package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC4038uO;

/* JADX INFO: loaded from: classes2.dex */
public final class ChannelFlowCollector<T> implements InterfaceC0995Vm {
    private final InterfaceC4038uO channel;

    public ChannelFlowCollector(InterfaceC4038uO interfaceC4038uO) {
        AbstractC4492zt.h(interfaceC4038uO, "channel");
        this.channel = interfaceC4038uO;
    }

    @Override // defpackage.InterfaceC0995Vm
    public Object emit(T t, InterfaceC0793Of interfaceC0793Of) {
        Object objSend = this.channel.send(t, interfaceC0793Of);
        return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
    }

    public final InterfaceC4038uO getChannel() {
        return this.channel;
    }
}
