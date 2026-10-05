package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2129ee {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C2129ee.class, "_handled");
    private volatile /* synthetic */ int _handled;
    public final Throwable a;

    public C2129ee(Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return AbstractC3498ni.a(this) + '[' + this.a + ']';
    }

    public /* synthetic */ C2129ee(Throwable th, boolean z, int i, AbstractC0419Di abstractC0419Di) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
