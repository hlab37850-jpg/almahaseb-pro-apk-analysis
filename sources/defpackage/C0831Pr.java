package defpackage;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: renamed from: Pr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0831Pr implements InterfaceC0753Mr {
    public final SSLSocketFactory a;

    /* JADX INFO: renamed from: Pr$a */
    public interface a {
    }

    public C0831Pr() {
        this(null);
    }

    public static void b(HttpURLConnection httpURLConnection, AbstractC3712qL abstractC3712qL) throws IOException {
        byte[] bArrH = abstractC3712qL.h();
        if (bArrH != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, abstractC3712qL.i());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrH);
            dataOutputStream.close();
        }
    }

    public static HttpEntity d(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    public static void f(HttpURLConnection httpURLConnection, AbstractC3712qL abstractC3712qL) throws IOException {
        switch (abstractC3712qL.m()) {
            case -1:
                byte[] bArrP = abstractC3712qL.p();
                if (bArrP != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(HttpMethods.POST);
                    httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, abstractC3712qL.q());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArrP);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod(HttpMethods.GET);
                return;
            case 1:
                httpURLConnection.setRequestMethod(HttpMethods.POST);
                b(httpURLConnection, abstractC3712qL);
                return;
            case 2:
                httpURLConnection.setRequestMethod(HttpMethods.PUT);
                b(httpURLConnection, abstractC3712qL);
                return;
            case 3:
                httpURLConnection.setRequestMethod(HttpMethods.DELETE);
                return;
            case 4:
                httpURLConnection.setRequestMethod(HttpMethods.HEAD);
                return;
            case 5:
                httpURLConnection.setRequestMethod(HttpMethods.OPTIONS);
                return;
            case 6:
                httpURLConnection.setRequestMethod(HttpMethods.TRACE);
                return;
            case 7:
                b(httpURLConnection, abstractC3712qL);
                httpURLConnection.setRequestMethod(HttpMethods.PATCH);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // defpackage.InterfaceC0753Mr
    public HttpResponse a(AbstractC3712qL abstractC3712qL, Map map) throws IOException {
        String strX = abstractC3712qL.x();
        HashMap map2 = new HashMap();
        map2.putAll(abstractC3712qL.l());
        map2.putAll(map);
        HttpURLConnection httpURLConnectionE = e(new URL(strX), abstractC3712qL);
        for (String str : map2.keySet()) {
            httpURLConnectionE.addRequestProperty(str, (String) map2.get(str));
        }
        f(httpURLConnectionE, abstractC3712qL);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (httpURLConnectionE.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, httpURLConnectionE.getResponseCode(), httpURLConnectionE.getResponseMessage()));
        basicHttpResponse.setEntity(d(httpURLConnectionE));
        for (Map.Entry<String, List<String>> entry : httpURLConnectionE.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }

    public HttpURLConnection c(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public final HttpURLConnection e(URL url, AbstractC3712qL abstractC3712qL) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionC = c(url);
        int iV = abstractC3712qL.v();
        httpURLConnectionC.setConnectTimeout(iV);
        httpURLConnectionC.setReadTimeout(iV);
        httpURLConnectionC.setUseCaches(false);
        httpURLConnectionC.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.a) != null) {
            ((HttpsURLConnection) httpURLConnectionC).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionC;
    }

    public C0831Pr(a aVar) {
        this(aVar, null);
    }

    public C0831Pr(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }
}
