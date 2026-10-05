package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: qL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3712qL implements Comparable {
    public final AbstractC2201fY.a a;
    public final int b;
    public final String c;
    public final int d;
    public final DL.a e;
    public Integer f;
    public C4278xL g;
    public boolean h;
    public boolean i;
    public boolean j;
    public long k;
    public QL l;
    public InterfaceC2339h9.a n;
    public Object p;

    /* JADX INFO: renamed from: qL$a */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3712qL.this.a.a(this.a, this.b);
            AbstractC3712qL.this.a.b(toString());
        }
    }

    /* JADX INFO: renamed from: qL$b */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public AbstractC3712qL(int i, String str, DL.a aVar) {
        this.a = AbstractC2201fY.a.c ? new AbstractC2201fY.a() : null;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = 0L;
        this.n = null;
        this.b = i;
        this.c = str;
        this.e = aVar;
        F(new C0719Li());
        this.d = TextUtils.isEmpty(str) ? 0 : Uri.parse(str).getHost().hashCode();
    }

    public void A() {
        this.j = true;
    }

    public abstract DL C(C3865sD c3865sD);

    public void D(InterfaceC2339h9.a aVar) {
        this.n = aVar;
    }

    public void E(C4278xL c4278xL) {
        this.g = c4278xL;
    }

    public void F(QL ql) {
        this.l = ql;
    }

    public final void G(int i) {
        this.f = Integer.valueOf(i);
    }

    public final void H(boolean z) {
        this.h = z;
    }

    public void I(Object obj) {
        this.p = obj;
    }

    public final boolean J() {
        return this.h;
    }

    public void b(String str) {
        if (AbstractC2201fY.a.c) {
            this.a.a(str, Thread.currentThread().getId());
        } else if (this.k == 0) {
            this.k = SystemClock.elapsedRealtime();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC3712qL abstractC3712qL) {
        b bVarT = t();
        b bVarT2 = abstractC3712qL.t();
        return bVarT == bVarT2 ? this.f.intValue() - abstractC3712qL.f.intValue() : bVarT2.ordinal() - bVarT.ordinal();
    }

    public void d(C2119eY c2119eY) {
        DL.a aVar = this.e;
        if (aVar != null) {
            aVar.a(c2119eY);
        }
    }

    public abstract void e(Object obj);

    public final byte[] f(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : map.entrySet()) {
                sb.append(URLEncoder.encode((String) entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public void g(String str) {
        C4278xL c4278xL = this.g;
        if (c4278xL != null) {
            c4278xL.b(this);
        }
        if (!AbstractC2201fY.a.c) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.k;
            if (jElapsedRealtime >= 3000) {
                AbstractC2201fY.b("%d ms: %s", Long.valueOf(jElapsedRealtime), toString());
                return;
            }
            return;
        }
        long id = Thread.currentThread().getId();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new a(str, id));
        } else {
            this.a.a(str, id);
            this.a.b(toString());
        }
    }

    public byte[] h() {
        Map mapN = n();
        if (mapN == null || mapN.size() <= 0) {
            return null;
        }
        return f(mapN, o());
    }

    public String i() {
        return "application/x-www-form-urlencoded; charset=" + o();
    }

    public InterfaceC2339h9.a j() {
        return this.n;
    }

    public String k() {
        return x();
    }

    public Map l() {
        return Collections.emptyMap();
    }

    public int m() {
        return this.b;
    }

    public Map n() {
        return null;
    }

    public String o() {
        return XmpWriter.UTF8;
    }

    public byte[] p() {
        Map mapR = r();
        if (mapR == null || mapR.size() <= 0) {
            return null;
        }
        return f(mapR, s());
    }

    public String q() {
        return i();
    }

    public Map r() {
        return n();
    }

    public String s() {
        return o();
    }

    public b t() {
        return b.NORMAL;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(w());
        StringBuilder sb = new StringBuilder();
        sb.append(this.i ? "[X] " : "[ ] ");
        sb.append(x());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(t());
        sb.append(" ");
        sb.append(this.f);
        return sb.toString();
    }

    public QL u() {
        return this.l;
    }

    public final int v() {
        return this.l.a();
    }

    public int w() {
        return this.d;
    }

    public String x() {
        return this.c;
    }

    public boolean y() {
        return this.j;
    }

    public boolean z() {
        return this.i;
    }

    public C2119eY B(C2119eY c2119eY) {
        return c2119eY;
    }
}
