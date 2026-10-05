package androidx.paging;

import defpackage.AbstractC0819Pf;
import defpackage.C0529Fs;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.CachedPageEventFlow$job$1$1", f = "CachedPageEventFlow.kt", l = {78, 79}, m = "emit")
public final class CachedPageEventFlow$job$1$1$emit$1 extends AbstractC0819Pf {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachedPageEventFlow$job$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CachedPageEventFlow$job$1$1$emit$1(CachedPageEventFlow$job$1.AnonymousClass1<? super T> anonymousClass1, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
        this.this$0 = anonymousClass1;
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((C0529Fs) null, (InterfaceC0793Of) this);
    }
}
