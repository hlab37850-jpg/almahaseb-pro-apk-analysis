package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.timepicker.TimeModel;
import defpackage.C0917Sq;
import defpackage.C1044Xj;
import defpackage.C3874sM;
import defpackage.C4062ug;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.App;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Action_list extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public String[] Q;
    public TypedArray R;
    public List S;
    public C4062ug T;
    public Bundle U;
    public Bundle V;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public int p;
    public int q;
    public int t;
    public CharSequence u;
    public CharSequence v;
    public ListView w;
    public int n = 0;
    public ListView x = null;
    public Toolbar y = null;
    public TextView z = null;
    public TextView A = null;
    public List I = new ArrayList();
    public ImageButton J = null;
    public int K = 0;
    public String[] L = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] M = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public ArrayList N = new ArrayList();
    public int[] O = {R.drawable.up, 1, R.drawable.down};
    public ArrayList P = new ArrayList();
    public String W = "";
    public DatePickerDialog.OnDateSetListener X = new g();
    public DatePickerDialog.OnDateSetListener Y = new a();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Action_list.this.p = i;
            Action_list.this.q = i2;
            Action_list.this.t = i3;
            try {
                String str = Action_list.this.p + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Action_list.this.q + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Action_list.this.t));
                Locale locale = Locale.ENGLISH;
                Action_list.this.A.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Action_list.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            TextView textView = (TextView) view.findViewById(R.id.title);
            int i2 = this.a;
            if (i2 == 0) {
                if (i == 0 || i == 5) {
                    Intent intent = new Intent(Action_list.this, (Class<?>) Info_edit.class);
                    intent.putExtra("action_type", i);
                    intent.putExtra("action_text", textView.getText().toString());
                    Action_list.this.startActivity(intent);
                    return;
                }
                if (i == 2 || i == 3 || i == 4) {
                    Intent intent2 = new Intent(Action_list.this, (Class<?>) Info_edit2.class);
                    intent2.putExtra("action_type", i);
                    intent2.putExtra("action_text", textView.getText().toString());
                    Action_list.this.startActivity(intent2);
                    return;
                }
                if (i == 1) {
                    Intent intent3 = new Intent(Action_list.this, (Class<?>) Info_edit3.class);
                    intent3.putExtra("action_type", i);
                    intent3.putExtra("action_text", textView.getText().toString());
                    Action_list.this.startActivity(intent3);
                    return;
                }
                return;
            }
            if (i2 == 1) {
                if (i == 0 || i == 1 || i == 2) {
                    Intent intent4 = new Intent(Action_list.this, (Class<?>) (i != 2 ? Bill_edit.class : Bill_move.class));
                    intent4.putExtra("TR_TYPE", String.valueOf(i + 1));
                    intent4.putExtra("g_id", Action_list.this.j);
                    intent4.putExtra("g_name", Action_list.this.k);
                    Action_list.this.startActivity(intent4);
                    return;
                }
                return;
            }
            if (i2 == 3) {
                if (i == 0) {
                    try {
                        Intent intent5 = new Intent(Action_list.this, (Class<?>) Frag_Report3_item_balance.class);
                        intent5.putExtra("g_id", Action_list.this.j);
                        intent5.putExtra("g_name", Action_list.this.k);
                        intent5.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                        Action_list.this.startActivity(intent5);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (i == 1) {
                    try {
                        Intent intent6 = new Intent(Action_list.this, (Class<?>) FragmentStatePagerSupport.class);
                        intent6.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                        intent6.putExtra("screen_no", "8");
                        intent6.putExtra("g_id", Action_list.this.j);
                        intent6.putExtra("g_name", Action_list.this.k);
                        Action_list.this.O();
                        intent6.putExtras(Action_list.this.U);
                        Action_list action_list = Action_list.this;
                        C1044Xj.a().c(new RunnableC1171Zj(12, action_list.i, action_list));
                        Action_list.this.startActivity(intent6);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (i == 2) {
                    Intent intent7 = new Intent(Action_list.this, (Class<?>) Revenue_item_Report.class);
                    intent7.putExtra("g_id", Action_list.this.j);
                    intent7.putExtra("g_name", Action_list.this.k);
                    intent7.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent7.putExtra("TR_TYPE", String.valueOf(i));
                    Action_list.this.startActivity(intent7);
                    return;
                }
                if (i == 3) {
                    Intent intent8 = new Intent(Action_list.this, (Class<?>) FragmentStatePagerSupport.class);
                    intent8.putExtra("screen_no", "3");
                    intent8.putExtra("g_id", Action_list.this.j);
                    intent8.putExtra("g_name", Action_list.this.k);
                    intent8.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    Action_list.this.N();
                    intent8.putExtras(Action_list.this.V);
                    Action_list.this.startActivity(intent8);
                    return;
                }
                if (i == 4) {
                    try {
                        Intent intent9 = new Intent(Action_list.this, (Class<?>) Daily_Trans_Report.class);
                        intent9.putExtra("g_id", Action_list.this.j);
                        intent9.putExtra("g_name", Action_list.this.k);
                        intent9.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                        Z00.w0 = false;
                        Action_list.this.startActivity(intent9);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                if (i == 5) {
                    Intent intent10 = new Intent(Action_list.this, (Class<?>) FragmentStatePagerSupport.class);
                    C4143vg c4143vgB3 = Action_list.this.i.B3();
                    intent10.putExtra("screen_no", "11");
                    intent10.putExtra("CUS_ID", c4143vgB3.i());
                    intent10.putExtra("CUS_BAL", "0");
                    intent10.putExtra("CUS_GSM", c4143vgB3.h());
                    intent10.putExtra("CUS_NAME", c4143vgB3.j());
                    intent10.putExtra("g_id", Action_list.this.j);
                    intent10.putExtra("g_name", Action_list.this.k);
                    intent10.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent10.putExtra("CURR_NAME", Action_list.this.i.l3("0"));
                    intent10.putExtra("adv_search", 1);
                    Action_list.this.i.v0("update sys_conf set value_='now' where id=2");
                    String strF5 = Action_list.this.i.f5(0);
                    intent10.putExtra("f_date", strF5);
                    intent10.putExtra("t_date", strF5);
                    Action_list.this.startActivity(intent10);
                    return;
                }
                if (i == 6) {
                    Intent intent11 = new Intent(Action_list.this, (Class<?>) Account_Balance_Report.class);
                    intent11.putExtra("g_id", Action_list.this.j);
                    intent11.putExtra("g_name", Action_list.this.k);
                    intent11.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    Action_list.this.startActivity(intent11);
                    return;
                }
                if (i == 7) {
                    Intent intent12 = new Intent(Action_list.this, (Class<?>) FragmentStatePagerSupport.class);
                    intent12.putExtra("g_id", Action_list.this.j);
                    intent12.putExtra("g_name", Action_list.this.k);
                    intent12.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent12.putExtra("screen_no", "12");
                    Action_list.this.startActivity(intent12);
                    return;
                }
                if (i == 8) {
                    Intent intent13 = new Intent(Action_list.this, (Class<?>) Revaluation_Currency_Report.class);
                    intent13.putExtra("g_id", Action_list.this.j);
                    intent13.putExtra("g_name", Action_list.this.k);
                    intent13.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    Action_list.this.startActivity(intent13);
                    return;
                }
                if (i == 9) {
                    Intent intent14 = new Intent(Action_list.this, (Class<?>) Money_Balance_Report.class);
                    intent14.putExtra("g_id", Action_list.this.j);
                    intent14.putExtra("g_name", Action_list.this.k);
                    intent14.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    Action_list.this.startActivity(intent14);
                    return;
                }
                if (i == 10) {
                    Intent intent15 = new Intent(Action_list.this, (Class<?>) Revenue_customer_Report.class);
                    intent15.putExtra("g_id", Action_list.this.j);
                    intent15.putExtra("g_name", Action_list.this.k);
                    intent15.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent15.putExtra("TR_TYPE", String.valueOf(i));
                    Action_list.this.startActivity(intent15);
                    return;
                }
                if (i == 11) {
                    Intent intent16 = new Intent(Action_list.this, (Class<?>) Bills_customer_Report.class);
                    intent16.putExtra("g_id", Action_list.this.j);
                    intent16.putExtra("g_name", Action_list.this.k);
                    intent16.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent16.putExtra("TR_TYPE", "1");
                    Action_list.this.startActivity(intent16);
                    return;
                }
                if (i == 12) {
                    Intent intent17 = new Intent(Action_list.this, (Class<?>) Bills_customer_Report.class);
                    intent17.putExtra("g_id", Action_list.this.j);
                    intent17.putExtra("g_name", Action_list.this.k);
                    intent17.putExtra("title_", textView.getText().toString().replaceAll("تقرير -", ""));
                    intent17.putExtra("TR_TYPE", "2");
                    Action_list.this.startActivity(intent17);
                    return;
                }
                if (i == 13) {
                    Action_list.this.i.Mc("recreate_items_cost_calc", false);
                    Action_list.this.M();
                    Z00.v0 = false;
                    Intent intent18 = new Intent(Action_list.this, (Class<?>) FragmentStatePagerSupport.class);
                    intent18.putExtra("screen_no", "71");
                    intent18.putExtra("report_type", 1);
                    intent18.putExtra("item_name", Action_list.this.k);
                    intent18.putExtra("br_name", Action_list.this.k);
                    intent18.putExtra("g_id", Action_list.this.j);
                    intent18.putExtra("g_name", Action_list.this.k);
                    Action_list.this.startActivity(intent18);
                    return;
                }
                if (i == 14) {
                    Action_list.this.i.Mc("recreate_items_cost_calc", false);
                    Action_list.this.M();
                    Intent intent19 = new Intent(Action_list.this, (Class<?>) FragmentStatePagerSupport.class);
                    intent19.putExtra("screen_no", "72");
                    intent19.putExtra("report_type", 1);
                    intent19.putExtra("item_name", Action_list.this.k);
                    intent19.putExtra("br_name", Action_list.this.k);
                    intent19.putExtra("g_id", Action_list.this.j);
                    intent19.putExtra("g_name", Action_list.this.k);
                    Action_list.this.startActivity(intent19);
                }
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public c(TextView textView, ImageView imageView) {
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
                Action_list.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Action_list.this.l = 0;
                Action_list.this.L();
            } catch (Exception unused) {
                Toast.makeText(Action_list.this.getApplicationContext(), Action_list.this.getString(R.string.sql_error), 1);
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

    public class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public e(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Action_list.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Action_list.this.l = 0;
                    Action_list.this.L();
                }
            } catch (Exception unused) {
                Toast.makeText(Action_list.this.getApplicationContext(), Action_list.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements DatePickerDialog.OnDateSetListener {
        public g() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Action_list.this.p = i;
            Action_list.this.q = i2;
            Action_list.this.t = i3;
            try {
                String str = Action_list.this.p + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Action_list.this.q + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Action_list.this.t));
                Locale locale = Locale.ENGLISH;
                Action_list.this.z.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Action_list.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Action_list.this.R(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i) {
        if (i == 0) {
            startActivity(new Intent(this, (Class<?>) Report8_item_movement.class));
            return;
        }
        if (i == 1) {
            startActivity(new Intent(this, (Class<?>) Report2_supp_balance.class));
            return;
        }
        if (i == 2) {
            Intent intent = new Intent(this, (Class<?>) Report4_purchases.class);
            intent.putExtra("TR_TYPE", "2");
            startActivity(intent);
        } else if (i == 3) {
            Intent intent2 = new Intent(this, (Class<?>) Report4_purchases.class);
            intent2.putExtra("TR_TYPE", "1");
            startActivity(intent2);
        } else if (i == 4) {
            startActivity(new Intent(this, (Class<?>) Report9_expenses_balance_daily.class));
        } else {
            if (i != 5) {
                return;
            }
            Intent intent3 = new Intent(this, (Class<?>) Report6_expenses.class);
            intent3.putExtra("TR_TYPE", "3");
            startActivity(intent3);
        }
    }

    public void J(int i) {
        GridView gridView = (GridView) findViewById(R.id.gridview);
        int i2 = 0;
        if (i == 0) {
            this.Q = getResources().getStringArray(R.array.action_0);
            this.R = getResources().obtainTypedArray(R.array.icons_0);
        } else if (i == 1) {
            this.Q = getResources().getStringArray(R.array.action_1);
            this.R = getResources().obtainTypedArray(R.array.icons_1);
        } else if (i == 3) {
            this.Q = getResources().getStringArray(R.array.action_3);
            this.R = getResources().obtainTypedArray(R.array.icons_3);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                this.Q = getResources().getStringArray(R.array.action_3_end_date);
                this.R = getResources().obtainTypedArray(R.array.icons_3_end_date_);
            }
        }
        this.S = new ArrayList();
        while (true) {
            String[] strArr = this.Q;
            if (i2 >= strArr.length) {
                this.R.recycle();
                C4062ug c4062ug = new C4062ug(getApplicationContext(), this.S, R.layout.list_item2_);
                this.T = c4062ug;
                gridView.setAdapter((ListAdapter) c4062ug);
                gridView.setOnItemClickListener(new b(i));
                return;
            }
            this.S.add(new C3874sM(strArr[i2], this.R.getResourceId(i2, -1)));
            i2++;
        }
    }

    public void K(Cursor cursor) {
        int count = cursor.getCount();
        this.I.clear();
        Log.d("Cursor_cnt=", String.valueOf(count));
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.B.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f1"))));
            this.C.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))));
            this.D.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))));
            this.E.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f4"))));
            this.F.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f5"))));
            this.G.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))));
            this.H.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))));
            cursor.moveToNext();
        }
        cursor.close();
    }

    public void L() {
        CharSequence title = getTitle();
        this.u = title;
        this.v = title;
        this.Q = getResources().getStringArray(R.array.titles2);
        this.R = getResources().obtainTypedArray(R.array.icons2);
        this.w = (ListView) findViewById(R.id.list_items);
        this.S = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.Q;
            if (i >= strArr.length) {
                this.R.recycle();
                C4062ug c4062ug = new C4062ug(getApplicationContext(), this.S);
                this.T = c4062ug;
                this.w.setAdapter((ListAdapter) c4062ug);
                this.w.setOnItemClickListener(new h());
                return;
            }
            this.S.add(new C3874sM(strArr[i], this.R.getResourceId(i, -1)));
            i++;
        }
    }

    public void M() {
        Cursor cursorG2 = this.i.G2();
        Log.d("recCount_Det=", cursorG2.getCount() + "");
        this.I.clear();
        cursorG2.moveToFirst();
        while (!cursorG2.isAfterLast()) {
            this.I.add(new C4145vh(cursorG2.getString(cursorG2.getColumnIndex("_id")), cursorG2.getString(cursorG2.getColumnIndex("g_name")), "", "", "", ""));
            cursorG2.moveToNext();
        }
        cursorG2.close();
        ((App) getApplication()).c(this.I);
    }

    public void N() {
        Cursor cursorJ3 = this.i.J3();
        this.P.clear();
        cursorJ3.moveToFirst();
        while (!cursorJ3.isAfterLast()) {
            this.P.add(new C0917Sq(cursorJ3.getString(cursorJ3.getColumnIndex("_id")), cursorJ3.getString(cursorJ3.getColumnIndex("g_name")), cursorJ3.getString(cursorJ3.getColumnIndex("curr_name")), cursorJ3.getString(cursorJ3.getColumnIndex("cus_type"))));
            cursorJ3.moveToNext();
        }
        cursorJ3.close();
        Bundle bundle = new Bundle();
        this.V = bundle;
        bundle.putSerializable("dataGroups", this.P);
    }

    public void O() {
        Cursor cursorO4 = this.i.o4();
        Log.d("recCount_Det=", cursorO4.getCount() + "");
        this.N.clear();
        cursorO4.moveToFirst();
        while (!cursorO4.isAfterLast()) {
            this.N.add(new C0917Sq(cursorO4.getString(cursorO4.getColumnIndex("_id")), cursorO4.getString(cursorO4.getColumnIndex("g_name")), cursorO4.getString(cursorO4.getColumnIndex("curr_name")), cursorO4.getString(cursorO4.getColumnIndex("cus_type"))));
            cursorO4.moveToNext();
        }
        cursorO4.close();
        Bundle bundle = new Bundle();
        this.U = bundle;
        bundle.putSerializable("dataGroups", this.N);
    }

    public void P(String str, String str2) {
    }

    public void Q(boolean z) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.W = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new e(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new f());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        P(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new c(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new d());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.W.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.W + "'");
            }
            this.W = "";
            L();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (FragmentStatePagerSupport_Main.a0) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_gridview);
        if (getIntent().getStringExtra("action_text") != null) {
            setTitle(getIntent().getStringExtra("action_text"));
        }
        this.i = new Z00(this.h, this);
        if (getIntent().getIntExtra("action_id", -1) != -1) {
            J(getIntent().getIntExtra("action_id", 0));
        }
        if (getIntent().getStringExtra("g_id") != null) {
            this.j = getIntent().getStringExtra("g_id");
            this.k = getIntent().getStringExtra("g_name");
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        K(this.i.L2());
        Q(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
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
