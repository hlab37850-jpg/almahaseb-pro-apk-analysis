package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class I6 {

    public static final class a extends AbstractC0819Pf {
        public Object a;
        public /* synthetic */ Object b;
        public int c;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return I6.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(Collection collection, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
        Iterator it;
        if (interfaceC0793Of instanceof a) {
            aVar = (a) interfaceC0793Of;
            int i = aVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.c = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(interfaceC0793Of);
            }
        } else {
            aVar = new a(interfaceC0793Of);
        }
        Object obj = aVar.b;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.c;
        if (i2 == 0) {
            LL.b(obj);
            it = collection.iterator();
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) aVar.a;
            LL.b(obj);
        }
        while (it.hasNext()) {
            InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) it.next();
            aVar.a = it;
            aVar.c = 1;
            if (interfaceC1830bu.F(aVar) == objD) {
                return objD;
            }
        }
        return FW.a;
    }
}
