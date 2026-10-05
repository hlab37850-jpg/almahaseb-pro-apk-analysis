package defpackage;

import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcn;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: y90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4347y90 extends AbstractC4430z50 implements zzcn, RandomAccess {
    public static final C4347y90 c;
    public long[] a;
    public int b;

    static {
        C4347y90 c4347y90 = new C4347y90();
        c = c4347y90;
        c4347y90.zzv();
    }

    public C4347y90() {
        this(new long[10], 0);
    }

    public static C4347y90 b() {
        return c;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    private final String d(int i) {
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final long a(int i) {
        c(i);
        return this.a[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        e(i, ((Long) obj).longValue());
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof C4347y90)) {
            return super.addAll(collection);
        }
        C4347y90 c4347y90 = (C4347y90) collection;
        int i = c4347y90.b;
        if (i == 0) {
            return false;
        }
        int i2 = this.b;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.a;
        if (i3 > jArr.length) {
            this.a = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(c4347y90.a, 0, this.a, this.b, c4347y90.b);
        this.b = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void e(int i, long j) {
        int i2;
        zzw();
        if (i < 0 || i > (i2 = this.b)) {
            throw new IndexOutOfBoundsException(d(i));
        }
        long[] jArr = this.a;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.a, i, jArr2, i + 1, this.b - i);
            this.a = jArr2;
        }
        this.a[i] = j;
        this.b++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4347y90)) {
            return super.equals(obj);
        }
        C4347y90 c4347y90 = (C4347y90) obj;
        if (this.b != c4347y90.b) {
            return false;
        }
        long[] jArr = c4347y90.a;
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(long j) {
        e(this.b, j);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(a(i));
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzl = 1;
        for (int i = 0; i < this.b; i++) {
            iZzl = (iZzl * 31) + zzci.zzl(this.a[i]);
        }
        return iZzl;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        c(i);
        long[] jArr = this.a;
        long j = jArr[i];
        int i2 = this.b;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.b--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzw();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.a;
        System.arraycopy(jArr, i2, jArr, i, this.b - i2);
        this.b -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzw();
        c(i);
        long[] jArr = this.a;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn zzi(int i) {
        if (i >= this.b) {
            return new C4347y90(Arrays.copyOf(this.a, i), this.b);
        }
        throw new IllegalArgumentException();
    }

    public C4347y90(long[] jArr, int i) {
        this.a = jArr;
        this.b = i;
    }

    @Override // defpackage.AbstractC4430z50, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.b; i++) {
            if (obj.equals(Long.valueOf(this.a[i]))) {
                long[] jArr = this.a;
                System.arraycopy(jArr, i + 1, jArr, i, this.b - i);
                this.b--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
