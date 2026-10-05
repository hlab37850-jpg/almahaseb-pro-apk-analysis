package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.itextpdf.tool.xml.css.CSS;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: renamed from: Qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0856Qh extends AsyncTaskLoader {
    public String a;
    public Z00 b;
    public int c;
    public int[] d;

    public C0856Qh(Context context, Z00 z00, String str, int i) {
        super(context);
        this.d = new int[]{R.drawable.up, 1, R.drawable.down};
        this.a = str;
        this.b = z00;
        this.c = i;
        Log.d("Data_All_Loader:=", "Data_All_Loader:" + str);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        ArrayList arrayList = new ArrayList();
        int i = this.c;
        String str = "remarks";
        String str2 = "date_";
        String str3 = "_id";
        String str4 = "";
        if (i == 0) {
            int i2 = 0;
            Cursor cursorU3 = this.b.U3(this.a, -1, 0);
            cursorU3.moveToFirst();
            int count = cursorU3.getCount();
            arrayList.clear();
            C0566Hd c0566Hd = new C0566Hd();
            while (i2 < count) {
                if (count >= 10000) {
                    cursorU3 = this.b.U3(this.a, Constants.CP_MAC_ROMAN, i2);
                    cursorU3.moveToFirst();
                    Log.d("cursor_cnt=", i2 + str4);
                }
                while (!cursorU3.isAfterLast()) {
                    arrayList.add(new C0795Oh(cursorU3.getString(c0566Hd.b(cursorU3, "_id")), cursorU3.getString(c0566Hd.b(cursorU3, "date_")), str4 + cursorU3.getDouble(c0566Hd.b(cursorU3, "amount")), cursorU3.getString(c0566Hd.b(cursorU3, "remarks")), this.d[cursorU3.getInt(c0566Hd.b(cursorU3, "_in"))], cursorU3.getString(c0566Hd.b(cursorU3, "name")), cursorU3.getString(c0566Hd.b(cursorU3, "bill_id")), cursorU3.getString(c0566Hd.b(cursorU3, "org_remarks")), cursorU3.getString(c0566Hd.b(cursorU3, "p_id")), cursorU3.getString(c0566Hd.b(cursorU3, "doc_type")), cursorU3.getString(c0566Hd.b(cursorU3, "p_acc_id"))));
                    cursorU3.moveToNext();
                    count = count;
                    str4 = str4;
                }
                i2 += Constants.CP_MAC_ROMAN;
                c0566Hd.a();
                cursorU3.close();
            }
        } else if (i == 1) {
            Cursor cursorP3 = this.b.P3(this.a, "-1");
            arrayList.clear();
            cursorP3.moveToFirst();
            while (!cursorP3.isAfterLast()) {
                arrayList.add(new C0795Oh(cursorP3.getLong(cursorP3.getColumnIndex("_id")), cursorP3.getString(cursorP3.getColumnIndex("date_")), String.valueOf(cursorP3.getDouble(cursorP3.getColumnIndex("amount"))), cursorP3.getString(cursorP3.getColumnIndex(str)), this.d[cursorP3.getInt(cursorP3.getColumnIndex("_in"))], cursorP3.getString(cursorP3.getColumnIndex("name")), cursorP3.getString(cursorP3.getColumnIndex("bill_id")), cursorP3.getString(cursorP3.getColumnIndex("curr_name")), cursorP3.getString(cursorP3.getColumnIndex("param1")), cursorP3.getString(cursorP3.getColumnIndex("fund_name")), cursorP3.getString(cursorP3.getColumnIndex("other_account"))));
                cursorP3.moveToNext();
                str = str;
            }
            cursorP3.close();
        } else if (i == 2) {
            Cursor cursorM5 = this.b.m5(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.a);
            cursorM5.moveToFirst();
            arrayList.clear();
            C0566Hd c0566Hd2 = new C0566Hd();
            while (!cursorM5.isAfterLast()) {
                arrayList.add(new C0795Oh(cursorM5.getString(c0566Hd2.b(cursorM5, str3)), cursorM5.getString(c0566Hd2.b(cursorM5, str2)), "" + cursorM5.getDouble(c0566Hd2.b(cursorM5, "credit")), cursorM5.getString(c0566Hd2.b(cursorM5, "tr_remarks")), 0, cursorM5.getString(c0566Hd2.b(cursorM5, "cus_name")), cursorM5.getString(c0566Hd2.b(cursorM5, "bill_id")), cursorM5.getString(c0566Hd2.b(cursorM5, "curr_name")), cursorM5.getString(c0566Hd2.b(cursorM5, "param1")), cursorM5.getString(c0566Hd2.b(cursorM5, "bill_no")), cursorM5.getString(c0566Hd2.b(cursorM5, "p_remarks")), cursorM5.getString(c0566Hd2.b(cursorM5, "debit"))));
                cursorM5.moveToNext();
                str2 = str2;
                str3 = str3;
            }
            c0566Hd2.a();
            cursorM5.close();
        }
        return arrayList;
    }
}
