package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.loader.content.AsyncTaskLoader;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2135eh extends AsyncTaskLoader {
    public String a;
    public String b;
    public String c;
    public Z00 d;
    public int[] e;
    public double f;
    public int g;
    public String h;
    public String i;

    public C2135eh(Context context, String str, String str2, String str3, Z00 z00, int i, String str4, String str5) {
        super(context);
        this.e = new int[]{R.drawable.up, 1, R.drawable.down};
        this.f = 0.0d;
        this.a = str;
        this.d = z00;
        this.b = str2;
        this.c = str3;
        this.g = i;
        this.h = str4;
        this.i = str5;
        Log.d("Customer_hdr_Loader:=", "Customer_Loader:" + str + ":" + str2 + ":" + str3);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList loadInBackground() {
        ArrayList arrayList = new ArrayList();
        int i = this.g;
        String str = "amount";
        String str2 = "";
        if (i == 1) {
            try {
                Cursor cursorRc = !Z00.Z ? this.d.rc(this.a, this.c, this.h, this.i) : this.d.sc(this.a, this.b, this.c, this.h, this.i);
                arrayList.clear();
                C0566Hd c0566Hd = new C0566Hd();
                cursorRc.moveToFirst();
                while (!cursorRc.isAfterLast()) {
                    arrayList.add(new C1896ch(cursorRc.getString(c0566Hd.b(cursorRc, HTML.Attribute.ID)), cursorRc.getString(c0566Hd.b(cursorRc, "_id")), cursorRc.getString(c0566Hd.b(cursorRc, HintConstants.AUTOFILL_HINT_PHONE)), str2 + cursorRc.getDouble(c0566Hd.b(cursorRc, str)), this.e[cursorRc.getInt(c0566Hd.b(cursorRc, "_in"))], cursorRc.getString(c0566Hd.b(cursorRc, "days_late")), cursorRc.getString(c0566Hd.b(cursorRc, "curr_name"))));
                    cursorRc.moveToNext();
                    str = str;
                    str2 = str2;
                }
                c0566Hd.a();
                cursorRc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        String str3 = "amount";
        if (i == 2) {
            Cursor cursorWc = !Z00.Z ? this.d.wc(this.a) : this.d.xc(this.a, this.b);
            arrayList.clear();
            C0566Hd c0566Hd2 = new C0566Hd();
            cursorWc.moveToFirst();
            while (!cursorWc.isAfterLast()) {
                String str4 = str3;
                arrayList.add(new C1896ch(cursorWc.getString(c0566Hd2.b(cursorWc, "_in")), cursorWc.getString(c0566Hd2.b(cursorWc, "_id")), cursorWc.getString(c0566Hd2.b(cursorWc, HintConstants.AUTOFILL_HINT_PHONE)), String.valueOf(cursorWc.getDouble(c0566Hd2.b(cursorWc, str4))), this.e[cursorWc.getInt(c0566Hd2.b(cursorWc, "_in"))], cursorWc.getString(c0566Hd2.b(cursorWc, "days_late"))));
                cursorWc.moveToNext();
                str3 = str4;
            }
            c0566Hd2.a();
            cursorWc.close();
            this.f = 0.0d;
            for (int i2 = 0; i2 <= arrayList.size() - 1; i2++) {
                this.f += Double.parseDouble(((C1896ch) arrayList.get(i2)).a().replaceAll(",", "")) * (Double.parseDouble(((C1896ch) arrayList.get(i2)).i()) - 1.0d);
                C1896ch c1896ch = (C1896ch) arrayList.get(i2);
                c1896ch.n(String.valueOf(this.f));
                arrayList.set(i2, c1896ch);
            }
        }
        return arrayList;
    }
}
