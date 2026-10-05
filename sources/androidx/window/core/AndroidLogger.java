package androidx.window.core;

import android.util.Log;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE = new AndroidLogger();

    private AndroidLogger() {
    }

    @Override // androidx.window.core.Logger
    public void debug(String str, String str2) {
        AbstractC4492zt.h(str, "tag");
        AbstractC4492zt.h(str2, "message");
        Log.d(str, str2);
    }
}
