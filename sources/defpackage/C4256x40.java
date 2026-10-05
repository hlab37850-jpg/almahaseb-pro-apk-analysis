package defpackage;

import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: x40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4256x40 implements InterfaceC3770r40 {
    public final Object a = new Object();
    public final int b;
    public final ui0 c;
    public int d;
    public int e;
    public int f;
    public Exception g;
    public boolean h;

    public C4256x40(int i, ui0 ui0Var) {
        this.b = i;
        this.c = ui0Var;
    }

    private final void a() {
        if (this.d + this.e + this.f == this.b) {
            if (this.g == null) {
                if (this.h) {
                    this.c.c();
                    return;
                } else {
                    this.c.b(null);
                    return;
                }
            }
            this.c.a(new ExecutionException(this.e + " out of " + this.b + " underlying tasks failed", this.g));
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.a) {
            this.f++;
            this.h = true;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.a) {
            this.e++;
            this.g = exc;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        synchronized (this.a) {
            this.d++;
            a();
        }
    }
}
