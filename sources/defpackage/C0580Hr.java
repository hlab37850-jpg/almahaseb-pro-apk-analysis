package defpackage;

import com.google.api.client.util.Preconditions;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* JADX INFO: renamed from: Hr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0580Hr extends HttpEntityEnclosingRequestBase {
    public final String a;

    public C0580Hr(String str, String str2) {
        this.a = (String) Preconditions.checkNotNull(str);
        setURI(URI.create(str2));
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.a;
    }
}
