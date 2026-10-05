package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: hM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2353hM extends V implements RandomAccess {
    public final Object[] a;
    public final int b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: hM$a */
    public static final class a extends U {
        public int c;
        public int d;

        public a() {
            this.c = C2353hM.this.size();
            this.d = C2353hM.this.c;
        }

        @Override // defpackage.U
        public void a() {
            if (this.c == 0) {
                b();
                return;
            }
            c(C2353hM.this.a[this.d]);
            this.d = (this.d + 1) % C2353hM.this.b;
            this.c--;
        }
    }

    public C2353hM(Object[] objArr, int i) {
        AbstractC4492zt.h(objArr, "buffer");
        this.a = objArr;
        if (i < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
        }
        if (i <= objArr.length) {
            this.b = objArr.length;
            this.d = i;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
    }

    public final void e(Object obj) {
        if (h()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.a[(this.c + size()) % this.b] = obj;
        this.d = size() + 1;
    }

    public final C2353hM f(int i) {
        Object[] array;
        int i2 = this.b;
        int iG = AbstractC3871sJ.g(i2 + (i2 >> 1) + 1, i);
        if (this.c == 0) {
            array = Arrays.copyOf(this.a, iG);
            AbstractC4492zt.g(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iG]);
        }
        return new C2353hM(array, size());
    }

    @Override // defpackage.V, java.util.List
    public Object get(int i) {
        V.Companion.b(i, size());
        return this.a[(this.c + i) % this.b];
    }

    @Override // defpackage.V, defpackage.D
    public int getSize() {
        return this.d;
    }

    public final boolean h() {
        return size() == this.b;
    }

    @Override // defpackage.V, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a();
    }

    public final void j(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (i > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        if (i > 0) {
            int i2 = this.c;
            int i3 = (i2 + i) % this.b;
            if (i2 > i3) {
                Q5.r(this.a, null, i2, this.b);
                Q5.r(this.a, null, 0, i3);
            } else {
                Q5.r(this.a, null, i2, i3);
            }
            this.c = i3;
            this.d = size() - i;
        }
    }

    @Override // defpackage.D, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        AbstractC4492zt.h(objArr, "array");
        if (objArr.length < size()) {
            objArr = Arrays.copyOf(objArr, size());
            AbstractC4492zt.g(objArr, "copyOf(...)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.c; i2 < size && i3 < this.b; i3++) {
            objArr[i2] = this.a[i3];
            i2++;
        }
        while (i2 < size) {
            objArr[i2] = this.a[i];
            i2++;
            i++;
        }
        return AbstractC1805bc.f(size, objArr);
    }

    public C2353hM(int i) {
        this(new Object[i], 0);
    }

    @Override // defpackage.D, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
