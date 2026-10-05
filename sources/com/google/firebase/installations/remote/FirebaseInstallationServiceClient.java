package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstallationServiceClient {
    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final int MAX_RETRIES = 1;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;

    @VisibleForTesting
    static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final String USER_AGENT_HEADER = "x-firebase-client";
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private final Context context;
    private final HeartBeatInfo heartbeatInfo;
    private final UserAgentPublisher userAgentPublisher;
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
    private static final Charset UTF_8 = Charset.forName(XmpWriter.UTF8);

    public FirebaseInstallationServiceClient(@NonNull Context context, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        this.context = context;
        this.userAgentPublisher = userAgentPublisher;
        this.heartbeatInfo = heartBeatInfo;
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fid", str);
        jSONObject.put("appId", str2);
        jSONObject.put("authVersion", FIREBASE_INSTALLATION_AUTH_VERSION);
        jSONObject.put("sdkVersion", "a:16.1.0");
        return jSONObject;
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdkVersion", "a:16.1.0");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("installation", jSONObject);
        return jSONObject2;
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ContentValues", "No such package: " + this.context.getPackageName(), e);
            return null;
        }
    }

    private HttpURLConnection openHttpURLConnection(URL url) {
        HeartBeatInfo.HeartBeat heartBeatCode;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.addRequestProperty("Content-Type", JSON_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Accept", JSON_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", GZIP_CONTENT_ENCODING);
        httpURLConnection.addRequestProperty(X_ANDROID_PACKAGE_HEADER_KEY, this.context.getPackageName());
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo;
        if (heartBeatInfo != null && this.userAgentPublisher != null && (heartBeatCode = heartBeatInfo.getHeartBeatCode(FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG)) != HeartBeatInfo.HeartBeat.NONE) {
            httpURLConnection.addRequestProperty(USER_AGENT_HEADER, this.userAgentPublisher.getUserAgent());
            httpURLConnection.addRequestProperty(HEART_BEAT_HEADER, Integer.toString(heartBeatCode.getCode()));
        }
        httpURLConnection.addRequestProperty(X_ANDROID_CERT_HEADER_KEY, getFingerprintHashForPackage());
        return httpURLConnection;
    }

    @VisibleForTesting
    public static long parseTokenExpirationTimestamp(String str) {
        Preconditions.checkArgument(EXPIRATION_TIMESTAMP_PATTERN.matcher(str).matches(), PARSING_EXPIRATION_TIME_ERROR_MESSAGE);
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private InstallationResponse readCreateResponse(HttpURLConnection httpURLConnection) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(httpURLConnection.getInputStream(), UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        InstallationResponse.Builder builder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("name")) {
                builder2.setUri(jsonReader.nextString());
            } else if (strNextName.equals("fid")) {
                builder2.setFid(jsonReader.nextString());
            } else if (strNextName.equals("refreshToken")) {
                builder2.setRefreshToken(jsonReader.nextString());
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("token")) {
                        builder.setToken(jsonReader.nextString());
                    } else if (strNextName2.equals("expiresIn")) {
                        builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builder2.setAuthToken(builder.build());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        return builder2.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    private TokenResult readGenerateAuthTokenResponse(HttpURLConnection httpURLConnection) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(httpURLConnection.getInputStream(), UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("token")) {
                builder.setToken(jsonReader.nextString());
            } else if (strNextName.equals("expiresIn")) {
                builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        return builder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, @NonNull String str, @NonNull String str2) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send CreateInstallation request to FIS. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            try {
                gZIPOutputStream.write(buildCreateFirebaseInstallationRequestBody(str, str2).toString().getBytes(XmpWriter.UTF8));
                gZIPOutputStream.close();
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send GenerateAuthToken request to FIS. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            try {
                gZIPOutputStream.write(buildGenerateAuthTokenRequestBody().toString().getBytes(XmpWriter.UTF8));
                gZIPOutputStream.close();
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    @NonNull
    public InstallationResponse createFirebaseInstallation(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5) {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s?key=%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(CREATE_REQUEST_RESOURCE_NAME_FORMAT, str3), str));
        while (i <= 1) {
            HttpURLConnection httpURLConnectionOpenHttpURLConnection = openHttpURLConnection(url);
            try {
                httpURLConnectionOpenHttpURLConnection.setRequestMethod(HttpMethods.POST);
                httpURLConnectionOpenHttpURLConnection.setDoOutput(true);
                if (str5 != null) {
                    httpURLConnectionOpenHttpURLConnection.addRequestProperty(X_ANDROID_IID_MIGRATION_KEY, str5);
                }
                writeFIDCreateRequestBodyToOutputStream(httpURLConnectionOpenHttpURLConnection, str2, str4);
                int responseCode = httpURLConnectionOpenHttpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    return readCreateResponse(httpURLConnectionOpenHttpURLConnection);
                }
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    return InstallationResponse.builder().setResponseCode(InstallationResponse.ResponseCode.BAD_CONFIG).build();
                }
                i++;
            } finally {
                httpURLConnectionOpenHttpURLConnection.disconnect();
            }
        }
        throw new IOException();
    }

    @NonNull
    public void deleteFirebaseInstallation(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        URL url = new URL(String.format("https://%s/%s/%s?key=%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(DELETE_REQUEST_RESOURCE_NAME_FORMAT, str3, str2), str));
        for (int i = 0; i <= 1; i++) {
            HttpURLConnection httpURLConnectionOpenHttpURLConnection = openHttpURLConnection(url);
            httpURLConnectionOpenHttpURLConnection.setRequestMethod(HttpMethods.DELETE);
            httpURLConnectionOpenHttpURLConnection.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + str4);
            int responseCode = httpURLConnectionOpenHttpURLConnection.getResponseCode();
            httpURLConnectionOpenHttpURLConnection.disconnect();
            if (responseCode == 200 || responseCode == 401 || responseCode == 404) {
                return;
            }
            if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                throw new FirebaseInstallationsException("bad config while trying to delete FID", FirebaseInstallationsException.Status.BAD_CONFIG);
            }
        }
        throw new IOException();
    }

    @NonNull
    public TokenResult generateAuthToken(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s?key=%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT, str3, str2), str));
        while (i <= 1) {
            HttpURLConnection httpURLConnectionOpenHttpURLConnection = openHttpURLConnection(url);
            try {
                httpURLConnectionOpenHttpURLConnection.setRequestMethod(HttpMethods.POST);
                httpURLConnectionOpenHttpURLConnection.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + str4);
                writeGenerateAuthTokenRequestBodyToOutputStream(httpURLConnectionOpenHttpURLConnection);
                int responseCode = httpURLConnectionOpenHttpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    return readGenerateAuthTokenResponse(httpURLConnectionOpenHttpURLConnection);
                }
                if (responseCode == 401 || responseCode == 404) {
                    return TokenResult.builder().setResponseCode(TokenResult.ResponseCode.AUTH_ERROR).build();
                }
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    return TokenResult.builder().setResponseCode(TokenResult.ResponseCode.BAD_CONFIG).build();
                }
                i++;
            } finally {
                httpURLConnectionOpenHttpURLConnection.disconnect();
            }
        }
        throw new IOException();
    }
}
