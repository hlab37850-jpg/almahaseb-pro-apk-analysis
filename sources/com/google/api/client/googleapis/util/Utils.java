package com.google.api.client.googleapis.util;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Beta;

/* JADX INFO: loaded from: classes2.dex */
@Beta
public final class Utils {

    public static class a {
        public static final JsonFactory a = new JacksonFactory();
    }

    public static class b {
        public static final HttpTransport a = new NetHttpTransport();
    }

    private Utils() {
    }

    public static JsonFactory getDefaultJsonFactory() {
        return a.a;
    }

    public static HttpTransport getDefaultTransport() {
        return b.a;
    }
}
