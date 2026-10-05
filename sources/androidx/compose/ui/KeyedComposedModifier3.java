package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class KeyedComposedModifier3 extends ComposedModifier {
    private final String fqName;
    private final Object key1;
    private final Object key2;
    private final Object key3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedComposedModifier3(String str, Object obj, Object obj2, Object obj3, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        super(interfaceC3750qp, interfaceC0552Gp);
        AbstractC4492zt.h(str, "fqName");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        this.fqName = str;
        this.key1 = obj;
        this.key2 = obj2;
        this.key3 = obj3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KeyedComposedModifier3) {
            KeyedComposedModifier3 keyedComposedModifier3 = (KeyedComposedModifier3) obj;
            if (AbstractC4492zt.d(this.fqName, keyedComposedModifier3.fqName) && AbstractC4492zt.d(this.key1, keyedComposedModifier3.key1) && AbstractC4492zt.d(this.key2, keyedComposedModifier3.key2) && AbstractC4492zt.d(this.key3, keyedComposedModifier3.key3)) {
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

    public final Object getKey2() {
        return this.key2;
    }

    public final Object getKey3() {
        return this.key3;
    }

    public int hashCode() {
        int iHashCode = this.fqName.hashCode() * 31;
        Object obj = this.key1;
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.key2;
        int iHashCode3 = (iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.key3;
        return iHashCode3 + (obj3 != null ? obj3.hashCode() : 0);
    }
}
