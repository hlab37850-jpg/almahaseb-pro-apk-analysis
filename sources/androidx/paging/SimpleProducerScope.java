package androidx.paging;

import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3552oO;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4038uO;

/* JADX INFO: loaded from: classes2.dex */
public interface SimpleProducerScope<T> extends InterfaceC2052dg, InterfaceC4038uO {

    public static final class DefaultImpls {
        public static <T> boolean offer(SimpleProducerScope<T> simpleProducerScope, T t) {
            return InterfaceC4038uO.a.b(simpleProducerScope, t);
        }
    }

    Object awaitClose(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of);

    @Override // defpackage.InterfaceC4038uO
    /* synthetic */ boolean close(Throwable th);

    InterfaceC4038uO getChannel();

    @Override // defpackage.InterfaceC2052dg
    /* synthetic */ InterfaceC0988Vf getCoroutineContext();

    @Override // defpackage.InterfaceC4038uO
    /* synthetic */ InterfaceC3552oO getOnSend();

    @Override // defpackage.InterfaceC4038uO
    /* synthetic */ void invokeOnClose(InterfaceC3750qp interfaceC3750qp);

    @Override // defpackage.InterfaceC4038uO
    /* synthetic */ boolean isClosedForSend();

    @Override // defpackage.InterfaceC4038uO
    /* synthetic */ boolean offer(Object obj);

    @Override // defpackage.InterfaceC4038uO
    /* synthetic */ Object send(Object obj, InterfaceC0793Of interfaceC0793Of);

    @Override // defpackage.InterfaceC4038uO
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    /* synthetic */ Object mo0trySendJP2dKIU(Object obj);
}
