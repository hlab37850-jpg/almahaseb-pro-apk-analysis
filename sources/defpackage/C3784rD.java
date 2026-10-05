package defpackage;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: rD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3784rD extends AbstractC4116vL {
    public final InterfaceC1254ak a;
    public final C1874cS b;

    /* JADX INFO: renamed from: rD$a */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public C3784rD(InterfaceC1254ak interfaceC1254ak, C1874cS c1874cS) {
        this.a = interfaceC1254ak;
        this.b = c1874cS;
    }

    @Override // defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        String scheme = c3792rL.d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // defpackage.AbstractC4116vL
    public int e() {
        return 2;
    }

    @Override // defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) throws a {
        InterfaceC1254ak.a aVarA = this.a.a(c3792rL.d, c3792rL.c);
        if (aVarA == null) {
            return null;
        }
        C4192wG.e eVar = aVarA.c ? C4192wG.e.DISK : C4192wG.e.NETWORK;
        Bitmap bitmapA = aVarA.a();
        if (bitmapA != null) {
            return new AbstractC4116vL.a(bitmapA, eVar);
        }
        InputStream inputStreamC = aVarA.c();
        if (inputStreamC == null) {
            return null;
        }
        if (eVar == C4192wG.e.DISK && aVarA.b() == 0) {
            AbstractC4047uX.e(inputStreamC);
            throw new a("Received response with 0 content-length header.");
        }
        if (eVar == C4192wG.e.NETWORK && aVarA.b() > 0) {
            this.b.f(aVarA.b());
        }
        return new AbstractC4116vL.a(inputStreamC, eVar);
    }

    @Override // defpackage.AbstractC4116vL
    public boolean h(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    @Override // defpackage.AbstractC4116vL
    public boolean i() {
        return true;
    }
}
