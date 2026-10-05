package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = i;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int find(Object obj) {
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        Object[] objArr = this.values;
        int[] iArr = this.valueOrder;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = objArr[iArr[i3]];
            int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (iIdentityHashCode2 < iIdentityHashCode) {
                i2 = i3 + 1;
            } else {
                if (iIdentityHashCode2 <= iIdentityHashCode) {
                    return obj == obj2 ? i3 : findExactIndex(i3, obj, iIdentityHashCode);
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        Object[] objArr = this.values;
        int[] iArr = this.valueOrder;
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj2 = objArr[iArr[i3]];
            if (obj2 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj2) != i2) {
                break;
            }
        }
        int i4 = i + 1;
        int i5 = this.size;
        while (i4 < i5) {
            Object obj3 = objArr[iArr[i4]];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                return -(i4 + 1);
            }
            i4++;
        }
        i4 = this.size;
        return -(i4 + 1);
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object obj) {
        int iFind;
        int i = this.size;
        int[] iArr = this.valueOrder;
        Object[] objArr = this.values;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        if (i > 0) {
            iFind = find(obj);
            if (iFind >= 0) {
                return scopeSetAt(iFind);
            }
        } else {
            iFind = -1;
        }
        int i2 = -(iFind + 1);
        if (i < iArr.length) {
            int i3 = iArr[i];
            objArr[i3] = obj;
            IdentityArraySet<T> identityArraySet = identityArraySetArr[i3];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                identityArraySetArr[i3] = identityArraySet;
            }
            if (i2 < i) {
                Q5.g(iArr, iArr, i2 + 1, i2, i);
            }
            iArr[i2] = i3;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] objArrCopyOf = Arrays.copyOf(identityArraySetArr, length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        IdentityArraySet<T>[] identityArraySetArr2 = (IdentityArraySet[]) objArrCopyOf;
        IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
        identityArraySetArr2[i] = identityArraySet2;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, length);
        AbstractC4492zt.g(objArrCopyOf2, "copyOf(this, newSize)");
        objArrCopyOf2[i] = obj;
        int[] iArr2 = new int[length];
        for (int i4 = i + 1; i4 < length; i4++) {
            iArr2[i4] = i4;
        }
        if (i2 < i) {
            Q5.g(iArr, iArr2, i2 + 1, i2, i);
        }
        iArr2[i2] = i;
        if (i2 > 0) {
            Q5.l(iArr, iArr2, 0, 0, i2, 6, null);
        }
        this.scopeSets = identityArraySetArr2;
        this.values = objArrCopyOf2;
        this.valueOrder = iArr2;
        this.size++;
        return identityArraySet2;
    }

    private final void removingScopes(InterfaceC3750qp interfaceC3750qp) {
        int[] valueOrder = getValueOrder();
        IdentityArraySet<T>[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet<T> identityArraySet = scopeSets[i3];
            AbstractC4492zt.e(identityArraySet);
            interfaceC3750qp.invoke(identityArraySet);
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i4 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i4;
                }
                i++;
            }
        }
        int size2 = getSize();
        for (int i5 = i; i5 < size2; i5++) {
            values[valueOrder[i5]] = null;
        }
        setSize(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int i) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[i]];
        AbstractC4492zt.e(identityArraySet);
        return identityArraySet;
    }

    public final boolean add(Object obj, T t) {
        AbstractC4492zt.h(obj, "value");
        AbstractC4492zt.h(t, "scope");
        return getOrCreateIdentitySet(obj).add(t);
    }

    public final void clear() {
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        int[] iArr = this.valueOrder;
        Object[] objArr = this.values;
        int length = identityArraySetArr.length;
        for (int i = 0; i < length; i++) {
            IdentityArraySet<T> identityArraySet = identityArraySetArr[i];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            iArr[i] = i;
            objArr[i] = null;
        }
        this.size = 0;
    }

    public final boolean contains(Object obj) {
        AbstractC4492zt.h(obj, "element");
        return find(obj) >= 0;
    }

    public final void forEachScopeOf(Object obj, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(obj, "value");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iFind = find(obj);
        if (iFind >= 0) {
            IdentityArraySet identityArraySetScopeSetAt = scopeSetAt(iFind);
            Object[] values = identityArraySetScopeSetAt.getValues();
            int size = identityArraySetScopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                interfaceC3750qp.invoke(obj2);
            }
        }
    }

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final boolean remove(Object obj, T t) {
        int i;
        IdentityArraySet<T> identityArraySet;
        AbstractC4492zt.h(obj, "value");
        AbstractC4492zt.h(t, "scope");
        int iFind = find(obj);
        int[] iArr = this.valueOrder;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        Object[] objArr = this.values;
        int i2 = this.size;
        if (iFind < 0 || (identityArraySet = identityArraySetArr[(i = iArr[iFind])]) == null) {
            return false;
        }
        boolean zRemove = identityArraySet.remove(t);
        if (identityArraySet.size() == 0) {
            int i3 = iFind + 1;
            if (i3 < i2) {
                Q5.g(iArr, iArr, iFind, i3, i2);
            }
            int i4 = i2 - 1;
            iArr[i4] = i;
            objArr[i] = null;
            this.size = i4;
        }
        return zRemove;
    }

    public final void removeScope(T t) {
        AbstractC4492zt.h(t, "scope");
        int[] valueOrder = getValueOrder();
        IdentityArraySet<T>[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet<T> identityArraySet = scopeSets[i3];
            AbstractC4492zt.e(identityArraySet);
            identityArraySet.remove(t);
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i4 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i4;
                }
                i++;
            }
        }
        int size2 = getSize();
        for (int i5 = i; i5 < size2; i5++) {
            values[valueOrder[i5]] = null;
        }
        setSize(i);
    }

    public final void removeValueIf(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        int[] valueOrder = getValueOrder();
        IdentityArraySet<T>[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet<T> identityArraySet = scopeSets[i3];
            AbstractC4492zt.e(identityArraySet);
            Object[] values2 = identityArraySet.getValues();
            int size2 = identityArraySet.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size2; i5++) {
                Object obj = values2[i5];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!((Boolean) interfaceC3750qp.invoke(obj)).booleanValue()) {
                    if (i4 != i5) {
                        values2[i4] = obj;
                    }
                    i4++;
                }
            }
            for (int i6 = i4; i6 < size2; i6++) {
                values2[i6] = null;
            }
            ((IdentityArraySet) identityArraySet).size = i4;
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i7 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i7;
                }
                i++;
            }
        }
        int size3 = getSize();
        for (int i8 = i; i8 < size3; i8++) {
            values[valueOrder[i8]] = null;
        }
        setSize(i);
    }

    public final void setSize(int i) {
        this.size = i;
    }
}
