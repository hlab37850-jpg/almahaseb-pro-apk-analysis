package defpackage;

import com.google.android.gms.auth.api.accounttransfer.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: gg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2298gg0 extends TaskApiCall {
    public TaskCompletionSource a;

    public /* synthetic */ AbstractC2298gg0(int i, zzk zzkVar) {
        super(null, false, i);
    }

    public abstract void a(zzau zzauVar);

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
        a((zzau) ((zzap) anyClient).getService());
    }
}
