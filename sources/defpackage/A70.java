package defpackage;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class A70 implements ProxyApi.ProxyResult {
    public final Status a;
    public ProxyResponse b;

    public A70(Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
    public final ProxyResponse getResponse() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    public A70(ProxyResponse proxyResponse) {
        this.b = proxyResponse;
        this.a = Status.RESULT_SUCCESS;
    }
}
