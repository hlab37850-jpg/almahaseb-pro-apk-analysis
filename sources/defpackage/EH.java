package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EH {
    public static SharedPreferences a;

    public static String a(String str) {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str, "");
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void c(String str, String str2) {
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
