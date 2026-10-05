package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: renamed from: Sh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0908Sh extends AsyncTaskLoader {
    public static double n;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public Z00 k;
    public int[] l;
    public int m;

    public C0908Sh(Context context, String str, String str2, String str3, Z00 z00, int i) {
        super(context);
        this.g = CSS.Value.PERCENTAGE;
        this.h = CSS.Value.PERCENTAGE;
        this.i = CSS.Value.PERCENTAGE;
        this.l = new int[]{R.drawable.up, 1, R.drawable.down};
        this.m = 0;
        this.a = str;
        this.k = z00;
        this.j = i;
        this.b = str2;
        this.c = str3;
        Log.d("Data_Loader:=", "Data_Loader:" + str + ":" + str2 + ":" + str3);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        String str;
        ArrayList arrayList;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Cursor cursorU1;
        Cursor cursorU2;
        ArrayList arrayList2 = new ArrayList();
        int i = this.j;
        String str8 = "f4";
        String str9 = "f2";
        String str10 = "f8";
        String str11 = "_id";
        if (i == 1) {
            if (!this.h.equals(CSS.Value.PERCENTAGE) && this.k.ia("pref_cost_avg", "1").equals("2")) {
                new C2160f10(this.k).W(this.h);
            } else if (!this.k.ja("recreate_items_cost_calc", false)) {
                this.k.Vb();
                this.k.Mc("recreate_items_cost_calc", true);
            }
            Cursor cursorB7 = this.k.b7(this.a, this.g, this.h, this.i);
            Log.d("Data_Loader:=", "before_db:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
            cursorB7.moveToFirst();
            Log.d("Data_Loader:=", "after_db:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
            n = 0.0d;
            arrayList2.clear();
            Log.d("Data_Loader:=", "before_loop:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
            C0566Hd c0566Hd = new C0566Hd();
            while (!cursorB7.isAfterLast()) {
                String str12 = str10;
                arrayList2.add(new C4145vh(cursorB7.getString(c0566Hd.b(cursorB7, "_id")), cursorB7.getString(c0566Hd.b(cursorB7, "f1")), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, "f2")))), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, "f4")))), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, "f5")))), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, "f3")))), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, "f6")))), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, "f7")))), this.k.P7(String.valueOf(cursorB7.getDouble(c0566Hd.b(cursorB7, str12)))), "", cursorB7.getString(c0566Hd.b(cursorB7, "f10"))));
                cursorB7.moveToNext();
                str10 = str12;
            }
            c0566Hd.a();
            cursorB7.close();
        } else {
            String str13 = "f5";
            String str14 = "f6";
            String str15 = str10;
            String str16 = "f3";
            String str17 = "f7";
            String str18 = "f10";
            if (i != 9) {
                if (i == 13) {
                    Cursor cursorT4 = this.k.t4(this.a, this.c);
                    Log.d("Data_Loader:=", "before_db:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
                    cursorT4.moveToFirst();
                    Log.d("Data_Loader:=", "after_db:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
                    n = 0.0d;
                    arrayList2.clear();
                    Log.d("Data_Loader:=", "before_loop:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
                    C0566Hd c0566Hd2 = new C0566Hd();
                    while (!cursorT4.isAfterLast()) {
                        arrayList2.add(new C4145vh(cursorT4.getString(c0566Hd2.b(cursorT4, "_id")), cursorT4.getString(c0566Hd2.b(cursorT4, "f1")), cursorT4.getString(c0566Hd2.b(cursorT4, "f2")), cursorT4.getString(c0566Hd2.b(cursorT4, str16)), cursorT4.getString(c0566Hd2.b(cursorT4, "f4")), cursorT4.getString(c0566Hd2.b(cursorT4, str13)), "", "", ""));
                        cursorT4.moveToNext();
                    }
                    c0566Hd2.a();
                    cursorT4.close();
                } else {
                    if (i == 4) {
                        try {
                            str = ":";
                            try {
                                String str19 = "f13";
                                Cursor cursorD7 = this.k.d7(this.e, this.d, this.g, this.h);
                                cursorD7.moveToFirst();
                                n = 0.0d;
                                arrayList2.clear();
                                C0566Hd c0566Hd3 = new C0566Hd();
                                while (!cursorD7.isAfterLast()) {
                                    String string = cursorD7.getString(c0566Hd3.b(cursorD7, "_id"));
                                    String string2 = cursorD7.getString(c0566Hd3.b(cursorD7, "f1"));
                                    String string3 = cursorD7.getString(c0566Hd3.b(cursorD7, str9));
                                    String string4 = cursorD7.getString(c0566Hd3.b(cursorD7, str16));
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("");
                                    String str20 = str8;
                                    String str21 = str9;
                                    sb.append(cursorD7.getDouble(c0566Hd3.b(cursorD7, str8)));
                                    String string5 = sb.toString();
                                    String str22 = "" + cursorD7.getDouble(c0566Hd3.b(cursorD7, str13));
                                    String str23 = "" + cursorD7.getDouble(c0566Hd3.b(cursorD7, str14));
                                    String str24 = str17;
                                    String string6 = cursorD7.getString(c0566Hd3.b(cursorD7, str24));
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("");
                                    String str25 = str15;
                                    String str26 = str13;
                                    sb2.append(cursorD7.getDouble(c0566Hd3.b(cursorD7, str25)));
                                    String string7 = sb2.toString();
                                    String str27 = "" + cursorD7.getDouble(c0566Hd3.b(cursorD7, "f9"));
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("");
                                    String str28 = str18;
                                    str18 = str28;
                                    sb3.append(cursorD7.getDouble(c0566Hd3.b(cursorD7, str28)));
                                    String string8 = sb3.toString();
                                    String str29 = str19;
                                    arrayList2.add(new C4145vh(string, string2, string3, string4, string5, str22, str23, string6, string7, str27, string8, "" + cursorD7.getDouble(c0566Hd3.b(cursorD7, "f11")), cursorD7.getString(c0566Hd3.b(cursorD7, "f12")), cursorD7.getString(c0566Hd3.b(cursorD7, str29)), cursorD7.getString(c0566Hd3.b(cursorD7, "id2"))));
                                    cursorD7.moveToNext();
                                    str17 = str24;
                                    str19 = str29;
                                    str13 = str26;
                                    str8 = str20;
                                    str15 = str25;
                                    str9 = str21;
                                }
                                cursorD7.close();
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = ":";
                        }
                    } else {
                        str = ":";
                        String str30 = "f4";
                        String str31 = "f2";
                        String str32 = str13;
                        String str33 = str17;
                        if (i == 41) {
                            try {
                                if (!this.h.equals(CSS.Value.PERCENTAGE) && this.k.ia("pref_cost_avg", "1").equals("2")) {
                                    new C2160f10(this.k).W(this.h);
                                } else if (!this.k.ja("recreate_items_cost_calc", false)) {
                                    this.k.Vb();
                                    this.k.Mc("recreate_items_cost_calc", true);
                                }
                                Cursor cursorE7 = this.k.e7(this.d, this.g, this.h);
                                cursorE7.moveToFirst();
                                n = 0.0d;
                                arrayList2.clear();
                                C0566Hd c0566Hd4 = new C0566Hd();
                                while (!cursorE7.isAfterLast()) {
                                    String string9 = cursorE7.getString(c0566Hd4.b(cursorE7, str11));
                                    String string10 = cursorE7.getString(c0566Hd4.b(cursorE7, "f1"));
                                    String str34 = str31;
                                    String string11 = cursorE7.getString(c0566Hd4.b(cursorE7, str34));
                                    String string12 = cursorE7.getString(c0566Hd4.b(cursorE7, str16));
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("");
                                    String str35 = str16;
                                    String str36 = str11;
                                    String str37 = str30;
                                    str30 = str37;
                                    sb4.append(cursorE7.getDouble(c0566Hd4.b(cursorE7, str37)));
                                    String string13 = sb4.toString();
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("");
                                    String str38 = str32;
                                    str31 = str34;
                                    sb5.append(cursorE7.getDouble(c0566Hd4.b(cursorE7, str38)));
                                    String string14 = sb5.toString();
                                    String str39 = "" + cursorE7.getDouble(c0566Hd4.b(cursorE7, str14));
                                    String string15 = cursorE7.getString(c0566Hd4.b(cursorE7, str33));
                                    String str40 = "" + cursorE7.getDouble(c0566Hd4.b(cursorE7, str15));
                                    String str41 = "" + cursorE7.getDouble(c0566Hd4.b(cursorE7, "f9"));
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("");
                                    String str42 = str18;
                                    str18 = str42;
                                    sb6.append(cursorE7.getDouble(c0566Hd4.b(cursorE7, str42)));
                                    arrayList2.add(new C4145vh(string9, string10, string11, string12, string13, string14, str39, string15, str40, str41, sb6.toString(), "" + cursorE7.getDouble(c0566Hd4.b(cursorE7, "f11")), cursorE7.getString(c0566Hd4.b(cursorE7, "f12")), cursorE7.getString(c0566Hd4.b(cursorE7, "f13"))));
                                    cursorE7.moveToNext();
                                    str32 = str38;
                                    str11 = str36;
                                    str16 = str35;
                                }
                                cursorE7.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            String str43 = str16;
                            String str44 = "_id";
                            String str45 = str32;
                            if (i == 42) {
                                try {
                                    if (!this.h.equals(CSS.Value.PERCENTAGE) && this.k.ia("pref_cost_avg", "1").equals("2")) {
                                        new C2160f10(this.k).W(this.h);
                                    } else if (!this.k.ja("recreate_items_cost_calc", false)) {
                                        this.k.Vb();
                                        this.k.Mc("recreate_items_cost_calc", true);
                                    }
                                    Cursor cursorG7 = this.k.g7(this.d, this.g, this.h, "");
                                    cursorG7.moveToFirst();
                                    n = 0.0d;
                                    arrayList2.clear();
                                    C0566Hd c0566Hd5 = new C0566Hd();
                                    while (!cursorG7.isAfterLast()) {
                                        if (cursorG7.getDouble(c0566Hd5.b(cursorG7, str45)) != 0.0d) {
                                            str7 = str31;
                                            str6 = str30;
                                            str5 = str43;
                                            str4 = str18;
                                            arrayList2.add(new C4145vh(cursorG7.getString(c0566Hd5.b(cursorG7, HTML.Attribute.ID)), cursorG7.getString(c0566Hd5.b(cursorG7, "f1")), cursorG7.getString(c0566Hd5.b(cursorG7, "f11")), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str7)))), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str6)))), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str45)))), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str5)))), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str14)))), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str33)))), this.k.P7(String.valueOf(cursorG7.getDouble(c0566Hd5.b(cursorG7, str15)))), cursorG7.getString(c0566Hd5.b(cursorG7, str4))));
                                        } else {
                                            str4 = str18;
                                            str5 = str43;
                                            str6 = str30;
                                            str7 = str31;
                                        }
                                        cursorG7.moveToNext();
                                        str18 = str4;
                                        str30 = str6;
                                        str43 = str5;
                                        str31 = str7;
                                    }
                                    cursorG7.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            } else {
                                String str46 = str43;
                                String str47 = str30;
                                String str48 = str31;
                                if (i == 43) {
                                    try {
                                        String str49 = "f13";
                                        String str50 = "f11";
                                        String str51 = str18;
                                        String str52 = str15;
                                        Cursor cursorF7 = this.k.f7(this.e, this.d, this.f, this.g, this.h);
                                        cursorF7.moveToFirst();
                                        n = 0.0d;
                                        arrayList2.clear();
                                        C0566Hd c0566Hd6 = new C0566Hd();
                                        while (!cursorF7.isAfterLast()) {
                                            String str53 = str44;
                                            String string16 = cursorF7.getString(c0566Hd6.b(cursorF7, str53));
                                            String string17 = cursorF7.getString(c0566Hd6.b(cursorF7, "f1"));
                                            String string18 = cursorF7.getString(c0566Hd6.b(cursorF7, str48));
                                            String string19 = cursorF7.getString(c0566Hd6.b(cursorF7, str46));
                                            String str54 = "" + cursorF7.getDouble(c0566Hd6.b(cursorF7, str47));
                                            String str55 = "" + cursorF7.getDouble(c0566Hd6.b(cursorF7, str45));
                                            String str56 = "" + cursorF7.getDouble(c0566Hd6.b(cursorF7, str14));
                                            String string20 = cursorF7.getString(c0566Hd6.b(cursorF7, str33));
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append("");
                                            String str57 = str52;
                                            String str58 = str14;
                                            String str59 = str47;
                                            sb7.append(cursorF7.getDouble(c0566Hd6.b(cursorF7, str57)));
                                            String string21 = sb7.toString();
                                            String str60 = "" + cursorF7.getDouble(c0566Hd6.b(cursorF7, "f9"));
                                            StringBuilder sb8 = new StringBuilder();
                                            sb8.append("");
                                            String str61 = str51;
                                            sb8.append(cursorF7.getDouble(c0566Hd6.b(cursorF7, str61)));
                                            String string22 = sb8.toString();
                                            StringBuilder sb9 = new StringBuilder();
                                            sb9.append("");
                                            String str62 = str50;
                                            str50 = str62;
                                            sb9.append(cursorF7.getDouble(c0566Hd6.b(cursorF7, str62)));
                                            String str63 = str49;
                                            arrayList2.add(new C4145vh(string16, string17, string18, string19, str54, str55, str56, string20, string21, str60, string22, sb9.toString(), cursorF7.getString(c0566Hd6.b(cursorF7, "f12")), cursorF7.getString(c0566Hd6.b(cursorF7, str63))));
                                            cursorF7.moveToNext();
                                            str49 = str63;
                                            str51 = str61;
                                            str52 = str57;
                                            str48 = str48;
                                            str14 = str58;
                                            str47 = str59;
                                            str44 = str53;
                                        }
                                        cursorF7.close();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                } else {
                                    String str64 = str14;
                                    String str65 = str18;
                                    String str66 = "f11";
                                    String str67 = "f13";
                                    if (i == 2 || i == 3) {
                                        arrayList = arrayList2;
                                        str2 = str;
                                        str3 = "Data_Loader:=";
                                        Cursor cursorI2 = this.k.i2(i - 1, 2, this.a, this.b, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
                                        Log.d(str3, "before_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                        cursorI2.moveToFirst();
                                        Log.d(str3, "after_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                        n = 0.0d;
                                        arrayList.clear();
                                        Log.d(str3, "before_loop:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                        C0566Hd c0566Hd7 = new C0566Hd();
                                        while (!cursorI2.isAfterLast()) {
                                            arrayList.add(new C4145vh(cursorI2.getString(c0566Hd7.b(cursorI2, str44)), cursorI2.getString(c0566Hd7.b(cursorI2, "f1")), cursorI2.getString(c0566Hd7.b(cursorI2, str45)), cursorI2.getString(c0566Hd7.b(cursorI2, str33)), this.k.P7(cursorI2.getString(c0566Hd7.b(cursorI2, str46))), this.k.P7(cursorI2.getString(c0566Hd7.b(cursorI2, str46))), cursorI2.getString(c0566Hd7.b(cursorI2, str45)), cursorI2.getString(c0566Hd7.b(cursorI2, str64)), cursorI2.getString(c0566Hd7.b(cursorI2, str15))));
                                            cursorI2.moveToNext();
                                        }
                                        c0566Hd7.a();
                                        cursorI2.close();
                                    } else if (i == 10) {
                                        int i2 = this.m;
                                        if (i2 == 8 || i2 == 9) {
                                            cursorU1 = this.k.U1(this.a.equals("0") ? CSS.Value.PERCENTAGE : this.a, this.m, 2, this.g, this.h, CSS.Value.PERCENTAGE, -1, -1, 0, "");
                                        } else {
                                            cursorU1 = this.k.h2(this.a.equals("0") ? CSS.Value.PERCENTAGE : this.a, this.m, 2, this.g, this.h, CSS.Value.PERCENTAGE, -1, -1, 0, "");
                                        }
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append("before_db:");
                                        sb10.append(this.a);
                                        str2 = str;
                                        sb10.append(str2);
                                        sb10.append(FragmentStatePagerSupport_Main.X());
                                        str3 = "Data_Loader:=";
                                        Log.d(str3, sb10.toString());
                                        cursorU1.moveToFirst();
                                        StringBuilder sb11 = new StringBuilder();
                                        String str68 = str15;
                                        sb11.append("after_db:");
                                        sb11.append(this.a);
                                        sb11.append(str2);
                                        sb11.append(FragmentStatePagerSupport_Main.X());
                                        Log.d(str3, sb11.toString());
                                        n = 0.0d;
                                        arrayList2.clear();
                                        int count = cursorU1.getCount();
                                        StringBuilder sb12 = new StringBuilder();
                                        sb12.append(count);
                                        Cursor cursor = cursorU1;
                                        sb12.append(":before_loop:");
                                        sb12.append(this.a);
                                        sb12.append(str2);
                                        sb12.append(FragmentStatePagerSupport_Main.X());
                                        Log.d(str3, sb12.toString());
                                        C0566Hd c0566Hd8 = new C0566Hd();
                                        int i3 = 0;
                                        while (i3 < count) {
                                            ArrayList arrayList3 = arrayList2;
                                            if (count >= 10000) {
                                                int i4 = this.m;
                                                if (i4 == 8 || i4 == 9) {
                                                    cursorU2 = this.k.U1(this.a.equals("0") ? CSS.Value.PERCENTAGE : this.a, this.m, 2, this.g, this.h, CSS.Value.PERCENTAGE, Constants.CP_MAC_ROMAN, i3, 0, "");
                                                } else {
                                                    cursorU2 = this.k.h2(this.a.equals("0") ? CSS.Value.PERCENTAGE : this.a, this.m, 2, this.g, this.h, CSS.Value.PERCENTAGE, Constants.CP_MAC_ROMAN, i3, 0, "");
                                                }
                                                Log.d(str3, "before_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                                cursorU2.moveToFirst();
                                                StringBuilder sb13 = new StringBuilder();
                                                sb13.append(i3);
                                                sb13.append("");
                                                Log.d("cursor_cnt=", sb13.toString());
                                            } else {
                                                str46 = str46;
                                                str33 = str33;
                                                cursorU2 = cursor;
                                            }
                                            while (!cursorU2.isAfterLast()) {
                                                n += cursorU2.getDouble(c0566Hd8.b(cursorU2, str67));
                                                String string23 = cursorU2.getString(c0566Hd8.b(cursorU2, str44));
                                                String string24 = cursorU2.getString(c0566Hd8.b(cursorU2, str65));
                                                String string25 = cursorU2.getString(c0566Hd8.b(cursorU2, "f1"));
                                                String string26 = cursorU2.getString(c0566Hd8.b(cursorU2, str45));
                                                String string27 = cursorU2.getString(c0566Hd8.b(cursorU2, str33));
                                                StringBuilder sb14 = new StringBuilder();
                                                sb14.append("");
                                                String str69 = str65;
                                                String str70 = str46;
                                                String str71 = str45;
                                                sb14.append(cursorU2.getDouble(c0566Hd8.b(cursorU2, str70)));
                                                String str72 = str68;
                                                String str73 = str64;
                                                String str74 = str66;
                                                ArrayList arrayList4 = arrayList3;
                                                arrayList4.add(new C4145vh(string23, string24, string25, string26, string27, sb14.toString(), cursorU2.getString(c0566Hd8.b(cursorU2, "f9")), cursorU2.getString(c0566Hd8.b(cursorU2, str48)), cursorU2.getString(c0566Hd8.b(cursorU2, str72)), cursorU2.getString(c0566Hd8.b(cursorU2, str47)), cursorU2.getString(c0566Hd8.b(cursorU2, str73)), cursorU2.getString(c0566Hd8.b(cursorU2, str74)), cursorU2.getString(c0566Hd8.b(cursorU2, "f12")), cursorU2.getString(c0566Hd8.b(cursorU2, str67)), cursorU2.getString(c0566Hd8.b(cursorU2, "f14")), cursorU2.getString(c0566Hd8.b(cursorU2, "f15")), cursorU2.getString(c0566Hd8.b(cursorU2, "f16")), cursorU2.getString(c0566Hd8.b(cursorU2, "f17")), cursorU2.getString(c0566Hd8.b(cursorU2, "f18")), cursorU2.getString(c0566Hd8.b(cursorU2, "f19"))));
                                                if (cursorU2.getColumnIndex("user_name") > 0) {
                                                    ((C4145vh) arrayList4.get(arrayList4.size() - 1)).i = cursorU2.getString(cursorU2.getColumnIndex("user_name"));
                                                }
                                                cursorU2.moveToNext();
                                                str66 = str74;
                                                str68 = str72;
                                                arrayList3 = arrayList4;
                                                str65 = str69;
                                                str45 = str71;
                                                str67 = str67;
                                                str64 = str73;
                                                str46 = str70;
                                            }
                                            i3 += Constants.CP_MAC_ROMAN;
                                            c0566Hd8.a();
                                            cursorU2.close();
                                            str65 = str65;
                                            str46 = str46;
                                            str45 = str45;
                                            cursor = cursorU2;
                                            arrayList2 = arrayList3;
                                            str64 = str64;
                                            count = count;
                                            str33 = str33;
                                        }
                                        arrayList = arrayList2;
                                    } else {
                                        arrayList = arrayList2;
                                        str2 = str;
                                        str3 = "Data_Loader:=";
                                        if (i == 11) {
                                            Cursor cursorV4 = this.k.V4(this.a, this.g, this.h, -1, -1, 0, "");
                                            Log.d(str3, "before_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            Log.d(str3, "after_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            n = 0.0d;
                                            arrayList.clear();
                                            Log.d(str3, "before_loop:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            C0566Hd c0566Hd9 = new C0566Hd();
                                            while (cursorV4.moveToNext()) {
                                                arrayList.add(new C4145vh(cursorV4.getString(c0566Hd9.b(cursorV4, str44)), cursorV4.getString(c0566Hd9.b(cursorV4, "p_ref_no")), cursorV4.getString(c0566Hd9.b(cursorV4, "p_date")), "" + cursorV4.getDouble(c0566Hd9.b(cursorV4, "p_amount")), cursorV4.getString(c0566Hd9.b(cursorV4, "p_remarks")), cursorV4.getString(c0566Hd9.b(cursorV4, "doc_type")) + "-" + cursorV4.getString(c0566Hd9.b(cursorV4, "cash_name")), cursorV4.getString(c0566Hd9.b(cursorV4, "curr_name")), cursorV4.getString(c0566Hd9.b(cursorV4, "doc_type")), "" + cursorV4.getDouble(c0566Hd9.b(cursorV4, "p_amount")), cursorV4.getString(c0566Hd9.b(cursorV4, "cash_name")), cursorV4.getString(c0566Hd9.b(cursorV4, "curr_name")), cursorV4.getString(c0566Hd9.b(cursorV4, "online")), cursorV4.getString(cursorV4.getColumnIndex("dev_id"))));
                                            }
                                            c0566Hd9.a();
                                            cursorV4.close();
                                        } else if (i == 12) {
                                            Cursor cursorW4 = this.k.W4(this.g, this.h, -1, -1, 0, "");
                                            Log.d(str3, "before_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            Log.d(str3, "after_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            n = 0.0d;
                                            arrayList.clear();
                                            Log.d(str3, "before_loop:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            C0566Hd c0566Hd10 = new C0566Hd();
                                            while (cursorW4.moveToNext()) {
                                                arrayList.add(new C4145vh(cursorW4.getString(c0566Hd10.b(cursorW4, str44)), cursorW4.getString(c0566Hd10.b(cursorW4, "p_ref_no")), cursorW4.getString(c0566Hd10.b(cursorW4, "p_date")), this.k.P7(String.valueOf(Math.abs(cursorW4.getDouble(c0566Hd10.b(cursorW4, "p_amount"))))), cursorW4.getString(c0566Hd10.b(cursorW4, "p_remarks")), cursorW4.getString(c0566Hd10.b(cursorW4, "curr_name")), "", "", "", "", "", "", cursorW4.getString(cursorW4.getColumnIndex("dev_id"))));
                                            }
                                            c0566Hd10.a();
                                            cursorW4.close();
                                        } else if (i == 14) {
                                            Cursor cursorU4 = this.k.U4(this.g, this.h, -1, -1, "");
                                            Log.d(str3, "before_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            Log.d(str3, "after_db:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            n = 0.0d;
                                            arrayList.clear();
                                            Log.d(str3, "before_loop:" + this.a + str2 + FragmentStatePagerSupport_Main.X());
                                            C0566Hd c0566Hd11 = new C0566Hd();
                                            while (cursorU4.moveToNext()) {
                                                arrayList.add(new C4145vh(cursorU4.getString(c0566Hd11.b(cursorU4, str44)), cursorU4.getString(c0566Hd11.b(cursorU4, "p_ref_no")), cursorU4.getString(c0566Hd11.b(cursorU4, "p_date")), "" + cursorU4.getDouble(c0566Hd11.b(cursorU4, "p_amount")), cursorU4.getString(c0566Hd11.b(cursorU4, "p_remarks")), cursorU4.getString(c0566Hd11.b(cursorU4, "doc_type")), cursorU4.getString(c0566Hd11.b(cursorU4, "curr_name")), cursorU4.getString(c0566Hd11.b(cursorU4, "doc_type")), "" + cursorU4.getDouble(c0566Hd11.b(cursorU4, "p_amount")), cursorU4.getString(c0566Hd11.b(cursorU4, "cash_name")), cursorU4.getString(c0566Hd11.b(cursorU4, "curr_name")), cursorU4.getString(c0566Hd11.b(cursorU4, "online")), ""));
                                            }
                                            c0566Hd11.a();
                                            cursorU4.close();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    arrayList = arrayList2;
                    str2 = str;
                    str3 = "Data_Loader:=";
                }
                Log.d(str3, "after_loop:" + arrayList.size() + str2 + FragmentStatePagerSupport_Main.X());
                return arrayList;
            }
            Cursor cursorR4 = this.k.r4(this.a, this.c);
            Log.d("Data_Loader:=", "before_db:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
            cursorR4.moveToFirst();
            Log.d("Data_Loader:=", "after_db:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
            n = 0.0d;
            arrayList2.clear();
            Log.d("Data_Loader:=", "before_loop:" + this.a + ":" + FragmentStatePagerSupport_Main.X());
            C0566Hd c0566Hd12 = new C0566Hd();
            while (!cursorR4.isAfterLast()) {
                arrayList2.add(new C4145vh(cursorR4.getString(c0566Hd12.b(cursorR4, "_id")), cursorR4.getString(c0566Hd12.b(cursorR4, "f1")), cursorR4.getString(c0566Hd12.b(cursorR4, "f2")), cursorR4.getString(c0566Hd12.b(cursorR4, str16)), cursorR4.getString(c0566Hd12.b(cursorR4, "f4")), cursorR4.getString(c0566Hd12.b(cursorR4, str13)), "", "", ""));
                cursorR4.moveToNext();
            }
            c0566Hd12.a();
            cursorR4.close();
        }
        str2 = ":";
        str3 = "Data_Loader:=";
        arrayList = arrayList2;
        Log.d(str3, "after_loop:" + arrayList.size() + str2 + FragmentStatePagerSupport_Main.X());
        return arrayList;
    }

    public C0908Sh(Context context, String str, String str2, Z00 z00, String str3, String str4, int i) {
        super(context);
        this.i = CSS.Value.PERCENTAGE;
        this.l = new int[]{R.drawable.up, 1, R.drawable.down};
        this.m = 0;
        this.a = str;
        this.k = z00;
        this.j = i;
        this.b = str2;
        this.g = str3;
        this.h = str4;
        Log.d("Data_Loader:=", "Data_Loader:" + str + ":" + str2);
    }

    public C0908Sh(Context context, String str, int i, Z00 z00, String str2, String str3, int i2) {
        super(context);
        this.i = CSS.Value.PERCENTAGE;
        this.l = new int[]{R.drawable.up, 1, R.drawable.down};
        this.a = str;
        this.k = z00;
        this.j = i2;
        this.m = i;
        this.g = str2;
        this.h = str3;
        Log.d("Data_Loader:=", "Data_Loader:" + str + ":" + i);
    }

    public C0908Sh(Context context, String str, String str2, Z00 z00, int i, String str3, String str4) {
        super(context);
        this.i = CSS.Value.PERCENTAGE;
        this.l = new int[]{R.drawable.up, 1, R.drawable.down};
        this.m = 0;
        this.e = str;
        this.d = str2;
        this.g = str3;
        this.h = str4;
        this.k = z00;
        this.j = i;
        this.b = this.b;
        Log.d("Data_Loader_Det:=", str2 + ":" + str + ":" + str3 + ":" + str4);
    }

    public C0908Sh(Context context, String str, String str2, Z00 z00, int i, String str3, String str4, String str5) {
        super(context);
        this.i = CSS.Value.PERCENTAGE;
        this.l = new int[]{R.drawable.up, 1, R.drawable.down};
        this.m = 0;
        this.e = str;
        this.d = str2;
        this.g = str3;
        this.h = str4;
        this.k = z00;
        this.j = i;
        this.f = str5;
        this.b = this.b;
        Log.d("Data_Loader_Det:=", str2 + ":" + str + ":" + str3 + ":" + str4);
    }
}
