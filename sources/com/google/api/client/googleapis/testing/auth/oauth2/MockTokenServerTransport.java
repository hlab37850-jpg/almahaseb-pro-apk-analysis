package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.testing.TestUtils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Beta
public class MockTokenServerTransport extends MockHttpTransport {
    static final String EXPECTED_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:jwt-bearer";
    static final JsonFactory JSON_FACTORY = new JacksonFactory();
    Map<String, String> clients;
    Map<String, String> refreshTokens;
    Map<String, String> serviceAccounts;
    final String tokenServerUrl;

    public class a extends MockLowLevelHttpRequest {
        public a(String str) {
            super(str);
        }

        @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
        public LowLevelHttpResponse execute() throws IOException {
            String str;
            Map<String, String> query = TestUtils.parseQuery(getContentAsString());
            String str2 = query.get("client_id");
            if (str2 != null) {
                if (!MockTokenServerTransport.this.clients.containsKey(str2)) {
                    throw new IOException("Client ID not found.");
                }
                String str3 = query.get("client_secret");
                String str4 = MockTokenServerTransport.this.clients.get(str2);
                if (str3 == null || !str3.equals(str4)) {
                    throw new IOException("Client secret not found.");
                }
                String str5 = query.get("refresh_token");
                if (!MockTokenServerTransport.this.refreshTokens.containsKey(str5)) {
                    throw new IOException("Refresh Token not found.");
                }
                str = MockTokenServerTransport.this.refreshTokens.get(str5);
            } else {
                if (!query.containsKey("grant_type")) {
                    throw new IOException("Unknown token type.");
                }
                if (!MockTokenServerTransport.EXPECTED_GRANT_TYPE.equals(query.get("grant_type"))) {
                    throw new IOException("Unexpected Grant Type.");
                }
                JsonWebSignature jsonWebSignature = JsonWebSignature.parse(MockTokenServerTransport.JSON_FACTORY, query.get("assertion"));
                String issuer = jsonWebSignature.getPayload().getIssuer();
                if (!MockTokenServerTransport.this.serviceAccounts.containsKey(issuer)) {
                    throw new IOException("Service Account Email not found as issuer.");
                }
                String str6 = MockTokenServerTransport.this.serviceAccounts.get(issuer);
                String str7 = (String) jsonWebSignature.getPayload().get("scope");
                if (str7 == null || str7.length() == 0) {
                    throw new IOException("Scopes not found.");
                }
                str = str6;
            }
            GenericJson genericJson = new GenericJson();
            genericJson.setFactory(MockTokenServerTransport.JSON_FACTORY);
            genericJson.put("access_token", (Object) str);
            genericJson.put("expires_in", (Object) 3600000);
            genericJson.put("token_type", (Object) "Bearer");
            return new MockLowLevelHttpResponse().setContentType(Json.MEDIA_TYPE).setContent(genericJson.toPrettyString());
        }
    }

    public MockTokenServerTransport() {
        this(GoogleOAuthConstants.TOKEN_SERVER_URL);
    }

    public void addClient(String str, String str2) {
        this.clients.put(str, str2);
    }

    public void addRefreshToken(String str, String str2) {
        this.refreshTokens.put(str, str2);
    }

    public void addServiceAccount(String str, String str2) {
        this.serviceAccounts.put(str, str2);
    }

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) {
        return str2.equals(this.tokenServerUrl) ? new a(str2) : super.buildRequest(str, str2);
    }

    public MockTokenServerTransport(String str) {
        this.serviceAccounts = new HashMap();
        this.clients = new HashMap();
        this.refreshTokens = new HashMap();
        this.tokenServerUrl = str;
    }
}
