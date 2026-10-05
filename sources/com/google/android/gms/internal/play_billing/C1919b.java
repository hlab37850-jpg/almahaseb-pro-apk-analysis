package com.google.android.gms.internal.play_billing;

import com.google.common.primitives.UnsignedBytes;
import defpackage.AbstractC2172f70;
import defpackage.AbstractC2418i70;
import defpackage.C2174f80;
import defpackage.C3125j80;
import defpackage.C3371m80;
import defpackage.C4434z70;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1919b extends zzbw {
    public static final zzbw d = new C1919b(null, new Object[0], 0);
    public final transient Object a;
    public final transient Object[] b;
    public final transient int c;

    public C1919b(Object obj, Object[] objArr, int i) {
        this.a = obj;
        this.b = objArr;
        this.c = i;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:82:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static C1919b a(int i, Object[] objArr, zzbv zzbvVar) {
        int iHighestOneBit;
        short[] sArr;
        char c;
        char c2;
        ?? r3;
        ?? r4;
        boolean z;
        ?? r5;
        Object[] objArr2;
        C4434z70 c4434z70;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (C1919b) d;
        }
        C4434z70 c4434z71 = null;
        ?? r6 = 0;
        C4434z70 c4434z72 = null;
        C4434z70 c4434z73 = null;
        int i3 = 1;
        if (i2 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            AbstractC2172f70.a(obj, obj2);
            return new C1919b(null, objArrCopyOf, 1);
        }
        zzbg.zzb(i2, objArrCopyOf.length >> 1, "index");
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            AbstractC2172f70.a(obj3, obj4);
            i2 = 1;
        } else {
            int i4 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit > 128) {
                if (iHighestOneBit <= 32768) {
                    sArr = new short[iHighestOneBit];
                    Arrays.fill(sArr, (short) -1);
                    int i5 = 0;
                    for (int i6 = 0; i6 < i2; i6++) {
                        int i7 = i5 + i5;
                        int i8 = i6 + i6;
                        Object obj5 = objArrCopyOf[i8];
                        Objects.requireNonNull(obj5);
                        Object obj6 = objArrCopyOf[i8 ^ 1];
                        Objects.requireNonNull(obj6);
                        AbstractC2172f70.a(obj5, obj6);
                        int iA = AbstractC2418i70.a(obj5.hashCode());
                        while (true) {
                            int i9 = iA & i4;
                            char c3 = (char) sArr[i9];
                            if (c3 == 65535) {
                                sArr[i9] = (short) i7;
                                if (i5 < i6) {
                                    objArrCopyOf[i7] = obj5;
                                    objArrCopyOf[i7 ^ 1] = obj6;
                                }
                                i5++;
                                break;
                            }
                            if (obj5.equals(objArrCopyOf[c3])) {
                                int i10 = c3 ^ 1;
                                Object obj7 = objArrCopyOf[i10 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                C4434z70 c4434z74 = new C4434z70(obj5, obj6, obj7);
                                objArrCopyOf[i10 == true ? 1 : 0] = obj6;
                                c4434z73 = c4434z74;
                                break;
                            }
                            iA = i9 + 1;
                        }
                    }
                    if (i5 != i2) {
                        c2 = 2;
                        r4 = new Object[]{sArr, Integer.valueOf(i5), c4434z73};
                    }
                    c = 1;
                    r3 = r4;
                    z = r3 instanceof Object[];
                    r5 = r3;
                    if (z) {
                        objArr2 = (Object[]) r3;
                        c4434z70 = (C4434z70) objArr2[c2];
                        if (zzbvVar == null) {
                            throw c4434z70.a();
                        }
                        zzbvVar.zzc = c4434z70;
                        Object obj8 = objArr2[0];
                        int iIntValue = ((Integer) objArr2[c]).intValue();
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
                        r5 = obj8;
                        i2 = iIntValue;
                    }
                    return new C1919b(r5, objArrCopyOf, i2);
                }
                int i11 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i12 = 0;
                int i13 = 0;
                while (i12 < i2) {
                    int i14 = i13 + i13;
                    int i15 = i12 + i12;
                    Object obj9 = objArrCopyOf[i15];
                    Objects.requireNonNull(obj9);
                    Object obj10 = objArrCopyOf[i15 ^ i11];
                    Objects.requireNonNull(obj10);
                    AbstractC2172f70.a(obj9, obj10);
                    int iA2 = AbstractC2418i70.a(obj9.hashCode());
                    while (true) {
                        int i16 = iA2 & i4;
                        ?? r15 = sArr[i16];
                        if (r15 == b) {
                            sArr[i16] = i14;
                            if (i13 < i12) {
                                objArrCopyOf[i14] = obj9;
                                objArrCopyOf[i14 ^ 1] = obj10;
                            }
                            i13++;
                            break;
                        }
                        if (obj9.equals(objArrCopyOf[r15])) {
                            int i17 = r15 ^ 1;
                            Object obj11 = objArrCopyOf[i17 == true ? 1 : 0];
                            Objects.requireNonNull(obj11);
                            C4434z70 c4434z75 = new C4434z70(obj9, obj10, obj11);
                            objArrCopyOf[i17 == true ? 1 : 0] = obj10;
                            c4434z71 = c4434z75;
                            break;
                        }
                        iA2 = i16 + 1;
                        b = -1;
                    }
                    i12++;
                    i11 = 1;
                    b = -1;
                }
                if (i13 != i2) {
                    c = 1;
                    c2 = 2;
                    r3 = new Object[]{sArr, Integer.valueOf(i13), c4434z71};
                }
                z = r3 instanceof Object[];
                r5 = r3;
                if (z) {
                    objArr2 = (Object[]) r3;
                    c4434z70 = (C4434z70) objArr2[c2];
                    if (zzbvVar == null) {
                        throw c4434z70.a();
                    }
                    zzbvVar.zzc = c4434z70;
                    Object obj12 = objArr2[0];
                    int iIntValue2 = ((Integer) objArr2[c]).intValue();
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue2 + iIntValue2);
                    r5 = obj12;
                    i2 = iIntValue2;
                }
                return new C1919b(r5, objArrCopyOf, i2);
            }
            byte[] bArr = new byte[iHighestOneBit];
            Arrays.fill(bArr, (byte) -1);
            int i18 = 0;
            int i19 = 0;
            while (i18 < i2) {
                int i20 = i19 + i19;
                int i21 = i18 + i18;
                Object obj13 = objArrCopyOf[i21];
                Objects.requireNonNull(obj13);
                Object obj14 = objArrCopyOf[i21 ^ i3];
                Objects.requireNonNull(obj14);
                AbstractC2172f70.a(obj13, obj14);
                int iA3 = AbstractC2418i70.a(obj13.hashCode());
                while (true) {
                    int i22 = iA3 & i4;
                    int i23 = bArr[i22] & UnsignedBytes.MAX_VALUE;
                    if (i23 == 255) {
                        bArr[i22] = (byte) i20;
                        if (i19 < i18) {
                            objArrCopyOf[i20] = obj13;
                            objArrCopyOf[i20 ^ 1] = obj14;
                        }
                        i19++;
                        break;
                    }
                    if (obj13.equals(objArrCopyOf[i23 == true ? 1 : 0])) {
                        int i24 = ~i23;
                        Object obj15 = objArrCopyOf[i24 == true ? 1 : 0];
                        Objects.requireNonNull(obj15);
                        C4434z70 c4434z76 = new C4434z70(obj13, obj14, obj15);
                        objArrCopyOf[i24 == true ? 1 : 0] = obj14;
                        c4434z72 = c4434z76;
                        break;
                    }
                    iA3 = i22 + 1;
                }
                i18++;
                i3 = 1;
            }
            if (i19 == i2) {
                r6 = bArr;
            } else {
                sArr = new Object[]{bArr, Integer.valueOf(i19), c4434z72};
            }
            r6 = sArr;
        }
        c2 = 2;
        r4 = r6;
        c = 1;
        r3 = r4;
        z = r3 instanceof Object[];
        r5 = r3;
        if (z) {
            objArr2 = (Object[]) r3;
            c4434z70 = (C4434z70) objArr2[c2];
            if (zzbvVar == null) {
                throw c4434z70.a();
            }
            zzbvVar.zzc = c4434z70;
            Object obj16 = objArr2[0];
            int iIntValue3 = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue3 + iIntValue3);
            r5 = obj16;
            i2 = iIntValue3;
        }
        return new C1919b(r5, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i = this.c;
            Object[] objArr = this.b;
            if (i == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.a;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iA = AbstractC2418i70.a(obj.hashCode());
                    while (true) {
                        int i2 = iA & length;
                        int i3 = bArr[i2] & UnsignedBytes.MAX_VALUE;
                        if (i3 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i3])) {
                            obj2 = objArr[i3 ^ 1];
                        } else {
                            iA = i2 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iA2 = AbstractC2418i70.a(obj.hashCode());
                    while (true) {
                        int i4 = iA2 & length2;
                        char c = (char) sArr[i4];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            obj2 = objArr[c ^ 1];
                        } else {
                            iA2 = i4 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iA3 = AbstractC2418i70.a(obj.hashCode());
                    while (true) {
                        int i5 = iA3 & length3;
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i6])) {
                            obj2 = objArr[i6 ^ 1];
                        } else {
                            iA3 = i5 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public final zzbq zza() {
        return new C3371m80(this.b, 1, this.c);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public final zzbx zzd() {
        return new C2174f80(this, this.b, 0, this.c);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public final zzbx zze() {
        return new C3125j80(this, new C3371m80(this.b, 0, this.c));
    }
}
