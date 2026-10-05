package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: renamed from: vt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4158vt {
    public static boolean a = false;

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0;
        }
        return false;
    }

    public static boolean b(Z00 z00) {
        if (z00.S()) {
            return false;
        }
        if (z00.ia("online_date_done", "").equals(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime())) && a) {
            return false;
        }
        a = true;
        return (z00.ia("PREF_ACCOUNT_NAME", "0").equals("0") || z00.ja("black_list", false)) ? false : true;
    }
}
