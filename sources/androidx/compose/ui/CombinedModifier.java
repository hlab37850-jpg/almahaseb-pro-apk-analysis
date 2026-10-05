package androidx.compose.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CombinedModifier implements Modifier {
    public static final int $stable = 0;
    private final Modifier inner;
    private final Modifier outer;

    /* JADX INFO: renamed from: androidx.compose.ui.CombinedModifier$toString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final String mo13invoke(String str, Modifier.Element element) {
            AbstractC4492zt.h(str, "acc");
            AbstractC4492zt.h(element, "element");
            if (str.length() == 0) {
                return element.toString();
            }
            return str + ", " + element;
        }
    }

    public CombinedModifier(Modifier modifier, Modifier modifier2) {
        AbstractC4492zt.h(modifier, "outer");
        AbstractC4492zt.h(modifier2, "inner");
        this.outer = modifier;
        this.inner = modifier2;
    }

    @Override // androidx.compose.ui.Modifier
    public boolean all(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return this.outer.all(interfaceC3750qp) && this.inner.all(interfaceC3750qp);
    }

    @Override // androidx.compose.ui.Modifier
    public boolean any(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return this.outer.any(interfaceC3750qp) || this.inner.any(interfaceC3750qp);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            if (AbstractC4492zt.d(this.outer, combinedModifier.outer) && AbstractC4492zt.d(this.inner, combinedModifier.inner)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public <R> R foldIn(R r, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        return (R) this.inner.foldIn(this.outer.foldIn(r, interfaceC0526Fp), interfaceC0526Fp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public <R> R foldOut(R r, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        return (R) this.outer.foldOut(this.inner.foldOut(r, interfaceC0526Fp), interfaceC0526Fp);
    }

    public final Modifier getInner$ui_release() {
        return this.inner;
    }

    public final Modifier getOuter$ui_release() {
        return this.outer;
    }

    public int hashCode() {
        return this.outer.hashCode() + (this.inner.hashCode() * 31);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return YB.a(this, modifier);
    }

    public String toString() {
        return '[' + ((String) foldIn("", AnonymousClass1.INSTANCE)) + ']';
    }
}
