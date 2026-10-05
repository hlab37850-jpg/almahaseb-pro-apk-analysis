package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: pL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3631pL extends AsyncTaskLoader {
    public String a;
    public String b;
    public Z00 c;
    public int[] d;
    public double e;
    public int f;

    public C3631pL(Context context, String str, String str2, Z00 z00, int i) {
        super(context);
        this.d = new int[]{R.drawable.up, 1, R.drawable.down};
        this.e = 0.0d;
        this.a = str;
        this.c = z00;
        this.b = str2;
        this.f = i;
        Log.d("Customer_hdr_Loader:=", "Customer_Loader:" + str + ":" + str2);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList loadInBackground() {
        ArrayList arrayList = new ArrayList();
        int i = this.f;
        String str = "_id";
        String str2 = "";
        if (i == 1) {
            this.c.Vb();
            Cursor cursorTc = this.c.tc();
            cursorTc.getCount();
            arrayList.clear();
            C0566Hd c0566Hd = new C0566Hd();
            cursorTc.moveToFirst();
            while (!cursorTc.isAfterLast()) {
                String string = cursorTc.getString(c0566Hd.b(cursorTc, HTML.Attribute.ID));
                String string2 = cursorTc.getString(c0566Hd.b(cursorTc, "_id"));
                StringBuilder sb = new StringBuilder();
                sb.append(this.c.R7("" + cursorTc.getDouble(c0566Hd.b(cursorTc, "u_price"))));
                sb.append(cursorTc.getString(c0566Hd.b(cursorTc, "curr_name")));
                C3549oL c3549oL = new C3549oL(string, string2, "", sb.toString(), "" + cursorTc.getDouble(c0566Hd.b(cursorTc, "u_cost")), cursorTc.getString(c0566Hd.b(cursorTc, "date_")), cursorTc.getString(c0566Hd.b(cursorTc, "unit_id")));
                c3549oL.j = cursorTc.getString(c0566Hd.b(cursorTc, "curr_name2"));
                arrayList.add(c3549oL);
                cursorTc.moveToNext();
            }
            c0566Hd.a();
            cursorTc.close();
        } else if (i == 6) {
            Cursor cursorEc = this.c.Ec();
            Log.d("recCount_Det=", cursorEc.getCount() + "");
            arrayList.clear();
            C0566Hd c0566Hd2 = new C0566Hd();
            cursorEc.moveToFirst();
            while (!cursorEc.isAfterLast()) {
                arrayList.add(new C3549oL(cursorEc.getString(c0566Hd2.b(cursorEc, HTML.Attribute.ID)), cursorEc.getString(c0566Hd2.b(cursorEc, "_id")), "", this.c.P7(cursorEc.getString(c0566Hd2.b(cursorEc, "price"))), cursorEc.getString(c0566Hd2.b(cursorEc, "f_date")), cursorEc.getString(c0566Hd2.b(cursorEc, "t_date")), "0"));
                cursorEc.moveToNext();
            }
            c0566Hd2.a();
            cursorEc.close();
        } else if (i == 2 || i == 3) {
            Cursor cursorOc = this.c.oc(String.valueOf(i - 1));
            cursorOc.getCount();
            arrayList.clear();
            C0566Hd c0566Hd3 = new C0566Hd();
            cursorOc.moveToFirst();
            while (!cursorOc.isAfterLast()) {
                arrayList.add(new C3549oL(cursorOc.getString(c0566Hd3.b(cursorOc, "_id")), cursorOc.getString(c0566Hd3.b(cursorOc, "br_name")), "", this.c.P7(cursorOc.getString(c0566Hd3.b(cursorOc, "tot_amount"))), cursorOc.getString(c0566Hd3.b(cursorOc, "curr_name")), cursorOc.getString(c0566Hd3.b(cursorOc, "type_name")), "0"));
                cursorOc.moveToNext();
            }
            c0566Hd3.a();
            cursorOc.close();
        } else if (i == 5) {
            Cursor cursorAc = this.c.Ac();
            cursorAc.getCount();
            arrayList.clear();
            C0566Hd c0566Hd4 = new C0566Hd();
            cursorAc.moveToFirst();
            while (!cursorAc.isAfterLast()) {
                arrayList.add(new C3549oL(this.c.P7(String.valueOf(Double.parseDouble(cursorAc.getString(cursorAc.getColumnIndex("s_amount"))) - Double.parseDouble(cursorAc.getString(cursorAc.getColumnIndex("s_qty_cost"))))), cursorAc.getString(c0566Hd4.b(cursorAc, "br_name")), cursorAc.getString(c0566Hd4.b(cursorAc, "curr_name")), this.c.P7(cursorAc.getString(c0566Hd4.b(cursorAc, "p_amount"))), this.c.P7(cursorAc.getString(c0566Hd4.b(cursorAc, "s_amount"))), this.c.P7(cursorAc.getString(c0566Hd4.b(cursorAc, "s_qty_cost"))), this.c.P7(cursorAc.getString(c0566Hd4.b(cursorAc, "net_qty")))));
                cursorAc.moveToNext();
            }
            c0566Hd4.a();
            cursorAc.close();
        } else if (i == 7) {
            Cursor cursorUc = this.c.uc(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.b);
            cursorUc.getCount();
            arrayList.clear();
            C0566Hd c0566Hd5 = new C0566Hd();
            cursorUc.moveToFirst();
            while (!cursorUc.isAfterLast()) {
                String string3 = cursorUc.getString(c0566Hd5.b(cursorUc, HTML.Attribute.ID));
                String string4 = cursorUc.getString(c0566Hd5.b(cursorUc, str));
                String str3 = str2 + cursorUc.getDouble(c0566Hd5.b(cursorUc, "cr_amount"));
                String str4 = str2 + cursorUc.getDouble(c0566Hd5.b(cursorUc, "db_amount"));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                String str5 = str;
                String str6 = str2;
                sb2.append(cursorUc.getDouble(c0566Hd5.b(cursorUc, "net_balance")));
                arrayList.add(new C3549oL(string3, string4, "", str3, str4, sb2.toString(), !Z00.Z ? str6 : cursorUc.getString(cursorUc.getColumnIndex("curr_name"))));
                cursorUc.moveToNext();
                str = str5;
                str2 = str6;
            }
            c0566Hd5.a();
            cursorUc.close();
        }
        return arrayList;
    }
}
