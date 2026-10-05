package androidx.compose.foundation.pager;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PagerStateImpl$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final PagerStateImpl$Companion$Saver$2 INSTANCE = new PagerStateImpl$Companion$Saver$2();

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerStateImpl$Companion$Saver$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ List<Object> $it;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<? extends Object> list) {
            super(0);
            this.$it = list;
        }

        @Override // defpackage.InterfaceC3588op
        public final Integer invoke() {
            Object obj = this.$it.get(2);
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }
    }

    public PagerStateImpl$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final PagerStateImpl invoke(List<? extends Object> list) {
        AbstractC4492zt.h(list, "it");
        Object obj = list.get(0);
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = list.get(1);
        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Float");
        return new PagerStateImpl(iIntValue, ((Float) obj2).floatValue(), new AnonymousClass1(list));
    }
}
