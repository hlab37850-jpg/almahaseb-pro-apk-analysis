package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DO extends CO {

    public static final class a implements InterfaceC4362yO {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // defpackage.InterfaceC4362yO
        public Iterator iterator() {
            return this.a;
        }
    }

    public static final class b extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ InterfaceC3588op a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC3588op interfaceC3588op) {
            super(1);
            this.a = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(Object obj) {
            AbstractC4492zt.h(obj, "it");
            return this.a.invoke();
        }
    }

    public static final class c extends AbstractC2233fv implements InterfaceC3588op {
        public final /* synthetic */ Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj) {
            super(0);
            this.a = obj;
        }

        @Override // defpackage.InterfaceC3588op
        public final Object invoke() {
            return this.a;
        }
    }

    public static InterfaceC4362yO c(Iterator it) {
        AbstractC4492zt.h(it, "<this>");
        return d(new a(it));
    }

    public static final InterfaceC4362yO d(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return interfaceC4362yO instanceof C1892cf ? interfaceC4362yO : new C1892cf(interfaceC4362yO);
    }

    public static InterfaceC4362yO e() {
        return C2305gl.a;
    }

    public static InterfaceC4362yO f(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "nextFunction");
        return d(new C2310gq(interfaceC3588op, new b(interfaceC3588op)));
    }

    public static InterfaceC4362yO g(Object obj, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "nextFunction");
        return obj == null ? C2305gl.a : new C2310gq(new c(obj), interfaceC3750qp);
    }

    public static InterfaceC4362yO h(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return R5.C(objArr);
    }
}
