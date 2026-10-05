package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 0;
    private final InterfaceC0526Fp mergePolicy;
    private final String name;

    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsPropertyKey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public final T mo13invoke(T t, T t2) {
            return t == null ? t2 : t;
        }
    }

    public SemanticsPropertyKey(String str, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(interfaceC0526Fp, "mergePolicy");
        this.name = str;
        this.mergePolicy = interfaceC0526Fp;
    }

    public final InterfaceC0526Fp getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    public final String getName() {
        return this.name;
    }

    public final T getValue(SemanticsPropertyReceiver semanticsPropertyReceiver, InterfaceC0977Uu interfaceC0977Uu) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "thisRef");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        return (T) SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public final T merge(T t, T t2) {
        return (T) this.mergePolicy.mo13invoke(t, t2);
    }

    public final void setValue(SemanticsPropertyReceiver semanticsPropertyReceiver, InterfaceC0977Uu interfaceC0977Uu, T t) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "thisRef");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        semanticsPropertyReceiver.set(this, t);
    }

    public String toString() {
        return "SemanticsPropertyKey: " + this.name;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, InterfaceC0526Fp interfaceC0526Fp, int i, AbstractC0419Di abstractC0419Di) {
        this(str, (i & 2) != 0 ? AnonymousClass1.INSTANCE : interfaceC0526Fp);
    }
}
