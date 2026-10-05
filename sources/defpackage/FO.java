package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FO extends EO {

    public static final class a implements Iterable, InterfaceC0756Mu {
        public final /* synthetic */ InterfaceC4362yO a;

        public a(InterfaceC4362yO interfaceC4362yO) {
            this.a = interfaceC4362yO;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static final class b extends AbstractC2233fv implements InterfaceC3750qp {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj == null);
        }
    }

    public static Iterable i(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return new a(interfaceC4362yO);
    }

    public static int j(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        Iterator it = interfaceC4362yO.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                AbstractC1886cc.v();
            }
        }
        return i;
    }

    public static InterfaceC4362yO k(InterfaceC4362yO interfaceC4362yO, int i) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return interfaceC4362yO;
            }
            return interfaceC4362yO instanceof InterfaceC0343Ak ? ((InterfaceC0343Ak) interfaceC4362yO).b(i) : new C4483zk(interfaceC4362yO, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final InterfaceC4362yO l(InterfaceC4362yO interfaceC4362yO, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return new C4232wm(interfaceC4362yO, false, interfaceC3750qp);
    }

    public static final InterfaceC4362yO m(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        InterfaceC4362yO interfaceC4362yOL = l(interfaceC4362yO, b.a);
        AbstractC4492zt.f(interfaceC4362yOL, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return interfaceC4362yOL;
    }

    public static Object n(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        Iterator it = interfaceC4362yO.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final Appendable o(InterfaceC4362yO interfaceC4362yO, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) throws IOException {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        AbstractC4492zt.h(appendable, "buffer");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : interfaceC4362yO) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            AbstractC3228kS.a(appendable, obj, interfaceC3750qp);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String p(InterfaceC4362yO interfaceC4362yO, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        String string = ((StringBuilder) o(interfaceC4362yO, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC3750qp)).toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String q(InterfaceC4362yO interfaceC4362yO, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            interfaceC3750qp = null;
        }
        return p(interfaceC4362yO, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC3750qp);
    }

    public static InterfaceC4362yO r(InterfaceC4362yO interfaceC4362yO, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        return new C3149jV(interfaceC4362yO, interfaceC3750qp);
    }

    public static InterfaceC4362yO s(InterfaceC4362yO interfaceC4362yO, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        return m(new C3149jV(interfaceC4362yO, interfaceC3750qp));
    }

    public static Comparable t(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        Iterator it = interfaceC4362yO.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static InterfaceC4362yO u(InterfaceC4362yO interfaceC4362yO, int i) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return DO.e();
            }
            return interfaceC4362yO instanceof InterfaceC0343Ak ? ((InterfaceC0343Ak) interfaceC4362yO).a(i) : new C4043uT(interfaceC4362yO, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static List v(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        Iterator it = interfaceC4362yO.iterator();
        if (!it.hasNext()) {
            return AbstractC1886cc.m();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC1805bc.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
