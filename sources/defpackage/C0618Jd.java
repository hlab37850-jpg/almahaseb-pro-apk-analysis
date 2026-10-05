package defpackage;

import com.itextpdf.text.Annotation;
import java.io.Serializable;

/* JADX INFO: renamed from: Jd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0618Jd implements InterfaceC0988Vf, Serializable {
    public final InterfaceC0988Vf a;
    public final InterfaceC0988Vf.b b;

    /* JADX INFO: renamed from: Jd$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String mo13invoke(String str, InterfaceC0988Vf.b bVar) {
            AbstractC4492zt.h(str, "acc");
            AbstractC4492zt.h(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public C0618Jd(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf.b bVar) {
        AbstractC4492zt.h(interfaceC0988Vf, "left");
        AbstractC4492zt.h(bVar, "element");
        this.a = interfaceC0988Vf;
        this.b = bVar;
    }

    private final int e() {
        int i = 2;
        C0618Jd c0618Jd = this;
        while (true) {
            InterfaceC0988Vf interfaceC0988Vf = c0618Jd.a;
            c0618Jd = interfaceC0988Vf instanceof C0618Jd ? (C0618Jd) interfaceC0988Vf : null;
            if (c0618Jd == null) {
                return i;
            }
            i++;
        }
    }

    public final boolean a(InterfaceC0988Vf.b bVar) {
        return AbstractC4492zt.d(get(bVar.getKey()), bVar);
    }

    public final boolean b(C0618Jd c0618Jd) {
        while (a(c0618Jd.b)) {
            InterfaceC0988Vf interfaceC0988Vf = c0618Jd.a;
            if (!(interfaceC0988Vf instanceof C0618Jd)) {
                AbstractC4492zt.f(interfaceC0988Vf, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((InterfaceC0988Vf.b) interfaceC0988Vf);
            }
            c0618Jd = (C0618Jd) interfaceC0988Vf;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C0618Jd) {
                C0618Jd c0618Jd = (C0618Jd) obj;
                if (c0618Jd.e() != e() || !c0618Jd.b(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.InterfaceC0988Vf
    public Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        return interfaceC0526Fp.mo13invoke(this.a.fold(obj, interfaceC0526Fp), this.b);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf.b get(InterfaceC0988Vf.c cVar) {
        AbstractC4492zt.h(cVar, "key");
        C0618Jd c0618Jd = this;
        while (true) {
            InterfaceC0988Vf.b bVar = c0618Jd.b.get(cVar);
            if (bVar != null) {
                return bVar;
            }
            InterfaceC0988Vf interfaceC0988Vf = c0618Jd.a;
            if (!(interfaceC0988Vf instanceof C0618Jd)) {
                return interfaceC0988Vf.get(cVar);
            }
            c0618Jd = (C0618Jd) interfaceC0988Vf;
        }
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        AbstractC4492zt.h(cVar, "key");
        if (this.b.get(cVar) != null) {
            return this.a;
        }
        InterfaceC0988Vf interfaceC0988VfMinusKey = this.a.minusKey(cVar);
        if (interfaceC0988VfMinusKey == this.a) {
            return this;
        }
        return interfaceC0988VfMinusKey == C1172Zk.a ? this.b : new C0618Jd(interfaceC0988VfMinusKey, this.b);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return InterfaceC0988Vf.a.a(this, interfaceC0988Vf);
    }

    public String toString() {
        return '[' + ((String) fold("", a.a)) + ']';
    }
}
