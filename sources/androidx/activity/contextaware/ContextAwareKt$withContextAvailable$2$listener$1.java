package androidx.activity.contextaware;

import android.content.Context;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ InterfaceC4293xa $co;
    final /* synthetic */ InterfaceC3750qp $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(InterfaceC4293xa interfaceC4293xa, InterfaceC3750qp interfaceC3750qp) {
        this.$co = interfaceC4293xa;
        this.$onContextAvailable = interfaceC3750qp;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objA;
        AbstractC4492zt.h(context, "context");
        InterfaceC4293xa interfaceC4293xa = this.$co;
        InterfaceC3750qp interfaceC3750qp = this.$onContextAvailable;
        try {
            KL.a aVar = KL.a;
            objA = KL.a(interfaceC3750qp.invoke(context));
        } catch (Throwable th) {
            KL.a aVar2 = KL.a;
            objA = KL.a(LL.a(th));
        }
        interfaceC4293xa.resumeWith(objA);
    }
}
