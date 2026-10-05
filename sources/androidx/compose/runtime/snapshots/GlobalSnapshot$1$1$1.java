package androidx.compose.runtime.snapshots;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GlobalSnapshot$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<InterfaceC3750qp> $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSnapshot$1$1$1(List<InterfaceC3750qp> list) {
        super(1);
        this.$it = list;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2677invoke(obj);
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2677invoke(Object obj) {
        AbstractC4492zt.h(obj, "state");
        List<InterfaceC3750qp> list = this.$it;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).invoke(obj);
        }
    }
}
