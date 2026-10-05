package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.C0529Fs;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.CachedPageEventFlow$sharedForDownstream$1", f = "CachedPageEventFlow.kt", l = {63, 68}, m = "invokeSuspend")
public final class CachedPageEventFlow$sharedForDownstream$1 extends XS implements InterfaceC0526Fp {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$sharedForDownstream$1(CachedPageEventFlow<T> cachedPageEventFlow, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = cachedPageEventFlow;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        CachedPageEventFlow$sharedForDownstream$1 cachedPageEventFlow$sharedForDownstream$1 = new CachedPageEventFlow$sharedForDownstream$1(this.this$0, interfaceC0793Of);
        cachedPageEventFlow$sharedForDownstream$1.L$0 = obj;
        return cachedPageEventFlow$sharedForDownstream$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return ((CachedPageEventFlow$sharedForDownstream$1) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    /* JADX WARN: Code duplicated, block: B:21:0x006e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:? A[LOOP:0: B:14:0x0056->B:24:?, LOOP_END, SYNTHETIC] */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC0995Vm interfaceC0995Vm;
        InterfaceC0995Vm interfaceC0995Vm2;
        Iterator it;
        C0529Fs c0529Fs;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
                LL.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$1;
                interfaceC0995Vm2 = (InterfaceC0995Vm) this.L$0;
                LL.b(obj);
            }
            while (it.hasNext()) {
                c0529Fs = (C0529Fs) it.next();
                this.L$0 = interfaceC0995Vm2;
                this.L$1 = it;
                this.label = 2;
                if (interfaceC0995Vm2.emit(c0529Fs, this) == objD) {
                    return objD;
                }
            }
            return FW.a;
        }
        LL.b(obj);
        interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
        FlattenedPageController flattenedPageController = ((CachedPageEventFlow) this.this$0).pageController;
        this.L$0 = interfaceC0995Vm;
        this.label = 1;
        obj = flattenedPageController.getStateAsEvents(this);
        if (obj == objD) {
            return objD;
        }
        ((CachedPageEventFlow) this.this$0).job.start();
        interfaceC0995Vm2 = interfaceC0995Vm;
        it = ((List) obj).iterator();
        while (it.hasNext()) {
            c0529Fs = (C0529Fs) it.next();
            this.L$0 = interfaceC0995Vm2;
            this.L$1 = it;
            this.label = 2;
            if (interfaceC0995Vm2.emit(c0529Fs, this) == objD) {
                return objD;
            }
        }
        return FW.a;
    }
}
