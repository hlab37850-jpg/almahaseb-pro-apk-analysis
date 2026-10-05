package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Lb0 implements OnSuccessListener, OnFailureListener, OnCanceledListener, Bh0 {
    public final Executor a;
    public final Continuation b;
    public final ui0 c;

    public Lb0(Executor executor, Continuation continuation, ui0 ui0Var) {
        this.a = executor;
        this.b = continuation;
        this.c = ui0Var;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        this.a.execute(new a(this, task));
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
