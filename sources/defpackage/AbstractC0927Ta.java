package defpackage;

import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: renamed from: Ta, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0927Ta {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: Ta$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final AbstractC0927Ta a(X509TrustManager x509TrustManager) {
            AbstractC4492zt.h(x509TrustManager, "trustManager");
            return EG.a.g().c(x509TrustManager);
        }

        public a() {
        }
    }

    public abstract List a(List list, String str);
}
