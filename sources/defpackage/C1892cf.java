package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: cf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1892cf implements InterfaceC4362yO {
    public final AtomicReference a;

    public C1892cf(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "sequence");
        this.a = new AtomicReference(interfaceC4362yO);
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        InterfaceC4362yO interfaceC4362yO = (InterfaceC4362yO) this.a.getAndSet(null);
        if (interfaceC4362yO != null) {
            return interfaceC4362yO.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
