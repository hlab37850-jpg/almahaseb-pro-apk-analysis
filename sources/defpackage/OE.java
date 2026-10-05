package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OE {

    public static final class a extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ InterfaceC3750qp a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC0988Vf c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC3750qp interfaceC3750qp, Object obj, InterfaceC0988Vf interfaceC0988Vf) {
            super(1);
            this.a = interfaceC3750qp;
            this.b = obj;
            this.c = interfaceC0988Vf;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) throws IllegalAccessException, InvocationTargetException {
            OE.b(this.a, this.b, this.c);
        }
    }

    public static final InterfaceC3750qp a(InterfaceC3750qp interfaceC3750qp, Object obj, InterfaceC0988Vf interfaceC0988Vf) {
        return new a(interfaceC3750qp, obj, interfaceC0988Vf);
    }

    public static final void b(InterfaceC3750qp interfaceC3750qp, Object obj, InterfaceC0988Vf interfaceC0988Vf) throws IllegalAccessException, InvocationTargetException {
        C3965tW c3965tWC = c(interfaceC3750qp, obj, null);
        if (c3965tWC != null) {
            AbstractC1247ag.a(interfaceC0988Vf, c3965tWC);
        }
    }

    public static final C3965tW c(InterfaceC3750qp interfaceC3750qp, Object obj, C3965tW c3965tW) throws IllegalAccessException, InvocationTargetException {
        try {
            interfaceC3750qp.invoke(obj);
        } catch (Throwable th) {
            if (c3965tW == null || c3965tW.getCause() == th) {
                return new C3965tW("Exception in undelivered element handler for " + obj, th);
            }
            AbstractC0773Nl.a(c3965tW, th);
        }
        return c3965tW;
    }

    public static /* synthetic */ C3965tW d(InterfaceC3750qp interfaceC3750qp, Object obj, C3965tW c3965tW, int i, Object obj2) {
        if ((i & 2) != 0) {
            c3965tW = null;
        }
        return c(interfaceC3750qp, obj, c3965tW);
    }
}
