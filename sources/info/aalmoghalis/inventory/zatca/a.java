package info.aalmoghalis.inventory.zatca;

import android.database.Cursor;
import defpackage.Z00;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public Z00 a;

    public a(Z00 z00) {
        this.a = z00;
    }

    public final BigDecimal a(Cursor cursor, String str) {
        String strG = g(cursor, str);
        return (strG == null || strG.trim().isEmpty()) ? BigDecimal.ZERO : new BigDecimal(strG);
    }

    public List b(long j, int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = this.a.a.rawQuery("SELECT c.item_id AS item_id, d.name AS item_name, e.name AS unit_name, COALESCE(c.qty, 0) AS qty, ROUND((((((COALESCE(c.cost_price, 0) + COALESCE(c.sls_u_price, 0)) * COALESCE(c.u_val, 0))  / NULLIF((COALESCE(c.qty_pr, 0) * COALESCE(c.u_val, 0)), 0)))), ?) AS unit_price, ROUND(((((COALESCE(c.cost_price, 0) + COALESCE(c.sls_u_price, 0)) * COALESCE(c.u_val, 0) * COALESCE(c.qty, 0)) )), ?) AS total_price, ROUND(((((COALESCE(c.cost_price, 0) + COALESCE(c.sls_u_price, 0)-COALESCE(c.d_amount,0))*c.qty_pr*c.u_val))*(0+a.t_val/100)), ?) AS t_val, ROUND(COALESCE(c.d_amount, 0)*c.qty_pr*c.u_val, ?) AS d_val, ROUND(COALESCE(a.t_val, 0), ?) AS tax_per FROM bills a JOIN bill_transactions c ON c.bill_id = a.id JOIN items d ON c.item_id = d.id JOIN units e ON c.unit_id = e.id WHERE COALESCE(a.tax_amount, 0) > 0 AND a.id = ? AND a.tr_type = ?", new String[]{String.valueOf(2), String.valueOf(2), String.valueOf(2), String.valueOf(2), String.valueOf(2), String.valueOf(j), String.valueOf(i)});
        while (cursorRawQuery.moveToNext()) {
            try {
                arrayList.add(new b(g(cursorRawQuery, "item_id"), g(cursorRawQuery, "item_name"), g(cursorRawQuery, "unit_name"), a(cursorRawQuery, "qty"), a(cursorRawQuery, "unit_price"), a(cursorRawQuery, "total_price"), a(cursorRawQuery, "t_val"), a(cursorRawQuery, "tax_per"), a(cursorRawQuery, "d_val")));
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public List c(long j, int i) {
        List listB = b(j, i);
        ArrayList arrayList = new ArrayList();
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((b) it.next()).a());
        }
        return arrayList;
    }

    public d.g d(long j, int i) {
        Cursor cursorRawQuery = this.a.a.rawQuery("SELECT a.id AS bill_id, COALESCE(a.date_, '') || 'T' || COALESCE(a.time_, '') AS date_time, b.z_name AS comp_name, b.vat_no AS tax_no, ROUND(COALESCE(a.amount, 0), ?) AS tot_amount, COALESCE(a.tax_amount, 0) AS tax_amount, a.time_ AS time_, ROUND(COALESCE(a.d_amount, 0), ?) AS d_amount, (SELECT per FROM tax WHERE id IN     (SELECT tax_id FROM bill_transactions bt WHERE bt.bill_id = a.id)  ORDER BY id LIMIT 1) AS tax_per, COALESCE((SELECT c.vat_no FROM customers c WHERE c.id = a.cus_id), '') AS cus_vat_no, COALESCE((SELECT c.cr_no FROM customers c WHERE c.id = a.cus_id), '') AS cus_cr_no, COALESCE((SELECT c.name FROM customers c WHERE c.id = a.cus_id), '') AS cus_name, COALESCE((SELECT c.address FROM customers c WHERE c.id = a.cus_id), '') AS cus_address, COALESCE((SELECT c.id FROM customers c WHERE c.id = a.cus_id), 0) AS cus_id, COALESCE(a.is_back, 0) AS is_back, a.bill_no AS bill_no, COALESCE(a.remarks, '') AS remarks, a.bill_no2 AS bill_no2, b.vat_no AS company_tax_no, b.cr_no AS company_cr_no, a.date_ AS bill_date, a.z_unit_id AS z_unit_id, a.br_id AS br_id, b.z_name AS org_name, a.bill_no AS r_bill_id, COALESCE(CASE     WHEN a.z_unit_id IS NULL THEN 0     ELSE (SELECT cc.auto_ FROM z_units cc WHERE cc.id = a.z_unit_id) END, 0) AS unit_auto, ROUND(COALESCE(a.curr_price, 0), ?) AS curr_price, (SELECT cc.code_name FROM currency cc WHERE cc.id = a.curr_id) AS curr_code FROM bills a , z_units b   WHERE a.br_id=b.br_id and a.z_unit_id=b.id  and  a.id = ? AND a.tr_type = ?  and b.is_active=1 ", new String[]{String.valueOf(2), String.valueOf(2), String.valueOf(2), String.valueOf(j), String.valueOf(i)});
        try {
            if (!cursorRawQuery.moveToFirst()) {
                cursorRawQuery.close();
                return null;
            }
            d.g gVar = new d.g();
            gVar.a = g(cursorRawQuery, "br_id");
            gVar.b = g(cursorRawQuery, "bill_id");
            gVar.c = g(cursorRawQuery, "date_time");
            gVar.d = g(cursorRawQuery, "curr_code");
            gVar.e = e(cursorRawQuery, "curr_price");
            gVar.f = g(cursorRawQuery, "org_name");
            gVar.g = g(cursorRawQuery, "company_tax_no");
            gVar.h = g(cursorRawQuery, "cus_name");
            gVar.i = g(cursorRawQuery, "cus_vat_no");
            gVar.j = g(cursorRawQuery, "cus_address");
            boolean z = true;
            if (f(cursorRawQuery, "is_back") != 1) {
                z = false;
            }
            gVar.k = z;
            gVar.l = g(cursorRawQuery, "remarks");
            gVar.m = g(cursorRawQuery, "r_bill_id");
            cursorRawQuery.close();
            return gVar;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final Double e(Cursor cursor, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(columnIndexOrThrow));
    }

    public final int f(Cursor cursor, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return 0;
        }
        return cursor.getInt(columnIndexOrThrow);
    }

    public final String g(Cursor cursor, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return null;
        }
        return cursor.getString(columnIndexOrThrow);
    }
}
