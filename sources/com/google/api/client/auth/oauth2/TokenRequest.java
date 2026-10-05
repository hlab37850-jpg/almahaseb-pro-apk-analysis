package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class TokenRequest extends GenericData {
    HttpExecuteInterceptor clientAuthentication;

    @Key("grant_type")
    private String grantType;
    private final JsonFactory jsonFactory;
    HttpRequestInitializer requestInitializer;

    @Key("scope")
    private String scopes;
    private GenericUrl tokenServerUrl;
    private final HttpTransport transport;

    public class a implements HttpRequestInitializer {

        /* JADX INFO: renamed from: com.google.api.client.auth.oauth2.TokenRequest$a$a, reason: collision with other inner class name */
        public class C0195a implements HttpExecuteInterceptor {
            public final /* synthetic */ HttpExecuteInterceptor a;

            public C0195a(HttpExecuteInterceptor httpExecuteInterceptor) {
                this.a = httpExecuteInterceptor;
            }

            @Override // com.google.api.client.http.HttpExecuteInterceptor
            public void intercept(HttpRequest httpRequest) {
                HttpExecuteInterceptor httpExecuteInterceptor = this.a;
                if (httpExecuteInterceptor != null) {
                    httpExecuteInterceptor.intercept(httpRequest);
                }
                HttpExecuteInterceptor httpExecuteInterceptor2 = TokenRequest.this.clientAuthentication;
                if (httpExecuteInterceptor2 != null) {
                    httpExecuteInterceptor2.intercept(httpRequest);
                }
            }
        }

        public a() {
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) {
            HttpRequestInitializer httpRequestInitializer = TokenRequest.this.requestInitializer;
            if (httpRequestInitializer != null) {
                httpRequestInitializer.initialize(httpRequest);
            }
            httpRequest.setInterceptor(new C0195a(httpRequest.getInterceptor()));
        }
    }

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        this.transport = (HttpTransport) Preconditions.checkNotNull(httpTransport);
        this.jsonFactory = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        setTokenServerUrl(genericUrl);
        setGrantType(str);
    }

    public TokenResponse execute() {
        return (TokenResponse) executeUnparsed().parseAs(TokenResponse.class);
    }

    public final HttpResponse executeUnparsed() throws IOException {
        HttpRequest httpRequestBuildPostRequest = this.transport.createRequestFactory(new a()).buildPostRequest(this.tokenServerUrl, new UrlEncodedContent(this));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(this.jsonFactory));
        httpRequestBuildPostRequest.setThrowExceptionOnExecuteError(false);
        HttpResponse httpResponseExecute = httpRequestBuildPostRequest.execute();
        if (httpResponseExecute.isSuccessStatusCode()) {
            return httpResponseExecute;
        }
        throw TokenResponseException.from(this.jsonFactory, httpResponseExecute);
    }

    public final HttpExecuteInterceptor getClientAuthentication() {
        return this.clientAuthentication;
    }

    public final String getGrantType() {
        return this.grantType;
    }

    public final JsonFactory getJsonFactory() {
        return this.jsonFactory;
    }

    public final HttpRequestInitializer getRequestInitializer() {
        return this.requestInitializer;
    }

    public final String getScopes() {
        return this.scopes;
    }

    public final GenericUrl getTokenServerUrl() {
        return this.tokenServerUrl;
    }

    public final HttpTransport getTransport() {
        return this.transport;
    }

    public TokenRequest setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.clientAuthentication = httpExecuteInterceptor;
        return this;
    }

    public TokenRequest setGrantType(String str) {
        this.grantType = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public TokenRequest setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
        this.requestInitializer = httpRequestInitializer;
        return this;
    }

    public TokenRequest setScopes(Collection<String> collection) {
        this.scopes = collection == null ? null : Joiner.on(' ').join(collection);
        return this;
    }

    public TokenRequest setTokenServerUrl(GenericUrl genericUrl) {
        this.tokenServerUrl = genericUrl;
        Preconditions.checkArgument(genericUrl.getFragment() == null);
        return this;
    }

    @Override // com.google.api.client.util.GenericData
    public TokenRequest set(String str, Object obj) {
        return (TokenRequest) super.set(str, obj);
    }
}
