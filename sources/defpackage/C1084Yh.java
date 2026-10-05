package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;
import com.itextpdf.tool.xml.css.CSS;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: Yh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1084Yh extends RxPagingSource {
    public String a;
    public String b;
    public Z00 e;
    public Context k;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public String s;
    public int t;
    public int u;
    public String c = CSS.Value.PERCENTAGE;
    public int d = 0;
    public int[] f = {R.drawable.up, 1, R.drawable.down};
    public double g = 0.0d;
    public MutableLiveData h = new MutableLiveData();
    public MutableLiveData i = new MutableLiveData();
    public MutableLiveData j = new MutableLiveData();
    public int l = 0;
    public int v = 0;

    public C1084Yh(Context context, String str, String str2, Z00 z00, String str3, int i, String str4, String str5, int i2, int i3, String str6, int i4, int i5) {
        this.k = context;
        this.a = str;
        this.e = z00;
        this.m = str3;
        this.p = i;
        this.n = str4;
        this.o = str5;
        this.q = i2;
        this.r = i3;
        this.s = str6;
        this.t = i4;
        this.u = i5;
        this.b = str2;
        Log.d("trace_Data_Loader2:=", "Data_Loader:" + str + ":" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public PagingSource.LoadResult f(List list, int i) {
        Log.d("trace_2_toLoadResult=", "" + list.size() + ":" + i);
        if (list.size() == 0 || this.p == 1 || this.q > 0 || list.size() < C2160f10.l) {
            return new PagingSource.LoadResult.Page(list, i == 1 ? null : Integer.valueOf(i), null);
        }
        return new PagingSource.LoadResult.Page(list, i != 1 ? Integer.valueOf(i - 1) : null, Integer.valueOf(i + 1));
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List e(int i, int i2) throws Throwable {
        String str;
        String str2;
        Cursor cursorQ3;
        ArrayList arrayList;
        boolean z;
        List listK;
        String str3 = "remarks";
        int i3 = (i2 - 1) * i;
        Log.d("trace_2getItemsInPage3:", this.a + ":" + this.b + ":page=" + i2 + ":limit=" + i + ":offset=" + i3);
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = this.p != 1 && this.q <= 0;
        Cursor cursor = null;
        try {
            Log.d("trace_2getItemsInPage3:", this.a + ":" + this.b + ":page=" + i2 + ":before_db:query_flag=" + this.r + ":do_action=" + this.q + ":adv_search=" + this.p);
            if (z2) {
                str = "trace_2getItemsInPage3:";
                str2 = ":page=";
                cursorQ3 = this.e.Q3(this.a, this.n, this.o, this.b, i, i3, this.p, this.r, this.s);
            } else {
                str = "trace_2getItemsInPage3:";
                str2 = ":page=";
                cursorQ3 = this.e.Q3(this.a, this.n, this.o, this.b, -1, -1, this.p, this.r, this.s);
            }
            try {
                if (cursorQ3.moveToFirst()) {
                    Log.d(str, this.a + ":" + this.b + str2 + i2 + ":after_db:");
                    while (true) {
                        String str4 = str3;
                        arrayList = arrayList2;
                        arrayList.add(new C4064uh(cursorQ3.getString(cursorQ3.getColumnIndex("_id")), cursorQ3.getString(cursorQ3.getColumnIndex("date_")), "" + cursorQ3.getDouble(cursorQ3.getColumnIndex("amount")), cursorQ3.getString(cursorQ3.getColumnIndex(str4)) != null ? cursorQ3.getString(cursorQ3.getColumnIndex(str4)) : "", this.f[cursorQ3.getInt(cursorQ3.getColumnIndex("_in"))], this.e.O7(cursorQ3.getDouble(cursorQ3.getColumnIndex("net_bal"))), cursorQ3.getString(cursorQ3.getColumnIndex("param1")), cursorQ3.getString(cursorQ3.getColumnIndex("curr_name")), cursorQ3.getString(cursorQ3.getColumnIndex("bill_id")), cursorQ3.getString(cursorQ3.getColumnIndex("org_remarks")), cursorQ3.getString(cursorQ3.getColumnIndex("p_id")), cursorQ3.getString(cursorQ3.getColumnIndex("other_account")), cursorQ3.getString(cursorQ3.getColumnIndex("doc_type")), cursorQ3.getString(cursorQ3.getColumnIndex("p_acc_id")), this.e.nc(cursorQ3.getString(cursorQ3.getColumnIndex("param2")))));
                        if (!cursorQ3.moveToNext()) {
                            break;
                        }
                        str3 = str4;
                        arrayList2 = arrayList;
                    }
                    Log.d(str, this.a + ":" + this.b + str2 + i2 + ":after_db=" + arrayList.size());
                } else {
                    arrayList = arrayList2;
                }
                cursorQ3.close();
                if (this.p != 1 || this.r != 1 || arrayList.size() <= 0 || this.s.length() <= 0) {
                    z = false;
                } else {
                    z = false;
                    C4064uh c4064uh = (C4064uh) arrayList.get(0);
                    if (c4064uh.q().equals("0")) {
                        if (!(c4064uh.p() + "|" + c4064uh.n() + "|" + c4064uh.r() + "|" + c4064uh.f()).contains(this.s)) {
                            arrayList.remove(0);
                        }
                    }
                }
                int i4 = this.q;
                if (i4 == -2) {
                    listK = new C0769Nh().k(arrayList, this.t, this.u);
                } else {
                    listK = ((i4 != 1 && i4 != 3 && i4 != 6) || this.e.ja("prefPrintSort", true) || this.e.ja("pref_print_all_curr", z)) ? arrayList : new C0769Nh().k(arrayList, 1, 2);
                }
                this.e.z0("delete from transactions_tmp");
                return listK;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQ3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.paging.PagingSource
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Integer getRefreshKey(PagingState pagingState) {
        return null;
    }

    @Override // androidx.paging.rxjava3.RxPagingSource
    public BQ loadSingle(PagingSource.LoadParams loadParams) {
        try {
            final int iIntValue = loadParams.getKey() == null ? 1 : ((Integer) loadParams.getKey()).intValue();
            final int i = C2160f10.l;
            return BQ.b(new Callable() { // from class: Wh
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.e(i, iIntValue);
                }
            }).g(IN.c()).d(new InterfaceC0777Np() { // from class: Xh
                @Override // defpackage.InterfaceC0777Np
                public final Object apply(Object obj) {
                    return this.a.f(iIntValue, (List) obj);
                }
            }).e(new C0718Lh());
        } catch (Exception e) {
            return BQ.c(new PagingSource.LoadResult.Error(e));
        }
    }
}
