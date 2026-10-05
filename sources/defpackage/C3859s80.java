package defpackage;

import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcn;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: s80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3859s80 extends AbstractC4430z50 implements zzcn, RandomAccess {
    public static final C3859s80 c;
    public int[] a;
    public int b;

    static {
        C3859s80 c3859s80 = new C3859s80();
        c = c3859s80;
        c3859s80.zzv();
    }

    public C3859s80() {
        this(new int[10], 0);
    }

    public static C3859s80 c() {
        return c;
    }

    public final int a(int i) {
        d(i);
        return this.a[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        f(i, ((Integer) obj).intValue());
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof C3859s80)) {
            return super.addAll(collection);
        }
        C3859s80 c3859s80 = (C3859s80) collection;
        int i = c3859s80.b;
        if (i == 0) {
            return false;
        }
        int i2 = this.b;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.a;
        if (i3 > iArr.length) {
            this.a = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(c3859s80.a, 0, this.a, this.b, c3859s80.b);
        this.b = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        f(this.b, i);
    }

    public final void d(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final String e(int i) {
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3859s80)) {
            return super.equals(obj);
        }
        C3859s80 c3859s80 = (C3859s80) obj;
        if (this.b != c3859s80.b) {
            return false;
        }
        int[] iArr = c3859s80.a;
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i, int i2) {
        int i3;
        zzw();
        if (i < 0 || i > (i3 = this.b)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        int[] iArr = this.a;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.a, i, iArr2, i + 1, this.b - i);
            this.a = iArr2;
        }
        this.a[i] = i2;
        this.b++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(a(i));
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.b; i2++) {
            i = (i * 31) + this.a[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        d(i);
        int[] iArr = this.a;
        int i2 = iArr[i];
        int i3 = this.b;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.b--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzw();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.a;
        System.arraycopy(iArr, i2, iArr, i, this.b - i2);
        this.b -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzw();
        d(i);
        int[] iArr = this.a;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn zzi(int i) {
        if (i >= this.b) {
            return new C3859s80(Arrays.copyOf(this.a, i), this.b);
        }
        throw new IllegalArgumentException();
    }

    public C3859s80(int[] iArr, int i) {
        this.a = iArr;
        this.b = i;
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.b; i++) {
            if (obj.equals(Integer.valueOf(this.a[i]))) {
                int[] iArr = this.a;
                System.arraycopy(iArr, i + 1, iArr, i, this.b - i);
                this.b--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
