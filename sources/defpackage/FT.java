package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FT {
    public static final long a = AbstractC3720qT.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    public static final int b = AbstractC3720qT.d("kotlinx.coroutines.scheduler.core.pool.size", AbstractC3871sJ.d(AbstractC3557oT.a(), 2), 1, 0, 8, null);
    public static final int c = AbstractC3720qT.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
    public static final long d = TimeUnit.SECONDS.toNanos(AbstractC3720qT.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
    public static GN e = C1212aD.a;
    public static final InterfaceC4286xT f = new C4367yT(0);
    public static final InterfaceC4286xT g = new C4367yT(1);
}
