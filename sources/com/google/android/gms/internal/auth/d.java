package com.google.android.gms.internal.auth;

import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC1244ae0;
import defpackage.AbstractC2047dd0;
import defpackage.AbstractC2124eb0;
import defpackage.AbstractC3159jc0;
import defpackage.AbstractC3245ke0;
import defpackage.AbstractC3574of;
import defpackage.AbstractC4219wd0;
import defpackage.C1883ca0;
import defpackage.C3893sc0;
import defpackage.InterfaceC4217wc0;
import defpackage.Pc0;
import defpackage.Uc0;
import defpackage.Xc0;
import defpackage.Zc0;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Zc0 {
    public static final int[] o = new int[0];
    public static final Unsafe p = AbstractC1244ae0.g();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final zzfw e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final AbstractC3159jc0 j;
    public final AbstractC4219wd0 k;
    public final AbstractC2124eb0 l;
    public final Pc0 m;
    public final C3893sc0 n;

    public d(int[] iArr, Object[] objArr, int i, int i2, zzfw zzfwVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, Pc0 pc0, AbstractC3159jc0 abstractC3159jc0, AbstractC4219wd0 abstractC4219wd0, AbstractC2124eb0 abstractC2124eb0, C3893sc0 c3893sc0, byte[] bArr) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = z;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.m = pc0;
        this.j = abstractC3159jc0;
        this.k = abstractC4219wd0;
        this.l = abstractC2124eb0;
        this.e = zzfwVar;
        this.n = c3893sc0;
    }

    public static int C(int i) {
        return (i >>> 20) & 255;
    }

    public static long E(Object obj, long j) {
        return ((Long) AbstractC1244ae0.f(obj, j)).longValue();
    }

    public static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static boolean n(Object obj, int i, Zc0 zc0) {
        return zc0.b(AbstractC1244ae0.f(obj, i & 1048575));
    }

    public static zzgz q(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar != zzgz.zza()) {
            return zzgzVar;
        }
        zzgz zzgzVarZzc = zzgz.zzc();
        zzeuVar.zzc = zzgzVarZzc;
        return zzgzVarZzc;
    }

    public static d r(Class cls, InterfaceC4217wc0 interfaceC4217wc0, Pc0 pc0, AbstractC3159jc0 abstractC3159jc0, AbstractC4219wd0 abstractC4219wd0, AbstractC2124eb0 abstractC2124eb0, C3893sc0 c3893sc0) {
        if (interfaceC4217wc0 instanceof Xc0) {
            return s((Xc0) interfaceC4217wc0, pc0, abstractC3159jc0, abstractC4219wd0, abstractC2124eb0, c3893sc0);
        }
        AbstractC3574of.a(interfaceC4217wc0);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0264  */
    /* JADX WARN: Code duplicated, block: B:128:0x027a  */
    /* JADX WARN: Code duplicated, block: B:130:0x027e  */
    /* JADX WARN: Code duplicated, block: B:164:0x0334  */
    /* JADX WARN: Code duplicated, block: B:180:0x0384  */
    /* JADX WARN: Code duplicated, block: B:183:0x038e  */
    public static d s(Xc0 xc0, Pc0 pc0, AbstractC3159jc0 abstractC3159jc0, AbstractC4219wd0 abstractC4219wd0, AbstractC2124eb0 abstractC2124eb0, C3893sc0 c3893sc0) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Object[] objArr;
        int i20;
        int i21;
        Field fieldA;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldA2;
        int i26;
        Object obj2;
        Field fieldA3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        boolean z = xc0.zzc() == 2;
        String strA = xc0.a();
        int length = strA.length();
        char c = 55296;
        if (strA.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (strA.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt4 = strA.charAt(i);
        if (iCharAt4 >= 55296) {
            int i33 = iCharAt4 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                cCharAt13 = strA.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            iCharAt4 = i33 | (cCharAt13 << i34);
            i32 = i30;
        }
        if (iCharAt4 == 0) {
            iArr = o;
            i3 = 0;
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i4 = 0;
            iCharAt3 = 0;
            i2 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt5 = strA.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i13 = i35 + 1;
                    cCharAt8 = strA.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i13;
                }
                iCharAt5 = i36 | (cCharAt8 << i37);
                i35 = i13;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strA.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt7 = strA.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt7 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            iCharAt = strA.charAt(i38);
            if (iCharAt >= 55296) {
                int i42 = iCharAt & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt6 = strA.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt = i42 | (cCharAt6 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            int iCharAt7 = strA.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt5 = strA.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            iCharAt2 = strA.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt4 = strA.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt2 = i48 | (cCharAt4 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strA.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt3 = strA.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt8 = i51 | (cCharAt3 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strA.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt2 = strA.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt9 = i54 | (cCharAt2 << i55);
                i53 = i7;
            }
            int i56 = i53 + 1;
            iCharAt3 = strA.charAt(i53);
            if (iCharAt3 >= 55296) {
                int i57 = iCharAt3 & 8191;
                int i58 = 13;
                while (true) {
                    i6 = i56 + 1;
                    cCharAt = strA.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i56 = i6;
                }
                iCharAt3 = i57 | (cCharAt << i58);
                i56 = i6;
            }
            iArr = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i2 = iCharAt5 + iCharAt5 + iCharAt6;
            i3 = iCharAt5;
            i32 = i56;
            int i59 = iCharAt8;
            i4 = iCharAt7;
            i5 = i59;
        }
        Unsafe unsafe = p;
        Object[] objArrB = xc0.b();
        Class<?> cls = xc0.zza().getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 + iCharAt2];
        int i60 = iCharAt3 + i5;
        int i61 = iCharAt3;
        int i62 = i60;
        int i63 = 0;
        int i64 = 0;
        while (i32 < length) {
            int i65 = i32 + 1;
            int iCharAt10 = strA.charAt(i32);
            if (iCharAt10 >= c) {
                int i66 = iCharAt10 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i29 = i67 + 1;
                    cCharAt12 = strA.charAt(i67);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i66 |= (cCharAt12 & 8191) << i68;
                    i68 += 13;
                    i67 = i29;
                }
                iCharAt10 = i66 | (cCharAt12 << i68);
                i14 = i29;
            } else {
                i14 = i65;
            }
            int i69 = i14 + 1;
            int iCharAt11 = strA.charAt(i14);
            if (iCharAt11 >= c) {
                int i70 = iCharAt11 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i28 = i71 + 1;
                    cCharAt11 = strA.charAt(i71);
                    i15 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i28;
                    length = i15;
                }
                iCharAt11 = i70 | (cCharAt11 << i72);
                i16 = i28;
            } else {
                i15 = length;
                i16 = i69;
            }
            int i73 = iCharAt11 & 255;
            int i74 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i63;
                i64++;
            }
            if (i73 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strA.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i76 = iCharAt12 & 8191;
                    int i77 = i75;
                    int i78 = 13;
                    while (true) {
                        i27 = i77 + 1;
                        cCharAt10 = strA.charAt(i77);
                        i18 = i4;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i76 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i77 = i27;
                        i4 = i18;
                    }
                    iCharAt12 = i76 | (cCharAt10 << i78);
                    i23 = i27;
                } else {
                    i18 = i4;
                    i23 = i75;
                }
                int i79 = i73 - 51;
                int i80 = i23;
                if (i79 == 9 || i79 == 17) {
                    int i81 = i63 / 3;
                    i24 = i2 + 1;
                    objArr2[i81 + i81 + 1] = objArrB[i2];
                } else {
                    if (i79 == 12 && !z) {
                        int i82 = i63 / 3;
                        i24 = i2 + 1;
                        objArr2[i82 + i82 + 1] = objArrB[i2];
                    }
                    i25 = iCharAt12 + iCharAt12;
                    obj = objArrB[i25];
                    if (obj instanceof Field) {
                        fieldA2 = (Field) obj;
                    } else {
                        fieldA2 = a(cls, (String) obj);
                        objArrB[i25] = fieldA2;
                    }
                    iArr2 = iArr3;
                    i17 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldA2);
                    i26 = i25 + 1;
                    obj2 = objArrB[i26];
                    if (obj2 instanceof Field) {
                        fieldA3 = (Field) obj2;
                    } else {
                        fieldA3 = a(cls, (String) obj2);
                        objArrB[i26] = fieldA3;
                    }
                    strA = strA;
                    i3 = i3;
                    objArr = objArr2;
                    i19 = i2;
                    i20 = i80;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = 0;
                }
                i2 = i24;
                i25 = iCharAt12 + iCharAt12;
                obj = objArrB[i25];
                if (obj instanceof Field) {
                    fieldA2 = (Field) obj;
                } else {
                    fieldA2 = a(cls, (String) obj);
                    objArrB[i25] = fieldA2;
                }
                iArr2 = iArr3;
                i17 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldA2);
                i26 = i25 + 1;
                obj2 = objArrB[i26];
                if (obj2 instanceof Field) {
                    fieldA3 = (Field) obj2;
                } else {
                    fieldA3 = a(cls, (String) obj2);
                    objArrB[i26] = fieldA3;
                }
                strA = strA;
                i3 = i3;
                objArr = objArr2;
                i19 = i2;
                i20 = i80;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = 0;
            } else {
                iArr2 = iArr3;
                i17 = iCharAt;
                i18 = i4;
                int i83 = i2 + 1;
                Field fieldA4 = a(cls, (String) objArrB[i2]);
                if (i73 == 9 || i73 == 17) {
                    int i84 = i63 / 3;
                    objArr2[i84 + i84 + 1] = fieldA4.getType();
                } else {
                    if (i73 == 27 || i73 == 49) {
                        int i85 = i63 / 3;
                        i22 = i2 + 2;
                        objArr2[i85 + i85 + 1] = objArrB[i83];
                    } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                        if (!z) {
                            int i86 = i63 / 3;
                            i22 = i2 + 2;
                            objArr2[i86 + i86 + 1] = objArrB[i83];
                        }
                    } else if (i73 == 50) {
                        int i87 = i61 + 1;
                        iArr[i61] = i63;
                        int i88 = i63 / 3;
                        int i89 = i88 + i88;
                        int i90 = i2 + 2;
                        objArr2[i89] = objArrB[i83];
                        if ((iCharAt11 & 2048) != 0) {
                            i83 = i2 + 3;
                            objArr2[i89 + 1] = objArrB[i90];
                            i61 = i87;
                        } else {
                            i61 = i87;
                            i19 = i90;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldA4);
                        iObjectFieldOffset2 = 1048575;
                        objArr = objArr2;
                        if ((iCharAt11 & 4096) == 4096 || i73 > 17) {
                            i20 = i16;
                            i21 = 0;
                        } else {
                            int i91 = i16 + 1;
                            int iCharAt13 = strA.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i92 = iCharAt13 & 8191;
                                int i93 = 13;
                                while (true) {
                                    i20 = i91 + 1;
                                    cCharAt9 = strA.charAt(i91);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i92 |= (cCharAt9 & 8191) << i93;
                                    i93 += 13;
                                    i91 = i20;
                                }
                                iCharAt13 = i92 | (cCharAt9 << i93);
                            } else {
                                i20 = i91;
                            }
                            int i94 = i3 + i3 + (iCharAt13 / 32);
                            Object obj3 = objArrB[i94];
                            if (obj3 instanceof Field) {
                                fieldA = (Field) obj3;
                            } else {
                                fieldA = a(cls, (String) obj3);
                                objArrB[i94] = fieldA;
                            }
                            i21 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA);
                        }
                        if (i73 >= 18 && i73 <= 49) {
                            iArr[i62] = iObjectFieldOffset;
                            i62++;
                        }
                    }
                    i19 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldA4);
                    iObjectFieldOffset2 = 1048575;
                    objArr = objArr2;
                    if ((iCharAt11 & 4096) == 4096) {
                        i20 = i16;
                        i21 = 0;
                    } else {
                        i20 = i16;
                        i21 = 0;
                    }
                    if (i73 >= 18) {
                        iArr[i62] = iObjectFieldOffset;
                        i62++;
                    }
                }
                i19 = i83;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldA4);
                iObjectFieldOffset2 = 1048575;
                objArr = objArr2;
                if ((iCharAt11 & 4096) == 4096) {
                    i20 = i16;
                    i21 = 0;
                } else {
                    i20 = i16;
                    i21 = 0;
                }
                if (i73 >= 18) {
                    iArr[i62] = iObjectFieldOffset;
                    i62++;
                }
            }
            int i95 = i63 + 1;
            iArr2[i63] = iCharAt10;
            int i96 = i63 + 2;
            iArr2[i95] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | (i73 << 20) | iObjectFieldOffset;
            i63 += 3;
            iArr2[i96] = (i21 << 20) | iObjectFieldOffset2;
            i3 = i3;
            i2 = i19;
            iCharAt = i17;
            iCharAt3 = i74;
            i32 = i20;
            length = i15;
            objArr2 = objArr;
            strA = strA;
            iArr3 = iArr2;
            i4 = i18;
            c = 55296;
        }
        return new d(iArr3, objArr2, iCharAt, i4, xc0.zza(), z, false, iArr, iCharAt3, i60, pc0, abstractC3159jc0, abstractC4219wd0, abstractC2124eb0, c3893sc0, null);
    }

    public static int t(Object obj, long j) {
        return ((Integer) AbstractC1244ae0.f(obj, j)).intValue();
    }

    public final int A(int i) {
        return this.a[i + 2];
    }

    public final int B(int i, int i2) {
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

    public final int D(int i) {
        return this.a[i + 1];
    }

    public final zzex F(int i) {
        int i2 = i / 3;
        return (zzex) this.b[i2 + i2 + 1];
    }

    public final Zc0 G(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Zc0 zc0 = (Zc0) this.b[i3];
        if (zc0 != null) {
            return zc0;
        }
        Zc0 zc0B = Uc0.a().b((Class) this.b[i3 + 1]);
        this.b[i3] = zc0B;
        return zc0B;
    }

    public final Object H(int i) {
        int i2 = i / 3;
        return this.b[i2 + i2];
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c2 A[LOOP:1: B:45:0x00b1->B:50:0x00c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00df A[SYNTHETIC] */
    @Override // defpackage.Zc0
    public final boolean b(Object obj) {
        int i;
        int i2;
        List list;
        Zc0 zc0G;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.h) {
            int i7 = this.g[i6];
            int i8 = this.a[i7];
            int iD = D(i7);
            int i9 = this.a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = p.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iD) != 0 && !m(obj, i7, i, i2, i11)) {
                return false;
            }
            int iC = C(iD);
            if (iC == 9 || iC == 17) {
                if (m(obj, i7, i, i2, i11) && !n(obj, iD, G(i7))) {
                    return false;
                }
            } else if (iC == 27) {
                list = (List) AbstractC1244ae0.f(obj, iD & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zc0G = G(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zc0G.b(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iC == 60 || iC == 68) {
                if (o(obj, i8, i7) && !n(obj, iD, G(i7))) {
                    return false;
                }
            } else if (iC == 49) {
                list = (List) AbstractC1244ae0.f(obj, iD & 1048575);
                if (list.isEmpty()) {
                    zc0G = G(i7);
                    while (i3 < list.size()) {
                        if (!zc0G.b(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iC == 50 && !((zzfq) AbstractC1244ae0.f(obj, iD & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return true;
    }

    @Override // defpackage.Zc0
    public final void c(Object obj) {
        int i;
        int i2 = this.h;
        while (true) {
            i = this.i;
            if (i2 >= i) {
                break;
            }
            long jD = D(this.g[i2]) & 1048575;
            Object objF = AbstractC1244ae0.f(obj, jD);
            if (objF != null) {
                ((zzfq) objF).zzc();
                AbstractC1244ae0.p(obj, jD, objF);
            }
            i2++;
        }
        int length = this.g.length;
        while (i < length) {
            this.j.a(obj, this.g[i]);
            i++;
        }
        this.k.e(obj);
    }

    @Override // defpackage.Zc0
    public final void d(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            int iD = D(i);
            long j = 1048575 & iD;
            int i2 = this.a[i];
            switch (C(iD)) {
                case 0:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.l(obj, j, AbstractC1244ae0.a(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 1:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.m(obj, j, AbstractC1244ae0.b(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 2:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.o(obj, j, AbstractC1244ae0.d(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 3:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.o(obj, j, AbstractC1244ae0.d(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 4:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.n(obj, j, AbstractC1244ae0.c(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 5:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.o(obj, j, AbstractC1244ae0.d(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 6:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.n(obj, j, AbstractC1244ae0.c(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 7:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.k(obj, j, AbstractC1244ae0.t(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 8:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.p(obj, j, AbstractC1244ae0.f(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 9:
                    g(obj, obj2, i);
                    break;
                case 10:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.p(obj, j, AbstractC1244ae0.f(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 11:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.n(obj, j, AbstractC1244ae0.c(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 12:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.n(obj, j, AbstractC1244ae0.c(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 13:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.n(obj, j, AbstractC1244ae0.c(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 14:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.o(obj, j, AbstractC1244ae0.d(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 15:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.n(obj, j, AbstractC1244ae0.c(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 16:
                    if (l(obj2, i)) {
                        AbstractC1244ae0.o(obj, j, AbstractC1244ae0.d(obj2, j));
                        i(obj, i);
                    }
                    break;
                case 17:
                    g(obj, obj2, i);
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
                    this.j.b(obj, obj2, j);
                    break;
                case 50:
                    AbstractC2047dd0.i(this.n, obj, obj2, j);
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
                    if (o(obj2, i2, i)) {
                        AbstractC1244ae0.p(obj, j, AbstractC1244ae0.f(obj2, j));
                        j(obj, i2, i);
                    }
                    break;
                case 60:
                    h(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (o(obj2, i2, i)) {
                        AbstractC1244ae0.p(obj, j, AbstractC1244ae0.f(obj2, j));
                        j(obj, i2, i);
                    }
                    break;
                case 68:
                    h(obj, obj2, i);
                    break;
            }
        }
        AbstractC2047dd0.f(this.k, obj, obj2);
    }

    @Override // defpackage.Zc0
    public final void e(Object obj, byte[] bArr, int i, int i2, C1883ca0 c1883ca0) throws zzfa {
        if (this.f) {
            w(obj, bArr, i, i2, c1883ca0);
        } else {
            p(obj, bArr, i, i2, 0, c1883ca0);
        }
    }

    @Override // defpackage.Zc0
    public final boolean f(Object obj, Object obj2) {
        boolean zH;
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            int iD = D(i);
            long j = iD & 1048575;
            switch (C(iD)) {
                case 0:
                    if (!k(obj, obj2, i) || Double.doubleToLongBits(AbstractC1244ae0.a(obj, j)) != Double.doubleToLongBits(AbstractC1244ae0.a(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!k(obj, obj2, i) || Float.floatToIntBits(AbstractC1244ae0.b(obj, j)) != Float.floatToIntBits(AbstractC1244ae0.b(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.d(obj, j) != AbstractC1244ae0.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.d(obj, j) != AbstractC1244ae0.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.c(obj, j) != AbstractC1244ae0.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.d(obj, j) != AbstractC1244ae0.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.c(obj, j) != AbstractC1244ae0.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.t(obj, j) != AbstractC1244ae0.t(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!k(obj, obj2, i) || !AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!k(obj, obj2, i) || !AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!k(obj, obj2, i) || !AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.c(obj, j) != AbstractC1244ae0.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.c(obj, j) != AbstractC1244ae0.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.c(obj, j) != AbstractC1244ae0.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.d(obj, j) != AbstractC1244ae0.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.c(obj, j) != AbstractC1244ae0.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!k(obj, obj2, i) || AbstractC1244ae0.d(obj, j) != AbstractC1244ae0.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!k(obj, obj2, i) || !AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
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
                    zH = AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j));
                    break;
                case 50:
                    zH = AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j));
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
                    long jA = A(i) & 1048575;
                    if (AbstractC1244ae0.c(obj, jA) != AbstractC1244ae0.c(obj2, jA) || !AbstractC2047dd0.h(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zH) {
                return false;
            }
        }
        return this.k.a(obj).equals(this.k.a(obj2));
    }

    public final void g(Object obj, Object obj2, int i) {
        long jD = D(i) & 1048575;
        if (l(obj2, i)) {
            Object objF = AbstractC1244ae0.f(obj, jD);
            Object objF2 = AbstractC1244ae0.f(obj2, jD);
            if (objF != null && objF2 != null) {
                AbstractC1244ae0.p(obj, jD, zzez.zzg(objF, objF2));
                i(obj, i);
            } else if (objF2 != null) {
                AbstractC1244ae0.p(obj, jD, objF2);
                i(obj, i);
            }
        }
    }

    public final void h(Object obj, Object obj2, int i) {
        int iD = D(i);
        int i2 = this.a[i];
        long j = iD & 1048575;
        if (o(obj2, i2, i)) {
            Object objF = o(obj, i2, i) ? AbstractC1244ae0.f(obj, j) : null;
            Object objF2 = AbstractC1244ae0.f(obj2, j);
            if (objF != null && objF2 != null) {
                AbstractC1244ae0.p(obj, j, zzez.zzg(objF, objF2));
                j(obj, i2, i);
            } else if (objF2 != null) {
                AbstractC1244ae0.p(obj, j, objF2);
                j(obj, i2, i);
            }
        }
    }

    public final void i(Object obj, int i) {
        int iA = A(i);
        long j = 1048575 & iA;
        if (j == 1048575) {
            return;
        }
        AbstractC1244ae0.n(obj, j, (1 << (iA >>> 20)) | AbstractC1244ae0.c(obj, j));
    }

    public final void j(Object obj, int i, int i2) {
        AbstractC1244ae0.n(obj, A(i2) & 1048575, i);
    }

    public final boolean k(Object obj, Object obj2, int i) {
        return l(obj, i) == l(obj2, i);
    }

    public final boolean l(Object obj, int i) {
        int iA = A(i);
        long j = iA & 1048575;
        if (j != 1048575) {
            return (AbstractC1244ae0.c(obj, j) & (1 << (iA >>> 20))) != 0;
        }
        int iD = D(i);
        long j2 = iD & 1048575;
        switch (C(iD)) {
            case 0:
                return Double.doubleToRawLongBits(AbstractC1244ae0.a(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(AbstractC1244ae0.b(obj, j2)) != 0;
            case 2:
                return AbstractC1244ae0.d(obj, j2) != 0;
            case 3:
                return AbstractC1244ae0.d(obj, j2) != 0;
            case 4:
                return AbstractC1244ae0.c(obj, j2) != 0;
            case 5:
                return AbstractC1244ae0.d(obj, j2) != 0;
            case 6:
                return AbstractC1244ae0.c(obj, j2) != 0;
            case 7:
                return AbstractC1244ae0.t(obj, j2);
            case 8:
                Object objF = AbstractC1244ae0.f(obj, j2);
                if (objF instanceof String) {
                    return !((String) objF).isEmpty();
                }
                if (objF instanceof zzee) {
                    return !zzee.zzb.equals(objF);
                }
                throw new IllegalArgumentException();
            case 9:
                return AbstractC1244ae0.f(obj, j2) != null;
            case 10:
                return !zzee.zzb.equals(AbstractC1244ae0.f(obj, j2));
            case 11:
                return AbstractC1244ae0.c(obj, j2) != 0;
            case 12:
                return AbstractC1244ae0.c(obj, j2) != 0;
            case 13:
                return AbstractC1244ae0.c(obj, j2) != 0;
            case 14:
                return AbstractC1244ae0.d(obj, j2) != 0;
            case 15:
                return AbstractC1244ae0.c(obj, j2) != 0;
            case 16:
                return AbstractC1244ae0.d(obj, j2) != 0;
            case 17:
                return AbstractC1244ae0.f(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean m(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return l(obj, i);
        }
        return (i3 & i4) != 0;
    }

    public final boolean o(Object obj, int i, int i2) {
        return AbstractC1244ae0.c(obj, (long) (A(i2) & 1048575)) == i;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0362 A[PHI: r0 r19 r28
      0x0362: PHI (r0v23 int) = (r0v18 int), (r0v21 int), (r0v25 int) binds: [B:130:0x03d3, B:126:0x03b2, B:116:0x0360] A[DONT_GENERATE, DONT_INLINE]
      0x0362: PHI (r19v2 int) = (r19v0 int), (r19v0 int), (r19v3 int) binds: [B:130:0x03d3, B:126:0x03b2, B:116:0x0360] A[DONT_GENERATE, DONT_INLINE]
      0x0362: PHI (r28v7 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:130:0x03d3, B:126:0x03b2, B:116:0x0360] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x037a A[PHI: r0 r19 r28
      0x037a: PHI (r0v22 int) = (r0v18 int), (r0v21 int), (r0v25 int) binds: [B:130:0x03d3, B:126:0x03b2, B:116:0x0360] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r19v1 int) = (r19v0 int), (r19v0 int), (r19v3 int) binds: [B:130:0x03d3, B:126:0x03b2, B:116:0x0360] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r28v6 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:130:0x03d3, B:126:0x03b2, B:116:0x0360] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0082. Please report as an issue. */
    public final int p(Object obj, byte[] bArr, int i, int i2, int i3, C1883ca0 c1883ca0) throws zzfa {
        Unsafe unsafe;
        Object obj2;
        int i4;
        int iK;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        c1883ca0 = c1883ca0;
        Unsafe unsafe2 = p;
        int i17 = -1;
        int i18 = i;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        int i23 = 1048575;
        while (true) {
            if (i18 < i2) {
                int i24 = i18 + 1;
                byte b = bArr[i18];
                if (b < 0) {
                    iK = a.k(b, bArr, i24, c1883ca0);
                    i4 = c1883ca0.a;
                } else {
                    i4 = b;
                    iK = i24;
                }
                int i25 = i4 >>> 3;
                int i26 = i4 & 7;
                int iZ = i25 > i20 ? this.z(i25, i21 / 3) : this.y(i25);
                if (iZ == i17) {
                    i3 = i3;
                    i5 = i25;
                    i6 = iK;
                    unsafe = unsafe2;
                    i7 = 0;
                    i8 = i4;
                } else {
                    int[] iArr = this.a;
                    int i27 = iArr[iZ + 1];
                    int iC = C(i27);
                    int i28 = i4;
                    long j = i27 & 1048575;
                    if (iC <= 17) {
                        int i29 = iArr[iZ + 2];
                        int i30 = 1 << (i29 >>> 20);
                        int i31 = i29 & 1048575;
                        if (i31 != i23) {
                            if (i23 != 1048575) {
                                unsafe2.putInt(obj, i23, i22);
                            }
                            i22 = unsafe2.getInt(obj, i31);
                            i23 = i31;
                        }
                        switch (iC) {
                            case 0:
                                i5 = i25;
                                i12 = iZ;
                                i13 = iK;
                                i14 = i23;
                                i15 = i28;
                                bArr = bArr;
                                if (i26 == 1) {
                                    AbstractC1244ae0.l(obj, j, Double.longBitsToDouble(a.n(bArr, i13)));
                                    i18 = i13 + 8;
                                    i22 |= i30;
                                    i23 = i14;
                                    i21 = i12;
                                    i19 = i15;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 1:
                                i5 = i25;
                                i12 = iZ;
                                i13 = iK;
                                i14 = i23;
                                i15 = i28;
                                bArr = bArr;
                                if (i26 == 5) {
                                    AbstractC1244ae0.m(obj, j, Float.intBitsToFloat(a.b(bArr, i13)));
                                    i18 = i13 + 4;
                                    i22 |= i30;
                                    i23 = i14;
                                    i21 = i12;
                                    i19 = i15;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 2:
                            case 3:
                                i5 = i25;
                                i12 = iZ;
                                i13 = iK;
                                i14 = i23;
                                i15 = i28;
                                bArr = bArr;
                                i2 = i2;
                                if (i26 == 0) {
                                    int iM = a.m(bArr, i13, c1883ca0);
                                    unsafe2.putLong(obj, j, c1883ca0.b);
                                    i22 |= i30;
                                    i23 = i14;
                                    i21 = i12;
                                    i19 = i15;
                                    i18 = iM;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 4:
                            case 11:
                                i5 = i25;
                                i12 = iZ;
                                i13 = iK;
                                i14 = i23;
                                i15 = i28;
                                bArr = bArr;
                                if (i26 == 0) {
                                    i18 = a.j(bArr, i13, c1883ca0);
                                    unsafe2.putInt(obj, j, c1883ca0.a);
                                    i22 |= i30;
                                    i23 = i14;
                                    i21 = i12;
                                    i19 = i15;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 5:
                            case 14:
                                i5 = i25;
                                i12 = iZ;
                                i14 = i23;
                                i15 = i28;
                                bArr = bArr;
                                if (i26 == 1) {
                                    unsafe2.putLong(obj, j, a.n(bArr, iK));
                                    i18 = iK + 8;
                                    i22 |= i30;
                                    i23 = i14;
                                    i21 = i12;
                                    i19 = i15;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 6:
                            case 13:
                                i5 = i25;
                                i12 = iZ;
                                i14 = i23;
                                i15 = i28;
                                bArr = bArr;
                                if (i26 == 5) {
                                    unsafe2.putInt(obj, j, a.b(bArr, iK));
                                    i18 = iK + 4;
                                    i22 |= i30;
                                    i23 = i14;
                                    i21 = i12;
                                    i19 = i15;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 7:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                bArr = bArr;
                                i2 = i2;
                                if (i26 == 0) {
                                    i18 = a.m(bArr, iK, c1883ca0);
                                    AbstractC1244ae0.k(obj, j, c1883ca0.b != 0);
                                    i22 |= i30;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i14 = i23;
                                i15 = i16;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 8:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                bArr = bArr;
                                i2 = i2;
                                if (i26 == 2) {
                                    i18 = (i27 & PropertyOptions.DELETE_EXISTING) == 0 ? a.g(bArr, iK, c1883ca0) : a.h(bArr, iK, c1883ca0);
                                    unsafe2.putObject(obj, j, c1883ca0.c);
                                    i22 |= i30;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i14 = i23;
                                i15 = i16;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 9:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                bArr = bArr;
                                if (i26 == 2) {
                                    i2 = i2;
                                    i18 = a.d(this.G(i12), bArr, iK, i2, c1883ca0);
                                    if ((i22 & i30) == 0) {
                                        unsafe2.putObject(obj, j, c1883ca0.c);
                                    } else {
                                        unsafe2.putObject(obj, j, zzez.zzg(unsafe2.getObject(obj, j), c1883ca0.c));
                                    }
                                    i22 |= i30;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i14 = i23;
                                i15 = i16;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 10:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                bArr = bArr;
                                if (i26 == 2) {
                                    i18 = a.a(bArr, iK, c1883ca0);
                                    unsafe2.putObject(obj, j, c1883ca0.c);
                                    i22 |= i30;
                                    i2 = i2;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i14 = i23;
                                i15 = i16;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 12:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                bArr = bArr;
                                if (i26 == 0) {
                                    i18 = a.j(bArr, iK, c1883ca0);
                                    int i32 = c1883ca0.a;
                                    zzex zzexVarF = this.F(i12);
                                    if (zzexVarF == null || zzexVarF.zza()) {
                                        unsafe2.putInt(obj, j, i32);
                                        i22 |= i30;
                                    } else {
                                        q(obj).zzf(i16, Long.valueOf(i32));
                                    }
                                    i2 = i2;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i14 = i23;
                                i15 = i16;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 15:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                bArr = bArr;
                                if (i26 == 0) {
                                    i18 = a.j(bArr, iK, c1883ca0);
                                    unsafe2.putInt(obj, j, zzei.zzb(c1883ca0.a));
                                    i22 |= i30;
                                    i2 = i2;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                }
                                i13 = iK;
                                i14 = i23;
                                i15 = i16;
                                i23 = i14;
                                i3 = i3;
                                i6 = i13;
                                unsafe = unsafe2;
                                i7 = i12;
                                i8 = i15;
                                break;
                            case 16:
                                i5 = i25;
                                i12 = iZ;
                                i16 = i28;
                                if (i26 == 0) {
                                    bArr = bArr;
                                    int iM2 = a.m(bArr, iK, c1883ca0);
                                    unsafe2.putLong(obj, j, zzei.zzc(c1883ca0.b));
                                    i22 |= i30;
                                    i19 = i16;
                                    i21 = i12;
                                    i18 = iM2;
                                    i20 = i5;
                                    i17 = -1;
                                    i2 = i2;
                                } else {
                                    i13 = iK;
                                    i14 = i23;
                                    i15 = i16;
                                    i23 = i14;
                                    i3 = i3;
                                    i6 = i13;
                                    unsafe = unsafe2;
                                    i7 = i12;
                                    i8 = i15;
                                }
                                break;
                            default:
                                if (i26 == 3) {
                                    i5 = i25;
                                    i12 = iZ;
                                    i16 = i28;
                                    i18 = a.c(this.G(iZ), bArr, iK, i2, (i25 << 3) | 4, c1883ca0);
                                    if ((i22 & i30) == 0) {
                                        unsafe2.putObject(obj, j, c1883ca0.c);
                                    } else {
                                        unsafe2.putObject(obj, j, zzez.zzg(unsafe2.getObject(obj, j), c1883ca0.c));
                                    }
                                    i22 |= i30;
                                    bArr = bArr;
                                    i2 = i2;
                                    i19 = i16;
                                    i21 = i12;
                                    i20 = i5;
                                    i17 = -1;
                                } else {
                                    i5 = i25;
                                    i12 = iZ;
                                    i16 = i28;
                                    i13 = iK;
                                    i14 = i23;
                                    i15 = i16;
                                    i23 = i14;
                                    i3 = i3;
                                    i6 = i13;
                                    unsafe = unsafe2;
                                    i7 = i12;
                                    i8 = i15;
                                }
                                break;
                        }
                    } else {
                        i5 = i25;
                        int i33 = iK;
                        int i34 = i23;
                        bArr = bArr;
                        i2 = i2;
                        if (iC == 27) {
                            if (i26 == 2) {
                                zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj, j);
                                if (!zzeyVarZzd.zzc()) {
                                    int size = zzeyVarZzd.size();
                                    zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                    unsafe2.putObject(obj, j, zzeyVarZzd);
                                }
                                i19 = i28;
                                i18 = a.e(this.G(iZ), i19, bArr, i33, i2, zzeyVarZzd, c1883ca0);
                                i23 = i34;
                                i20 = i5;
                                i21 = iZ;
                                i22 = i22;
                            } else {
                                i7 = iZ;
                                i9 = i22;
                                i10 = i33;
                                unsafe = unsafe2;
                                i11 = i28;
                            }
                            i17 = -1;
                        } else {
                            i7 = iZ;
                            i9 = i22;
                            if (iC <= 49) {
                                i11 = i28;
                                unsafe = unsafe2;
                                i18 = x(obj, bArr, i33, i2, i28, i5, i26, i7, i27, iC, j, c1883ca0);
                                if (i18 != i33) {
                                    i19 = i11;
                                    i23 = i34;
                                    i20 = i5;
                                    i21 = i7;
                                    i22 = i9;
                                } else {
                                    i6 = i18;
                                    i8 = i11;
                                    i23 = i34;
                                    i22 = i9;
                                }
                                unsafe2 = unsafe;
                            } else {
                                i10 = i33;
                                unsafe = unsafe2;
                                i11 = i28;
                                if (iC == 50) {
                                    if (i26 == 2) {
                                        i18 = u(obj, bArr, i10, i2, i7, j, c1883ca0);
                                        if (i18 != i10) {
                                            i19 = i11;
                                            i23 = i34;
                                            i20 = i5;
                                            i21 = i7;
                                            i22 = i9;
                                        } else {
                                            i6 = i18;
                                        }
                                        unsafe2 = unsafe;
                                    }
                                    i8 = i11;
                                    i23 = i34;
                                    i22 = i9;
                                } else {
                                    i18 = v(obj, bArr, i10, i2, i11, i5, i26, i27, iC, j, i7, c1883ca0);
                                    if (i18 != i10) {
                                        i19 = i11;
                                        i23 = i34;
                                        i20 = i5;
                                        i21 = i7;
                                        i22 = i9;
                                    } else {
                                        i6 = i18;
                                        i8 = i11;
                                        i23 = i34;
                                        i22 = i9;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                            i17 = -1;
                        }
                        i6 = i10;
                        i8 = i11;
                        i23 = i34;
                        i22 = i9;
                    }
                }
                if (i8 != i3 || i3 == 0) {
                    i18 = a.i(i8, bArr, i6, i2, q(obj), c1883ca0);
                    i19 = i8;
                    i20 = i5;
                    i21 = i7;
                    unsafe2 = unsafe;
                    i17 = -1;
                } else {
                    i18 = i6;
                    i19 = i8;
                }
            } else {
                i3 = i3;
                unsafe = unsafe2;
            }
        }
        if (i23 != 1048575) {
            obj2 = obj;
            unsafe.putInt(obj2, i23, i22);
        } else {
            obj2 = obj;
        }
        for (int i35 = this.h; i35 < this.i; i35++) {
            int i36 = this.g[i35];
            int i37 = this.a[i36];
            Object objF = AbstractC1244ae0.f(obj2, D(i36) & 1048575);
            if (objF != null && F(i36) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (i18 != i2) {
                throw zzfa.zzd();
            }
        } else if (i18 > i2 || i19 != i3) {
            throw zzfa.zzd();
        }
        return i18;
    }

    public final int u(Object obj, byte[] bArr, int i, int i2, int i3, long j, C1883ca0 c1883ca0) {
        Unsafe unsafe = p;
        Object objH = H(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzfq) object).zze()) {
            zzfq zzfqVarZzb = zzfq.zza().zzb();
            C3893sc0.a(zzfqVarZzb, object);
            unsafe.putObject(obj, j, zzfqVarZzb);
        }
        throw null;
    }

    public final int v(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C1883ca0 c1883ca0) throws zzfa {
        Unsafe unsafe = p;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(a.n(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(a.b(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iM = a.m(bArr, i, c1883ca0);
                unsafe.putObject(obj, j, Long.valueOf(c1883ca0.b));
                unsafe.putInt(obj, j2, i4);
                return iM;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iJ = a.j(bArr, i, c1883ca0);
                unsafe.putObject(obj, j, Integer.valueOf(c1883ca0.a));
                unsafe.putInt(obj, j2, i4);
                return iJ;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(a.n(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(a.b(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iM2 = a.m(bArr, i, c1883ca0);
                unsafe.putObject(obj, j, Boolean.valueOf(c1883ca0.b != 0));
                unsafe.putInt(obj, j2, i4);
                return iM2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iJ2 = a.j(bArr, i, c1883ca0);
                int i9 = c1883ca0.a;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & PropertyOptions.DELETE_EXISTING) != 0 && !AbstractC3245ke0.d(bArr, iJ2, iJ2 + i9)) {
                        throw zzfa.zzb();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iJ2, i9, zzez.zzb));
                    iJ2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iJ2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iD = a.d(G(i8), bArr, i, i2, c1883ca0);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, c1883ca0.c);
                } else {
                    unsafe.putObject(obj, j, zzez.zzg(object, c1883ca0.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iD;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iA = a.a(bArr, i, c1883ca0);
                unsafe.putObject(obj, j, c1883ca0.c);
                unsafe.putInt(obj, j2, i4);
                return iA;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iJ3 = a.j(bArr, i, c1883ca0);
                int i10 = c1883ca0.a;
                zzex zzexVarF = F(i8);
                if (zzexVarF == null || zzexVarF.zza()) {
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    q(obj).zzf(i3, Long.valueOf(i10));
                }
                return iJ3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iJ4 = a.j(bArr, i, c1883ca0);
                unsafe.putObject(obj, j, Integer.valueOf(zzei.zzb(c1883ca0.a)));
                unsafe.putInt(obj, j2, i4);
                return iJ4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iM3 = a.m(bArr, i, c1883ca0);
                unsafe.putObject(obj, j, Long.valueOf(zzei.zzc(c1883ca0.b)));
                unsafe.putInt(obj, j2, i4);
                return iM3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iC = a.c(G(i8), bArr, i, i2, (i3 & (-8)) | 4, c1883ca0);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, c1883ca0.c);
                } else {
                    unsafe.putObject(obj, j, zzez.zzg(object2, c1883ca0.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iC;
            default:
                return i;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0082. Please report as an issue. */
    public final int w(Object obj, byte[] bArr, int i, int i2, C1883ca0 c1883ca0) throws zzfa {
        int i3;
        int iK;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int iM;
        int iD;
        int i9;
        int i10;
        int i11;
        d dVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i12 = i2;
        c1883ca0 = c1883ca0;
        Unsafe unsafe2 = p;
        int i13 = 1048575;
        int i14 = -1;
        int i15 = i;
        int i16 = -1;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1048575;
        while (i15 < i12) {
            int i20 = i15 + 1;
            byte b = bArr2[i15];
            if (b < 0) {
                iK = a.k(b, bArr2, i20, c1883ca0);
                i3 = c1883ca0.a;
            } else {
                i3 = b;
                iK = i20;
            }
            int i21 = i3 >>> 3;
            int i22 = i3 & 7;
            int iZ = i21 > i16 ? dVar.z(i21, i17 / 3) : dVar.y(i21);
            if (iZ == i14) {
                i4 = iK;
                i5 = i21;
                unsafe = unsafe2;
                i6 = 0;
            } else {
                int[] iArr = dVar.a;
                int i23 = iArr[iZ + 1];
                int iC = C(i23);
                long j = i23 & i13;
                if (iC <= 17) {
                    int i24 = iArr[iZ + 2];
                    int i25 = 1 << (i24 >>> 20);
                    int i26 = i24 & 1048575;
                    if (i26 != i19) {
                        if (i19 != 1048575) {
                            unsafe2.putInt(obj2, i19, i18);
                        }
                        if (i26 != 1048575) {
                            i18 = unsafe2.getInt(obj2, i26);
                        }
                        i19 = i26;
                    }
                    switch (iC) {
                        case 0:
                            i7 = iZ;
                            i8 = iK;
                            i5 = i21;
                            if (i22 == 1) {
                                AbstractC1244ae0.l(obj2, j, Double.longBitsToDouble(a.n(bArr2, i8)));
                                i15 = i8 + 8;
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 1:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i8 = iK;
                            i5 = i21;
                            if (i22 == 5) {
                                AbstractC1244ae0.m(obj2, j, Float.intBitsToFloat(a.b(bArr2, i8)));
                                i15 = i8 + 4;
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 2:
                        case 3:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i8 = iK;
                            i5 = i21;
                            if (i22 == 0) {
                                iM = a.m(bArr2, i8, c1883ca0);
                                unsafe2.putLong(obj, j, c1883ca0.b);
                                i18 |= i25;
                                i15 = iM;
                                i17 = i7;
                                i16 = i5;
                            }
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 4:
                        case 11:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i8 = iK;
                            i5 = i21;
                            if (i22 == 0) {
                                i15 = a.j(bArr2, i8, c1883ca0);
                                unsafe2.putInt(obj2, j, c1883ca0.a);
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 5:
                        case 14:
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 1) {
                                i8 = iK;
                                unsafe2.putLong(obj, j, a.n(bArr2, iK));
                                i15 = i8 + 8;
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 6:
                        case 13:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 5) {
                                unsafe2.putInt(obj2, j, a.b(bArr2, iK));
                                i15 = iK + 4;
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 7:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 0) {
                                i15 = a.m(bArr2, iK, c1883ca0);
                                AbstractC1244ae0.k(obj2, j, c1883ca0.b != 0);
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 8:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 2) {
                                i15 = (536870912 & i23) == 0 ? a.g(bArr2, iK, c1883ca0) : a.h(bArr2, iK, c1883ca0);
                                unsafe2.putObject(obj2, j, c1883ca0.c);
                                i18 |= i25;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 9:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 2) {
                                iD = a.d(dVar.G(i7), bArr2, iK, i12, c1883ca0);
                                Object object = unsafe2.getObject(obj2, j);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j, c1883ca0.c);
                                } else {
                                    unsafe2.putObject(obj2, j, zzez.zzg(object, c1883ca0.c));
                                }
                                i18 |= i25;
                                i15 = iD;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 10:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 2) {
                                iD = a.a(bArr2, iK, c1883ca0);
                                unsafe2.putObject(obj2, j, c1883ca0.c);
                                i18 |= i25;
                                i15 = iD;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 12:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 0) {
                                iD = a.j(bArr2, iK, c1883ca0);
                                unsafe2.putInt(obj2, j, c1883ca0.a);
                                i18 |= i25;
                                i15 = iD;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 15:
                            c1883ca0 = c1883ca0;
                            i7 = iZ;
                            i5 = i21;
                            if (i22 == 0) {
                                iD = a.j(bArr2, iK, c1883ca0);
                                unsafe2.putInt(obj2, j, zzei.zzb(c1883ca0.a));
                                i18 |= i25;
                                i15 = iD;
                                i17 = i7;
                                i16 = i5;
                            }
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                        case 16:
                            if (i22 != 0) {
                                i5 = i21;
                                i7 = iZ;
                                i8 = iK;
                                i4 = i8;
                                unsafe = unsafe2;
                                i6 = i7;
                            } else {
                                c1883ca0 = c1883ca0;
                                iM = a.m(bArr2, iK, c1883ca0);
                                i7 = iZ;
                                i5 = i21;
                                unsafe2.putLong(obj, j, zzei.zzc(c1883ca0.b));
                                i18 |= i25;
                                i15 = iM;
                                i17 = i7;
                                i16 = i5;
                            }
                            break;
                        default:
                            i5 = i21;
                            i7 = iZ;
                            i8 = iK;
                            i4 = i8;
                            unsafe = unsafe2;
                            i6 = i7;
                            break;
                    }
                    i14 = -1;
                    i13 = 1048575;
                } else {
                    c1883ca0 = c1883ca0;
                    i7 = iZ;
                    int i27 = iK;
                    i5 = i21;
                    if (iC == 27) {
                        if (i22 == 2) {
                            zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj2, j);
                            if (!zzeyVarZzd.zzc()) {
                                int size = zzeyVarZzd.size();
                                zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj2, j, zzeyVarZzd);
                            }
                            i15 = a.e(dVar.G(i7), i3, bArr, i27, i2, zzeyVarZzd, c1883ca0);
                            i18 = i18;
                            i17 = i7;
                            i16 = i5;
                            i14 = -1;
                            i13 = 1048575;
                        } else {
                            i9 = i27;
                            i10 = i18;
                            i11 = i19;
                            unsafe = unsafe2;
                            i6 = i7;
                        }
                    } else if (iC <= 49) {
                        i10 = i18;
                        i11 = i19;
                        unsafe = unsafe2;
                        i6 = i7;
                        i15 = x(obj, bArr, i27, i2, i3, i5, i22, i7, i23, iC, j, c1883ca0);
                        if (i15 != i27) {
                            obj2 = obj;
                            bArr2 = bArr;
                            i12 = i2;
                            c1883ca0 = c1883ca0;
                            i19 = i11;
                            i16 = i5;
                            i18 = i10;
                            i17 = i6;
                            unsafe2 = unsafe;
                            i14 = -1;
                            i13 = 1048575;
                            dVar = this;
                        } else {
                            i4 = i15;
                            i19 = i11;
                            i18 = i10;
                        }
                    } else {
                        i9 = i27;
                        i10 = i18;
                        i11 = i19;
                        unsafe = unsafe2;
                        i6 = i7;
                        if (iC != 50) {
                            i15 = v(obj, bArr, i9, i2, i3, i5, i22, i23, iC, j, i6, c1883ca0);
                            if (i15 != i9) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i12 = i2;
                                c1883ca0 = c1883ca0;
                                i19 = i11;
                                i16 = i5;
                                i18 = i10;
                                i17 = i6;
                                unsafe2 = unsafe;
                                i14 = -1;
                                i13 = 1048575;
                                dVar = this;
                            } else {
                                i4 = i15;
                                i19 = i11;
                                i18 = i10;
                            }
                        } else if (i22 == 2) {
                            i15 = u(obj, bArr, i9, i2, i6, j, c1883ca0);
                            if (i15 != i9) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i12 = i2;
                                c1883ca0 = c1883ca0;
                                i19 = i11;
                                i16 = i5;
                                i18 = i10;
                                i17 = i6;
                                unsafe2 = unsafe;
                                i14 = -1;
                                i13 = 1048575;
                                dVar = this;
                            } else {
                                i4 = i15;
                                i19 = i11;
                                i18 = i10;
                            }
                        }
                    }
                    i4 = i9;
                    i19 = i11;
                    i18 = i10;
                }
            }
            i15 = a.i(i3, bArr, i4, i2, q(obj), c1883ca0);
            dVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i12 = i2;
            c1883ca0 = c1883ca0;
            i16 = i5;
            i17 = i6;
            unsafe2 = unsafe;
            i14 = -1;
            i13 = 1048575;
        }
        int i28 = i18;
        int i29 = i19;
        Unsafe unsafe3 = unsafe2;
        if (i29 != 1048575) {
            unsafe3.putInt(obj, i29, i28);
        }
        if (i15 == i2) {
            return i15;
        }
        throw zzfa.zzd();
    }

    public final int x(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C1883ca0 c1883ca0) throws zzfa {
        int iL;
        int iJ = i;
        Unsafe unsafe = p;
        zzey zzeyVarZzd = (zzey) unsafe.getObject(obj, j2);
        if (!zzeyVarZzd.zzc()) {
            int size = zzeyVarZzd.size();
            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzeyVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ2 = a.j(bArr, iJ, c1883ca0);
                    int i8 = c1883ca0.a + iJ2;
                    if (iJ2 < i8) {
                        Double.longBitsToDouble(a.n(bArr, iJ2));
                        throw null;
                    }
                    if (iJ2 == i8) {
                        return iJ2;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 1) {
                    AbstractC3574of.a(zzeyVarZzd);
                    Double.longBitsToDouble(a.n(bArr, i));
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ3 = a.j(bArr, iJ, c1883ca0);
                    int i9 = c1883ca0.a + iJ3;
                    if (iJ3 < i9) {
                        Float.intBitsToFloat(a.b(bArr, iJ3));
                        throw null;
                    }
                    if (iJ3 == i9) {
                        return iJ3;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 5) {
                    AbstractC3574of.a(zzeyVarZzd);
                    Float.intBitsToFloat(a.b(bArr, i));
                    throw null;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ4 = a.j(bArr, iJ, c1883ca0);
                    int i10 = c1883ca0.a + iJ4;
                    if (iJ4 < i10) {
                        a.m(bArr, iJ4, c1883ca0);
                        throw null;
                    }
                    if (iJ4 == i10) {
                        return iJ4;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    AbstractC3574of.a(zzeyVarZzd);
                    a.m(bArr, iJ, c1883ca0);
                    long j3 = c1883ca0.b;
                    throw null;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return a.f(bArr, iJ, zzeyVarZzd, c1883ca0);
                }
                if (i5 == 0) {
                    return a.l(i3, bArr, i, i2, zzeyVarZzd, c1883ca0);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ5 = a.j(bArr, iJ, c1883ca0);
                    int i11 = c1883ca0.a + iJ5;
                    if (iJ5 < i11) {
                        a.n(bArr, iJ5);
                        throw null;
                    }
                    if (iJ5 == i11) {
                        return iJ5;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 1) {
                    AbstractC3574of.a(zzeyVarZzd);
                    a.n(bArr, i);
                    throw null;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ6 = a.j(bArr, iJ, c1883ca0);
                    int i12 = c1883ca0.a + iJ6;
                    if (iJ6 < i12) {
                        a.b(bArr, iJ6);
                        throw null;
                    }
                    if (iJ6 == i12) {
                        return iJ6;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 5) {
                    AbstractC3574of.a(zzeyVarZzd);
                    a.b(bArr, i);
                    throw null;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ7 = a.j(bArr, iJ, c1883ca0);
                    int i13 = c1883ca0.a + iJ7;
                    if (iJ7 < i13) {
                        a.m(bArr, iJ7, c1883ca0);
                        throw null;
                    }
                    if (iJ7 == i13) {
                        return iJ7;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    AbstractC3574of.a(zzeyVarZzd);
                    a.m(bArr, iJ, c1883ca0);
                    long j4 = c1883ca0.b;
                    throw null;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        iJ = a.j(bArr, iJ, c1883ca0);
                        int i14 = c1883ca0.a;
                        if (i14 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i14 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            zzeyVarZzd.add(new String(bArr, iJ, i14, zzez.zzb));
                            iJ += i14;
                        }
                        while (iJ < i2) {
                            int iJ8 = a.j(bArr, iJ, c1883ca0);
                            if (i3 != c1883ca0.a) {
                                break;
                            } else {
                                iJ = a.j(bArr, iJ8, c1883ca0);
                                int i15 = c1883ca0.a;
                                if (i15 < 0) {
                                    throw zzfa.zzc();
                                }
                                if (i15 == 0) {
                                    zzeyVarZzd.add("");
                                } else {
                                    zzeyVarZzd.add(new String(bArr, iJ, i15, zzez.zzb));
                                    iJ += i15;
                                }
                            }
                        }
                    } else {
                        iJ = a.j(bArr, iJ, c1883ca0);
                        int i16 = c1883ca0.a;
                        if (i16 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i16 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            int i17 = iJ + i16;
                            if (!AbstractC3245ke0.d(bArr, iJ, i17)) {
                                throw zzfa.zzb();
                            }
                            zzeyVarZzd.add(new String(bArr, iJ, i16, zzez.zzb));
                            iJ = i17;
                        }
                        while (iJ < i2) {
                            int iJ9 = a.j(bArr, iJ, c1883ca0);
                            if (i3 != c1883ca0.a) {
                                break;
                            } else {
                                iJ = a.j(bArr, iJ9, c1883ca0);
                                int i18 = c1883ca0.a;
                                if (i18 < 0) {
                                    throw zzfa.zzc();
                                }
                                if (i18 == 0) {
                                    zzeyVarZzd.add("");
                                } else {
                                    int i19 = iJ + i18;
                                    if (!AbstractC3245ke0.d(bArr, iJ, i19)) {
                                        throw zzfa.zzb();
                                    }
                                    zzeyVarZzd.add(new String(bArr, iJ, i18, zzez.zzb));
                                    iJ = i19;
                                }
                            }
                        }
                    }
                }
                break;
            case 27:
                if (i5 == 2) {
                    return a.e(G(i6), i3, bArr, i, i2, zzeyVarZzd, c1883ca0);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iJ10 = a.j(bArr, iJ, c1883ca0);
                    int i20 = c1883ca0.a;
                    if (i20 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i20 > bArr.length - iJ10) {
                        throw zzfa.zzf();
                    }
                    if (i20 == 0) {
                        zzeyVarZzd.add(zzee.zzb);
                    } else {
                        zzeyVarZzd.add(zzee.zzk(bArr, iJ10, i20));
                        iJ10 += i20;
                    }
                    while (iJ10 < i2) {
                        int iJ11 = a.j(bArr, iJ10, c1883ca0);
                        if (i3 != c1883ca0.a) {
                            return iJ10;
                        }
                        iJ10 = a.j(bArr, iJ11, c1883ca0);
                        int i21 = c1883ca0.a;
                        if (i21 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i21 > bArr.length - iJ10) {
                            throw zzfa.zzf();
                        }
                        if (i21 == 0) {
                            zzeyVarZzd.add(zzee.zzb);
                        } else {
                            zzeyVarZzd.add(zzee.zzk(bArr, iJ10, i21));
                            iJ10 += i21;
                        }
                    }
                    return iJ10;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iL = a.f(bArr, iJ, zzeyVarZzd, c1883ca0);
                } else if (i5 == 0) {
                    iL = a.l(i3, bArr, i, i2, zzeyVarZzd, c1883ca0);
                }
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                Object objD = AbstractC2047dd0.d(i4, zzeyVarZzd, F(i6), zzgzVar != zzgz.zza() ? zzgzVar : null, this.k);
                if (objD == null) {
                    return iL;
                }
                zzeuVar.zzc = (zzgz) objD;
                return iL;
            case 33:
            case 47:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ12 = a.j(bArr, iJ, c1883ca0);
                    int i22 = c1883ca0.a + iJ12;
                    if (iJ12 >= i22) {
                        if (iJ12 == i22) {
                            return iJ12;
                        }
                        throw zzfa.zzf();
                    }
                    a.j(bArr, iJ12, c1883ca0);
                    zzei.zzb(c1883ca0.a);
                    throw null;
                }
                if (i5 == 0) {
                    AbstractC3574of.a(zzeyVarZzd);
                    a.j(bArr, iJ, c1883ca0);
                    zzei.zzb(c1883ca0.a);
                    throw null;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    AbstractC3574of.a(zzeyVarZzd);
                    int iJ13 = a.j(bArr, iJ, c1883ca0);
                    int i23 = c1883ca0.a + iJ13;
                    if (iJ13 >= i23) {
                        if (iJ13 == i23) {
                            return iJ13;
                        }
                        throw zzfa.zzf();
                    }
                    a.m(bArr, iJ13, c1883ca0);
                    zzei.zzc(c1883ca0.b);
                    throw null;
                }
                if (i5 == 0) {
                    AbstractC3574of.a(zzeyVarZzd);
                    a.m(bArr, iJ, c1883ca0);
                    zzei.zzc(c1883ca0.b);
                    throw null;
                }
                break;
            default:
                if (i5 == 3) {
                    Zc0 zc0G = G(i6);
                    int i24 = (i3 & (-8)) | 4;
                    int iC = a.c(zc0G, bArr, i, i2, i24, c1883ca0);
                    zzeyVarZzd.add(c1883ca0.c);
                    while (iC < i2) {
                        int iJ14 = a.j(bArr, iC, c1883ca0);
                        if (i3 != c1883ca0.a) {
                            return iC;
                        }
                        iC = a.c(zc0G, bArr, iJ14, i2, i24, c1883ca0);
                        zzeyVarZzd.add(c1883ca0.c);
                    }
                    return iC;
                }
                break;
        }
        return iJ;
    }

    public final int y(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return B(i, 0);
    }

    public final int z(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return B(i, i2);
    }

    @Override // defpackage.Zc0
    public final int zza(Object obj) {
        int i;
        int iZzc;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iD = D(i3);
            int i4 = this.a[i3];
            long j = 1048575 & iD;
            int iHashCode = 37;
            switch (C(iD)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzez.zzc(Double.doubleToLongBits(AbstractC1244ae0.a(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(AbstractC1244ae0.b(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzez.zzc(AbstractC1244ae0.d(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzez.zzc(AbstractC1244ae0.d(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.c(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzez.zzc(AbstractC1244ae0.d(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.c(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzez.zza(AbstractC1244ae0.t(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) AbstractC1244ae0.f(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objF = AbstractC1244ae0.f(obj, j);
                    if (objF != null) {
                        iHashCode = objF.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.f(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.c(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.c(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.c(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzez.zzc(AbstractC1244ae0.d(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.c(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzez.zzc(AbstractC1244ae0.d(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objF2 = AbstractC1244ae0.f(obj, j);
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
                    iZzc = AbstractC1244ae0.f(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = AbstractC1244ae0.f(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(Double.doubleToLongBits(((Double) AbstractC1244ae0.f(obj, j)).doubleValue()));
                        i2 = i + iZzc;
                    }
                    break;
                case 52:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(((Float) AbstractC1244ae0.f(obj, j)).floatValue());
                        i2 = i + iZzc;
                    }
                    break;
                case 53:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(E(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 54:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(E(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 55:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = t(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 56:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(E(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 57:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = t(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 58:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zza(((Boolean) AbstractC1244ae0.f(obj, j)).booleanValue());
                        i2 = i + iZzc;
                    }
                    break;
                case 59:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) AbstractC1244ae0.f(obj, j)).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 60:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = AbstractC1244ae0.f(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 61:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = AbstractC1244ae0.f(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 62:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = t(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 63:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = t(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 64:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = t(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 65:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(E(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 66:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = t(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 67:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(E(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 68:
                    if (o(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = AbstractC1244ae0.f(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
            }
        }
        return (i2 * 53) + this.k.a(obj).hashCode();
    }

    @Override // defpackage.Zc0
    public final Object zzd() {
        return ((zzeu) this.e).zzi(4, null, null);
    }
}
