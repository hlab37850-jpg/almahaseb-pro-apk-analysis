package defpackage;

import com.google.android.gms.internal.vision.zzjk;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public final class Rg0 extends Mg0 {
    public static int e(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return Lg0.h(i);
        }
        if (i2 == 1) {
            return Lg0.i(i, Ig0.a(bArr, j));
        }
        if (i2 == 2) {
            return Lg0.j(i, Ig0.a(bArr, j), Ig0.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    @Override // defpackage.Mg0
    public final int a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = 2;
        int i6 = 0;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j = i2;
        int i7 = (int) (((long) i3) - j);
        if (i7 >= 16) {
            long j2 = j;
            i4 = 0;
            while (true) {
                if (i4 >= i7) {
                    i4 = i7;
                    break;
                }
                long j3 = j2 + 1;
                if (Ig0.a(bArr, j2) < 0) {
                    break;
                }
                i4++;
                j2 = j3;
            }
        } else {
            i4 = 0;
        }
        int i8 = i7 - i4;
        long j4 = j + ((long) i4);
        while (true) {
            byte bA = 0;
            while (i8 > 0) {
                long j5 = j4 + 1;
                bA = Ig0.a(bArr, j4);
                if (bA < 0) {
                    j4 = j5;
                    break;
                }
                i8--;
                j4 = j5;
            }
            if (i8 == 0) {
                return i6;
            }
            int i9 = i8 - 1;
            if (bA < -32) {
                if (i9 == 0) {
                    return bA;
                }
                i8 -= 2;
                if (bA >= -62) {
                    long j6 = j4 + 1;
                    if (Ig0.a(bArr, j4) <= -65) {
                        j4 = j6;
                    }
                }
                return -1;
            }
            if (bA >= -16) {
                if (i9 < 3) {
                    return e(bArr, bA, j4, i9);
                }
                i8 -= 4;
                long j7 = j4 + 1;
                byte bA2 = Ig0.a(bArr, j4);
                if (bA2 <= -65 && (((bA << Ascii.FS) + (bA2 + 112)) >> 30) == 0) {
                    long j8 = j4 + 2;
                    if (Ig0.a(bArr, j7) <= -65) {
                        j4 += 3;
                        if (Ig0.a(bArr, j8) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i9 < i5) {
                return e(bArr, bA, j4, i9);
            }
            i8 -= 3;
            long j9 = j4 + 1;
            byte bA3 = Ig0.a(bArr, j4);
            if (bA3 <= -65 && ((bA != -32 || bA3 >= -96) && (bA != -19 || bA3 < -96))) {
                j4 += 2;
                if (Ig0.a(bArr, j9) > -65) {
                }
            }
            return -1;
            i5 = 2;
            i6 = 0;
        }
    }

    @Override // defpackage.Mg0
    public final int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        String str;
        String str2;
        int i3;
        long j2;
        char cCharAt;
        long j3 = i;
        long j4 = ((long) i2) + j3;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            Ig0.l(bArr, j3, (byte) cCharAt);
            i4++;
            j3 = 1 + j3;
        }
        if (i4 == length) {
            return (int) j3;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= 128 || j3 >= j4) {
                if (cCharAt3 >= 2048 || j3 > j4 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j3 > j4 - 3) {
                        if (j3 > j4 - 4) {
                            if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                                throw new Og0(i4, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append(str2);
                            sb2.append(cCharAt3);
                            sb2.append(str);
                            sb2.append(j3);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                j2 = 1;
                                Ig0.l(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                Ig0.l(bArr, j3 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j5 = j3 + 3;
                                Ig0.l(bArr, j3 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 += 4;
                                Ig0.l(bArr, j5, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new Og0(i4 - 1, length);
                    }
                    Ig0.l(bArr, j3, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j6 = j3 + 2;
                    Ig0.l(bArr, j3 + 1, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j3 += 3;
                    Ig0.l(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j7 = j3 + j;
                    Ig0.l(bArr, j3, (byte) ((cCharAt3 >>> 6) | 960));
                    j3 += 2;
                    Ig0.l(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
                }
                j2 = 1;
            } else {
                Ig0.l(bArr, j3, (byte) cCharAt3);
                str2 = str4;
                j2 = j;
                j3 += j;
                str = str3;
            }
            i4++;
            str3 = str;
            str4 = str2;
            j = j2;
            j4 = j4;
        }
        return (int) j3;
    }

    @Override // defpackage.Mg0
    public final String d(byte[] bArr, int i, int i2) throws zzjk {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bA = Ig0.a(bArr, i);
            if (!Ng0.l(bA)) {
                break;
            }
            i++;
            Ng0.i(bA, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bA2 = Ig0.a(bArr, i);
            if (Ng0.l(bA2)) {
                int i7 = i5 + 1;
                Ng0.i(bA2, cArr, i5);
                while (i6 < i3) {
                    byte bA3 = Ig0.a(bArr, i6);
                    if (!Ng0.l(bA3)) {
                        break;
                    }
                    i6++;
                    Ng0.i(bA3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (Ng0.m(bA2)) {
                if (i6 >= i3) {
                    throw zzjk.zzh();
                }
                i += 2;
                Ng0.h(bA2, Ig0.a(bArr, i6), cArr, i5);
                i5++;
            } else if (Ng0.n(bA2)) {
                if (i6 >= i3 - 1) {
                    throw zzjk.zzh();
                }
                int i8 = i + 2;
                i += 3;
                Ng0.g(bA2, Ig0.a(bArr, i6), Ig0.a(bArr, i8), cArr, i5);
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw zzjk.zzh();
                }
                byte bA4 = Ig0.a(bArr, i6);
                int i9 = i + 3;
                byte bA5 = Ig0.a(bArr, i + 2);
                i += 4;
                Ng0.f(bA2, bA4, bA5, Ig0.a(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }
}
