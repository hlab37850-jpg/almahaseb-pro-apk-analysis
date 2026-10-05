package defpackage;

import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: Rr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0892Rr {
    public static final Logger a = Logger.getLogger(AbstractC0892Rr.class.getName());
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static int c = 5;

    /* JADX INFO: renamed from: Rr$a */
    public static class a extends C3432mx.k {
        public boolean B;
        public boolean C = true;
    }

    public static VQ a(String str) {
        return b(str, null);
    }

    public static VQ b(String str, a aVar) {
        return c(new URI(str), aVar);
    }

    public static VQ c(URI uri, a aVar) {
        C3432mx c3432mx;
        String str;
        if (aVar == null) {
            aVar = new a();
        }
        ZW.a aVarB = ZW.b(uri);
        URI uri2 = aVarB.a;
        String str2 = aVarB.b;
        ConcurrentHashMap concurrentHashMap = b;
        boolean z = aVar.B || !aVar.C || (concurrentHashMap.containsKey(str2) && ((C3432mx) concurrentHashMap.get(str2)).t.containsKey(uri2.getPath()));
        String query = uri2.getQuery();
        if (query != null && ((str = aVar.q) == null || str.isEmpty())) {
            aVar.q = query;
        }
        if (z) {
            Logger logger = a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("ignoring socket cache for %s", uri2));
            }
            c3432mx = new C3432mx(uri2, aVar);
        } else {
            if (!concurrentHashMap.containsKey(str2)) {
                Logger logger2 = a;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(String.format("new io instance for %s", uri2));
                }
                concurrentHashMap.putIfAbsent(str2, new C3432mx(uri2, aVar));
            }
            c3432mx = (C3432mx) concurrentHashMap.get(str2);
        }
        return c3432mx.Y(uri2.getPath(), aVar);
    }
}
