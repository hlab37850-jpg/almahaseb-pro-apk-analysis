package androidx.paging;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.CR;
import defpackage.DC;
import defpackage.ER;
import defpackage.InterfaceC3750qp;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
final class AccessorStateHolder<Key, Value> {
    private final ReentrantLock lock = new ReentrantLock();
    private final DC _loadStates = ER.a(LoadStates.Companion.getIDLE());
    private final AccessorState<Key, Value> internalState = new AccessorState<>();

    public final CR getLoadStates() {
        return this._loadStates;
    }

    public final <R> R use(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            R r = (R) interfaceC3750qp.invoke(this.internalState);
            this._loadStates.setValue(this.internalState.computeLoadStates());
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }
}
