package defpackage;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: renamed from: aX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1232aX implements InterfaceC1254ak {
    public static volatile Object b;
    public static final Object c = new Object();
    public static final ThreadLocal d = new a();
    public final Context a;

    /* JADX INFO: renamed from: aX$a */
    public static class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    /* JADX INFO: renamed from: aX$b */
    public static class b {
        public static Object a(Context context) {
            File fileF = AbstractC4047uX.f(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(fileF, AbstractC4047uX.a(fileF)) : installed;
        }
    }

    public C1232aX(Context context) {
        this.a = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (b == null) {
            try {
                synchronized (c) {
                    try {
                        if (b == null) {
                            b = b.a(context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.InterfaceC1254ak
    public InterfaceC1254ak.a a(Uri uri, int i) throws IOException {
        String string;
        b(this.a);
        HttpURLConnection httpURLConnectionC = c(uri);
        httpURLConnectionC.setUseCaches(true);
        if (i != 0) {
            if (EnumC3704qD.a(i)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = (StringBuilder) d.get();
                sb.setLength(0);
                if (!EnumC3704qD.b(i)) {
                    sb.append("no-cache");
                }
                if (!EnumC3704qD.c(i)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionC.setRequestProperty(HttpHeaders.CACHE_CONTROL, string);
        }
        int responseCode = httpURLConnectionC.getResponseCode();
        if (responseCode < 300) {
            return new InterfaceC1254ak.a(httpURLConnectionC.getInputStream(), AbstractC4047uX.w(httpURLConnectionC.getHeaderField("X-Android-Response-Source")), httpURLConnectionC.getHeaderFieldInt(HttpHeaders.CONTENT_LENGTH, -1));
        }
        httpURLConnectionC.disconnect();
        throw new InterfaceC1254ak.b(responseCode + " " + httpURLConnectionC.getResponseMessage(), i, responseCode);
    }

    public HttpURLConnection c(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        return httpURLConnection;
    }
}
