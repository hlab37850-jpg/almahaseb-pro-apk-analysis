package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: Mh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0743Mh extends RxPagingSource {
    public static String j = null;
    public static String k = null;
    public static Z00 l = null;
    public static Context m = null;
    public static String n = "";
    public static String o = "";
    public static int p;
    public int[] a = {R.drawable.up, 1, R.drawable.down};
    public MutableLiveData b = new MutableLiveData();
    public MutableLiveData c = new MutableLiveData();
    public ProgressDialog d;
    public int e;
    public int f;
    public String g;
    public int h;
    public int i;

    public C0743Mh(Context context, String str, String str2, Z00 z00, String str3, String str4, int i, int i2, int i3, String str5, int i4, int i5) {
        m = context;
        j = str;
        l = z00;
        n = str3;
        o = str4;
        p = i;
        this.f = i3;
        this.g = str5;
        this.e = i2;
        k = str2;
        this.h = i4;
        this.i = i5;
        this.d = new ProgressDialog(context);
        Log.d("Data_Loader:=", "Data_Loader:" + str + ":" + str2);
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List e(int i, int i2) throws Throwable {
        int i3 = (i2 - 1) * i;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Log.d("trace_2getItemsInPage:", j + ":" + k + ":page=" + i2 + ":before_db:query_flag=" + this.f + ":do_action=" + this.e + ":curr=" + Z00.Z + ":f_date=" + n + ":t_date=" + o + ":adv_search=" + p + ":do_action=" + this.e + ":limit=" + i + ":offset=" + i3);
            int i4 = p;
            Cursor cursorV3 = (i4 == 1 || this.e > 0) ? l.V3(n, o, k, -1, -1, i4, this.f, this.g) : l.V3(n, o, k, i, i3, i4, this.f, this.g);
            try {
                if (cursorV3.moveToFirst()) {
                    Log.d("trace_2getItemsInPage:", j + ":" + k + ":page=" + i2 + ":after_db:");
                    do {
                        arrayList.add(new C0795Oh(cursorV3.getString(cursorV3.getColumnIndex("_id")), cursorV3.getString(cursorV3.getColumnIndex("date_")), "" + cursorV3.getDouble(cursorV3.getColumnIndex("amount")), cursorV3.getString(cursorV3.getColumnIndex("remarks")), this.a[cursorV3.getInt(cursorV3.getColumnIndex("_in"))], cursorV3.getString(cursorV3.getColumnIndex("name")), cursorV3.getString(cursorV3.getColumnIndex("bill_id")), cursorV3.getString(cursorV3.getColumnIndex("org_remarks")), cursorV3.getString(cursorV3.getColumnIndex("p_id")), cursorV3.getString(cursorV3.getColumnIndex("doc_type")), cursorV3.getString(cursorV3.getColumnIndex("p_acc_id"))));
                    } while (cursorV3.moveToNext());
                }
                Log.d("trace_2getItemsInPage:", j + ":" + k + ":page=" + i2 + ":after_db=" + arrayList.size());
                cursorV3.close();
                return this.e == -2 ? new C0821Ph().k(arrayList, this.h, this.i) : arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = cursorV3;
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

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final PagingSource.LoadResult f(List list, int i) {
        Log.d("trace_2_toLoadResult=", "" + list.size() + ":" + i);
        if (list.size() == 0 || p == 1 || this.e > 0 || list.size() < C2160f10.l) {
            return new PagingSource.LoadResult.Page(list, i == 1 ? null : Integer.valueOf(i), null);
        }
        return new PagingSource.LoadResult.Page(list, i != 1 ? Integer.valueOf(i - 1) : null, Integer.valueOf(i + 1));
    }

    @Override // androidx.paging.rxjava3.RxPagingSource
    public BQ loadSingle(PagingSource.LoadParams loadParams) {
        try {
            final int iIntValue = loadParams.getKey() == null ? 1 : ((Integer) loadParams.getKey()).intValue();
            final int i = C2160f10.l;
            return BQ.b(new Callable() { // from class: Jh
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.e(i, iIntValue);
                }
            }).g(IN.c()).d(new InterfaceC0777Np() { // from class: Kh
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
