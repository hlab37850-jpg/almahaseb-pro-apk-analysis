package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class R50 {
    public final SharedPreferences a;
    public final Context b;
    public final Map c = new ArrayMap();

    public R50(Context context) {
        this.b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || k()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            g();
            FirebaseInstanceId.getInstance().zze();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public static String j(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    public final synchronized String a() {
        return this.a.getString("topic_operation_queue", "");
    }

    public final synchronized C3285l60 c(String str, String str2, String str3) {
        return C3285l60.c(this.a.getString(j(str, str2, str3), null));
    }

    public final synchronized void d(String str) {
        this.a.edit().putString("topic_operation_queue", str).apply();
    }

    public final synchronized void e(String str, String str2, String str3, String str4, String str5) {
        String strA = C3285l60.a(str4, str5, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putString(j(str, str2, str3), strA);
        editorEdit.commit();
    }

    public final synchronized long f(String str) {
        Long l = (Long) this.c.get(str);
        if (l != null) {
            return l.longValue();
        }
        return m(str);
    }

    public final synchronized void g() {
        this.c.clear();
        this.a.edit().clear().commit();
    }

    public final synchronized void h(String str, String str2, String str3) {
        String strJ = j(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.remove(strJ);
        editorEdit.commit();
    }

    public final synchronized long i(String str) {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            if (this.a.contains(b(str, "cre"))) {
                jCurrentTimeMillis = m(str);
            } else {
                SharedPreferences.Editor editorEdit = this.a.edit();
                editorEdit.putString(b(str, "cre"), String.valueOf(jCurrentTimeMillis));
                editorEdit.commit();
            }
            this.c.put(str, Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
        return jCurrentTimeMillis;
    }

    public final synchronized boolean k() {
        return this.a.getAll().isEmpty();
    }

    public final synchronized void l(String str) {
        try {
            String strConcat = String.valueOf(str).concat("|T|");
            SharedPreferences.Editor editorEdit = this.a.edit();
            for (String str2 : this.a.getAll().keySet()) {
                if (str2.startsWith(strConcat)) {
                    editorEdit.remove(str2);
                }
            }
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final long m(String str) {
        String string = this.a.getString(b(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
