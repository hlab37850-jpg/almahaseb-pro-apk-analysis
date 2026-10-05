package com.google.android.gms.internal.vision;

import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC3331lg0;
import defpackage.AbstractC3574of;
import defpackage.Af0;
import defpackage.Ag0;
import defpackage.C1812bf0;
import defpackage.C2380hg0;
import defpackage.C3327le0;
import defpackage.C4142vf0;
import defpackage.Ig0;
import defpackage.InterfaceC3167jg0;
import defpackage.InterfaceC3249kg0;
import defpackage.Lg0;
import defpackage.Oe0;
import defpackage.Rf0;
import defpackage.Sf0;
import defpackage.Vf0;
import defpackage.Wg0;
import defpackage.Xe0;
import defpackage.Yf0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements InterfaceC3167jg0 {
    public static final int[] r = new int[0];
    public static final Unsafe s = Ig0.t();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final zzkk e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final Vf0 m;
    public final Af0 n;
    public final Ag0 o;
    public final Xe0 p;
    public final Rf0 q;

    public x(int[] iArr, Object[] objArr, int i, int i2, zzkk zzkkVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, Vf0 vf0, Af0 af0, Ag0 ag0, Xe0 xe0, Rf0 rf0) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = zzkkVar instanceof zzjb;
        this.h = z;
        this.f = xe0 != null && xe0.h(zzkkVar);
        this.i = false;
        this.j = iArr2;
        this.k = i3;
        this.l = i4;
        this.m = vf0;
        this.n = af0;
        this.o = ag0;
        this.p = xe0;
        this.e = zzkkVar;
        this.q = rf0;
    }

    public static boolean B(Object obj, int i, InterfaceC3167jg0 interfaceC3167jg0) {
        return interfaceC3167jg0.d(Ig0.F(obj, i & 1048575));
    }

    public static double C(Object obj, long j) {
        return ((Double) Ig0.F(obj, j)).doubleValue();
    }

    public static float J(Object obj, long j) {
        return ((Float) Ig0.F(obj, j)).floatValue();
    }

    public static int N(Object obj, long j) {
        return ((Integer) Ig0.F(obj, j)).intValue();
    }

    public static long P(Object obj, long j) {
        return ((Long) Ig0.F(obj, j)).longValue();
    }

    public static zzlx Q(Object obj) {
        zzjb zzjbVar = (zzjb) obj;
        zzlx zzlxVar = zzjbVar.zzb;
        if (zzlxVar != zzlx.zza()) {
            return zzlxVar;
        }
        zzlx zzlxVarZzb = zzlx.zzb();
        zzjbVar.zzb = zzlxVarZzb;
        return zzlxVarZzb;
    }

    public static boolean R(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    public static boolean S(Object obj, long j) {
        return ((Boolean) Ig0.F(obj, j)).booleanValue();
    }

    public static int m(Ag0 ag0, Object obj) {
        return ag0.s(ag0.k(obj));
    }

    /* JADX WARN: Code duplicated, block: B:163:0x033b  */
    /* JADX WARN: Code duplicated, block: B:180:0x038c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0399  */
    public static x n(Class cls, Sf0 sf0, Vf0 vf0, Af0 af0, Ag0 ag0, Xe0 xe0, Rf0 rf0) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int iCharAt5;
        int i2;
        int[] iArr;
        int i3;
        char cCharAt;
        int i4;
        char cCharAt2;
        int i5;
        char cCharAt3;
        int i6;
        char cCharAt4;
        int i7;
        char cCharAt5;
        int i8;
        char cCharAt6;
        int i9;
        char cCharAt7;
        int i10;
        char cCharAt8;
        int i11;
        int i12;
        int i13;
        int i14;
        C2380hg0 c2380hg0;
        int i15;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i16;
        int i17;
        Field fieldQ;
        char cCharAt9;
        int i18;
        int i19;
        Field fieldQ2;
        Field fieldQ3;
        int i20;
        char cCharAt10;
        int i21;
        char cCharAt11;
        int i22;
        char cCharAt12;
        int i23;
        char cCharAt13;
        if (!(sf0 instanceof C2380hg0)) {
            AbstractC3574of.a(sf0);
            throw null;
        }
        C2380hg0 c2380hg1 = (C2380hg0) sf0;
        int i24 = 0;
        boolean z = c2380hg1.zza() == zzkz.zzb;
        String strA = c2380hg1.a();
        int length = strA.length();
        if (strA.charAt(0) >= 55296) {
            int i25 = 1;
            while (true) {
                i = i25 + 1;
                if (strA.charAt(i25) < 55296) {
                    break;
                }
                i25 = i;
            }
        } else {
            i = 1;
        }
        int i26 = i + 1;
        int iCharAt6 = strA.charAt(i);
        if (iCharAt6 >= 55296) {
            int i27 = iCharAt6 & 8191;
            int i28 = 13;
            while (true) {
                i23 = i26 + 1;
                cCharAt13 = strA.charAt(i26);
                if (cCharAt13 < 55296) {
                    break;
                }
                i27 |= (cCharAt13 & 8191) << i28;
                i28 += 13;
                i26 = i23;
            }
            iCharAt6 = i27 | (cCharAt13 << i28);
            i26 = i23;
        }
        if (iCharAt6 == 0) {
            iArr = r;
            i2 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            iCharAt4 = 0;
            iCharAt5 = 0;
        } else {
            int i29 = i26 + 1;
            int iCharAt7 = strA.charAt(i26);
            if (iCharAt7 >= 55296) {
                int i30 = iCharAt7 & 8191;
                int i31 = 13;
                while (true) {
                    i10 = i29 + 1;
                    cCharAt8 = strA.charAt(i29);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i30 |= (cCharAt8 & 8191) << i31;
                    i31 += 13;
                    i29 = i10;
                }
                iCharAt7 = i30 | (cCharAt8 << i31);
                i29 = i10;
            }
            int i32 = i29 + 1;
            int iCharAt8 = strA.charAt(i29);
            if (iCharAt8 >= 55296) {
                int i33 = iCharAt8 & 8191;
                int i34 = 13;
                while (true) {
                    i9 = i32 + 1;
                    cCharAt7 = strA.charAt(i32);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt7 & 8191) << i34;
                    i34 += 13;
                    i32 = i9;
                }
                iCharAt8 = i33 | (cCharAt7 << i34);
                i32 = i9;
            }
            int i35 = i32 + 1;
            iCharAt = strA.charAt(i32);
            if (iCharAt >= 55296) {
                int i36 = iCharAt & 8191;
                int i37 = 13;
                while (true) {
                    i8 = i35 + 1;
                    cCharAt6 = strA.charAt(i35);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt6 & 8191) << i37;
                    i37 += 13;
                    i35 = i8;
                }
                iCharAt = i36 | (cCharAt6 << i37);
                i35 = i8;
            }
            int i38 = i35 + 1;
            iCharAt2 = strA.charAt(i35);
            if (iCharAt2 >= 55296) {
                int i39 = iCharAt2 & 8191;
                int i40 = 13;
                while (true) {
                    i7 = i38 + 1;
                    cCharAt5 = strA.charAt(i38);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt5 & 8191) << i40;
                    i40 += 13;
                    i38 = i7;
                }
                iCharAt2 = i39 | (cCharAt5 << i40);
                i38 = i7;
            }
            int i41 = i38 + 1;
            iCharAt3 = strA.charAt(i38);
            if (iCharAt3 >= 55296) {
                int i42 = iCharAt3 & 8191;
                int i43 = 13;
                while (true) {
                    i6 = i41 + 1;
                    cCharAt4 = strA.charAt(i41);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt4 & 8191) << i43;
                    i43 += 13;
                    i41 = i6;
                }
                iCharAt3 = i42 | (cCharAt4 << i43);
                i41 = i6;
            }
            int i44 = i41 + 1;
            iCharAt4 = strA.charAt(i41);
            if (iCharAt4 >= 55296) {
                int i45 = iCharAt4 & 8191;
                int i46 = 13;
                while (true) {
                    i5 = i44 + 1;
                    cCharAt3 = strA.charAt(i44);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt3 & 8191) << i46;
                    i46 += 13;
                    i44 = i5;
                }
                iCharAt4 = i45 | (cCharAt3 << i46);
                i44 = i5;
            }
            int i47 = i44 + 1;
            int iCharAt9 = strA.charAt(i44);
            if (iCharAt9 >= 55296) {
                int i48 = iCharAt9 & 8191;
                int i49 = 13;
                while (true) {
                    i4 = i47 + 1;
                    cCharAt2 = strA.charAt(i47);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt2 & 8191) << i49;
                    i49 += 13;
                    i47 = i4;
                }
                iCharAt9 = i48 | (cCharAt2 << i49);
                i47 = i4;
            }
            int i50 = i47 + 1;
            iCharAt5 = strA.charAt(i47);
            if (iCharAt5 >= 55296) {
                int i51 = iCharAt5 & 8191;
                int i52 = i50;
                int i53 = 13;
                while (true) {
                    i3 = i52 + 1;
                    cCharAt = strA.charAt(i52);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i51 |= (cCharAt & 8191) << i53;
                    i53 += 13;
                    i52 = i3;
                }
                iCharAt5 = i51 | (cCharAt << i53);
                i50 = i3;
            }
            i2 = (iCharAt7 << 1) + iCharAt8;
            iArr = new int[iCharAt5 + iCharAt4 + iCharAt9];
            i24 = iCharAt7;
            i26 = i50;
        }
        Unsafe unsafe = s;
        Object[] objArrB = c2380hg1.b();
        Class<?> cls2 = c2380hg1.zzc().getClass();
        int i54 = i26;
        int[] iArr2 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 << 1];
        int i55 = iCharAt5 + iCharAt4;
        int i56 = i2;
        int i57 = iCharAt5;
        int i58 = i54;
        int i59 = i55;
        int i60 = 0;
        int i61 = 0;
        while (i58 < length) {
            int i62 = i58 + 1;
            int iCharAt10 = strA.charAt(i58);
            if (iCharAt10 >= 55296) {
                int i63 = iCharAt10 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i22 = i64 + 1;
                    cCharAt12 = strA.charAt(i64);
                    i11 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt12 & 8191) << i65;
                    i65 += 13;
                    i64 = i22;
                    length = i11;
                }
                iCharAt10 = i63 | (cCharAt12 << i65);
                i12 = i22;
            } else {
                i11 = length;
                i12 = i62;
            }
            int i66 = i12 + 1;
            int iCharAt11 = strA.charAt(i12);
            if (iCharAt11 >= 55296) {
                int i67 = iCharAt11 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i21 = i68 + 1;
                    cCharAt11 = strA.charAt(i68);
                    i13 = iCharAt5;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i67 |= (cCharAt11 & 8191) << i69;
                    i69 += 13;
                    i68 = i21;
                    iCharAt5 = i13;
                }
                iCharAt11 = i67 | (cCharAt11 << i69);
                i14 = i21;
            } else {
                i13 = iCharAt5;
                i14 = i66;
            }
            int i70 = iCharAt11 & 255;
            int i71 = iCharAt2;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            int i72 = iCharAt;
            if (i70 >= 51) {
                int i73 = i14 + 1;
                int iCharAt12 = strA.charAt(i14);
                char c = 55296;
                if (iCharAt12 >= 55296) {
                    int i74 = iCharAt12 & 8191;
                    int i75 = 13;
                    while (true) {
                        i20 = i73 + 1;
                        cCharAt10 = strA.charAt(i73);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i74 |= (cCharAt10 & 8191) << i75;
                        i75 += 13;
                        i73 = i20;
                        c = 55296;
                    }
                    iCharAt12 = i74 | (cCharAt10 << i75);
                    i73 = i20;
                }
                int i76 = i70 - 51;
                int i77 = i73;
                if (i76 == 9 || i76 == 17) {
                    i19 = 1;
                    objArr[((i61 / 3) << 1) + 1] = objArrB[i56];
                    i56++;
                } else {
                    if (i76 == 12 && !z) {
                        objArr[((i61 / 3) << 1) + 1] = objArrB[i56];
                        i56++;
                    }
                    i19 = 1;
                }
                int i78 = iCharAt12 << i19;
                Object obj = objArrB[i78];
                if (obj instanceof Field) {
                    fieldQ2 = (Field) obj;
                } else {
                    fieldQ2 = q(cls2, (String) obj);
                    objArrB[i78] = fieldQ2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldQ2);
                int i79 = i78 + 1;
                Object obj2 = objArrB[i79];
                if (obj2 instanceof Field) {
                    fieldQ3 = (Field) obj2;
                } else {
                    fieldQ3 = q(cls2, (String) obj2);
                    objArrB[i79] = fieldQ3;
                }
                i15 = i56;
                iObjectFieldOffset = iObjectFieldOffset3;
                i16 = i77;
                c2380hg0 = c2380hg1;
                strA = strA;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldQ3);
                i17 = 0;
            } else {
                int i80 = i56 + 1;
                Field fieldQ4 = q(cls2, (String) objArrB[i56]);
                c2380hg0 = c2380hg1;
                if (i70 == 9 || i70 == 17) {
                    objArr[((i61 / 3) << 1) + 1] = fieldQ4.getType();
                } else {
                    if (i70 == 27 || i70 == 49) {
                        i18 = i56 + 2;
                        objArr[((i61 / 3) << 1) + 1] = objArrB[i80];
                    } else if (i70 != 12 && i70 != 30 && i70 != 44) {
                        if (i70 == 50) {
                            int i81 = i57 + 1;
                            iArr[i57] = i61;
                            int i82 = (i61 / 3) << 1;
                            int i83 = i56 + 2;
                            objArr[i82] = objArrB[i80];
                            if ((iCharAt11 & 2048) != 0) {
                                i80 = i56 + 3;
                                objArr[i82 + 1] = objArrB[i83];
                                i57 = i81;
                            } else {
                                i57 = i81;
                                i15 = i83;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldQ4);
                        if ((iCharAt11 & 4096) == 4096 || i70 > 17) {
                            iObjectFieldOffset2 = 1048575;
                            i16 = i14;
                            i17 = 0;
                        } else {
                            int i84 = i14 + 1;
                            int iCharAt13 = strA.charAt(i14);
                            if (iCharAt13 >= 55296) {
                                int i85 = iCharAt13 & 8191;
                                int i86 = 13;
                                while (true) {
                                    i16 = i84 + 1;
                                    cCharAt9 = strA.charAt(i84);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i85 |= (cCharAt9 & 8191) << i86;
                                    i86 += 13;
                                    i84 = i16;
                                }
                                iCharAt13 = i85 | (cCharAt9 << i86);
                            } else {
                                i16 = i84;
                            }
                            int i87 = (i24 << 1) + (iCharAt13 / 32);
                            Object obj3 = objArrB[i87];
                            if (obj3 instanceof Field) {
                                fieldQ = (Field) obj3;
                            } else {
                                fieldQ = q(cls2, (String) obj3);
                                objArrB[i87] = fieldQ;
                            }
                            i17 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldQ);
                        }
                        if (i70 >= 18 && i70 <= 49) {
                            iArr[i59] = iObjectFieldOffset;
                            i59++;
                        }
                    } else if (!z) {
                        i18 = i56 + 2;
                        objArr[((i61 / 3) << 1) + 1] = objArrB[i80];
                    }
                    i15 = i18;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldQ4);
                    if ((iCharAt11 & 4096) == 4096) {
                        iObjectFieldOffset2 = 1048575;
                        i16 = i14;
                        i17 = 0;
                    } else {
                        iObjectFieldOffset2 = 1048575;
                        i16 = i14;
                        i17 = 0;
                    }
                    if (i70 >= 18) {
                        iArr[i59] = iObjectFieldOffset;
                        i59++;
                    }
                }
                i15 = i80;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldQ4);
                if ((iCharAt11 & 4096) == 4096) {
                    iObjectFieldOffset2 = 1048575;
                    i16 = i14;
                    i17 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i16 = i14;
                    i17 = 0;
                }
                if (i70 >= 18) {
                    iArr[i59] = iObjectFieldOffset;
                    i59++;
                }
            }
            int i88 = i61 + 1;
            iArr2[i61] = iCharAt10;
            int i89 = i61 + 2;
            iArr2[i88] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | (i70 << 20) | iObjectFieldOffset;
            i61 += 3;
            iArr2[i89] = iObjectFieldOffset2 | (i17 << 20);
            strA = strA;
            i56 = i15;
            iCharAt2 = i71;
            i58 = i16;
            length = i11;
            iCharAt5 = i13;
            iCharAt = i72;
            c2380hg1 = c2380hg0;
        }
        return new x(iArr2, objArr, iCharAt, iCharAt2, c2380hg1.zzc(), z, false, iArr, iCharAt5, i55, vf0, af0, ag0, xe0, rf0);
    }

    public static Field q(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    public static List r(Object obj, long j) {
        return (List) Ig0.F(obj, j);
    }

    public static void t(int i, Object obj, Wg0 wg0) {
        if (obj instanceof String) {
            wg0.o(i, (String) obj);
        } else {
            wg0.C(i, (zzht) obj);
        }
    }

    public static void w(Ag0 ag0, Object obj, Wg0 wg0) {
        ag0.h(ag0.k(obj), wg0);
    }

    public final boolean A(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return y(obj, i);
        }
        return (i3 & i4) != 0;
    }

    public final int D(int i, int i2) {
        int length = (this.a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final Object E(int i) {
        return this.b[(i / 3) << 1];
    }

    public final void F(Object obj, int i) {
        int iO = O(i);
        long j = 1048575 & iO;
        if (j == 1048575) {
            return;
        }
        Ig0.h(obj, j, (1 << (iO >>> 20)) | Ig0.b(obj, j));
    }

    public final void G(Object obj, int i, int i2) {
        Ig0.h(obj, O(i2) & 1048575, i);
    }

    public final void H(Object obj, Object obj2, int i) {
        int iM = M(i);
        int i2 = this.a[i];
        long j = iM & 1048575;
        if (z(obj2, i2, i)) {
            Object objF = z(obj, i2, i) ? Ig0.F(obj, j) : null;
            Object objF2 = Ig0.F(obj2, j);
            if (objF != null && objF2 != null) {
                Ig0.j(obj, j, zzjf.zza(objF, objF2));
                G(obj, i2, i);
            } else if (objF2 != null) {
                Ig0.j(obj, j, objF2);
                G(obj, i2, i);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public final void I(Object obj, Wg0 wg0) {
        Iterator itO;
        Map.Entry entry;
        int i;
        if (this.f) {
            C1812bf0 c1812bf0D = this.p.d(obj);
            if (c1812bf0D.a.isEmpty()) {
                itO = null;
                entry = null;
            } else {
                itO = c1812bf0D.o();
                entry = (Map.Entry) itO.next();
            }
        } else {
            itO = null;
            entry = null;
        }
        int length = this.a.length;
        Unsafe unsafe = s;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iM = M(i4);
            int[] iArr = this.a;
            int i5 = iArr[i4];
            int i6 = (iM & 267386880) >>> 20;
            if (i6 <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & 1048575;
                if (i8 != i2) {
                    i3 = unsafe.getInt(obj, i8);
                    i2 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.p.a(entry) <= i5) {
                this.p.g(wg0, entry);
                entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
            }
            long j = iM & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        wg0.r(i5, Ig0.C(obj, j));
                        continue;
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        wg0.s(i5, Ig0.x(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        wg0.q(i5, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        wg0.l(i5, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        wg0.k(i5, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        wg0.J(i5, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        wg0.y(i5, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        wg0.j(i5, Ig0.w(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        t(i5, unsafe.getObject(obj, j), wg0);
                    } else {
                        continue;
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        wg0.G(i5, unsafe.getObject(obj, j), s(i4));
                    } else {
                        continue;
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        wg0.C(i5, (zzht) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        wg0.A(i5, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        wg0.D(i5, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        wg0.zza(i5, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        wg0.g(i5, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        wg0.u(i5, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        wg0.K(i5, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        wg0.F(i5, unsafe.getObject(obj, j), s(i4));
                    } else {
                        continue;
                    }
                    break;
                case 18:
                    AbstractC3331lg0.l(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 19:
                    AbstractC3331lg0.y(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 20:
                    AbstractC3331lg0.C(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 21:
                    AbstractC3331lg0.G(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 22:
                    AbstractC3331lg0.T(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 23:
                    AbstractC3331lg0.N(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 24:
                    AbstractC3331lg0.a0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 25:
                    AbstractC3331lg0.d0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 26:
                    AbstractC3331lg0.j(this.a[i4], (List) unsafe.getObject(obj, j), wg0);
                    break;
                case 27:
                    AbstractC3331lg0.k(this.a[i4], (List) unsafe.getObject(obj, j), wg0, s(i4));
                    break;
                case 28:
                    AbstractC3331lg0.w(this.a[i4], (List) unsafe.getObject(obj, j), wg0);
                    break;
                case 29:
                    AbstractC3331lg0.W(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 30:
                    AbstractC3331lg0.c0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 31:
                    AbstractC3331lg0.b0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 32:
                    AbstractC3331lg0.Q(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 33:
                    AbstractC3331lg0.Z(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 34:
                    AbstractC3331lg0.K(this.a[i4], (List) unsafe.getObject(obj, j), wg0, false);
                    break;
                case 35:
                    AbstractC3331lg0.l(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 36:
                    AbstractC3331lg0.y(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 37:
                    AbstractC3331lg0.C(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 38:
                    AbstractC3331lg0.G(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 39:
                    AbstractC3331lg0.T(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 40:
                    AbstractC3331lg0.N(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 41:
                    AbstractC3331lg0.a0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 42:
                    AbstractC3331lg0.d0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 43:
                    AbstractC3331lg0.W(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 44:
                    AbstractC3331lg0.c0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 45:
                    AbstractC3331lg0.b0(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 46:
                    AbstractC3331lg0.Q(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 47:
                    AbstractC3331lg0.Z(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 48:
                    AbstractC3331lg0.K(this.a[i4], (List) unsafe.getObject(obj, j), wg0, true);
                    break;
                case 49:
                    AbstractC3331lg0.x(this.a[i4], (List) unsafe.getObject(obj, j), wg0, s(i4));
                    break;
                case 50:
                    x(wg0, i5, unsafe.getObject(obj, j), i4);
                    break;
                case 51:
                    if (z(obj, i5, i4)) {
                        wg0.r(i5, C(obj, j));
                    }
                    break;
                case 52:
                    if (z(obj, i5, i4)) {
                        wg0.s(i5, J(obj, j));
                    }
                    break;
                case 53:
                    if (z(obj, i5, i4)) {
                        wg0.q(i5, P(obj, j));
                    }
                    break;
                case 54:
                    if (z(obj, i5, i4)) {
                        wg0.l(i5, P(obj, j));
                    }
                    break;
                case 55:
                    if (z(obj, i5, i4)) {
                        wg0.k(i5, N(obj, j));
                    }
                    break;
                case 56:
                    if (z(obj, i5, i4)) {
                        wg0.J(i5, P(obj, j));
                    }
                    break;
                case 57:
                    if (z(obj, i5, i4)) {
                        wg0.y(i5, N(obj, j));
                    }
                    break;
                case 58:
                    if (z(obj, i5, i4)) {
                        wg0.j(i5, S(obj, j));
                    }
                    break;
                case 59:
                    if (z(obj, i5, i4)) {
                        t(i5, unsafe.getObject(obj, j), wg0);
                    }
                    break;
                case 60:
                    if (z(obj, i5, i4)) {
                        wg0.G(i5, unsafe.getObject(obj, j), s(i4));
                    }
                    break;
                case 61:
                    if (z(obj, i5, i4)) {
                        wg0.C(i5, (zzht) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (z(obj, i5, i4)) {
                        wg0.A(i5, N(obj, j));
                    }
                    break;
                case 63:
                    if (z(obj, i5, i4)) {
                        wg0.D(i5, N(obj, j));
                    }
                    break;
                case 64:
                    if (z(obj, i5, i4)) {
                        wg0.zza(i5, N(obj, j));
                    }
                    break;
                case 65:
                    if (z(obj, i5, i4)) {
                        wg0.g(i5, P(obj, j));
                    }
                    break;
                case 66:
                    if (z(obj, i5, i4)) {
                        wg0.u(i5, N(obj, j));
                    }
                    break;
                case 67:
                    if (z(obj, i5, i4)) {
                        wg0.K(i5, P(obj, j));
                    }
                    break;
                case 68:
                    if (z(obj, i5, i4)) {
                        wg0.F(i5, unsafe.getObject(obj, j), s(i4));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.p.g(wg0, entry);
            entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
        }
        w(this.o, obj, wg0);
    }

    public final zzjg K(int i) {
        return (zzjg) this.b[((i / 3) << 1) + 1];
    }

    public final boolean L(Object obj, Object obj2, int i) {
        return y(obj, i) == y(obj2, i);
    }

    public final int M(int i) {
        return this.a[i + 1];
    }

    public final int O(int i) {
        return this.a[i + 2];
    }

    public final int T(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return D(i, 0);
    }

    @Override // defpackage.InterfaceC3167jg0
    public final void a(Object obj) {
        int i;
        int i2 = this.k;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            long jM = M(this.j[i2]) & 1048575;
            Object objF = Ig0.F(obj, jM);
            if (objF != null) {
                Ig0.j(obj, jM, this.q.c(objF));
            }
            i2++;
        }
        int length = this.j.length;
        while (i < length) {
            this.n.e(obj, this.j[i]);
            i++;
        }
        this.o.q(obj);
        if (this.f) {
            this.p.j(obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02e0 A[PHI: r0 r27 r28 r29
      0x02e0: PHI (r0v18 int) = (r0v13 int), (r0v16 int), (r0v20 int) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]
      0x02e0: PHI (r27v3 int) = (r27v1 int), (r27v1 int), (r27v4 int) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]
      0x02e0: PHI (r28v2 int) = (r28v0 int), (r28v0 int), (r28v3 int) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]
      0x02e0: PHI (r29v3 sun.misc.Unsafe) = (r29v1 sun.misc.Unsafe), (r29v1 sun.misc.Unsafe), (r29v4 sun.misc.Unsafe) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:106:0x02e7 A[PHI: r0 r27 r28 r29
      0x02e7: PHI (r0v17 int) = (r0v13 int), (r0v16 int), (r0v20 int) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]
      0x02e7: PHI (r27v2 int) = (r27v1 int), (r27v1 int), (r27v4 int) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]
      0x02e7: PHI (r28v1 int) = (r28v0 int), (r28v0 int), (r28v3 int) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]
      0x02e7: PHI (r29v2 sun.misc.Unsafe) = (r29v1 sun.misc.Unsafe), (r29v1 sun.misc.Unsafe), (r29v4 sun.misc.Unsafe) binds: [B:117:0x034b, B:113:0x032c, B:103:0x02de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0095. Please report as an issue. */
    @Override // defpackage.InterfaceC3167jg0
    public final void b(Object obj, byte[] bArr, int i, int i2, C3327le0 c3327le0) throws zzjk {
        int i3;
        int iD;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Unsafe unsafe;
        int i9;
        int i10;
        Unsafe unsafe2;
        int i11;
        int i12;
        Unsafe unsafe3;
        Unsafe unsafe4;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        c3327le0 = c3327le0;
        if (!this.h) {
            l(obj, bArr, i, i2, 0, c3327le0);
            return;
        }
        Unsafe unsafe5 = s;
        int i13 = -1;
        int i14 = 1048575;
        int i15 = i;
        int i16 = -1;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1048575;
        while (i15 < i2) {
            int i20 = i15 + 1;
            byte b = bArr[i15];
            if (b < 0) {
                iD = r.d(b, bArr, i20, c3327le0);
                i3 = c3327le0.a;
            } else {
                i3 = b;
                iD = i20;
            }
            int i21 = i3 >>> 3;
            int i22 = i3 & 7;
            int iH = i21 > i16 ? this.h(i21, i17 / 3) : this.T(i21);
            if (iH == i13) {
                i10 = iD;
                i4 = i21;
                unsafe = unsafe5;
                i6 = 0;
            } else {
                int[] iArr = this.a;
                int i23 = iArr[iH + 1];
                int i24 = (i23 & 267386880) >>> 20;
                Unsafe unsafe6 = unsafe5;
                long j = i23 & i14;
                if (i24 <= 17) {
                    int i25 = iArr[iH + 2];
                    int i26 = 1 << (i25 >>> 20);
                    int i27 = i25 & 1048575;
                    if (i27 != i19) {
                        if (i19 != 1048575) {
                            long j2 = i19;
                            unsafe4 = unsafe6;
                            unsafe4.putInt(obj, j2, i18);
                        } else {
                            unsafe4 = unsafe6;
                        }
                        if (i27 != 1048575) {
                            i18 = unsafe4.getInt(obj, i27);
                        }
                        unsafe2 = unsafe4;
                        i19 = i27;
                    } else {
                        unsafe2 = unsafe6;
                    }
                    switch (i24) {
                        case 0:
                            i4 = i21;
                            i11 = iD;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 1) {
                                Ig0.f(obj, j, r.m(bArr, i11));
                                i15 = i11 + 8;
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 1:
                            i4 = i21;
                            i11 = iD;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 5) {
                                Ig0.g(obj, j, r.o(bArr, i11));
                                i15 = i11 + 4;
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 2:
                        case 3:
                            i4 = i21;
                            i11 = iD;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 0) {
                                int iK = r.k(bArr, i11, c3327le0);
                                unsafe3.putLong(obj, j, c3327le0.b);
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                                i15 = iK;
                            }
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 4:
                        case 11:
                            i4 = i21;
                            i11 = iD;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 0) {
                                i15 = r.j(bArr, i11, c3327le0);
                                unsafe3.putInt(obj, j, c3327le0.a);
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 5:
                        case 14:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 1) {
                                unsafe3.putLong(obj, j, r.l(bArr, iD));
                                i15 = iD + 8;
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 6:
                        case 13:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 5) {
                                unsafe3.putInt(obj, j, r.h(bArr, iD));
                                i15 = iD + 4;
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 7:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 0) {
                                i15 = r.k(bArr, iD, c3327le0);
                                Ig0.k(obj, j, c3327le0.b != 0);
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 8:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 2) {
                                i15 = (i23 & PropertyOptions.DELETE_EXISTING) == 0 ? r.n(bArr, iD, c3327le0) : r.p(bArr, iD, c3327le0);
                                unsafe3.putObject(obj, j, c3327le0.c);
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 9:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 2) {
                                i15 = r.g(this.s(i12), bArr, iD, i2, c3327le0);
                                Object object = unsafe3.getObject(obj, j);
                                if (object == null) {
                                    unsafe3.putObject(obj, j, c3327le0.c);
                                } else {
                                    unsafe3.putObject(obj, j, zzjf.zza(object, c3327le0.c));
                                }
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 10:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 2) {
                                i15 = r.q(bArr, iD, c3327le0);
                                unsafe3.putObject(obj, j, c3327le0.c);
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 12:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 0) {
                                i15 = r.j(bArr, iD, c3327le0);
                                unsafe3.putInt(obj, j, c3327le0.a);
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 15:
                            i4 = i21;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            if (i22 == 0) {
                                i15 = r.j(bArr, iD, c3327le0);
                                unsafe3.putInt(obj, j, zzif.zze(c3327le0.a));
                                i18 |= i26;
                                unsafe5 = unsafe3;
                                i17 = i12;
                            }
                            i11 = iD;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                        case 16:
                            if (i22 != 0) {
                                i4 = i21;
                                i5 = i19;
                                unsafe3 = unsafe2;
                                i11 = iD;
                                i12 = iH;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i19 = i5;
                            } else {
                                int iK2 = r.k(bArr, iD, c3327le0);
                                i5 = i19;
                                i4 = i21;
                                unsafe2.putLong(obj, j, zzif.zza(c3327le0.b));
                                i18 |= i26;
                                unsafe5 = unsafe2;
                                i17 = iH;
                                i15 = iK2;
                            }
                            break;
                        default:
                            i4 = i21;
                            i11 = iD;
                            i12 = iH;
                            i5 = i19;
                            unsafe3 = unsafe2;
                            i10 = i11;
                            unsafe = unsafe3;
                            i6 = i12;
                            i19 = i5;
                            break;
                    }
                    i14 = 1048575;
                    i13 = -1;
                } else {
                    i4 = i21;
                    int i28 = iD;
                    i5 = i19;
                    if (i24 != 27) {
                        i6 = iH;
                        if (i24 <= 49) {
                            i8 = i18;
                            i9 = i5;
                            unsafe = unsafe6;
                            i15 = j(obj, bArr, i28, i2, i3, i4, i22, i6, i23, i24, j, c3327le0);
                            if (i15 == i28) {
                                i10 = i15;
                                i18 = i8;
                                i19 = i9;
                                i15 = r.b(i3, bArr, i10, i2, Q(obj), c3327le0);
                                i17 = i6;
                                i16 = i4;
                            } else {
                                i17 = i6;
                                i16 = i4;
                                i18 = i8;
                                i19 = i9;
                            }
                        } else {
                            i7 = i28;
                            i8 = i18;
                            unsafe = unsafe6;
                            i9 = i5;
                            if (i24 == 50) {
                                if (i22 == 2) {
                                    i15 = k(obj, bArr, i7, i2, i6, j, c3327le0);
                                    if (i15 == i7) {
                                        i10 = i15;
                                    } else {
                                        i17 = i6;
                                        i16 = i4;
                                        i18 = i8;
                                        i19 = i9;
                                    }
                                }
                                i18 = i8;
                                i19 = i9;
                                i15 = r.b(i3, bArr, i10, i2, Q(obj), c3327le0);
                                i17 = i6;
                                i16 = i4;
                            } else {
                                i15 = i(obj, bArr, i7, i2, i3, i4, i22, i23, i24, j, i6, c3327le0);
                                if (i15 == i7) {
                                    i10 = i15;
                                    i18 = i8;
                                    i19 = i9;
                                    i15 = r.b(i3, bArr, i10, i2, Q(obj), c3327le0);
                                    i17 = i6;
                                    i16 = i4;
                                } else {
                                    i17 = i6;
                                    i16 = i4;
                                    i18 = i8;
                                    i19 = i9;
                                }
                            }
                        }
                        unsafe5 = unsafe;
                        i14 = 1048575;
                        i13 = -1;
                    } else if (i22 == 2) {
                        zzjl zzjlVarZza = (zzjl) unsafe6.getObject(obj, j);
                        if (!zzjlVarZza.zza()) {
                            int size = zzjlVarZza.size();
                            zzjlVarZza = zzjlVarZza.zza(size == 0 ? 10 : size << 1);
                            unsafe6.putObject(obj, j, zzjlVarZza);
                        }
                        i15 = r.e(this.s(iH), i3, bArr, i28, i2, zzjlVarZza, c3327le0);
                        unsafe5 = unsafe6;
                        i18 = i18;
                        i17 = iH;
                    } else {
                        i6 = iH;
                        i7 = i28;
                        i8 = i18;
                        unsafe = unsafe6;
                        i9 = i5;
                    }
                    i10 = i7;
                    i18 = i8;
                    i19 = i9;
                    i15 = r.b(i3, bArr, i10, i2, Q(obj), c3327le0);
                    i17 = i6;
                    i16 = i4;
                    unsafe5 = unsafe;
                    i14 = 1048575;
                    i13 = -1;
                }
                i19 = i5;
                i16 = i4;
                i14 = 1048575;
                i13 = -1;
            }
            i15 = r.b(i3, bArr, i10, i2, Q(obj), c3327le0);
            i17 = i6;
            i16 = i4;
            unsafe5 = unsafe;
            i14 = 1048575;
            i13 = -1;
        }
        int i29 = i18;
        Unsafe unsafe7 = unsafe5;
        if (i19 != 1048575) {
            unsafe7.putInt(obj, i19, i29);
        }
        if (i15 != i2) {
            throw zzjk.zzg();
        }
    }

    @Override // defpackage.InterfaceC3167jg0
    public final void c(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            int iM = M(i);
            long j = 1048575 & iM;
            int i2 = this.a[i];
            switch ((iM & 267386880) >>> 20) {
                case 0:
                    if (y(obj2, i)) {
                        Ig0.f(obj, j, Ig0.C(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 1:
                    if (y(obj2, i)) {
                        Ig0.g(obj, j, Ig0.x(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 2:
                    if (y(obj2, i)) {
                        Ig0.i(obj, j, Ig0.o(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 3:
                    if (y(obj2, i)) {
                        Ig0.i(obj, j, Ig0.o(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 4:
                    if (y(obj2, i)) {
                        Ig0.h(obj, j, Ig0.b(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 5:
                    if (y(obj2, i)) {
                        Ig0.i(obj, j, Ig0.o(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 6:
                    if (y(obj2, i)) {
                        Ig0.h(obj, j, Ig0.b(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 7:
                    if (y(obj2, i)) {
                        Ig0.k(obj, j, Ig0.w(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 8:
                    if (y(obj2, i)) {
                        Ig0.j(obj, j, Ig0.F(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 9:
                    v(obj, obj2, i);
                    break;
                case 10:
                    if (y(obj2, i)) {
                        Ig0.j(obj, j, Ig0.F(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 11:
                    if (y(obj2, i)) {
                        Ig0.h(obj, j, Ig0.b(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 12:
                    if (y(obj2, i)) {
                        Ig0.h(obj, j, Ig0.b(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 13:
                    if (y(obj2, i)) {
                        Ig0.h(obj, j, Ig0.b(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 14:
                    if (y(obj2, i)) {
                        Ig0.i(obj, j, Ig0.o(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 15:
                    if (y(obj2, i)) {
                        Ig0.h(obj, j, Ig0.b(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 16:
                    if (y(obj2, i)) {
                        Ig0.i(obj, j, Ig0.o(obj2, j));
                        F(obj, i);
                    }
                    break;
                case 17:
                    v(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.n.c(obj, obj2, j);
                    break;
                case 50:
                    AbstractC3331lg0.o(this.q, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (z(obj2, i2, i)) {
                        Ig0.j(obj, j, Ig0.F(obj2, j));
                        G(obj, i2, i);
                    }
                    break;
                case 60:
                    H(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (z(obj2, i2, i)) {
                        Ig0.j(obj, j, Ig0.F(obj2, j));
                        G(obj, i2, i);
                    }
                    break;
                case 68:
                    H(obj, obj2, i);
                    break;
            }
        }
        AbstractC3331lg0.p(this.o, obj, obj2);
        if (this.f) {
            AbstractC3331lg0.n(this.p, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00be  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9 A[LOOP:1: B:44:0x00b8->B:49:0x00c9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6 A[SYNTHETIC] */
    @Override // defpackage.InterfaceC3167jg0
    public final boolean d(Object obj) {
        int i;
        int i2;
        List list;
        InterfaceC3167jg0 interfaceC3167jg0S;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.k) {
            int i7 = this.j[i6];
            int i8 = this.a[i7];
            int iM = M(i7);
            int i9 = this.a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = s.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iM) != 0 && !A(obj, i7, i, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & iM) >>> 20;
            if (i12 == 9 || i12 == 17) {
                if (A(obj, i7, i, i2, i11) && !B(obj, iM, s(i7))) {
                    return false;
                }
            } else if (i12 == 27) {
                list = (List) Ig0.F(obj, iM & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    interfaceC3167jg0S = s(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!interfaceC3167jg0S.d(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (i12 == 60 || i12 == 68) {
                if (z(obj, i8, i7) && !B(obj, iM, s(i7))) {
                    return false;
                }
            } else if (i12 == 49) {
                list = (List) Ig0.F(obj, iM & 1048575);
                if (list.isEmpty()) {
                    interfaceC3167jg0S = s(i7);
                    while (i3 < list.size()) {
                        if (!interfaceC3167jg0S.d(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i12 == 50 && !this.q.a(Ig0.F(obj, iM & 1048575)).isEmpty()) {
                this.q.zzb(E(i7));
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return !this.f || this.p.d(obj).r();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    @Override // defpackage.InterfaceC3167jg0
    public final boolean e(Object obj, Object obj2) {
        int length = this.a.length;
        int i = 0;
        while (true) {
            boolean zQ = true;
            if (i >= length) {
                if (!this.o.k(obj).equals(this.o.k(obj2))) {
                    return false;
                }
                if (this.f) {
                    return this.p.d(obj).equals(this.p.d(obj2));
                }
                return true;
            }
            int iM = M(i);
            long j = iM & 1048575;
            switch ((iM & 267386880) >>> 20) {
                case 0:
                    if (!L(obj, obj2, i) || Double.doubleToLongBits(Ig0.C(obj, j)) != Double.doubleToLongBits(Ig0.C(obj2, j))) {
                        zQ = false;
                    }
                    break;
                case 1:
                    if (!L(obj, obj2, i) || Float.floatToIntBits(Ig0.x(obj, j)) != Float.floatToIntBits(Ig0.x(obj2, j))) {
                        zQ = false;
                    }
                    break;
                case 2:
                    if (!L(obj, obj2, i) || Ig0.o(obj, j) != Ig0.o(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 3:
                    if (!L(obj, obj2, i) || Ig0.o(obj, j) != Ig0.o(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 4:
                    if (!L(obj, obj2, i) || Ig0.b(obj, j) != Ig0.b(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 5:
                    if (!L(obj, obj2, i) || Ig0.o(obj, j) != Ig0.o(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 6:
                    if (!L(obj, obj2, i) || Ig0.b(obj, j) != Ig0.b(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 7:
                    if (!L(obj, obj2, i) || Ig0.w(obj, j) != Ig0.w(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 8:
                    if (!L(obj, obj2, i) || !AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j))) {
                        zQ = false;
                    }
                    break;
                case 9:
                    if (!L(obj, obj2, i) || !AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j))) {
                        zQ = false;
                    }
                    break;
                case 10:
                    if (!L(obj, obj2, i) || !AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j))) {
                        zQ = false;
                    }
                    break;
                case 11:
                    if (!L(obj, obj2, i) || Ig0.b(obj, j) != Ig0.b(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 12:
                    if (!L(obj, obj2, i) || Ig0.b(obj, j) != Ig0.b(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 13:
                    if (!L(obj, obj2, i) || Ig0.b(obj, j) != Ig0.b(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 14:
                    if (!L(obj, obj2, i) || Ig0.o(obj, j) != Ig0.o(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 15:
                    if (!L(obj, obj2, i) || Ig0.b(obj, j) != Ig0.b(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 16:
                    if (!L(obj, obj2, i) || Ig0.o(obj, j) != Ig0.o(obj2, j)) {
                        zQ = false;
                    }
                    break;
                case 17:
                    if (!L(obj, obj2, i) || !AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j))) {
                        zQ = false;
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zQ = AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j));
                    break;
                case 50:
                    zQ = AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jO = O(i) & 1048575;
                    if (Ig0.b(obj, jO) != Ig0.b(obj2, jO) || !AbstractC3331lg0.q(Ig0.F(obj, j), Ig0.F(obj2, j))) {
                        zQ = false;
                    }
                    break;
            }
            if (!zQ) {
                return false;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:168:0x05ce A[LOOP:5: B:166:0x05ca->B:168:0x05ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:170:0x05db  */
    @Override // defpackage.InterfaceC3167jg0
    public final void f(Object obj, InterfaceC3249kg0 interfaceC3249kg0, zzio zzioVar) {
        int i;
        zzioVar.getClass();
        Ag0 ag0 = this.o;
        Xe0 xe0 = this.p;
        C1812bf0 c1812bf0I = null;
        Object objP = null;
        while (true) {
            try {
                int iZza = interfaceC3249kg0.zza();
                int iT = T(iZza);
                if (iT >= 0) {
                    int iM = M(iT);
                    switch ((267386880 & iM) >>> 20) {
                        case 0:
                            Ig0.f(obj, iM & 1048575, interfaceC3249kg0.zzd());
                            F(obj, iT);
                            continue;
                        case 1:
                            Ig0.g(obj, iM & 1048575, interfaceC3249kg0.zze());
                            F(obj, iT);
                            continue;
                        case 2:
                            Ig0.i(obj, iM & 1048575, interfaceC3249kg0.zzg());
                            F(obj, iT);
                            continue;
                        case 3:
                            Ig0.i(obj, iM & 1048575, interfaceC3249kg0.zzf());
                            F(obj, iT);
                            continue;
                        case 4:
                            Ig0.h(obj, iM & 1048575, interfaceC3249kg0.zzh());
                            F(obj, iT);
                            continue;
                        case 5:
                            Ig0.i(obj, iM & 1048575, interfaceC3249kg0.zzi());
                            F(obj, iT);
                            continue;
                        case 6:
                            Ig0.h(obj, iM & 1048575, interfaceC3249kg0.zzj());
                            F(obj, iT);
                            continue;
                        case 7:
                            Ig0.k(obj, iM & 1048575, interfaceC3249kg0.zzk());
                            F(obj, iT);
                            continue;
                        case 8:
                            u(obj, iM, interfaceC3249kg0);
                            F(obj, iT);
                            continue;
                        case 9:
                            if (y(obj, iT)) {
                                long j = iM & 1048575;
                                Ig0.j(obj, j, zzjf.zza(Ig0.F(obj, j), interfaceC3249kg0.j(s(iT), zzioVar)));
                            } else {
                                Ig0.j(obj, iM & 1048575, interfaceC3249kg0.j(s(iT), zzioVar));
                                F(obj, iT);
                                continue;
                            }
                            break;
                        case 10:
                            Ig0.j(obj, iM & 1048575, interfaceC3249kg0.f());
                            F(obj, iT);
                            continue;
                        case 11:
                            Ig0.h(obj, iM & 1048575, interfaceC3249kg0.i());
                            F(obj, iT);
                            continue;
                        case 12:
                            int iZzp = interfaceC3249kg0.zzp();
                            zzjg zzjgVarK = K(iT);
                            if (zzjgVarK == null || zzjgVarK.zza(iZzp)) {
                                Ig0.h(obj, iM & 1048575, iZzp);
                                F(obj, iT);
                                continue;
                            } else {
                                objP = AbstractC3331lg0.f(iZza, iZzp, objP, ag0);
                            }
                            break;
                        case 13:
                            Ig0.h(obj, iM & 1048575, interfaceC3249kg0.zzq());
                            F(obj, iT);
                            continue;
                        case 14:
                            Ig0.i(obj, iM & 1048575, interfaceC3249kg0.zzr());
                            F(obj, iT);
                            continue;
                        case 15:
                            Ig0.h(obj, iM & 1048575, interfaceC3249kg0.zzs());
                            F(obj, iT);
                            continue;
                        case 16:
                            Ig0.i(obj, iM & 1048575, interfaceC3249kg0.zzt());
                            F(obj, iT);
                            continue;
                        case 17:
                            if (y(obj, iT)) {
                                long j2 = iM & 1048575;
                                Ig0.j(obj, j2, zzjf.zza(Ig0.F(obj, j2), interfaceC3249kg0.m(s(iT), zzioVar)));
                            } else {
                                Ig0.j(obj, iM & 1048575, interfaceC3249kg0.m(s(iT), zzioVar));
                                F(obj, iT);
                                continue;
                            }
                            break;
                        case 18:
                            interfaceC3249kg0.h(this.n.a(obj, iM & 1048575));
                            continue;
                        case 19:
                            interfaceC3249kg0.zzb(this.n.a(obj, iM & 1048575));
                            continue;
                        case 20:
                            interfaceC3249kg0.y(this.n.a(obj, iM & 1048575));
                            continue;
                        case 21:
                            interfaceC3249kg0.q(this.n.a(obj, iM & 1048575));
                            continue;
                        case 22:
                            interfaceC3249kg0.v(this.n.a(obj, iM & 1048575));
                            continue;
                        case 23:
                            interfaceC3249kg0.e(this.n.a(obj, iM & 1048575));
                            continue;
                        case 24:
                            interfaceC3249kg0.b(this.n.a(obj, iM & 1048575));
                            continue;
                        case 25:
                            interfaceC3249kg0.a(this.n.a(obj, iM & 1048575));
                            continue;
                        case 26:
                            if (R(iM)) {
                                interfaceC3249kg0.g(this.n.a(obj, iM & 1048575));
                            } else {
                                interfaceC3249kg0.k(this.n.a(obj, iM & 1048575));
                                continue;
                            }
                            break;
                        case 27:
                            interfaceC3249kg0.s(this.n.a(obj, iM & 1048575), s(iT), zzioVar);
                            continue;
                        case 28:
                            interfaceC3249kg0.r(this.n.a(obj, iM & 1048575));
                            continue;
                        case 29:
                            interfaceC3249kg0.n(this.n.a(obj, iM & 1048575));
                            continue;
                        case 30:
                            List listA = this.n.a(obj, iM & 1048575);
                            interfaceC3249kg0.w(listA);
                            objP = AbstractC3331lg0.g(iZza, listA, K(iT), objP, ag0);
                            continue;
                        case 31:
                            interfaceC3249kg0.t(this.n.a(obj, iM & 1048575));
                            continue;
                        case 32:
                            interfaceC3249kg0.d(this.n.a(obj, iM & 1048575));
                            continue;
                        case 33:
                            interfaceC3249kg0.c(this.n.a(obj, iM & 1048575));
                            continue;
                        case 34:
                            interfaceC3249kg0.l(this.n.a(obj, iM & 1048575));
                            continue;
                        case 35:
                            interfaceC3249kg0.h(this.n.a(obj, iM & 1048575));
                            continue;
                        case 36:
                            interfaceC3249kg0.zzb(this.n.a(obj, iM & 1048575));
                            continue;
                        case 37:
                            interfaceC3249kg0.y(this.n.a(obj, iM & 1048575));
                            continue;
                        case 38:
                            interfaceC3249kg0.q(this.n.a(obj, iM & 1048575));
                            continue;
                        case 39:
                            interfaceC3249kg0.v(this.n.a(obj, iM & 1048575));
                            continue;
                        case 40:
                            interfaceC3249kg0.e(this.n.a(obj, iM & 1048575));
                            continue;
                        case 41:
                            interfaceC3249kg0.b(this.n.a(obj, iM & 1048575));
                            continue;
                        case 42:
                            interfaceC3249kg0.a(this.n.a(obj, iM & 1048575));
                            continue;
                        case 43:
                            interfaceC3249kg0.n(this.n.a(obj, iM & 1048575));
                            continue;
                        case 44:
                            List listA2 = this.n.a(obj, iM & 1048575);
                            interfaceC3249kg0.w(listA2);
                            objP = AbstractC3331lg0.g(iZza, listA2, K(iT), objP, ag0);
                            continue;
                        case 45:
                            interfaceC3249kg0.t(this.n.a(obj, iM & 1048575));
                            continue;
                        case 46:
                            interfaceC3249kg0.d(this.n.a(obj, iM & 1048575));
                            continue;
                        case 47:
                            interfaceC3249kg0.c(this.n.a(obj, iM & 1048575));
                            continue;
                        case 48:
                            interfaceC3249kg0.l(this.n.a(obj, iM & 1048575));
                            continue;
                        case 49:
                            interfaceC3249kg0.p(this.n.a(obj, iM & 1048575), s(iT), zzioVar);
                            continue;
                        case 50:
                            Object objE = E(iT);
                            long jM = M(iT) & 1048575;
                            Object objF = Ig0.F(obj, jM);
                            if (objF == null) {
                                objF = this.q.b(objE);
                                Ig0.j(obj, jM, objF);
                            } else if (this.q.d(objF)) {
                                Object objB = this.q.b(objE);
                                this.q.e(objB, objF);
                                Ig0.j(obj, jM, objB);
                                objF = objB;
                            }
                            Map mapZza = this.q.zza(objF);
                            this.q.zzb(objE);
                            interfaceC3249kg0.z(mapZza, null, zzioVar);
                            continue;
                        case 51:
                            Ig0.j(obj, iM & 1048575, Double.valueOf(interfaceC3249kg0.zzd()));
                            G(obj, iZza, iT);
                            continue;
                        case 52:
                            Ig0.j(obj, iM & 1048575, Float.valueOf(interfaceC3249kg0.zze()));
                            G(obj, iZza, iT);
                            continue;
                        case 53:
                            Ig0.j(obj, iM & 1048575, Long.valueOf(interfaceC3249kg0.zzg()));
                            G(obj, iZza, iT);
                            continue;
                        case 54:
                            Ig0.j(obj, iM & 1048575, Long.valueOf(interfaceC3249kg0.zzf()));
                            G(obj, iZza, iT);
                            continue;
                        case 55:
                            Ig0.j(obj, iM & 1048575, Integer.valueOf(interfaceC3249kg0.zzh()));
                            G(obj, iZza, iT);
                            continue;
                        case 56:
                            Ig0.j(obj, iM & 1048575, Long.valueOf(interfaceC3249kg0.zzi()));
                            G(obj, iZza, iT);
                            continue;
                        case 57:
                            Ig0.j(obj, iM & 1048575, Integer.valueOf(interfaceC3249kg0.zzj()));
                            G(obj, iZza, iT);
                            continue;
                        case 58:
                            Ig0.j(obj, iM & 1048575, Boolean.valueOf(interfaceC3249kg0.zzk()));
                            G(obj, iZza, iT);
                            continue;
                        case 59:
                            u(obj, iM, interfaceC3249kg0);
                            G(obj, iZza, iT);
                            continue;
                        case 60:
                            if (z(obj, iZza, iT)) {
                                long j3 = iM & 1048575;
                                Ig0.j(obj, j3, zzjf.zza(Ig0.F(obj, j3), interfaceC3249kg0.j(s(iT), zzioVar)));
                            } else {
                                Ig0.j(obj, iM & 1048575, interfaceC3249kg0.j(s(iT), zzioVar));
                                F(obj, iT);
                            }
                            G(obj, iZza, iT);
                            continue;
                        case 61:
                            Ig0.j(obj, iM & 1048575, interfaceC3249kg0.f());
                            G(obj, iZza, iT);
                            continue;
                        case 62:
                            Ig0.j(obj, iM & 1048575, Integer.valueOf(interfaceC3249kg0.i()));
                            G(obj, iZza, iT);
                            continue;
                        case 63:
                            int iZzp2 = interfaceC3249kg0.zzp();
                            zzjg zzjgVarK2 = K(iT);
                            if (zzjgVarK2 == null || zzjgVarK2.zza(iZzp2)) {
                                Ig0.j(obj, iM & 1048575, Integer.valueOf(iZzp2));
                                G(obj, iZza, iT);
                                continue;
                            } else {
                                objP = AbstractC3331lg0.f(iZza, iZzp2, objP, ag0);
                            }
                            break;
                        case 64:
                            Ig0.j(obj, iM & 1048575, Integer.valueOf(interfaceC3249kg0.zzq()));
                            G(obj, iZza, iT);
                            continue;
                        case 65:
                            Ig0.j(obj, iM & 1048575, Long.valueOf(interfaceC3249kg0.zzr()));
                            G(obj, iZza, iT);
                            continue;
                        case 66:
                            Ig0.j(obj, iM & 1048575, Integer.valueOf(interfaceC3249kg0.zzs()));
                            G(obj, iZza, iT);
                            continue;
                        case 67:
                            Ig0.j(obj, iM & 1048575, Long.valueOf(interfaceC3249kg0.zzt()));
                            G(obj, iZza, iT);
                            continue;
                        case 68:
                            Ig0.j(obj, iM & 1048575, interfaceC3249kg0.m(s(iT), zzioVar));
                            G(obj, iZza, iT);
                            continue;
                        default:
                            if (objP == null) {
                                try {
                                    objP = ag0.a();
                                } catch (zzjn unused) {
                                    ag0.j(interfaceC3249kg0);
                                    if (objP == null) {
                                        objP = ag0.o(obj);
                                    }
                                    if (!ag0.i(objP, interfaceC3249kg0)) {
                                        for (int i2 = this.k; i2 < this.l; i2++) {
                                            objP = p(obj, this.j[i2], objP, ag0);
                                        }
                                        if (objP != null) {
                                            ag0.m(obj, objP);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            if (!ag0.i(objP, interfaceC3249kg0)) {
                                for (int i3 = this.k; i3 < this.l; i3++) {
                                    objP = p(obj, this.j[i3], objP, ag0);
                                }
                                if (objP != null) {
                                    ag0.m(obj, objP);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                    for (i = this.k; i < this.l; i++) {
                        objP = p(obj, this.j[i], objP, ag0);
                    }
                    if (objP != null) {
                        ag0.m(obj, objP);
                    }
                    throw th;
                }
                if (iZza == Integer.MAX_VALUE) {
                    for (int i4 = this.k; i4 < this.l; i4++) {
                        objP = p(obj, this.j[i4], objP, ag0);
                    }
                    if (objP != null) {
                        ag0.m(obj, objP);
                        return;
                    }
                    return;
                }
                Object objB2 = !this.f ? null : xe0.b(zzioVar, this.e, iZza);
                if (objB2 != null) {
                    if (c1812bf0I == null) {
                        c1812bf0I = xe0.i(obj);
                    }
                    C1812bf0 c1812bf0 = c1812bf0I;
                    objP = xe0.c(interfaceC3249kg0, objB2, zzioVar, c1812bf0, objP, ag0);
                    c1812bf0I = c1812bf0;
                } else {
                    ag0.j(interfaceC3249kg0);
                    if (objP == null) {
                        objP = ag0.o(obj);
                    }
                    if (!ag0.i(objP, interfaceC3249kg0)) {
                        for (int i5 = this.k; i5 < this.l; i5++) {
                            objP = p(obj, this.j[i5], objP, ag0);
                        }
                        if (objP != null) {
                            ag0.m(obj, objP);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                while (i < this.l) {
                    objP = p(obj, this.j[i], objP, ag0);
                }
                if (objP != null) {
                    ag0.m(obj, objP);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:178:0x054a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0032  */
    @Override // defpackage.InterfaceC3167jg0
    public final void g(Object obj, Wg0 wg0) {
        Iterator itO;
        Map.Entry entry;
        Iterator itQ;
        Map.Entry entry2;
        if (wg0.zza() == zzmq.zzb) {
            w(this.o, obj, wg0);
            if (this.f) {
                C1812bf0 c1812bf0D = this.p.d(obj);
                if (c1812bf0D.a.isEmpty()) {
                    itQ = null;
                    entry2 = null;
                } else {
                    itQ = c1812bf0D.q();
                    entry2 = (Map.Entry) itQ.next();
                }
            } else {
                itQ = null;
                entry2 = null;
            }
            for (int length = this.a.length - 3; length >= 0; length -= 3) {
                int iM = M(length);
                int i = this.a[length];
                while (entry2 != null && this.p.a(entry2) > i) {
                    this.p.g(wg0, entry2);
                    entry2 = itQ.hasNext() ? (Map.Entry) itQ.next() : null;
                }
                switch ((iM & 267386880) >>> 20) {
                    case 0:
                        if (y(obj, length)) {
                            wg0.r(i, Ig0.C(obj, iM & 1048575));
                        }
                        break;
                    case 1:
                        if (y(obj, length)) {
                            wg0.s(i, Ig0.x(obj, iM & 1048575));
                        }
                        break;
                    case 2:
                        if (y(obj, length)) {
                            wg0.q(i, Ig0.o(obj, iM & 1048575));
                        }
                        break;
                    case 3:
                        if (y(obj, length)) {
                            wg0.l(i, Ig0.o(obj, iM & 1048575));
                        }
                        break;
                    case 4:
                        if (y(obj, length)) {
                            wg0.k(i, Ig0.b(obj, iM & 1048575));
                        }
                        break;
                    case 5:
                        if (y(obj, length)) {
                            wg0.J(i, Ig0.o(obj, iM & 1048575));
                        }
                        break;
                    case 6:
                        if (y(obj, length)) {
                            wg0.y(i, Ig0.b(obj, iM & 1048575));
                        }
                        break;
                    case 7:
                        if (y(obj, length)) {
                            wg0.j(i, Ig0.w(obj, iM & 1048575));
                        }
                        break;
                    case 8:
                        if (y(obj, length)) {
                            t(i, Ig0.F(obj, iM & 1048575), wg0);
                        }
                        break;
                    case 9:
                        if (y(obj, length)) {
                            wg0.G(i, Ig0.F(obj, iM & 1048575), s(length));
                        }
                        break;
                    case 10:
                        if (y(obj, length)) {
                            wg0.C(i, (zzht) Ig0.F(obj, iM & 1048575));
                        }
                        break;
                    case 11:
                        if (y(obj, length)) {
                            wg0.A(i, Ig0.b(obj, iM & 1048575));
                        }
                        break;
                    case 12:
                        if (y(obj, length)) {
                            wg0.D(i, Ig0.b(obj, iM & 1048575));
                        }
                        break;
                    case 13:
                        if (y(obj, length)) {
                            wg0.zza(i, Ig0.b(obj, iM & 1048575));
                        }
                        break;
                    case 14:
                        if (y(obj, length)) {
                            wg0.g(i, Ig0.o(obj, iM & 1048575));
                        }
                        break;
                    case 15:
                        if (y(obj, length)) {
                            wg0.u(i, Ig0.b(obj, iM & 1048575));
                        }
                        break;
                    case 16:
                        if (y(obj, length)) {
                            wg0.K(i, Ig0.o(obj, iM & 1048575));
                        }
                        break;
                    case 17:
                        if (y(obj, length)) {
                            wg0.F(i, Ig0.F(obj, iM & 1048575), s(length));
                        }
                        break;
                    case 18:
                        AbstractC3331lg0.l(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 19:
                        AbstractC3331lg0.y(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 20:
                        AbstractC3331lg0.C(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 21:
                        AbstractC3331lg0.G(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 22:
                        AbstractC3331lg0.T(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 23:
                        AbstractC3331lg0.N(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 24:
                        AbstractC3331lg0.a0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 25:
                        AbstractC3331lg0.d0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 26:
                        AbstractC3331lg0.j(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0);
                        break;
                    case 27:
                        AbstractC3331lg0.k(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, s(length));
                        break;
                    case 28:
                        AbstractC3331lg0.w(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0);
                        break;
                    case 29:
                        AbstractC3331lg0.W(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 30:
                        AbstractC3331lg0.c0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 31:
                        AbstractC3331lg0.b0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 32:
                        AbstractC3331lg0.Q(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 33:
                        AbstractC3331lg0.Z(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 34:
                        AbstractC3331lg0.K(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, false);
                        break;
                    case 35:
                        AbstractC3331lg0.l(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 36:
                        AbstractC3331lg0.y(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 37:
                        AbstractC3331lg0.C(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 38:
                        AbstractC3331lg0.G(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 39:
                        AbstractC3331lg0.T(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 40:
                        AbstractC3331lg0.N(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 41:
                        AbstractC3331lg0.a0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 42:
                        AbstractC3331lg0.d0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 43:
                        AbstractC3331lg0.W(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 44:
                        AbstractC3331lg0.c0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 45:
                        AbstractC3331lg0.b0(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 46:
                        AbstractC3331lg0.Q(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 47:
                        AbstractC3331lg0.Z(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 48:
                        AbstractC3331lg0.K(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, true);
                        break;
                    case 49:
                        AbstractC3331lg0.x(this.a[length], (List) Ig0.F(obj, iM & 1048575), wg0, s(length));
                        break;
                    case 50:
                        x(wg0, i, Ig0.F(obj, iM & 1048575), length);
                        break;
                    case 51:
                        if (z(obj, i, length)) {
                            wg0.r(i, C(obj, iM & 1048575));
                        }
                        break;
                    case 52:
                        if (z(obj, i, length)) {
                            wg0.s(i, J(obj, iM & 1048575));
                        }
                        break;
                    case 53:
                        if (z(obj, i, length)) {
                            wg0.q(i, P(obj, iM & 1048575));
                        }
                        break;
                    case 54:
                        if (z(obj, i, length)) {
                            wg0.l(i, P(obj, iM & 1048575));
                        }
                        break;
                    case 55:
                        if (z(obj, i, length)) {
                            wg0.k(i, N(obj, iM & 1048575));
                        }
                        break;
                    case 56:
                        if (z(obj, i, length)) {
                            wg0.J(i, P(obj, iM & 1048575));
                        }
                        break;
                    case 57:
                        if (z(obj, i, length)) {
                            wg0.y(i, N(obj, iM & 1048575));
                        }
                        break;
                    case 58:
                        if (z(obj, i, length)) {
                            wg0.j(i, S(obj, iM & 1048575));
                        }
                        break;
                    case 59:
                        if (z(obj, i, length)) {
                            t(i, Ig0.F(obj, iM & 1048575), wg0);
                        }
                        break;
                    case 60:
                        if (z(obj, i, length)) {
                            wg0.G(i, Ig0.F(obj, iM & 1048575), s(length));
                        }
                        break;
                    case 61:
                        if (z(obj, i, length)) {
                            wg0.C(i, (zzht) Ig0.F(obj, iM & 1048575));
                        }
                        break;
                    case 62:
                        if (z(obj, i, length)) {
                            wg0.A(i, N(obj, iM & 1048575));
                        }
                        break;
                    case 63:
                        if (z(obj, i, length)) {
                            wg0.D(i, N(obj, iM & 1048575));
                        }
                        break;
                    case 64:
                        if (z(obj, i, length)) {
                            wg0.zza(i, N(obj, iM & 1048575));
                        }
                        break;
                    case 65:
                        if (z(obj, i, length)) {
                            wg0.g(i, P(obj, iM & 1048575));
                        }
                        break;
                    case 66:
                        if (z(obj, i, length)) {
                            wg0.u(i, N(obj, iM & 1048575));
                        }
                        break;
                    case 67:
                        if (z(obj, i, length)) {
                            wg0.K(i, P(obj, iM & 1048575));
                        }
                        break;
                    case 68:
                        if (z(obj, i, length)) {
                            wg0.F(i, Ig0.F(obj, iM & 1048575), s(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.p.g(wg0, entry2);
                entry2 = itQ.hasNext() ? (Map.Entry) itQ.next() : null;
            }
            return;
        }
        if (!this.h) {
            I(obj, wg0);
            return;
        }
        if (this.f) {
            C1812bf0 c1812bf0D2 = this.p.d(obj);
            if (c1812bf0D2.a.isEmpty()) {
                itO = null;
                entry = null;
            } else {
                itO = c1812bf0D2.o();
                entry = (Map.Entry) itO.next();
            }
        } else {
            itO = null;
            entry = null;
        }
        int length2 = this.a.length;
        for (int i2 = 0; i2 < length2; i2 += 3) {
            int iM2 = M(i2);
            int i3 = this.a[i2];
            while (entry != null && this.p.a(entry) <= i3) {
                this.p.g(wg0, entry);
                entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
            }
            switch ((iM2 & 267386880) >>> 20) {
                case 0:
                    if (y(obj, i2)) {
                        wg0.r(i3, Ig0.C(obj, iM2 & 1048575));
                    }
                    break;
                case 1:
                    if (y(obj, i2)) {
                        wg0.s(i3, Ig0.x(obj, iM2 & 1048575));
                    }
                    break;
                case 2:
                    if (y(obj, i2)) {
                        wg0.q(i3, Ig0.o(obj, iM2 & 1048575));
                    }
                    break;
                case 3:
                    if (y(obj, i2)) {
                        wg0.l(i3, Ig0.o(obj, iM2 & 1048575));
                    }
                    break;
                case 4:
                    if (y(obj, i2)) {
                        wg0.k(i3, Ig0.b(obj, iM2 & 1048575));
                    }
                    break;
                case 5:
                    if (y(obj, i2)) {
                        wg0.J(i3, Ig0.o(obj, iM2 & 1048575));
                    }
                    break;
                case 6:
                    if (y(obj, i2)) {
                        wg0.y(i3, Ig0.b(obj, iM2 & 1048575));
                    }
                    break;
                case 7:
                    if (y(obj, i2)) {
                        wg0.j(i3, Ig0.w(obj, iM2 & 1048575));
                    }
                    break;
                case 8:
                    if (y(obj, i2)) {
                        t(i3, Ig0.F(obj, iM2 & 1048575), wg0);
                    }
                    break;
                case 9:
                    if (y(obj, i2)) {
                        wg0.G(i3, Ig0.F(obj, iM2 & 1048575), s(i2));
                    }
                    break;
                case 10:
                    if (y(obj, i2)) {
                        wg0.C(i3, (zzht) Ig0.F(obj, iM2 & 1048575));
                    }
                    break;
                case 11:
                    if (y(obj, i2)) {
                        wg0.A(i3, Ig0.b(obj, iM2 & 1048575));
                    }
                    break;
                case 12:
                    if (y(obj, i2)) {
                        wg0.D(i3, Ig0.b(obj, iM2 & 1048575));
                    }
                    break;
                case 13:
                    if (y(obj, i2)) {
                        wg0.zza(i3, Ig0.b(obj, iM2 & 1048575));
                    }
                    break;
                case 14:
                    if (y(obj, i2)) {
                        wg0.g(i3, Ig0.o(obj, iM2 & 1048575));
                    }
                    break;
                case 15:
                    if (y(obj, i2)) {
                        wg0.u(i3, Ig0.b(obj, iM2 & 1048575));
                    }
                    break;
                case 16:
                    if (y(obj, i2)) {
                        wg0.K(i3, Ig0.o(obj, iM2 & 1048575));
                    }
                    break;
                case 17:
                    if (y(obj, i2)) {
                        wg0.F(i3, Ig0.F(obj, iM2 & 1048575), s(i2));
                    }
                    break;
                case 18:
                    AbstractC3331lg0.l(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 19:
                    AbstractC3331lg0.y(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 20:
                    AbstractC3331lg0.C(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 21:
                    AbstractC3331lg0.G(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 22:
                    AbstractC3331lg0.T(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 23:
                    AbstractC3331lg0.N(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 24:
                    AbstractC3331lg0.a0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 25:
                    AbstractC3331lg0.d0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 26:
                    AbstractC3331lg0.j(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0);
                    break;
                case 27:
                    AbstractC3331lg0.k(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, s(i2));
                    break;
                case 28:
                    AbstractC3331lg0.w(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0);
                    break;
                case 29:
                    AbstractC3331lg0.W(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 30:
                    AbstractC3331lg0.c0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 31:
                    AbstractC3331lg0.b0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 32:
                    AbstractC3331lg0.Q(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 33:
                    AbstractC3331lg0.Z(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 34:
                    AbstractC3331lg0.K(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, false);
                    break;
                case 35:
                    AbstractC3331lg0.l(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 36:
                    AbstractC3331lg0.y(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 37:
                    AbstractC3331lg0.C(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 38:
                    AbstractC3331lg0.G(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 39:
                    AbstractC3331lg0.T(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 40:
                    AbstractC3331lg0.N(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 41:
                    AbstractC3331lg0.a0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 42:
                    AbstractC3331lg0.d0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 43:
                    AbstractC3331lg0.W(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 44:
                    AbstractC3331lg0.c0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 45:
                    AbstractC3331lg0.b0(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 46:
                    AbstractC3331lg0.Q(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 47:
                    AbstractC3331lg0.Z(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 48:
                    AbstractC3331lg0.K(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, true);
                    break;
                case 49:
                    AbstractC3331lg0.x(this.a[i2], (List) Ig0.F(obj, iM2 & 1048575), wg0, s(i2));
                    break;
                case 50:
                    x(wg0, i3, Ig0.F(obj, iM2 & 1048575), i2);
                    break;
                case 51:
                    if (z(obj, i3, i2)) {
                        wg0.r(i3, C(obj, iM2 & 1048575));
                    }
                    break;
                case 52:
                    if (z(obj, i3, i2)) {
                        wg0.s(i3, J(obj, iM2 & 1048575));
                    }
                    break;
                case 53:
                    if (z(obj, i3, i2)) {
                        wg0.q(i3, P(obj, iM2 & 1048575));
                    }
                    break;
                case 54:
                    if (z(obj, i3, i2)) {
                        wg0.l(i3, P(obj, iM2 & 1048575));
                    }
                    break;
                case 55:
                    if (z(obj, i3, i2)) {
                        wg0.k(i3, N(obj, iM2 & 1048575));
                    }
                    break;
                case 56:
                    if (z(obj, i3, i2)) {
                        wg0.J(i3, P(obj, iM2 & 1048575));
                    }
                    break;
                case 57:
                    if (z(obj, i3, i2)) {
                        wg0.y(i3, N(obj, iM2 & 1048575));
                    }
                    break;
                case 58:
                    if (z(obj, i3, i2)) {
                        wg0.j(i3, S(obj, iM2 & 1048575));
                    }
                    break;
                case 59:
                    if (z(obj, i3, i2)) {
                        t(i3, Ig0.F(obj, iM2 & 1048575), wg0);
                    }
                    break;
                case 60:
                    if (z(obj, i3, i2)) {
                        wg0.G(i3, Ig0.F(obj, iM2 & 1048575), s(i2));
                    }
                    break;
                case 61:
                    if (z(obj, i3, i2)) {
                        wg0.C(i3, (zzht) Ig0.F(obj, iM2 & 1048575));
                    }
                    break;
                case 62:
                    if (z(obj, i3, i2)) {
                        wg0.A(i3, N(obj, iM2 & 1048575));
                    }
                    break;
                case 63:
                    if (z(obj, i3, i2)) {
                        wg0.D(i3, N(obj, iM2 & 1048575));
                    }
                    break;
                case 64:
                    if (z(obj, i3, i2)) {
                        wg0.zza(i3, N(obj, iM2 & 1048575));
                    }
                    break;
                case 65:
                    if (z(obj, i3, i2)) {
                        wg0.g(i3, P(obj, iM2 & 1048575));
                    }
                    break;
                case 66:
                    if (z(obj, i3, i2)) {
                        wg0.u(i3, N(obj, iM2 & 1048575));
                    }
                    break;
                case 67:
                    if (z(obj, i3, i2)) {
                        wg0.K(i3, P(obj, iM2 & 1048575));
                    }
                    break;
                case 68:
                    if (z(obj, i3, i2)) {
                        wg0.F(i3, Ig0.F(obj, iM2 & 1048575), s(i2));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.p.g(wg0, entry);
            entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
        }
        w(this.o, obj, wg0);
    }

    public final int h(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return D(i, i2);
    }

    public final int i(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C3327le0 c3327le0) throws zzjk {
        int iK;
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(r.m(bArr, i)));
                iK = i + 8;
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(r.o(bArr, i)));
                iK = i + 4;
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iK = r.k(bArr, i, c3327le0);
                unsafe.putObject(obj, j, Long.valueOf(c3327le0.b));
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iK = r.j(bArr, i, c3327le0);
                unsafe.putObject(obj, j, Integer.valueOf(c3327le0.a));
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(r.l(bArr, i)));
                iK = i + 8;
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(r.h(bArr, i)));
                iK = i + 4;
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iK = r.k(bArr, i, c3327le0);
                unsafe.putObject(obj, j, Boolean.valueOf(c3327le0.b != 0));
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iJ = r.j(bArr, i, c3327le0);
                int i9 = c3327le0.a;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & PropertyOptions.DELETE_EXISTING) != 0 && !Lg0.g(bArr, iJ, iJ + i9)) {
                        throw zzjk.zzh();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iJ, i9, zzjf.zza));
                    iJ += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iJ;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iG = r.g(s(i8), bArr, i, i2, c3327le0);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, c3327le0.c);
                } else {
                    unsafe.putObject(obj, j, zzjf.zza(object, c3327le0.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iK = r.q(bArr, i, c3327le0);
                unsafe.putObject(obj, j, c3327le0.c);
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iJ2 = r.j(bArr, i, c3327le0);
                int i10 = c3327le0.a;
                zzjg zzjgVarK = K(i8);
                if (zzjgVarK != null && !zzjgVarK.zza(i10)) {
                    Q(obj).zza(i3, Long.valueOf(i10));
                    return iJ2;
                }
                unsafe.putObject(obj, j, Integer.valueOf(i10));
                iK = iJ2;
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iK = r.j(bArr, i, c3327le0);
                unsafe.putObject(obj, j, Integer.valueOf(zzif.zze(c3327le0.a)));
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iK = r.k(bArr, i, c3327le0);
                unsafe.putObject(obj, j, Long.valueOf(zzif.zza(c3327le0.b)));
                unsafe.putInt(obj, j2, i4);
                return iK;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iK = r.f(s(i8), bArr, i, i2, (i3 & (-8)) | 4, c3327le0);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, c3327le0.c);
                } else {
                    unsafe.putObject(obj, j, zzjf.zza(object2, c3327le0.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iK;
            default:
                return i;
        }
    }

    public final int j(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C3327le0 c3327le0) throws zzjk {
        int iA;
        int iJ = i;
        Unsafe unsafe = s;
        zzjl zzjlVarZza = (zzjl) unsafe.getObject(obj, j2);
        if (!zzjlVarZza.zza()) {
            int size = zzjlVarZza.size();
            zzjlVarZza = zzjlVarZza.zza(size == 0 ? 10 : size << 1);
            unsafe.putObject(obj, j2, zzjlVarZza);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    int iJ2 = r.j(bArr, iJ, c3327le0);
                    int i8 = c3327le0.a + iJ2;
                    if (iJ2 < i8) {
                        r.m(bArr, iJ2);
                        throw null;
                    }
                    if (iJ2 == i8) {
                        return iJ2;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 1) {
                    r.m(bArr, i);
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    int iJ3 = r.j(bArr, iJ, c3327le0);
                    int i9 = c3327le0.a + iJ3;
                    if (iJ3 < i9) {
                        r.o(bArr, iJ3);
                        throw null;
                    }
                    if (iJ3 == i9) {
                        return iJ3;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 5) {
                    r.o(bArr, i);
                    throw null;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    int iJ4 = r.j(bArr, iJ, c3327le0);
                    int i10 = c3327le0.a + iJ4;
                    if (iJ4 < i10) {
                        r.k(bArr, iJ4, c3327le0);
                        throw null;
                    }
                    if (iJ4 == i10) {
                        return iJ4;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 0) {
                    r.k(bArr, iJ, c3327le0);
                    long j3 = c3327le0.b;
                    throw null;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return r.i(bArr, iJ, zzjlVarZza, c3327le0);
                }
                if (i5 == 0) {
                    return r.a(i3, bArr, i, i2, zzjlVarZza, c3327le0);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    int iJ5 = r.j(bArr, iJ, c3327le0);
                    int i11 = c3327le0.a + iJ5;
                    if (iJ5 < i11) {
                        r.l(bArr, iJ5);
                        throw null;
                    }
                    if (iJ5 == i11) {
                        return iJ5;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 1) {
                    r.l(bArr, i);
                    throw null;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    C4142vf0 c4142vf0 = (C4142vf0) zzjlVarZza;
                    int iJ6 = r.j(bArr, iJ, c3327le0);
                    int i12 = c3327le0.a + iJ6;
                    while (iJ6 < i12) {
                        c4142vf0.b(r.h(bArr, iJ6));
                        iJ6 += 4;
                    }
                    if (iJ6 == i12) {
                        return iJ6;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 5) {
                    C4142vf0 c4142vf1 = (C4142vf0) zzjlVarZza;
                    c4142vf1.b(r.h(bArr, i));
                    while (true) {
                        int i13 = iJ + 4;
                        if (i13 >= i2) {
                            return i13;
                        }
                        iJ = r.j(bArr, i13, c3327le0);
                        if (i3 != c3327le0.a) {
                            return i13;
                        }
                        c4142vf1.b(r.h(bArr, iJ));
                    }
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    int iJ7 = r.j(bArr, iJ, c3327le0);
                    int i14 = c3327le0.a + iJ7;
                    if (iJ7 < i14) {
                        r.k(bArr, iJ7, c3327le0);
                        throw null;
                    }
                    if (iJ7 == i14) {
                        return iJ7;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 0) {
                    r.k(bArr, iJ, c3327le0);
                    long j4 = c3327le0.b;
                    throw null;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        iJ = r.j(bArr, iJ, c3327le0);
                        int i15 = c3327le0.a;
                        if (i15 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i15 == 0) {
                            zzjlVarZza.add("");
                        } else {
                            zzjlVarZza.add(new String(bArr, iJ, i15, zzjf.zza));
                            iJ += i15;
                        }
                        while (iJ < i2) {
                            int iJ8 = r.j(bArr, iJ, c3327le0);
                            if (i3 != c3327le0.a) {
                                break;
                            } else {
                                iJ = r.j(bArr, iJ8, c3327le0);
                                int i16 = c3327le0.a;
                                if (i16 < 0) {
                                    throw zzjk.zzb();
                                }
                                if (i16 == 0) {
                                    zzjlVarZza.add("");
                                } else {
                                    zzjlVarZza.add(new String(bArr, iJ, i16, zzjf.zza));
                                    iJ += i16;
                                }
                            }
                        }
                    } else {
                        iJ = r.j(bArr, iJ, c3327le0);
                        int i17 = c3327le0.a;
                        if (i17 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i17 == 0) {
                            zzjlVarZza.add("");
                        } else {
                            int i18 = iJ + i17;
                            if (!Lg0.g(bArr, iJ, i18)) {
                                throw zzjk.zzh();
                            }
                            zzjlVarZza.add(new String(bArr, iJ, i17, zzjf.zza));
                            iJ = i18;
                        }
                        while (iJ < i2) {
                            int iJ9 = r.j(bArr, iJ, c3327le0);
                            if (i3 != c3327le0.a) {
                                break;
                            } else {
                                iJ = r.j(bArr, iJ9, c3327le0);
                                int i19 = c3327le0.a;
                                if (i19 < 0) {
                                    throw zzjk.zzb();
                                }
                                if (i19 == 0) {
                                    zzjlVarZza.add("");
                                } else {
                                    int i20 = iJ + i19;
                                    if (!Lg0.g(bArr, iJ, i20)) {
                                        throw zzjk.zzh();
                                    }
                                    zzjlVarZza.add(new String(bArr, iJ, i19, zzjf.zza));
                                    iJ = i20;
                                }
                            }
                        }
                    }
                }
                break;
            case 27:
                if (i5 == 2) {
                    return r.e(s(i6), i3, bArr, i, i2, zzjlVarZza, c3327le0);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iJ10 = r.j(bArr, iJ, c3327le0);
                    int i21 = c3327le0.a;
                    if (i21 < 0) {
                        throw zzjk.zzb();
                    }
                    if (i21 > bArr.length - iJ10) {
                        throw zzjk.zza();
                    }
                    if (i21 == 0) {
                        zzjlVarZza.add(zzht.zza);
                    } else {
                        zzjlVarZza.add(zzht.zza(bArr, iJ10, i21));
                        iJ10 += i21;
                    }
                    while (iJ10 < i2) {
                        int iJ11 = r.j(bArr, iJ10, c3327le0);
                        if (i3 != c3327le0.a) {
                            return iJ10;
                        }
                        iJ10 = r.j(bArr, iJ11, c3327le0);
                        int i22 = c3327le0.a;
                        if (i22 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i22 > bArr.length - iJ10) {
                            throw zzjk.zza();
                        }
                        if (i22 == 0) {
                            zzjlVarZza.add(zzht.zza);
                        } else {
                            zzjlVarZza.add(zzht.zza(bArr, iJ10, i22));
                            iJ10 += i22;
                        }
                    }
                    return iJ10;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iA = r.i(bArr, iJ, zzjlVarZza, c3327le0);
                } else if (i5 == 0) {
                    iA = r.a(i3, bArr, i, i2, zzjlVarZza, c3327le0);
                }
                zzjb zzjbVar = (zzjb) obj;
                zzlx zzlxVar = zzjbVar.zzb;
                zzlx zzlxVar2 = (zzlx) AbstractC3331lg0.g(i4, zzjlVarZza, K(i6), zzlxVar != zzlx.zza() ? zzlxVar : null, this.o);
                if (zzlxVar2 != null) {
                    zzjbVar.zzb = zzlxVar2;
                }
                return iA;
            case 33:
            case 47:
                if (i5 == 2) {
                    C4142vf0 c4142vf2 = (C4142vf0) zzjlVarZza;
                    int iJ12 = r.j(bArr, iJ, c3327le0);
                    int i23 = c3327le0.a + iJ12;
                    while (iJ12 < i23) {
                        iJ12 = r.j(bArr, iJ12, c3327le0);
                        c4142vf2.b(zzif.zze(c3327le0.a));
                    }
                    if (iJ12 == i23) {
                        return iJ12;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 0) {
                    C4142vf0 c4142vf3 = (C4142vf0) zzjlVarZza;
                    int iJ13 = r.j(bArr, iJ, c3327le0);
                    c4142vf3.b(zzif.zze(c3327le0.a));
                    while (iJ13 < i2) {
                        int iJ14 = r.j(bArr, iJ13, c3327le0);
                        if (i3 != c3327le0.a) {
                            return iJ13;
                        }
                        iJ13 = r.j(bArr, iJ14, c3327le0);
                        c4142vf3.b(zzif.zze(c3327le0.a));
                    }
                    return iJ13;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    int iJ15 = r.j(bArr, iJ, c3327le0);
                    int i24 = c3327le0.a + iJ15;
                    if (iJ15 >= i24) {
                        if (iJ15 == i24) {
                            return iJ15;
                        }
                        throw zzjk.zza();
                    }
                    r.k(bArr, iJ15, c3327le0);
                    zzif.zza(c3327le0.b);
                    throw null;
                }
                if (i5 == 0) {
                    r.k(bArr, iJ, c3327le0);
                    zzif.zza(c3327le0.b);
                    throw null;
                }
                break;
            case 49:
                if (i5 == 3) {
                    InterfaceC3167jg0 interfaceC3167jg0S = s(i6);
                    int i25 = (i3 & (-8)) | 4;
                    iJ = r.f(interfaceC3167jg0S, bArr, i, i2, i25, c3327le0);
                    zzjlVarZza.add(c3327le0.c);
                    while (iJ < i2) {
                        int iJ16 = r.j(bArr, iJ, c3327le0);
                        if (i3 == c3327le0.a) {
                            iJ = r.f(interfaceC3167jg0S, bArr, iJ16, i2, i25, c3327le0);
                            zzjlVarZza.add(c3327le0.c);
                        }
                    }
                }
                break;
        }
        return iJ;
    }

    public final int k(Object obj, byte[] bArr, int i, int i2, int i3, long j, C3327le0 c3327le0) throws zzjk {
        Unsafe unsafe = s;
        Object objE = E(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.q.d(object)) {
            Object objB = this.q.b(objE);
            this.q.e(objB, object);
            unsafe.putObject(obj, j, objB);
            object = objB;
        }
        this.q.zzb(objE);
        this.q.zza(object);
        int iJ = r.j(bArr, i, c3327le0);
        int i4 = c3327le0.a;
        if (i4 < 0 || i4 > i2 - iJ) {
            throw zzjk.zza();
        }
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16661. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int l(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, defpackage.C3327le0 r40) throws com.google.android.gms.internal.vision.zzjk {
        /*
            Method dump skipped, instruction units count: 1666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.x.l(java.lang.Object, byte[], int, int, int, le0):int");
    }

    public final Object o(int i, int i2, Map map, zzjg zzjgVar, Object obj, Ag0 ag0) {
        this.q.zzb(E(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzjgVar.zza(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = ag0.a();
                }
                Oe0 oe0Zzc = zzht.zzc(zzkc.zza(null, entry.getKey(), entry.getValue()));
                try {
                    zzkc.zza(oe0Zzc.b(), null, entry.getKey(), entry.getValue());
                    ag0.e(obj, i2, oe0Zzc.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    public final Object p(Object obj, int i, Object obj2, Ag0 ag0) {
        zzjg zzjgVarK;
        int i2 = this.a[i];
        Object objF = Ig0.F(obj, M(i) & 1048575);
        return (objF == null || (zzjgVarK = K(i)) == null) ? obj2 : o(i, i2, this.q.zza(objF), zzjgVarK, obj2, ag0);
    }

    public final InterfaceC3167jg0 s(int i) {
        int i2 = (i / 3) << 1;
        InterfaceC3167jg0 interfaceC3167jg0 = (InterfaceC3167jg0) this.b[i2];
        if (interfaceC3167jg0 != null) {
            return interfaceC3167jg0;
        }
        InterfaceC3167jg0 interfaceC3167jg0B = Yf0.a().b((Class) this.b[i2 + 1]);
        this.b[i2] = interfaceC3167jg0B;
        return interfaceC3167jg0B;
    }

    public final void u(Object obj, int i, InterfaceC3249kg0 interfaceC3249kg0) {
        if (R(i)) {
            Ig0.j(obj, i & 1048575, interfaceC3249kg0.zzm());
        } else if (this.g) {
            Ig0.j(obj, i & 1048575, interfaceC3249kg0.o());
        } else {
            Ig0.j(obj, i & 1048575, interfaceC3249kg0.f());
        }
    }

    public final void v(Object obj, Object obj2, int i) {
        long jM = M(i) & 1048575;
        if (y(obj2, i)) {
            Object objF = Ig0.F(obj, jM);
            Object objF2 = Ig0.F(obj2, jM);
            if (objF != null && objF2 != null) {
                Ig0.j(obj, jM, zzjf.zza(objF, objF2));
                F(obj, i);
            } else if (objF2 != null) {
                Ig0.j(obj, jM, objF2);
                F(obj, i);
            }
        }
    }

    public final void x(Wg0 wg0, int i, Object obj, int i2) {
        if (obj != null) {
            this.q.zzb(E(i2));
            wg0.H(i, null, this.q.a(obj));
        }
    }

    public final boolean y(Object obj, int i) {
        int iO = O(i);
        long j = iO & 1048575;
        if (j != 1048575) {
            return (Ig0.b(obj, j) & (1 << (iO >>> 20))) != 0;
        }
        int iM = M(i);
        long j2 = iM & 1048575;
        switch ((iM & 267386880) >>> 20) {
            case 0:
                return Ig0.C(obj, j2) != 0.0d;
            case 1:
                return Ig0.x(obj, j2) != 0.0f;
            case 2:
                return Ig0.o(obj, j2) != 0;
            case 3:
                return Ig0.o(obj, j2) != 0;
            case 4:
                return Ig0.b(obj, j2) != 0;
            case 5:
                return Ig0.o(obj, j2) != 0;
            case 6:
                return Ig0.b(obj, j2) != 0;
            case 7:
                return Ig0.w(obj, j2);
            case 8:
                Object objF = Ig0.F(obj, j2);
                if (objF instanceof String) {
                    return !((String) objF).isEmpty();
                }
                if (objF instanceof zzht) {
                    return !zzht.zza.equals(objF);
                }
                throw new IllegalArgumentException();
            case 9:
                return Ig0.F(obj, j2) != null;
            case 10:
                return !zzht.zza.equals(Ig0.F(obj, j2));
            case 11:
                return Ig0.b(obj, j2) != 0;
            case 12:
                return Ig0.b(obj, j2) != 0;
            case 13:
                return Ig0.b(obj, j2) != 0;
            case 14:
                return Ig0.o(obj, j2) != 0;
            case 15:
                return Ig0.b(obj, j2) != 0;
            case 16:
                return Ig0.o(obj, j2) != 0;
            case 17:
                return Ig0.F(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean z(Object obj, int i, int i2) {
        return Ig0.b(obj, (long) (O(i2) & 1048575)) == i;
    }

    @Override // defpackage.InterfaceC3167jg0
    public final Object zza() {
        return this.m.zza(this.e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.InterfaceC3167jg0
    public final int zzb(Object obj) {
        int i;
        long j;
        int iZzd;
        int iZzb;
        int iZzc;
        int iR;
        int iV;
        int iZze;
        int iZzg;
        int iZzb2;
        int iV2;
        int iZze2;
        int iZzg2;
        int i2 = 267386880;
        int i3 = 1048575;
        int i4 = 1;
        if (!this.h) {
            Unsafe unsafe = s;
            int i5 = 0;
            int iZzb3 = 0;
            int i6 = 1048575;
            int i7 = 0;
            while (i5 < this.a.length) {
                int iM = M(i5);
                int[] iArr = this.a;
                int i8 = iArr[i5];
                int i9 = (iM & 267386880) >>> 20;
                if (i9 <= 17) {
                    int i10 = iArr[i5 + 2];
                    int i11 = i10 & i3;
                    i = i4 << (i10 >>> 20);
                    if (i11 != i6) {
                        i7 = unsafe.getInt(obj, i11);
                        i6 = i11;
                    }
                } else {
                    i = 0;
                }
                long j2 = iM & i3;
                switch (i9) {
                    case 0:
                        j = 0;
                        if ((i7 & i) != 0) {
                            iZzb3 += zzii.zzb(i8, 0.0d);
                        }
                        break;
                    case 1:
                        j = 0;
                        if ((i7 & i) != 0) {
                            iZzb3 += zzii.zzb(i8, 0.0f);
                        }
                        break;
                    case 2:
                        j = 0;
                        if ((i & i7) != 0) {
                            iZzd = zzii.zzd(i8, unsafe.getLong(obj, j2));
                            iZzb3 += iZzd;
                        }
                        break;
                    case 3:
                        j = 0;
                        if ((i & i7) != 0) {
                            iZzd = zzii.zze(i8, unsafe.getLong(obj, j2));
                            iZzb3 += iZzd;
                        }
                        break;
                    case 4:
                        j = 0;
                        if ((i & i7) != 0) {
                            iZzd = zzii.zzf(i8, unsafe.getInt(obj, j2));
                            iZzb3 += iZzd;
                        }
                        break;
                    case 5:
                        j = 0;
                        if ((i7 & i) != 0) {
                            iZzd = zzii.zzg(i8, 0L);
                            iZzb3 += iZzd;
                        }
                        break;
                    case 6:
                        if ((i7 & i) != 0) {
                            iZzb3 += zzii.zzi(i8, 0);
                        }
                        j = 0;
                        break;
                    case 7:
                        if ((i7 & i) != 0) {
                            iZzb = zzii.zzb(i8, true);
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 8:
                        if ((i7 & i) != 0) {
                            Object object = unsafe.getObject(obj, j2);
                            iZzc = object instanceof zzht ? zzii.zzc(i8, (zzht) object) : zzii.zzb(i8, (String) object);
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 9:
                        if ((i7 & i) != 0) {
                            iZzc = AbstractC3331lg0.a(i8, unsafe.getObject(obj, j2), s(i5));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 10:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzc(i8, (zzht) unsafe.getObject(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 11:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzg(i8, unsafe.getInt(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 12:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzk(i8, unsafe.getInt(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 13:
                        if ((i7 & i) != 0) {
                            iZzb = zzii.zzj(i8, 0);
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 14:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzh(i8, 0L);
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 15:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzh(i8, unsafe.getInt(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 16:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzf(i8, unsafe.getLong(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 17:
                        if ((i7 & i) != 0) {
                            iZzc = zzii.zzc(i8, (zzkk) unsafe.getObject(obj, j2), s(i5));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 18:
                        iZzc = AbstractC3331lg0.U(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 19:
                        iR = AbstractC3331lg0.R(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 20:
                        iR = AbstractC3331lg0.d(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 21:
                        iR = AbstractC3331lg0.t(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 22:
                        iR = AbstractC3331lg0.H(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 23:
                        iR = AbstractC3331lg0.U(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 24:
                        iR = AbstractC3331lg0.R(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 25:
                        iR = AbstractC3331lg0.X(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 26:
                        iZzc = AbstractC3331lg0.b(i8, (List) unsafe.getObject(obj, j2));
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 27:
                        iZzc = AbstractC3331lg0.c(i8, (List) unsafe.getObject(obj, j2), s(i5));
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 28:
                        iZzc = AbstractC3331lg0.r(i8, (List) unsafe.getObject(obj, j2));
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 29:
                        iZzc = AbstractC3331lg0.L(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 30:
                        iR = AbstractC3331lg0.D(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 31:
                        iR = AbstractC3331lg0.R(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 32:
                        iR = AbstractC3331lg0.U(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 33:
                        iR = AbstractC3331lg0.O(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 34:
                        iR = AbstractC3331lg0.z(i8, (List) unsafe.getObject(obj, j2), false);
                        iZzb3 += iR;
                        j = 0;
                        break;
                    case 35:
                        iV = AbstractC3331lg0.V((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 36:
                        iV = AbstractC3331lg0.S((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 37:
                        iV = AbstractC3331lg0.e((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 38:
                        iV = AbstractC3331lg0.u((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 39:
                        iV = AbstractC3331lg0.I((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 40:
                        iV = AbstractC3331lg0.V((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 41:
                        iV = AbstractC3331lg0.S((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 42:
                        iV = AbstractC3331lg0.Y((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 43:
                        iV = AbstractC3331lg0.M((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 44:
                        iV = AbstractC3331lg0.E((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 45:
                        iV = AbstractC3331lg0.S((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 46:
                        iV = AbstractC3331lg0.V((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 47:
                        iV = AbstractC3331lg0.P((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 48:
                        iV = AbstractC3331lg0.A((List) unsafe.getObject(obj, j2));
                        if (iV > 0) {
                            iZze = zzii.zze(i8);
                            iZzg = zzii.zzg(iV);
                            iZzb = iZze + iZzg + iV;
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 49:
                        iZzc = AbstractC3331lg0.s(i8, (List) unsafe.getObject(obj, j2), s(i5));
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 50:
                        iZzc = this.q.f(i8, unsafe.getObject(obj, j2), E(i5));
                        iZzb3 += iZzc;
                        j = 0;
                        break;
                    case 51:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzb(i8, 0.0d);
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 52:
                        if (z(obj, i8, i5)) {
                            iZzb = zzii.zzb(i8, 0.0f);
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 53:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzd(i8, P(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 54:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zze(i8, P(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 55:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzf(i8, N(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 56:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzg(i8, 0L);
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 57:
                        if (z(obj, i8, i5)) {
                            iZzb = zzii.zzi(i8, 0);
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 58:
                        if (z(obj, i8, i5)) {
                            iZzb = zzii.zzb(i8, true);
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 59:
                        if (z(obj, i8, i5)) {
                            Object object2 = unsafe.getObject(obj, j2);
                            iZzc = object2 instanceof zzht ? zzii.zzc(i8, (zzht) object2) : zzii.zzb(i8, (String) object2);
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 60:
                        if (z(obj, i8, i5)) {
                            iZzc = AbstractC3331lg0.a(i8, unsafe.getObject(obj, j2), s(i5));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 61:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzc(i8, (zzht) unsafe.getObject(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 62:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzg(i8, N(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 63:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzk(i8, N(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 64:
                        if (z(obj, i8, i5)) {
                            iZzb = zzii.zzj(i8, 0);
                            iZzb3 += iZzb;
                        }
                        j = 0;
                        break;
                    case 65:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzh(i8, 0L);
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 66:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzh(i8, N(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 67:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzf(i8, P(obj, j2));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    case 68:
                        if (z(obj, i8, i5)) {
                            iZzc = zzii.zzc(i8, (zzkk) unsafe.getObject(obj, j2), s(i5));
                            iZzb3 += iZzc;
                        }
                        j = 0;
                        break;
                    default:
                        j = 0;
                        break;
                }
                i5 += 3;
                i3 = 1048575;
                i4 = 1;
            }
            int iL = 0;
            int iM2 = iZzb3 + m(this.o, obj);
            if (!this.f) {
                return iM2;
            }
            C1812bf0 c1812bf0D = this.p.d(obj);
            for (int i12 = 0; i12 < c1812bf0D.a.k(); i12++) {
                Map.Entry entryH = c1812bf0D.a.h(i12);
                iL += C1812bf0.l((zziw) entryH.getKey(), entryH.getValue());
            }
            for (Map.Entry entry : c1812bf0D.a.n()) {
                iL += C1812bf0.l((zziw) entry.getKey(), entry.getValue());
            }
            return iM2 + iL;
        }
        Unsafe unsafe2 = s;
        int i13 = 0;
        int i14 = 0;
        while (i13 < this.a.length) {
            int iM3 = M(i13);
            int i15 = (iM3 & i2) >>> 20;
            int i16 = this.a[i13];
            long j3 = iM3 & 1048575;
            if (i15 >= zziv.zza.zza() && i15 <= zziv.zzb.zza()) {
                int i17 = this.a[i13 + 2];
            }
            switch (i15) {
                case 0:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzb(i16, 0.0d);
                        i14 += iZzb2;
                    }
                    break;
                case 1:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzb(i16, 0.0f);
                        i14 += iZzb2;
                    }
                    break;
                case 2:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzd(i16, Ig0.o(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 3:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zze(i16, Ig0.o(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 4:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzf(i16, Ig0.b(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 5:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzg(i16, 0L);
                        i14 += iZzb2;
                    }
                    break;
                case 6:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzi(i16, 0);
                        i14 += iZzb2;
                    }
                    break;
                case 7:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzb(i16, true);
                        i14 += iZzb2;
                    }
                    break;
                case 8:
                    if (y(obj, i13)) {
                        Object objF = Ig0.F(obj, j3);
                        iZzb2 = objF instanceof zzht ? zzii.zzc(i16, (zzht) objF) : zzii.zzb(i16, (String) objF);
                        i14 += iZzb2;
                    }
                    break;
                case 9:
                    if (y(obj, i13)) {
                        iZzb2 = AbstractC3331lg0.a(i16, Ig0.F(obj, j3), s(i13));
                        i14 += iZzb2;
                    }
                    break;
                case 10:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzc(i16, (zzht) Ig0.F(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 11:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzg(i16, Ig0.b(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 12:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzk(i16, Ig0.b(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 13:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzj(i16, 0);
                        i14 += iZzb2;
                    }
                    break;
                case 14:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzh(i16, 0L);
                        i14 += iZzb2;
                    }
                    break;
                case 15:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzh(i16, Ig0.b(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 16:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzf(i16, Ig0.o(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 17:
                    if (y(obj, i13)) {
                        iZzb2 = zzii.zzc(i16, (zzkk) Ig0.F(obj, j3), s(i13));
                        i14 += iZzb2;
                    }
                    break;
                case 18:
                    iZzb2 = AbstractC3331lg0.U(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 19:
                    iZzb2 = AbstractC3331lg0.R(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 20:
                    iZzb2 = AbstractC3331lg0.d(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 21:
                    iZzb2 = AbstractC3331lg0.t(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 22:
                    iZzb2 = AbstractC3331lg0.H(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 23:
                    iZzb2 = AbstractC3331lg0.U(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 24:
                    iZzb2 = AbstractC3331lg0.R(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 25:
                    iZzb2 = AbstractC3331lg0.X(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 26:
                    iZzb2 = AbstractC3331lg0.b(i16, r(obj, j3));
                    i14 += iZzb2;
                    break;
                case 27:
                    iZzb2 = AbstractC3331lg0.c(i16, r(obj, j3), s(i13));
                    i14 += iZzb2;
                    break;
                case 28:
                    iZzb2 = AbstractC3331lg0.r(i16, r(obj, j3));
                    i14 += iZzb2;
                    break;
                case 29:
                    iZzb2 = AbstractC3331lg0.L(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 30:
                    iZzb2 = AbstractC3331lg0.D(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 31:
                    iZzb2 = AbstractC3331lg0.R(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 32:
                    iZzb2 = AbstractC3331lg0.U(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 33:
                    iZzb2 = AbstractC3331lg0.O(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 34:
                    iZzb2 = AbstractC3331lg0.z(i16, r(obj, j3), false);
                    i14 += iZzb2;
                    break;
                case 35:
                    iV2 = AbstractC3331lg0.V((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 36:
                    iV2 = AbstractC3331lg0.S((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 37:
                    iV2 = AbstractC3331lg0.e((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 38:
                    iV2 = AbstractC3331lg0.u((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 39:
                    iV2 = AbstractC3331lg0.I((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 40:
                    iV2 = AbstractC3331lg0.V((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 41:
                    iV2 = AbstractC3331lg0.S((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 42:
                    iV2 = AbstractC3331lg0.Y((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 43:
                    iV2 = AbstractC3331lg0.M((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 44:
                    iV2 = AbstractC3331lg0.E((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 45:
                    iV2 = AbstractC3331lg0.S((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 46:
                    iV2 = AbstractC3331lg0.V((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 47:
                    iV2 = AbstractC3331lg0.P((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 48:
                    iV2 = AbstractC3331lg0.A((List) unsafe2.getObject(obj, j3));
                    if (iV2 > 0) {
                        iZze2 = zzii.zze(i16);
                        iZzg2 = zzii.zzg(iV2);
                        iZzb2 = iZze2 + iZzg2 + iV2;
                        i14 += iZzb2;
                    }
                    break;
                case 49:
                    iZzb2 = AbstractC3331lg0.s(i16, r(obj, j3), s(i13));
                    i14 += iZzb2;
                    break;
                case 50:
                    iZzb2 = this.q.f(i16, Ig0.F(obj, j3), E(i13));
                    i14 += iZzb2;
                    break;
                case 51:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzb(i16, 0.0d);
                        i14 += iZzb2;
                    }
                    break;
                case 52:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzb(i16, 0.0f);
                        i14 += iZzb2;
                    }
                    break;
                case 53:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzd(i16, P(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 54:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zze(i16, P(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 55:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzf(i16, N(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 56:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzg(i16, 0L);
                        i14 += iZzb2;
                    }
                    break;
                case 57:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzi(i16, 0);
                        i14 += iZzb2;
                    }
                    break;
                case 58:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzb(i16, true);
                        i14 += iZzb2;
                    }
                    break;
                case 59:
                    if (z(obj, i16, i13)) {
                        Object objF2 = Ig0.F(obj, j3);
                        iZzb2 = objF2 instanceof zzht ? zzii.zzc(i16, (zzht) objF2) : zzii.zzb(i16, (String) objF2);
                        i14 += iZzb2;
                    }
                    break;
                case 60:
                    if (z(obj, i16, i13)) {
                        iZzb2 = AbstractC3331lg0.a(i16, Ig0.F(obj, j3), s(i13));
                        i14 += iZzb2;
                    }
                    break;
                case 61:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzc(i16, (zzht) Ig0.F(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 62:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzg(i16, N(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 63:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzk(i16, N(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 64:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzj(i16, 0);
                        i14 += iZzb2;
                    }
                    break;
                case 65:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzh(i16, 0L);
                        i14 += iZzb2;
                    }
                    break;
                case 66:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzh(i16, N(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 67:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzf(i16, P(obj, j3));
                        i14 += iZzb2;
                    }
                    break;
                case 68:
                    if (z(obj, i16, i13)) {
                        iZzb2 = zzii.zzc(i16, (zzkk) Ig0.F(obj, j3), s(i13));
                        i14 += iZzb2;
                    }
                    break;
            }
            i13 += 3;
            i2 = 267386880;
        }
        return i14 + m(this.o, obj);
    }

    @Override // defpackage.InterfaceC3167jg0
    public final int zza(Object obj) {
        int i;
        int iZza;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iM = M(i3);
            int i4 = this.a[i3];
            long j = 1048575 & iM;
            int iHashCode = 37;
            switch ((iM & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjf.zza(Double.doubleToLongBits(Ig0.C(obj, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(Ig0.x(obj, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjf.zza(Ig0.o(obj, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjf.zza(Ig0.o(obj, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = Ig0.b(obj, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjf.zza(Ig0.o(obj, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = Ig0.b(obj, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjf.zza(Ig0.w(obj, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) Ig0.F(obj, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objF = Ig0.F(obj, j);
                    if (objF != null) {
                        iHashCode = objF.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = Ig0.F(obj, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = Ig0.b(obj, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = Ig0.b(obj, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = Ig0.b(obj, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjf.zza(Ig0.o(obj, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = Ig0.b(obj, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjf.zza(Ig0.o(obj, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objF2 = Ig0.F(obj, j);
                    if (objF2 != null) {
                        iHashCode = objF2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = Ig0.F(obj, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = Ig0.F(obj, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(Double.doubleToLongBits(C(obj, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(J(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 53:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(P(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(P(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 55:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = N(obj, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(P(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = N(obj, j);
                        i2 = i + iZza;
                    }
                    break;
                case 58:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(S(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) Ig0.F(obj, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = Ig0.F(obj, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 61:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = Ig0.F(obj, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 62:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = N(obj, j);
                        i2 = i + iZza;
                    }
                    break;
                case 63:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = N(obj, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = N(obj, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(P(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 66:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = N(obj, j);
                        i2 = i + iZza;
                    }
                    break;
                case 67:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(P(obj, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = Ig0.F(obj, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.o.k(obj).hashCode();
        return this.f ? (iHashCode2 * 53) + this.p.d(obj).hashCode() : iHashCode2;
    }
}
