package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class KeyedComposedModifierN extends ComposedModifier {
    private final String fqName;
    private final Object[] keys;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedComposedModifierN(String str, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        super(interfaceC3750qp, interfaceC0552Gp);
        AbstractC4492zt.h(str, "fqName");
        AbstractC4492zt.h(objArr, "keys");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        this.fqName = str;
        this.keys = objArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KeyedComposedModifierN) {
            KeyedComposedModifierN keyedComposedModifierN = (KeyedComposedModifierN) obj;
            if (AbstractC4492zt.d(this.fqName, keyedComposedModifierN.fqName) && Arrays.equals(this.keys, keyedComposedModifierN.keys)) {
                return true;
            }
        }
        return false;
    }

    public final String getFqName() {
        return this.fqName;
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return (this.fqName.hashCode() * 31) + Arrays.hashCode(this.keys);
    }
}
