package defpackage;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: hc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2372hc0 extends Yb0 {
    public static int f(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return Xb0.d(i);
        }
        if (i2 == 1) {
            return Xb0.l(i, Sb0.a(bArr, j));
        }
        if (i2 == 2) {
            return Xb0.f(i, Sb0.a(bArr, j), Sb0.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    @Override // defpackage.Yb0
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
                if (Sb0.a(bArr, j2) < 0) {
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
                bA = Sb0.a(bArr, j4);
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
                    if (Sb0.a(bArr, j4) <= -65) {
                        j4 = j6;
                    }
                }
                return -1;
            }
            if (bA >= -16) {
                if (i9 < 3) {
                    return f(bArr, bA, j4, i9);
                }
                i8 -= 4;
                long j7 = j4 + 1;
                byte bA2 = Sb0.a(bArr, j4);
                if (bA2 <= -65 && (((bA << Ascii.FS) + (bA2 + 112)) >> 30) == 0) {
                    long j8 = j4 + 2;
                    if (Sb0.a(bArr, j7) <= -65) {
                        j4 += 3;
                        if (Sb0.a(bArr, j8) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i9 < i5) {
                return f(bArr, bA, j4, i9);
            }
            i8 -= 3;
            long j9 = j4 + 1;
            byte bA3 = Sb0.a(bArr, j4);
            if (bA3 <= -65 && ((bA != -32 || bA3 >= -96) && (bA != -19 || bA3 < -96))) {
                j4 += 2;
                if (Sb0.a(bArr, j9) > -65) {
                }
            }
            return -1;
            i5 = 2;
            i6 = 0;
        }
    }

    @Override // defpackage.Yb0
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
            Sb0.k(bArr, j3, (byte) cCharAt);
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
                                throw new C2045dc0(i4, length);
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
                                Sb0.k(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                Sb0.k(bArr, j3 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j5 = j3 + 3;
                                Sb0.k(bArr, j3 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 += 4;
                                Sb0.k(bArr, j5, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new C2045dc0(i4 - 1, length);
                    }
                    Sb0.k(bArr, j3, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j6 = j3 + 2;
                    Sb0.k(bArr, j3 + 1, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j3 += 3;
                    Sb0.k(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j7 = j3 + j;
                    Sb0.k(bArr, j3, (byte) ((cCharAt3 >>> 6) | 960));
                    j3 += 2;
                    Sb0.k(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
                }
                j2 = 1;
            } else {
                Sb0.k(bArr, j3, (byte) cCharAt3);
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

    @Override // defpackage.Yb0
    public final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        char c;
        int i;
        int i2;
        char cCharAt;
        long jO = Sb0.o(byteBuffer);
        long jPosition = ((long) byteBuffer.position()) + jO;
        long jLimit = ((long) byteBuffer.limit()) + jO;
        int length = charSequence.length();
        if (length > jLimit - jPosition) {
            char cCharAt2 = charSequence.charAt(length - 1);
            int iLimit = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(iLimit);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i3 = 0;
        while (true) {
            j = 1;
            c = 128;
            if (i3 >= length || (cCharAt = charSequence.charAt(i3)) >= 128) {
                break;
            }
            Sb0.c(jPosition, (byte) cCharAt);
            i3++;
            jPosition = 1 + jPosition;
        }
        if (i3 == length) {
            i = (int) (jPosition - jO);
        } else {
            while (i3 < length) {
                char cCharAt3 = charSequence.charAt(i3);
                if (cCharAt3 >= c || jPosition >= jLimit) {
                    if (cCharAt3 >= 2048 || jPosition > jLimit - 2) {
                        jO = jO;
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || jPosition > jLimit - 3) {
                            if (jPosition > jLimit - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i2 = i3 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i2)))) {
                                    throw new C2045dc0(i3, length);
                                }
                                StringBuilder sb2 = new StringBuilder(46);
                                sb2.append("Failed writing ");
                                sb2.append(cCharAt3);
                                sb2.append(" at index ");
                                sb2.append(jPosition);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i3++;
                            if (i3 != length) {
                                char cCharAt4 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    j = 1;
                                    Sb0.c(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    jLimit = jLimit;
                                    Sb0.c(jPosition + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j2 = jPosition + 3;
                                    Sb0.c(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    Sb0.c(j2, (byte) ((codePoint & 63) | 128));
                                } else {
                                    i3 = i3;
                                }
                            }
                            throw new C2045dc0(i3 - 1, length);
                        }
                        long j3 = jPosition + j;
                        Sb0.c(jPosition, (byte) ((cCharAt3 >>> '\f') | 480));
                        long j4 = jPosition + 2;
                        Sb0.c(j3, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                        jPosition += 3;
                        Sb0.c(j4, (byte) ((cCharAt3 & '?') | 128));
                        jLimit = jLimit;
                        i3 = i3;
                        j = 1;
                    } else {
                        long j5 = jPosition + j;
                        Sb0.c(jPosition, (byte) ((cCharAt3 >>> 6) | 960));
                        jPosition += 2;
                        Sb0.c(j5, (byte) ((cCharAt3 & '?') | 128));
                    }
                    i3++;
                    jO = jO;
                    j = j;
                    jLimit = jLimit;
                    c = 128;
                } else {
                    Sb0.c(jPosition, (byte) cCharAt3);
                    jPosition += j;
                }
                i3++;
                jO = jO;
                j = j;
                jLimit = jLimit;
                c = 128;
            }
            i = (int) (jPosition - jO);
        }
        byteBuffer.position(i);
    }
}
