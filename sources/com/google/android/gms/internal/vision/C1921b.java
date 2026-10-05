package com.google.android.gms.internal.vision;

import com.google.common.primitives.UnsignedBytes;
import defpackage.C3649pb0;
import defpackage.C3891sb0;
import defpackage.C4377yb0;
import defpackage.La0;
import defpackage.X90;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.vision.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1921b extends zzef {
    public static final zzef d = new C1921b(null, new Object[0], 0);
    public final transient Object a;
    public final transient Object[] b;
    public final transient int c;

    public C1921b(Object obj, Object[] objArr, int i) {
        this.a = obj;
        this.b = objArr;
        this.c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    public static C1921b a(int i, Object[] objArr) {
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            return (C1921b) d;
        }
        ?? r0 = 0;
        int i5 = 0;
        if (i == 1) {
            X90.a(objArr[0], objArr[1]);
            return new C1921b(null, objArr, 1);
        }
        zzde.zzb(i, objArr.length >> 1);
        int iZza = zzej.zza(i);
        if (i == 1) {
            X90.a(objArr[0], objArr[1]);
        } else {
            int i6 = iZza - 1;
            if (iZza <= 128) {
                bArr = new byte[iZza];
                Arrays.fill(bArr, (byte) -1);
                while (i5 < i) {
                    int i7 = i5 * 2;
                    Object obj = objArr[i7];
                    Object obj2 = objArr[i7 ^ 1];
                    X90.a(obj, obj2);
                    int iA = La0.a(obj.hashCode());
                    while (true) {
                        i4 = iA & i6;
                        int i8 = bArr[i4] & 255;
                        if (i8 == 255) {
                            break;
                        }
                        if (objArr[i8].equals(obj)) {
                            throw b(obj, obj2, objArr, i8);
                        }
                        iA = i4 + 1;
                    }
                    bArr[i4] = (byte) i7;
                    i5++;
                }
            } else if (iZza <= 32768) {
                bArr = new short[iZza];
                Arrays.fill(bArr, (short) -1);
                while (i5 < i) {
                    int i9 = i5 * 2;
                    Object obj3 = objArr[i9];
                    Object obj4 = objArr[i9 ^ 1];
                    X90.a(obj3, obj4);
                    int iA2 = La0.a(obj3.hashCode());
                    while (true) {
                        i3 = iA2 & i6;
                        int i10 = bArr[i3] & 65535;
                        if (i10 == 65535) {
                            break;
                        }
                        if (objArr[i10].equals(obj3)) {
                            throw b(obj3, obj4, objArr, i10);
                        }
                        iA2 = i3 + 1;
                    }
                    bArr[i3] = (short) i9;
                    i5++;
                }
            } else {
                bArr = new int[iZza];
                Arrays.fill((int[]) bArr, -1);
                while (i5 < i) {
                    int i11 = i5 * 2;
                    Object obj5 = objArr[i11];
                    Object obj6 = objArr[i11 ^ 1];
                    X90.a(obj5, obj6);
                    int iA3 = La0.a(obj5.hashCode());
                    while (true) {
                        i2 = iA3 & i6;
                        ?? r8 = bArr[i2];
                        if (r8 == -1) {
                            break;
                        }
                        if (objArr[r8].equals(obj5)) {
                            throw b(obj5, obj6, objArr, r8);
                        }
                        iA3 = i2 + 1;
                    }
                    bArr[i2] = i11;
                    i5++;
                }
            }
            r0 = bArr;
        }
        return new C1921b(r0, objArr, i);
    }

    public static IllegalArgumentException b(Object obj, Object obj2, Object[] objArr, int i) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(objArr[i]);
        String strValueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39 + strValueOf2.length() + strValueOf3.length() + strValueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.internal.vision.zzef, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = this.a;
        Object[] objArr = this.b;
        int i = this.c;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return objArr[1];
            }
            return null;
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int iA = La0.a(obj.hashCode());
            while (true) {
                int i2 = iA & length;
                int i3 = bArr[i2] & UnsignedBytes.MAX_VALUE;
                if (i3 == 255) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return objArr[i3 ^ 1];
                }
                iA = i2 + 1;
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int iA2 = La0.a(obj.hashCode());
            while (true) {
                int i4 = iA2 & length2;
                int i5 = sArr[i4] & 65535;
                if (i5 == 65535) {
                    return null;
                }
                if (objArr[i5].equals(obj)) {
                    return objArr[i5 ^ 1];
                }
                iA2 = i4 + 1;
            }
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int iA3 = La0.a(obj.hashCode());
            while (true) {
                int i6 = iA3 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    return null;
                }
                if (objArr[i7].equals(obj)) {
                    return objArr[i7 ^ 1];
                }
                iA3 = i6 + 1;
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.vision.zzef
    public final zzej zza() {
        return new C3649pb0(this, this.b, 0, this.c);
    }

    @Override // com.google.android.gms.internal.vision.zzef
    public final zzej zzb() {
        return new C3891sb0(this, new C4377yb0(this.b, 0, this.c));
    }

    @Override // com.google.android.gms.internal.vision.zzef
    public final zzeb zzc() {
        return new C4377yb0(this.b, 1, this.c);
    }
}
