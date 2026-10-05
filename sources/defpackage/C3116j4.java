package defpackage;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: renamed from: j4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3116j4 extends LowLevelHttpRequest {
    public final HttpClient a;
    public final HttpRequestBase b;

    public C3116j4(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.a = httpClient;
        this.b = httpRequestBase;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) {
        this.b.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() {
        if (getStreamingContent() != null) {
            HttpRequestBase httpRequestBase = this.b;
            Preconditions.checkArgument(httpRequestBase instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", httpRequestBase.getRequestLine().getMethod());
            C3492nf c3492nf = new C3492nf(getContentLength(), getStreamingContent());
            c3492nf.setContentEncoding(getContentEncoding());
            c3492nf.setContentType(getContentType());
            ((HttpEntityEnclosingRequest) this.b).setEntity(c3492nf);
        }
        HttpRequestBase httpRequestBase2 = this.b;
        return new C3198k4(httpRequestBase2, this.a.execute(httpRequestBase2));
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void setTimeout(int i, int i2) {
        HttpParams params = this.b.getParams();
        ConnManagerParams.setTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i2);
    }
}
