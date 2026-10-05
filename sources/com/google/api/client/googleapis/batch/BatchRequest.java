package com.google.api.client.googleapis.batch;

import com.google.api.client.http.BackOffPolicy;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import defpackage.Lr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class BatchRequest {
    private final HttpRequestFactory requestFactory;
    private GenericUrl batchUrl = new GenericUrl("https://www.googleapis.com/batch");
    List<b> requestInfos = new ArrayList();
    private Sleeper sleeper = Sleeper.DEFAULT;

    public class a implements HttpExecuteInterceptor {
        public HttpExecuteInterceptor a;

        public a(HttpExecuteInterceptor httpExecuteInterceptor) {
            this.a = httpExecuteInterceptor;
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void intercept(HttpRequest httpRequest) {
            HttpExecuteInterceptor httpExecuteInterceptor = this.a;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(httpRequest);
            }
            for (b bVar : BatchRequest.this.requestInfos) {
                HttpExecuteInterceptor interceptor = bVar.d.getInterceptor();
                if (interceptor != null) {
                    interceptor.intercept(bVar.d);
                }
            }
        }
    }

    public static class b {
        public final BatchCallback a;
        public final Class b;
        public final Class c;
        public final HttpRequest d;

        public b(BatchCallback batchCallback, Class cls, Class cls2, HttpRequest httpRequest) {
            this.a = batchCallback;
            this.b = cls;
            this.c = cls2;
            this.d = httpRequest;
        }
    }

    public BatchRequest(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.requestFactory = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public void execute() throws IOException {
        boolean z;
        Preconditions.checkState(!this.requestInfos.isEmpty());
        HttpRequest httpRequestBuildPostRequest = this.requestFactory.buildPostRequest(this.batchUrl, null);
        httpRequestBuildPostRequest.setInterceptor(new a(httpRequestBuildPostRequest.getInterceptor()));
        int numberOfRetries = httpRequestBuildPostRequest.getNumberOfRetries();
        BackOffPolicy backOffPolicy = httpRequestBuildPostRequest.getBackOffPolicy();
        if (backOffPolicy != null) {
            backOffPolicy.reset();
        }
        do {
            z = numberOfRetries > 0;
            MultipartContent multipartContent = new MultipartContent();
            multipartContent.getMediaType().setSubType("mixed");
            Iterator<b> it = this.requestInfos.iterator();
            int i = 1;
            while (it.hasNext()) {
                multipartContent.addPart(new MultipartContent.Part(new HttpHeaders().setAcceptEncoding(null).set("Content-ID", (Object) Integer.valueOf(i)), new Lr(it.next().d)));
                i++;
            }
            httpRequestBuildPostRequest.setContent(multipartContent);
            HttpResponse httpResponseExecute = httpRequestBuildPostRequest.execute();
            try {
                com.google.api.client.googleapis.batch.a aVar = new com.google.api.client.googleapis.batch.a(httpResponseExecute.getContent(), "--" + httpResponseExecute.getMediaType().getParameter("boundary"), this.requestInfos, z);
                while (aVar.d) {
                    aVar.e();
                }
                httpResponseExecute.disconnect();
                List<b> list = aVar.e;
                if (list.isEmpty()) {
                    break;
                }
                this.requestInfos = list;
                if (aVar.f && backOffPolicy != null) {
                    long nextBackOffMillis = backOffPolicy.getNextBackOffMillis();
                    if (nextBackOffMillis != -1) {
                        try {
                            this.sleeper.sleep(nextBackOffMillis);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                numberOfRetries--;
            } catch (Throwable th) {
                httpResponseExecute.disconnect();
                throw th;
            }
        } while (z);
        this.requestInfos.clear();
    }

    public GenericUrl getBatchUrl() {
        return this.batchUrl;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public <T, E> BatchRequest queue(HttpRequest httpRequest, Class<T> cls, Class<E> cls2, BatchCallback<T, E> batchCallback) {
        Preconditions.checkNotNull(httpRequest);
        Preconditions.checkNotNull(batchCallback);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(cls2);
        this.requestInfos.add(new b(batchCallback, cls, cls2, httpRequest));
        return this;
    }

    public BatchRequest setBatchUrl(GenericUrl genericUrl) {
        this.batchUrl = genericUrl;
        return this;
    }

    public BatchRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    public int size() {
        return this.requestInfos.size();
    }
}
