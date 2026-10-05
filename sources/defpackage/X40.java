package defpackage;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class X40 extends BinderC1847c50 {
    public final InterfaceC1766b50 b;

    public X40(TaskCompletionSource taskCompletionSource, InterfaceC1766b50 interfaceC1766b50) {
        super(taskCompletionSource);
        this.b = interfaceC1766b50;
    }

    @Override // defpackage.BinderC1847c50, com.google.android.gms.internal.location.zzai
    public final void zzc() {
        this.b.zza();
    }
}
