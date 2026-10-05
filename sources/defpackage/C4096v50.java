package defpackage;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: v50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4096v50 {
    public final Executor a;
    public final Map b = new ArrayMap();

    public C4096v50(Executor executor) {
        this.a = executor;
    }

    public final /* synthetic */ Task a(Pair pair, Task task) {
        synchronized (this) {
            this.b.remove(pair);
        }
        return task;
    }

    public final synchronized Task b(String str, String str2, InterfaceC4258x50 interfaceC4258x50) {
        final Pair pair = new Pair(str, str2);
        Task task = (Task) this.b.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(strValueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(strValueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        Task taskContinueWithTask = interfaceC4258x50.zza().continueWithTask(this.a, new Continuation(this, pair) { // from class: C50
            public final C4096v50 a;
            public final Pair b;

            {
                this.a = this;
                this.b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.a.a(this.b, task2);
            }
        });
        this.b.put(pair, taskContinueWithTask);
        return taskContinueWithTask;
    }
}
