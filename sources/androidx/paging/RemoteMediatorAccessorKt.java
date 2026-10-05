package androidx.paging;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteMediatorAccessorKt {
    public static final <Key, Value> RemoteMediatorAccessor<Key, Value> RemoteMediatorAccessor(InterfaceC2052dg interfaceC2052dg, RemoteMediator<Key, Value> remoteMediator) {
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC4492zt.h(remoteMediator, "delegate");
        return new RemoteMediatorAccessImpl(interfaceC2052dg, remoteMediator);
    }
}
