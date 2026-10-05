package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotWeakSet<T> {
    private int size;
    private int[] hashes = new int[16];
    private WeakReference<T>[] values = new WeakReference[16];

    private final int find(T t, int i) {
        int i2 = this.size - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.hashes[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    WeakReference<T> weakReference = this.values[i4];
                    return t == (weakReference != null ? weakReference.get() : null) ? i4 : findExactIndex(i4, t, i);
                }
                i2 = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    private final int findExactIndex(int i, T t, int i2) {
        int i3 = i - 1;
        while (true) {
            if (-1 >= i3 || this.hashes[i3] != i2) {
                break;
            }
            WeakReference<T> weakReference = this.values[i3];
            if ((weakReference != null ? weakReference.get() : null) == t) {
                return i3;
            }
            i3--;
        }
        int i4 = i + 1;
        int i5 = this.size;
        while (i4 < i5) {
            if (this.hashes[i4] != i2) {
                return -(i4 + 1);
            }
            WeakReference<T> weakReference2 = this.values[i4];
            if ((weakReference2 != null ? weakReference2.get() : null) == t) {
                return i4;
            }
            i4++;
        }
        i4 = this.size;
        return -(i4 + 1);
    }

    public final boolean add(T t) {
        int iFind;
        AbstractC4492zt.h(t, "value");
        int i = this.size;
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(t);
        if (i > 0) {
            iFind = find(t, iIdentityHashCode);
            if (iFind >= 0) {
                return false;
            }
        } else {
            iFind = -1;
        }
        int i2 = -(iFind + 1);
        WeakReference<T>[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i == length) {
            int i3 = length * 2;
            WeakReference<T>[] weakReferenceArr2 = new WeakReference[i3];
            int[] iArr = new int[i3];
            int i4 = i2 + 1;
            Q5.i(weakReferenceArr, weakReferenceArr2, i4, i2, i);
            Q5.m(this.values, weakReferenceArr2, 0, 0, i2, 6, null);
            Q5.g(this.hashes, iArr, i4, i2, i);
            Q5.l(this.hashes, iArr, 0, 0, i2, 6, null);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i5 = i2 + 1;
            Q5.i(weakReferenceArr, weakReferenceArr, i5, i2, i);
            int[] iArr2 = this.hashes;
            Q5.g(iArr2, iArr2, i5, i2, i);
        }
        this.values[i2] = new WeakReference<>(t);
        this.hashes[i2] = iIdentityHashCode;
        this.size++;
        return true;
    }

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final boolean isValid$runtime_release() {
        WeakReference<T> weakReference;
        int i = this.size;
        WeakReference<T>[] weakReferenceArr = this.values;
        int[] iArr = this.hashes;
        int length = weakReferenceArr.length;
        if (i > length) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            if (i4 < i2 || (weakReference = weakReferenceArr[i3]) == null) {
                return false;
            }
            T t = weakReference.get();
            if (t != null && i4 != ActualJvm_jvmKt.identityHashCode(t)) {
                return false;
            }
            i3++;
            i2 = i4;
        }
        while (i < length) {
            if (iArr[i] != 0 || weakReferenceArr[i] != null) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void removeIf(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int size$runtime_release = getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference<T> weakReference = getValues$runtime_release()[i];
            T t = weakReference != null ? weakReference.get() : null;
            if (t != null && !((Boolean) interfaceC3750qp.invoke(t)).booleanValue()) {
                if (i2 != i) {
                    getValues$runtime_release()[i2] = weakReference;
                    getHashes$runtime_release()[i2] = getHashes$runtime_release()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            getValues$runtime_release()[i3] = null;
            getHashes$runtime_release()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            setSize$runtime_release(i2);
        }
    }

    public final void setHashes$runtime_release(int[] iArr) {
        AbstractC4492zt.h(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final void setValues$runtime_release(WeakReference<T>[] weakReferenceArr) {
        AbstractC4492zt.h(weakReferenceArr, "<set-?>");
        this.values = weakReferenceArr;
    }
}
