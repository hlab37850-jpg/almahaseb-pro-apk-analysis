package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: qX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3724qX {
    public static final byte[] a;
    public static final C3994tr b = C3994tr.b.g(new String[0]);
    public static final FL c;
    public static final AbstractC3954tL d;
    public static final XE e;
    public static final TimeZone f;
    public static final SJ g;
    public static final boolean h;
    public static final String i;

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        c = FL.a.c(FL.a, bArr, null, 1, null);
        d = AbstractC3954tL.a.d(AbstractC3954tL.a, bArr, null, 0, 0, 7, null);
        XE.a aVar = XE.c;
        W8.a aVar2 = W8.d;
        e = aVar.d(aVar2.a("efbbbf"), aVar2.a("feff"), aVar2.a("fffe"), aVar2.a("0000ffff"), aVar2.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        AbstractC4492zt.e(timeZone);
        f = timeZone;
        g = new SJ("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        h = false;
        String name = C4271xE.class.getName();
        AbstractC4492zt.g(name, "OkHttpClient::class.java.name");
        i = AbstractC3961tS.h0(AbstractC3961tS.g0(name, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return z(str, i2, i3);
    }

    public static final int B(String str, int i2, int i3) {
        AbstractC4492zt.h(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 != i2) {
                    i4--;
                }
            }
        }
        return i2;
    }

    public static /* synthetic */ int C(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return B(str, i2, i3);
    }

    public static final int D(String str, int i2) {
        AbstractC4492zt.h(str, "<this>");
        int length = str.length();
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static final String[] E(String[] strArr, String[] strArr2, Comparator comparator) {
        AbstractC4492zt.h(strArr, "<this>");
        AbstractC4492zt.h(strArr2, "other");
        AbstractC4492zt.h(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean F(Socket socket, L8 l8) {
        AbstractC4492zt.h(socket, "<this>");
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !l8.h();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean G(String str) {
        AbstractC4492zt.h(str, "name");
        return AbstractC3880sS.q(str, HttpHeaders.AUTHORIZATION, true) || AbstractC3880sS.q(str, HttpHeaders.COOKIE, true) || AbstractC3880sS.q(str, HttpHeaders.PROXY_AUTHORIZATION, true) || AbstractC3880sS.q(str, HttpHeaders.SET_COOKIE, true);
    }

    public static final int H(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final Charset I(L8 l8, Charset charset) {
        AbstractC4492zt.h(l8, "<this>");
        AbstractC4492zt.h(charset, "default");
        int iB = l8.B(e);
        if (iB == -1) {
            return charset;
        }
        if (iB == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            AbstractC4492zt.g(charset2, "UTF_8");
            return charset2;
        }
        if (iB == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            AbstractC4492zt.g(charset3, "UTF_16BE");
            return charset3;
        }
        if (iB == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            AbstractC4492zt.g(charset4, "UTF_16LE");
            return charset4;
        }
        if (iB == 3) {
            return C3809rb.a.a();
        }
        if (iB == 4) {
            return C3809rb.a.b();
        }
        throw new AssertionError();
    }

    public static final int J(L8 l8) {
        AbstractC4492zt.h(l8, "<this>");
        return d(l8.readByte(), 255) | (d(l8.readByte(), 255) << 16) | (d(l8.readByte(), 255) << 8);
    }

    public static final int K(H8 h8, byte b2) throws EOFException {
        AbstractC4492zt.h(h8, "<this>");
        int i2 = 0;
        while (!h8.h() && h8.x(0L) == b2) {
            i2++;
            h8.readByte();
        }
        return i2;
    }

    public static final boolean L(InterfaceC3309lR interfaceC3309lR, int i2, TimeUnit timeUnit) {
        AbstractC4492zt.h(interfaceC3309lR, "<this>");
        AbstractC4492zt.h(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = interfaceC3309lR.b().e() ? interfaceC3309lR.b().c() - jNanoTime : Long.MAX_VALUE;
        interfaceC3309lR.b().d(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            H8 h8 = new H8();
            while (interfaceC3309lR.y(h8, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                h8.d();
            }
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                interfaceC3309lR.b().a();
            } else {
                interfaceC3309lR.b().d(jNanoTime + jC);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                interfaceC3309lR.b().a();
            } else {
                interfaceC3309lR.b().d(jNanoTime + jC);
            }
            return false;
        } catch (Throwable th) {
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                interfaceC3309lR.b().a();
            } else {
                interfaceC3309lR.b().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final ThreadFactory M(final String str, final boolean z) {
        AbstractC4492zt.h(str, "name");
        return new ThreadFactory() { // from class: pX
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AbstractC3724qX.N(str, z, runnable);
            }
        };
    }

    public static final Thread N(String str, boolean z, Runnable runnable) {
        AbstractC4492zt.h(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static final List O(C3994tr c3994tr) {
        AbstractC4492zt.h(c3994tr, "<this>");
        C1001Vs c1001VsS = AbstractC3871sJ.s(0, c3994tr.size());
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(c1001VsS, 10));
        Iterator it = c1001VsS.iterator();
        while (it.hasNext()) {
            int iNextInt = ((AbstractC0919Ss) it).nextInt();
            arrayList.add(new C3752qr(c3994tr.b(iNextInt), c3994tr.e(iNextInt)));
        }
        return arrayList;
    }

    public static final C3994tr P(List list) {
        AbstractC4492zt.h(list, "<this>");
        C3994tr.a aVar = new C3994tr.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C3752qr c3752qr = (C3752qr) it.next();
            aVar.c(c3752qr.a().y(), c3752qr.b().y());
        }
        return aVar.d();
    }

    public static final String Q(int i2) {
        String hexString = Integer.toHexString(i2);
        AbstractC4492zt.g(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String R(long j) {
        String hexString = Long.toHexString(j);
        AbstractC4492zt.g(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String S(C0779Nr c0779Nr, boolean z) {
        String strH;
        AbstractC4492zt.h(c0779Nr, "<this>");
        if (AbstractC3961tS.G(c0779Nr.h(), ":", false, 2, null)) {
            strH = '[' + c0779Nr.h() + ']';
        } else {
            strH = c0779Nr.h();
        }
        if (!z && c0779Nr.m() == C0779Nr.k.c(c0779Nr.q())) {
            return strH;
        }
        return strH + ':' + c0779Nr.m();
    }

    public static /* synthetic */ String T(C0779Nr c0779Nr, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return S(c0779Nr, z);
    }

    public static final List U(List list) {
        AbstractC4492zt.h(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(AbstractC3240kc.F0(list));
        AbstractC4492zt.g(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final Map V(Map map) {
        AbstractC4492zt.h(map, "<this>");
        if (map.isEmpty()) {
            return AbstractC4243wx.g();
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        AbstractC4492zt.g(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long W(String str, long j) {
        AbstractC4492zt.h(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int X(String str, int i2) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static final String Y(String str, int i2, int i3) {
        AbstractC4492zt.h(str, "<this>");
        int iZ = z(str, i2, i3);
        String strSubstring = str.substring(iZ, B(str, iZ, i3));
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String Z(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return Y(str, i2, i3);
    }

    public static final Throwable a0(Exception exc, List list) throws IllegalAccessException, InvocationTargetException {
        AbstractC4492zt.h(exc, "<this>");
        AbstractC4492zt.h(list, "suppressed");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC0773Nl.a(exc, (Exception) it.next());
        }
        return exc;
    }

    public static final void b0(K8 k8, int i2) {
        AbstractC4492zt.h(k8, "<this>");
        k8.writeByte((i2 >>> 16) & 255);
        k8.writeByte((i2 >>> 8) & 255);
        k8.writeByte(i2 & 255);
    }

    public static final void c(List list, Object obj) {
        AbstractC4492zt.h(list, "<this>");
        if (list.contains(obj)) {
            return;
        }
        list.add(obj);
    }

    public static final int d(byte b2, int i2) {
        return b2 & i2;
    }

    public static final int e(short s, int i2) {
        return s & i2;
    }

    public static final long f(int i2, long j) {
        return ((long) i2) & j;
    }

    public static final AbstractC0396Cl.c g(final AbstractC0396Cl abstractC0396Cl) {
        AbstractC4492zt.h(abstractC0396Cl, "<this>");
        return new AbstractC0396Cl.c() { // from class: oX
            @Override // defpackage.AbstractC0396Cl.c
            public final AbstractC0396Cl a(InterfaceC2121ea interfaceC2121ea) {
                return AbstractC3724qX.h(abstractC0396Cl, interfaceC2121ea);
            }
        };
    }

    public static final AbstractC0396Cl h(AbstractC0396Cl abstractC0396Cl, InterfaceC2121ea interfaceC2121ea) {
        AbstractC4492zt.h(abstractC0396Cl, "$this_asFactory");
        AbstractC4492zt.h(interfaceC2121ea, "it");
        return abstractC0396Cl;
    }

    public static final boolean i(String str) {
        AbstractC4492zt.h(str, "<this>");
        return g.c(str);
    }

    public static final boolean j(C0779Nr c0779Nr, C0779Nr c0779Nr2) {
        AbstractC4492zt.h(c0779Nr, "<this>");
        AbstractC4492zt.h(c0779Nr2, "other");
        return AbstractC4492zt.d(c0779Nr.h(), c0779Nr2.h()) && c0779Nr.m() == c0779Nr2.m() && AbstractC4492zt.d(c0779Nr.q(), c0779Nr2.q());
    }

    public static final int k(String str, long j, TimeUnit timeUnit) {
        AbstractC4492zt.h(str, "name");
        if (j < 0) {
            throw new IllegalStateException((str + " < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException((str + " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((str + " too small.").toString());
    }

    public static final void l(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m(Closeable closeable) {
        AbstractC4492zt.h(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void n(Socket socket) {
        AbstractC4492zt.h(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!AbstractC4492zt.d(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] o(String[] strArr, String str) {
        AbstractC4492zt.h(strArr, "<this>");
        AbstractC4492zt.h(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[R5.O(strArr2)] = str;
        return strArr2;
    }

    public static final int p(String str, char c2, int i2, int i3) {
        AbstractC4492zt.h(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int q(String str, String str2, int i2, int i3) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "delimiters");
        while (i2 < i3) {
            if (AbstractC3961tS.F(str2, str.charAt(i2), false, 2, null)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int r(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return p(str, c2, i2, i3);
    }

    public static final boolean s(InterfaceC3309lR interfaceC3309lR, int i2, TimeUnit timeUnit) {
        AbstractC4492zt.h(interfaceC3309lR, "<this>");
        AbstractC4492zt.h(timeUnit, "timeUnit");
        try {
            return L(interfaceC3309lR, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String t(String str, Object... objArr) {
        AbstractC4492zt.h(str, DublinCoreProperties.FORMAT);
        AbstractC4492zt.h(objArr, "args");
        C2359hS c2359hS = C2359hS.a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        AbstractC4492zt.g(str2, "format(locale, format, *args)");
        return str2;
    }

    public static final boolean u(String[] strArr, String[] strArr2, Comparator comparator) {
        AbstractC4492zt.h(strArr, "<this>");
        AbstractC4492zt.h(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                Iterator itA = AbstractC1199a5.a(strArr2);
                while (itA.hasNext()) {
                    if (comparator.compare(str, (String) itA.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long v(EL el) {
        AbstractC4492zt.h(el, "<this>");
        String strA = el.z().a(HttpHeaders.CONTENT_LENGTH);
        if (strA != null) {
            return W(strA, -1L);
        }
        return -1L;
    }

    public static final List w(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(AbstractC1886cc.p(Arrays.copyOf(objArr2, objArr2.length)));
        AbstractC4492zt.g(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int x(String[] strArr, String str, Comparator comparator) {
        AbstractC4492zt.h(strArr, "<this>");
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int y(String str) {
        AbstractC4492zt.h(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (AbstractC4492zt.j(cCharAt, 31) <= 0 || AbstractC4492zt.j(cCharAt, ShapeTypes.VERTICAL_SCROLL) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int z(String str, int i2, int i3) {
        AbstractC4492zt.h(str, "<this>");
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
