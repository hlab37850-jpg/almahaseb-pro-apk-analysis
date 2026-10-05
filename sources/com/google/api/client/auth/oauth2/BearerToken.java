package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import com.google.api.client.util.Preconditions;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class BearerToken {
    static final Pattern INVALID_TOKEN_ERROR = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");
    static final String PARAM_NAME = "access_token";

    public static final class a implements Credential.AccessMethod {
        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public String getAccessTokenFromRequest(HttpRequest httpRequest) {
            List<String> authorizationAsList = httpRequest.getHeaders().getAuthorizationAsList();
            if (authorizationAsList == null) {
                return null;
            }
            for (String str : authorizationAsList) {
                if (str.startsWith("Bearer ")) {
                    return str.substring(7);
                }
            }
            return null;
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public void intercept(HttpRequest httpRequest, String str) {
            httpRequest.getHeaders().setAuthorization("Bearer " + str);
        }
    }

    public static final class b implements Credential.AccessMethod {
        public static Map a(HttpRequest httpRequest) {
            return Data.mapOf(UrlEncodedContent.getContent(httpRequest).getData());
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public String getAccessTokenFromRequest(HttpRequest httpRequest) {
            Object obj = a(httpRequest).get(BearerToken.PARAM_NAME);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public void intercept(HttpRequest httpRequest, String str) {
            Preconditions.checkArgument(!HttpMethods.GET.equals(httpRequest.getRequestMethod()), "HTTP GET method is not supported");
            a(httpRequest).put(BearerToken.PARAM_NAME, str);
        }
    }

    public static final class c implements Credential.AccessMethod {
        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public String getAccessTokenFromRequest(HttpRequest httpRequest) {
            Object obj = httpRequest.getUrl().get(BearerToken.PARAM_NAME);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }

        @Override // com.google.api.client.auth.oauth2.Credential.AccessMethod
        public void intercept(HttpRequest httpRequest, String str) {
            httpRequest.getUrl().set(BearerToken.PARAM_NAME, (Object) str);
        }
    }

    public static Credential.AccessMethod authorizationHeaderAccessMethod() {
        return new a();
    }

    public static Credential.AccessMethod formEncodedBodyAccessMethod() {
        return new b();
    }

    public static Credential.AccessMethod queryParameterAccessMethod() {
        return new c();
    }
}
