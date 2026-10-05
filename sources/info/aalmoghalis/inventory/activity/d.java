package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0605Iq;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC1794bT;
import defpackage.AbstractC2242g10;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4032uI;
import defpackage.AbstractC4158vt;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0917Sq;
import defpackage.C1044Xj;
import defpackage.C1815bh;
import defpackage.C1839c10;
import defpackage.C1896ch;
import defpackage.C2160f10;
import defpackage.C3819rg;
import defpackage.C3874sM;
import defpackage.C3981tg;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Q00;
import defpackage.RunnableC1171Zj;
import defpackage.SC;
import defpackage.V50;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.d;
import info.aalmoghalis.inventory.fcm.online_status;
import info.aalmoghalis.inventory.old.BranchList_edit;
import info.aalmoghalis.inventory.old.CurrList_edit;
import info.aalmoghalis.inventory.old.CusLimit_edit;
import info.aalmoghalis.inventory.old.Reminders;
import info.aalmoghalis.inventory.old.Unit_item_edit;
import info.aalmoghalis.inventory.threads.HelloService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class d extends Fragment {
    public C3819rg A;
    public String[] B;
    public TypedArray C;
    public List D;
    public C3981tg E;
    public ImageView K;
    public ImageView L;
    public ImageView M;
    public ImageView N;
    public ImageView O;
    public Boolean S;
    public Boolean T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a0;
    public String b0;
    public Context c0;
    public boolean d0;
    public View e0;
    public Activity f0;
    public o g;
    public int g0;
    public SQLiteDatabase h;
    public ArrayList h0;
    public Z00 i;
    public LinearLayout i0;
    public FloatingActionButton j0;
    public ExpandableListView.OnChildClickListener k0;
    public ExpandableListView.OnGroupClickListener l0;
    public Dialog m0;
    public TextView n0;
    public Handler o0;
    public String p;
    public boolean p0;
    public String q;
    public String q0;
    public View.OnClickListener r0;
    public EditText s0;
    public String t;
    public String t0;
    public ExpandableListView u;
    public ArrayList u0;
    public SC v;
    public Bundle v0;
    public ShareActionProvider w0;
    public String[] x;
    public boolean x0;
    public TypedArray y;
    public Snackbar y0;
    public List z;
    public static ArrayList z0 = new ArrayList();
    public static int A0 = -1;
    public static int B0 = 0;
    public EditText j = null;
    public EditText k = null;
    public Button l = null;
    public int n = 0;
    public GridView w = null;
    public TextView F = null;
    public ArrayList G = new ArrayList();
    public ArrayList H = new ArrayList();
    public ActionBar I = null;
    public TextView J = null;
    public int[] P = {R.drawable.up, 1, R.drawable.down};
    public String[] Q = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public boolean R = false;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            d.this.k();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Handler a;

        public b(Handler handler) {
            this.a = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = d.this;
                dVar.p0 = false;
                dVar.q0 = "";
                int iZ = dVar.i.Z(this.a, dVar.n0);
                if (iZ == 1) {
                    d.this.p0 = true;
                } else {
                    d.this.q0 = "Error:" + iZ + ":" + Z00.n0;
                }
            } catch (Exception e) {
                d dVar2 = d.this;
                dVar2.p0 = false;
                dVar2.q0 = "Error:" + e.getMessage();
                e.printStackTrace();
            }
            Message message = new Message();
            d dVar3 = d.this;
            if (dVar3.p0) {
                message.obj = "0";
            } else {
                message.obj = "-1";
            }
            dVar3.o0.sendMessage(message);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_help) {
                d.this.help_btn(view);
                return;
            }
            if (view.getId() == R.id.img_add_amount) {
                d.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_move_tr) {
                d.this.move_tr_btn(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                d.this.g.onButtonClicked(view);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.d$d, reason: collision with other inner class name */
    public class C0301d implements ExpandableListView.OnGroupExpandListener {
        public int a = -1;

        public C0301d() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            if (i != this.a) {
                d.A0 = -1;
            }
            this.a = i;
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.i.Lc("reminders_check_date_h", this.a);
            d.this.y0.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.startActivity(new Intent(d.this.getActivity(), (Class<?>) Reminders.class));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.y0.dismiss();
        }
    }

    public class h implements ViewTreeObserver.OnGlobalLayoutListener {
        public h() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d dVar = d.this;
            if (dVar.d0) {
                return;
            }
            dVar.d0 = true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            int i2;
            String str;
            int i3;
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (!d.this.p.equals("0") && (C2160f10.h <= 0 || d.this.p.equals("0"))) {
                if (i == 0 || i == 1) {
                    Bill_edit.P2 = false;
                    Intent intent = new Intent(d.this.getActivity(), (Class<?>) (i != 2 ? Bills2.class : Moves2.class));
                    if (i == 0) {
                        i3 = 2;
                    } else if (i == 1) {
                        i3 = 1;
                    } else {
                        i3 = i == 2 ? 3 : 0;
                    }
                    intent.putExtra("TR_TYPE", String.valueOf(i3));
                    intent.putExtra("g_id", d.this.p);
                    intent.putExtra("g_name", d.this.q);
                    intent.putExtra("title_", textView.getText());
                    d.this.startActivity(intent);
                }
                if (i == 2) {
                    d dVar = d.this;
                    Z00 z00 = dVar.i;
                    FragmentActivity activity = dVar.getActivity();
                    d dVar2 = d.this;
                    z00.y(activity, dVar2.p, dVar2.q, true);
                }
                if (i == 3) {
                    d.this.i.Mc("recreate_items_cost_calc", false);
                    Intent intent2 = new Intent(d.this.getActivity(), (Class<?>) Frag_Report3_item_balance.class);
                    intent2.putExtra("g_id", d.this.p);
                    intent2.putExtra("g_name", d.this.q);
                    intent2.putExtra("title_", textView.getText());
                    d.this.startActivity(intent2);
                    return;
                }
                if (i == 5) {
                    d.this.i.Mc("recreate_items_cost_calc", false);
                    Intent intent3 = new Intent(d.this.getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                    intent3.putExtra("screen_no", "1");
                    intent3.putExtra("g_id", d.this.p);
                    intent3.putExtra("g_name", d.this.q);
                    intent3.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    d.this.startActivity(intent3);
                    return;
                }
                if (i == 4) {
                    Intent intent4 = new Intent(d.this.getActivity(), (Class<?>) Revenue_item_Report.class);
                    intent4.putExtra("g_id", d.this.p);
                    intent4.putExtra("g_name", d.this.q);
                    intent4.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent4.putExtra("TR_TYPE", String.valueOf(i));
                    d.this.startActivity(intent4);
                    return;
                }
                return;
            }
            if (i == 7) {
                d.this.i.Mc("recreate_items_cost_calc", false);
                Intent intent5 = new Intent(d.this.getActivity(), (Class<?>) Frag_Report3_item_balance.class);
                intent5.putExtra("g_id", d.this.p);
                intent5.putExtra("g_name", d.this.q);
                intent5.putExtra("title_", textView.getText());
                d.this.startActivity(intent5);
                return;
            }
            if (i == 2) {
                if (C2160f10.h > 0 && !new C2160f10(d.this.i).l("-9", "view")) {
                    Toast.makeText(d.this.getActivity(), d.this.getActivity().getString(R.string.no_priv), 0).show();
                    return;
                }
                FragmentStatePagerSupport_Main.a0 = false;
                Intent intent6 = new Intent(d.this.getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                intent6.putExtra("screen_no", "2");
                intent6.putExtra("g_id", d.this.p);
                intent6.putExtra("g_name", d.this.q);
                intent6.putExtra("title_", textView.getText());
                d.this.q();
                intent6.putExtras(d.this.v0);
                if (d.this.H.size() == 0) {
                    d.this.i();
                    return;
                } else {
                    d.this.startActivity(intent6);
                    return;
                }
            }
            if (i == 8) {
                Intent intent7 = new Intent(d.this.getActivity(), (Class<?>) Action_list.class);
                intent7.putExtra("action_id", 3);
                intent7.putExtra("action_text", textView.getText());
                intent7.putExtra("g_id", d.this.p);
                intent7.putExtra("g_name", d.this.q);
                d.this.startActivity(intent7);
                return;
            }
            if (i == 1 || i == 3) {
                Bill_edit.P2 = false;
                Intent intent8 = new Intent(d.this.getActivity(), (Class<?>) (i != 5 ? Bills2.class : Moves2.class));
                if (i == 3) {
                    i2 = 2;
                } else if (i == 1) {
                    i2 = 1;
                } else {
                    i2 = i == 5 ? 3 : 0;
                }
                Bills2.w0 = 0;
                intent8.putExtra("TR_TYPE", String.valueOf(i2));
                intent8.putExtra("g_id", d.this.p);
                intent8.putExtra("g_name", d.this.q);
                intent8.putExtra("title_", textView.getText());
                if (i2 == 1) {
                    str = "-6";
                } else if (i2 == 2) {
                    str = "-7";
                } else {
                    str = i2 == 3 ? "6" : "-6";
                }
                if (C2160f10.h <= 0 || new C2160f10(d.this.i).l(str, "view")) {
                    d.this.startActivity(intent8);
                    return;
                } else {
                    Toast.makeText(d.this.getActivity(), d.this.getActivity().getString(R.string.no_priv), 0).show();
                    return;
                }
            }
            if (i == 5) {
                d dVar3 = d.this;
                Z00 z01 = dVar3.i;
                FragmentActivity activity2 = dVar3.getActivity();
                d dVar4 = d.this;
                z01.y(activity2, dVar4.p, dVar4.q, true);
                return;
            }
            if (i == 4) {
                Intent intent9 = new Intent(d.this.getActivity(), (Class<?>) Info_edit3.class);
                intent9.putExtra("action_type", 1);
                intent9.putExtra("action_text", textView.getText().toString());
                d.this.startActivity(intent9);
                return;
            }
            if (i == 6) {
                Intent intent10 = new Intent(d.this.getActivity(), (Class<?>) item_price_exp.class);
                intent10.putExtra("action_id", 2);
                intent10.putExtra("action_text", textView.getText());
                d.this.startActivity(intent10);
                return;
            }
            if (i != 0) {
                if (i == 2) {
                    d.this.startActivity(new Intent(d.this.getActivity(), (Class<?>) Customer_Det_List_edit3.class));
                }
            } else {
                if (C2160f10.h > 0 && !new C2160f10(d.this.i).l("-8", "view")) {
                    Toast.makeText(d.this.getActivity(), d.this.getActivity().getString(R.string.no_priv), 0).show();
                    return;
                }
                Intent intent11 = new Intent(d.this.getActivity(), (Class<?>) Daily_Doc_Report.class);
                intent11.putExtra("g_id", C2160f10.j + "");
                intent11.putExtra("g_name", d.this.q);
                intent11.putExtra("title_", d.this.getResources().getStringArray(R.array.titles4)[0].toString().replaceAll("تقرير -", ""));
                Z00.y0 = false;
                d.this.startActivity(intent11);
            }
        }
    }

    public class j implements ExpandableListView.OnChildClickListener {
        public j() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            C1815bh c1815bh = (C1815bh) ((C1896ch) d.this.v.b.get(i)).e().get(i2);
            d.A0 = i;
            d.B0 = (int) d.this.u.getSelectedPosition();
            d.this.t(Integer.parseInt(c1815bh.c()), c1815bh.e());
            return false;
        }
    }

    public class k implements ExpandableListView.OnGroupClickListener {
        public k() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            C1896ch c1896ch = (C1896ch) d.this.v.b.get(i);
            if (d.z0.size() == 0) {
                d.this.s();
            }
            ((C1896ch) d.this.v.b.get(i)).m(d.this.r(c1896ch.i()));
            d.this.v.notifyDataSetChanged();
            return false;
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ boolean a;

        public l(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.i.bc(this.a);
            new C2160f10(d.this.i).W(d.this.i.Z4());
            Message message = new Message();
            message.obj = "1";
            d.this.o0.sendMessage(message);
        }
    }

    public class m extends Handler {
        public m() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                d dVar = d.this;
                if (dVar.p0) {
                    dVar.u.collapseGroup(1);
                    Toast.makeText(d.this.getContext(), d.this.getActivity().getString(R.string.done), 0).show();
                } else {
                    Toast.makeText(dVar.getContext(), d.this.q0 + "", 0).show();
                }
            } else if (message.obj.toString().equals("1")) {
                d.this.j();
            } else if (message.obj.toString().equals("-1")) {
                Toast.makeText(d.this.getContext(), d.this.q0 + "", 0).show();
            }
            d.this.z(false);
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public interface o {
        void onButtonClicked(View view);
    }

    public d() {
        Boolean bool = Boolean.FALSE;
        this.S = bool;
        this.T = bool;
        this.d0 = false;
        this.e0 = null;
        this.g0 = -1;
        this.h0 = new ArrayList();
        this.i0 = null;
        this.j0 = null;
        this.k0 = new j();
        this.l0 = new k();
        this.m0 = null;
        this.n0 = null;
        this.o0 = new m();
        this.p0 = false;
        this.q0 = "";
        this.r0 = new c();
        this.t0 = "";
        this.u0 = new ArrayList();
        this.x0 = true;
    }

    private void l() {
        if (this.p.equals("0") || C2160f10.h >= 0) {
            try {
                n(this.i.q8("0"));
                if (Build.VERSION.SDK_INT >= 23) {
                    this.i.Ud();
                } else {
                    getActivity().startService(new Intent(getActivity(), (Class<?>) HelloService.class));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.i.ia("online_date_done", ""));
                sb.append(":");
                sb.append(this.i.S());
                sb.append(":");
                sb.append(FragmentStatePagerSupport_Main.S == null ? "Null" : "NotNull");
                Log.d("fire_chk=", sb.toString());
                if (AbstractC4158vt.a(getActivity()) && this.i.S()) {
                    int iR3 = this.i.r3();
                    this.i.o3();
                    int i2 = Integer.parseInt(this.i.ia("nodejs_date", "0"));
                    Integer.parseInt(this.i.ia("nodejs_hr", "0"));
                    Log.d("nodejs_date=", iR3 + ":" + i2);
                }
            } catch (Exception unused) {
            }
            try {
                A();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Calendar.getInstance().get(14);
    }

    public static /* synthetic */ void v(Integer num) {
    }

    public static d w(C0917Sq c0917Sq, int i2, int i3, String str, String str2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putInt(CSS.Property.POSITION, i2);
        bundle.putInt("size", i3);
        bundle.putString("g_name", str);
        bundle.putString("curr_name", str2);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void A() {
        try {
            Log.d("show_remin", "show_snackbar_reminder");
            Calendar calendar = Calendar.getInstance();
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy H", locale);
            String str = simpleDateFormat.format(calendar.getTime());
            new SimpleDateFormat("dd-MM-yyyy", locale);
            simpleDateFormat.format(calendar.getTime());
            if (this.y0 == null && getActivity() != null) {
                this.y0 = Snackbar.make(this.u, "", -2);
            }
            TextView textView = (TextView) ((Snackbar.SnackbarLayout) this.y0.getView()).findViewById(R.id.snackbar_text);
            int size = this.i.N4().size();
            if (size != 0 && !this.i.ja("prefOthers_reminders", false)) {
                this.y0.setText(size + " " + getString(R.string.reminders_cnt));
                this.y0.setAction(R.string.hide_tr, new e(str));
                textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getActivity(), R.drawable.ic_notification), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setOnClickListener(new f());
                ViewCompat.setLayoutDirection(this.y0.getView(), 1);
                this.y0.show();
                new Handler().postDelayed(new g(), 5000);
                y(size + "");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void B(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.google.android.youtube");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str));
            startActivity(intent2);
        }
    }

    public void amount_add_btn(View view) {
        if (!this.p.equals("0") || C2160f10.h >= 0) {
            Bill_edit.P2 = true;
            this.i.z(getActivity(), this.p, this.q);
            return;
        }
        try {
            Intent intent = new Intent(view.getContext(), (Class<?>) Daily_Curr_Report.class);
            intent.putExtra("g_id", this.p);
            intent.putExtra("g_name", this.q);
            intent.putExtra("title_", getActivity().getString(R.string.add_curr_sales));
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void help_btn(View view) {
        try {
            if (this.i.S()) {
                startActivity(new Intent(getActivity(), (Class<?>) online_status.class));
            } else {
                B("https://www.youtube.com/channel/UCeoaICkhfb4M7t7atseyqIA");
            }
        } catch (Exception e2) {
            Log.d("youtune_err", e2.getMessage() + "");
            e2.printStackTrace();
        }
    }

    public void i() {
        try {
            startActivity(new Intent(getActivity(), (Class<?>) Customer_Det_List_edit3.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j() {
        String str;
        if (this.i.ja("prefOthers_item_end_date", false)) {
            this.i.v0("update sys_conf set value_='1' where id=10");
        } else {
            this.i.v0("update sys_conf set value_='0' where id=10");
        }
        int iU2 = this.i.U2();
        if (iU2 > 0) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.alarm_curr_price) + ":" + iU2, 1).show();
            return;
        }
        if (this.i.w6() > 0) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.alarm_item_negative), 1).show();
            return;
        }
        if (this.i.D6() > 0) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.alarm_item_negative_cost), 1).show();
            String strX4 = this.i.X4("select ifnull(group_concat(item_name,' , '),'') as _id\n from(\n select    DISTINCT((select name from items where id=a.item_id) ) item_name from items_cost_calc a \n                 where date(a.date_)<=date('now','localtime','start of year','-1 day')\n\t\t\t\t    and (date(strftime('%Y-%m-%d',date_ )) != \n                         (select ifnull(max(closing_year.date_),date(a.date_,'-1 day')) \n                         from closing_year))  and (round(a.n_u,7)<0 or round(a.i_u,7)<0 or round(a.o_u,7)<0 ) \t\t\t\t\t\t )");
            if (strX4.length() > 0) {
                C1839c10.D(this.i, getActivity(), strX4, "", true, null);
                return;
            }
            return;
        }
        double dJ = new C2160f10(this.i).J(CSS.Value.PERCENTAGE, this.i.Z4());
        if (dJ > 1.0d || dJ < -1.0d) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.alarm_diff_trail_bal) + ":" + dJ, 1).show();
            if (new C1839c10(getActivity()).f(this.i)) {
                new C1839c10(getActivity()).G();
                return;
            } else {
                if (new C1839c10(getActivity()).e(this.i)) {
                    new C1839c10(getActivity()).F();
                    return;
                }
                return;
            }
        }
        int iD = C1839c10.d(this.i, true, "bill_total_check_date");
        if (iD > 0) {
            String strX5 = this.i.X4("select group_concat(type_||'{'||bill_no2||'} ',' , ') as _id from bills_tot_issue");
            FragmentActivity activity = getActivity();
            StringBuilder sb = new StringBuilder();
            sb.append(getActivity().getString(R.string.alarm_diff_bills_tot));
            sb.append(":");
            sb.append(this.i.O7(iD));
            if (iD <= 2) {
                str = ":" + strX5;
            } else {
                str = "";
            }
            sb.append(str);
            Toast.makeText(activity, sb.toString(), 1).show();
            this.i.Lc("bill_total_check_date", "");
            return;
        }
        if (this.i.O2() > 0) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.alreay_closed), 1).show();
            return;
        }
        if (this.i.S()) {
            if (!Q00.E(this.i)) {
                Toast.makeText(getActivity(), "Not Allowed:try to refresh", 1).show();
                return;
            } else if (Integer.parseInt(this.i.X4("select count(*) as _id from table_action")) > 0) {
                Toast.makeText(getActivity(), "Not Allowed2:try to refresh", 1).show();
                return;
            } else {
                AbstractC1794bT.c(getActivity());
                AbstractC1794bT.b();
            }
        }
        String str2 = new SimpleDateFormat("yyyyMMddkkmmss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        AbstractC2242g10.c(getActivity(), "inv.db", "yearly-" + str2 + "-inv.db", "info.aalmoghalis.inventory");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.closing_year_hdr) + this.i.Z4());
        builder.setMessage(getString(R.string.closing_year_desc));
        builder.setCancelable(true).setPositiveButton(getString(R.string.closing_year), new a()).setNegativeButton(getString(R.string.btn_cancel), new n());
        builder.create().show();
    }

    public void k() {
        z(true);
        new Thread(new b(new Handler(Looper.getMainLooper()))).start();
    }

    public void m() {
        TelephonyManager telephonyManager = (TelephonyManager) getActivity().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        try {
            String strSubstring = telephonyManager.getDeviceId().substring(0, 14);
            Z00.R = strSubstring;
            Z00.S = AbstractC4032uI.b(strSubstring);
            if (this.i.p3().equals("")) {
                return;
            }
            if (!this.i.p3().equals(Z00.R) && Build.VERSION.SDK_INT >= 23) {
                if (telephonyManager.getPhoneCount() != 2) {
                    return;
                }
                if (this.i.P(telephonyManager.getDeviceId(0).substring(0, 14))) {
                    String strSubstring2 = telephonyManager.getDeviceId(0).substring(0, 14);
                    Z00.R = strSubstring2;
                    Z00.S = AbstractC4032uI.b(strSubstring2);
                } else if (this.i.P(telephonyManager.getDeviceId(1).substring(0, 14))) {
                    String strSubstring3 = telephonyManager.getDeviceId(1).substring(0, 14);
                    Z00.R = strSubstring3;
                    Z00.S = AbstractC4032uI.b(strSubstring3);
                }
            }
            String str = Z00.R;
            if (str == null || str.equals("")) {
                Z00.R = Build.SERIAL;
            }
        } catch (Exception unused) {
        }
    }

    public void move_tr_btn(View view) {
        try {
            Intent intent = new Intent(view.getContext(), (Class<?>) Daily_Trans_Report.class);
            intent.putExtra("g_id", this.p);
            intent.putExtra("g_name", this.q);
            intent.putExtra("title_", getActivity().getString(R.string.add_tr_account));
            Z00.w0 = false;
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void n(Cursor cursor) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(isResumed());
            sb.append(":");
            sb.append(this.v == null ? "Ad_NULL" : "Ad_Not_NULL");
            Log.d("c.getCount()=", sb.toString());
            this.G.clear();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                this.G.add(new C1896ch(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("name")), "", "0", 0, "", ""));
                cursor.moveToNext();
            }
            cursor.close();
            SC sc = new SC(getActivity(), this.G, 1);
            this.v = sc;
            this.u.setAdapter(sc);
        } catch (Exception unused) {
        }
    }

    public void o() {
        Cursor cursorS4 = this.i.s4();
        Z00.i0.clear();
        cursorS4.moveToFirst();
        while (!cursorS4.isAfterLast()) {
            Z00.i0.add(new C4145vh(cursorS4.getString(cursorS4.getColumnIndex("_id")), cursorS4.getString(cursorS4.getColumnIndex("f1")), cursorS4.getString(cursorS4.getColumnIndex("f2")), cursorS4.getString(cursorS4.getColumnIndex("f3")), cursorS4.getString(cursorS4.getColumnIndex("f4")), cursorS4.getString(cursorS4.getColumnIndex("f5")), "", "", ""));
            cursorS4.moveToNext();
        }
        cursorS4.close();
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
                    this.s0.setText(string);
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
        this.f0 = activity;
        try {
            this.g = (o) activity;
        } catch (ClassCastException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = getArguments() != null ? getArguments().getString("cus_id") : "";
        this.q = getArguments() != null ? getArguments().getString("g_name") : "";
        this.t = getArguments() != null ? getArguments().getString("curr_name") : "";
        this.i = new Z00(this.h, getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Log.d("Oncreate:", "Menu_Create");
        menu.clear();
        menuInflater.inflate(R.menu.menu_main, menu);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
        this.w0 = shareActionProvider;
        shareActionProvider.setShareIntent(this.i.S9(getActivity().getString(R.string.share_content)));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.e0 = layoutInflater.inflate(R.layout.content_customer_main4, viewGroup, false);
            this.i = new Z00(this.h, getActivity());
            this.f0 = getActivity();
            setHasOptionsMenu(true);
            Log.d("On CreateView=", this.p + ":" + this.T + ":" + this.S);
            this.i0 = (LinearLayout) this.e0.findViewById(R.id.main_row_2);
            TextView textView = (TextView) this.e0.findViewById(R.id.footer_sum);
            this.J = textView;
            textView.setText(this.q);
            this.U = getActivity().getString(R.string.footer_null);
            this.V = getActivity().getString(R.string.footer_cus_null);
            this.W = getActivity().getString(R.string.footer_out);
            this.X = getActivity().getString(R.string.footer_in);
            this.Z = getActivity().getString(R.string.footer_filter);
            this.Y = getActivity().getString(R.string.tr_bal);
            this.a0 = getActivity().getString(R.string.tot_radio1);
            this.b0 = getActivity().getString(R.string.tot_radio2);
            this.w = (GridView) this.e0.findViewById(R.id.gridview);
            ExpandableListView expandableListView = (ExpandableListView) this.e0.findViewById(R.id.list_report);
            this.u = expandableListView;
            expandableListView.setOnChildClickListener(this.k0);
            this.u.setOnGroupClickListener(this.l0);
            this.u.setOnGroupExpandListener(new C0301d());
            n(this.i.q8("0"));
            if (this.p.equals("0") || C2160f10.h > 0) {
                this.i0.setVisibility(0);
                this.x = getActivity().getResources().getStringArray(R.array.titles4);
                this.y = getActivity().getResources().obtainTypedArray(R.array.icons4);
            } else {
                this.i0.setVisibility(8);
                this.x = getActivity().getResources().getStringArray(R.array.titles4_);
                this.y = getActivity().getResources().obtainTypedArray(R.array.icons4_);
            }
            this.z = new ArrayList();
            int i2 = 0;
            while (true) {
                String[] strArr = this.x;
                if (i2 >= strArr.length) {
                    break;
                }
                this.z.add(new C3874sM(strArr[i2], this.y.getResourceId(i2, -1)));
                i2++;
            }
            this.y.recycle();
            C3819rg c3819rg = new C3819rg(getActivity(), this.z, this.p, this.q, this.i);
            this.A = c3819rg;
            this.w.setAdapter((ListAdapter) c3819rg);
            this.w.getViewTreeObserver().addOnGlobalLayoutListener(new h());
            this.w.setOnItemClickListener(new i());
            if (this.p.equals("0")) {
                this.B = getResources().getStringArray(R.array.titles3_main);
                this.C = getResources().obtainTypedArray(R.array.icons3_main);
            } else {
                this.B = getResources().getStringArray(R.array.titles3_);
                this.C = getResources().obtainTypedArray(R.array.icons3_);
            }
            this.D = new ArrayList();
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.B;
                if (i3 >= strArr2.length) {
                    break;
                }
                this.D.add(new C3874sM(strArr2[i3], this.C.getResourceId(i3, -1)));
                i3++;
            }
            this.C.recycle();
            this.E = new C3981tg(getActivity(), this.D);
            this.K = (ImageView) this.e0.findViewById(R.id.img_help);
            this.L = (ImageView) this.e0.findViewById(R.id.img_move_tr);
            this.M = (ImageView) this.e0.findViewById(R.id.move_right);
            this.N = (ImageView) this.e0.findViewById(R.id.move_left);
            this.K.setOnClickListener(this.r0);
            this.L.setOnClickListener(this.r0);
            this.M.setOnClickListener(this.r0);
            this.N.setOnClickListener(this.r0);
            this.O = (ImageView) this.e0.findViewById(R.id.img_add_amount);
            if (this.p.equals("0")) {
                this.O.setImageResource(R.drawable.s_currency4);
            } else {
                this.O.setImageResource(R.drawable.add2);
            }
            if (this.i.S()) {
                this.K.setImageResource(R.drawable.s_node);
            }
            this.O.setOnClickListener(this.r0);
            if (this.p.equals("0") || C2160f10.h >= 0) {
                this.L.setVisibility(0);
                if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "view")) {
                    this.L.setVisibility(4);
                }
            } else {
                this.L.setVisibility(8);
                this.O.setVisibility(0);
            }
            if (FragmentStatePagerSupport_Main.X <= 1) {
                this.M.setVisibility(8);
                this.N.setVisibility(8);
            }
            try {
                l();
                C0372Bn.e.a(getActivity(), this.J);
            } catch (Exception unused) {
            }
            return this.e0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("OnCreate:", "DestroyView:" + this.p);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Log.d("Oncreate:", "onDetach");
        this.f0 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.notification) {
            startActivity(new Intent(getActivity(), (Class<?>) Reminders.class));
            return true;
        }
        if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        try {
            MenuItem menuItemFindItem = menu.findItem(R.id.notification);
            if (this.i.N4().size() > 0) {
                menuItemFindItem.setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_notification));
            } else {
                menuItemFindItem.setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_notification2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                m();
                return;
            }
            return;
        }
        if (i2 == 112 && iArr.length == 1) {
            int i3 = iArr[0];
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.S = Boolean.TRUE;
        Log.d("OnCreate:", "Start:" + this.p + ":" + this.T + ":" + this.S);
        if (this.T.booleanValue() && this.S.booleanValue()) {
            this.c0 = getActivity();
        }
    }

    public void p() {
        Cursor cursorW5 = this.i.W5();
        this.H.clear();
        cursorW5.moveToFirst();
        while (!cursorW5.isAfterLast()) {
            this.H.add(new C0917Sq(cursorW5.getString(cursorW5.getColumnIndex("_id")), cursorW5.getString(cursorW5.getColumnIndex("g_name")), "", cursorW5.getString(cursorW5.getColumnIndex("cus_type"))));
            cursorW5.moveToNext();
        }
        cursorW5.close();
        Bundle bundle = new Bundle();
        this.v0 = bundle;
        bundle.putSerializable("dataGroups", this.H);
    }

    public void q() {
        Log.d("trace_S_group_type=", FragmentStatePagerSupport_Main.X());
        this.i.L1();
        Cursor cursorN4 = this.i.n4(false);
        Log.d("recCount_Det=", cursorN4.getCount() + "");
        this.H.clear();
        cursorN4.moveToFirst();
        while (!cursorN4.isAfterLast()) {
            this.H.add(new C0917Sq(cursorN4.getString(cursorN4.getColumnIndex("_id")), cursorN4.getString(cursorN4.getColumnIndex("g_name")), cursorN4.getString(cursorN4.getColumnIndex("curr_name")), cursorN4.getString(cursorN4.getColumnIndex("cus_type"))));
            cursorN4.moveToNext();
        }
        cursorN4.close();
        Bundle bundle = new Bundle();
        this.v0 = bundle;
        bundle.putSerializable("dataGroups", this.H);
        Log.d("trace_E_group_type=", FragmentStatePagerSupport_Main.X());
    }

    public ArrayList r(String str) {
        ArrayList arrayList = new ArrayList();
        Log.d("trace_S_rep_click=", str);
        for (C1815bh c1815bh : z0) {
            if (str.equals(c1815bh.b())) {
                arrayList.add(c1815bh);
            }
        }
        Log.d("trace_E_rep_click=", str + ":" + FragmentStatePagerSupport_Main.X());
        return arrayList;
    }

    public void s() {
        Cursor cursorQ8 = this.i.q8("-1");
        C0566Hd c0566Hd = new C0566Hd();
        cursorQ8.moveToFirst();
        while (!cursorQ8.isAfterLast()) {
            z0.add(new C1815bh(cursorQ8.getString(c0566Hd.b(cursorQ8, "_id")), cursorQ8.getString(c0566Hd.b(cursorQ8, "name")), "", 0.0d, 0, 0, cursorQ8.getString(c0566Hd.b(cursorQ8, "p_id"))));
            cursorQ8.moveToNext();
        }
        c0566Hd.a();
        cursorQ8.close();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.p != null && isResumed()) {
            l();
        }
    }

    /* JADX WARN: Code duplicated, block: B:122:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:124:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:125:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:127:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:128:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:130:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:131:0x0515  */
    /* JADX WARN: Code duplicated, block: B:133:0x0519  */
    /* JADX WARN: Code duplicated, block: B:135:0x0486 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    public void t(int i2, String str) {
        String str2;
        if (C2160f10.h != -1) {
            this.p = C2160f10.i + "";
            this.q = this.i.C2(C2160f10.i + "");
        }
        if (i2 != -2) {
            if (i2 == -3) {
                Intent intent = new Intent(getActivity(), (Class<?>) Adj2.class);
                intent.putExtra("TR_TYPE", "11");
                intent.putExtra("g_id", this.p);
                intent.putExtra("g_name", this.q);
                startActivity(intent);
            } else {
                if (i2 == 6) {
                    if (C2160f10.h > 0 && !new C2160f10(this.i).l("6", "view")) {
                        Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
                        return;
                    }
                    Intent intent2 = new Intent(getActivity(), (Class<?>) Moves2.class);
                    intent2.putExtra("TR_TYPE", "3");
                    intent2.putExtra("g_id", this.p);
                    intent2.putExtra("g_name", this.q);
                    startActivity(intent2);
                } else if (i2 == 7) {
                    if (C2160f10.h > 0 && !new C2160f10(this.i).l("7", "view")) {
                        Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
                        return;
                    }
                    Intent intent3 = new Intent(getActivity(), (Class<?>) Moves2.class);
                    Moves2.V = 0;
                    intent3.putExtra("TR_TYPE", "4");
                    intent3.putExtra("g_id", this.p);
                    intent3.putExtra("g_name", this.q);
                    startActivity(intent3);
                } else if (i2 == 28) {
                    if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "view")) {
                        Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
                        return;
                    }
                    Intent intent4 = new Intent(getActivity(), (Class<?>) Invs3.class);
                    Invs3.V = 0;
                    intent4.putExtra("TR_TYPE", "7");
                    intent4.putExtra("g_id", this.p);
                    intent4.putExtra("g_name", this.q);
                    startActivity(intent4);
                } else if (i2 == 29) {
                    Intent intent5 = new Intent(getActivity(), (Class<?>) Offers.class);
                    Invs3.V = 0;
                    intent5.putExtra("TR_TYPE", "8");
                    intent5.putExtra("g_id", this.p);
                    intent5.putExtra("g_name", this.q);
                    startActivity(intent5);
                } else if (i2 == 30) {
                    Intent intent6 = new Intent(getActivity(), (Class<?>) Orders.class);
                    Invs3.V = 0;
                    intent6.putExtra("TR_TYPE", "9");
                    intent6.putExtra("g_id", this.p);
                    intent6.putExtra("g_name", this.q);
                    startActivity(intent6);
                } else if (i2 == 8) {
                    startActivity(new Intent(getActivity(), (Class<?>) BranchList_edit.class));
                } else if (i2 == 9) {
                    if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
                        Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
                        return;
                    }
                    Intent intent7 = new Intent(getActivity(), (Class<?>) Customer_Det_List_edit4.class);
                    intent7.putExtra("g_id", this.p);
                    intent7.putExtra("g_name", this.q);
                    getActivity().getResources().getStringArray(R.array.action_3)[5].toString();
                    startActivity(intent7);
                } else if (i2 == 10) {
                    if (C2160f10.h > 0 && !new C2160f10(this.i).l("10", "new")) {
                        Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
                        return;
                    }
                    startActivity(new Intent(getActivity(), (Class<?>) Customer_Det_List_edit3.class));
                } else if (i2 == 11) {
                    try {
                        Intent intent8 = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                        intent8.putExtra("title_", str);
                        intent8.putExtra("screen_no", "9");
                        p();
                        intent8.putExtras(this.v0);
                        o();
                        startActivity(intent8);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (i2 == 12) {
                    Intent intent9 = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                    C4143vg c4143vgB3 = this.i.B3();
                    intent9.putExtra("screen_no", "11");
                    intent9.putExtra("CUS_ID", c4143vgB3.i());
                    intent9.putExtra("CUS_BAL", "0");
                    intent9.putExtra("CUS_GSM", c4143vgB3.h());
                    intent9.putExtra("CUS_NAME", c4143vgB3.j());
                    intent9.putExtra("g_id", this.p);
                    intent9.putExtra("g_name", this.q);
                    intent9.putExtra("title_", str);
                    intent9.putExtra("CURR_NAME", this.i.l3("0"));
                    intent9.putExtra("adv_search", 1);
                    this.i.v0("update sys_conf set value_='now' where id=2");
                    String strF5 = this.i.f5(0);
                    intent9.putExtra("f_date", strF5);
                    intent9.putExtra("t_date", strF5);
                    startActivity(intent9);
                } else if (i2 == 13) {
                    startActivity(new Intent(getActivity(), (Class<?>) Account_Tree_Main.class));
                } else if (i2 == 31) {
                    startActivity(new Intent(getActivity(), (Class<?>) CusLimit_edit.class));
                } else if (i2 == 32) {
                    Intent intent10 = new Intent(getActivity(), (Class<?>) Daily_Curr_Report.class);
                    intent10.putExtra("g_id", this.p);
                    intent10.putExtra("g_name", this.q);
                    intent10.putExtra("title_", getActivity().getString(R.string.add_curr_sales));
                    startActivity(intent10);
                } else if (i2 == 14) {
                    try {
                        x(false);
                        this.i.Mc("prefOthers_closed_year", false);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Toast.makeText(getContext(), "" + e3.getMessage(), 0).show();
                    }
                } else if (i2 == 15) {
                    Intent intent11 = new Intent(getActivity(), (Class<?>) Info_edit3.class);
                    intent11.putExtra("action_type", 1);
                    intent11.putExtra("action_text", str);
                    startActivity(intent11);
                } else if (i2 == 16) {
                    Intent intent12 = new Intent(getActivity(), (Class<?>) item_price_exp.class);
                    str2 = "action_id";
                    intent12.putExtra(str2, 2);
                    intent12.putExtra("action_text", str);
                    startActivity(intent12);
                } else {
                    str2 = "action_id";
                    if (i2 == 27) {
                        Intent intent13 = new Intent(getActivity(), (Class<?>) Unit_item_edit.class);
                        intent13.putExtra("g_id", this.p);
                        intent13.putExtra("g_name", this.q);
                        intent13.putExtra("title_", str);
                        startActivity(intent13);
                    } else if (i2 == 17 || i2 == 22) {
                        Intent intent14 = new Intent(getActivity(), (Class<?>) Frag_Report3_item_balance.class);
                        intent14.putExtra("g_id", this.p);
                        intent14.putExtra("g_name", this.q);
                        intent14.putExtra("title_", str);
                        startActivity(intent14);
                    } else if (i2 == 18) {
                        Intent intent15 = new Intent(getActivity(), (Class<?>) Revenue_item_Report.class);
                        intent15.putExtra("g_id", this.p);
                        intent15.putExtra("g_name", this.q);
                        intent15.putExtra("title_", str);
                        intent15.putExtra("TR_TYPE", "2");
                        startActivity(intent15);
                    } else if (i2 == 19) {
                        Intent intent16 = new Intent(getActivity(), (Class<?>) CurrList_edit.class);
                        intent16.putExtra("g_id", this.p);
                        intent16.putExtra("g_name", this.q);
                        intent16.putExtra("title_", str);
                        startActivity(intent16);
                    } else if (i2 == 20) {
                        Intent intent17 = new Intent(getActivity(), (Class<?>) currency_price_exp.class);
                        intent17.putExtra("g_id", this.p);
                        intent17.putExtra("g_name", this.q);
                        intent17.putExtra("title_", str);
                        startActivity(intent17);
                    }
                }
                str2 = "action_id";
            }
            if (i2 == 21) {
                try {
                    this.i.Mc("recreate_items_cost_calc", false);
                    Intent intent18 = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                    intent18.putExtra("screen_no", "1");
                    intent18.putExtra("g_id", this.p);
                    intent18.putExtra("g_name", this.q);
                    intent18.putExtra("title_", str);
                    startActivity(intent18);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (i2 == 23) {
                Intent intent19 = new Intent(getActivity(), (Class<?>) Trail_Balance_Report.class);
                intent19.putExtra("g_id", this.p);
                intent19.putExtra("g_name", this.q);
                intent19.putExtra("title_", str);
                startActivity(intent19);
                return;
            }
            if (i2 == 24) {
                Intent intent20 = new Intent(getActivity(), (Class<?>) Accounts_Total_Report.class);
                intent20.putExtra("g_id", this.p);
                intent20.putExtra("g_name", this.q);
                intent20.putExtra("title_", str);
                startActivity(intent20);
                return;
            }
            if (i2 == 25) {
                Intent intent21 = new Intent(getActivity(), (Class<?>) Balance_Sheet_Report.class);
                intent21.putExtra("g_id", this.p);
                intent21.putExtra("g_name", this.q);
                intent21.putExtra("title_", str);
                startActivity(intent21);
                return;
            }
            if (i2 == 26) {
                Intent intent22 = new Intent(getActivity(), (Class<?>) Action_list.class);
                intent22.putExtra(str2, 3);
                intent22.putExtra("action_text", str);
                intent22.putExtra("g_id", this.p);
                intent22.putExtra("g_name", this.q);
                startActivity(intent22);
                AbstractC3132jE.d(new Callable() { // from class: eo
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.u();
                    }
                }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: fo
                    @Override // defpackage.InterfaceC2295gf
                    public final void accept(Object obj) {
                        d.v((Integer) obj);
                    }
                });
            }
        }
        Intent intent23 = new Intent(getActivity(), (Class<?>) Adj2.class);
        intent23.putExtra("TR_TYPE", "21");
        intent23.putExtra("g_id", this.p);
        intent23.putExtra("g_name", this.q);
        startActivity(intent23);
        str2 = "action_id";
        if (i2 == 21) {
            this.i.Mc("recreate_items_cost_calc", false);
            Intent intent110 = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
            intent110.putExtra("screen_no", "1");
            intent110.putExtra("g_id", this.p);
            intent110.putExtra("g_name", this.q);
            intent110.putExtra("title_", str);
            startActivity(intent110);
            return;
        }
        if (i2 == 23) {
            Intent intent111 = new Intent(getActivity(), (Class<?>) Trail_Balance_Report.class);
            intent111.putExtra("g_id", this.p);
            intent111.putExtra("g_name", this.q);
            intent111.putExtra("title_", str);
            startActivity(intent111);
            return;
        }
        if (i2 == 24) {
            Intent intent24 = new Intent(getActivity(), (Class<?>) Accounts_Total_Report.class);
            intent24.putExtra("g_id", this.p);
            intent24.putExtra("g_name", this.q);
            intent24.putExtra("title_", str);
            startActivity(intent24);
            return;
        }
        if (i2 == 25) {
            Intent intent25 = new Intent(getActivity(), (Class<?>) Balance_Sheet_Report.class);
            intent25.putExtra("g_id", this.p);
            intent25.putExtra("g_name", this.q);
            intent25.putExtra("title_", str);
            startActivity(intent25);
            return;
        }
        if (i2 == 26) {
            Intent intent26 = new Intent(getActivity(), (Class<?>) Action_list.class);
            intent26.putExtra(str2, 3);
            intent26.putExtra("action_text", str);
            intent26.putExtra("g_id", this.p);
            intent26.putExtra("g_name", this.q);
            startActivity(intent26);
            AbstractC3132jE.d(new Callable() { // from class: eo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.u();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: fo
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    d.v((Integer) obj);
                }
            });
        }
    }

    public final /* synthetic */ Integer u() {
        C1044Xj.a().c(new RunnableC1171Zj(14, this.i, getActivity()));
        return 1;
    }

    public void x(boolean z) {
        z(true);
        new Thread(new l(z)).start();
    }

    public void y(String str) {
        try {
            Intent intent = new Intent(getActivity(), (Class<?>) Reminders.class);
            int i2 = Build.VERSION.SDK_INT;
            PendingIntent activity = i2 >= 31 ? PendingIntent.getActivity(getActivity(), 0, intent, 33554432) : PendingIntent.getActivity(getActivity(), 0, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService("notification");
            if (i2 >= 26) {
                V50.a();
                NotificationChannel notificationChannelA = AbstractC0605Iq.a("my_channel_id_01", "My Notifications", 3);
                notificationChannelA.setDescription(str + " " + getActivity().getString(R.string.reminders_cnt));
                notificationChannelA.enableLights(true);
                notificationChannelA.setLightColor(SupportMenu.CATEGORY_MASK);
                notificationChannelA.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                notificationChannelA.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannelA);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "my_channel_id_01");
            builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(getActivity().getString(R.string.app_name)).setSmallIcon(R.mipmap.ic_launcher).setContentText(str + " " + getActivity().getString(R.string.reminders_cnt));
            builder.setContentIntent(activity);
            builder.setAutoCancel(true);
            notificationManager.notify(R.mipmap.ic_launcher, builder.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void z(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null);
        this.n0 = (TextView) viewInflate.findViewById(R.id.loading_msg);
        builder.setView(viewInflate);
        if (z) {
            AlertDialog alertDialogCreate = builder.create();
            this.m0 = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.m0;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}
