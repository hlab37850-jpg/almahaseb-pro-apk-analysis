package androidx.work.impl.utils;

import android.app.Application;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
final class Api28Impl {
    public static final Api28Impl INSTANCE = new Api28Impl();

    private Api28Impl() {
    }

    @DoNotInline
    public final String getProcessName() {
        String processName = Application.getProcessName();
        AbstractC4492zt.g(processName, "getProcessName()");
        return processName;
    }
}
