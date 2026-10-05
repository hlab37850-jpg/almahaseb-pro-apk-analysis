package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MO {
    public static void a(Context context) {
        context.getSharedPreferences("session", 0).edit().clear().apply();
        C2160f10.h = -1;
    }

    public static int b(Context context) {
        int i = context.getSharedPreferences("session", 0).getInt("login_user_id", -1);
        C2160f10.h = i;
        return i;
    }

    public static void c(Context context, int i) {
        context.getSharedPreferences("session", 0).edit().putInt("login_user_id", i).apply();
        C2160f10.h = i;
    }
}
