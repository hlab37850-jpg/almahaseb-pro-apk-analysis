package defpackage;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
public final class M60 {
    public final Intent a;
    public final TaskCompletionSource b = new TaskCompletionSource();

    public M60(Intent intent) {
        this.a = intent;
    }

    public final Task a() {
        return this.b.getTask();
    }

    public final void b() {
        this.b.trySetResult(null);
    }

    public final /* synthetic */ void c() {
        String action = this.a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        b();
    }
}
