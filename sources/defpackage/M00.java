package defpackage;

import android.content.Context;
import android.content.SyncResult;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.fcm.online_status;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class M00 {
    public static boolean A = false;
    public static boolean B = false;
    public static String[] C = {"drop TRIGGER if EXISTS closing_year_update_items", "drop TRIGGER if EXISTS closing_year_delete_tr", "drop TRIGGER if EXISTS closing_year_delete_bills", "delete_bills", "delete_bill_transactions", "delete_transactions"};
    public static String u = "";
    public static boolean v = false;
    public static boolean w = false;
    public static boolean x = false;
    public static boolean y = false;
    public static boolean z = false;
    public Z00 a;
    public String b;
    public String c;
    public String d;
    public String e;
    public Context f;
    public online_status q;
    public String g = "mohaseb";
    public String h = "socket:firebase_db";
    public boolean i = false;
    public boolean j = false;
    public int k = 1;
    public String l = "\\^";
    public String m = "^";
    public String[] n = {"bills", "bills2", "transactions"};
    public int o = 50;
    public String[] p = {"currency", "item_type", "groups", "cus_type", "branches", "users", "tax", "units", "account_tree", "customers"};
    public String[] r = {"items_h", "bills_h", "bills2_h", "transactions_h", "transactions_h2"};
    public String[] s = {"bill_transactions_h", "bill_transactions2_h"};
    public String[] t = {"bills", "bills2", "items", "transactions"};

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            M00.this.q.I(this.a);
        }
    }

    public class b extends Thread {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                M00.this.q.J(bVar.a);
            }
        }

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            M00.this.q.runOnUiThread(new a());
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            M00 m00 = M00.this;
            m00.a.Kd(m00.q, this.a, 1000);
        }
    }

    public class d extends Thread {
        public final /* synthetic */ boolean a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                if (dVar.a) {
                    M00.this.q.c.d.setVisibility(0);
                } else {
                    M00.this.q.c.d.setVisibility(8);
                }
            }
        }

        public d(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            M00.this.q.runOnUiThread(new a());
        }
    }

    public M00(Z00 z00, Context context, boolean z2, online_status online_statusVar) {
        this.a = z00;
        z00.w0("PRAGMA foreign_keys = ON");
        this.f = context;
        this.q = online_statusVar;
        this.b = z00.ia("online_user", "").replace("@gmail.com", "");
        this.c = z00.ia("PREF_ACCOUNT_NAME", "0").replace("@gmail.com", "");
        FirebaseApp.initializeApp(context);
        this.d = FirebaseInstanceId.getInstance().getToken();
        this.e = C2160f10.F(z00);
        if (C1839c10.o(z00)) {
            Log.d(this.h, "fcm=" + this.d + ":p_un=" + this.b);
        }
        if (z2) {
            v();
        }
    }

    public static /* synthetic */ boolean C(char c2, int i) {
        return i == c2;
    }

    public static void G(int i, Z00 z00) {
        z00.v0("delete from table_action where init=0 and id>" + i);
    }

    public static void H(int i, Z00 z00) {
        z00.v0("delete from table_action where init=0 and action_='delete' and id>" + i);
    }

    public static String m(String str, String str2) {
        return " where bill_id=(select id from  " + str + " " + n(str2) + ")";
    }

    public static String n(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(" where online_ref2='");
        sb.append(str);
        sb.append("'");
        sb.append(str.equals("") ? " and online_ref2 is not null " : " ");
        return sb.toString();
    }

    public static int r(Z00 z00) {
        return Integer.parseInt(z00.X4("select ifnull(max(id),0) as _id from table_action"));
    }

    public static void w(Z00 z00, String str, String str2, String str3, String str4, String str5, String str6) {
        if (C1839c10.o(z00)) {
            Log.d(Q00.H, "insert_action:" + str + ":table=" + str2 + ":ref_no=" + str4);
        }
        z00.x0("insert into table_action(table_name,table_cond,ref_no,action_,batch_,init) values('" + str2 + "','" + str3.replaceAll("'", "''") + "','" + str4 + "','" + str + "'," + str5 + "," + str6 + ")");
    }

    public static String x(Z00 z00, String str, String str2, String str3, String str4, String str5, String str6) {
        C1839c10.o(z00);
        return "insert into table_action(table_name,table_cond,ref_no,action_,batch_,init) values('" + str2 + "','" + str3.replaceAll("'", "''") + "','" + str4 + "','" + str + "'," + str5 + "," + str6 + ")";
    }

    public boolean A(String str) {
        for (String str2 : this.t) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean B(String str) {
        for (String str2 : this.r) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean D(String str) {
        return str.equals("bills") || str.equals("bills2") || str.equals("bills_h") || str.equals("bills2_h");
    }

    /* JADX WARN: Code duplicated, block: B:152:0x0350 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:190:0x0405  */
    public List E(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONArray jSONArray;
        String str7;
        JSONArray jSONArray2;
        String str8;
        ArrayList arrayList;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z2;
        String string;
        String str15;
        String str16;
        String str17;
        ArrayList arrayList2;
        String str18;
        String str19;
        String str20;
        int i;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        String str21;
        String str22;
        String string2;
        String str23;
        JSONArray jSONArray5;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29 = str;
        String str30 = str2;
        String str31 = "online_ref3";
        String str32 = "";
        ArrayList arrayList3 = new ArrayList();
        if (C1839c10.o(this.a)) {
            Log.d(this.h, "prepare_Query_list=table_name=" + str29 + ":cond=" + str3 + ":action=" + str30 + ":json=" + str4 + ":json_c=" + str5 + ":ref=" + str6);
        }
        String str33 = "'";
        if (str30.equals(SearchIntents.EXTRA_QUERY)) {
            for (String str34 : str3.split(";")) {
                if ((str34.startsWith("create table if not exists") && !str34.contains("'") && str34.trim().endsWith("where 1=2")) || (C2160f10.p(C, str34) && !str34.contains("'"))) {
                    if (str34.startsWith("delete")) {
                        arrayList3.add("drop table if EXISTS tmp_max_action_id");
                        arrayList3.add("create TEMPORARY table tmp_max_action_id as select ifnull(max(id),0) as _id from table_action");
                    }
                    if (str34.equals("delete_bills")) {
                        arrayList3.add("delete from bills where  (date_)<=date('" + p(str6) + "','-1 day')");
                    } else if (str34.equals("delete_bill_transactions")) {
                        arrayList3.add("delete from bill_transactions where bill_id in (select id from bills a where  (a.date_)<=date('" + p(str6) + "','-1 day') )");
                    } else if (str34.equals("delete_transactions")) {
                        arrayList3.add("delete from transactions where strftime('%Y-%m-%d',substr(date_,7,4)||'-' ||substr(date_,4,2)||'-'||substr(date_,1,2) )<=date('" + p(str6) + "','-1 day')");
                    } else {
                        arrayList3.add(str34);
                    }
                    if (str34.startsWith("delete")) {
                        arrayList3.add("delete from table_action where init=0 and id>(select b._id from tmp_max_action_id b )");
                    }
                }
                if ((str29.equals("items") && str34.startsWith("update items set o_qty=o_qty+") && h(str34, '\'') == 6 && str34.contains("where online_ref2=(select id from items where name='") && str34.endsWith("'")) || (str34.startsWith("update items set online_ref2=") && str34.contains("where online_ref2 is null and name='") && str34.endsWith("'"))) {
                    arrayList3.add(str34);
                }
            }
            return arrayList3;
        }
        String str35 = " ";
        if (str30.equals("delete") && str3.trim().length() > 0) {
            arrayList3.add("delete from  " + str29 + " " + str3);
            return arrayList3;
        }
        JSONArray jSONArray6 = null;
        try {
            jSONArray = !str4.equals("") ? new JSONArray(str4) : null;
            try {
                if (!str5.equals("")) {
                    jSONArray6 = new JSONArray(str5);
                }
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                this.i = true;
                J(e, 13);
            }
        } catch (JSONException e2) {
            e = e2;
            jSONArray = null;
        }
        JSONArray jSONArray7 = jSONArray6;
        String strO = D(str) ? o(str) : "";
        String str36 = "insert";
        String str37 = "date_";
        String str38 = "update";
        if (jSONArray != null) {
            boolean z3 = B(str) || z(str);
            boolean z4 = D(str) && g(strO) && (str30.equals("update") || str30.equals("insert"));
            if (z3) {
                if (!A) {
                    this.a.v0("CREATE INDEX if not exists bill_trans_id_date_h on bill_transactions_h(bill_id,date_);");
                    this.a.v0("drop INDEX if EXISTS bill_trans_id_h;");
                    this.a.v0("CREATE INDEX if not exists bills_h_ref2 on bills_h(online_ref2);");
                }
                A = true;
                B = false;
            } else {
                strO = strO;
                if (!B) {
                    this.a.v0("drop INDEX if EXISTS bill_trans_id_date_h;");
                    this.a.v0("drop INDEX if EXISTS bill_trans_id_h;");
                    this.a.v0("drop INDEX if EXISTS bills_h_ref2;");
                }
                B = true;
                A = false;
            }
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    HashMap mapQ = Q(jSONArray.getJSONObject(i2).toString(), str29, jSONArray.getJSONObject(i2).getString("online_ref2"));
                    if (z3) {
                        string2 = jSONArray.getJSONObject(i2).has(str37) ? jSONArray.getJSONObject(i2).getString(str37) : str32;
                        str20 = str32;
                    } else {
                        string2 = str32;
                        str20 = string2;
                    }
                    String str39 = str31;
                    try {
                        if (z4) {
                            str23 = string2;
                            try {
                                if (str29.equals("bills") && str30.equals(str38)) {
                                    Z00 z00 = this.a;
                                    jSONArray5 = jSONArray7;
                                    try {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("select count(*) as _id from ");
                                        sb.append(str29);
                                        sb.append(str35);
                                        str24 = str37;
                                        try {
                                            sb.append(n(jSONArray.getJSONObject(i2).getString("online_ref2")));
                                            if (z00.X4(sb.toString()).equals("0")) {
                                                str25 = str36;
                                            }
                                            str15 = str36;
                                            str18 = str38;
                                            str26 = strO;
                                            i = i2;
                                            jSONArray3 = jSONArray;
                                            jSONArray4 = jSONArray5;
                                            str16 = str24;
                                            str27 = str35;
                                            str28 = str33;
                                            arrayList2 = arrayList3;
                                            arrayList2.add(t(str, str25, mapQ, jSONArray.getJSONObject(i2).getString("online_ref2"), str3, str6, str23));
                                            if (jSONArray4 == null && z4) {
                                                str19 = str39;
                                                try {
                                                    String string3 = jSONArray3.getJSONObject(i).has(str19) ? jSONArray3.getJSONObject(i).getString(str19) : jSONArray3.getJSONObject(i).getString("online_ref2");
                                                    Z00 z01 = this.a;
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("select count(*) as _id from ");
                                                    str22 = str26;
                                                    try {
                                                        sb2.append(str22);
                                                        str17 = str27;
                                                        try {
                                                            sb2.append(str17);
                                                            jSONArray4 = jSONArray4;
                                                            str29 = str;
                                                            try {
                                                                sb2.append(m(str29, string3));
                                                                if (z01.X4(sb2.toString()).equals("0")) {
                                                                    str21 = str28;
                                                                } else {
                                                                    String string4 = "delete from " + str22 + str17 + m(str29, string3);
                                                                    if (z(str22)) {
                                                                        StringBuilder sb3 = new StringBuilder();
                                                                        sb3.append(string4);
                                                                        sb3.append(" and date_='");
                                                                        sb3.append(str23);
                                                                        str21 = str28;
                                                                        try {
                                                                            sb3.append(str21);
                                                                            string4 = sb3.toString();
                                                                        } catch (JSONException e3) {
                                                                            e = e3;
                                                                            e.printStackTrace();
                                                                            this.i = true;
                                                                            J(e, 14);
                                                                        }
                                                                    } else {
                                                                        str21 = str28;
                                                                    }
                                                                    arrayList2.add(string4);
                                                                }
                                                            } catch (JSONException e4) {
                                                                e = e4;
                                                                str21 = str28;
                                                            }
                                                        } catch (JSONException e5) {
                                                            e = e5;
                                                            jSONArray4 = jSONArray4;
                                                            str21 = str28;
                                                            str29 = str;
                                                            e.printStackTrace();
                                                            this.i = true;
                                                            J(e, 14);
                                                            i2 = i + 1;
                                                            str38 = str18;
                                                            str33 = str21;
                                                            strO = str22;
                                                            str35 = str17;
                                                            arrayList3 = arrayList2;
                                                            jSONArray7 = jSONArray4;
                                                            jSONArray = jSONArray3;
                                                            str32 = str20;
                                                            str36 = str15;
                                                            str37 = str16;
                                                            str30 = str2;
                                                            str31 = str19;
                                                        }
                                                    } catch (JSONException e6) {
                                                        e = e6;
                                                        str17 = str27;
                                                        str21 = str28;
                                                        str29 = str;
                                                        e.printStackTrace();
                                                        this.i = true;
                                                        J(e, 14);
                                                        i2 = i + 1;
                                                        str38 = str18;
                                                        str33 = str21;
                                                        strO = str22;
                                                        str35 = str17;
                                                        arrayList3 = arrayList2;
                                                        jSONArray7 = jSONArray4;
                                                        jSONArray = jSONArray3;
                                                        str32 = str20;
                                                        str36 = str15;
                                                        str37 = str16;
                                                        str30 = str2;
                                                        str31 = str19;
                                                    }
                                                } catch (JSONException e7) {
                                                    e = e7;
                                                    str22 = str26;
                                                }
                                            } else {
                                                jSONArray4 = jSONArray4;
                                                str22 = str26;
                                                str19 = str39;
                                                str17 = str27;
                                                str21 = str28;
                                                str29 = str;
                                            }
                                        } catch (JSONException e8) {
                                            e = e8;
                                            str15 = str36;
                                            jSONArray3 = jSONArray;
                                            str17 = str35;
                                            str21 = str33;
                                            arrayList2 = arrayList3;
                                            str18 = str38;
                                            str22 = strO;
                                            str19 = str39;
                                            jSONArray4 = jSONArray5;
                                            str16 = str24;
                                            i = i2;
                                            e.printStackTrace();
                                            this.i = true;
                                            J(e, 14);
                                            i2 = i + 1;
                                            str38 = str18;
                                            str33 = str21;
                                            strO = str22;
                                            str35 = str17;
                                            arrayList3 = arrayList2;
                                            jSONArray7 = jSONArray4;
                                            jSONArray = jSONArray3;
                                            str32 = str20;
                                            str36 = str15;
                                            str37 = str16;
                                            str30 = str2;
                                            str31 = str19;
                                        }
                                    } catch (JSONException e9) {
                                        e = e9;
                                        str24 = str37;
                                        str15 = str36;
                                        jSONArray3 = jSONArray;
                                        str17 = str35;
                                        str21 = str33;
                                        arrayList2 = arrayList3;
                                        str18 = str38;
                                        str22 = strO;
                                        str19 = str39;
                                        jSONArray4 = jSONArray5;
                                        str16 = str24;
                                        i = i2;
                                        e.printStackTrace();
                                        this.i = true;
                                        J(e, 14);
                                        i2 = i + 1;
                                        str38 = str18;
                                        str33 = str21;
                                        strO = str22;
                                        str35 = str17;
                                        arrayList3 = arrayList2;
                                        jSONArray7 = jSONArray4;
                                        jSONArray = jSONArray3;
                                        str32 = str20;
                                        str36 = str15;
                                        str37 = str16;
                                        str30 = str2;
                                        str31 = str19;
                                    }
                                    i2 = i + 1;
                                    str38 = str18;
                                    str33 = str21;
                                    strO = str22;
                                    str35 = str17;
                                    arrayList3 = arrayList2;
                                    jSONArray7 = jSONArray4;
                                    jSONArray = jSONArray3;
                                    str32 = str20;
                                    str36 = str15;
                                    str37 = str16;
                                    str30 = str2;
                                    str31 = str19;
                                }
                                str25 = str30;
                                str15 = str36;
                                str18 = str38;
                                str26 = strO;
                                i = i2;
                                jSONArray3 = jSONArray;
                                jSONArray4 = jSONArray5;
                                str16 = str24;
                                str27 = str35;
                                str28 = str33;
                                arrayList2 = arrayList3;
                                arrayList2.add(t(str, str25, mapQ, jSONArray.getJSONObject(i2).getString("online_ref2"), str3, str6, str23));
                                if (jSONArray4 == null) {
                                    jSONArray4 = jSONArray4;
                                    str22 = str26;
                                    str19 = str39;
                                    str17 = str27;
                                    str21 = str28;
                                    str29 = str;
                                } else {
                                    jSONArray4 = jSONArray4;
                                    str22 = str26;
                                    str19 = str39;
                                    str17 = str27;
                                    str21 = str28;
                                    str29 = str;
                                }
                            } catch (JSONException e10) {
                                e = e10;
                                jSONArray5 = jSONArray7;
                            }
                            i2 = i + 1;
                            str38 = str18;
                            str33 = str21;
                            strO = str22;
                            str35 = str17;
                            arrayList3 = arrayList2;
                            jSONArray7 = jSONArray4;
                            jSONArray = jSONArray3;
                            str32 = str20;
                            str36 = str15;
                            str37 = str16;
                            str30 = str2;
                            str31 = str19;
                        } else {
                            str23 = string2;
                        }
                        arrayList2.add(t(str, str25, mapQ, jSONArray.getJSONObject(i2).getString("online_ref2"), str3, str6, str23));
                        if (jSONArray4 == null) {
                            jSONArray4 = jSONArray4;
                            str22 = str26;
                            str19 = str39;
                            str17 = str27;
                            str21 = str28;
                            str29 = str;
                        } else {
                            jSONArray4 = jSONArray4;
                            str22 = str26;
                            str19 = str39;
                            str17 = str27;
                            str21 = str28;
                            str29 = str;
                        }
                    } catch (JSONException e11) {
                        e = e11;
                        str22 = str26;
                        str19 = str39;
                    }
                    jSONArray5 = jSONArray7;
                    str24 = str37;
                    str25 = str30;
                    str15 = str36;
                    str18 = str38;
                    str26 = strO;
                    i = i2;
                    jSONArray3 = jSONArray;
                    jSONArray4 = jSONArray5;
                    str16 = str24;
                    str27 = str35;
                    str28 = str33;
                    arrayList2 = arrayList3;
                } catch (JSONException e12) {
                    e = e12;
                    str15 = str36;
                    str16 = str37;
                    str17 = str35;
                    arrayList2 = arrayList3;
                    str18 = str38;
                    str19 = str31;
                    str20 = str32;
                    i = i2;
                    jSONArray3 = jSONArray;
                    jSONArray4 = jSONArray7;
                    str21 = str33;
                    str22 = strO;
                }
                i2 = i + 1;
                str38 = str18;
                str33 = str21;
                strO = str22;
                str35 = str17;
                arrayList3 = arrayList2;
                jSONArray7 = jSONArray4;
                jSONArray = jSONArray3;
                str32 = str20;
                str36 = str15;
                str37 = str16;
                str30 = str2;
                str31 = str19;
            }
            str7 = str36;
            jSONArray2 = jSONArray7;
            str8 = str37;
            arrayList = arrayList3;
            str9 = str38;
            str10 = str32;
            str11 = strO;
        } else {
            str7 = "insert";
            jSONArray2 = jSONArray7;
            str8 = "date_";
            arrayList = arrayList3;
            str9 = "update";
            str10 = "";
            str11 = strO;
        }
        if (jSONArray2 != null) {
            int i3 = 0;
            while (i3 < jSONArray2.length()) {
                try {
                    HashMap mapQ2 = Q(jSONArray2.getJSONObject(i3).toString(), str11, jSONArray2.getJSONObject(i3).getString("online_ref2"));
                    if (B(str) || z(str)) {
                        str14 = str8;
                        string = jSONArray2.getJSONObject(i3).has(str14) ? jSONArray2.getJSONObject(i3).getString(str14) : str10;
                    } else {
                        string = str10;
                        str14 = str8;
                    }
                    try {
                        if (g(str11)) {
                            String str40 = str9;
                            str13 = str11;
                            try {
                                if (str2.equals(str40)) {
                                    str12 = str40;
                                    z2 = true;
                                    try {
                                        arrayList.add(t(str13, str2.equals(str40) ? str7 : str2, mapQ2, jSONArray2.getJSONObject(i3).getString("online_ref2"), str3, str6, string));
                                    } catch (JSONException e13) {
                                        e = e13;
                                        e.printStackTrace();
                                        this.i = z2;
                                        J(e, 15);
                                    }
                                } else {
                                    str12 = str40;
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                str12 = str40;
                                z2 = true;
                                e.printStackTrace();
                                this.i = z2;
                                J(e, 15);
                                i3++;
                                str8 = str14;
                                str11 = str13;
                                str9 = str12;
                            }
                            i3++;
                            str8 = str14;
                            str11 = str13;
                            str9 = str12;
                        } else {
                            str12 = str9;
                            str13 = str11;
                        }
                        arrayList.add(t(str13, str2, mapQ2, jSONArray2.getJSONObject(i3).getString("online_ref2"), str3, str6, string));
                    } catch (JSONException e15) {
                        e = e15;
                        str12 = str9;
                        str13 = str11;
                    }
                } catch (JSONException e16) {
                    e = e16;
                    str12 = str9;
                    str13 = str11;
                    str14 = str8;
                }
                i3++;
                str8 = str14;
                str11 = str13;
                str9 = str12;
            }
        }
        return arrayList;
    }

    public void F(int i) {
        this.a.v0("delete from table_action where param1=2 and id<=" + i);
    }

    public void I(String str) {
        if (str.length() == 0) {
            return;
        }
        if (C1839c10.o(this.a)) {
            String str2 = this.h;
            StringBuilder sb = new StringBuilder();
            sb.append("set_alert_status#:err=");
            sb.append(str);
            sb.append(":");
            sb.append(u);
            sb.append(":");
            sb.append(this.q == null ? "Null" : "NotNull");
            Log.d(str2, sb.toString());
        }
        online_status online_statusVar = this.q;
        if (online_statusVar != null) {
            online_statusVar.runOnUiThread(new c(str));
        }
    }

    public void J(Exception exc, int i) {
        C1839c10.z(this.a, this.h, "set_error#" + i + ":" + exc.getMessage());
        if (exc.getMessage() == null) {
            return;
        }
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder();
        sb.append(u);
        sb.append("\nError");
        sb.append(i);
        sb.append(":");
        if (message != null && message.length() > 30) {
            message = message.substring(0, 30);
        }
        sb.append(message);
        String string = sb.toString();
        u = string;
        online_status online_statusVar = this.q;
        if (online_statusVar != null) {
            online_statusVar.I(string);
        }
        O(false);
    }

    public void K(String str) {
        u += StringUtilities.LF + str;
        Z00 z00 = this.a;
        String str2 = this.h;
        StringBuilder sb = new StringBuilder();
        sb.append("set_error#:err=");
        sb.append(str);
        sb.append(":");
        sb.append(u);
        sb.append(":");
        sb.append(this.q == null ? "Null" : "NotNull");
        C1839c10.z(z00, str2, sb.toString());
        online_status online_statusVar = this.q;
        if (online_statusVar != null) {
            online_statusVar.runOnUiThread(new a(str));
        }
        O(false);
    }

    public void L(String str) {
        if (C1839c10.o(this.a)) {
            String str2 = this.h;
            StringBuilder sb = new StringBuilder();
            sb.append("set_info#:err=");
            sb.append(str);
            sb.append(":");
            sb.append(this.q == null ? "Null" : "NotNull");
            Log.d(str2, sb.toString());
        }
        if (this.q != null) {
            new b(str).start();
        }
    }

    public void O(boolean z2) {
        if (C1839c10.o(this.a)) {
            String str = this.h;
            StringBuilder sb = new StringBuilder();
            sb.append("show_progress#:err=");
            sb.append(z2);
            sb.append(":");
            sb.append(this.q == null ? "Null" : "NotNull");
            Log.d(str, sb.toString());
        }
        SyncResult syncResult = Q00.G;
        if (syncResult != null) {
            syncResult.stats.numParseExceptions++;
        }
        if (this.q != null) {
            new d(z2).start();
        }
    }

    public HashMap Q(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String string;
        String str8;
        String str9;
        String str10;
        String str11 = "'";
        String str12 = "null";
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    Object obj = jSONObject.get(next);
                    boolean zEquals = next.equals("cus_name_");
                    String str13 = HTML.Attribute.ID;
                    Iterator<String> it = itKeys;
                    HashMap map2 = map;
                    if (zEquals || next.equals("t_cus_name_") || next.equals("cash_name_") || next.equals("fund_name_") || next.equals("cost_name_")) {
                        String str14 = str12;
                        str4 = str11;
                        str5 = str14;
                        y("customers", obj + "");
                        str6 = "(select id from customers where name='" + obj + "')";
                    } else if (next.equals("br_name_") || next.equals("to_br_name_") || next.equals("o_br_name_")) {
                        String str15 = str12;
                        str4 = str11;
                        str5 = str15;
                        y("branches", obj + "");
                        str6 = "(select id from branches where name='" + obj + "')";
                    } else if (next.equals("curr_name_") || next.equals("p_curr_name_") || next.equals("c_curr_name_")) {
                        String str16 = str12;
                        str4 = str11;
                        str5 = str16;
                        y("currency", obj + "");
                        str6 = "(select id from currency where name='" + obj + "')";
                    } else if (next.equals("user_name_") || next.equals("last_user_name_")) {
                        String str17 = str12;
                        str4 = str11;
                        str5 = str17;
                        y("users", obj + "");
                        str6 = "(select id from users where name='" + obj + "')";
                    } else if (next.equals("unit_name_") || next.equals("base_unit_name_")) {
                        String str18 = str12;
                        str4 = str11;
                        str5 = str18;
                        y("units", obj + "");
                        str6 = "(select id from units where name='" + obj + "')";
                    } else {
                        if (next.equals("item_name_") || next.equals("item_h_name_")) {
                            str7 = str11;
                            str5 = str12;
                            y("items", obj + "");
                            string = "ifnull((select id from items where name='" + obj + "'),null)";
                        } else {
                            if (next.equals("item_type_name_")) {
                                str8 = str11;
                                y("item_type", obj + "");
                                str10 = "(select id from item_type where name='" + obj + "')";
                            } else {
                                str8 = str11;
                                if (next.equals("cus_type_name_")) {
                                    y("cus_type", obj + "");
                                    str10 = "(select id from cus_type where name='" + obj + "')";
                                } else if (next.equals("g_name_")) {
                                    y("groups", obj + "");
                                    str10 = "(select id from groups where name='" + obj + "')";
                                } else {
                                    String str19 = str12;
                                    if (next.equals("acc_p_name_") || next.equals("parent_name_")) {
                                        str7 = str8;
                                        str5 = str19;
                                        string = "(ifnull((select id from account_tree where name='" + obj + "'),0))";
                                    } else {
                                        if (next.equals("p_id_ref2_")) {
                                            str9 = "(ifnull((select id from account_tree_type where name='" + obj + "'),0))";
                                        } else if (next.equals("p_id_ref_")) {
                                            str9 = "(ifnull((select id from account_tree where name='" + obj + "'),0)||(SELECT count(*)+1 as _id from account_tree where parent_id=(ifnull((select id from account_tree where name='" + obj + "'),0))))";
                                        } else if (next.equals("tax_name_")) {
                                            y("tax", obj + "");
                                            str9 = "(select id from tax where name='" + obj + "')";
                                        } else if (next.equals("bill_id") && str2.equals("bill_transactions")) {
                                            str9 = "(select id from bills where online_ref2='" + str3 + "')";
                                        } else if (next.equals("id2_ref_") && D(str2)) {
                                            str9 = "(select id from " + str2 + " where online_ref2='" + obj + "')";
                                        } else if (next.equals("bill_id") && str2.equals("bill_transactions2")) {
                                            str9 = "(select id from bills2 where online_ref2='" + str3 + "')";
                                        } else if (next.equals("bill_id") && str2.equals("bill_transactions_h")) {
                                            str9 = "(select id from bills_h where online_ref2='" + str3 + "')";
                                        } else if (next.equals("bill_id") && str2.equals("bill_transactions2_h")) {
                                            str9 = "(select id from bills2_h where online_ref2='" + str3 + "')";
                                        } else if (next.equals("amount") && str2.equals("bills") && str3.equals("patch#first_year")) {
                                            str9 = "abs(" + obj + ")";
                                        } else if (next.equals(HTML.Attribute.ID) && str2.equals("items_h")) {
                                            str9 = "(select id from items where name='" + jSONObject.get("name") + "' and date_='" + jSONObject.get("date_") + "')";
                                        } else {
                                            str5 = str19;
                                            if (obj.equals(str5)) {
                                                str6 = str5;
                                                str4 = str8;
                                            } else {
                                                StringBuilder sb = new StringBuilder();
                                                str7 = str8;
                                                sb.append(str7);
                                                sb.append(obj);
                                                sb.append(str7);
                                                string = sb.toString();
                                            }
                                        }
                                        str6 = str9;
                                        str4 = str8;
                                        str5 = str19;
                                    }
                                }
                            }
                            str6 = str10;
                            str5 = str12;
                            str4 = str8;
                        }
                        str6 = string;
                        str4 = str7;
                    }
                    String strReplace = next.replace("_name_", "_id");
                    if (strReplace.equals("base_unit_id") || strReplace.equals("base_unit_name")) {
                        str13 = "base_unit";
                    } else if (strReplace.equals("last_user_id")) {
                        str13 = "last_user";
                    } else if (strReplace.equals(CSS.Value.IN)) {
                        str13 = "[in]";
                    } else if (!strReplace.equals("p_id_ref_")) {
                        if (strReplace.equals("p_id_ref2_")) {
                            str13 = "p";
                        } else if (strReplace.equals("id2_ref_")) {
                            str13 = "id2";
                        } else if (!strReplace.equals("id_id")) {
                            str13 = strReplace.equals("item_h_id") ? "item_id" : strReplace;
                        }
                    }
                    map2.put(str13.toLowerCase(), str6);
                    itKeys = it;
                    map = map2;
                    String str20 = str4;
                    str12 = str5;
                    str11 = str20;
                } catch (JSONException e) {
                    J(e, 17);
                    return null;
                }
            }
            return map;
        } catch (JSONException e2) {
            J(e2, 16);
            return null;
        }
    }

    public HashMap c(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        HashMap map = new HashMap();
        map.put("table", K00.a(this.m, strArr));
        map.put("action", K00.a(this.m, strArr2));
        map.put("un", this.c);
        map.put("p_un", this.b);
        map.put("fcm_token", this.d);
        map.put("last_user", C2160f10.h + "");
        map.put("dev_id", this.e);
        map.put("app_id", Q00.B);
        try {
            map.put("json", AbstractC4032uI.c(K00.a(this.m, strArr3), this.d));
            map.put("json_c", AbstractC4032uI.c(K00.a(this.m, strArr4), this.d));
            for (int i = 0; i < strArr7.length; i++) {
                if (strArr7[i].equals("1")) {
                    strArr5[i] = "batch";
                }
            }
            map.put("cond", K00.a(this.m, strArr5));
            map.put("ref_no", K00.a(this.m, strArr6));
            if (this.a.ia("online_share_type", "0").equals("2")) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < strArr2.length; i2++) {
                    if (strArr2[i2].equals("pref") && ((strArr[i2].equals("online_push_init_data") || strArr[i2].equals("online_push_closed_data")) && strArr5[i2].equals("1"))) {
                        arrayList.add(strArr[i2].replace("online_", ""));
                        arrayList2.add(strArr5[i2]);
                    }
                }
                if (arrayList.size() > 0) {
                    M((String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]));
                }
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean d() {
        return this.a.ia("online_stop", "0").equals("1") || this.a.ia("online_user", "").equals("");
    }

    public boolean e(String str) {
        int i = Integer.parseInt(this.a.ia("online_param_" + str, "0"));
        int iQ = q("online_last_" + str);
        if (C1839c10.o(this.a)) {
            Log.d(this.h, "conf_param:name=" + str + ":value=" + i + ":min=" + iQ);
        }
        return iQ < i;
    }

    public void f(boolean z2) {
        if (C1839c10.o(this.a)) {
            Log.d(this.h, "get_user_fields:online_date_done=" + this.a.ia("online_date_done", "") + ":server=" + this.a.ja("online_server", false) + ":client=" + this.a.ja("online_client", false));
        }
        if (this.c.equals("0") || this.d == null || !this.a.ia("online_share_type", "0").equals("2")) {
            return;
        }
        if (z2 && this.a.ia("online_date_done", "").equals(C2160f10.z("dd-MM-yyyy"))) {
            C1839c10.J(this.a);
        }
    }

    public boolean g(String str) {
        return str.equals("bill_transactions") || str.equals("bill_transactions2") || str.equals("bill_transactions_h") || str.equals("bill_transactions2_h");
    }

    public long h(String str, final char c2) {
        return Build.VERSION.SDK_INT >= 24 ? str.chars().filter(new IntPredicate() { // from class: L00
            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return M00.C(c2, i);
            }
        }).count() : AbstractC3146jS.a(str, Character.toString(c2));
    }

    public final void i() {
        try {
            if (this.i) {
                I("Error0 ......");
            }
        } catch (Exception e) {
            e.printStackTrace();
            J(e, 3);
            w = false;
            v = false;
        }
    }

    public boolean j(String str) {
        return false;
    }

    public void k(boolean z2) {
        if (d()) {
            return;
        }
        try {
            this.i = false;
            if (C1839c10.o(this.a)) {
                Log.d(this.h, "fetch_data:fetch_data_flag=" + v + ":listen_data_flag=" + this.j + ":download_docs_flag=" + w);
            }
            if (!v && !this.j) {
                if (Integer.parseInt(this.a.X4("select count(*) as _id from table_action where init=1")) <= 0) {
                    v = true;
                    i();
                    return;
                } else {
                    if (C1839c10.o(this.a)) {
                        Log.d(this.h, "fetch_data:Exit:first push all init data");
                        return;
                    }
                    return;
                }
            }
            I("1:already running..." + v + ":" + this.j);
        } catch (Exception e) {
            v = false;
            e.printStackTrace();
            J(e, 2);
        }
    }

    public String l(String str, String str2) {
        String str3 = "id " + str2 + " (0) ";
        if (str.equals("currency")) {
            return "id " + str2 + "(0,1) ";
        }
        if (str.equals("cus_type")) {
            return "id " + str2 + "(0,1,2,3,4,5,6,7) ";
        }
        if (str.equals("tax")) {
            return "id " + str2 + "(-1,0) ";
        }
        if (str.equals("units")) {
            return "(id " + str2 + " (0,1,2,3,4)) ";
        }
        if (str.equals("account_tree")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2.trim().equals(CSS.Value.IN) ? " " : "not ");
            sb.append(" ( admin in (1) or id in (124)) ");
            return sb.toString();
        }
        if (str.equals("customers")) {
            return "id " + str2 + "(select id from customers where id<0) ";
        }
        if (!str.equals("users")) {
            return str3;
        }
        return "id " + str2 + "(0) and is_active=1 ";
    }

    public String o(String str) {
        if (str.equals("bills")) {
            return "bill_transactions";
        }
        if (str.equals("bills2")) {
            return "bill_transactions2";
        }
        if (str.equals("bills_h")) {
            return "bill_transactions_h";
        }
        return str.equals("bills2_h") ? "bill_transactions2_h" : "";
    }

    public String p(String str) {
        return str.split(":")[str.split(":").length - 1];
    }

    public int q(String str) {
        long j = Long.parseLong(this.a.ia(str, "0"));
        if (j == 0) {
            return 0;
        }
        return (((int) (Calendar.getInstance().getTimeInMillis() - j)) / 1000) / 60;
    }

    public String s(String str) {
        if (str.equals("bill_transactions")) {
            return "bills";
        }
        if (str.equals("bill_transactions2")) {
            return "bills2";
        }
        if (str.equals("bill_transactions_h")) {
            return "bills_h";
        }
        return str.equals("bill_transactions2_h") ? "bills2_h" : "";
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0377  */
    /* JADX WARN: Instruction removed from duplicated block: B:132:0x0377, please report this as an issue */
    public String t(String str, String str2, HashMap map, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        String str9;
        String str10;
        Object obj;
        String str11;
        String str12;
        Object obj2;
        String str13;
        str4 = str4;
        if (str3.equals("0") || str3.length() == 0) {
            return " ";
        }
        String strM = " where online_ref2='" + str3 + "' ";
        String strS = s(str);
        if (g(str)) {
            strM = m(strS, str3);
            if (z(str)) {
                strM = strM + " and date_='" + str6 + "' ";
            }
        } else if (str.equals("transactions_h") || str.equals("transactions_h2")) {
            strM = " where online_ref2='" + str3 + "' and date_='" + str6 + "' ";
        }
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        boolean zEquals = str2.equals("insert");
        String str14 = strM;
        String str15 = "account_tree";
        String str16 = HTML.Attribute.ID;
        Object obj3 = "bills2";
        if (zEquals) {
            StringBuilder sb = new StringBuilder();
            String str17 = ",";
            sb.append("insert into ");
            sb.append(str);
            sb.append(" (");
            String string = sb.toString();
            if (!g(str)) {
                string = "insert or ignore  into " + str + " (";
            }
            Iterator it = arrayList.iterator();
            String str18 = " ";
            while (it.hasNext()) {
                String str19 = (String) it.next();
                it = it;
                if ((!str19.toLowerCase().equals(str16) || str.equals(str15) || str.equals("users") || B(str) || str4.equals("batch")) && !((str19.toLowerCase().equals(str16) && str.equals("unit_item")) || ((str19.equals("online_ref2") && g(str)) || (str19.equals("paid_amount") && str.equals(obj3))))) {
                    str11 = str16;
                    if ((str19.equals("paid_amount") && str.equals("bills2_h")) || ((str19.equals("curr_mod") && str.equals(obj3)) || (str19.equals("u_cost2") && str.equals("bill_transactions2")))) {
                        str12 = str15;
                        str16 = str11;
                        str15 = str12;
                    } else {
                        str12 = str15;
                        if ((str19.equals("u_cost2") && str.equals("bill_transactions2_h")) || ((str19.equals("cash_id") && ((str.equals("bill_transactions2") || str.equals("bill_transactions2_h")) && !u(str, "cash_id"))) || (str19.equals("curr_mod") && str.equals("bills2_h") && !u(str, "curr_mod")))) {
                            str16 = str11;
                            str15 = str12;
                        } else if (str5.equals("patch#first_year") && ((str.equals("bills") || str.equals(obj3)) && str19.equals("online_ref3"))) {
                            str16 = str11;
                            str15 = str12;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(string);
                            sb2.append(str19);
                            String str20 = str17;
                            sb2.append(str20);
                            String string2 = sb2.toString();
                            if (str5.equals("patch#first_year") && ((str.equals("bills") || str.equals(obj3)) && str19.equals("online_ref2"))) {
                                str13 = str18 + map.get("online_ref3") + str20;
                                obj2 = obj3;
                            } else {
                                obj2 = obj3;
                                str13 = (str5.equals("patch#first_year") && str.equals("transactions") && str19.equals("out")) ? str18 + "abs(" + map.get("out") + ")," : str18 + map.get(str19) + str20;
                            }
                            str18 = str13;
                            obj3 = obj2;
                            str17 = str20;
                            string = string2;
                            str16 = str11;
                            str15 = str12;
                        }
                    }
                } else {
                    str11 = str16;
                    str12 = str15;
                    str16 = str11;
                    str15 = str12;
                }
            }
            String str21 = str15;
            String strSubstring = string.substring(0, string.length() - 1);
            String strSubstring2 = str18.substring(0, str18.length() - 1);
            str8 = (this.b.equals("hamzaalmughalles2019") && str.equals("bill_transactions")) ? strSubstring + " ) select  " + strSubstring2 + " where (select count(*) from bills where online_ref2='" + str3 + "')!=0 ; " : strSubstring + " ) values( " + strSubstring2 + " ) ; ";
            str7 = str21;
        } else if (str2.equals("update")) {
            if (new C2160f10().t(new String[]{"groups", "items", "customers"}, str)) {
                if (this.a.X4("select count(*) as _id from " + str + " where name='" + map.get("name") + "'").equals("0")) {
                    str9 = "update " + str + " set ";
                } else {
                    str9 = "update or ignore " + str + " set ";
                }
            } else {
                str9 = "update " + str + " set ";
            }
            for (String str22 : arrayList) {
                if (!str22.toLowerCase().equals(HTML.Attribute.ID) && (!str22.equals("online_ref2") || !g(str))) {
                    if (!str22.equals("online_ref2") || !str.equals("user_priv")) {
                        if (!str22.equals("paid_amount") || !str.equals("bills2")) {
                            if (!str22.equals("curr_mod") || !str.equals("bills2")) {
                                if (!str22.equals("u_cost2") || !str.equals("bill_transactions2")) {
                                    if (!this.b.equals("hamzaalmughalles2019") || ((!str22.equals("cr_no") && !str22.startsWith("z_") && !str22.equals("curr_price_sar") && !str22.equals("qr") && !str22.equals("xml_file") && !str22.equals("common_name") && !str22.equals("price_sar")) || u(str, str22))) {
                                        str9 = str9 + " " + str22 + "=" + map.get(str22) + ",";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            String strSubstring3 = str9.substring(0, str9.length() - 1);
            if (str2.equals("update")) {
                str10 = str4;
                obj = "batch";
                if (str10.equals(obj) && new C2160f10().t(this.p, str)) {
                    str7 = "account_tree";
                    str8 = str.equals(str7) ? strSubstring3 + " where name= " + map.get("name") : strSubstring3 + " where id= " + map.get(HTML.Attribute.ID);
                }
            } else {
                str10 = str4;
                obj = "batch";
            }
            str7 = "account_tree";
            str8 = str10.equals(obj) ? strSubstring3 + str14 + "; " : strSubstring3 + " " + str10 + "; ";
        } else {
            str7 = "account_tree";
            str8 = " ";
        }
        str.startsWith(str7);
        return str8;
    }

    public boolean u(String str, String str2) {
        return this.a.X4("select count(*) as _id from pragma_table_info('" + str + "') where name='" + str2 + "'").equals("1");
    }

    public void y(String str, String str2) {
        if (str2 == null || str2.toString().length() == 0 || str2.toString().equals("null")) {
            return;
        }
        if (str.equals("users")) {
            if (this.a.X4("select count(*) as _id from users where name='" + str2 + "' and user_name='" + str2 + "' ").equals("0")) {
                this.a.v0("insert or ignore into " + str + " (name,user_name) values('" + str2 + "','" + str2 + "')");
                return;
            }
            return;
        }
        if (str.equals("units")) {
            if (this.a.X4("select count(*) as _id from units where name='" + str2 + "' ").equals("0")) {
                this.a.v0("insert or ignore into " + str + " (name,code) values('" + str2 + "','" + str2 + "')");
                return;
            }
            return;
        }
        if (this.a.X4("select count(*) as _id from " + str + " where name='" + str2 + "'").equals("0")) {
            this.a.v0("insert or ignore into " + str + " (name) values('" + str2 + "')");
        }
    }

    public boolean z(String str) {
        for (String str2 : this.s) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void N(Map map) {
    }

    public void P(boolean z2) {
    }

    public void v() {
    }

    public void M(String[] strArr, String[] strArr2) {
    }

    public void b(HashMap map, long j) {
    }
}
