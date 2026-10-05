package defpackage;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: yE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4352yE implements InterfaceC1254ak {
    public final OkHttpClient a;

    public C4352yE(Context context) {
        this(AbstractC4047uX.f(context));
    }

    public static OkHttpClient b() {
        OkHttpClient okHttpClient = new OkHttpClient();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        okHttpClient.setConnectTimeout(15000L, timeUnit);
        okHttpClient.setReadTimeout(20000L, timeUnit);
        okHttpClient.setWriteTimeout(20000L, timeUnit);
        return okHttpClient;
    }

    @Override // defpackage.InterfaceC1254ak
    public InterfaceC1254ak.a a(Uri uri, int i) throws InterfaceC1254ak.b {
        CacheControl cacheControlBuild;
        if (i == 0) {
            cacheControlBuild = null;
        } else if (EnumC3704qD.a(i)) {
            cacheControlBuild = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!EnumC3704qD.b(i)) {
                builder.noCache();
            }
            if (!EnumC3704qD.c(i)) {
                builder.noStore();
            }
            cacheControlBuild = builder.build();
        }
        Request.Builder builderUrl = new Request.Builder().url(uri.toString());
        if (cacheControlBuild != null) {
            builderUrl.cacheControl(cacheControlBuild);
        }
        Response responseExecute = this.a.newCall(builderUrl.build()).execute();
        int iCode = responseExecute.code();
        if (iCode < 300) {
            boolean z = responseExecute.cacheResponse() != null;
            ResponseBody responseBodyBody = responseExecute.body();
            return new InterfaceC1254ak.a(responseBodyBody.byteStream(), z, responseBodyBody.contentLength());
        }
        responseExecute.body().close();
        throw new InterfaceC1254ak.b(iCode + " " + responseExecute.message(), i, iCode);
    }

    public C4352yE(File file) {
        this(file, AbstractC4047uX.a(file));
    }

    public C4352yE(File file, long j) {
        this(b());
        try {
            this.a.setCache(new Cache(file, j));
        } catch (IOException unused) {
        }
    }

    public C4352yE(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }
}
