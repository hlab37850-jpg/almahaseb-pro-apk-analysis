package defpackage;

import com.google.android.gms.internal.vision.zzjf;
import com.google.android.gms.internal.vision.zzjl;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: vf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4142vf0 extends AbstractC1810be0 implements zzjl, Xf0, RandomAccess {
    public static final C4142vf0 c;
    public int[] a;
    public int b;

    static {
        C4142vf0 c4142vf0 = new C4142vf0(new int[0], 0);
        c = c4142vf0;
        c4142vf0.zzb();
    }

    public C4142vf0(int[] iArr, int i) {
        this.a = iArr;
        this.b = i;
    }

    public static C4142vf0 c() {
        return c;
    }

    public final int a(int i) {
        d(i);
        return this.a[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        zzc();
        if (i < 0 || i > (i2 = this.b)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        int[] iArr = this.a;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.a, i, iArr2, i + 1, this.b - i);
            this.a = iArr2;
        }
        this.a[i] = iIntValue;
        this.b++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.AbstractC1810be0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzc();
        zzjf.zza(collection);
        if (!(collection instanceof C4142vf0)) {
            return super.addAll(collection);
        }
        C4142vf0 c4142vf0 = (C4142vf0) collection;
        int i = c4142vf0.b;
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
        System.arraycopy(c4142vf0.a, 0, this.a, this.b, c4142vf0.b);
        this.b = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        zzc();
        int i2 = this.b;
        int[] iArr = this.a;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.a = iArr2;
        }
        int[] iArr3 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
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

    @Override // defpackage.AbstractC1810be0, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4142vf0)) {
            return super.equals(obj);
        }
        C4142vf0 c4142vf0 = (C4142vf0) obj;
        if (this.b != c4142vf0.b) {
            return false;
        }
        int[] iArr = c4142vf0.a;
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(a(i));
    }

    @Override // defpackage.AbstractC1810be0, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.b; i2++) {
            i = (i * 31) + this.a[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.a[i] == iIntValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // defpackage.AbstractC1810be0, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzc();
        d(i);
        int[] iArr = this.a;
        int i2 = iArr[i];
        int i3 = this.b;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.b--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzc();
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
        zzc();
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

    @Override // com.google.android.gms.internal.vision.zzjl
    public final /* synthetic */ zzjl zza(int i) {
        if (i >= this.b) {
            return new C4142vf0(Arrays.copyOf(this.a, i), this.b);
        }
        throw new IllegalArgumentException();
    }

    @Override // defpackage.AbstractC1810be0, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        b(((Integer) obj).intValue());
        return true;
    }
}
