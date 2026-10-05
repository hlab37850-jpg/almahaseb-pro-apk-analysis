package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.Q5;

/* JADX INFO: loaded from: classes.dex */
public final class IdentityArrayIntMap {
    private int size;
    private Object[] keys = new Object[4];
    private int[] values = new int[4];

    private final int find(Object obj) {
        int i = this.size - 1;
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
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
                    return obj2 == obj ? i3 : findExactIndex(i3, obj, iIdentityHashCode);
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

    public final int add(Object obj, int i) {
        int iFind;
        AbstractC4492zt.h(obj, "key");
        int[] iArr = this.values;
        if (this.size > 0) {
            iFind = find(obj);
            if (iFind >= 0) {
                int i2 = iArr[iFind];
                iArr[iFind] = i;
                return i2;
            }
        } else {
            iFind = -1;
        }
        int i3 = -(iFind + 1);
        Object[] objArr = this.keys;
        int i4 = this.size;
        if (i4 == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            int[] iArr2 = new int[objArr.length * 2];
            int i5 = i3 + 1;
            Q5.i(objArr, objArr2, i5, i3, i4);
            Q5.g(iArr, iArr2, i5, i3, i4);
            Q5.m(objArr, objArr2, 0, 0, i3, 6, null);
            Q5.l(iArr, iArr2, 0, 0, i3, 6, null);
            this.keys = objArr2;
            this.values = iArr2;
        } else {
            int i6 = i3 + 1;
            Q5.i(objArr, objArr, i6, i3, i4);
            Q5.g(iArr, iArr, i6, i3, i4);
        }
        this.keys[i3] = obj;
        this.values[i3] = i;
        this.size++;
        return -1;
    }

    public final boolean any(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "predicate");
        Object[] keys = getKeys();
        int[] values = getValues();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            Object obj = keys[i];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Any");
            if (((Boolean) interfaceC0526Fp.mo13invoke(obj, Integer.valueOf(values[i]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void forEach(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        Object[] keys = getKeys();
        int[] values = getValues();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            Object obj = keys[i];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Any");
            interfaceC0526Fp.mo13invoke(obj, Integer.valueOf(values[i]));
        }
    }

    public final int get(Object obj) {
        AbstractC4492zt.h(obj, "key");
        int iFind = find(obj);
        if (iFind >= 0) {
            return this.values[iFind];
        }
        throw new IllegalStateException("Key not found");
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValues() {
        return this.values;
    }

    public final boolean remove(Object obj) {
        AbstractC4492zt.h(obj, "key");
        int iFind = find(obj);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int i = this.size;
        if (iFind < 0) {
            return false;
        }
        int i2 = i - 1;
        if (iFind < i2) {
            int i3 = iFind + 1;
            Q5.i(objArr, objArr, iFind, i3, i);
            Q5.g(iArr, iArr, iFind, i3, i);
        }
        objArr[i2] = null;
        this.size = i2;
        return true;
    }

    public final void removeValueIf(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "predicate");
        Object[] keys = getKeys();
        int[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = keys[i2];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Any");
            int i3 = values[i2];
            if (!((Boolean) interfaceC0526Fp.mo13invoke(obj, Integer.valueOf(i3))).booleanValue()) {
                if (i != i2) {
                    keys[i] = obj;
                    values[i] = i3;
                }
                i++;
            }
        }
        for (int i4 = i; i4 < size; i4++) {
            keys[i4] = null;
        }
        this.size = i;
    }
}
