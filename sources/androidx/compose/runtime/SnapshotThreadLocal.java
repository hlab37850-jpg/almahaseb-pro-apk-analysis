package androidx.compose.runtime;

import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.ThreadMapKt;
import defpackage.FW;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotThreadLocal<T> {
    private final AtomicReference<ThreadMap> map = new AtomicReference<>(ThreadMapKt.getEmptyThreadMap());
    private final Object writeMutex = new Object();

    public final T get() {
        return (T) this.map.get().get(Thread.currentThread().getId());
    }

    public final void set(T t) {
        long id = Thread.currentThread().getId();
        synchronized (this.writeMutex) {
            ThreadMap threadMap = this.map.get();
            if (threadMap.trySet(id, t)) {
                return;
            }
            this.map.set(threadMap.newWith(id, t));
            FW fw = FW.a;
        }
    }
}
