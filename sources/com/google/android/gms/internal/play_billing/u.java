package com.google.android.gms.internal.play_billing;

import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC3483na0;
import defpackage.AbstractC3491ne0;
import defpackage.AbstractC3574of;
import defpackage.AbstractC3978te0;
import defpackage.AbstractC4215wb0;
import defpackage.C2208fc0;
import defpackage.C3161jd0;
import defpackage.C3237ka0;
import defpackage.C3407md0;
import defpackage.C3653pd0;
import defpackage.C4300xd0;
import defpackage.C4379yc0;
import defpackage.Cb0;
import defpackage.InterfaceC1242ad0;
import defpackage.InterfaceC3814rd0;
import defpackage.InterfaceC4221we0;
import defpackage.Sd0;
import defpackage.Wc0;
import defpackage.Xd0;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements InterfaceC3814rd0 {
    public static final int[] l = new int[0];
    public static final Unsafe m = AbstractC3491ne0.l();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final zzgl e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final Xd0 j;
    public final AbstractC4215wb0 k;

    public u(int[] iArr, Object[] objArr, int i, int i2, zzgl zzglVar, boolean z, int[] iArr2, int i3, int i4, C3161jd0 c3161jd0, C4379yc0 c4379yc0, Xd0 xd0, AbstractC4215wb0 abstractC4215wb0, Wc0 wc0) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        boolean z2 = false;
        if (abstractC4215wb0 != null && (zzglVar instanceof zzff)) {
            z2 = true;
        }
        this.f = z2;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = xd0;
        this.k = abstractC4215wb0;
        this.e = zzglVar;
    }

    public static int A(Object obj, long j) {
        return ((Integer) AbstractC3491ne0.k(obj, j)).intValue();
    }

    public static int D(int i) {
        return (i >>> 20) & 255;
    }

    public static long F(Object obj, long j) {
        return ((Long) AbstractC3491ne0.k(obj, j)).longValue();
    }

    public static Field L(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    public static void g(Object obj) {
        if (!r(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public static boolean q(Object obj, int i, InterfaceC3814rd0 interfaceC3814rd0) {
        return interfaceC3814rd0.a(AbstractC3491ne0.k(obj, i & 1048575));
    }

    public static boolean r(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    public static boolean t(Object obj, long j) {
        return ((Boolean) AbstractC3491ne0.k(obj, j)).booleanValue();
    }

    public static final void u(int i, Object obj, InterfaceC4221we0 interfaceC4221we0) {
        if (obj instanceof String) {
            interfaceC4221we0.g(i, (String) obj);
        } else {
            interfaceC4221we0.l(i, (zzei) obj);
        }
    }

    public static zzhi w(Object obj) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar != zzhi.zzc()) {
            return zzhiVar;
        }
        zzhi zzhiVarZzf = zzhi.zzf();
        zzfiVar.zzc = zzhiVarZzf;
        return zzhiVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0283  */
    /* JADX WARN: Code duplicated, block: B:170:0x0345  */
    /* JADX WARN: Code duplicated, block: B:186:0x0394  */
    /* JADX WARN: Code duplicated, block: B:189:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:193:0x03af  */
    public static u x(Class cls, InterfaceC1242ad0 interfaceC1242ad0, C3161jd0 c3161jd0, C4379yc0 c4379yc0, Xd0 xd0, AbstractC4215wb0 abstractC4215wb0, Wc0 wc0) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        Field fieldL;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldL2;
        int i28;
        Object obj2;
        Field fieldL3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(interfaceC1242ad0 instanceof C3653pd0)) {
            AbstractC3574of.a(interfaceC1242ad0);
            throw null;
        }
        C3653pd0 c3653pd0 = (C3653pd0) interfaceC1242ad0;
        String strA = c3653pd0.a();
        int length = strA.length();
        char c = 55296;
        if (strA.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strA.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strA.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strA.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            iArr = l;
            i6 = 0;
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strA.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strA.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strA.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strA.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strA.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strA.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strA.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strA.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strA.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strA.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strA.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strA.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strA.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strA.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strA.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strA.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = m;
        Object[] objArrB = c3653pd0.b();
        Class<?> cls2 = c3653pd0.zza().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strA.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strA.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strA.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strA.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strA.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strA.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrB[i4];
                } else {
                    if (i84 == 12) {
                        if (c3653pd0.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrB[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrB[i27];
                    if (obj instanceof Field) {
                        fieldL2 = (Field) obj;
                    } else {
                        fieldL2 = L(cls2, (String) obj);
                        objArrB[i27] = fieldL2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldL2);
                    i28 = i27 + 1;
                    obj2 = objArrB[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldL3 = (Field) obj2;
                    } else {
                        fieldL3 = L(cls2, (String) obj2);
                        objArrB[i28] = fieldL3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldL3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i20 = i88;
                    c3653pd0 = c3653pd0;
                    cls2 = cls2;
                    i18 = i85;
                    strA = strA;
                    i19 = 0;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrB[i27];
                if (obj instanceof Field) {
                    fieldL2 = (Field) obj;
                } else {
                    fieldL2 = L(cls2, (String) obj);
                    objArrB[i27] = fieldL2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldL2);
                i28 = i27 + 1;
                obj2 = objArrB[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldL3 = (Field) obj2;
                } else {
                    fieldL3 = L(cls2, (String) obj2);
                    objArrB[i28] = fieldL3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldL3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i20 = i89;
                c3653pd0 = c3653pd0;
                cls2 = cls2;
                i18 = i85;
                strA = strA;
                i19 = 0;
            } else {
                i17 = i2;
                i4++;
                Field fieldL4 = L(cls2, (String) objArrB[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldL4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            c3653pd0 = c3653pd0;
                            if (c3653pd0.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i67 / 3;
                                objArr[i91 + i91 + 1] = objArrB[i4];
                                i4 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i67;
                            int i94 = i67 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrB[i4];
                            if (i78 != 0) {
                                i4 += 3;
                                objArr[i95 + 1] = objArrB[i92];
                                i64 = i93;
                                c3653pd0 = c3653pd0;
                            } else {
                                i4 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldL4);
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i18 = i16;
                            i19 = 0;
                            iObjectFieldOffset2 = 1048575;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strA.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strA.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i21 = i22;
                            } else {
                                i21 = i96;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrB[i99];
                            if (obj3 instanceof Field) {
                                fieldL = (Field) obj3;
                            } else {
                                fieldL = L(cls2, (String) obj3);
                                objArrB[i99] = fieldL;
                            }
                            i19 = iCharAt13 % 32;
                            i18 = i21;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldL);
                        }
                        if (i76 < 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i67 / 3;
                    objArr[i100 + i100 + i23] = objArrB[i4];
                    i4 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldL4);
                    if ((iCharAt11 & 4096) != 0) {
                        i18 = i16;
                        i19 = 0;
                        iObjectFieldOffset2 = 1048575;
                    } else {
                        i18 = i16;
                        i19 = 0;
                        iObjectFieldOffset2 = 1048575;
                    }
                    if (i76 < 18) {
                    }
                    i20 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldL4);
                if ((iCharAt11 & 4096) != 0) {
                    i18 = i16;
                    i19 = 0;
                    iObjectFieldOffset2 = 1048575;
                } else {
                    i18 = i16;
                    i19 = 0;
                    iObjectFieldOffset2 = 1048575;
                }
                if (i76 < 18) {
                }
                i20 = i78;
            }
            int i101 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i102 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i76 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr3[i102] = (i19 << 20) | iObjectFieldOffset2;
            strA = strA;
            length = i77;
            i5 = i79;
            c3653pd0 = c3653pd0;
            i2 = i17;
            c = 55296;
            i34 = i18;
            cls2 = cls3;
        }
        return new u(iArr3, objArr, i2, i5, c3653pd0.zza(), false, iArr, i3, i62, c3161jd0, c4379yc0, xd0, abstractC4215wb0, wc0);
    }

    public static double y(Object obj, long j) {
        return ((Double) AbstractC3491ne0.k(obj, j)).doubleValue();
    }

    public static float z(Object obj, long j) {
        return ((Float) AbstractC3491ne0.k(obj, j)).floatValue();
    }

    public final int B(int i) {
        return this.a[i + 2];
    }

    public final int C(int i, int i2) {
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    public final int E(int i) {
        return this.a[i + 1];
    }

    public final zzfl G(int i) {
        int i2 = i / 3;
        return (zzfl) this.b[i2 + i2 + 1];
    }

    public final InterfaceC3814rd0 H(int i) {
        Object[] objArr = this.b;
        int i2 = i / 3;
        int i3 = i2 + i2;
        InterfaceC3814rd0 interfaceC3814rd0 = (InterfaceC3814rd0) objArr[i3];
        if (interfaceC3814rd0 != null) {
            return interfaceC3814rd0;
        }
        InterfaceC3814rd0 interfaceC3814rd0B = C3407md0.a().b((Class) objArr[i3 + 1]);
        objArr[i3] = interfaceC3814rd0B;
        return interfaceC3814rd0B;
    }

    public final Object I(int i) {
        int i2 = i / 3;
        return this.b[i2 + i2];
    }

    public final Object J(Object obj, int i) {
        InterfaceC3814rd0 interfaceC3814rd0H = H(i);
        int iE = E(i) & 1048575;
        if (!o(obj, i)) {
            return interfaceC3814rd0H.zze();
        }
        Object object = m.getObject(obj, iE);
        if (r(object)) {
            return object;
        }
        Object objZze = interfaceC3814rd0H.zze();
        if (object != null) {
            interfaceC3814rd0H.d(objZze, object);
        }
        return objZze;
    }

    public final Object K(Object obj, int i, int i2) {
        InterfaceC3814rd0 interfaceC3814rd0H = H(i2);
        if (!s(obj, i, i2)) {
            return interfaceC3814rd0H.zze();
        }
        Object object = m.getObject(obj, E(i2) & 1048575);
        if (r(object)) {
            return object;
        }
        Object objZze = interfaceC3814rd0H.zze();
        if (object != null) {
            interfaceC3814rd0H.d(objZze, object);
        }
        return objZze;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // defpackage.InterfaceC3814rd0
    public final boolean a(Object obj) {
        int i;
        int i2;
        List list;
        InterfaceC3814rd0 interfaceC3814rd0H;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.h) {
            int[] iArr = this.g;
            int[] iArr2 = this.a;
            int i7 = iArr[i6];
            int i8 = iArr2[i7];
            int iE = E(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = m.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iE) != 0 && !p(obj, i7, i, i2, i11)) {
                return false;
            }
            int iD = D(iE);
            if (iD == 9 || iD == 17) {
                if (p(obj, i7, i, i2, i11) && !q(obj, iE, H(i7))) {
                    return false;
                }
            } else if (iD == 27) {
                list = (List) AbstractC3491ne0.k(obj, iE & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    interfaceC3814rd0H = H(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!interfaceC3814rd0H.a(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iD == 60 || iD == 68) {
                if (s(obj, i8, i7) && !q(obj, iE, H(i7))) {
                    return false;
                }
            } else if (iD == 49) {
                list = (List) AbstractC3491ne0.k(obj, iE & 1048575);
                if (list.isEmpty()) {
                    interfaceC3814rd0H = H(i7);
                    while (i3 < list.size()) {
                        if (!interfaceC3814rd0H.a(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iD == 50 && !((zzgf) AbstractC3491ne0.k(obj, iE & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return !this.f || ((zzff) obj).zzb.i();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // defpackage.InterfaceC3814rd0
    public final void b(Object obj) {
        if (r(obj)) {
            if (obj instanceof zzfi) {
                zzfi zzfiVar = (zzfi) obj;
                zzfiVar.zzx(Integer.MAX_VALUE);
                zzfiVar.zza = 0;
                zzfiVar.zzv();
            }
            int[] iArr = this.a;
            for (int i = 0; i < iArr.length; i += 3) {
                int iE = E(i);
                int i2 = 1048575 & iE;
                int iD = D(iE);
                long j = i2;
                if (iD != 9) {
                    if (iD != 60 && iD != 68) {
                        switch (iD) {
                            case 17:
                                if (o(obj, i)) {
                                    H(i).b(m.getObject(obj, j));
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
                                ((zzfn) AbstractC3491ne0.k(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = m;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgf) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (s(obj, iArr[i], i)) {
                        H(i).b(m.getObject(obj, j));
                    }
                } else if (o(obj, i)) {
                    H(i).b(m.getObject(obj, j));
                }
            }
            this.j.b(obj);
            if (this.f) {
                this.k.a(obj);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @Override // defpackage.InterfaceC3814rd0
    public final void c(Object obj, InterfaceC4221we0 interfaceC4221we0) {
        Map.Entry entry;
        int i;
        int i2;
        int i3;
        int i4;
        Map.Entry entry2;
        int[] iArr;
        ?? r9 = 1;
        if (this.f) {
            Cb0 cb0 = ((zzff) obj).zzb;
            if (cb0.a.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) cb0.f().next();
            }
        } else {
            entry = null;
        }
        int[] iArr2 = this.a;
        Unsafe unsafe = m;
        int i5 = 1048575;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < iArr2.length) {
            int iE = E(i8);
            int iD = D(iE);
            int i9 = iArr2[i8];
            if (iD <= 17) {
                int i10 = iArr2[i8 + 2];
                int i11 = i10 & i5;
                if (i11 != i6) {
                    i7 = i11 == i5 ? 0 : unsafe.getInt(obj, i11);
                    i6 = i11;
                }
                int i12 = r9 << (i10 >>> 20);
                i2 = i7;
                i3 = i12;
                i = i6;
            } else {
                i = i6;
                i2 = i7;
                i3 = 0;
            }
            if (entry != null) {
                AbstractC3574of.a(entry.getKey());
                throw null;
            }
            long j = iE & i5;
            switch (iD) {
                case 0:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.v(i9, AbstractC3491ne0.f(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 1:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.y(i9, AbstractC3491ne0.g(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 2:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.m(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 3:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.I(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 4:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.t(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 5:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.G(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 6:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.k(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 7:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.j(i9, AbstractC3491ne0.B(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 8:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        u(i9, unsafe.getObject(obj, j), interfaceC4221we0);
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 9:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.D(i9, unsafe.getObject(obj, j), H(i4));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 10:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.l(i9, (zzei) unsafe.getObject(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 11:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.h(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 12:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.s(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 13:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.B(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 14:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.r(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 15:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.F(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 16:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    if (p(obj, i4, i, i2, i3)) {
                        interfaceC4221we0.w(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 17:
                    i4 = i8;
                    if (p(obj, i8, i, i2, i3)) {
                        interfaceC4221we0.o(i9, unsafe.getObject(obj, j), H(i4));
                    }
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 18:
                    w.w(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 19:
                    w.A(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 20:
                    w.C(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 21:
                    w.d(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 22:
                    w.B(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 23:
                    w.z(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 24:
                    w.y(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 25:
                    w.v(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 26:
                    int i13 = iArr2[i8];
                    List list = (List) unsafe.getObject(obj, j);
                    Xd0 xd0 = w.a;
                    if (list != null && !list.isEmpty()) {
                        interfaceC4221we0.H(i13, list);
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 27:
                    int i14 = iArr2[i8];
                    List list2 = (List) unsafe.getObject(obj, j);
                    InterfaceC3814rd0 interfaceC3814rd0H = H(i8);
                    Xd0 xd1 = w.a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15 += r9) {
                            ((r) interfaceC4221we0).D(i14, list2.get(i15), interfaceC3814rd0H);
                        }
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 28:
                    int i16 = iArr2[i8];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Xd0 xd2 = w.a;
                    if (list3 != null && !list3.isEmpty()) {
                        interfaceC4221we0.f(i16, list3);
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 29:
                    w.c(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 30:
                    w.x(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 31:
                    w.D(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 32:
                    w.E(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 33:
                    w.a(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 34:
                    w.b(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, false);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 35:
                    w.w(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 36:
                    w.A(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 37:
                    w.C(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 38:
                    w.d(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 39:
                    w.B(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 40:
                    w.z(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 41:
                    w.y(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 42:
                    w.v(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 43:
                    w.c(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 44:
                    w.x(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 45:
                    w.D(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 46:
                    w.E(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 47:
                    w.a(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 48:
                    w.b(iArr2[i8], (List) unsafe.getObject(obj, j), interfaceC4221we0, r9);
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 49:
                    int i17 = iArr2[i8];
                    List list4 = (List) unsafe.getObject(obj, j);
                    InterfaceC3814rd0 interfaceC3814rd0H2 = H(i8);
                    Xd0 xd3 = w.a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18 += r9) {
                            ((r) interfaceC4221we0).o(i17, list4.get(i18), interfaceC3814rd0H2);
                        }
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 51:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.v(i9, y(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 52:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.y(i9, z(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 53:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.m(i9, F(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 54:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.I(i9, F(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 55:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.t(i9, A(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 56:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.G(i9, F(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 57:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.k(i9, A(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 58:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.j(i9, t(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 59:
                    if (s(obj, i9, i8)) {
                        u(i9, unsafe.getObject(obj, j), interfaceC4221we0);
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 60:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.D(i9, unsafe.getObject(obj, j), H(i8));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 61:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.l(i9, (zzei) unsafe.getObject(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 62:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.h(i9, A(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 63:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.s(i9, A(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 64:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.B(i9, A(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 65:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.r(i9, F(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 66:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.F(i9, A(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 67:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.w(i9, F(obj, j));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                case 68:
                    if (s(obj, i9, i8)) {
                        interfaceC4221we0.o(i9, unsafe.getObject(obj, j), H(i8));
                    }
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
                default:
                    i4 = i8;
                    entry2 = entry;
                    iArr = iArr2;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    entry = entry2;
                    iArr2 = iArr;
                    r9 = 1;
                    i5 = 1048575;
                    break;
            }
        }
        Map.Entry entry3 = entry;
        if (entry3 != null) {
            AbstractC3574of.a(entry3.getKey());
            throw null;
        }
        ((zzfi) obj).zzc.zzl(interfaceC4221we0);
    }

    @Override // defpackage.InterfaceC3814rd0
    public final void d(Object obj, Object obj2) {
        g(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                w.u(this.j, obj, obj2);
                if (this.f) {
                    w.t(this.k, obj, obj2);
                    return;
                }
                return;
            }
            int iE = E(i);
            int i2 = 1048575 & iE;
            int iD = D(iE);
            int i3 = iArr[i];
            long j = i2;
            switch (iD) {
                case 0:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.t(obj, j, AbstractC3491ne0.f(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 1:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.u(obj, j, AbstractC3491ne0.g(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 2:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.w(obj, j, AbstractC3491ne0.i(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 3:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.w(obj, j, AbstractC3491ne0.i(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 4:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.v(obj, j, AbstractC3491ne0.h(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 5:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.w(obj, j, AbstractC3491ne0.i(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 6:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.v(obj, j, AbstractC3491ne0.h(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 7:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.r(obj, j, AbstractC3491ne0.B(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 8:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.x(obj, j, AbstractC3491ne0.k(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 9:
                    h(obj, obj2, i);
                    break;
                case 10:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.x(obj, j, AbstractC3491ne0.k(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 11:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.v(obj, j, AbstractC3491ne0.h(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 12:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.v(obj, j, AbstractC3491ne0.h(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 13:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.v(obj, j, AbstractC3491ne0.h(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 14:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.w(obj, j, AbstractC3491ne0.i(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 15:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.v(obj, j, AbstractC3491ne0.h(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 16:
                    if (o(obj2, i)) {
                        AbstractC3491ne0.w(obj, j, AbstractC3491ne0.i(obj2, j));
                        j(obj, i);
                    }
                    break;
                case 17:
                    h(obj, obj2, i);
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
                    zzfn zzfnVarZzd = (zzfn) AbstractC3491ne0.k(obj, j);
                    zzfn zzfnVar = (zzfn) AbstractC3491ne0.k(obj2, j);
                    int size = zzfnVarZzd.size();
                    int size2 = zzfnVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzfnVarZzd.zzc()) {
                            zzfnVarZzd = zzfnVarZzd.zzd(size2 + size);
                        }
                        zzfnVarZzd.addAll(zzfnVar);
                    }
                    if (size > 0) {
                        zzfnVar = zzfnVarZzd;
                    }
                    AbstractC3491ne0.x(obj, j, zzfnVar);
                    break;
                case 50:
                    Xd0 xd0 = w.a;
                    AbstractC3491ne0.x(obj, j, Wc0.a(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j)));
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
                    if (s(obj2, i3, i)) {
                        AbstractC3491ne0.x(obj, j, AbstractC3491ne0.k(obj2, j));
                        k(obj, i3, i);
                    }
                    break;
                case 60:
                    i(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (s(obj2, i3, i)) {
                        AbstractC3491ne0.x(obj, j, AbstractC3491ne0.k(obj2, j));
                        k(obj, i3, i);
                    }
                    break;
                case 68:
                    i(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // defpackage.InterfaceC3814rd0
    public final boolean e(Object obj, Object obj2) {
        boolean zE;
        for (int i = 0; i < this.a.length; i += 3) {
            int iE = E(i);
            long j = iE & 1048575;
            switch (D(iE)) {
                case 0:
                    if (!n(obj, obj2, i) || Double.doubleToLongBits(AbstractC3491ne0.f(obj, j)) != Double.doubleToLongBits(AbstractC3491ne0.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!n(obj, obj2, i) || Float.floatToIntBits(AbstractC3491ne0.g(obj, j)) != Float.floatToIntBits(AbstractC3491ne0.g(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.i(obj, j) != AbstractC3491ne0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.i(obj, j) != AbstractC3491ne0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.h(obj, j) != AbstractC3491ne0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.i(obj, j) != AbstractC3491ne0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.h(obj, j) != AbstractC3491ne0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.B(obj, j) != AbstractC3491ne0.B(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!n(obj, obj2, i) || !w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!n(obj, obj2, i) || !w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!n(obj, obj2, i) || !w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.h(obj, j) != AbstractC3491ne0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.h(obj, j) != AbstractC3491ne0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.h(obj, j) != AbstractC3491ne0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.i(obj, j) != AbstractC3491ne0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.h(obj, j) != AbstractC3491ne0.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!n(obj, obj2, i) || AbstractC3491ne0.i(obj, j) != AbstractC3491ne0.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!n(obj, obj2, i) || !w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j))) {
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
                    zE = w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j));
                    break;
                case 50:
                    zE = w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j));
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
                    long jB = B(i) & 1048575;
                    if (AbstractC3491ne0.h(obj, jB) != AbstractC3491ne0.h(obj2, jB) || !w.e(AbstractC3491ne0.k(obj, j), AbstractC3491ne0.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zE) {
                return false;
            }
        }
        if (!((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            return false;
        }
        if (this.f) {
            return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
        }
        return true;
    }

    @Override // defpackage.InterfaceC3814rd0
    public final void f(Object obj, byte[] bArr, int i, int i2, C3237ka0 c3237ka0) {
        v(obj, bArr, i, i2, 0, c3237ka0);
    }

    public final void h(Object obj, Object obj2, int i) {
        if (o(obj2, i)) {
            int iE = E(i) & 1048575;
            Unsafe unsafe = m;
            long j = iE;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2.toString());
            }
            InterfaceC3814rd0 interfaceC3814rd0H = H(i);
            if (!o(obj, i)) {
                if (r(object)) {
                    Object objZze = interfaceC3814rd0H.zze();
                    interfaceC3814rd0H.d(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                j(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!r(object2)) {
                Object objZze2 = interfaceC3814rd0H.zze();
                interfaceC3814rd0H.d(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            interfaceC3814rd0H.d(object2, object);
        }
    }

    public final void i(Object obj, Object obj2, int i) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (s(obj2, i2, i)) {
            int iE = E(i) & 1048575;
            Unsafe unsafe = m;
            long j = iE;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            InterfaceC3814rd0 interfaceC3814rd0H = H(i);
            if (!s(obj, i2, i)) {
                if (r(object)) {
                    Object objZze = interfaceC3814rd0H.zze();
                    interfaceC3814rd0H.d(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                k(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!r(object2)) {
                Object objZze2 = interfaceC3814rd0H.zze();
                interfaceC3814rd0H.d(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            interfaceC3814rd0H.d(object2, object);
        }
    }

    public final void j(Object obj, int i) {
        int iB = B(i);
        long j = 1048575 & iB;
        if (j == 1048575) {
            return;
        }
        AbstractC3491ne0.v(obj, j, (1 << (iB >>> 20)) | AbstractC3491ne0.h(obj, j));
    }

    public final void k(Object obj, int i, int i2) {
        AbstractC3491ne0.v(obj, B(i2) & 1048575, i);
    }

    public final void l(Object obj, int i, Object obj2) {
        m.putObject(obj, E(i) & 1048575, obj2);
        j(obj, i);
    }

    public final void m(Object obj, int i, int i2, Object obj2) {
        m.putObject(obj, E(i2) & 1048575, obj2);
        k(obj, i, i2);
    }

    public final boolean n(Object obj, Object obj2, int i) {
        return o(obj, i) == o(obj2, i);
    }

    public final boolean o(Object obj, int i) {
        int iB = B(i);
        long j = iB & 1048575;
        if (j != 1048575) {
            return (AbstractC3491ne0.h(obj, j) & (1 << (iB >>> 20))) != 0;
        }
        int iE = E(i);
        long j2 = iE & 1048575;
        switch (D(iE)) {
            case 0:
                return Double.doubleToRawLongBits(AbstractC3491ne0.f(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(AbstractC3491ne0.g(obj, j2)) != 0;
            case 2:
                return AbstractC3491ne0.i(obj, j2) != 0;
            case 3:
                return AbstractC3491ne0.i(obj, j2) != 0;
            case 4:
                return AbstractC3491ne0.h(obj, j2) != 0;
            case 5:
                return AbstractC3491ne0.i(obj, j2) != 0;
            case 6:
                return AbstractC3491ne0.h(obj, j2) != 0;
            case 7:
                return AbstractC3491ne0.B(obj, j2);
            case 8:
                Object objK = AbstractC3491ne0.k(obj, j2);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof zzei) {
                    return !zzei.zzb.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return AbstractC3491ne0.k(obj, j2) != null;
            case 10:
                return !zzei.zzb.equals(AbstractC3491ne0.k(obj, j2));
            case 11:
                return AbstractC3491ne0.h(obj, j2) != 0;
            case 12:
                return AbstractC3491ne0.h(obj, j2) != 0;
            case 13:
                return AbstractC3491ne0.h(obj, j2) != 0;
            case 14:
                return AbstractC3491ne0.i(obj, j2) != 0;
            case 15:
                return AbstractC3491ne0.h(obj, j2) != 0;
            case 16:
                return AbstractC3491ne0.i(obj, j2) != 0;
            case 17:
                return AbstractC3491ne0.k(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean p(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return o(obj, i);
        }
        return (i3 & i4) != 0;
    }

    public final boolean s(Object obj, int i, int i2) {
        return AbstractC3491ne0.h(obj, (long) (B(i2) & 1048575)) == i;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:131:0x0404  */
    /* JADX WARN: Code duplicated, block: B:132:0x0407  */
    /* JADX WARN: Code duplicated, block: B:140:0x0469  */
    /* JADX WARN: Code duplicated, block: B:141:0x047a  */
    /* JADX WARN: Code duplicated, block: B:144:0x0482  */
    /* JADX WARN: Code duplicated, block: B:146:0x0485  */
    /* JADX WARN: Code duplicated, block: B:148:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:150:0x04ae A[LOOP:2: B:147:0x04a2->B:150:0x04ae, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:154:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:156:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:158:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:160:0x04f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x050b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x0525  */
    /* JADX WARN: Code duplicated, block: B:173:0x052d  */
    /* JADX WARN: Code duplicated, block: B:175:0x053a A[LOOP:3: B:174:0x0538->B:175:0x053a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:180:0x0551 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:181:0x0553  */
    /* JADX WARN: Code duplicated, block: B:183:0x0566  */
    /* JADX WARN: Code duplicated, block: B:185:0x056e A[LOOP:4: B:182:0x0564->B:185:0x056e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x057c  */
    /* JADX WARN: Code duplicated, block: B:188:0x0584  */
    /* JADX WARN: Code duplicated, block: B:189:0x0589 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x058b  */
    /* JADX WARN: Code duplicated, block: B:193:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:195:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:197:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:199:0x05c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:200:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:203:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:207:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:208:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:211:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:214:0x0616  */
    /* JADX WARN: Code duplicated, block: B:216:0x0627  */
    /* JADX WARN: Code duplicated, block: B:217:0x062b  */
    /* JADX WARN: Code duplicated, block: B:219:0x0636  */
    /* JADX WARN: Code duplicated, block: B:221:0x063e  */
    /* JADX WARN: Code duplicated, block: B:223:0x0642 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x0644  */
    /* JADX WARN: Code duplicated, block: B:225:0x064a  */
    /* JADX WARN: Code duplicated, block: B:228:0x0654  */
    /* JADX WARN: Code duplicated, block: B:230:0x065c  */
    /* JADX WARN: Code duplicated, block: B:232:0x0664  */
    /* JADX WARN: Code duplicated, block: B:234:0x0668 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:246:0x069f  */
    /* JADX WARN: Code duplicated, block: B:248:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:250:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:252:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:253:0x06e7  */
    /* JADX WARN: Code duplicated, block: B:255:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:257:0x0700  */
    /* JADX WARN: Code duplicated, block: B:259:0x0708 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:260:0x070a  */
    /* JADX WARN: Code duplicated, block: B:261:0x0710  */
    /* JADX WARN: Code duplicated, block: B:264:0x071f  */
    /* JADX WARN: Code duplicated, block: B:266:0x0727  */
    /* JADX WARN: Code duplicated, block: B:268:0x072f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:276:0x0752  */
    /* JADX WARN: Code duplicated, block: B:278:0x075c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:279:0x075e  */
    /* JADX WARN: Code duplicated, block: B:280:0x0762  */
    /* JADX WARN: Code duplicated, block: B:282:0x076a  */
    /* JADX WARN: Code duplicated, block: B:284:0x0777  */
    /* JADX WARN: Code duplicated, block: B:286:0x077f  */
    /* JADX WARN: Code duplicated, block: B:288:0x0787 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:292:0x0795  */
    /* JADX WARN: Code duplicated, block: B:29:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:301:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:302:0x07c4  */
    /* JADX WARN: Code duplicated, block: B:304:0x07d2  */
    /* JADX WARN: Code duplicated, block: B:306:0x07e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:313:0x07f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:317:0x0808  */
    /* JADX WARN: Code duplicated, block: B:319:0x0816  */
    /* JADX WARN: Code duplicated, block: B:321:0x0825  */
    /* JADX WARN: Code duplicated, block: B:323:0x0831 A[LOOP:10: B:322:0x082f->B:323:0x0831, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:330:0x084a  */
    /* JADX WARN: Code duplicated, block: B:332:0x084d  */
    /* JADX WARN: Code duplicated, block: B:334:0x085c  */
    /* JADX WARN: Code duplicated, block: B:336:0x0864 A[LOOP:11: B:333:0x085a->B:336:0x0864, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:338:0x0874  */
    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:342:0x0891  */
    /* JADX WARN: Code duplicated, block: B:344:0x0897  */
    /* JADX WARN: Code duplicated, block: B:345:0x0898 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:349:0x08a5  */
    /* JADX WARN: Code duplicated, block: B:351:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:352:0x08b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:353:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:354:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:355:0x08d6  */
    /* JADX WARN: Code duplicated, block: B:357:0x08e4  */
    /* JADX WARN: Code duplicated, block: B:359:0x08f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:365:0x0900 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:369:0x090f  */
    /* JADX WARN: Code duplicated, block: B:373:0x092c  */
    /* JADX WARN: Code duplicated, block: B:375:0x0932  */
    /* JADX WARN: Code duplicated, block: B:376:0x0933  */
    /* JADX WARN: Code duplicated, block: B:381:0x0944  */
    /* JADX WARN: Code duplicated, block: B:385:0x0961  */
    /* JADX WARN: Code duplicated, block: B:387:0x0967  */
    /* JADX WARN: Code duplicated, block: B:388:0x0968 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:400:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:403:0x09df  */
    /* JADX WARN: Code duplicated, block: B:405:0x09f0  */
    /* JADX WARN: Code duplicated, block: B:407:0x0a07 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:408:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:410:0x0a14  */
    /* JADX WARN: Code duplicated, block: B:412:0x0a40  */
    /* JADX WARN: Code duplicated, block: B:414:0x0a43  */
    /* JADX WARN: Code duplicated, block: B:415:0x0a68  */
    /* JADX WARN: Code duplicated, block: B:416:0x0a6e A[PHI: r6 r14 r37
      0x0a6e: PHI (r6v119 sun.misc.Unsafe) = (r6v106 sun.misc.Unsafe), (r6v120 sun.misc.Unsafe) binds: [B:476:0x0bf7, B:415:0x0a68] A[DONT_GENERATE, DONT_INLINE]
      0x0a6e: PHI (r14v88 com.google.android.gms.internal.play_billing.u) = (r14v70 com.google.android.gms.internal.play_billing.u), (r14v89 com.google.android.gms.internal.play_billing.u) binds: [B:476:0x0bf7, B:415:0x0a68] A[DONT_GENERATE, DONT_INLINE]
      0x0a6e: PHI (r37v29 int) = (r37v12 int), (r37v30 int) binds: [B:476:0x0bf7, B:415:0x0a68] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:417:0x0a72  */
    /* JADX WARN: Code duplicated, block: B:419:0x0a77  */
    /* JADX WARN: Code duplicated, block: B:425:0x0a9e  */
    /* JADX WARN: Code duplicated, block: B:427:0x0aa3  */
    /* JADX WARN: Code duplicated, block: B:433:0x0ac3  */
    /* JADX WARN: Code duplicated, block: B:434:0x0ace  */
    /* JADX WARN: Code duplicated, block: B:436:0x0ad4  */
    /* JADX WARN: Code duplicated, block: B:437:0x0ae1  */
    /* JADX WARN: Code duplicated, block: B:439:0x0ae7  */
    /* JADX WARN: Code duplicated, block: B:440:0x0b0b  */
    /* JADX WARN: Code duplicated, block: B:441:0x0b11  */
    /* JADX WARN: Code duplicated, block: B:443:0x0b1a  */
    /* JADX WARN: Code duplicated, block: B:445:0x0b22  */
    /* JADX WARN: Code duplicated, block: B:446:0x0b28  */
    /* JADX WARN: Code duplicated, block: B:455:0x0b53  */
    /* JADX WARN: Code duplicated, block: B:456:0x0b57  */
    /* JADX WARN: Code duplicated, block: B:458:0x0b61  */
    /* JADX WARN: Code duplicated, block: B:460:0x0b6b  */
    /* JADX WARN: Code duplicated, block: B:461:0x0b6d  */
    /* JADX WARN: Code duplicated, block: B:463:0x0b7a  */
    /* JADX WARN: Code duplicated, block: B:465:0x0b85  */
    /* JADX WARN: Code duplicated, block: B:466:0x0b97  */
    /* JADX WARN: Code duplicated, block: B:468:0x0ba2  */
    /* JADX WARN: Code duplicated, block: B:469:0x0bb4  */
    /* JADX WARN: Code duplicated, block: B:471:0x0bbf  */
    /* JADX WARN: Code duplicated, block: B:472:0x0bd1  */
    /* JADX WARN: Code duplicated, block: B:474:0x0bdc  */
    /* JADX WARN: Code duplicated, block: B:475:0x0bf0  */
    /* JADX WARN: Code duplicated, block: B:477:0x0bf9  */
    /* JADX WARN: Code duplicated, block: B:478:0x0c10  */
    /* JADX WARN: Code duplicated, block: B:480:0x0c1b  */
    /* JADX WARN: Code duplicated, block: B:481:0x0c30 A[PHI: r4 r6 r14 r37
      0x0c30: PHI (r4v93 int) = (r4v60 int), (r4v79 int), (r4v85 int), (r4v94 int) binds: [B:479:0x0c19, B:424:0x0a9b, B:416:0x0a6e, B:407:0x0a07] A[DONT_GENERATE, DONT_INLINE]
      0x0c30: PHI (r6v126 sun.misc.Unsafe) = (r6v105 sun.misc.Unsafe), (r6v115 sun.misc.Unsafe), (r6v119 sun.misc.Unsafe), (r6v127 sun.misc.Unsafe) binds: [B:479:0x0c19, B:424:0x0a9b, B:416:0x0a6e, B:407:0x0a07] A[DONT_GENERATE, DONT_INLINE]
      0x0c30: PHI (r14v97 com.google.android.gms.internal.play_billing.u) = 
      (r14v69 com.google.android.gms.internal.play_billing.u)
      (r14v83 com.google.android.gms.internal.play_billing.u)
      (r14v88 com.google.android.gms.internal.play_billing.u)
      (r14v98 com.google.android.gms.internal.play_billing.u)
     binds: [B:479:0x0c19, B:424:0x0a9b, B:416:0x0a6e, B:407:0x0a07] A[DONT_GENERATE, DONT_INLINE]
      0x0c30: PHI (r37v36 int) = (r37v11 int), (r37v24 int), (r37v29 int), (r37v37 int) binds: [B:479:0x0c19, B:424:0x0a9b, B:416:0x0a6e, B:407:0x0a07] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:492:0x0c60  */
    /* JADX WARN: Code duplicated, block: B:494:0x0c6a  */
    /* JADX WARN: Code duplicated, block: B:496:0x0c74  */
    /* JADX WARN: Code duplicated, block: B:499:0x0c8f  */
    /* JADX WARN: Code duplicated, block: B:530:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:532:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:0x01fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:0x0278 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:0x02c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:0x02f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:539:0x031f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:540:0x0353 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:0x036f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:542:0x039c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:0x03bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:0x03f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:0x0502 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x04fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:0x0517 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:548:0x054b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:0x0697 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:550:0x0691 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:551:0x067e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:552:0x0678 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:0x074c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:0x0740 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:555:0x07b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:0x07af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:0x07a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:0x07a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:0x07f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:0x07ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x07fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:0x0844 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x083e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x0882 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:0x089c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:0x08fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:0x08f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:0x0904 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:0x091d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:570:0x0937 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:0x0952 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:0x0998 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:0x096d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x09b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:0x0c35 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:0x0c8b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x03de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x021d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x02b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x0310 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x02e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x038e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x03af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x018d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x044c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x043b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x025f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x03ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x09a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0988 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x045a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x09b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0c49 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:631:0x04c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x04c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x04cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x060e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x05f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x0686 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0670 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x066a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x0746 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0735 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0731 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x078d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0746 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0789 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x086e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x027c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0285  */
    /* JADX WARN: Code duplicated, block: B:86:0x028d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0291  */
    /* JADX WARN: Code duplicated, block: B:89:0x0296  */
    /* JADX WARN: Code duplicated, block: B:98:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:99:0x02d5  */
    /* JADX WARN: Multi-variable type inference failed */
    public final int v(Object obj, byte[] bArr, int i, int i2, int i3, C3237ka0 c3237ka0) {
        u uVar;
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int iC;
        C3237ka0 c3237ka1;
        Unsafe unsafe2;
        int iH;
        zzeu zzeuVar;
        zzgl zzglVar;
        boolean z;
        int[] iArr;
        int i7;
        int iD;
        long j;
        int i8;
        int i9;
        int i10;
        int i11;
        Unsafe unsafe3;
        int i12;
        int i13;
        C3237ka0 c3237ka2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z2;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Unsafe unsafe4;
        int i30;
        C3237ka0 c3237ka3;
        int i31;
        int i32;
        Unsafe unsafe5;
        int i33;
        int i34;
        zzfn zzfnVarZzd;
        int size;
        int i35;
        int i36;
        long j2;
        zzfn zzfnVar;
        zzfn zzfnVar2;
        Unsafe unsafe6;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        int iF;
        int i44;
        C2208fc0 c2208fc0;
        int i45;
        C2208fc0 c2208fc1;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        int i51;
        int i52;
        int i53;
        int i54;
        int i55;
        int i56;
        Object[] objArr;
        int i57;
        int i58;
        int i59;
        int i60;
        int i61;
        int i62;
        int i63;
        int iK;
        zzfl zzflVarG;
        Xd0 xd0;
        int i64;
        int i65;
        Iterator it;
        Object objS;
        int iIntValue;
        int size2;
        Object objS2;
        int i66;
        int i67;
        Integer num;
        int iIntValue2;
        int i68;
        C2208fc0 c2208fc2;
        int i69;
        C2208fc0 c2208fc3;
        int i70;
        int i71;
        int i72;
        InterfaceC3814rd0 interfaceC3814rd0H;
        int i73;
        int i74;
        Object object;
        int i75;
        long j3;
        int i76;
        int i77;
        boolean z3;
        int i78;
        int i79;
        int i80;
        Unsafe unsafe7;
        int iA;
        int i81;
        zzfl zzflVarG2;
        u uVar2 = this;
        Object obj2 = obj;
        i2 = i2;
        C3237ka0 c3237ka4 = c3237ka0;
        int i82 = 3;
        g(obj);
        Unsafe unsafe8 = m;
        int i83 = 0;
        int i84 = -1;
        int i85 = 1048575;
        int iM = i;
        int i86 = -1;
        int i87 = 0;
        int i88 = 1048575;
        int i89 = 0;
        int i90 = 0;
        while (true) {
            if (iM < i2) {
                int iL = iM + 1;
                int i91 = bArr[iM];
                if (i91 < 0) {
                    iL = AbstractC3483na0.j(i91, bArr, iL, c3237ka4);
                    i91 = c3237ka4.a;
                }
                i90 = i91;
                int i92 = (i90 == true ? 1 : 0) >>> 3;
                if (i92 > i86) {
                    iC = (i92 < uVar2.c || i92 > uVar2.d) ? -1 : uVar2.C(i92, i87 / i82);
                } else {
                    if (i92 < uVar2.c || i92 > uVar2.d) {
                        i87 = -1;
                    } else {
                        iC = uVar2.C(i92, i83);
                    }
                    if (i87 == i84) {
                        uVar = uVar2;
                        c3237ka1 = c3237ka4;
                        i6 = i90 == true ? 1 : 0;
                        i87 = 0;
                        unsafe2 = unsafe8;
                    } else {
                        z = (i90 == true ? 1 : 0) & 7;
                        iArr = uVar2.a;
                        i7 = iArr[i87 + 1];
                        iD = D(i7);
                        j = i7 & i85;
                        if (iD <= 17) {
                            int i93 = iArr[i87 + 2];
                            i8 = 1 << (i93 >>> 20);
                            i9 = 1048575;
                            i10 = i93 & 1048575;
                            if (i10 != i88) {
                                if (i88 != 1048575) {
                                    unsafe8.putInt(obj2, i88, i89);
                                    i9 = 1048575;
                                }
                                if (i10 == i9) {
                                    i11 = 0;
                                } else {
                                    i11 = unsafe8.getInt(obj2, i10);
                                }
                                i88 = i10;
                            } else {
                                i11 = i89;
                                i88 = i88;
                            }
                            switch (iD) {
                                case 0:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    c3237ka2 = c3237ka0;
                                    if (z == 1) {
                                        i14 = i12 + 8;
                                        i15 = i11 | i8;
                                        AbstractC3491ne0.t(obj2, j, Double.longBitsToDouble(AbstractC3483na0.o(bArr, i12)));
                                        c3237ka4 = c3237ka2;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i14;
                                        unsafe8 = unsafe3;
                                        i89 = i15;
                                    } else {
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 1:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    c3237ka2 = c3237ka0;
                                    if (z == 5) {
                                        i14 = i12 + 4;
                                        i15 = i11 | i8;
                                        AbstractC3491ne0.u(obj2, j, Float.intBitsToFloat(AbstractC3483na0.b(bArr, i12)));
                                        c3237ka4 = c3237ka2;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i14;
                                        unsafe8 = unsafe3;
                                        i89 = i15;
                                    } else {
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    c3237ka2 = c3237ka0;
                                    if (z == 0) {
                                        i17 = i11 | i8;
                                        int iL2 = AbstractC3483na0.l(bArr, i12, c3237ka2);
                                        unsafe8 = unsafe3;
                                        unsafe8.putLong(obj, j, c3237ka2.b);
                                        i2 = i2;
                                        c3237ka4 = c3237ka2;
                                        iM = iL2;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        i89 = i17;
                                        i86 = i13;
                                    } else {
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    c3237ka2 = c3237ka0;
                                    if (z == 0) {
                                        i18 = i11 | i8;
                                        i19 = AbstractC3483na0.i(bArr, i12, c3237ka2);
                                        unsafe3.putInt(obj2, j, c3237ka2.a);
                                        c3237ka4 = c3237ka2;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i19;
                                        int i94 = i88;
                                        i89 = i18;
                                        unsafe8 = unsafe3;
                                        i88 = i94;
                                    } else {
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    i16 = i90 == true ? 1 : 0;
                                    c3237ka2 = c3237ka0;
                                    if (z == 1) {
                                        int i95 = i12 + 8;
                                        int i96 = i11 | i8;
                                        long jO = AbstractC3483na0.o(bArr, i12);
                                        unsafe8 = unsafe3;
                                        i90 = i16 == true ? 1 : 0;
                                        unsafe8.putLong(obj, j, jO);
                                        i2 = i2;
                                        c3237ka4 = c3237ka2;
                                        iM = i95;
                                        i88 = i88;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        i89 = i96;
                                    } else {
                                        i90 = i16;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    i16 = i90 == true ? 1 : 0;
                                    c3237ka2 = c3237ka0;
                                    if (z == 5) {
                                        i14 = i12 + 4;
                                        i15 = i11 | i8;
                                        unsafe3.putInt(obj2, j, AbstractC3483na0.b(bArr, i12));
                                        i90 = i16 == true ? 1 : 0;
                                        c3237ka4 = c3237ka2;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i14;
                                        unsafe8 = unsafe3;
                                        i89 = i15;
                                    } else {
                                        i90 = i16;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 7:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    i16 = i90 == true ? 1 : 0;
                                    c3237ka2 = c3237ka0;
                                    if (z == 0) {
                                        i18 = i11 | i8;
                                        i19 = AbstractC3483na0.l(bArr, i12, c3237ka2);
                                        if (c3237ka2.b != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        AbstractC3491ne0.r(obj2, j, z2);
                                        i90 = i16 == true ? 1 : 0;
                                        c3237ka4 = c3237ka2;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i19;
                                        int i97 = i88;
                                        i89 = i18;
                                        unsafe8 = unsafe3;
                                        i88 = i97;
                                    } else {
                                        i90 = i16;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 8:
                                    unsafe3 = unsafe8;
                                    i12 = iL;
                                    i13 = i92;
                                    i16 = i90 == true ? 1 : 0;
                                    c3237ka2 = c3237ka0;
                                    if (z == 2) {
                                        if ((i7 & PropertyOptions.DELETE_EXISTING) != 0) {
                                            i11 |= i8;
                                            i20 = AbstractC3483na0.g(bArr, i12, c3237ka2);
                                        } else {
                                            i20 = AbstractC3483na0.i(bArr, i12, c3237ka2);
                                            i21 = c3237ka2.a;
                                            if (i21 >= 0) {
                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i11 |= i8;
                                            if (i21 == 0) {
                                                c3237ka2.c = "";
                                            } else {
                                                c3237ka2.c = new String(bArr, i20, i21, zzfo.zza);
                                                i20 += i21;
                                            }
                                        }
                                        unsafe3.putObject(obj2, j, c3237ka2.c);
                                        i90 = i16 == true ? 1 : 0;
                                        c3237ka4 = c3237ka2;
                                        i86 = i13;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i20;
                                        unsafe8 = unsafe3;
                                        i88 = i88;
                                        i89 = i11;
                                        i2 = i2;
                                    } else {
                                        i90 = i16;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 9:
                                    unsafe3 = unsafe8;
                                    i22 = i87;
                                    c3237ka2 = c3237ka0;
                                    if (z == 2) {
                                        i17 = i11 | i8;
                                        Object objJ = uVar2.J(obj2, i22);
                                        i87 = i22;
                                        i2 = i2;
                                        i13 = i92;
                                        int iN = AbstractC3483na0.n(objJ, uVar2.H(i22), bArr, iL, i2, c3237ka0);
                                        uVar2.l(obj2, i87, objJ);
                                        c3237ka4 = c3237ka2;
                                        i90 = i90 == true ? 1 : 0;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = iN;
                                        unsafe8 = unsafe3;
                                        i89 = i17;
                                        i86 = i13;
                                    } else {
                                        i87 = i22;
                                        i13 = i92;
                                        i12 = iL;
                                        i90 = i90 == true ? 1 : 0;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 10:
                                    unsafe3 = unsafe8;
                                    i23 = i87;
                                    c3237ka2 = c3237ka0;
                                    if (z == 2) {
                                        i18 = i11 | i8;
                                        int iA2 = AbstractC3483na0.a(bArr, iL, c3237ka2);
                                        unsafe3.putObject(obj2, j, c3237ka2.c);
                                        i2 = i2;
                                        i87 = i23;
                                        i86 = i92;
                                        c3237ka4 = c3237ka2;
                                        i90 = i90 == true ? 1 : 0;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = iA2;
                                        int i98 = i88;
                                        i89 = i18;
                                        unsafe8 = unsafe3;
                                        i88 = i98;
                                    } else {
                                        i87 = i23;
                                        i13 = i92;
                                        i90 = i90 == true ? 1 : 0;
                                        i12 = iL;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 12:
                                    unsafe3 = unsafe8;
                                    i24 = i87;
                                    i25 = i90 == true ? 1 : 0;
                                    c3237ka2 = c3237ka0;
                                    if (z == 0) {
                                        i20 = AbstractC3483na0.i(bArr, iL, c3237ka2);
                                        i26 = c3237ka2.a;
                                        zzfl zzflVarG3 = uVar2.G(i24);
                                        if ((i7 & Integer.MIN_VALUE) != 0 || zzflVarG3 == null || zzflVarG3.zza(i26)) {
                                            i27 = i25 == true ? 1 : 0;
                                            i11 |= i8;
                                            unsafe3.putInt(obj2, j, i26);
                                        } else {
                                            zzhi zzhiVarW = w(obj);
                                            Long lValueOf = Long.valueOf(i26);
                                            i27 = i25 == true ? 1 : 0;
                                            zzhiVarW.zzj(i27 == true ? 1 : 0, lValueOf);
                                        }
                                        i87 = i24;
                                        i86 = i92;
                                        c3237ka4 = c3237ka2;
                                        i90 = i27;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i20;
                                        unsafe8 = unsafe3;
                                        i88 = i88;
                                        i89 = i11;
                                        i2 = i2;
                                    } else {
                                        i87 = i24;
                                        i13 = i92;
                                        i90 = i25;
                                        i12 = iL;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 15:
                                    unsafe3 = unsafe8;
                                    i28 = i87;
                                    c3237ka2 = c3237ka0;
                                    if (z == 0) {
                                        i18 = i11 | i8;
                                        i19 = AbstractC3483na0.i(bArr, iL, c3237ka2);
                                        unsafe3.putInt(obj2, j, zzel.zzb(c3237ka2.a));
                                        i2 = i2;
                                        i87 = i28;
                                        i86 = i92;
                                        c3237ka4 = c3237ka2;
                                        i90 = i90 == true ? 1 : 0;
                                        i82 = 3;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        iM = i19;
                                        int i99 = i88;
                                        i89 = i18;
                                        unsafe8 = unsafe3;
                                        i88 = i99;
                                    } else {
                                        i87 = i28;
                                        i13 = i92;
                                        i90 = i90 == true ? 1 : 0;
                                        i12 = iL;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                case 16:
                                    i29 = i87;
                                    i25 = i90 == true ? 1 : 0;
                                    if (z == 0) {
                                        int i100 = i11 | i8;
                                        int iL3 = AbstractC3483na0.l(bArr, iL, c3237ka0);
                                        unsafe8.putLong(obj, j, zzel.zzc(c3237ka0.b));
                                        i2 = i2;
                                        c3237ka4 = c3237ka0;
                                        i87 = i29;
                                        i88 = i88;
                                        i90 = i25 == true ? 1 : 0;
                                        i82 = 3;
                                        i84 = -1;
                                        i83 = 0;
                                        i89 = i100;
                                        iM = iL3;
                                        i86 = i92;
                                        i85 = 1048575;
                                    } else {
                                        unsafe3 = unsafe8;
                                        i13 = i92;
                                        c3237ka2 = c3237ka0;
                                        i87 = i29;
                                        i90 = i25;
                                        i12 = iL;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                                default:
                                    i82 = 3;
                                    if (z == 3) {
                                        i15 = i11 | i8;
                                        Object objJ2 = uVar2.J(obj2, i87);
                                        int i101 = i87;
                                        iM = AbstractC3483na0.m(objJ2, uVar2.H(i87), bArr, iL, i2, (i92 << 3) | 4, c3237ka0);
                                        uVar2.l(obj2, i101, objJ2);
                                        i86 = i92;
                                        i2 = i2;
                                        i87 = i101;
                                        i85 = 1048575;
                                        i84 = -1;
                                        i83 = 0;
                                        c3237ka4 = c3237ka0;
                                        i89 = i15;
                                    } else {
                                        unsafe3 = unsafe8;
                                        i87 = i87;
                                        i13 = i92;
                                        c3237ka2 = c3237ka0;
                                        i12 = iL;
                                        uVar = uVar2;
                                        iL = i12;
                                        c3237ka1 = c3237ka2;
                                        unsafe2 = unsafe3;
                                        i88 = i88;
                                        i92 = i13;
                                        i89 = i11;
                                        i6 = i90;
                                    }
                                    break;
                            }
                        } else {
                            unsafe4 = unsafe8;
                            i30 = i92;
                            c3237ka3 = c3237ka4;
                            i31 = iL;
                            if (iD == 27) {
                                i32 = i88;
                                c3237ka1 = c3237ka3;
                                i36 = i87;
                                if (iD <= 49) {
                                    j2 = i7;
                                    zzfnVar = (zzfn) unsafe4.getObject(obj2, j);
                                    if (zzfnVar.zzc()) {
                                        zzfnVar2 = zzfnVar;
                                    } else {
                                        int size3 = zzfnVar.size();
                                        zzfn zzfnVarZzd2 = zzfnVar.zzd(size3 + size3);
                                        unsafe4.putObject(obj2, j, zzfnVarZzd2);
                                        zzfnVar2 = zzfnVarZzd2;
                                    }
                                    switch (iD) {
                                        case 18:
                                        case 35:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i36 = i36;
                                            i38 = i90 == true ? 1 : 0;
                                            i92 = i30;
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            if (z == 2) {
                                                int i102 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                if (AbstractC3483na0.i(bArr, i37, c3237ka1) + c3237ka1.a > bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                throw null;
                                            }
                                            if (z == 1) {
                                                int i103 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                Double.longBitsToDouble(AbstractC3483na0.o(bArr, i37));
                                                throw null;
                                            }
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar3 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar3;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                            break;
                                        case 19:
                                        case 36:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i36 = i36;
                                            i38 = i90 == true ? 1 : 0;
                                            i92 = i30;
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            if (z == 2) {
                                                int i104 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                if (AbstractC3483na0.i(bArr, i37, c3237ka1) + c3237ka1.a > bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                throw null;
                                            }
                                            if (z == 5) {
                                                int i105 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                Float.intBitsToFloat(AbstractC3483na0.b(bArr, i37));
                                                throw null;
                                            }
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar4 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar4;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i36 = i36;
                                            i38 = i90 == true ? 1 : 0;
                                            i92 = i30;
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            if (z == 2) {
                                                int i106 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                i39 = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                i40 = c3237ka1.a + i39;
                                                if (i39 >= i40) {
                                                    AbstractC3483na0.l(bArr, i39, c3237ka1);
                                                    throw null;
                                                }
                                                if (i39 != i40) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (z == 0) {
                                                    int i107 = AbstractC3483na0.a;
                                                    AbstractC3574of.a(zzfnVar2);
                                                    AbstractC3483na0.l(bArr, i37, c3237ka1);
                                                    long j4 = c3237ka1.b;
                                                    throw null;
                                                }
                                                i39 = i37;
                                            }
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar5 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar5;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i41 = i36;
                                            c3237ka1 = c3237ka1;
                                            i42 = i90 == true ? 1 : 0;
                                            i43 = i30;
                                            if (z == 2) {
                                                iF = AbstractC3483na0.f(bArr, i37, zzfnVar2, c3237ka1);
                                                i92 = i43;
                                                i39 = iF;
                                                i38 = i42;
                                                i36 = i41;
                                            } else if (z == 0) {
                                                i92 = i43;
                                                i38 = i42 == true ? 1 : 0;
                                                i36 = i41;
                                                i39 = AbstractC3483na0.k(i42 == true ? 1 : 0, bArr, i37, i2, zzfnVar2, c3237ka0);
                                                this = this;
                                            } else {
                                                i92 = i43;
                                                i38 = i42 == true ? 1 : 0;
                                                i36 = i41;
                                                this = this;
                                                i39 = i37;
                                            }
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar6 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar6;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i41 = i36;
                                            c3237ka1 = c3237ka1;
                                            i42 = i90 == true ? 1 : 0;
                                            i43 = i30;
                                            if (z == 2) {
                                                int i108 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                if (AbstractC3483na0.i(bArr, i37, c3237ka1) + c3237ka1.a > bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                throw null;
                                            }
                                            if (z == 1) {
                                                int i109 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                AbstractC3483na0.o(bArr, i37);
                                                throw null;
                                            }
                                            this = this;
                                            i92 = i43;
                                            i38 = i42;
                                            i36 = i41;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar7 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar7;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i41 = i36;
                                            c3237ka1 = c3237ka1;
                                            i42 = i90 == true ? 1 : 0;
                                            i43 = i30;
                                            if (z == 2) {
                                                if (z == 5) {
                                                    i44 = i37 + 4;
                                                    int i110 = AbstractC3483na0.a;
                                                    c2208fc0 = (C2208fc0) zzfnVar2;
                                                    c2208fc0.d(AbstractC3483na0.b(bArr, i37));
                                                    while (i44 < i2) {
                                                        i45 = AbstractC3483na0.i(bArr, i44, c3237ka1);
                                                        if (i42 == c3237ka1.a) {
                                                            c2208fc0.d(AbstractC3483na0.b(bArr, i45));
                                                            i44 = i45 + 4;
                                                        } else {
                                                            i92 = i43;
                                                            i39 = i44;
                                                        }
                                                    }
                                                    i92 = i43;
                                                    i39 = i44;
                                                }
                                                this = this;
                                                i92 = i43;
                                                i38 = i42;
                                                i36 = i41;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar8 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar8;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                int i111 = AbstractC3483na0.a;
                                                c2208fc1 = (C2208fc0) zzfnVar2;
                                                iF = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                i46 = c3237ka1.a;
                                                i47 = iF + i46;
                                                if (i47 <= bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                c2208fc1.e(c2208fc1.size() + (i46 / 4));
                                                while (iF < i47) {
                                                    c2208fc1.d(AbstractC3483na0.b(bArr, iF));
                                                    iF += 4;
                                                }
                                                if (iF != i47) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i92 = i43;
                                                i39 = iF;
                                            }
                                            i38 = i42;
                                            i36 = i41;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar9 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar9;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i41 = i36;
                                            c3237ka1 = c3237ka1;
                                            i42 = i90 == true ? 1 : 0;
                                            i43 = i30;
                                            if (z == 2) {
                                                int i112 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                iF = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                i48 = c3237ka1.a + iF;
                                                if (iF >= i48) {
                                                    AbstractC3483na0.l(bArr, iF, c3237ka1);
                                                    throw null;
                                                }
                                                if (iF != i48) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i92 = i43;
                                                i39 = iF;
                                                i38 = i42;
                                                i36 = i41;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar10 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar10;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                if (z == 0) {
                                                    int i113 = AbstractC3483na0.a;
                                                    AbstractC3574of.a(zzfnVar2);
                                                    AbstractC3483na0.l(bArr, i37, c3237ka1);
                                                    long j5 = c3237ka1.b;
                                                    throw null;
                                                }
                                                this = this;
                                                i92 = i43;
                                                i38 = i42;
                                                i36 = i41;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar11 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar11;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            }
                                            break;
                                        case 26:
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            c3237ka1 = c3237ka1;
                                            i49 = i30;
                                            if (z == 2) {
                                                if ((536870912 & j2) == 0) {
                                                    i50 = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                    i56 = c3237ka1.a;
                                                    if (i56 >= 0) {
                                                        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i56 == 0) {
                                                        objArr = "";
                                                        zzfnVar2.add(objArr);
                                                    } else {
                                                        objArr = "";
                                                        zzfnVar2.add(new String(bArr, i50, i56, zzfo.zza));
                                                        i50 += i56;
                                                    }
                                                    while (i50 < i2) {
                                                        i57 = AbstractC3483na0.i(bArr, i50, c3237ka1);
                                                        if (i90 == c3237ka1.a) {
                                                            i50 = AbstractC3483na0.i(bArr, i57, c3237ka1);
                                                            i58 = c3237ka1.a;
                                                            if (i58 >= 0) {
                                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i58 == 0) {
                                                                zzfnVar2.add(objArr);
                                                            } else {
                                                                zzfnVar2.add(new String(bArr, i50, i58, zzfo.zza));
                                                                i50 += i58;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    i50 = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                    i51 = c3237ka1.a;
                                                    if (i51 >= 0) {
                                                        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i51 == 0) {
                                                        zzfnVar2.add("");
                                                    } else {
                                                        i52 = i50 + i51;
                                                        if (AbstractC3978te0.d(bArr, i50, i52)) {
                                                            throw new zzfq("Protocol message had invalid UTF-8.");
                                                        }
                                                        zzfnVar2.add(new String(bArr, i50, i51, zzfo.zza));
                                                        i50 = i52;
                                                    }
                                                    while (i50 < i2) {
                                                        i53 = AbstractC3483na0.i(bArr, i50, c3237ka1);
                                                        if (i90 == c3237ka1.a) {
                                                            i50 = AbstractC3483na0.i(bArr, i53, c3237ka1);
                                                            i54 = c3237ka1.a;
                                                            if (i54 >= 0) {
                                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i54 == 0) {
                                                                zzfnVar2.add("");
                                                            } else {
                                                                i55 = i50 + i54;
                                                                if (AbstractC3978te0.d(bArr, i50, i55)) {
                                                                    throw new zzfq("Protocol message had invalid UTF-8.");
                                                                }
                                                                zzfnVar2.add(new String(bArr, i50, i54, zzfo.zza));
                                                                i50 = i55;
                                                            }
                                                        }
                                                    }
                                                }
                                                i38 = i90 == true ? 1 : 0;
                                                i36 = i36;
                                                int i114 = i50;
                                                i92 = i49;
                                                i39 = i114;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar12 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar12;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                this = this;
                                                i92 = i49;
                                                i38 = i90 == true ? 1 : 0;
                                                i36 = i36;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar13 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar13;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            }
                                            break;
                                        case 27:
                                            unsafe6 = unsafe4;
                                            i38 = i90 == true ? 1 : 0;
                                            i49 = i30;
                                            if (z == 2) {
                                                c3237ka1 = c3237ka1;
                                                i37 = i31;
                                                i50 = AbstractC3483na0.e(H(i36), i38 == true ? 1 : 0, bArr, i31, i2, zzfnVar2, c3237ka0);
                                                i38 = i38 == true ? 1 : 0;
                                                i36 = i36;
                                                int i115 = i50;
                                                i92 = i49;
                                                i39 = i115;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar14 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar14;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                i37 = i31;
                                                i92 = i49;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar15 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar15;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            }
                                            break;
                                        case 28:
                                            unsafe6 = unsafe4;
                                            i38 = i90 == true ? 1 : 0;
                                            i49 = i30;
                                            if (z == 2) {
                                                i59 = AbstractC3483na0.i(bArr, i31, c3237ka1);
                                                i60 = c3237ka1.a;
                                                if (i60 >= 0) {
                                                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i60 <= bArr.length - i59) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i60 == 0) {
                                                    zzfnVar2.add(zzei.zzb);
                                                } else {
                                                    zzfnVar2.add(zzei.zzj(bArr, i59, i60));
                                                    i59 += i60;
                                                }
                                                while (i59 < i2) {
                                                    i61 = AbstractC3483na0.i(bArr, i59, c3237ka1);
                                                    if (i38 == c3237ka1.a) {
                                                        i59 = AbstractC3483na0.i(bArr, i61, c3237ka1);
                                                        i62 = c3237ka1.a;
                                                        if (i62 >= 0) {
                                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i62 <= bArr.length - i59) {
                                                            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i62 == 0) {
                                                            zzfnVar2.add(zzei.zzb);
                                                        } else {
                                                            zzfnVar2.add(zzei.zzj(bArr, i59, i62));
                                                            i59 += i62;
                                                        }
                                                    } else {
                                                        this = this;
                                                        c3237ka1 = c3237ka1;
                                                        i37 = i31;
                                                        i36 = i36;
                                                        i92 = i49;
                                                        i39 = i59;
                                                    }
                                                }
                                                this = this;
                                                c3237ka1 = c3237ka1;
                                                i37 = i31;
                                                i36 = i36;
                                                i92 = i49;
                                                i39 = i59;
                                            } else {
                                                i37 = i31;
                                                i92 = i49;
                                                i39 = i37;
                                            }
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar16 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar16;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            unsafe6 = unsafe4;
                                            i63 = i31;
                                            i38 = i90 == true ? 1 : 0;
                                            if (z == 2) {
                                                iK = AbstractC3483na0.f(bArr, i63, zzfnVar2, c3237ka1);
                                            } else if (z == 0) {
                                                this = this;
                                                c3237ka1 = c3237ka1;
                                                i37 = i63;
                                                i36 = i36;
                                                i92 = i30;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar17 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar17;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                iK = AbstractC3483na0.k(i38 == true ? 1 : 0, bArr, i63, i2, zzfnVar2, c3237ka0);
                                            }
                                            zzflVarG = uVar2.G(i36);
                                            xd0 = uVar2.j;
                                            Xd0 xd1 = w.a;
                                            if (zzflVarG != null) {
                                                i64 = iK;
                                                i65 = i30;
                                            } else if (zzfnVar2 instanceof RandomAccess) {
                                                size2 = zzfnVar2.size();
                                                objS2 = null;
                                                i66 = 0;
                                                i67 = 0;
                                                while (i66 < size2) {
                                                    int i116 = iK;
                                                    num = (Integer) zzfnVar2.get(i66);
                                                    iIntValue2 = num.intValue();
                                                    if (zzflVarG.zza(iIntValue2)) {
                                                        if (i66 != i67) {
                                                            zzfnVar2.set(i67, num);
                                                        }
                                                        i67++;
                                                        i68 = i30;
                                                    } else {
                                                        i68 = i30;
                                                        objS2 = w.s(obj2, i68, iIntValue2, objS2, xd0);
                                                    }
                                                    i66++;
                                                    i30 = i68;
                                                    iK = i116;
                                                }
                                                i64 = iK;
                                                i65 = i30;
                                                if (i67 != size2) {
                                                    zzfnVar2.subList(i67, size2).clear();
                                                }
                                            } else {
                                                i64 = iK;
                                                i65 = i30;
                                                it = zzfnVar2.iterator();
                                                objS = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!zzflVarG.zza(iIntValue)) {
                                                        objS = w.s(obj2, i65, iIntValue, objS, xd0);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            this = this;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i65;
                                            i39 = i64;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar18 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar18;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            unsafe6 = unsafe4;
                                            i63 = i31;
                                            i38 = i90 == true ? 1 : 0;
                                            if (z == 2) {
                                                if (z == 0) {
                                                    int i117 = AbstractC3483na0.a;
                                                    c2208fc2 = (C2208fc0) zzfnVar2;
                                                    i39 = AbstractC3483na0.i(bArr, i63, c3237ka1);
                                                    c2208fc2.d(zzel.zzb(c3237ka1.a));
                                                    while (i39 < i2) {
                                                        i69 = AbstractC3483na0.i(bArr, i39, c3237ka1);
                                                        if (i38 == c3237ka1.a) {
                                                            i39 = AbstractC3483na0.i(bArr, i69, c3237ka1);
                                                            c2208fc2.d(zzel.zzb(c3237ka1.a));
                                                        }
                                                    }
                                                }
                                                this = uVar2;
                                                c3237ka1 = c3237ka1;
                                                i37 = i63;
                                                i36 = i36;
                                                i92 = i30;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar19 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar19;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                int i118 = AbstractC3483na0.a;
                                                c2208fc3 = (C2208fc0) zzfnVar2;
                                                i39 = AbstractC3483na0.i(bArr, i63, c3237ka1);
                                                i70 = c3237ka1.a + i39;
                                                while (i39 < i70) {
                                                    i39 = AbstractC3483na0.i(bArr, i39, c3237ka1);
                                                    c2208fc3.d(zzel.zzb(c3237ka1.a));
                                                }
                                                if (i39 != i70) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i30;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar110 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar110;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            unsafe6 = unsafe4;
                                            i63 = i31;
                                            i38 = i90 == true ? 1 : 0;
                                            if (z == 2) {
                                                int i119 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                i39 = AbstractC3483na0.i(bArr, i63, c3237ka1);
                                                i71 = c3237ka1.a + i39;
                                                if (i39 >= i71) {
                                                    AbstractC3483na0.l(bArr, i39, c3237ka1);
                                                    zzel.zzc(c3237ka1.b);
                                                    throw null;
                                                }
                                                if (i39 != i71) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                this = uVar2;
                                                c3237ka1 = c3237ka1;
                                                i37 = i63;
                                                i36 = i36;
                                                i92 = i30;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar111 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar111;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                if (z == 0) {
                                                    int i120 = AbstractC3483na0.a;
                                                    AbstractC3574of.a(zzfnVar2);
                                                    AbstractC3483na0.l(bArr, i63, c3237ka1);
                                                    zzel.zzc(c3237ka1.b);
                                                    throw null;
                                                }
                                                this = uVar2;
                                                c3237ka1 = c3237ka1;
                                                i37 = i63;
                                                i36 = i36;
                                                i92 = i30;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar112 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar112;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            }
                                            break;
                                        default:
                                            if (z == 3) {
                                                i72 = ((i90 == true ? 1 : 0) & (-8)) | 4;
                                                interfaceC3814rd0H = uVar2.H(i36);
                                                unsafe6 = unsafe4;
                                                i63 = i31;
                                                i39 = AbstractC3483na0.c(interfaceC3814rd0H, bArr, i31, i2, i72, c3237ka0);
                                                zzfnVar2.add(c3237ka1.c);
                                                while (true) {
                                                    if (i39 < i2) {
                                                        i73 = AbstractC3483na0.i(bArr, i39, c3237ka1);
                                                        i74 = i90;
                                                        if (i74 == c3237ka1.a) {
                                                            i39 = AbstractC3483na0.c(interfaceC3814rd0H, bArr, i73, i2, i72, c3237ka0);
                                                            zzfnVar2.add(c3237ka1.c);
                                                            i90 = i74 == true ? 1 : 0;
                                                            interfaceC3814rd0H = interfaceC3814rd0H;
                                                        } else {
                                                            i38 = i74 == true ? 1 : 0;
                                                        }
                                                    } else {
                                                        i38 = i90;
                                                    }
                                                }
                                                this = uVar2;
                                                c3237ka1 = c3237ka1;
                                                i37 = i63;
                                                i36 = i36;
                                                i92 = i30;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar113 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar113;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            } else {
                                                unsafe6 = unsafe4;
                                                i37 = i31;
                                                i36 = i36;
                                                i38 = i90 == true ? 1 : 0;
                                                i92 = i30;
                                                this = uVar2;
                                                c3237ka1 = c3237ka1;
                                                i39 = i37;
                                                if (i39 != i37) {
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i86 = i92;
                                                    i90 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i83 = 0;
                                                    iM = i39;
                                                    unsafe8 = unsafe6;
                                                    u uVar114 = this;
                                                    c3237ka4 = c3237ka1;
                                                    uVar2 = uVar114;
                                                } else {
                                                    obj2 = obj;
                                                    iL = i39;
                                                    uVar = this;
                                                    i6 = i38;
                                                    i87 = i36;
                                                    i88 = i32;
                                                    unsafe2 = unsafe6;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    i34 = i36;
                                    i6 = i90 == true ? 1 : 0;
                                    i92 = i30;
                                    uVar = uVar2;
                                    c3237ka1 = c3237ka1;
                                    if (iD == 50) {
                                        i75 = i31;
                                        obj2 = obj;
                                        j3 = iArr[i34 + 2] & 1048575;
                                        switch (iD) {
                                            case 51:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i76 = i75;
                                                if (z == 1) {
                                                    iL = i76 + 8;
                                                    unsafe2.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(AbstractC3483na0.o(bArr, i76))));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                } else {
                                                    iL = i76;
                                                }
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 52:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                if (z == 5) {
                                                    iL = i75 + 4;
                                                    i76 = i75;
                                                    unsafe2.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(AbstractC3483na0.b(bArr, i76))));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                } else {
                                                    i76 = i75;
                                                    iL = i76;
                                                }
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i77 = i75;
                                                if (z == 0) {
                                                    iL = AbstractC3483na0.l(bArr, i77, c3237ka1);
                                                    i75 = i77;
                                                    unsafe2.putObject(obj2, j, Long.valueOf(c3237ka1.b));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                    i76 = i75;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i77 = i75;
                                                if (z == 0) {
                                                    iL = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                    unsafe2.putObject(obj2, j, Integer.valueOf(c3237ka1.a));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i77 = i75;
                                                if (z == 1) {
                                                    iL = i77 + 8;
                                                    unsafe2.putObject(obj2, j, Long.valueOf(AbstractC3483na0.o(bArr, i77)));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i77 = i75;
                                                if (z == 5) {
                                                    iL = i77 + 4;
                                                    unsafe2.putObject(obj2, j, Integer.valueOf(AbstractC3483na0.b(bArr, i77)));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 58:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i77 = i75;
                                                if (z == 0) {
                                                    iL = AbstractC3483na0.l(bArr, i77, c3237ka1);
                                                    if (c3237ka1.b != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    unsafe2.putObject(obj2, j, Boolean.valueOf(z3));
                                                    unsafe2.putInt(obj2, j3, i92);
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 59:
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i77 = i75;
                                                if (z == 2) {
                                                    i78 = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                    i79 = c3237ka1.a;
                                                    if (i79 == 0) {
                                                        unsafe2.putObject(obj2, j, "");
                                                    } else {
                                                        i80 = i78 + i79;
                                                        if ((i7 & PropertyOptions.DELETE_EXISTING) == 0 && !AbstractC3978te0.d(bArr, i78, i80)) {
                                                            throw new zzfq("Protocol message had invalid UTF-8.");
                                                        }
                                                        unsafe2.putObject(obj2, j, new String(bArr, i78, i79, zzfo.zza));
                                                        i78 = i80;
                                                    }
                                                    unsafe2.putInt(obj2, j3, i92);
                                                    iL = i78;
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                } else {
                                                    i34 = i34;
                                                    i76 = i77;
                                                    iL = i76;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                break;
                                            case 60:
                                                unsafe7 = unsafe4;
                                                i77 = i75;
                                                if (z == 2) {
                                                    Object objK = uVar.K(obj2, i92, i34);
                                                    i76 = i77;
                                                    uVar = uVar;
                                                    int iN2 = AbstractC3483na0.n(objK, uVar.H(i34), bArr, i76, i2, c3237ka0);
                                                    uVar.m(obj2, i92, i34, objK);
                                                    iL = iN2;
                                                    i34 = i34;
                                                    unsafe2 = unsafe7;
                                                    i6 = i6 == true ? 1 : 0;
                                                } else {
                                                    unsafe2 = unsafe7;
                                                    i76 = i77;
                                                    iL = i76;
                                                }
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 61:
                                                unsafe7 = unsafe4;
                                                i77 = i75;
                                                if (z == 2) {
                                                    iA = AbstractC3483na0.a(bArr, i77, c3237ka1);
                                                    unsafe7.putObject(obj2, j, c3237ka1.c);
                                                    unsafe7.putInt(obj2, j3, i92);
                                                    i34 = i34;
                                                    uVar = uVar;
                                                    iL = iA;
                                                    unsafe2 = unsafe7;
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 63:
                                                unsafe7 = unsafe4;
                                                i77 = i75;
                                                if (z == 0) {
                                                    iA = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                    i81 = c3237ka1.a;
                                                    zzflVarG2 = uVar.G(i34);
                                                    if (zzflVarG2 != null || zzflVarG2.zza(i81)) {
                                                        unsafe7.putObject(obj2, j, Integer.valueOf(i81));
                                                        unsafe7.putInt(obj2, j3, i92);
                                                    } else {
                                                        w(obj).zzj(i6 == true ? 1 : 0, Long.valueOf(i81));
                                                    }
                                                    i34 = i34;
                                                    uVar = uVar;
                                                    iL = iA;
                                                    unsafe2 = unsafe7;
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 66:
                                                unsafe7 = unsafe4;
                                                i77 = i75;
                                                if (z == 0) {
                                                    iA = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                    unsafe7.putObject(obj2, j, Integer.valueOf(zzel.zzb(c3237ka1.a)));
                                                    unsafe7.putInt(obj2, j3, i92);
                                                    i34 = i34;
                                                    uVar = uVar;
                                                    iL = iA;
                                                    unsafe2 = unsafe7;
                                                    i76 = i77;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                }
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 67:
                                                if (z == 0) {
                                                    int iL4 = AbstractC3483na0.l(bArr, i75, c3237ka1);
                                                    unsafe4.putObject(obj2, j, Long.valueOf(zzel.zzc(c3237ka1.b)));
                                                    unsafe4.putInt(obj2, j3, i92);
                                                    uVar = uVar;
                                                    unsafe2 = unsafe4;
                                                    i76 = i75;
                                                    iL = iL4;
                                                    i34 = i34;
                                                } else {
                                                    i34 = i34;
                                                    uVar = uVar;
                                                    unsafe2 = unsafe4;
                                                    i76 = i75;
                                                    iL = i76;
                                                }
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            case 68:
                                                if (z == 3) {
                                                    int i121 = ((i6 == true ? 1 : 0) & (-8)) | 4;
                                                    Object objK2 = uVar.K(obj2, i92, i34);
                                                    int iM2 = AbstractC3483na0.m(objK2, uVar.H(i34), bArr, i75, i2, i121, c3237ka0);
                                                    uVar.m(obj2, i92, i34, objK2);
                                                    i34 = i34;
                                                    uVar = uVar;
                                                    iL = iM2;
                                                    i92 = i92;
                                                    unsafe2 = unsafe4;
                                                    i76 = i75;
                                                    i87 = i34;
                                                    if (iL != i76) {
                                                        i90 = i6 == true ? 1 : 0;
                                                        unsafe8 = unsafe2;
                                                        i86 = i92;
                                                        i88 = i32;
                                                        i82 = 3;
                                                        i85 = 1048575;
                                                        i84 = -1;
                                                        i2 = i2;
                                                        c3237ka4 = c3237ka1;
                                                        iM = iL;
                                                        uVar2 = uVar;
                                                        i83 = 0;
                                                    } else {
                                                        i88 = i32;
                                                    }
                                                    break;
                                                }
                                            default:
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i76 = i75;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (z == 2) {
                                            Object objI = uVar.I(i34);
                                            object = unsafe4.getObject(obj, j);
                                            if (!((zzgf) object).zze()) {
                                                zzgf zzgfVarZzb = zzgf.zza().zzb();
                                                Wc0.a(zzgfVarZzb, object);
                                                unsafe4.putObject(obj, j, zzgfVarZzb);
                                            }
                                            throw null;
                                        }
                                        i33 = i31;
                                        unsafe5 = unsafe4;
                                        obj2 = obj;
                                    }
                                }
                            } else if (z == 2) {
                                zzfnVarZzd = (zzfn) unsafe4.getObject(obj2, j);
                                if (!zzfnVarZzd.zzc()) {
                                    size = zzfnVarZzd.size();
                                    if (size == 0) {
                                        i35 = 10;
                                    } else {
                                        i35 = size + size;
                                    }
                                    zzfnVarZzd = zzfnVarZzd.zzd(i35);
                                    unsafe4.putObject(obj2, j, zzfnVarZzd);
                                }
                                iM = AbstractC3483na0.e(uVar2.H(i87), i90 == true ? 1 : 0, bArr, i31, i2, zzfnVarZzd, c3237ka0);
                                c3237ka4 = c3237ka0;
                                i87 = i87;
                                unsafe8 = unsafe4;
                                i88 = i88;
                                i86 = i30;
                                i82 = 3;
                                i85 = 1048575;
                                i84 = -1;
                                i83 = 0;
                                i2 = i2;
                            } else {
                                i32 = i88;
                                unsafe5 = unsafe4;
                                i33 = i31;
                                i34 = i87;
                                i6 = i90 == true ? 1 : 0;
                                i92 = i30;
                                uVar = uVar2;
                                c3237ka1 = c3237ka0;
                            }
                            i87 = i34;
                            uVar = uVar;
                            unsafe2 = unsafe5;
                            i88 = i32;
                            iL = i33;
                        }
                    }
                    if (i6 == i3 || i3 == 0) {
                        if (uVar.f) {
                            zzeuVar = c3237ka1.d;
                            int i122 = zzeu.zzb;
                            C3407md0 c3407md0 = C3407md0.c;
                            if (zzeuVar != zzeu.zza) {
                                zzglVar = uVar.e;
                                int i123 = AbstractC3483na0.a;
                                if (zzeuVar.zzb(zzglVar, i92) == null) {
                                    throw null;
                                }
                                zzhi zzhiVarW2 = w(obj);
                                Object[] objArr2 = i6 == true ? 1 : 0;
                                i90 = i6 == true ? 1 : 0;
                                iH = AbstractC3483na0.h(objArr2 == true ? 1 : 0, bArr, iL, i2, zzhiVarW2, c3237ka0);
                            } else {
                                i90 = i6 == true ? 1 : 0;
                                iH = AbstractC3483na0.h(i90 == true ? 1 : 0, bArr, iL, i2, w(obj), c3237ka0);
                            }
                        } else {
                            i90 = i6 == true ? 1 : 0;
                            iH = AbstractC3483na0.h(i90 == true ? 1 : 0, bArr, iL, i2, w(obj), c3237ka0);
                        }
                        c3237ka4 = c3237ka1;
                        i86 = i92;
                        i2 = i2;
                        uVar2 = uVar;
                        i82 = 3;
                        i85 = 1048575;
                        i83 = 0;
                        iM = iH;
                        unsafe8 = unsafe2;
                        i84 = -1;
                    } else {
                        i4 = i2;
                        iM = iL;
                        unsafe = unsafe2;
                        i5 = i89;
                    }
                }
                i87 = iC;
                if (i87 == i84) {
                    uVar = uVar2;
                    c3237ka1 = c3237ka4;
                    i6 = i90 == true ? 1 : 0;
                    i87 = 0;
                    unsafe2 = unsafe8;
                } else {
                    z = (i90 == true ? 1 : 0) & 7;
                    iArr = uVar2.a;
                    i7 = iArr[i87 + 1];
                    iD = D(i7);
                    j = i7 & i85;
                    if (iD <= 17) {
                        int i910 = iArr[i87 + 2];
                        i8 = 1 << (i910 >>> 20);
                        i9 = 1048575;
                        i10 = i910 & 1048575;
                        if (i10 != i88) {
                            if (i88 != 1048575) {
                                unsafe8.putInt(obj2, i88, i89);
                                i9 = 1048575;
                            }
                            if (i10 == i9) {
                                i11 = 0;
                            } else {
                                i11 = unsafe8.getInt(obj2, i10);
                            }
                            i88 = i10;
                        } else {
                            i11 = i89;
                            i88 = i88;
                        }
                        switch (iD) {
                            case 0:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                c3237ka2 = c3237ka0;
                                if (z == 1) {
                                    i14 = i12 + 8;
                                    i15 = i11 | i8;
                                    AbstractC3491ne0.t(obj2, j, Double.longBitsToDouble(AbstractC3483na0.o(bArr, i12)));
                                    c3237ka4 = c3237ka2;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i14;
                                    unsafe8 = unsafe3;
                                    i89 = i15;
                                } else {
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 1:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                c3237ka2 = c3237ka0;
                                if (z == 5) {
                                    i14 = i12 + 4;
                                    i15 = i11 | i8;
                                    AbstractC3491ne0.u(obj2, j, Float.intBitsToFloat(AbstractC3483na0.b(bArr, i12)));
                                    c3237ka4 = c3237ka2;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i14;
                                    unsafe8 = unsafe3;
                                    i89 = i15;
                                } else {
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 2:
                            case 3:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                c3237ka2 = c3237ka0;
                                if (z == 0) {
                                    i17 = i11 | i8;
                                    int iL5 = AbstractC3483na0.l(bArr, i12, c3237ka2);
                                    unsafe8 = unsafe3;
                                    unsafe8.putLong(obj, j, c3237ka2.b);
                                    i2 = i2;
                                    c3237ka4 = c3237ka2;
                                    iM = iL5;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    i89 = i17;
                                    i86 = i13;
                                } else {
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 4:
                            case 11:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                c3237ka2 = c3237ka0;
                                if (z == 0) {
                                    i18 = i11 | i8;
                                    i19 = AbstractC3483na0.i(bArr, i12, c3237ka2);
                                    unsafe3.putInt(obj2, j, c3237ka2.a);
                                    c3237ka4 = c3237ka2;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i19;
                                    int i911 = i88;
                                    i89 = i18;
                                    unsafe8 = unsafe3;
                                    i88 = i911;
                                } else {
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 5:
                            case 14:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                i16 = i90 == true ? 1 : 0;
                                c3237ka2 = c3237ka0;
                                if (z == 1) {
                                    int i912 = i12 + 8;
                                    int i913 = i11 | i8;
                                    long jO2 = AbstractC3483na0.o(bArr, i12);
                                    unsafe8 = unsafe3;
                                    i90 = i16 == true ? 1 : 0;
                                    unsafe8.putLong(obj, j, jO2);
                                    i2 = i2;
                                    c3237ka4 = c3237ka2;
                                    iM = i912;
                                    i88 = i88;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    i89 = i913;
                                } else {
                                    i90 = i16;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 6:
                            case 13:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                i16 = i90 == true ? 1 : 0;
                                c3237ka2 = c3237ka0;
                                if (z == 5) {
                                    i14 = i12 + 4;
                                    i15 = i11 | i8;
                                    unsafe3.putInt(obj2, j, AbstractC3483na0.b(bArr, i12));
                                    i90 = i16 == true ? 1 : 0;
                                    c3237ka4 = c3237ka2;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i14;
                                    unsafe8 = unsafe3;
                                    i89 = i15;
                                } else {
                                    i90 = i16;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 7:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                i16 = i90 == true ? 1 : 0;
                                c3237ka2 = c3237ka0;
                                if (z == 0) {
                                    i18 = i11 | i8;
                                    i19 = AbstractC3483na0.l(bArr, i12, c3237ka2);
                                    if (c3237ka2.b != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    AbstractC3491ne0.r(obj2, j, z2);
                                    i90 = i16 == true ? 1 : 0;
                                    c3237ka4 = c3237ka2;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i19;
                                    int i914 = i88;
                                    i89 = i18;
                                    unsafe8 = unsafe3;
                                    i88 = i914;
                                } else {
                                    i90 = i16;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 8:
                                unsafe3 = unsafe8;
                                i12 = iL;
                                i13 = i92;
                                i16 = i90 == true ? 1 : 0;
                                c3237ka2 = c3237ka0;
                                if (z == 2) {
                                    if ((i7 & PropertyOptions.DELETE_EXISTING) != 0) {
                                        i11 |= i8;
                                        i20 = AbstractC3483na0.g(bArr, i12, c3237ka2);
                                    } else {
                                        i20 = AbstractC3483na0.i(bArr, i12, c3237ka2);
                                        i21 = c3237ka2.a;
                                        if (i21 >= 0) {
                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i11 |= i8;
                                        if (i21 == 0) {
                                            c3237ka2.c = "";
                                        } else {
                                            c3237ka2.c = new String(bArr, i20, i21, zzfo.zza);
                                            i20 += i21;
                                        }
                                    }
                                    unsafe3.putObject(obj2, j, c3237ka2.c);
                                    i90 = i16 == true ? 1 : 0;
                                    c3237ka4 = c3237ka2;
                                    i86 = i13;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i20;
                                    unsafe8 = unsafe3;
                                    i88 = i88;
                                    i89 = i11;
                                    i2 = i2;
                                } else {
                                    i90 = i16;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 9:
                                unsafe3 = unsafe8;
                                i22 = i87;
                                c3237ka2 = c3237ka0;
                                if (z == 2) {
                                    i17 = i11 | i8;
                                    Object objJ3 = uVar2.J(obj2, i22);
                                    i87 = i22;
                                    i2 = i2;
                                    i13 = i92;
                                    int iN3 = AbstractC3483na0.n(objJ3, uVar2.H(i22), bArr, iL, i2, c3237ka0);
                                    uVar2.l(obj2, i87, objJ3);
                                    c3237ka4 = c3237ka2;
                                    i90 = i90 == true ? 1 : 0;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = iN3;
                                    unsafe8 = unsafe3;
                                    i89 = i17;
                                    i86 = i13;
                                } else {
                                    i87 = i22;
                                    i13 = i92;
                                    i12 = iL;
                                    i90 = i90 == true ? 1 : 0;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 10:
                                unsafe3 = unsafe8;
                                i23 = i87;
                                c3237ka2 = c3237ka0;
                                if (z == 2) {
                                    i18 = i11 | i8;
                                    int iA3 = AbstractC3483na0.a(bArr, iL, c3237ka2);
                                    unsafe3.putObject(obj2, j, c3237ka2.c);
                                    i2 = i2;
                                    i87 = i23;
                                    i86 = i92;
                                    c3237ka4 = c3237ka2;
                                    i90 = i90 == true ? 1 : 0;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = iA3;
                                    int i915 = i88;
                                    i89 = i18;
                                    unsafe8 = unsafe3;
                                    i88 = i915;
                                } else {
                                    i87 = i23;
                                    i13 = i92;
                                    i90 = i90 == true ? 1 : 0;
                                    i12 = iL;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 12:
                                unsafe3 = unsafe8;
                                i24 = i87;
                                i25 = i90 == true ? 1 : 0;
                                c3237ka2 = c3237ka0;
                                if (z == 0) {
                                    i20 = AbstractC3483na0.i(bArr, iL, c3237ka2);
                                    i26 = c3237ka2.a;
                                    zzfl zzflVarG4 = uVar2.G(i24);
                                    if ((i7 & Integer.MIN_VALUE) != 0) {
                                        i27 = i25 == true ? 1 : 0;
                                        i11 |= i8;
                                        unsafe3.putInt(obj2, j, i26);
                                    } else {
                                        i27 = i25 == true ? 1 : 0;
                                        i11 |= i8;
                                        unsafe3.putInt(obj2, j, i26);
                                    }
                                    i87 = i24;
                                    i86 = i92;
                                    c3237ka4 = c3237ka2;
                                    i90 = i27;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i20;
                                    unsafe8 = unsafe3;
                                    i88 = i88;
                                    i89 = i11;
                                    i2 = i2;
                                } else {
                                    i87 = i24;
                                    i13 = i92;
                                    i90 = i25;
                                    i12 = iL;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 15:
                                unsafe3 = unsafe8;
                                i28 = i87;
                                c3237ka2 = c3237ka0;
                                if (z == 0) {
                                    i18 = i11 | i8;
                                    i19 = AbstractC3483na0.i(bArr, iL, c3237ka2);
                                    unsafe3.putInt(obj2, j, zzel.zzb(c3237ka2.a));
                                    i2 = i2;
                                    i87 = i28;
                                    i86 = i92;
                                    c3237ka4 = c3237ka2;
                                    i90 = i90 == true ? 1 : 0;
                                    i82 = 3;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    iM = i19;
                                    int i916 = i88;
                                    i89 = i18;
                                    unsafe8 = unsafe3;
                                    i88 = i916;
                                } else {
                                    i87 = i28;
                                    i13 = i92;
                                    i90 = i90 == true ? 1 : 0;
                                    i12 = iL;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            case 16:
                                i29 = i87;
                                i25 = i90 == true ? 1 : 0;
                                if (z == 0) {
                                    int i1010 = i11 | i8;
                                    int iL6 = AbstractC3483na0.l(bArr, iL, c3237ka0);
                                    unsafe8.putLong(obj, j, zzel.zzc(c3237ka0.b));
                                    i2 = i2;
                                    c3237ka4 = c3237ka0;
                                    i87 = i29;
                                    i88 = i88;
                                    i90 = i25 == true ? 1 : 0;
                                    i82 = 3;
                                    i84 = -1;
                                    i83 = 0;
                                    i89 = i1010;
                                    iM = iL6;
                                    i86 = i92;
                                    i85 = 1048575;
                                } else {
                                    unsafe3 = unsafe8;
                                    i13 = i92;
                                    c3237ka2 = c3237ka0;
                                    i87 = i29;
                                    i90 = i25;
                                    i12 = iL;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                            default:
                                i82 = 3;
                                if (z == 3) {
                                    i15 = i11 | i8;
                                    Object objJ4 = uVar2.J(obj2, i87);
                                    int i1011 = i87;
                                    iM = AbstractC3483na0.m(objJ4, uVar2.H(i87), bArr, iL, i2, (i92 << 3) | 4, c3237ka0);
                                    uVar2.l(obj2, i1011, objJ4);
                                    i86 = i92;
                                    i2 = i2;
                                    i87 = i1011;
                                    i85 = 1048575;
                                    i84 = -1;
                                    i83 = 0;
                                    c3237ka4 = c3237ka0;
                                    i89 = i15;
                                } else {
                                    unsafe3 = unsafe8;
                                    i87 = i87;
                                    i13 = i92;
                                    c3237ka2 = c3237ka0;
                                    i12 = iL;
                                    uVar = uVar2;
                                    iL = i12;
                                    c3237ka1 = c3237ka2;
                                    unsafe2 = unsafe3;
                                    i88 = i88;
                                    i92 = i13;
                                    i89 = i11;
                                    i6 = i90;
                                }
                                break;
                        }
                    } else {
                        unsafe4 = unsafe8;
                        i30 = i92;
                        c3237ka3 = c3237ka4;
                        i31 = iL;
                        if (iD == 27) {
                            i32 = i88;
                            c3237ka1 = c3237ka3;
                            i36 = i87;
                            if (iD <= 49) {
                                j2 = i7;
                                zzfnVar = (zzfn) unsafe4.getObject(obj2, j);
                                if (zzfnVar.zzc()) {
                                    int size4 = zzfnVar.size();
                                    zzfn zzfnVarZzd3 = zzfnVar.zzd(size4 + size4);
                                    unsafe4.putObject(obj2, j, zzfnVarZzd3);
                                    zzfnVar2 = zzfnVarZzd3;
                                } else {
                                    zzfnVar2 = zzfnVar;
                                }
                                switch (iD) {
                                    case 18:
                                    case 35:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i36 = i36;
                                        i38 = i90 == true ? 1 : 0;
                                        i92 = i30;
                                        this = uVar2;
                                        c3237ka1 = c3237ka1;
                                        if (z == 2) {
                                            int i1012 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            if (AbstractC3483na0.i(bArr, i37, c3237ka1) + c3237ka1.a > bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            throw null;
                                        }
                                        if (z == 1) {
                                            int i1013 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            Double.longBitsToDouble(AbstractC3483na0.o(bArr, i37));
                                            throw null;
                                        }
                                        i39 = i37;
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar115 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar115;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                        break;
                                    case 19:
                                    case 36:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i36 = i36;
                                        i38 = i90 == true ? 1 : 0;
                                        i92 = i30;
                                        this = uVar2;
                                        c3237ka1 = c3237ka1;
                                        if (z == 2) {
                                            int i1014 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            if (AbstractC3483na0.i(bArr, i37, c3237ka1) + c3237ka1.a > bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            throw null;
                                        }
                                        if (z == 5) {
                                            int i1015 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            Float.intBitsToFloat(AbstractC3483na0.b(bArr, i37));
                                            throw null;
                                        }
                                        i39 = i37;
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar116 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar116;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i36 = i36;
                                        i38 = i90 == true ? 1 : 0;
                                        i92 = i30;
                                        this = uVar2;
                                        c3237ka1 = c3237ka1;
                                        if (z == 2) {
                                            int i1016 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            i39 = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                            i40 = c3237ka1.a + i39;
                                            if (i39 >= i40) {
                                                AbstractC3483na0.l(bArr, i39, c3237ka1);
                                                throw null;
                                            }
                                            if (i39 != i40) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else {
                                            if (z == 0) {
                                                int i1017 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                AbstractC3483na0.l(bArr, i37, c3237ka1);
                                                long j6 = c3237ka1.b;
                                                throw null;
                                            }
                                            i39 = i37;
                                        }
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar117 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar117;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i41 = i36;
                                        c3237ka1 = c3237ka1;
                                        i42 = i90 == true ? 1 : 0;
                                        i43 = i30;
                                        if (z == 2) {
                                            iF = AbstractC3483na0.f(bArr, i37, zzfnVar2, c3237ka1);
                                            i92 = i43;
                                            i39 = iF;
                                            i38 = i42;
                                            i36 = i41;
                                        } else if (z == 0) {
                                            i92 = i43;
                                            i38 = i42 == true ? 1 : 0;
                                            i36 = i41;
                                            i39 = AbstractC3483na0.k(i42 == true ? 1 : 0, bArr, i37, i2, zzfnVar2, c3237ka0);
                                            this = this;
                                        } else {
                                            i92 = i43;
                                            i38 = i42 == true ? 1 : 0;
                                            i36 = i41;
                                            this = this;
                                            i39 = i37;
                                        }
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar118 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar118;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i41 = i36;
                                        c3237ka1 = c3237ka1;
                                        i42 = i90 == true ? 1 : 0;
                                        i43 = i30;
                                        if (z == 2) {
                                            int i1018 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            if (AbstractC3483na0.i(bArr, i37, c3237ka1) + c3237ka1.a > bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            throw null;
                                        }
                                        if (z == 1) {
                                            int i1019 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            AbstractC3483na0.o(bArr, i37);
                                            throw null;
                                        }
                                        this = this;
                                        i92 = i43;
                                        i38 = i42;
                                        i36 = i41;
                                        i39 = i37;
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar119 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar119;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i41 = i36;
                                        c3237ka1 = c3237ka1;
                                        i42 = i90 == true ? 1 : 0;
                                        i43 = i30;
                                        if (z == 2) {
                                            if (z == 5) {
                                                i44 = i37 + 4;
                                                int i1110 = AbstractC3483na0.a;
                                                c2208fc0 = (C2208fc0) zzfnVar2;
                                                c2208fc0.d(AbstractC3483na0.b(bArr, i37));
                                                while (i44 < i2) {
                                                    i45 = AbstractC3483na0.i(bArr, i44, c3237ka1);
                                                    if (i42 == c3237ka1.a) {
                                                        c2208fc0.d(AbstractC3483na0.b(bArr, i45));
                                                        i44 = i45 + 4;
                                                    } else {
                                                        i92 = i43;
                                                        i39 = i44;
                                                    }
                                                }
                                                i92 = i43;
                                                i39 = i44;
                                            }
                                            this = this;
                                            i92 = i43;
                                            i38 = i42;
                                            i36 = i41;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1110 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1110;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            int i1111 = AbstractC3483na0.a;
                                            c2208fc1 = (C2208fc0) zzfnVar2;
                                            iF = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                            i46 = c3237ka1.a;
                                            i47 = iF + i46;
                                            if (i47 <= bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            c2208fc1.e(c2208fc1.size() + (i46 / 4));
                                            while (iF < i47) {
                                                c2208fc1.d(AbstractC3483na0.b(bArr, iF));
                                                iF += 4;
                                            }
                                            if (iF != i47) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i92 = i43;
                                            i39 = iF;
                                        }
                                        i38 = i42;
                                        i36 = i41;
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar1111 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar1111;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        i41 = i36;
                                        c3237ka1 = c3237ka1;
                                        i42 = i90 == true ? 1 : 0;
                                        i43 = i30;
                                        if (z == 2) {
                                            int i1112 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            iF = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                            i48 = c3237ka1.a + iF;
                                            if (iF >= i48) {
                                                AbstractC3483na0.l(bArr, iF, c3237ka1);
                                                throw null;
                                            }
                                            if (iF != i48) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i92 = i43;
                                            i39 = iF;
                                            i38 = i42;
                                            i36 = i41;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1112 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1112;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            if (z == 0) {
                                                int i1113 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                AbstractC3483na0.l(bArr, i37, c3237ka1);
                                                long j7 = c3237ka1.b;
                                                throw null;
                                            }
                                            this = this;
                                            i92 = i43;
                                            i38 = i42;
                                            i36 = i41;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1113 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1113;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        }
                                        break;
                                    case 26:
                                        unsafe6 = unsafe4;
                                        i37 = i31;
                                        c3237ka1 = c3237ka1;
                                        i49 = i30;
                                        if (z == 2) {
                                            if ((536870912 & j2) == 0) {
                                                i50 = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                i56 = c3237ka1.a;
                                                if (i56 >= 0) {
                                                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i56 == 0) {
                                                    objArr = "";
                                                    zzfnVar2.add(objArr);
                                                } else {
                                                    objArr = "";
                                                    zzfnVar2.add(new String(bArr, i50, i56, zzfo.zza));
                                                    i50 += i56;
                                                }
                                                while (i50 < i2) {
                                                    i57 = AbstractC3483na0.i(bArr, i50, c3237ka1);
                                                    if (i90 == c3237ka1.a) {
                                                        i50 = AbstractC3483na0.i(bArr, i57, c3237ka1);
                                                        i58 = c3237ka1.a;
                                                        if (i58 >= 0) {
                                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i58 == 0) {
                                                            zzfnVar2.add(objArr);
                                                        } else {
                                                            zzfnVar2.add(new String(bArr, i50, i58, zzfo.zza));
                                                            i50 += i58;
                                                        }
                                                    }
                                                }
                                            } else {
                                                i50 = AbstractC3483na0.i(bArr, i37, c3237ka1);
                                                i51 = c3237ka1.a;
                                                if (i51 >= 0) {
                                                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i51 == 0) {
                                                    zzfnVar2.add("");
                                                } else {
                                                    i52 = i50 + i51;
                                                    if (AbstractC3978te0.d(bArr, i50, i52)) {
                                                        throw new zzfq("Protocol message had invalid UTF-8.");
                                                    }
                                                    zzfnVar2.add(new String(bArr, i50, i51, zzfo.zza));
                                                    i50 = i52;
                                                }
                                                while (i50 < i2) {
                                                    i53 = AbstractC3483na0.i(bArr, i50, c3237ka1);
                                                    if (i90 == c3237ka1.a) {
                                                        i50 = AbstractC3483na0.i(bArr, i53, c3237ka1);
                                                        i54 = c3237ka1.a;
                                                        if (i54 >= 0) {
                                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i54 == 0) {
                                                            zzfnVar2.add("");
                                                        } else {
                                                            i55 = i50 + i54;
                                                            if (AbstractC3978te0.d(bArr, i50, i55)) {
                                                                throw new zzfq("Protocol message had invalid UTF-8.");
                                                            }
                                                            zzfnVar2.add(new String(bArr, i50, i54, zzfo.zza));
                                                            i50 = i55;
                                                        }
                                                    }
                                                }
                                            }
                                            i38 = i90 == true ? 1 : 0;
                                            i36 = i36;
                                            int i1114 = i50;
                                            i92 = i49;
                                            i39 = i1114;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1114 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1114;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            this = this;
                                            i92 = i49;
                                            i38 = i90 == true ? 1 : 0;
                                            i36 = i36;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1115 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1115;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        }
                                        break;
                                    case 27:
                                        unsafe6 = unsafe4;
                                        i38 = i90 == true ? 1 : 0;
                                        i49 = i30;
                                        if (z == 2) {
                                            c3237ka1 = c3237ka1;
                                            i37 = i31;
                                            i50 = AbstractC3483na0.e(H(i36), i38 == true ? 1 : 0, bArr, i31, i2, zzfnVar2, c3237ka0);
                                            i38 = i38 == true ? 1 : 0;
                                            i36 = i36;
                                            int i1115 = i50;
                                            i92 = i49;
                                            i39 = i1115;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1116 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1116;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            i37 = i31;
                                            i92 = i49;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1117 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1117;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        }
                                        break;
                                    case 28:
                                        unsafe6 = unsafe4;
                                        i38 = i90 == true ? 1 : 0;
                                        i49 = i30;
                                        if (z == 2) {
                                            i59 = AbstractC3483na0.i(bArr, i31, c3237ka1);
                                            i60 = c3237ka1.a;
                                            if (i60 >= 0) {
                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i60 <= bArr.length - i59) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i60 == 0) {
                                                zzfnVar2.add(zzei.zzb);
                                            } else {
                                                zzfnVar2.add(zzei.zzj(bArr, i59, i60));
                                                i59 += i60;
                                            }
                                            while (i59 < i2) {
                                                i61 = AbstractC3483na0.i(bArr, i59, c3237ka1);
                                                if (i38 == c3237ka1.a) {
                                                    i59 = AbstractC3483na0.i(bArr, i61, c3237ka1);
                                                    i62 = c3237ka1.a;
                                                    if (i62 >= 0) {
                                                        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i62 <= bArr.length - i59) {
                                                        throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i62 == 0) {
                                                        zzfnVar2.add(zzei.zzb);
                                                    } else {
                                                        zzfnVar2.add(zzei.zzj(bArr, i59, i62));
                                                        i59 += i62;
                                                    }
                                                } else {
                                                    this = this;
                                                    c3237ka1 = c3237ka1;
                                                    i37 = i31;
                                                    i36 = i36;
                                                    i92 = i49;
                                                    i39 = i59;
                                                }
                                            }
                                            this = this;
                                            c3237ka1 = c3237ka1;
                                            i37 = i31;
                                            i36 = i36;
                                            i92 = i49;
                                            i39 = i59;
                                        } else {
                                            i37 = i31;
                                            i92 = i49;
                                            i39 = i37;
                                        }
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar1118 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar1118;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        unsafe6 = unsafe4;
                                        i63 = i31;
                                        i38 = i90 == true ? 1 : 0;
                                        if (z == 2) {
                                            iK = AbstractC3483na0.f(bArr, i63, zzfnVar2, c3237ka1);
                                        } else if (z == 0) {
                                            this = this;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i30;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar1119 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar1119;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            iK = AbstractC3483na0.k(i38 == true ? 1 : 0, bArr, i63, i2, zzfnVar2, c3237ka0);
                                        }
                                        zzflVarG = uVar2.G(i36);
                                        xd0 = uVar2.j;
                                        Xd0 xd2 = w.a;
                                        if (zzflVarG != null) {
                                            i64 = iK;
                                            i65 = i30;
                                        } else if (zzfnVar2 instanceof RandomAccess) {
                                            size2 = zzfnVar2.size();
                                            objS2 = null;
                                            i66 = 0;
                                            i67 = 0;
                                            while (i66 < size2) {
                                                int i1116 = iK;
                                                num = (Integer) zzfnVar2.get(i66);
                                                iIntValue2 = num.intValue();
                                                if (zzflVarG.zza(iIntValue2)) {
                                                    if (i66 != i67) {
                                                        zzfnVar2.set(i67, num);
                                                    }
                                                    i67++;
                                                    i68 = i30;
                                                } else {
                                                    i68 = i30;
                                                    objS2 = w.s(obj2, i68, iIntValue2, objS2, xd0);
                                                }
                                                i66++;
                                                i30 = i68;
                                                iK = i1116;
                                            }
                                            i64 = iK;
                                            i65 = i30;
                                            if (i67 != size2) {
                                                zzfnVar2.subList(i67, size2).clear();
                                            }
                                        } else {
                                            i64 = iK;
                                            i65 = i30;
                                            it = zzfnVar2.iterator();
                                            objS = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!zzflVarG.zza(iIntValue)) {
                                                    objS = w.s(obj2, i65, iIntValue, objS, xd0);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        this = this;
                                        c3237ka1 = c3237ka1;
                                        i37 = i63;
                                        i36 = i36;
                                        i92 = i65;
                                        i39 = i64;
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar11110 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar11110;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        unsafe6 = unsafe4;
                                        i63 = i31;
                                        i38 = i90 == true ? 1 : 0;
                                        if (z == 2) {
                                            if (z == 0) {
                                                int i1117 = AbstractC3483na0.a;
                                                c2208fc2 = (C2208fc0) zzfnVar2;
                                                i39 = AbstractC3483na0.i(bArr, i63, c3237ka1);
                                                c2208fc2.d(zzel.zzb(c3237ka1.a));
                                                while (i39 < i2) {
                                                    i69 = AbstractC3483na0.i(bArr, i39, c3237ka1);
                                                    if (i38 == c3237ka1.a) {
                                                        i39 = AbstractC3483na0.i(bArr, i69, c3237ka1);
                                                        c2208fc2.d(zzel.zzb(c3237ka1.a));
                                                    }
                                                }
                                            }
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i30;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar11111 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar11111;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            int i1118 = AbstractC3483na0.a;
                                            c2208fc3 = (C2208fc0) zzfnVar2;
                                            i39 = AbstractC3483na0.i(bArr, i63, c3237ka1);
                                            i70 = c3237ka1.a + i39;
                                            while (i39 < i70) {
                                                i39 = AbstractC3483na0.i(bArr, i39, c3237ka1);
                                                c2208fc3.d(zzel.zzb(c3237ka1.a));
                                            }
                                            if (i39 != i70) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        this = uVar2;
                                        c3237ka1 = c3237ka1;
                                        i37 = i63;
                                        i36 = i36;
                                        i92 = i30;
                                        if (i39 != i37) {
                                            obj2 = obj;
                                            i2 = i2;
                                            i86 = i92;
                                            i90 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            i82 = 3;
                                            i85 = 1048575;
                                            i84 = -1;
                                            i83 = 0;
                                            iM = i39;
                                            unsafe8 = unsafe6;
                                            u uVar11112 = this;
                                            c3237ka4 = c3237ka1;
                                            uVar2 = uVar11112;
                                        } else {
                                            obj2 = obj;
                                            iL = i39;
                                            uVar = this;
                                            i6 = i38;
                                            i87 = i36;
                                            i88 = i32;
                                            unsafe2 = unsafe6;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        unsafe6 = unsafe4;
                                        i63 = i31;
                                        i38 = i90 == true ? 1 : 0;
                                        if (z == 2) {
                                            int i1119 = AbstractC3483na0.a;
                                            AbstractC3574of.a(zzfnVar2);
                                            i39 = AbstractC3483na0.i(bArr, i63, c3237ka1);
                                            i71 = c3237ka1.a + i39;
                                            if (i39 >= i71) {
                                                AbstractC3483na0.l(bArr, i39, c3237ka1);
                                                zzel.zzc(c3237ka1.b);
                                                throw null;
                                            }
                                            if (i39 != i71) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i30;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar11113 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar11113;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            if (z == 0) {
                                                int i124 = AbstractC3483na0.a;
                                                AbstractC3574of.a(zzfnVar2);
                                                AbstractC3483na0.l(bArr, i63, c3237ka1);
                                                zzel.zzc(c3237ka1.b);
                                                throw null;
                                            }
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i30;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar11114 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar11114;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        }
                                        break;
                                    default:
                                        if (z == 3) {
                                            i72 = ((i90 == true ? 1 : 0) & (-8)) | 4;
                                            interfaceC3814rd0H = uVar2.H(i36);
                                            unsafe6 = unsafe4;
                                            i63 = i31;
                                            i39 = AbstractC3483na0.c(interfaceC3814rd0H, bArr, i31, i2, i72, c3237ka0);
                                            zzfnVar2.add(c3237ka1.c);
                                            while (true) {
                                                if (i39 < i2) {
                                                    i73 = AbstractC3483na0.i(bArr, i39, c3237ka1);
                                                    i74 = i90;
                                                    if (i74 == c3237ka1.a) {
                                                        i39 = AbstractC3483na0.c(interfaceC3814rd0H, bArr, i73, i2, i72, c3237ka0);
                                                        zzfnVar2.add(c3237ka1.c);
                                                        i90 = i74 == true ? 1 : 0;
                                                        interfaceC3814rd0H = interfaceC3814rd0H;
                                                    } else {
                                                        i38 = i74 == true ? 1 : 0;
                                                    }
                                                } else {
                                                    i38 = i90;
                                                }
                                            }
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            i37 = i63;
                                            i36 = i36;
                                            i92 = i30;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar11115 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar11115;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        } else {
                                            unsafe6 = unsafe4;
                                            i37 = i31;
                                            i36 = i36;
                                            i38 = i90 == true ? 1 : 0;
                                            i92 = i30;
                                            this = uVar2;
                                            c3237ka1 = c3237ka1;
                                            i39 = i37;
                                            if (i39 != i37) {
                                                obj2 = obj;
                                                i2 = i2;
                                                i86 = i92;
                                                i90 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i83 = 0;
                                                iM = i39;
                                                unsafe8 = unsafe6;
                                                u uVar11116 = this;
                                                c3237ka4 = c3237ka1;
                                                uVar2 = uVar11116;
                                            } else {
                                                obj2 = obj;
                                                iL = i39;
                                                uVar = this;
                                                i6 = i38;
                                                i87 = i36;
                                                i88 = i32;
                                                unsafe2 = unsafe6;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                i34 = i36;
                                i6 = i90 == true ? 1 : 0;
                                i92 = i30;
                                uVar = uVar2;
                                c3237ka1 = c3237ka1;
                                if (iD == 50) {
                                    i75 = i31;
                                    obj2 = obj;
                                    j3 = iArr[i34 + 2] & 1048575;
                                    switch (iD) {
                                        case 51:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i76 = i75;
                                            if (z == 1) {
                                                iL = i76 + 8;
                                                unsafe2.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(AbstractC3483na0.o(bArr, i76))));
                                                unsafe2.putInt(obj2, j3, i92);
                                            } else {
                                                iL = i76;
                                            }
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 52:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            if (z == 5) {
                                                iL = i75 + 4;
                                                i76 = i75;
                                                unsafe2.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(AbstractC3483na0.b(bArr, i76))));
                                                unsafe2.putInt(obj2, j3, i92);
                                            } else {
                                                i76 = i75;
                                                iL = i76;
                                            }
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i77 = i75;
                                            if (z == 0) {
                                                iL = AbstractC3483na0.l(bArr, i77, c3237ka1);
                                                i75 = i77;
                                                unsafe2.putObject(obj2, j, Long.valueOf(c3237ka1.b));
                                                unsafe2.putInt(obj2, j3, i92);
                                                i76 = i75;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i77 = i75;
                                            if (z == 0) {
                                                iL = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                unsafe2.putObject(obj2, j, Integer.valueOf(c3237ka1.a));
                                                unsafe2.putInt(obj2, j3, i92);
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i77 = i75;
                                            if (z == 1) {
                                                iL = i77 + 8;
                                                unsafe2.putObject(obj2, j, Long.valueOf(AbstractC3483na0.o(bArr, i77)));
                                                unsafe2.putInt(obj2, j3, i92);
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i77 = i75;
                                            if (z == 5) {
                                                iL = i77 + 4;
                                                unsafe2.putObject(obj2, j, Integer.valueOf(AbstractC3483na0.b(bArr, i77)));
                                                unsafe2.putInt(obj2, j3, i92);
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 58:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i77 = i75;
                                            if (z == 0) {
                                                iL = AbstractC3483na0.l(bArr, i77, c3237ka1);
                                                if (c3237ka1.b != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                unsafe2.putObject(obj2, j, Boolean.valueOf(z3));
                                                unsafe2.putInt(obj2, j3, i92);
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 59:
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i77 = i75;
                                            if (z == 2) {
                                                i78 = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                i79 = c3237ka1.a;
                                                if (i79 == 0) {
                                                    unsafe2.putObject(obj2, j, "");
                                                } else {
                                                    i80 = i78 + i79;
                                                    if ((i7 & PropertyOptions.DELETE_EXISTING) == 0) {
                                                    }
                                                    unsafe2.putObject(obj2, j, new String(bArr, i78, i79, zzfo.zza));
                                                    i78 = i80;
                                                }
                                                unsafe2.putInt(obj2, j3, i92);
                                                iL = i78;
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            } else {
                                                i34 = i34;
                                                i76 = i77;
                                                iL = i76;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            break;
                                        case 60:
                                            unsafe7 = unsafe4;
                                            i77 = i75;
                                            if (z == 2) {
                                                Object objK3 = uVar.K(obj2, i92, i34);
                                                i76 = i77;
                                                uVar = uVar;
                                                int iN4 = AbstractC3483na0.n(objK3, uVar.H(i34), bArr, i76, i2, c3237ka0);
                                                uVar.m(obj2, i92, i34, objK3);
                                                iL = iN4;
                                                i34 = i34;
                                                unsafe2 = unsafe7;
                                                i6 = i6 == true ? 1 : 0;
                                            } else {
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                iL = i76;
                                            }
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 61:
                                            unsafe7 = unsafe4;
                                            i77 = i75;
                                            if (z == 2) {
                                                iA = AbstractC3483na0.a(bArr, i77, c3237ka1);
                                                unsafe7.putObject(obj2, j, c3237ka1.c);
                                                unsafe7.putInt(obj2, j3, i92);
                                                i34 = i34;
                                                uVar = uVar;
                                                iL = iA;
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            unsafe2 = unsafe7;
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 63:
                                            unsafe7 = unsafe4;
                                            i77 = i75;
                                            if (z == 0) {
                                                iA = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                i81 = c3237ka1.a;
                                                zzflVarG2 = uVar.G(i34);
                                                if (zzflVarG2 != null) {
                                                    unsafe7.putObject(obj2, j, Integer.valueOf(i81));
                                                    unsafe7.putInt(obj2, j3, i92);
                                                } else {
                                                    unsafe7.putObject(obj2, j, Integer.valueOf(i81));
                                                    unsafe7.putInt(obj2, j3, i92);
                                                }
                                                i34 = i34;
                                                uVar = uVar;
                                                iL = iA;
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            unsafe2 = unsafe7;
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 66:
                                            unsafe7 = unsafe4;
                                            i77 = i75;
                                            if (z == 0) {
                                                iA = AbstractC3483na0.i(bArr, i77, c3237ka1);
                                                unsafe7.putObject(obj2, j, Integer.valueOf(zzel.zzb(c3237ka1.a)));
                                                unsafe7.putInt(obj2, j3, i92);
                                                i34 = i34;
                                                uVar = uVar;
                                                iL = iA;
                                                unsafe2 = unsafe7;
                                                i76 = i77;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                            }
                                            unsafe2 = unsafe7;
                                            i76 = i77;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 67:
                                            if (z == 0) {
                                                int iL7 = AbstractC3483na0.l(bArr, i75, c3237ka1);
                                                unsafe4.putObject(obj2, j, Long.valueOf(zzel.zzc(c3237ka1.b)));
                                                unsafe4.putInt(obj2, j3, i92);
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i76 = i75;
                                                iL = iL7;
                                                i34 = i34;
                                            } else {
                                                i34 = i34;
                                                uVar = uVar;
                                                unsafe2 = unsafe4;
                                                i76 = i75;
                                                iL = i76;
                                            }
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                        case 68:
                                            if (z == 3) {
                                                int i125 = ((i6 == true ? 1 : 0) & (-8)) | 4;
                                                Object objK4 = uVar.K(obj2, i92, i34);
                                                int iM3 = AbstractC3483na0.m(objK4, uVar.H(i34), bArr, i75, i2, i125, c3237ka0);
                                                uVar.m(obj2, i92, i34, objK4);
                                                i34 = i34;
                                                uVar = uVar;
                                                iL = iM3;
                                                i92 = i92;
                                                unsafe2 = unsafe4;
                                                i76 = i75;
                                                i87 = i34;
                                                if (iL != i76) {
                                                    i90 = i6 == true ? 1 : 0;
                                                    unsafe8 = unsafe2;
                                                    i86 = i92;
                                                    i88 = i32;
                                                    i82 = 3;
                                                    i85 = 1048575;
                                                    i84 = -1;
                                                    i2 = i2;
                                                    c3237ka4 = c3237ka1;
                                                    iM = iL;
                                                    uVar2 = uVar;
                                                    i83 = 0;
                                                } else {
                                                    i88 = i32;
                                                }
                                                break;
                                            }
                                        default:
                                            i34 = i34;
                                            uVar = uVar;
                                            unsafe2 = unsafe4;
                                            i76 = i75;
                                            iL = i76;
                                            i87 = i34;
                                            if (iL != i76) {
                                                i90 = i6 == true ? 1 : 0;
                                                unsafe8 = unsafe2;
                                                i86 = i92;
                                                i88 = i32;
                                                i82 = 3;
                                                i85 = 1048575;
                                                i84 = -1;
                                                i2 = i2;
                                                c3237ka4 = c3237ka1;
                                                iM = iL;
                                                uVar2 = uVar;
                                                i83 = 0;
                                            } else {
                                                i88 = i32;
                                            }
                                            break;
                                    }
                                } else {
                                    if (z == 2) {
                                        Object objI2 = uVar.I(i34);
                                        object = unsafe4.getObject(obj, j);
                                        if (!((zzgf) object).zze()) {
                                            zzgf zzgfVarZzb2 = zzgf.zza().zzb();
                                            Wc0.a(zzgfVarZzb2, object);
                                            unsafe4.putObject(obj, j, zzgfVarZzb2);
                                        }
                                        throw null;
                                    }
                                    i33 = i31;
                                    unsafe5 = unsafe4;
                                    obj2 = obj;
                                }
                            }
                        } else if (z == 2) {
                            zzfnVarZzd = (zzfn) unsafe4.getObject(obj2, j);
                            if (!zzfnVarZzd.zzc()) {
                                size = zzfnVarZzd.size();
                                if (size == 0) {
                                    i35 = 10;
                                } else {
                                    i35 = size + size;
                                }
                                zzfnVarZzd = zzfnVarZzd.zzd(i35);
                                unsafe4.putObject(obj2, j, zzfnVarZzd);
                            }
                            iM = AbstractC3483na0.e(uVar2.H(i87), i90 == true ? 1 : 0, bArr, i31, i2, zzfnVarZzd, c3237ka0);
                            c3237ka4 = c3237ka0;
                            i87 = i87;
                            unsafe8 = unsafe4;
                            i88 = i88;
                            i86 = i30;
                            i82 = 3;
                            i85 = 1048575;
                            i84 = -1;
                            i83 = 0;
                            i2 = i2;
                        } else {
                            i32 = i88;
                            unsafe5 = unsafe4;
                            i33 = i31;
                            i34 = i87;
                            i6 = i90 == true ? 1 : 0;
                            i92 = i30;
                            uVar = uVar2;
                            c3237ka1 = c3237ka0;
                        }
                        i87 = i34;
                        uVar = uVar;
                        unsafe2 = unsafe5;
                        i88 = i32;
                        iL = i33;
                    }
                }
                if (i6 == i3) {
                }
                if (uVar.f) {
                    zzeuVar = c3237ka1.d;
                    int i126 = zzeu.zzb;
                    C3407md0 c3407md1 = C3407md0.c;
                    if (zzeuVar != zzeu.zza) {
                        zzglVar = uVar.e;
                        int i127 = AbstractC3483na0.a;
                        if (zzeuVar.zzb(zzglVar, i92) == null) {
                            throw null;
                        }
                        zzhi zzhiVarW3 = w(obj);
                        Object[] objArr3 = i6 == true ? 1 : 0;
                        i90 = i6 == true ? 1 : 0;
                        iH = AbstractC3483na0.h(objArr3 == true ? 1 : 0, bArr, iL, i2, zzhiVarW3, c3237ka0);
                    } else {
                        i90 = i6 == true ? 1 : 0;
                        iH = AbstractC3483na0.h(i90 == true ? 1 : 0, bArr, iL, i2, w(obj), c3237ka0);
                    }
                } else {
                    i90 = i6 == true ? 1 : 0;
                    iH = AbstractC3483na0.h(i90 == true ? 1 : 0, bArr, iL, i2, w(obj), c3237ka0);
                }
                c3237ka4 = c3237ka1;
                i86 = i92;
                i2 = i2;
                uVar2 = uVar;
                i82 = 3;
                i85 = 1048575;
                i83 = 0;
                iM = iH;
                unsafe8 = unsafe2;
                i84 = -1;
            } else {
                i3 = i3;
                uVar = uVar2;
                unsafe = unsafe8;
                i4 = i2;
                i5 = i89;
                i6 = i90;
            }
        }
        if (i88 != 1048575) {
            unsafe.putInt(obj2, i88, i5);
        }
        for (int i128 = uVar.h; i128 < uVar.i; i128++) {
            int[] iArr2 = uVar.g;
            int[] iArr3 = uVar.a;
            int i129 = iArr2[i128];
            int i130 = iArr3[i129];
            Object objK5 = AbstractC3491ne0.k(obj2, uVar.E(i129) & 1048575);
            if (objK5 != null && uVar.G(i129) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (iM != i4) {
                throw new zzfq("Failed to parse the message.");
            }
        } else if (iM > i4 || i6 != i3) {
            throw new zzfq("Failed to parse the message.");
        }
        return iM;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x038d  */
    /* JADX WARN: Code duplicated, block: B:180:0x0484  */
    @Override // defpackage.InterfaceC3814rd0
    public final int zza(Object obj) {
        int i;
        int i2;
        int i3;
        int iZzC;
        int iZzC2;
        int iZzC3;
        int iZzD;
        int iZzC4;
        int iZzC5;
        int iZzd;
        int iZzC6;
        int iM;
        int iL;
        int size;
        int iZzC7;
        int iZzC8;
        int iZzC9;
        int iJ;
        int iZzC10;
        int iZzC11;
        int iZzy;
        Unsafe unsafe = m;
        boolean z = false;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i7 >= iArr.length) {
                int iZza = i8 + ((zzfi) obj).zzc.zza();
                if (!this.f) {
                    return iZza;
                }
                Sd0 sd0 = ((zzff) obj).zzb.a;
                int iC = sd0.c();
                int iC2 = 0;
                for (int i9 = 0; i9 < iC; i9++) {
                    Map.Entry entryG = sd0.g(i9);
                    iC2 += Cb0.c((zzey) ((C4300xd0) entryG).a(), entryG.getValue());
                }
                for (Map.Entry entry : sd0.d()) {
                    iC2 += Cb0.c((zzey) entry.getKey(), entry.getValue());
                }
                return iZza + iC2;
            }
            int iE = E(i7);
            int iD = D(iE);
            int i10 = iArr[i7];
            int i11 = iArr[i7 + 2];
            int i12 = i11 & i4;
            if (iD <= 17) {
                if (i12 != i5) {
                    i6 = i12 == i4 ? 0 : unsafe.getInt(obj, i12);
                    i5 = i12;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i11 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            int i13 = iE & i4;
            if (iD >= zzfa.zzJ.zza()) {
                zzfa.zzW.zza();
            }
            long j = i13;
            switch (iD) {
                case 0:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC = zzep.zzC(i10 << 3);
                        iM = iZzC + 8;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 1:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC2 = zzep.zzC(i10 << 3);
                        iM = iZzC2 + 4;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 2:
                    if (p(obj, i7, i, i2, i3)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(j2);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 3:
                    if (p(obj, i7, i, i2, i3)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(j3);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 4:
                    if (p(obj, i7, i, i2, i3)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(j4);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 5:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC = zzep.zzC(i10 << 3);
                        iM = iZzC + 8;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 6:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC2 = zzep.zzC(i10 << 3);
                        iM = iZzC2 + 4;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 7:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC4 = zzep.zzC(i10 << 3);
                        iM = iZzC4 + 1;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 8:
                    if (p(obj, i7, i, i2, i3)) {
                        int i14 = i10 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzei) {
                            iZzC5 = zzep.zzC(i14);
                            iZzd = ((zzei) object).zzd();
                            iZzC6 = zzep.zzC(iZzd);
                            iM = iZzC5 + iZzC6 + iZzd;
                            i8 += iM;
                        } else {
                            iZzC3 = zzep.zzC(i14);
                            iZzD = zzep.zzB((String) object);
                            iM = iZzC3 + iZzD;
                            i8 += iM;
                        }
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 9:
                    if (p(obj, i7, i, i2, i3)) {
                        iM = w.m(i10, unsafe.getObject(obj, j), H(i7));
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 10:
                    if (p(obj, i7, i, i2, i3)) {
                        zzei zzeiVar = (zzei) unsafe.getObject(obj, j);
                        iZzC5 = zzep.zzC(i10 << 3);
                        iZzd = zzeiVar.zzd();
                        iZzC6 = zzep.zzC(iZzd);
                        iM = iZzC5 + iZzC6 + iZzd;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 11:
                    if (p(obj, i7, i, i2, i3)) {
                        int i15 = unsafe.getInt(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzC(i15);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 12:
                    if (p(obj, i7, i, i2, i3)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(j5);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 13:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC2 = zzep.zzC(i10 << 3);
                        iM = iZzC2 + 4;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 14:
                    if (p(obj, i7, i, i2, i3)) {
                        iZzC = zzep.zzC(i10 << 3);
                        iM = iZzC + 8;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 15:
                    if (p(obj, i7, i, i2, i3)) {
                        int i16 = unsafe.getInt(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzC((i16 >> 31) ^ (i16 + i16));
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 16:
                    if (p(obj, i7, i, i2, i3)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD((j6 >> 63) ^ (j6 + j6));
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 17:
                    if (p(obj, i7, i, i2, i3)) {
                        iM = zzep.zzy(i10, (zzgl) unsafe.getObject(obj, j), H(i7));
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 18:
                    iM = w.i(i10, (List) unsafe.getObject(obj, j), z);
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 19:
                    iM = w.g(i10, (List) unsafe.getObject(obj, j), z);
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    Xd0 xd0 = w.a;
                    if (list.size() == 0) {
                        iL = 0;
                    } else {
                        iL = w.l(list) + (list.size() * zzep.zzC(i10 << 3));
                    }
                    i8 += iL;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    Xd0 xd1 = w.a;
                    size = list2.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iZzC3 = w.q(list2);
                        iZzC7 = zzep.zzC(i10 << 3);
                        iZzD = size * iZzC7;
                        iM = iZzC3 + iZzD;
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    Xd0 xd2 = w.a;
                    size = list3.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iZzC3 = w.k(list3);
                        iZzC7 = zzep.zzC(i10 << 3);
                        iZzD = size * iZzC7;
                        iM = iZzC3 + iZzD;
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 23:
                    iM = w.i(i10, (List) unsafe.getObject(obj, j), z);
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 24:
                    iM = w.g(i10, (List) unsafe.getObject(obj, j), z);
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    Xd0 xd3 = w.a;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iM = 0;
                    } else {
                        iM = size2 * (zzep.zzC(i10 << 3) + 1);
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    Xd0 xd4 = w.a;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iL = 0;
                    } else {
                        iL = zzep.zzC(i10 << 3) * size3;
                        if (list5 instanceof zzfx) {
                            zzfx zzfxVar = (zzfx) list5;
                            for (int i17 = 0; i17 < size3; i17++) {
                                Object objZza = zzfxVar.zza();
                                if (objZza instanceof zzei) {
                                    int iZzd2 = ((zzei) objZza).zzd();
                                    iL += zzep.zzC(iZzd2) + iZzd2;
                                } else {
                                    iL += zzep.zzB((String) objZza);
                                }
                            }
                        } else {
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object obj2 = list5.get(i18);
                                if (obj2 instanceof zzei) {
                                    int iZzd3 = ((zzei) obj2).zzd();
                                    iL += zzep.zzC(iZzd3) + iZzd3;
                                } else {
                                    iL += zzep.zzB((String) obj2);
                                }
                            }
                        }
                    }
                    i8 += iL;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    InterfaceC3814rd0 interfaceC3814rd0H = H(i7);
                    Xd0 xd5 = w.a;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzC8 = 0;
                    } else {
                        iZzC8 = zzep.zzC(i10 << 3) * size4;
                        for (int i19 = 0; i19 < size4; i19++) {
                            Object obj3 = list6.get(i19);
                            if (obj3 instanceof zzfw) {
                                int iZza2 = ((zzfw) obj3).zza();
                                iZzC8 += zzep.zzC(iZza2) + iZza2;
                            } else {
                                iZzC8 += zzep.zzA((zzgl) obj3, interfaceC3814rd0H);
                            }
                        }
                    }
                    i8 += iZzC8;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    Xd0 xd6 = w.a;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzC9 = 0;
                    } else {
                        iZzC9 = size5 * zzep.zzC(i10 << 3);
                        for (int i20 = 0; i20 < list7.size(); i20++) {
                            int iZzd4 = ((zzei) list7.get(i20)).zzd();
                            iZzC9 += zzep.zzC(iZzd4) + iZzd4;
                        }
                    }
                    i8 += iZzC9;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    Xd0 xd7 = w.a;
                    size = list8.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iZzC3 = w.p(list8);
                        iZzC7 = zzep.zzC(i10 << 3);
                        iZzD = size * iZzC7;
                        iM = iZzC3 + iZzD;
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    Xd0 xd8 = w.a;
                    size = list9.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iZzC3 = w.f(list9);
                        iZzC7 = zzep.zzC(i10 << 3);
                        iZzD = size * iZzC7;
                        iM = iZzC3 + iZzD;
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 31:
                    iM = w.g(i10, (List) unsafe.getObject(obj, j), z);
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 32:
                    iM = w.i(i10, (List) unsafe.getObject(obj, j), z);
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    Xd0 xd9 = w.a;
                    size = list10.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iZzC3 = w.n(list10);
                        iZzC7 = zzep.zzC(i10 << 3);
                        iZzD = size * iZzC7;
                        iM = iZzC3 + iZzD;
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    Xd0 xd10 = w.a;
                    size = list11.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iZzC3 = w.o(list11);
                        iZzC7 = zzep.zzC(i10 << 3);
                        iZzD = size * iZzC7;
                        iM = iZzC3 + iZzD;
                    }
                    i8 += iM;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 35:
                    iJ = w.j((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 36:
                    iJ = w.h((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 37:
                    iJ = w.l((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 38:
                    iJ = w.q((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 39:
                    iJ = w.k((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 40:
                    iJ = w.j((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 41:
                    iJ = w.h((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    Xd0 xd11 = w.a;
                    iJ = list12.size();
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 43:
                    iJ = w.p((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 44:
                    iJ = w.f((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 45:
                    iJ = w.h((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 46:
                    iJ = w.j((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 47:
                    iJ = w.n((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 48:
                    iJ = w.o((List) unsafe.getObject(obj, j));
                    if (iJ > 0) {
                        iZzC10 = zzep.zzC(i10 << 3);
                        iZzC11 = zzep.zzC(iJ);
                        iZzC9 = iZzC10 + iZzC11 + iJ;
                        i8 += iZzC9;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    InterfaceC3814rd0 interfaceC3814rd0H2 = H(i7);
                    Xd0 xd12 = w.a;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzy = 0;
                    } else {
                        iZzy = 0;
                        for (int i21 = 0; i21 < size6; i21++) {
                            iZzy += zzep.zzy(i10, (zzgl) list13.get(i21), interfaceC3814rd0H2);
                        }
                    }
                    i8 += iZzy;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 50:
                    zzgf zzgfVar = (zzgf) unsafe.getObject(obj, j);
                    if (zzgfVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgfVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                case 51:
                    if (s(obj, i10, i7)) {
                        iZzC = zzep.zzC(i10 << 3);
                        iM = iZzC + 8;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 52:
                    if (s(obj, i10, i7)) {
                        iZzC2 = zzep.zzC(i10 << 3);
                        iM = iZzC2 + 4;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 53:
                    if (s(obj, i10, i7)) {
                        long jF = F(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(jF);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 54:
                    if (s(obj, i10, i7)) {
                        long jF2 = F(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(jF2);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 55:
                    if (s(obj, i10, i7)) {
                        long jA = A(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(jA);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 56:
                    if (s(obj, i10, i7)) {
                        iZzC = zzep.zzC(i10 << 3);
                        iM = iZzC + 8;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 57:
                    if (s(obj, i10, i7)) {
                        iZzC2 = zzep.zzC(i10 << 3);
                        iM = iZzC2 + 4;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 58:
                    if (s(obj, i10, i7)) {
                        iZzC4 = zzep.zzC(i10 << 3);
                        iM = iZzC4 + 1;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 59:
                    if (s(obj, i10, i7)) {
                        int i22 = i10 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzei) {
                            iZzC5 = zzep.zzC(i22);
                            iZzd = ((zzei) object2).zzd();
                            iZzC6 = zzep.zzC(iZzd);
                            iM = iZzC5 + iZzC6 + iZzd;
                            i8 += iM;
                        } else {
                            iZzC3 = zzep.zzC(i22);
                            iZzD = zzep.zzB((String) object2);
                            iM = iZzC3 + iZzD;
                            i8 += iM;
                        }
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 60:
                    if (s(obj, i10, i7)) {
                        iM = w.m(i10, unsafe.getObject(obj, j), H(i7));
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 61:
                    if (s(obj, i10, i7)) {
                        zzei zzeiVar2 = (zzei) unsafe.getObject(obj, j);
                        iZzC5 = zzep.zzC(i10 << 3);
                        iZzd = zzeiVar2.zzd();
                        iZzC6 = zzep.zzC(iZzd);
                        iM = iZzC5 + iZzC6 + iZzd;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 62:
                    if (s(obj, i10, i7)) {
                        int iA = A(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzC(iA);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 63:
                    if (s(obj, i10, i7)) {
                        long jA2 = A(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD(jA2);
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 64:
                    if (s(obj, i10, i7)) {
                        iZzC2 = zzep.zzC(i10 << 3);
                        iM = iZzC2 + 4;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 65:
                    if (s(obj, i10, i7)) {
                        iZzC = zzep.zzC(i10 << 3);
                        iM = iZzC + 8;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 66:
                    if (s(obj, i10, i7)) {
                        int iA2 = A(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzC((iA2 >> 31) ^ (iA2 + iA2));
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 67:
                    if (s(obj, i10, i7)) {
                        long jF3 = F(obj, j);
                        iZzC3 = zzep.zzC(i10 << 3);
                        iZzD = zzep.zzD((jF3 >> 63) ^ (jF3 + jF3));
                        iM = iZzC3 + iZzD;
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                case 68:
                    if (s(obj, i10, i7)) {
                        iM = zzep.zzy(i10, (zzgl) unsafe.getObject(obj, j), H(i7));
                        i8 += iM;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
                default:
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    z = false;
                    i4 = 1048575;
                    break;
            }
        }
    }

    @Override // defpackage.InterfaceC3814rd0
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i4 >= iArr.length) {
                int iHashCode = (i5 * 53) + ((zzfi) obj).zzc.hashCode();
                return this.f ? (iHashCode * 53) + ((zzff) obj).zzb.a.hashCode() : iHashCode;
            }
            int iE = E(i4);
            int i6 = 1048575 & iE;
            int iD = D(iE);
            int i7 = iArr[i4];
            long j = i6;
            int iHashCode2 = 37;
            switch (iD) {
                case 0:
                    i = i5 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(AbstractC3491ne0.f(obj, j));
                    byte[] bArr = zzfo.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i2 = i5 * 53;
                    iFloatToIntBits = Float.floatToIntBits(AbstractC3491ne0.g(obj, j));
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 2:
                    i = i5 * 53;
                    jDoubleToLongBits = AbstractC3491ne0.i(obj, j);
                    byte[] bArr2 = zzfo.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i = i5 * 53;
                    jDoubleToLongBits = AbstractC3491ne0.i(obj, j);
                    byte[] bArr3 = zzfo.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.h(obj, j);
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 5:
                    i = i5 * 53;
                    jDoubleToLongBits = AbstractC3491ne0.i(obj, j);
                    byte[] bArr4 = zzfo.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.h(obj, j);
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 7:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzfo.zza(AbstractC3491ne0.B(obj, j));
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 8:
                    i2 = i5 * 53;
                    iFloatToIntBits = ((String) AbstractC3491ne0.k(obj, j)).hashCode();
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 9:
                    i3 = i5 * 53;
                    Object objK = AbstractC3491ne0.k(obj, j);
                    if (objK != null) {
                        iHashCode2 = objK.hashCode();
                    }
                    i5 = i3 + iHashCode2;
                    break;
                case 10:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.k(obj, j).hashCode();
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 11:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.h(obj, j);
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 12:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.h(obj, j);
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 13:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.h(obj, j);
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 14:
                    i = i5 * 53;
                    jDoubleToLongBits = AbstractC3491ne0.i(obj, j);
                    byte[] bArr5 = zzfo.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.h(obj, j);
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 16:
                    i = i5 * 53;
                    jDoubleToLongBits = AbstractC3491ne0.i(obj, j);
                    byte[] bArr6 = zzfo.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i3 = i5 * 53;
                    Object objK2 = AbstractC3491ne0.k(obj, j);
                    if (objK2 != null) {
                        iHashCode2 = objK2.hashCode();
                    }
                    i5 = i3 + iHashCode2;
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
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.k(obj, j).hashCode();
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 50:
                    i2 = i5 * 53;
                    iFloatToIntBits = AbstractC3491ne0.k(obj, j).hashCode();
                    i5 = i2 + iFloatToIntBits;
                    break;
                case 51:
                    if (s(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(y(obj, j));
                        byte[] bArr7 = zzfo.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = Float.floatToIntBits(z(obj, j));
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (s(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = F(obj, j);
                        byte[] bArr8 = zzfo.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (s(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = F(obj, j);
                        byte[] bArr9 = zzfo.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = A(obj, j);
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (s(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = F(obj, j);
                        byte[] bArr10 = zzfo.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = A(obj, j);
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzfo.zza(t(obj, j));
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((String) AbstractC3491ne0.k(obj, j)).hashCode();
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = AbstractC3491ne0.k(obj, j).hashCode();
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = AbstractC3491ne0.k(obj, j).hashCode();
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = A(obj, j);
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = A(obj, j);
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = A(obj, j);
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (s(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = F(obj, j);
                        byte[] bArr11 = zzfo.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = A(obj, j);
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (s(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = F(obj, j);
                        byte[] bArr12 = zzfo.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (s(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = AbstractC3491ne0.k(obj, j).hashCode();
                        i5 = i2 + iFloatToIntBits;
                    }
                    break;
            }
            i4 += 3;
        }
    }

    @Override // defpackage.InterfaceC3814rd0
    public final Object zze() {
        return ((zzfi) this.e).zzo();
    }
}
