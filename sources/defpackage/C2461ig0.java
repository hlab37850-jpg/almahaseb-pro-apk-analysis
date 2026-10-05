package defpackage;

import com.google.android.gms.internal.vision.zzjl;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: ig0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2461ig0 extends AbstractC1810be0 implements RandomAccess {
    public static final C2461ig0 c;
    public Object[] a;
    public int b;

    static {
        C2461ig0 c2461ig0 = new C2461ig0(new Object[0], 0);
        c = c2461ig0;
        c2461ig0.zzb();
    }

    public C2461ig0(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    public static C2461ig0 c() {
        return c;
    }

    public final void a(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    @Override // defpackage.AbstractC1810be0, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzc();
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

    public final String b(int i) {
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        a(i);
        return this.a[i];
    }

    @Override // defpackage.AbstractC1810be0, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zzc();
        a(i);
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
        zzc();
        a(i);
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

    @Override // com.google.android.gms.internal.vision.zzjl
    public final /* synthetic */ zzjl zza(int i) {
        if (i >= this.b) {
            return new C2461ig0(Arrays.copyOf(this.a, i), this.b);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zzc();
        if (i >= 0 && i <= (i2 = this.b)) {
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
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }
}
