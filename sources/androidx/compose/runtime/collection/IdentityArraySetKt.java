package androidx.compose.runtime.collection;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class IdentityArraySetKt {
    public static final <T> void fastForEach(Set<? extends T> set, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(set, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        if (!(set instanceof IdentityArraySet)) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                interfaceC3750qp.invoke(it.next());
            }
            return;
        }
        IdentityArraySet identityArraySet = (IdentityArraySet) set;
        Object[] values = identityArraySet.getValues();
        int size = identityArraySet.size();
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            interfaceC3750qp.invoke(obj);
        }
    }
}
