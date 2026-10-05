package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: renamed from: tD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3946tD {
    public static int a = 1;
    public static int b = 2;
    public static int c;

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                return a;
            }
            if (activeNetworkInfo.getType() == 0) {
                return b;
            }
        }
        return c;
    }

    public static int b(Context context) {
        int iA = a(context);
        if (iA == a) {
            return 1;
        }
        return iA == b ? 2 : 0;
    }
}
