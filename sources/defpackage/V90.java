package defpackage;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzfc;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class V90 extends AbstractMap implements Serializable {
    public static final Object j = new Object();
    public transient Object a;
    public transient int[] b;
    public transient Object[] c;
    public transient Object[] d;
    public transient int e;
    public transient int f;
    public transient Set g;
    public transient Set h;
    public transient Collection i;

    public V90() {
        zzde.zza(true, (Object) "Expected size must be >= 0");
        this.e = zzfc.zza(3, 1, 1073741823);
    }

    public static int k(int i, int i2) {
        return i - 1;
    }

    public static /* synthetic */ int t(V90 v90) {
        int i = v90.f;
        v90.f = i - 1;
        return i;
    }

    public final int a(int i) {
        int i2 = i + 1;
        if (i2 < this.f) {
            return i2;
        }
        return -1;
    }

    public final int b(int i, int i2, int i3, int i4) {
        Object objD = Fa0.d(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            Fa0.e(objD, i3 & i5, i4 + 1);
        }
        Object obj = this.a;
        int[] iArr = this.b;
        for (int i6 = 0; i6 <= i; i6++) {
            int iB = Fa0.b(obj, i6);
            while (iB != 0) {
                int i7 = iB - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iB2 = Fa0.b(objD, i10);
                Fa0.e(objD, i10, iB);
                iArr[i7] = Fa0.a(i9, iB2, i5);
                iB = i8 & i;
            }
        }
        this.a = objD;
        p(i5);
        return i5;
    }

    public final int c(Object obj) {
        if (j()) {
            return -1;
        }
        int iB = La0.b(obj);
        int iY = y();
        int iB2 = Fa0.b(this.a, iB & iY);
        if (iB2 == 0) {
            return -1;
        }
        int i = ~iY;
        int i2 = iB & i;
        do {
            int i3 = iB2 - 1;
            int i4 = this.b[i3];
            if ((i4 & i) == i2 && zzcz.zza(obj, this.c[i3])) {
                return i3;
            }
            iB2 = i4 & iY;
        } while (iB2 != 0);
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (j()) {
            return;
        }
        r();
        Map mapO = o();
        if (mapO != null) {
            this.e = zzfc.zza(size(), 3, 1073741823);
            mapO.clear();
            this.a = null;
            this.f = 0;
            return;
        }
        Arrays.fill(this.c, 0, this.f, (Object) null);
        Arrays.fill(this.d, 0, this.f, (Object) null);
        Object obj = this.a;
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(this.b, 0, this.f, 0);
        this.f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapO = o();
        if (mapO != null) {
            return mapO.containsKey(obj);
        }
        return c(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapO = o();
        if (mapO != null) {
            return mapO.containsValue(obj);
        }
        for (int i = 0; i < this.f; i++) {
            if (zzcz.zza(obj, this.d[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        C2041da0 c2041da0 = new C2041da0(this);
        this.h = c2041da0;
        return c2041da0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapO = o();
        if (mapO != null) {
            return mapO.get(obj);
        }
        int iC = c(obj);
        if (iC == -1) {
            return null;
        }
        return this.d[iC];
    }

    public final void h(int i, int i2) {
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            this.c[i] = null;
            this.d[i] = null;
            this.b[i] = 0;
            return;
        }
        Object[] objArr = this.c;
        Object obj = objArr[i3];
        objArr[i] = obj;
        Object[] objArr2 = this.d;
        objArr2[i] = objArr2[i3];
        objArr[i3] = null;
        objArr2[i3] = null;
        int[] iArr = this.b;
        iArr[i] = iArr[i3];
        iArr[i3] = 0;
        int iB = La0.b(obj) & i2;
        int iB2 = Fa0.b(this.a, iB);
        if (iB2 == size) {
            Fa0.e(this.a, iB, i + 1);
            return;
        }
        while (true) {
            int i4 = iB2 - 1;
            int[] iArr2 = this.b;
            int i5 = iArr2[i4];
            int i6 = i5 & i2;
            if (i6 == size) {
                iArr2[i4] = Fa0.a(i5, i + 1, i2);
                return;
            }
            iB2 = i6;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean j() {
        return this.a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.g;
        if (set != null) {
            return set;
        }
        C2368ha0 c2368ha0 = new C2368ha0(this);
        this.g = c2368ha0;
        return c2368ha0;
    }

    public final Object n(Object obj) {
        if (j()) {
            return j;
        }
        int iY = y();
        int iC = Fa0.c(obj, null, iY, this.a, this.b, this.c, null);
        if (iC == -1) {
            return j;
        }
        Object obj2 = this.d[iC];
        h(iC, iY);
        this.f--;
        r();
        return obj2;
    }

    public final Map o() {
        Object obj = this.a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void p(int i) {
        this.e = Fa0.a(this.e, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (j()) {
            zzde.zzb(j(), "Arrays already allocated");
            int i = this.e;
            int iMax = Math.max(i + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            int iMax2 = Math.max(4, (iMax <= ((int) (((double) iHighestOneBit) * 1.0d)) || (iHighestOneBit = iHighestOneBit << 1) > 0) ? iHighestOneBit : 1073741824);
            this.a = Fa0.d(iMax2);
            p(iMax2 - 1);
            this.b = new int[i];
            this.c = new Object[i];
            this.d = new Object[i];
        }
        Map mapO = o();
        if (mapO != null) {
            return mapO.put(obj, obj2);
        }
        int[] iArr = this.b;
        Object[] objArr = this.c;
        Object[] objArr2 = this.d;
        int i2 = this.f;
        int i3 = i2 + 1;
        int iB = La0.b(obj);
        int iY = y();
        int i4 = iB & iY;
        int iB2 = Fa0.b(this.a, i4);
        if (iB2 != 0) {
            int i5 = ~iY;
            int i6 = iB & i5;
            int i7 = 0;
            while (true) {
                int i8 = iB2 - 1;
                int i9 = iArr[i8];
                if ((i9 & i5) == i6 && zzcz.zza(obj, objArr[i8])) {
                    Object obj3 = objArr2[i8];
                    objArr2[i8] = obj2;
                    return obj3;
                }
                int i10 = i9 & iY;
                Object[] objArr3 = objArr;
                int i11 = i7 + 1;
                if (i10 == 0) {
                    if (i11 < 9) {
                        if (i3 <= iY) {
                            iArr[i8] = Fa0.a(i9, i3, iY);
                            break;
                        }
                        iY = b(iY, Fa0.f(iY), iB, i2);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(y() + 1, 1.0f);
                    int iS = s();
                    while (iS >= 0) {
                        linkedHashMap.put(this.c[iS], this.d[iS]);
                        iS = a(iS);
                    }
                    this.a = linkedHashMap;
                    this.b = null;
                    this.c = null;
                    this.d = null;
                    r();
                    return linkedHashMap.put(obj, obj2);
                }
                i7 = i11;
                iB2 = i10;
                objArr = objArr3;
            }
        } else if (i3 > iY) {
            iY = b(iY, Fa0.f(iY), iB, i2);
        } else {
            Fa0.e(this.a, i4, i3);
        }
        int length = this.b.length;
        if (i3 > length && (iMin = Math.min(1073741823, 1 | (Math.max(1, length >>> 1) + length))) != length) {
            this.b = Arrays.copyOf(this.b, iMin);
            this.c = Arrays.copyOf(this.c, iMin);
            this.d = Arrays.copyOf(this.d, iMin);
        }
        this.b[i2] = Fa0.a(iB, 0, iY);
        this.c[i2] = obj;
        this.d[i2] = obj2;
        this.f = i3;
        r();
        return null;
    }

    public final void r() {
        this.e += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapO = o();
        if (mapO != null) {
            return mapO.remove(obj);
        }
        Object objN = n(obj);
        if (objN == j) {
            return null;
        }
        return objN;
    }

    public final int s() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapO = o();
        return mapO != null ? mapO.size() : this.f;
    }

    public final Iterator u() {
        Map mapO = o();
        return mapO != null ? mapO.keySet().iterator() : new C1802ba0(this);
    }

    public final Iterator v() {
        Map mapO = o();
        return mapO != null ? mapO.entrySet().iterator() : new Z90(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.i;
        if (collection != null) {
            return collection;
        }
        C3565oa0 c3565oa0 = new C3565oa0(this);
        this.i = c3565oa0;
        return c3565oa0;
    }

    public final Iterator w() {
        Map mapO = o();
        return mapO != null ? mapO.values().iterator() : new C2122ea0(this);
    }

    public final int y() {
        return (1 << (this.e & 31)) - 1;
    }
}
