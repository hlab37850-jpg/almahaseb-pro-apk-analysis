package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;

/* JADX INFO: loaded from: classes.dex */
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    private int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, null);
    }

    private final int find(Object obj) {
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        Object[] objArr = this.keys;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = objArr[i3];
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
        Object obj2;
        Object[] objArr = this.keys;
        int i3 = this.size;
        for (int i4 = i - 1; -1 < i4; i4--) {
            Object obj3 = objArr[i4];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -(i3 + 1);
            }
            obj2 = objArr[i];
            if (obj2 == obj) {
                return i;
            }
        } while (ActualJvm_jvmKt.identityHashCode(obj2) == i2);
        return -(i + 1);
    }

    public final void clear() {
        this.size = 0;
        Q5.u(this.keys, null, 0, 0, 6, null);
        Q5.u(this.values, null, 0, 0, 6, null);
    }

    public final boolean contains(Key key) {
        AbstractC4492zt.h(key, "key");
        return find(key) >= 0;
    }

    public final void forEach(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        int size = getSize();
        for (int i = 0; i < size; i++) {
            Object obj = getKeys()[i];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            interfaceC0526Fp.mo13invoke(obj, getValues()[i]);
        }
    }

    public final Value get(Key key) {
        AbstractC4492zt.h(key, "key");
        int iFind = find(key);
        if (iFind >= 0) {
            return (Value) this.values[iFind];
        }
        return null;
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final Value remove(Key key) {
        AbstractC4492zt.h(key, "key");
        int iFind = find(key);
        if (iFind < 0) {
            return null;
        }
        Object[] objArr = this.values;
        Value value = (Value) objArr[iFind];
        int i = this.size;
        Object[] objArr2 = this.keys;
        int i2 = iFind + 1;
        Q5.i(objArr2, objArr2, iFind, i2, i);
        Q5.i(objArr, objArr, iFind, i2, i);
        int i3 = i - 1;
        objArr2[i3] = null;
        objArr[i3] = null;
        this.size = i3;
        return value;
    }

    public final void removeIf(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = getKeys()[i2];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!((Boolean) interfaceC0526Fp.mo13invoke(obj, getValues()[i2])).booleanValue()) {
                if (i != i2) {
                    getKeys()[i] = obj;
                    getValues()[i] = getValues()[i2];
                }
                i++;
            }
        }
        if (getSize() > i) {
            int size2 = getSize();
            for (int i3 = i; i3 < size2; i3++) {
                getKeys()[i3] = null;
                getValues()[i3] = null;
            }
            this.size = i;
        }
    }

    public final void removeValueIf(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = getKeys()[i2];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!((Boolean) interfaceC3750qp.invoke(getValues()[i2])).booleanValue()) {
                if (i != i2) {
                    getKeys()[i] = obj;
                    getValues()[i] = getValues()[i2];
                }
                i++;
            }
        }
        if (getSize() > i) {
            int size2 = getSize();
            for (int i3 = i; i3 < size2; i3++) {
                getKeys()[i3] = null;
                getValues()[i3] = null;
            }
            this.size = i;
        }
    }

    public final void set(Key key, Value value) {
        AbstractC4492zt.h(key, "key");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i = this.size;
        int iFind = find(key);
        if (iFind >= 0) {
            objArr2[iFind] = value;
            return;
        }
        int i2 = -(iFind + 1);
        boolean z = i == objArr.length;
        Object[] objArr3 = z ? new Object[i * 2] : objArr;
        int i3 = i2 + 1;
        Q5.i(objArr, objArr3, i3, i2, i);
        if (z) {
            Q5.m(objArr, objArr3, 0, 0, i2, 6, null);
        }
        objArr3[i2] = key;
        this.keys = objArr3;
        Object[] objArr4 = z ? new Object[i * 2] : objArr2;
        Q5.i(objArr2, objArr4, i3, i2, i);
        if (z) {
            Q5.m(objArr2, objArr4, 0, 0, i2, 6, null);
        }
        objArr4[i2] = value;
        this.values = objArr4;
        this.size++;
    }

    public IdentityArrayMap(int i) {
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    public /* synthetic */ IdentityArrayMap(int i, int i2, AbstractC0419Di abstractC0419Di) {
        this((i2 & 1) != 0 ? 16 : i);
    }
}
