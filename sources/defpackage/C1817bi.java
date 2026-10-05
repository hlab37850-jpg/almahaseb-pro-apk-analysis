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

/* JADX INFO: renamed from: bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1817bi extends RxPagingSource {
    public static double t;
    public String a;
    public int c;
    public Z00 d;
    public Context i;
    public int j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public String p;
    public int q;
    public int r;
    public String b = CSS.Value.PERCENTAGE;
    public int[] e = {R.drawable.up, 1, R.drawable.down};
    public MutableLiveData f = new MutableLiveData();
    public MutableLiveData g = new MutableLiveData();
    public MutableLiveData h = new MutableLiveData();
    public int s = 0;

    public C1817bi(Context context, String str, int i, Z00 z00, String str2, String str3, int i2, int i3, int i4, int i5, String str4, int i6, int i7) {
        this.c = 0;
        this.i = context;
        this.a = str;
        this.j = i;
        this.d = z00;
        this.c = i2;
        this.m = i3;
        this.k = str2;
        this.l = str3;
        this.n = i4;
        this.o = i5;
        this.p = str4;
        this.q = i6;
        this.r = i7;
        Log.d("trace_Data_Loader2:=", "Data_Loader:" + str + ":" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public PagingSource.LoadResult f(List list, int i) {
        Log.d("trace_2_toLoadResult=", "" + list.size() + ":" + i);
        if (list.size() == 0 || this.m == 1 || this.n > 0 || list.size() < C2160f10.l) {
            return new PagingSource.LoadResult.Page(list, i == 1 ? null : Integer.valueOf(i), null);
        }
        return new PagingSource.LoadResult.Page(list, i != 1 ? Integer.valueOf(i - 1) : null, Integer.valueOf(i + 1));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:108:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:110:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List e(int i, int i2) throws Throwable {
        ArrayList arrayList;
        String str;
        String str2;
        Cursor cursorW4;
        ArrayList arrayList2;
        String str3;
        String str4;
        C0566Hd c0566Hd;
        Cursor cursorV4;
        C0566Hd c0566Hd2;
        ArrayList arrayList3;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i3 = (i2 - 1) * i;
        t = 0.0d;
        Log.d("trace_2getItemsInPage3:", this.j + ":" + this.c + ":page=" + i2 + ":limit=" + i + ":offset=" + i3);
        ArrayList arrayList4 = new ArrayList();
        C0566Hd c0566Hd3 = new C0566Hd();
        ?? r2 = (this.m == 1 || this.n > 0) ? 0 : 1;
        ?? r16 = 0;
        Cursor cursor = null;
        try {
            Log.d("trace_2getItemsInPage3:", this.j + ":" + this.c + ":page=" + i2 + ":before_db:query_flag=" + this.o + ":do_action=" + this.n + ":adv_search=" + this.m);
            int i4 = this.c;
            String str11 = "user_name";
            try {
                if (i4 != 10) {
                    String str12 = str11;
                    String str13 = "p_date";
                    String str14 = "p_ref_no";
                    String str15 = "curr_name";
                    String str16 = "p_amount";
                    if (i4 != 11) {
                        arrayList = arrayList4;
                        String str17 = "p_ref_no";
                        String str18 = str12;
                        String str19 = str15;
                        if (i4 == 12) {
                            if (r2 != 0) {
                                str2 = str16;
                                str = "p_date";
                                cursorW4 = this.d.W4(this.k, this.l, i, i3, this.o, this.p);
                            } else {
                                str = "p_date";
                                str2 = str16;
                                cursorW4 = this.d.W4(this.k, this.l, -1, -1, this.o, this.p);
                            }
                            Log.d("trace_Data_Loader:=", "before_db:" + this.a + "");
                            Log.d("trace_Data_Loader:=", "after_db:" + this.a + "");
                            t = 0.0d;
                            arrayList.clear();
                            Log.d("trace_Data_Loader:=", "before_loop:" + this.a + "");
                            if (cursorW4.moveToFirst()) {
                                while (true) {
                                    String string = cursorW4.getString(c0566Hd3.b(cursorW4, "_id"));
                                    String str20 = str17;
                                    String string2 = cursorW4.getString(c0566Hd3.b(cursorW4, str20));
                                    String string3 = cursorW4.getString(c0566Hd3.b(cursorW4, str));
                                    String str21 = str2;
                                    String str22 = str19;
                                    arrayList2 = arrayList;
                                    arrayList2.add(new C4145vh(string, string2, string3, this.d.P7(String.valueOf(Math.abs(cursorW4.getDouble(c0566Hd3.b(cursorW4, str21))))), cursorW4.getString(c0566Hd3.b(cursorW4, "p_remarks")), cursorW4.getString(c0566Hd3.b(cursorW4, str22)), "", "", "", "", "", "", cursorW4.getString(cursorW4.getColumnIndex("dev_id")), cursorW4.getString(cursorW4.getColumnIndex("tr_type"))));
                                    String str23 = str18;
                                    if (c0566Hd3.b(cursorW4, str23) > 0) {
                                        ((C4145vh) arrayList2.get(arrayList2.size() - 1)).i = cursorW4.getString(c0566Hd3.b(cursorW4, str23));
                                    }
                                    if (!cursorW4.moveToNext()) {
                                        break;
                                    }
                                    str18 = str23;
                                    str17 = str20;
                                    str19 = str22;
                                    str2 = str21;
                                    arrayList = arrayList2;
                                }
                            } else {
                                arrayList2 = arrayList;
                            }
                            c0566Hd3.a();
                            cursorW4.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (this.n != -2) {
                            return arrayList2;
                        }
                        int i5 = this.c;
                        return (i5 != 11 || i5 == 12) ? new C0340Ah().h(arrayList2, this.q, this.r) : new C0340Ah().g(arrayList2, this.q, this.r);
                    }
                    if (r2 != 0) {
                        str3 = "after_db:";
                        str4 = "";
                        c0566Hd = c0566Hd3;
                        cursorV4 = this.d.V4(this.a, this.k, this.l, i, i3, this.o, this.p);
                    } else {
                        str3 = "after_db:";
                        str4 = "";
                        c0566Hd = c0566Hd3;
                        cursorV4 = this.d.V4(this.a, this.k, this.l, -1, -1, this.o, this.p);
                    }
                    Log.d("trace_Data_Loader:=", "before_db:" + this.a + str4);
                    Log.d("trace_Data_Loader:=", str3 + this.a + str4);
                    t = 0.0d;
                    arrayList4.clear();
                    Log.d("trace_Data_Loader:=", "before_loop:" + this.a + str4);
                    if (cursorV4.moveToFirst()) {
                        while (true) {
                            String string4 = cursorV4.getString(c0566Hd.b(cursorV4, "_id"));
                            String str24 = str14;
                            String string5 = cursorV4.getString(c0566Hd.b(cursorV4, str24));
                            String str25 = str13;
                            String string6 = cursorV4.getString(c0566Hd.b(cursorV4, str25));
                            StringBuilder sb = new StringBuilder();
                            sb.append(str4);
                            String str26 = str16;
                            sb.append(cursorV4.getDouble(c0566Hd.b(cursorV4, str26)));
                            String str27 = str15;
                            arrayList = arrayList4;
                            arrayList.add(new C4145vh(string4, string5, string6, sb.toString(), cursorV4.getString(c0566Hd.b(cursorV4, "p_remarks")), cursorV4.getString(c0566Hd.b(cursorV4, "doc_type")) + "-" + cursorV4.getString(c0566Hd.b(cursorV4, "cash_name")), cursorV4.getString(c0566Hd.b(cursorV4, str27)), cursorV4.getString(c0566Hd.b(cursorV4, "doc_type")), str4 + cursorV4.getDouble(c0566Hd.b(cursorV4, str26)), cursorV4.getString(c0566Hd.b(cursorV4, "cash_name")), cursorV4.getString(c0566Hd.b(cursorV4, str27)), cursorV4.getString(c0566Hd.b(cursorV4, "online")), cursorV4.getString(cursorV4.getColumnIndex("dev_id")), cursorV4.getString(cursorV4.getColumnIndex("tr_type"))));
                            String str28 = str12;
                            if (c0566Hd.b(cursorV4, str28) > 0) {
                                ((C4145vh) arrayList.get(arrayList.size() - 1)).i = cursorV4.getString(c0566Hd.b(cursorV4, str28));
                            }
                            if (c0566Hd.b(cursorV4, "acc_name") > 0) {
                                ((C4145vh) arrayList.get(arrayList.size() - 1)).j = cursorV4.getString(c0566Hd.b(cursorV4, "acc_name"));
                            }
                            if (!cursorV4.moveToNext()) {
                                break;
                            }
                            str12 = str28;
                            arrayList4 = arrayList;
                            str15 = str27;
                            str16 = str26;
                            str13 = str25;
                            str14 = str24;
                        }
                    } else {
                        arrayList = arrayList4;
                    }
                    c0566Hd.a();
                    cursorV4.close();
                    cursor = cursorV4;
                    arrayList2 = arrayList;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (this.n != -2) {
                        return arrayList2;
                    }
                    int i6 = this.c;
                    if (i6 != 11) {
                    }
                }
                String str29 = CSS.Value.PERCENTAGE;
                if (r2 != 0) {
                    int i7 = this.j;
                    if (i7 == 8 || i7 == 9) {
                        c0566Hd2 = c0566Hd3;
                        arrayList3 = arrayList4;
                        str5 = ":page=";
                        str6 = "z_status";
                        str7 = "_id";
                        str8 = "";
                        str9 = "trace_2getItemsInPage3:";
                        cursorW4 = this.d.U1(this.a.equals("0") ? CSS.Value.PERCENTAGE : this.a, this.j, 2, this.k, this.l, CSS.Value.PERCENTAGE, i, i3, this.o, this.p);
                    } else {
                        str6 = "z_status";
                        str7 = "_id";
                        c0566Hd2 = c0566Hd3;
                        str5 = ":page=";
                        arrayList3 = arrayList4;
                        str8 = "";
                        str9 = "trace_2getItemsInPage3:";
                        cursorW4 = this.d.h2(this.a.equals("0") ? CSS.Value.PERCENTAGE : this.a, this.j, 2, this.k, this.l, CSS.Value.PERCENTAGE, i, i3, this.o, this.p);
                    }
                } else {
                    c0566Hd2 = c0566Hd3;
                    arrayList3 = arrayList4;
                    str5 = ":page=";
                    str6 = "z_status";
                    str7 = "_id";
                    str8 = "";
                    str9 = "trace_2getItemsInPage3:";
                    int i8 = this.j;
                    if (i8 == 8 || i8 == 9) {
                        Z00 z00 = this.d;
                        if (!this.a.equals("0")) {
                            str29 = this.a;
                        }
                        cursorW4 = z00.U1(str29, this.j, 2, this.k, this.l, CSS.Value.PERCENTAGE, -1, -1, this.o, this.p);
                    } else {
                        Z00 z01 = this.d;
                        if (!this.a.equals("0")) {
                            str29 = this.a;
                        }
                        cursorW4 = z01.h2(str29, this.j, 2, this.k, this.l, CSS.Value.PERCENTAGE, -1, -1, this.o, this.p);
                    }
                }
                if (cursorW4.moveToFirst()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.a);
                    sb2.append(":");
                    sb2.append(this.c);
                    String str30 = str5;
                    sb2.append(str30);
                    sb2.append(i2);
                    sb2.append(":after_db:");
                    Log.d(str9, sb2.toString());
                    while (true) {
                        C0566Hd c0566Hd4 = c0566Hd2;
                        String string7 = cursorW4.getString(c0566Hd4.b(cursorW4, str7));
                        String string8 = cursorW4.getString(c0566Hd4.b(cursorW4, "f10"));
                        String string9 = cursorW4.getString(c0566Hd4.b(cursorW4, "f1"));
                        String string10 = cursorW4.getString(c0566Hd4.b(cursorW4, "f5"));
                        String string11 = cursorW4.getString(c0566Hd4.b(cursorW4, "f7"));
                        StringBuilder sb3 = new StringBuilder();
                        String str31 = str8;
                        sb3.append(str31);
                        sb3.append(cursorW4.getDouble(c0566Hd4.b(cursorW4, "f3")));
                        arrayList2 = arrayList3;
                        arrayList2.add(new C4145vh(string7, string8, string9, string10, string11, sb3.toString(), cursorW4.getString(c0566Hd4.b(cursorW4, "f9")), cursorW4.getString(c0566Hd4.b(cursorW4, "f2")), cursorW4.getString(c0566Hd4.b(cursorW4, "f8")), cursorW4.getString(c0566Hd4.b(cursorW4, "f4")), cursorW4.getString(c0566Hd4.b(cursorW4, "f6")), cursorW4.getString(c0566Hd4.b(cursorW4, "f11")), cursorW4.getString(c0566Hd4.b(cursorW4, "f12")), cursorW4.getString(c0566Hd4.b(cursorW4, "f13")), cursorW4.getString(c0566Hd4.b(cursorW4, "f14")), cursorW4.getString(c0566Hd4.b(cursorW4, "f15")), cursorW4.getString(c0566Hd4.b(cursorW4, "f16")), cursorW4.getString(c0566Hd4.b(cursorW4, "f17")), cursorW4.getString(c0566Hd4.b(cursorW4, "f18")), cursorW4.getString(c0566Hd4.b(cursorW4, "f19"))));
                        String str32 = str11;
                        if (c0566Hd4.b(cursorW4, str32) > 0) {
                            ((C4145vh) arrayList2.get(arrayList2.size() - 1)).i = cursorW4.getString(c0566Hd4.b(cursorW4, str32));
                        }
                        if (this.j == 1) {
                            str10 = str6;
                            if (c0566Hd4.b(cursorW4, str10) > 0) {
                                ((C4145vh) arrayList2.get(arrayList2.size() - 1)).k = cursorW4.getString(c0566Hd4.b(cursorW4, str10));
                                ((C4145vh) arrayList2.get(arrayList2.size() - 1)).l = cursorW4.getString(c0566Hd4.b(cursorW4, "xml_file"));
                            }
                        } else {
                            str10 = str6;
                        }
                        if (!cursorW4.moveToNext()) {
                            break;
                        }
                        str6 = str10;
                        str11 = str32;
                        arrayList3 = arrayList2;
                        str8 = str31;
                        c0566Hd2 = c0566Hd4;
                    }
                    Log.d(str9, this.a + ":" + this.c + str30 + i2 + ":after_db=" + arrayList2.size());
                } else {
                    arrayList2 = arrayList3;
                }
                cursor = cursorW4;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.n != -2) {
                    return arrayList2;
                }
                int i9 = this.c;
                if (i9 != 11) {
                }
            } catch (Throwable th) {
                th = th;
                r16 = r2;
                if (r16 != 0) {
                    r16.close();
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
            return BQ.b(new Callable() { // from class: Zh
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.e(i, iIntValue);
                }
            }).g(IN.c()).d(new InterfaceC0777Np() { // from class: ai
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
