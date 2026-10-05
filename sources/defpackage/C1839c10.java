package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import com.itextpdf.tool.xml.css.CSS;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Daily_Doc_Report;
import info.aalmoghalis.inventory.activity.Daily_Trans_Report;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport;
import info.aalmoghalis.inventory.lang.App;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: c10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1839c10 {
    public static int d = 3;
    public static String[] e = {"aalmoghalis@gmail.com", "azraki.test@gmail.com", "azraki.ye@gmail.com", "maherhaisam2014@gmail.com", "mokhtaralmoghlis@gmail.com", "mmoghlis@gmail.com"};
    public Dialog a = null;
    public Activity b;
    public Z00 c;

    /* JADX INFO: renamed from: c10$a */
    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Callable a;

        public a(Callable callable) {
            this.a = callable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Callable callable = this.a;
                if (callable != null) {
                    callable.call();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: c10$c */
    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ Z00 c;
        public final /* synthetic */ HashMap d;

        public c(int i, Activity activity, Z00 z00, HashMap map) {
            this.a = i;
            this.b = activity;
            this.c = z00;
            this.d = map;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                ((Bill_edit) this.b).Z.setText(this.c.P7(String.valueOf(this.d.get("bill_net_"))));
                ((Bill_edit) this.b).b0.setText(this.c.P7(String.valueOf(this.d.get("bill_total_disc"))));
                ((Bill_edit) this.b).U0.setText(this.c.P7(String.valueOf(this.d.get("bill_paid_val"))));
                ((Bill_edit) this.b).V1();
                ((Bill_edit) this.b).N2 = 1;
            }
        }
    }

    /* JADX INFO: renamed from: c10$f */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(C1839c10.this.b, (Class<?>) Daily_Doc_Report.class);
            intent.putExtra("g_id", C2160f10.j + "");
            intent.putExtra("g_name", "");
            intent.putExtra("title_", C1839c10.this.b.getResources().getStringArray(R.array.titles4)[0].toString().replaceAll("تقرير -", ""));
            Z00.y0 = true;
            C1839c10.this.b.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: c10$h */
    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(C1839c10.this.b, (Class<?>) Daily_Trans_Report.class);
            intent.putExtra("g_id", "");
            intent.putExtra("g_name", "");
            intent.putExtra("title_", C1839c10.this.b.getString(R.string.add_tr_account));
            Z00.w0 = true;
            C1839c10.this.b.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: c10$j */
    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C1839c10.this.c.Mc("recreate_items_cost_calc", false);
            C1839c10.this.r();
            Z00.v0 = true;
            Intent intent = new Intent(C1839c10.this.b, (Class<?>) FragmentStatePagerSupport.class);
            intent.putExtra("screen_no", "71");
            intent.putExtra("report_type", 1);
            intent.putExtra("item_name", "");
            intent.putExtra("br_name", "g_name");
            intent.putExtra("g_id", "0");
            intent.putExtra("g_name", "");
            C1839c10.this.b.startActivity(intent);
        }
    }

    public C1839c10() {
    }

    public static String B(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (String str3 : str.split(StringUtilities.LF)) {
            if (!str3.contains(str2)) {
                sb.append(str3);
                sb.append(StringUtilities.LF);
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static double C(double d2, int i2) {
        return new BigDecimal(d2).setScale(i2, RoundingMode.HALF_UP).doubleValue();
    }

    public static void D(Z00 z00, Activity activity, String str, String str2, boolean z, Callable callable) {
        try {
            if (str2.length() <= 0 || !z00.ia(str2, "").equals(Z00.n3()) || J(z00) || z) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(str);
                builder.setCancelable(true).setNegativeButton(activity.getString(R.string.btn_close), new a(callable));
                builder.create().show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean I(Z00 z00) {
        String strIa = z00.ia("PREF_ACCOUNT_NAME", "");
        Z00.T = strIa;
        return strIa.toLowerCase().equals("salehalialazzani@gmail.com") || Z00.T.toLowerCase().equals("salehalisalemalazzani@gmail.com") || Z00.T.toLowerCase().equals("alisalemalaazaniastore@gmail.com");
    }

    public static boolean J(Z00 z00) {
        return C2160f10.q(e, z00.ia("PREF_ACCOUNT_NAME", "").toUpperCase());
    }

    public static int d(Z00 z00, boolean z, String str) {
        if (z00.ia(str, "").equals(Z00.n3()) && !J(z00) && !z) {
            z(z00, "bills_total_diff=", "Exit");
            return 0;
        }
        double dY4 = z00.Y4("select count(*) as _id\nfrom bills_tot_issue a ");
        StringBuilder sb = new StringBuilder();
        sb.append("diff:");
        int i2 = (int) dY4;
        sb.append(i2);
        sb.append(":d=");
        sb.append(z00.ia(str, ""));
        z(z00, "bills_total_diff=", sb.toString());
        if (dY4 == 0.0d) {
            z00.Lc(str, Z00.n3());
        }
        return i2;
    }

    public static boolean k(Z00 z00, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) as _id from customers where (sms=1 or wa=1) and (id='");
        sb.append(str);
        sb.append("' or name='");
        sb.append(str);
        sb.append("')");
        return z00.X4(sb.toString()).equals("1") || z00.ja("prefAutoSMS_wa", false) || z00.ja("prefAutoSMS", false);
    }

    public static boolean l(Z00 z00, String str) {
        if (!z00.X4("select count(*) as _id from customers where (sms=1) and (id='" + str + "' or name='" + str + "')").equals("1")) {
            if (!z00.ja("prefAutoSMS", false)) {
                return false;
            }
            if (!z00.X4("select count(*) as _id from customers where (sms=0 and wa=0) and id=" + str).equals("1")) {
                return false;
            }
        }
        return true;
    }

    public static boolean m(Z00 z00, String str) {
        if (!z00.X4("select count(*) as _id from customers where (wa=1) and (id='" + str + "' or name='" + str + "')").equals("1")) {
            if (!z00.ja("prefAutoSMS_wa", false)) {
                return false;
            }
            if (!z00.X4("select count(*) as _id from customers where (sms=0 and wa=0) and id=" + str).equals("1")) {
                return false;
            }
        }
        return true;
    }

    public static void n(int i2, double d2, Z00 z00, Activity activity) {
        double d3;
        Object obj;
        Z00 z01;
        String strReplace;
        try {
            String string = activity.getString(R.string.bills_tot_fix_confirm);
            HashMap map = new HashMap();
            if (i2 != 1 && i2 != 2) {
                return;
            }
            map.put("bill_total_disc", Double.valueOf(((Bill_edit) activity).S1));
            map.put("bill_disc_id", Double.valueOf(((Bill_edit) activity).T1));
            map.put("bill_disc_val", Double.valueOf(((Bill_edit) activity).U1));
            map.put("bill_tax", Double.valueOf(((Bill_edit) activity).X1));
            map.put("bill_t_val", Double.valueOf(((Bill_edit) activity).W1));
            map.put("bill_cost_val", Double.valueOf(((Bill_edit) activity).Z1));
            map.put("bill_paid_val", Double.valueOf(((Bill_edit) activity).U0.getText().toString().replace(",", "")));
            map.put("bill_remin_val", Double.valueOf(((Bill_edit) activity).V0.getText().toString().replace(",", "")));
            map.put("bill_total_", Double.valueOf(((Bill_edit) activity).R1));
            map.put("bill_net_", Double.valueOf(((Bill_edit) activity).Z.getText().toString().replace(",", "")));
            double d4 = ((Bill_edit) activity).S1;
            if (((Bill_edit) activity).T1 == 1) {
                d3 = (((Bill_edit) activity).U1 / 100.0d) * d2;
                map.put("bill_total_disc", Double.valueOf(d3));
            } else {
                d3 = d4;
            }
            double d5 = d2 - d3;
            double d6 = (((Bill_edit) activity).W1 * d5) / 100.0d;
            if (d6 != ((Bill_edit) activity).X1) {
                map.put("bill_tax", Double.valueOf(d6));
            }
            double d7 = d6 + d5 + ((Bill_edit) activity).Z1;
            if (d7 != ((Bill_edit) activity).R1) {
                map.put("bill_total_", Double.valueOf(d7));
            }
            if (d5 != ((Double) map.get("bill_net_")).doubleValue()) {
                map.put("bill_net_", Double.valueOf(d5));
            }
            if (Double.valueOf(((Bill_edit) activity).U0.getText().toString().replace(",", "")).doubleValue() > d7) {
                map.put("bill_paid_val", Double.valueOf(0.0d));
                obj = "bill_remin_val";
                map.put(obj, Double.valueOf(0.0d));
            } else {
                obj = "bill_remin_val";
                map.put(obj, Double.valueOf(d7 - Double.valueOf(((Bill_edit) activity).U0.getText().toString().replace(",", "")).doubleValue()));
            }
            if (((Double) map.get("bill_total_disc")).doubleValue() == ((Bill_edit) activity).S1) {
                strReplace = B(string, "{1}");
                z01 = z00;
            } else {
                z01 = z00;
                strReplace = string.replace("{1}", z01.O7(((Bill_edit) activity).S1)).replace("{2}", z01.O7(((Double) map.get("bill_total_disc")).doubleValue()));
            }
            String strB = map.get("bill_net_") == Double.valueOf(((Bill_edit) activity).Z.getText().toString().replace(",", "")) ? B(strReplace, "{3}") : strReplace.replace("{3}", z01.O7(Double.valueOf(((Bill_edit) activity).Z.getText().toString().replace(",", "")).doubleValue())).replace("{4}", z01.P7(((Double) map.get("bill_net_")).toString()));
            String strB2 = ((Double) map.get("bill_tax")).doubleValue() == ((Bill_edit) activity).X1 ? B(strB, "{5}") : strB.replace("{5}", z01.O7(((Bill_edit) activity).X1)).replace("{6}", z01.O7(((Double) map.get("bill_tax")).doubleValue()));
            String strB3 = ((Double) map.get("bill_total_")).doubleValue() == ((Bill_edit) activity).R1 ? B(strB2, "{7}") : strB2.replace("{7}", z01.O7(((Bill_edit) activity).R1)).replace("{8}", z01.O7(((Double) map.get("bill_total_")).doubleValue()));
            String strB4 = ((Double) map.get("bill_paid_val")).doubleValue() == ((Bill_edit) activity).V1 ? B(strB3, "{9}") : strB3.replace("{9}", z01.O7(((Bill_edit) activity).V1)).replace("{10}", z01.O7(((Double) map.get("bill_paid_val")).doubleValue()));
            String strB5 = map.get(obj) == Double.valueOf(((Bill_edit) activity).V0.getText().toString().replace(",", "")) ? B(strB4, "{11}") : strB4.replace("{11}", z01.O7(Double.valueOf(((Bill_edit) activity).V0.getText().toString().replace(",", "")).doubleValue())).replace("{12}", z01.O7(((Double) map.get(obj)).doubleValue()));
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(strB5);
            builder.setCancelable(true).setPositiveButton(activity.getString(R.string.resourceID_OK), new c(i2, activity, z01, map)).setNegativeButton(activity.getString(R.string.resourceID_Cancel), new b());
            builder.create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean o(Z00 z00) {
        String strIa = z00.ia("PREF_ACCOUNT_NAME", "");
        Z00.T = strIa;
        return strIa.toLowerCase().equals("aalmoghalis@gmail.com") || Z00.T.toLowerCase().equals("engmogh@gmail.com") || Z00.T.toLowerCase().equals("goinsoft2020@gmail.com");
    }

    public static Integer p(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1 || cursor.isNull(columnIndex)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(columnIndex));
    }

    public static String v(String str, int i2) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        numberFormat.setMaximumFractionDigits(i2);
        return numberFormat.format(Double.parseDouble(str));
    }

    public static boolean w(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        return columnIndex == -1 || cursor.isNull(columnIndex);
    }

    public static /* synthetic */ Integer x() {
        if (!AbstractC1794bT.e()) {
            AbstractC1794bT.a();
        }
        return 1;
    }

    public static void z(Z00 z00, String str, String str2) {
        try {
            if (o(z00)) {
                Log.d(str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void A() {
        if (this.c.S() && AbstractC4158vt.a(this.b)) {
            AbstractC3132jE.d(new Callable() { // from class: a10
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C1839c10.x();
                }
            }).m(IN.c()).g().e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: b10
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    C1839c10.y((Integer) obj);
                }
            });
        }
    }

    public void E(Z00 z00) {
        try {
            String strQ = q(z00);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setMessage(this.b.getString(R.string.not_balanced) + StringUtilities.LF + strQ);
            builder.setCancelable(true).setNegativeButton(this.b.getString(R.string.btn_close), new d());
            builder.create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void F() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setMessage(this.b.getString(R.string.doc_curr_price_issue));
            builder.setCancelable(true).setPositiveButton(this.b.getString(R.string.details), new h()).setNegativeButton(this.b.getString(R.string.btn_close), new g());
            builder.create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void G() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setMessage(this.b.getString(R.string.doc_curr_price_issue));
            builder.setCancelable(true).setPositiveButton(this.b.getString(R.string.details), new f()).setNegativeButton(this.b.getString(R.string.btn_close), new e());
            builder.create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void H() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setMessage(this.b.getString(R.string.neg_purchase));
            builder.setCancelable(true).setPositiveButton(this.b.getString(R.string.details), new j()).setNegativeButton(this.b.getString(R.string.btn_close), new i());
            builder.create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean c(Z00 z00) {
        return !q(z00).equals("0");
    }

    public boolean e(Z00 z00) {
        StringBuilder sb = new StringBuilder();
        sb.append(" select ifnull(group_concat((select name from tran_type where id=tr_type) ||':'|| p_ref_no,' , '),'') as _id from(\n");
        sb.append(Z00.x0);
        sb.append("  )");
        return !z00.X4(sb.toString()).equals("");
    }

    public boolean f(Z00 z00) {
        StringBuilder sb = new StringBuilder();
        sb.append(" select ifnull(group_concat((select name from tran_type where id=tr_type) ||':'|| p_ref_no,' , '),'') as _id from(\n");
        sb.append(Z00.z0);
        sb.append("  )");
        return !z00.X4(sb.toString()).equals("");
    }

    public ArrayList g(ArrayList arrayList, String str, String str2, String str3) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((String) ((HashMap) arrayList.get(i2)).get("item_name")).equals(str) && ((String) ((HashMap) arrayList.get(i2)).get("br_name")).equals(str2) && ((String) ((HashMap) arrayList.get(i2)).get("item_date")).equals(str3)) {
                arrayList2.add((HashMap) arrayList.get(i2));
            }
        }
        return arrayList2;
    }

    public ArrayList h(ArrayList arrayList, String str, String str2) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((String) ((HashMap) arrayList.get(i2)).get("item_name")).equals(str) && ((String) ((HashMap) arrayList.get(i2)).get("br_name")).equals(str2) && Double.parseDouble((String) ((HashMap) arrayList.get(i2)).get("item_qty")) != 0.0d) {
                arrayList2.add((HashMap) arrayList.get(i2));
            }
        }
        return arrayList2;
    }

    public boolean i(String str, int i2) {
        return !str.equals(CSS.Value.PERCENTAGE) && i2 == 1;
    }

    public boolean j() {
        double dY4 = this.c.Y4("select count(*) as _id\nfrom items_cost_calc a where " + Z00.u0);
        Log.d("neg_purchase_diff=", "diff:" + dY4);
        return dY4 != 0.0d;
    }

    public String q(Z00 z00) {
        String strX4 = z00.X4("select IFNULL( group_concat(case when bill_id>0 then  (select (select name from tran_type  where id=tr_type)||'-'||(select name from branches  where id=br_id)||':'||bill_no2 from bills where id=bill_id) \nelse (case when bill_id=-2 then 'قيد#' when tr_type>0 then (select name||':' from tran_type where id=tr_type) end)|| p_ref_no end),0) as _id\nfrom transactions where (cus_id =IFNULL( t_cus_id,0) )");
        Log.d("br_account=", "diff:" + strX4);
        return strX4;
    }

    public void r() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorI2 = this.c.I2();
        arrayList.clear();
        cursorI2.moveToFirst();
        while (!cursorI2.isAfterLast()) {
            arrayList.add(new C4145vh(cursorI2.getString(cursorI2.getColumnIndex("_id")), cursorI2.getString(cursorI2.getColumnIndex("g_name")), "", "", "", ""));
            cursorI2.moveToNext();
        }
        cursorI2.close();
        ((App) this.b.getApplication()).c(arrayList);
    }

    public String s(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, Integer.parseInt(str));
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime());
    }

    public ArrayList t(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Log.d("date_parts=", str + ":");
            if (str != null && str.length() != 0 && str.contains("-")) {
                Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(str);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                arrayList.add(Integer.valueOf(calendar.get(1)));
                arrayList.add(Integer.valueOf(calendar.get(2)));
                arrayList.add(Integer.valueOf(calendar.get(5)));
                Log.d("date_parts=", str + ":" + arrayList.toString());
                return arrayList;
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public double u(String str, String str2, String str3, String str4, int i2, boolean z, String str5) {
        byte b2 = (Long.parseLong(str) != 0 || !(i2 == 2 || i2 == 21) || z) ? (byte) 1 : (byte) -1;
        Z00 z00 = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(" select  -ifnull((select sum(aa.qty_pr*aa.u_val*ifnull((select u_val from unit_item where item_id=aa.item_id and unit_id=aa.base_unit ),1))  ),0) *ifnull((select (case when bb.adj_id in(2,4) or (bb.tr_type in(2,21) and bb.is_back=0) then -1 else 1 end ) from bills bb where bb.id=");
        sb.append(str);
        sb.append("),1)  as _id  from items a,branches b,items_temp aa where a.o_br_id=b.id and aa.item_id=a.id  and b.name='");
        sb.append(str3);
        sb.append("' and a.name='");
        sb.append(str5);
        sb.append("'");
        String string = " ";
        if (b2 != -1) {
            StringBuilder sb2 = new StringBuilder();
            if (str4.length() != 0) {
                string = " and aa.e_date='" + str4 + "' ";
            }
            sb2.append(string);
            sb2.append(" and aa.no_= ");
            sb2.append(str2);
            sb2.append("");
            string = sb2.toString();
        }
        sb.append(string);
        double dY4 = z00.Y4(sb.toString());
        if (Long.parseLong(str) == 0 && ((i2 == 2 || i2 == 21) && !z && dY4 < 0.0d)) {
            dY4 *= 2.0d;
        }
        Log.d("get_item_qty_current=", "" + str + ":" + str2 + ":" + str3 + ":" + str4 + ":" + i2 + ":" + z + ":" + str5 + ":" + dY4);
        return dY4;
    }

    public C1839c10(Activity activity) {
        this.b = activity;
    }

    public C1839c10(Z00 z00) {
        this.c = z00;
    }

    public C1839c10(Activity activity, Z00 z00) {
        this.b = activity;
        this.c = z00;
    }

    public static /* synthetic */ void y(Integer num) {
    }

    /* JADX INFO: renamed from: c10$b */
    public class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: c10$d */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: c10$e */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: c10$g */
    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: c10$i */
    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
