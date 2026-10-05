package defpackage;

import androidx.core.app.NotificationCompat;
import com.itextpdf.tool.xml.html.HTML;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: rM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3793rM {
    public static final a i = new a(null);
    public final C3846s2 a;
    public final C3632pM b;
    public final InterfaceC2121ea c;
    public final AbstractC0396Cl d;
    public List e;
    public int f;
    public List g;
    public final List h;

    /* JADX INFO: renamed from: rM$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            AbstractC4492zt.h(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                AbstractC4492zt.g(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            AbstractC4492zt.g(hostAddress, "address.hostAddress");
            return hostAddress;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: rM$b */
    public static final class b {
        public final List a;
        public int b;

        public b(List list) {
            AbstractC4492zt.h(list, "routes");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public final boolean b() {
            return this.b < this.a.size();
        }

        public final C3550oM c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List list = this.a;
            int i = this.b;
            this.b = i + 1;
            return (C3550oM) list.get(i);
        }
    }

    public C3793rM(C3846s2 c3846s2, C3632pM c3632pM, InterfaceC2121ea interfaceC2121ea, AbstractC0396Cl abstractC0396Cl) {
        AbstractC4492zt.h(c3846s2, HTML.Tag.ADDRESS);
        AbstractC4492zt.h(c3632pM, "routeDatabase");
        AbstractC4492zt.h(interfaceC2121ea, NotificationCompat.CATEGORY_CALL);
        AbstractC4492zt.h(abstractC0396Cl, "eventListener");
        this.a = c3846s2;
        this.b = c3632pM;
        this.c = interfaceC2121ea;
        this.d = abstractC0396Cl;
        this.e = AbstractC1886cc.m();
        this.g = AbstractC1886cc.m();
        this.h = new ArrayList();
        f(c3846s2.l(), c3846s2.g());
    }

    public static final List g(Proxy proxy, C0779Nr c0779Nr, C3793rM c3793rM) {
        if (proxy != null) {
            return AbstractC1805bc.e(proxy);
        }
        URI uriR = c0779Nr.r();
        if (uriR.getHost() == null) {
            return AbstractC3724qX.w(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = c3793rM.a.i().select(uriR);
        List<Proxy> list = listSelect;
        if (list == null || list.isEmpty()) {
            return AbstractC3724qX.w(Proxy.NO_PROXY);
        }
        AbstractC4492zt.g(listSelect, "proxiesOrNull");
        return AbstractC3724qX.U(listSelect);
    }

    public final boolean a() {
        return b() || !this.h.isEmpty();
    }

    public final boolean b() {
        return this.f < this.e.size();
    }

    public final b c() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C3550oM c3550oM = new C3550oM(this.a, proxyD, (InetSocketAddress) it.next());
                if (this.b.c(c3550oM)) {
                    this.h.add(c3550oM);
                } else {
                    arrayList.add(c3550oM);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            AbstractC2371hc.D(arrayList, this.h);
            this.h.clear();
        }
        return new b(arrayList);
    }

    public final Proxy d() throws SocketException, UnknownHostException {
        if (b()) {
            List list = this.e;
            int i2 = this.f;
            this.f = i2 + 1;
            Proxy proxy = (Proxy) list.get(i2);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.l().h() + "; exhausted proxy configurations: " + this.e);
    }

    public final void e(Proxy proxy) throws SocketException, UnknownHostException {
        String strH;
        int iM;
        List listA;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strH = this.a.l().h();
            iM = this.a.l().m();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
            a aVar = i;
            AbstractC4492zt.g(socketAddressAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strH = aVar.a(inetSocketAddress);
            iM = inetSocketAddress.getPort();
        }
        if (1 > iM || iM >= 65536) {
            throw new SocketException("No route to " + strH + ':' + iM + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strH, iM));
            return;
        }
        if (AbstractC3724qX.i(strH)) {
            listA = AbstractC1805bc.e(InetAddress.getByName(strH));
        } else {
            this.d.m(this.c, strH);
            listA = this.a.c().a(strH);
            if (listA.isEmpty()) {
                throw new UnknownHostException(this.a.c() + " returned no addresses for " + strH);
            }
            this.d.l(this.c, strH, listA);
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress((InetAddress) it.next(), iM));
        }
    }

    public final void f(C0779Nr c0779Nr, Proxy proxy) {
        this.d.o(this.c, c0779Nr);
        List listG = g(proxy, c0779Nr, this);
        this.e = listG;
        this.f = 0;
        this.d.n(this.c, c0779Nr, listG);
    }
}
