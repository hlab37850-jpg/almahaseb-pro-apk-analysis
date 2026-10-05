package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class KeyedComposedModifier1 extends ComposedModifier {
    private final String fqName;
    private final Object key1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedComposedModifier1(String str, Object obj, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        super(interfaceC3750qp, interfaceC0552Gp);
        AbstractC4492zt.h(str, "fqName");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        this.fqName = str;
        this.key1 = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KeyedComposedModifier1) {
            KeyedComposedModifier1 keyedComposedModifier1 = (KeyedComposedModifier1) obj;
            if (AbstractC4492zt.d(this.fqName, keyedComposedModifier1.fqName) && AbstractC4492zt.d(this.key1, keyedComposedModifier1.key1)) {
                return true;
            }
        }
        return false;
    }

    public final String getFqName() {
        return this.fqName;
    }

    public final Object getKey1() {
        return this.key1;
    }

    public int hashCode() {
        int iHashCode = this.fqName.hashCode() * 31;
        Object obj = this.key1;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }
}
