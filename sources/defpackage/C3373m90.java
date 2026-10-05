package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: m90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3373m90 implements Bh0 {
    public final Executor a;
    public final Continuation b;
    public final ui0 c;

    public C3373m90(Executor executor, Continuation continuation, ui0 ui0Var) {
        this.a = executor;
        this.b = continuation;
        this.c = ui0Var;
    }

    @Override // defpackage.Bh0
    public final void a(Task task) {
        this.a.execute(new L70(this, task));
    }

    @Override // defpackage.Bh0
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
