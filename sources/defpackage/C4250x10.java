package defpackage;

import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: x10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4250x10 {
    public final ApiKey a;
    public final TaskCompletionSource b = new TaskCompletionSource();

    public C4250x10(ApiKey apiKey) {
        this.a = apiKey;
    }

    public final ApiKey a() {
        return this.a;
    }

    public final TaskCompletionSource b() {
        return this.b;
    }
}
