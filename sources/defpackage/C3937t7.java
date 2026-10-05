package defpackage;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: renamed from: t7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3937t7 implements InterfaceC3213kD {
    public static final boolean c = AbstractC2201fY.b;
    public static int d = 3000;
    public static int e = 4096;
    public final InterfaceC0753Mr a;
    public final S8 b;

    public C3937t7(InterfaceC0753Mr interfaceC0753Mr) {
        this(interfaceC0753Mr, new S8(e));
    }

    public static void c(String str, AbstractC3712qL abstractC3712qL, C2119eY c2119eY) throws C2119eY {
        QL qlU = abstractC3712qL.u();
        int iV = abstractC3712qL.v();
        try {
            qlU.c(c2119eY);
            abstractC3712qL.b(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iV)));
        } catch (C2119eY e2) {
            abstractC3712qL.b(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iV)));
            throw e2;
        }
    }

    public static Map d(Header[] headerArr) {
        HashMap map = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            map.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [t7] */
    /* JADX WARN: Type inference failed for: r2v11, types: [long] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // defpackage.InterfaceC3213kD
    public C3865sD a(AbstractC3712qL abstractC3712qL) throws C2119eY {
        ?? r4;
        HttpResponse httpResponseA;
        ?? r5;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Map map = new HashMap();
            try {
                try {
                    HashMap map2 = new HashMap();
                    b(map2, abstractC3712qL.j());
                    httpResponseA = this.a.a(abstractC3712qL, map2);
                    try {
                        StatusLine statusLine = httpResponseA.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        Map mapD = d(httpResponseA.getAllHeaders());
                        try {
                            if (statusCode == 304) {
                                return new C3865sD(304, abstractC3712qL.j().a, mapD, true);
                            }
                            byte[] bArrE = httpResponseA.getEntity() != null ? e(httpResponseA.getEntity()) : new byte[0];
                            try {
                                ?? ElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                try {
                                    f(ElapsedRealtime, abstractC3712qL, bArrE, statusLine);
                                    try {
                                        if (statusCode < 200 || statusCode > 299) {
                                            throw new IOException();
                                        }
                                        return new C3865sD(statusCode, bArrE, mapD, false);
                                    } catch (IOException e2) {
                                        e = e2;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    ElapsedRealtime = bArrE;
                                }
                                r5 = ElapsedRealtime;
                            } catch (IOException e4) {
                                e = e4;
                                r5 = bArrE;
                            }
                            map = mapD;
                            r4 = r5;
                            if (httpResponseA == null) {
                                throw new C4351yD(e);
                            }
                            int statusCode2 = httpResponseA.getStatusLine().getStatusCode();
                            AbstractC2201fY.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), abstractC3712qL.x());
                            if (r4 == 0) {
                                throw new C3623pD((C3865sD) null);
                            }
                            C3865sD c3865sD = new C3865sD(statusCode2, r4, map, false);
                            if (statusCode2 != 401 && statusCode2 != 403) {
                                throw new LO(c3865sD);
                            }
                            c("auth", abstractC3712qL, new C1848c6(c3865sD));
                        } catch (IOException e5) {
                            e = e5;
                            r5 = 0;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        r4 = 0;
                    }
                } catch (IOException e7) {
                    e = e7;
                    r4 = 0;
                    httpResponseA = null;
                }
            } catch (MalformedURLException e8) {
                throw new RuntimeException("Bad URL " + abstractC3712qL.x(), e8);
            } catch (SocketTimeoutException unused) {
                c("socket", abstractC3712qL, new MU());
            } catch (ConnectTimeoutException unused2) {
                c("connection", abstractC3712qL, new MU());
            }
        }
    }

    public final void b(Map map, InterfaceC2339h9.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = aVar.b;
        if (str != null) {
            map.put(HttpHeaders.IF_NONE_MATCH, str);
        }
        if (aVar.c > 0) {
            map.put(HttpHeaders.IF_MODIFIED_SINCE, DateUtils.formatDate(new Date(aVar.c)));
        }
    }

    public final byte[] e(HttpEntity httpEntity) throws IOException {
        VG vg = new VG(this.b, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new LO();
            }
            byte[] bArrA = this.b.a(1024);
            while (true) {
                int i = content.read(bArrA);
                if (i == -1) {
                    break;
                }
                vg.write(bArrA, 0, i);
            }
            byte[] byteArray = vg.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                AbstractC2201fY.e("Error occured when calling consumingContent", new Object[0]);
            }
            this.b.b(bArrA);
            vg.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                AbstractC2201fY.e("Error occured when calling consumingContent", new Object[0]);
            }
            this.b.b(null);
            vg.close();
            throw th;
        }
    }

    public final void f(long j, AbstractC3712qL abstractC3712qL, byte[] bArr, StatusLine statusLine) {
        if (c || j > d) {
            AbstractC2201fY.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", abstractC3712qL, Long.valueOf(j), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(statusLine.getStatusCode()), Integer.valueOf(abstractC3712qL.u().b()));
        }
    }

    public C3937t7(InterfaceC0753Mr interfaceC0753Mr, S8 s8) {
        this.a = interfaceC0753Mr;
        this.b = s8;
    }
}
