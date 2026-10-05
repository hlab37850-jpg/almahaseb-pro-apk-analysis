package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class NetworkApi23 {
    @DoNotInline
    public static final Network getActiveNetworkCompat(ConnectivityManager connectivityManager) {
        AbstractC4492zt.h(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
