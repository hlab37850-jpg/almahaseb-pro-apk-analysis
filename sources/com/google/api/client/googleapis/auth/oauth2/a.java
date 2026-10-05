package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import defpackage.C2033dT;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a extends C2033dT {
    public GoogleCredential b = null;
    public c c = null;

    /* JADX INFO: renamed from: com.google.api.client.googleapis.auth.oauth2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0196a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.ENVIRONMENT_VARIABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.WELL_KNOWN_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.APP_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.CLOUD_SHELL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.COMPUTE_ENGINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class b extends GoogleCredential {
        public static final String a = OAuth2Utils.getMetadataServerUrl() + "/computeMetadata/v1/instance/service-accounts/default/token";

        public b(HttpTransport httpTransport, JsonFactory jsonFactory) {
            super(new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory).setTokenServerEncodedUrl(a));
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
        public TokenResponse executeRefreshToken() throws IOException {
            HttpRequest httpRequestBuildGetRequest = getTransport().createRequestFactory().buildGetRequest(new GenericUrl(getTokenServerEncodedUrl()));
            JsonObjectParser jsonObjectParser = new JsonObjectParser(getJsonFactory());
            httpRequestBuildGetRequest.setParser(jsonObjectParser);
            httpRequestBuildGetRequest.getHeaders().set("Metadata-Flavor", "Google");
            httpRequestBuildGetRequest.setThrowExceptionOnExecuteError(false);
            HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
            int statusCode = httpResponseExecute.getStatusCode();
            if (statusCode != 200) {
                if (statusCode == 404) {
                    throw new IOException(String.format("Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified.", Integer.valueOf(statusCode)));
                }
                throw new IOException(String.format("Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s", Integer.valueOf(statusCode), httpResponseExecute.parseAsString()));
            }
            InputStream content = httpResponseExecute.getContent();
            if (content != null) {
                return (TokenResponse) jsonObjectParser.parseAndClose(content, httpResponseExecute.getContentCharset(), TokenResponse.class);
            }
            throw new IOException("Empty content from metadata token server request.");
        }
    }

    public enum c {
        UNKNOWN,
        ENVIRONMENT_VARIABLE,
        WELL_KNOWN_FILE,
        CLOUD_SHELL,
        APP_ENGINE,
        COMPUTE_ENGINE
    }

    public final c b(HttpTransport httpTransport) {
        if (p()) {
            return c.ENVIRONMENT_VARIABLE;
        }
        if (q()) {
            return c.WELL_KNOWN_FILE;
        }
        if (n()) {
            return c.APP_ENGINE;
        }
        if (o()) {
            return c.CLOUD_SHELL;
        }
        return OAuth2Utils.runningOnComputeEngine(httpTransport, this) ? c.COMPUTE_ENGINE : c.UNKNOWN;
    }

    public boolean c(File file) {
        return file.exists() && !file.isDirectory();
    }

    public Class d(String str) {
        return Class.forName(str);
    }

    public final GoogleCredential e(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        try {
            return (GoogleCredential) d("com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper").getConstructor(HttpTransport.class, JsonFactory.class).newInstance(httpTransport, jsonFactory);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw ((IOException) OAuth2Utils.exceptionWithCause(new IOException(String.format("Application Default Credentials failed to create the Google App Engine service account credentials class %s. Check that the component 'google-api-client-appengine' is deployed.", "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper")), e));
        }
    }

    public final GoogleCredential f(JsonFactory jsonFactory) {
        return new CloudShellCredential(Integer.parseInt(a("DEVSHELL_CLIENT_PORT")), jsonFactory);
    }

    public final GoogleCredential g(HttpTransport httpTransport, JsonFactory jsonFactory) {
        return new b(httpTransport, jsonFactory);
    }

    public final GoogleCredential h(HttpTransport httpTransport, JsonFactory jsonFactory) throws Throwable {
        String strA = a("GOOGLE_APPLICATION_CREDENTIALS");
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(strA);
                try {
                    GoogleCredential googleCredentialFromStream = GoogleCredential.fromStream(fileInputStream2, httpTransport, jsonFactory);
                    fileInputStream2.close();
                    return googleCredentialFromStream;
                } catch (IOException e) {
                    e = e;
                    throw ((IOException) OAuth2Utils.exceptionWithCause(new IOException(String.format("Error reading credential file from environment variable %s, value '%s': %s", "GOOGLE_APPLICATION_CREDENTIALS", strA, e.getMessage())), e));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public final GoogleCredential i(HttpTransport httpTransport, JsonFactory jsonFactory) throws Throwable {
        File fileM = m();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(fileM);
                try {
                    GoogleCredential googleCredentialFromStream = GoogleCredential.fromStream(fileInputStream2, httpTransport, jsonFactory);
                    fileInputStream2.close();
                    return googleCredentialFromStream;
                } catch (IOException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    throw new IOException(String.format("Error reading credential file from location %s: %s", fileM, e.getMessage()));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final GoogleCredential j(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        synchronized (this) {
            try {
                if (this.b == null) {
                    this.b = k(httpTransport, jsonFactory);
                }
                GoogleCredential googleCredential = this.b;
                if (googleCredential != null) {
                    return googleCredential;
                }
                throw new IOException(String.format("The Application Default Credentials are not available. They are available if running on Google App Engine, Google Compute Engine, or Google Cloud Shell. Otherwise, the environment variable %s must be defined pointing to a file defining the credentials. See %s for more information.", "GOOGLE_APPLICATION_CREDENTIALS", "https://developers.google.com/accounts/docs/application-default-credentials"));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final GoogleCredential k(HttpTransport httpTransport, JsonFactory jsonFactory) {
        if (this.c == null) {
            this.c = b(httpTransport);
        }
        int i = C0196a.a[this.c.ordinal()];
        if (i == 1) {
            return h(httpTransport, jsonFactory);
        }
        if (i == 2) {
            return i(httpTransport, jsonFactory);
        }
        if (i == 3) {
            return e(httpTransport, jsonFactory);
        }
        if (i == 4) {
            return f(jsonFactory);
        }
        if (i != 5) {
            return null;
        }
        return g(httpTransport, jsonFactory);
    }

    public String l(String str, String str2) {
        return System.getProperty(str, str2);
    }

    public final File m() {
        return new File(l("os.name", "").toLowerCase(Locale.US).indexOf("windows") >= 0 ? new File(new File(a("APPDATA")), "gcloud") : new File(new File(l("user.home", ""), ".config"), "gcloud"), "application_default_credentials.json");
    }

    public final boolean n() {
        try {
            try {
                Field field = d("com.google.appengine.api.utils.SystemProperty").getField("environment");
                return field.getType().getMethod("value", new Class[0]).invoke(field.get(null), new Object[0]) != null;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw ((RuntimeException) OAuth2Utils.exceptionWithCause(new RuntimeException(String.format("Unexpcted error trying to determine if runnning on Google App Engine: %s", e.getMessage())), e));
            }
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean o() {
        return a("DEVSHELL_CLIENT_PORT") != null;
    }

    public final boolean p() throws IOException {
        String strA = a("GOOGLE_APPLICATION_CREDENTIALS");
        if (strA != null && strA.length() != 0) {
            try {
                File file = new File(strA);
                if (!file.exists() || file.isDirectory()) {
                    throw new IOException(String.format("Error reading credential file from environment variable %s, value '%s': File does not exist.", "GOOGLE_APPLICATION_CREDENTIALS", strA));
                }
                return true;
            } catch (AccessControlException unused) {
            }
        }
        return false;
    }

    public final boolean q() {
        try {
            return c(m());
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
