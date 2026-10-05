package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: Ii, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorC0597Ii extends AbstractC0994Vl implements Executor {
    public static final ExecutorC0597Ii b = new ExecutorC0597Ii();
    public static final AbstractC1040Xf c = GW.a.limitedParallelism(AbstractC3720qT.d("kotlinx.coroutines.io.parallelism", AbstractC3871sJ.d(64, AbstractC3557oT.a()), 0, 0, 12, null));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        c.dispatch(interfaceC0988Vf, runnable);
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatchYield(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        c.dispatchYield(interfaceC0988Vf, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(C1172Zk.a, runnable);
    }

    @Override // defpackage.AbstractC1040Xf
    public AbstractC1040Xf limitedParallelism(int i) {
        return GW.a.limitedParallelism(i);
    }

    @Override // defpackage.AbstractC1040Xf
    public String toString() {
        return "Dispatchers.IO";
    }
}
