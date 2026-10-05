package defpackage;

import com.google.android.gms.common.api.internal.zaad;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: w10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4169w10 implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource a;
    public final /* synthetic */ zaad b;

    public C4169w10(zaad zaadVar, TaskCompletionSource taskCompletionSource) {
        this.b = zaadVar;
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.b.zab.remove(this.a);
    }
}
