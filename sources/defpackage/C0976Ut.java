package defpackage;

import com.google.common.net.HttpHeaders;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: renamed from: Ut, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0976Ut implements InterfaceC2087e6 {
    public final InterfaceC0910Sj d;

    /* JADX INFO: renamed from: Ut$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    public C0976Ut(InterfaceC0910Sj interfaceC0910Sj) {
        AbstractC4492zt.h(interfaceC0910Sj, "defaultDns");
        this.d = interfaceC0910Sj;
    }

    @Override // defpackage.InterfaceC2087e6
    public C3873sL a(C3550oM c3550oM, EL el) {
        Proxy proxyB;
        InterfaceC0910Sj interfaceC0910SjC;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        C3846s2 c3846s2A;
        AbstractC4492zt.h(el, "response");
        List<C0983Va> listI = el.i();
        C3873sL c3873sLK = el.K();
        C0779Nr c0779NrI = c3873sLK.i();
        boolean z = el.r() == 407;
        if (c3550oM == null || (proxyB = c3550oM.b()) == null) {
            proxyB = Proxy.NO_PROXY;
        }
        for (C0983Va c0983Va : listI) {
            if (AbstractC3880sS.q("Basic", c0983Va.c(), true)) {
                if (c3550oM == null || (c3846s2A = c3550oM.a()) == null || (interfaceC0910SjC = c3846s2A.c()) == null) {
                    interfaceC0910SjC = this.d;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxyB.address();
                    AbstractC4492zt.f(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    AbstractC4492zt.g(proxyB, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxyB, c0779NrI, interfaceC0910SjC), inetSocketAddress.getPort(), c0779NrI.q(), c0983Va.b(), c0983Va.c(), c0779NrI.s(), Authenticator.RequestorType.PROXY);
                } else {
                    String strH = c0779NrI.h();
                    AbstractC4492zt.g(proxyB, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strH, b(proxyB, c0779NrI, interfaceC0910SjC), c0779NrI.m(), c0779NrI.q(), c0983Va.b(), c0983Va.c(), c0779NrI.s(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? HttpHeaders.PROXY_AUTHORIZATION : HttpHeaders.AUTHORIZATION;
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    AbstractC4492zt.g(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    AbstractC4492zt.g(password, "auth.password");
                    return c3873sLK.h().c(str, C3330lg.a(userName, new String(password), c0983Va.a())).b();
                }
            }
        }
        return null;
    }

    public final InetAddress b(Proxy proxy, C0779Nr c0779Nr, InterfaceC0910Sj interfaceC0910Sj) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : a.a[type.ordinal()]) == 1) {
            return (InetAddress) AbstractC3240kc.b0(interfaceC0910Sj.a(c0779Nr.h()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        AbstractC4492zt.f(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        AbstractC4492zt.g(address, "address() as InetSocketAddress).address");
        return address;
    }

    public /* synthetic */ C0976Ut(InterfaceC0910Sj interfaceC0910Sj, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? InterfaceC0910Sj.b : interfaceC0910Sj);
    }
}
