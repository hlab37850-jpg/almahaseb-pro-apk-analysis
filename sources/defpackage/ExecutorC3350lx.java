package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: lx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class ExecutorC3350lx implements Executor {
    public Handler a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
