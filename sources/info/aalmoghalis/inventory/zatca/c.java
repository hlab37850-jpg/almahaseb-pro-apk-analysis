package info.aalmoghalis.inventory.zatca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.Z00;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public SQLiteDatabase a;
    public Z00 b;

    public c(Context context) {
        this.b = new Z00(this.a, context.getApplicationContext());
    }

    public final void a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_active", (Integer) 0);
        contentValues.put("date_", Long.valueOf(System.currentTimeMillis()));
        this.b.a.update("z_units", contentValues, "br_id = ? AND device_id = substr(?,1,10) AND is_active = 1", new String[]{str, str2 + ""});
    }

    public final void b(String str, String str2, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_active", (Integer) 0);
        contentValues.put("date_", Long.valueOf(System.currentTimeMillis()));
        this.b.a.update("z_units", contentValues, "br_id = ? AND device_id = substr(?,1,10) AND env_type = ? AND is_active = 1 AND id <> ?", new String[]{str, str2 + "", str3, String.valueOf(i)});
    }

    public e.g c(String str, String str2, String str3) {
        Cursor cursorQuery = this.b.a.query("z_units", null, "br_id = ? AND env_type = ? AND device_id = substr(?,1,10) AND is_active = 1", new String[]{str, str3, str2 + ""}, null, null, "id DESC", "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            e.g gVarK = k(cursorQuery);
            cursorQuery.close();
            return gVarK;
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

    public e.g d(int i) {
        Cursor cursorQuery = this.b.a.query("z_units", null, "id = ? AND is_active = 1", new String[]{String.valueOf(i)}, null, null, null, "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            e.g gVarK = k(cursorQuery);
            cursorQuery.close();
            return gVarK;
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

    public e.g e(String str, String str2) {
        Cursor cursorQuery = this.b.a.query("z_units", null, "br_id = ? AND device_id = substr(?,1,10) AND is_active = 1", new String[]{str, str2 + ""}, null, null, "id DESC", "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            e.g gVarK = k(cursorQuery);
            cursorQuery.close();
            return gVarK;
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

    public e.g f(int i) {
        Cursor cursorQuery = this.b.a.query("z_units", null, "id = ?", new String[]{String.valueOf(i)}, null, null, null, "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            e.g gVarK = k(cursorQuery);
            cursorQuery.close();
            return gVarK;
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

    public double g(String str, String str2) throws Exception {
        String string;
        String upperCase = str == null ? "" : str.trim().toUpperCase(Locale.US);
        if ("SAR".equals(upperCase)) {
            return 1.0d;
        }
        String strSubstring = str2.substring(0, 10);
        Cursor cursorRawQuery = this.b.a.rawQuery("SELECT id FROM currency WHERE LOWER(code_name) = LOWER(?) LIMIT 1", new String[]{upperCase});
        try {
            Integer numValueOf = cursorRawQuery.moveToFirst() ? Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow(HTML.Attribute.ID))) : null;
            cursorRawQuery.close();
            if (numValueOf == null) {
                throw new Exception("Currency not found: " + upperCase);
            }
            Cursor cursorRawQuery2 = this.b.a.rawQuery("SELECT price_sar FROM currency_price WHERE curr_id = ? AND f_date <= ? AND (t_date IS NULL OR t_date >= ?) ORDER BY f_date DESC LIMIT 1", new String[]{String.valueOf(numValueOf), strSubstring, strSubstring});
            try {
                double d = (!cursorRawQuery2.moveToFirst() || (string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("price_sar"))) == null || string.trim().length() <= 0) ? 0.0d : Double.parseDouble(string.trim());
                cursorRawQuery2.close();
                double d2 = d > 0.0d ? d : 0.0d;
                Log.d("Zatca=", "rate=" + d2 + ":" + strSubstring + ":" + upperCase);
                return d.Y(d2);
            } catch (Throwable th) {
                cursorRawQuery2.close();
                throw th;
            }
        } catch (Throwable th2) {
            cursorRawQuery.close();
            throw th2;
        }
    }

    public int h(Integer num, String str) {
        Cursor cursorQuery = this.b.a.query("z_units", null, "br_id = ?  AND device_id= substr(?,1,10)  AND is_active = 1", new String[]{num + "", str + ""}, null, null, "id DESC", "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1;
            }
            int i = k(cursorQuery).a;
            cursorQuery.close();
            return i;
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

    public boolean i(String str, String str2, String str3) {
        return c(str, str2, str3) != null;
    }

    public e.g j(e.g gVar) {
        this.b.a.beginTransaction();
        try {
            a(gVar.b, gVar.c);
            gVar.a = (int) this.b.a.insertOrThrow("z_units", null, l(gVar));
            this.b.a.setTransactionSuccessful();
            return gVar.a();
        } finally {
            this.b.a.endTransaction();
        }
    }

    public final e.g k(Cursor cursor) {
        e.g gVar = new e.g();
        gVar.a = cursor.getInt(cursor.getColumnIndexOrThrow(HTML.Attribute.ID));
        gVar.b = cursor.getString(cursor.getColumnIndexOrThrow("br_id"));
        gVar.l = cursor.getString(cursor.getColumnIndexOrThrow("taxer_id"));
        gVar.m = cursor.getString(cursor.getColumnIndexOrThrow("egs_id"));
        gVar.n = cursor.getString(cursor.getColumnIndexOrThrow("cert_id"));
        gVar.j = cursor.getInt(cursor.getColumnIndexOrThrow("icv"));
        gVar.d = cursor.getString(cursor.getColumnIndexOrThrow("env_type"));
        gVar.p = cursor.getString(cursor.getColumnIndexOrThrow("serial_no"));
        gVar.e = cursor.getString(cursor.getColumnIndexOrThrow("unit_name"));
        gVar.f = cursor.getString(cursor.getColumnIndexOrThrow("z_name"));
        gVar.q = cursor.getString(cursor.getColumnIndexOrThrow("z_address"));
        gVar.g = cursor.getString(cursor.getColumnIndexOrThrow("vat_no"));
        gVar.h = cursor.getString(cursor.getColumnIndexOrThrow("cr_no"));
        gVar.i = cursor.getInt(cursor.getColumnIndexOrThrow("is_active")) == 1;
        gVar.o = cursor.getString(cursor.getColumnIndexOrThrow("otp"));
        gVar.k = cursor.getInt(cursor.getColumnIndexOrThrow("auto_")) == 1;
        return gVar;
    }

    public final ContentValues l(e.g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("br_id", gVar.b);
        contentValues.put("device_id", gVar.c);
        contentValues.put("taxer_id", gVar.l);
        contentValues.put("egs_id", gVar.m);
        contentValues.put("cert_id", gVar.n);
        contentValues.put("icv", Integer.valueOf(gVar.j));
        contentValues.put("env_type", gVar.d);
        contentValues.put("serial_no", gVar.p);
        contentValues.put("unit_name", gVar.e);
        contentValues.put("z_name", gVar.f);
        contentValues.put("z_address", gVar.q);
        contentValues.put("is_active", Integer.valueOf(gVar.i ? 1 : 0));
        contentValues.put("otp", gVar.o);
        contentValues.put("vat_no", gVar.g);
        contentValues.put("cr_no", gVar.h);
        contentValues.put("auto_", Integer.valueOf(gVar.k ? 1 : 0));
        contentValues.put("date_", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public boolean m(int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("auto_", Integer.valueOf(z ? 1 : 0));
        contentValues.put("date_", Long.valueOf(System.currentTimeMillis()));
        return this.b.a.update("z_units", contentValues, "id = ?", new String[]{String.valueOf(i)}) > 0;
    }

    public e.g n(e.g gVar) {
        this.b.a.beginTransaction();
        try {
            b(gVar.b, gVar.c, gVar.d, gVar.a);
            this.b.a.update("z_units", l(gVar), "id = ?", new String[]{String.valueOf(gVar.a)});
            this.b.a.setTransactionSuccessful();
            return f(gVar.a);
        } finally {
            this.b.a.endTransaction();
        }
    }

    public e.g o(e.g gVar) {
        this.b.a.update("z_units", l(gVar), "id = ?", new String[]{String.valueOf(gVar.a)});
        return f(gVar.a);
    }
}
