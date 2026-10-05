package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.loader.content.AsyncTaskLoader;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1249ah extends AsyncTaskLoader {
    public String a;
    public String b;
    public String c;
    public Z00 d;
    public int[] e;
    public double f;

    public C1249ah(Context context, String str, String str2, String str3, Z00 z00) {
        super(context);
        this.e = new int[]{R.drawable.up, 1, R.drawable.down};
        this.f = 0.0d;
        this.a = str;
        this.d = z00;
        this.b = str2;
        this.c = str3;
        Log.d("Customer_Loader:=", "Customer_Loader:g_id=" + str + ":curr=" + str2 + ":type=" + str3 + ":" + FragmentStatePagerSupport_Main.X());
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        ArrayList arrayList = new ArrayList();
        Log.d("Customer_Loader:=", "before_db:" + this.a + ":" + this.b + "::type=" + this.c + FragmentStatePagerSupport_Main.X());
        Cursor cursorG4 = this.d.G4(this.a, this.b, this.c);
        cursorG4.moveToFirst();
        Log.d("Customer_Loader:=", "after_db:" + this.a + ":" + this.b + "::type=" + this.c + FragmentStatePagerSupport_Main.X());
        this.f = 0.0d;
        arrayList.clear();
        C0566Hd c0566Hd = new C0566Hd();
        Log.d("Customer_Loader:=", "before_loop:" + this.a + ":" + this.b + ":type=" + this.c + ":" + FragmentStatePagerSupport_Main.X());
        while (!cursorG4.isAfterLast()) {
            arrayList.add(new C4143vg(cursorG4.getString(c0566Hd.b(cursorG4, HTML.Attribute.ID)), cursorG4.getString(c0566Hd.b(cursorG4, "_id")), cursorG4.getString(c0566Hd.b(cursorG4, HintConstants.AUTOFILL_HINT_PHONE)), cursorG4.getDouble(c0566Hd.b(cursorG4, "amount")), this.e[cursorG4.getInt(c0566Hd.b(cursorG4, "_in"))], 0, cursorG4.getString(c0566Hd.b(cursorG4, "g_name")), cursorG4.getString(c0566Hd.b(cursorG4, "curr_name")), cursorG4.getString(c0566Hd.b(cursorG4, "cnt")), cursorG4.getString(c0566Hd.b(cursorG4, "cus_type"))));
            cursorG4.moveToNext();
        }
        Log.d("Customer_Loader:=", "after_loop:" + this.a + ":" + this.b + ":type=" + this.c + ":" + FragmentStatePagerSupport_Main.X());
        c0566Hd.a();
        cursorG4.close();
        return arrayList;
    }
}
