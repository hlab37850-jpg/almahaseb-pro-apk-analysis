package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.itextpdf.tool.xml.html.HTML;

/* JADX INFO: loaded from: classes3.dex */
public class W7 {
    public Double A;
    public Integer B;
    public Integer C;
    public Integer D;
    public Integer E;
    public Double F;
    public String G;
    public Double H;
    public Integer I;
    public Double J;
    public Integer K;
    public Integer L;
    public String M;
    public String N;
    public String O;
    public Integer P;
    public Integer Q;
    public Integer R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public Long a;
    public Double a0;
    public String b;
    public String c;
    public String d;
    public Integer e;
    public Integer f;
    public Integer g;
    public Integer h;
    public Integer i;
    public Integer j;
    public Integer k;
    public Integer l;
    public Double m;
    public Double n;
    public Double o;
    public String p;
    public String q;
    public String r;
    public Double s;
    public Integer t;
    public Integer u;
    public Integer v;
    public Integer w;
    public Integer x;
    public Integer y;
    public Double z;

    public static W7 a(Cursor cursor) {
        W7 w7 = new W7();
        w7.a = e(cursor, HTML.Attribute.ID);
        w7.b = f(cursor, "date_");
        w7.c = f(cursor, "remarks");
        w7.d = f(cursor, "bill_no");
        w7.e = d(cursor, "curr_id");
        w7.f = d(cursor, "bill_type");
        w7.g = d(cursor, "tr_type");
        w7.h = d(cursor, "is_back");
        w7.i = d(cursor, "br_id");
        w7.j = d(cursor, "cus_id");
        w7.k = d(cursor, "tran_status");
        w7.l = d(cursor, "to_br_id");
        w7.m = c(cursor, "amount");
        w7.n = c(cursor, "d_amount");
        w7.o = c(cursor, "tax_amount");
        w7.p = f(cursor, "param1");
        w7.q = f(cursor, "param2");
        w7.r = f(cursor, "param3");
        w7.s = c(cursor, "curr_price");
        w7.t = d(cursor, "bill_no2");
        w7.u = d(cursor, "cash_id");
        w7.v = d(cursor, "adj_id");
        w7.w = d(cursor, "adj_acc");
        w7.x = d(cursor, "curr_mod");
        w7.y = d(cursor, "discount_id");
        w7.z = c(cursor, "d_val");
        w7.A = c(cursor, "paid_amount");
        w7.B = d(cursor, "id2");
        w7.C = d(cursor, "online");
        w7.D = d(cursor, "online_ref");
        w7.E = d(cursor, "tax_id");
        w7.F = c(cursor, "t_val");
        w7.G = f(cursor, "time_");
        w7.H = c(cursor, "cost2");
        w7.I = d(cursor, "cost_id");
        w7.J = c(cursor, "r_cost");
        w7.K = d(cursor, "user_id");
        w7.L = d(cursor, "last_user");
        w7.M = f(cursor, "last_update");
        w7.N = f(cursor, "online_ref2");
        w7.O = f(cursor, "qr");
        w7.P = d(cursor, "z_status");
        w7.Q = d(cursor, "z_unit_id");
        w7.R = d(cursor, "z_user_id");
        w7.S = f(cursor, "z_date");
        w7.T = f(cursor, "z_code");
        w7.U = f(cursor, "z_reply");
        w7.V = f(cursor, "z_uuid");
        w7.W = f(cursor, "z_pih");
        w7.X = f(cursor, "z_inv_hash");
        w7.Y = f(cursor, "z_cleared_inv");
        w7.Z = f(cursor, "xml_file");
        w7.a0 = c(cursor, "curr_price_sar");
        return w7;
    }

    public static W7 b(SQLiteDatabase sQLiteDatabase, long j) {
        Cursor cursorQuery = sQLiteDatabase.query("bills", null, "id = ?  ", new String[]{j + ""}, null, null, "id DESC", "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            W7 w7A = a(cursorQuery);
            cursorQuery.close();
            return w7A;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Double c(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(columnIndex));
    }

    public static Integer d(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(columnIndex));
    }

    public static Long e(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(columnIndex));
    }

    public static String f(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    public static void g(ContentValues contentValues, String str, Double d) {
        if (d != null) {
            contentValues.put(str, d);
        }
    }

    public static void h(ContentValues contentValues, String str, Integer num) {
        if (num != null) {
            contentValues.put(str, num);
        }
    }

    public static void i(ContentValues contentValues, String str, String str2) {
        if (str2 != null) {
            contentValues.put(str, str2);
        }
    }

    public ContentValues j() {
        ContentValues contentValues = new ContentValues();
        i(contentValues, "date_", this.b);
        i(contentValues, "remarks", this.c);
        i(contentValues, "bill_no", this.d);
        h(contentValues, "curr_id", this.e);
        h(contentValues, "bill_type", this.f);
        h(contentValues, "tr_type", this.g);
        h(contentValues, "is_back", this.h);
        h(contentValues, "br_id", this.i);
        h(contentValues, "cus_id", this.j);
        h(contentValues, "tran_status", this.k);
        h(contentValues, "to_br_id", this.l);
        g(contentValues, "amount", this.m);
        g(contentValues, "d_amount", this.n);
        g(contentValues, "tax_amount", this.o);
        i(contentValues, "param1", this.p);
        i(contentValues, "param2", this.q);
        i(contentValues, "param3", this.r);
        g(contentValues, "curr_price", this.s);
        h(contentValues, "bill_no2", this.t);
        h(contentValues, "cash_id", this.u);
        h(contentValues, "adj_id", this.v);
        h(contentValues, "adj_acc", this.w);
        h(contentValues, "curr_mod", this.x);
        h(contentValues, "discount_id", this.y);
        g(contentValues, "d_val", this.z);
        g(contentValues, "paid_amount", this.A);
        h(contentValues, "id2", this.B);
        h(contentValues, "online", this.C);
        h(contentValues, "online_ref", this.D);
        h(contentValues, "tax_id", this.E);
        g(contentValues, "t_val", this.F);
        i(contentValues, "time_", this.G);
        g(contentValues, "cost2", this.H);
        h(contentValues, "cost_id", this.I);
        g(contentValues, "r_cost", this.J);
        h(contentValues, "user_id", this.K);
        h(contentValues, "last_user", this.L);
        i(contentValues, "last_update", this.M);
        i(contentValues, "online_ref2", this.N);
        i(contentValues, "qr", this.O);
        h(contentValues, "z_status", this.P);
        h(contentValues, "z_unit_id", this.Q);
        h(contentValues, "z_user_id", this.R);
        i(contentValues, "z_date", this.S);
        i(contentValues, "z_code", this.T);
        i(contentValues, "z_reply", this.U);
        i(contentValues, "z_uuid", this.V);
        i(contentValues, "z_pih", this.W);
        i(contentValues, "z_inv_hash", this.X);
        i(contentValues, "z_cleared_inv", this.Y);
        i(contentValues, "xml_file", this.Z);
        g(contentValues, "curr_price_sar", this.a0);
        return contentValues;
    }

    public ContentValues k() {
        return j();
    }

    public int l(SQLiteDatabase sQLiteDatabase) {
        if (this.a != null) {
            return sQLiteDatabase.update("bills", k(), "id=?", new String[]{String.valueOf(this.a)});
        }
        throw new IllegalStateException("BillsDto.id is required for update");
    }
}
