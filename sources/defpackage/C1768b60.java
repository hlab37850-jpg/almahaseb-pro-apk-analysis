package defpackage;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskExecutors;

/* JADX INFO: renamed from: b60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1768b60 extends CancellationToken {
    public final ui0 a = new ui0();

    public final void a() {
        this.a.e(null);
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.a.isComplete();
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.a.addOnSuccessListener(TaskExecutors.MAIN_THREAD, new C4426z30(this, onTokenCanceledListener));
        return this;
    }
}
