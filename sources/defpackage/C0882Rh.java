package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.itextpdf.tool.xml.css.CSS;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: Rh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0882Rh extends AsyncTaskLoader {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public Z00 g;
    public int[] h;
    public double i;

    public C0882Rh(Context context, String str, String str2, Z00 z00, String str3, int i, String str4, String str5) {
        super(context);
        this.h = new int[]{R.drawable.up, 1, R.drawable.down};
        this.i = 0.0d;
        this.a = str;
        this.g = z00;
        this.c = str3;
        this.f = i;
        this.d = str4;
        this.e = str5;
        this.b = str2;
        Log.d("Data_Loader:=", "Data_Loader:" + str + ":" + str2);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        Cursor cursorQ3;
        ArrayList arrayList = new ArrayList();
        int i = this.f;
        String str = CSS.Value.PERCENTAGE;
        if (i == 0) {
            cursorQ3 = this.g.N3(this.a, this.b, CSS.Value.PERCENTAGE);
        } else {
            this.d = this.d.isEmpty() ? CSS.Value.PERCENTAGE : this.d;
            if (!this.e.isEmpty()) {
                str = this.e;
            }
            String str2 = str;
            this.e = str2;
            cursorQ3 = this.g.Q3(this.a, this.d, str2, this.b, -1, -1, this.f, 0, "");
        }
        Log.d("Data_Loader:=", "before_db:" + this.a + ":" + this.f + ":" + this.d + ":" + this.e);
        cursorQ3.moveToFirst();
        StringBuilder sb = new StringBuilder();
        sb.append("after_db:");
        sb.append(this.a);
        sb.append(":");
        sb.append(FragmentStatePagerSupport_Main.X());
        Log.d("Data_Loader:=", sb.toString());
        this.i = 0.0d;
        arrayList.clear();
        Log.d("Data_Loader:=", "before_loop:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
        C0566Hd c0566Hd = new C0566Hd();
        while (!cursorQ3.isAfterLast()) {
            String string = cursorQ3.getString(c0566Hd.b(cursorQ3, "_id"));
            String string2 = cursorQ3.getString(c0566Hd.b(cursorQ3, "date_"));
            String str3 = "" + cursorQ3.getDouble(c0566Hd.b(cursorQ3, "amount"));
            String string3 = cursorQ3.getString(c0566Hd.b(cursorQ3, "remarks")) != null ? cursorQ3.getString(c0566Hd.b(cursorQ3, "remarks")) : "";
            arrayList.add(new C4064uh(string, string2, str3, string3, this.h[cursorQ3.getInt(c0566Hd.b(cursorQ3, "_in"))], "" + cursorQ3.getInt(c0566Hd.b(cursorQ3, "_in")), cursorQ3.getString(c0566Hd.b(cursorQ3, "param1")), cursorQ3.getString(c0566Hd.b(cursorQ3, "curr_name")), cursorQ3.getString(c0566Hd.b(cursorQ3, "bill_id")), cursorQ3.getString(c0566Hd.b(cursorQ3, "org_remarks")), cursorQ3.getString(c0566Hd.b(cursorQ3, "p_id")), cursorQ3.getString(c0566Hd.b(cursorQ3, "other_account")), cursorQ3.getString(c0566Hd.b(cursorQ3, "doc_type")), cursorQ3.getString(c0566Hd.b(cursorQ3, "p_acc_id")), cursorQ3.getString(c0566Hd.b(cursorQ3, "param2"))));
            cursorQ3.moveToNext();
        }
        c0566Hd.a();
        cursorQ3.close();
        Log.d("Data_Loader:=", "after_loop:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
        return arrayList;
    }
}
