package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC3590or;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class A extends ImmutableMap {
    public static final ImmutableMap d = new A(null, new Object[0], 0);
    public final transient Object a;
    public final transient Object[] b;
    public final transient int c;

    public static class a extends ImmutableSet {
        public final transient ImmutableMap a;
        public final transient Object[] b;
        public final transient int c;
        public final transient int d;

        /* JADX INFO: renamed from: com.google.common.collect.A$a$a, reason: collision with other inner class name */
        public class C0216a extends ImmutableList {
            public C0216a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i) {
                Preconditions.checkElementIndex(i, a.this.d);
                int i2 = i * 2;
                Object obj = a.this.b[a.this.c + i2];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.b[i2 + (a.this.c ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.d;
            }
        }

        public a(ImmutableMap immutableMap, Object[] objArr, int i, int i2) {
            this.a = immutableMap;
            this.b = objArr;
            this.c = i;
            this.d = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.a.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList createAsList() {
            return new C0216a();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.d;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator iterator() {
            return asList().iterator();
        }
    }

    public static final class b extends ImmutableSet {
        public final transient ImmutableMap a;
        public final transient ImmutableList b;

        public b(ImmutableMap immutableMap, ImmutableList immutableList) {
            this.a = immutableMap;
            this.b = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList asList() {
            return this.b;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator iterator() {
            return asList().iterator();
        }
    }

    public static final class c extends ImmutableList {
        public final transient Object[] a;
        public final transient int b;
        public final transient int c;

        public c(Object[] objArr, int i, int i2) {
            this.a = objArr;
            this.b = i;
            this.c = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.c);
            Object obj = this.a[(i * 2) + this.b];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c;
        }
    }

    public A(Object obj, Object[] objArr, int i) {
        this.a = obj;
        this.b = objArr;
        this.c = i;
    }

    public static A a(int i, Object[] objArr) {
        return b(i, objArr, null);
    }

    public static A b(int i, Object[] objArr, ImmutableMap.Builder builder) {
        if (i == 0) {
            return (A) d;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            AbstractC1163Zb.a(obj, obj2);
            return new A(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        Object objC = c(objArr, i, ImmutableSet.chooseTableSize(i), 0);
        if (objC instanceof Object[]) {
            Object[] objArr2 = (Object[]) objC;
            ImmutableMap.Builder.a aVar = (ImmutableMap.Builder.a) objArr2[2];
            if (builder == null) {
                throw aVar.a();
            }
            builder.duplicateKey = aVar;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objC = obj3;
            i = iIntValue;
        }
        return new A(objC, objArr, i);
    }

    public static Object c(Object[] objArr, int i, int i2, int i3) {
        ImmutableMap.Builder.a aVar = null;
        if (i == 1) {
            Object obj = objArr[i3];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i3 ^ 1];
            Objects.requireNonNull(obj2);
            AbstractC1163Zb.a(obj, obj2);
            return null;
        }
        int i4 = i2 - 1;
        int i5 = -1;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = (i7 * 2) + i3;
                int i9 = (i6 * 2) + i3;
                Object obj3 = objArr[i8];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i8 ^ 1];
                Objects.requireNonNull(obj4);
                AbstractC1163Zb.a(obj3, obj4);
                int iC = AbstractC3590or.c(obj3.hashCode());
                while (true) {
                    int i10 = iC & i4;
                    int i11 = bArr[i10] & UnsignedBytes.MAX_VALUE;
                    if (i11 == 255) {
                        bArr[i10] = (byte) i9;
                        if (i6 < i7) {
                            objArr[i9] = obj3;
                            objArr[i9 ^ 1] = obj4;
                        }
                        i6++;
                        break;
                    }
                    if (obj3.equals(objArr[i11])) {
                        int i12 = i11 ^ 1;
                        Object obj5 = objArr[i12];
                        Objects.requireNonNull(obj5);
                        aVar = new ImmutableMap.Builder.a(obj3, obj4, obj5);
                        objArr[i12] = obj4;
                        break;
                    }
                    iC = i10 + 1;
                }
            }
            return i6 == i ? bArr : new Object[]{bArr, Integer.valueOf(i6), aVar};
        }
        if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            int i13 = 0;
            for (int i14 = 0; i14 < i; i14++) {
                int i15 = (i14 * 2) + i3;
                int i16 = (i13 * 2) + i3;
                Object obj6 = objArr[i15];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i15 ^ 1];
                Objects.requireNonNull(obj7);
                AbstractC1163Zb.a(obj6, obj7);
                int iC2 = AbstractC3590or.c(obj6.hashCode());
                while (true) {
                    int i17 = iC2 & i4;
                    int i18 = sArr[i17] & 65535;
                    if (i18 == 65535) {
                        sArr[i17] = (short) i16;
                        if (i13 < i14) {
                            objArr[i16] = obj6;
                            objArr[i16 ^ 1] = obj7;
                        }
                        i13++;
                        break;
                    }
                    if (obj6.equals(objArr[i18])) {
                        int i19 = i18 ^ 1;
                        Object obj8 = objArr[i19];
                        Objects.requireNonNull(obj8);
                        aVar = new ImmutableMap.Builder.a(obj6, obj7, obj8);
                        objArr[i19] = obj7;
                        break;
                    }
                    iC2 = i17 + 1;
                }
            }
            return i13 == i ? sArr : new Object[]{sArr, Integer.valueOf(i13), aVar};
        }
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i20 = 0;
        int i21 = 0;
        while (i20 < i) {
            int i22 = (i20 * 2) + i3;
            int i23 = (i21 * 2) + i3;
            Object obj9 = objArr[i22];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i22 ^ 1];
            Objects.requireNonNull(obj10);
            AbstractC1163Zb.a(obj9, obj10);
            int iC3 = AbstractC3590or.c(obj9.hashCode());
            while (true) {
                int i24 = iC3 & i4;
                int i25 = iArr[i24];
                if (i25 == i5) {
                    iArr[i24] = i23;
                    if (i21 < i20) {
                        objArr[i23] = obj9;
                        objArr[i23 ^ 1] = obj10;
                    }
                    i21++;
                    break;
                }
                if (obj9.equals(objArr[i25])) {
                    int i26 = i25 ^ 1;
                    Object obj11 = objArr[i26];
                    Objects.requireNonNull(obj11);
                    aVar = new ImmutableMap.Builder.a(obj9, obj10, obj11);
                    objArr[i26] = obj10;
                    break;
                }
                iC3 = i24 + 1;
                i5 = -1;
            }
            i20++;
            i5 = -1;
        }
        return i21 == i ? iArr : new Object[]{iArr, Integer.valueOf(i21), aVar};
    }

    public static Object e(Object[] objArr, int i, int i2, int i3) {
        Object objC = c(objArr, i, i2, i3);
        if (objC instanceof Object[]) {
            throw ((ImmutableMap.Builder.a) ((Object[]) objC)[2]).a();
        }
        return objC;
    }

    public static Object f(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iC = AbstractC3590or.c(obj2.hashCode());
            while (true) {
                int i3 = iC & length;
                int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
                if (i4 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i4])) {
                    return objArr[i4 ^ 1];
                }
                iC = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iC2 = AbstractC3590or.c(obj2.hashCode());
            while (true) {
                int i5 = iC2 & length2;
                int i6 = sArr[i5] & 65535;
                if (i6 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                iC2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iC3 = AbstractC3590or.c(obj2.hashCode());
            while (true) {
                int i7 = iC3 & length3;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                iC3 = i7 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet createEntrySet() {
        return new a(this, this.b, 0, this.c);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet createKeySet() {
        return new b(this, new c(this.b, 0, this.c));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection createValues() {
        return new c(this.b, 1, this.c);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        Object objF = f(this.a, this.b, this.c, 0, obj);
        if (objF == null) {
            return null;
        }
        return objF;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.c;
    }
}
