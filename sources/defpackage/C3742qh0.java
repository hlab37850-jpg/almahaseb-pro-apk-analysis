package defpackage;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.b;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: qh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3742qh0 implements OnSuccessListener, OnFailureListener, OnCanceledListener, Bh0 {
    public final Executor a;
    public final SuccessContinuation b;
    public final ui0 c;

    public C3742qh0(Executor executor, SuccessContinuation successContinuation, ui0 ui0Var) {
        this.a = executor;
        this.b = successContinuation;
        this.c = ui0Var;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        this.a.execute(new b(this, task));
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.c.c();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.c.a(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.c.b(obj);
    }

    @Override // defpackage.Bh0
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
