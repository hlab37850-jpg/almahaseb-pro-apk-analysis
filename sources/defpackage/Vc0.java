package defpackage;

import com.google.android.gms.internal.auth.zzey;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class Vc0 extends Y90 implements RandomAccess {
    public static final Vc0 c;
    public Object[] a;
    public int b;

    static {
        Vc0 vc0 = new Vc0(new Object[0], 0);
        c = vc0;
        vc0.zzb();
    }

    public Vc0(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    public static Vc0 a() {
        return c;
    }

    private final String zzf(int i) {
        return "Index:" + i + ", Size:" + this.b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.b)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        Object[] objArr = this.a;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.a, i, objArr2, i + 1, this.b - i);
            this.a = objArr2;
        }
        this.a[i] = obj;
        this.b++;
        ((AbstractList) this).modCount++;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.a[i];
    }

    @Override // defpackage.Y90, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zza();
        b(i);
        Object[] objArr = this.a;
        Object obj = objArr[i];
        int i2 = this.b;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.b--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zza();
        b(i);
        Object[] objArr = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.auth.zzey
    public final /* bridge */ /* synthetic */ zzey zzd(int i) {
        if (i >= this.b) {
            return new Vc0(Arrays.copyOf(this.a, i), this.b);
        }
        throw new IllegalArgumentException();
    }

    @Override // defpackage.Y90, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i = this.b;
        Object[] objArr = this.a;
        if (i == objArr.length) {
            this.a = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
