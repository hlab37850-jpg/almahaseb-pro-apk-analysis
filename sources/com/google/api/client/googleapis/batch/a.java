package com.google.api.client.googleapis.batch;

import com.google.api.client.http.BackOffPolicy;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.util.ByteStreams;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final String a;
    public final List b;
    public final InputStream c;
    public boolean f;
    public final boolean h;
    public boolean d = true;
    public List e = new ArrayList();
    public int g = 0;

    /* JADX INFO: renamed from: com.google.api.client.googleapis.batch.a$a, reason: collision with other inner class name */
    public class C0197a extends FilterInputStream {
        public C0197a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public static class b extends LowLevelHttpRequest {
        public InputStream a;
        public int b;
        public List c;
        public List d;

        public b(InputStream inputStream, int i, List list, List list2) {
            this.a = inputStream;
            this.b = i;
            this.c = list;
            this.d = list2;
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public void addHeader(String str, String str2) {
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public LowLevelHttpResponse execute() {
            return new c(this.a, this.b, this.c, this.d);
        }
    }

    public static class c extends LowLevelHttpResponse {
        public InputStream a;
        public int b;
        public List c;
        public List d;

        public c(InputStream inputStream, int i, List list, List list2) {
            this.c = new ArrayList();
            new ArrayList();
            this.a = inputStream;
            this.b = i;
            this.c = list;
            this.d = list2;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public InputStream getContent() {
            return this.a;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getContentEncoding() {
            return null;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public long getContentLength() {
            return 0L;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getContentType() {
            return null;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public int getHeaderCount() {
            return this.c.size();
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getHeaderName(int i) {
            return (String) this.c.get(i);
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getHeaderValue(int i) {
            return (String) this.d.get(i);
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getReasonPhrase() {
            return null;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public int getStatusCode() {
            return this.b;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getStatusLine() {
            return null;
        }
    }

    public static class d extends HttpTransport {
        public int a;
        public InputStream b;
        public List c;
        public List d;

        public d(int i, InputStream inputStream, List list, List list2) {
            this.a = i;
            this.b = inputStream;
            this.c = list;
            this.d = list2;
        }

        @Override // com.google.api.client.http.HttpTransport
        public LowLevelHttpRequest buildRequest(String str, String str2) {
            return new b(this.b, this.a, this.c, this.d);
        }
    }

    public a(InputStream inputStream, String str, List list, boolean z) throws IOException {
        this.a = str;
        this.b = list;
        this.h = z;
        this.c = inputStream;
        a(f());
    }

    public static InputStream h(byte[] bArr) {
        int length = bArr.length;
        if (length > 0 && bArr[length - 1] == 10) {
            length--;
        }
        if (length > 0 && bArr[length - 1] == 13) {
            length--;
        }
        return new ByteArrayInputStream(bArr, 0, length);
    }

    public static String i(String str) {
        if (str.endsWith(StringUtilities.CRLF)) {
            return str.substring(0, str.length() - 2);
        }
        return str.endsWith(StringUtilities.LF) ? str.substring(0, str.length() - 1) : str;
    }

    public final void a(String str) throws IOException {
        if (str.equals(this.a + "--")) {
            this.d = false;
            this.c.close();
        }
    }

    public final HttpResponse b(int i, InputStream inputStream, List list, List list2) {
        HttpRequest httpRequestBuildPostRequest = new d(i, inputStream, list, list2).createRequestFactory().buildPostRequest(new GenericUrl(HttpTesting.SIMPLE_URL), null);
        httpRequestBuildPostRequest.setLoggingEnabled(false);
        httpRequestBuildPostRequest.setThrowExceptionOnExecuteError(false);
        return httpRequestBuildPostRequest.execute();
    }

    public final Object c(Class cls, HttpResponse httpResponse, BatchRequest.b bVar) {
        if (cls == Void.class) {
            return null;
        }
        return bVar.d.getParser().parseAndClose(httpResponse.getContent(), httpResponse.getContentCharset(), cls);
    }

    public final void d(BatchRequest.b bVar, int i, HttpResponse httpResponse) {
        BatchCallback batchCallback = bVar.a;
        HttpHeaders headers = httpResponse.getHeaders();
        HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler = bVar.d.getUnsuccessfulResponseHandler();
        BackOffPolicy backOffPolicy = bVar.d.getBackOffPolicy();
        boolean z = false;
        this.f = false;
        if (HttpStatusCodes.isSuccess(i)) {
            if (batchCallback == null) {
                return;
            }
            batchCallback.onSuccess(c(bVar.b, httpResponse, bVar), headers);
            return;
        }
        HttpContent content = bVar.d.getContent();
        boolean z2 = this.h && (content == null || content.retrySupported());
        boolean zHandleResponse = unsuccessfulResponseHandler != null ? unsuccessfulResponseHandler.handleResponse(bVar.d, httpResponse, z2) : false;
        if (!zHandleResponse) {
            if (bVar.d.handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                z = true;
            } else if (z2 && backOffPolicy != null && backOffPolicy.isBackOffRequired(httpResponse.getStatusCode())) {
                this.f = true;
            }
        }
        if (z2 && (zHandleResponse || this.f || z)) {
            this.e.add(bVar);
        } else {
            if (batchCallback == null) {
                return;
            }
            batchCallback.onFailure(c(bVar.c, httpResponse, bVar), headers);
        }
    }

    public void e() throws IOException {
        String strF;
        String strF2;
        InputStream c0197a;
        String strG;
        this.g++;
        do {
            strF = f();
            if (strF == null) {
                break;
            }
        } while (!strF.equals(""));
        int i = Integer.parseInt(f().split(" ")[1]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j = -1;
        while (true) {
            strF2 = f();
            if (strF2 == null || strF2.equals("")) {
                break;
            }
            String[] strArrSplit = strF2.split(": ", 2);
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            arrayList.add(str);
            arrayList2.add(str2);
            if (com.google.common.net.HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str.trim())) {
                j = Long.parseLong(str2);
            }
        }
        if (j == -1) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                strG = g();
                if (strG == null || strG.startsWith(this.a)) {
                    break;
                } else {
                    byteArrayOutputStream.write(strG.getBytes("ISO-8859-1"));
                }
            }
            c0197a = h(byteArrayOutputStream.toByteArray());
            strF2 = i(strG);
        } else {
            c0197a = new C0197a(ByteStreams.limit(this.c, j));
        }
        d((BatchRequest.b) this.b.get(this.g - 1), i, b(i, c0197a, arrayList, arrayList2));
        while (true) {
            if (c0197a.skip(j) <= 0 && c0197a.read() == -1) {
                break;
            }
        }
        if (j != -1) {
            strF2 = f();
        }
        while (strF2 != null && strF2.length() == 0) {
            strF2 = f();
        }
        a(strF2);
    }

    public final String f() {
        return i(g());
    }

    public final String g() throws IOException {
        int i = this.c.read();
        if (i == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i != -1) {
            sb.append((char) i);
            if (i == 10) {
                break;
            }
            i = this.c.read();
        }
        return sb.toString();
    }
}
