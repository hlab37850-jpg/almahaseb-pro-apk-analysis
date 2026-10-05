package androidx.work.impl;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class Api21Impl {
    public static final Api21Impl INSTANCE = new Api21Impl();

    private Api21Impl() {
    }

    @DoNotInline
    public final File getNoBackupFilesDir(Context context) {
        AbstractC4492zt.h(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        AbstractC4492zt.g(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
