package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.compose.material3.CalendarModelKt;

/* JADX INFO: renamed from: vr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4156vr {
    public static C4156vr b;
    public final SharedPreferences a;

    public C4156vr(Context context) {
        this.a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public static synchronized C4156vr a(Context context) {
        try {
            if (b == null) {
                b = new C4156vr(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public synchronized boolean b(long j) {
        return c("fire-global", j);
    }

    public synchronized boolean c(String str, long j) {
        if (!this.a.contains(str)) {
            this.a.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.a.getLong(str, -1L) < CalendarModelKt.MillisecondsIn24Hours) {
            return false;
        }
        this.a.edit().putLong(str, j).apply();
        return true;
    }
}
