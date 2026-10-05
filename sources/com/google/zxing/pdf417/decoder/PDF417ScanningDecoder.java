package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import defpackage.AbstractC2100eF;
import defpackage.AbstractC3904si;
import defpackage.C0928Tb;
import defpackage.C1203a7;
import defpackage.C2139ej;
import defpackage.C2221fj;
import defpackage.C2303gj;
import defpackage.D8;
import defpackage.X6;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* JADX INFO: loaded from: classes3.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static D8 adjustBoundingBox(C2303gj c2303gj) {
        int[] iArrJ;
        if (c2303gj == null || (iArrJ = c2303gj.j()) == null) {
            return null;
        }
        int max = getMax(iArrJ);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrJ) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        C0928Tb[] c0928TbArrD = c2303gj.d();
        for (int i4 = 0; i2 > 0 && c0928TbArrD[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i5 = iArrJ[length];
            i += max - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = c0928TbArrD.length - 1; i > 0 && c0928TbArrD[length2] == null; length2--) {
            i--;
        }
        return c2303gj.a().a(i2, i, c2303gj.k());
    }

    private static void adjustCodewordCount(C2139ej c2139ej, C1203a7[][] c1203a7Arr) throws NotFoundException {
        C1203a7 c1203a7 = c1203a7Arr[0][1];
        int[] iArrB = c1203a7.b();
        int iJ = (c2139ej.j() * c2139ej.l()) - getNumberOfECCodeWords(c2139ej.k());
        if (iArrB.length != 0) {
            if (iArrB[0] != iJ) {
                c1203a7.c(iJ);
            }
        } else {
            if (iJ <= 0 || iJ > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            c1203a7.c(iJ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z) {
                    if (i6 >= i2) {
                        break;
                    }
                    if (z == bitMatrix.get(i6, i4)) {
                        break;
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                } else {
                    if (i6 < i) {
                        break;
                    }
                    if (z == bitMatrix.get(i6, i4)) {
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static C1203a7[][] createBarcodeMatrix(C2139ej c2139ej) {
        int iC;
        C1203a7[][] c1203a7Arr = (C1203a7[][]) Array.newInstance((Class<?>) C1203a7.class, c2139ej.l(), c2139ej.j() + 2);
        for (C1203a7[] c1203a7Arr2 : c1203a7Arr) {
            int i = 0;
            while (true) {
                if (i < c1203a7Arr2.length) {
                    c1203a7Arr2[i] = new C1203a7();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (C2221fj c2221fj : c2139ej.o()) {
            if (c2221fj != null) {
                for (C0928Tb c0928Tb : c2221fj.d()) {
                    if (c0928Tb != null && (iC = c0928Tb.c()) >= 0 && iC < c1203a7Arr.length) {
                        c1203a7Arr[iC][i2].c(c0928Tb.e());
                    }
                }
            }
            i2++;
        }
        return c1203a7Arr;
    }

    private static DecoderResult createDecoderResult(C2139ej c2139ej) throws NotFoundException {
        C1203a7[][] c1203a7ArrCreateBarcodeMatrix = createBarcodeMatrix(c2139ej);
        adjustCodewordCount(c2139ej, c1203a7ArrCreateBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[c2139ej.l() * c2139ej.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < c2139ej.l(); i++) {
            int i2 = 0;
            while (i2 < c2139ej.j()) {
                int i3 = i2 + 1;
                int[] iArrB = c1203a7ArrCreateBarcodeMatrix[i][i3].b();
                int iJ = (c2139ej.j() * i) + i2;
                if (iArrB.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrB.length == 1) {
                    iArr[iJ] = iArrB[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrB);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(c2139ej.k(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return decodeCodewords(iArr, i, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
                i2 = i3;
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        int i3;
        C2221fj c2221fj;
        int i4;
        C2303gj rowIndicatorColumn = null;
        C2303gj rowIndicatorColumn2 = null;
        D8 d8 = new D8(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        boolean z = true;
        while (true) {
            if (resultPoint != null) {
                rowIndicatorColumn = getRowIndicatorColumn(bitMatrix, d8, resultPoint, true, i, i2);
            }
            if (resultPoint3 != null) {
                rowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, d8, resultPoint3, false, i, i2);
            }
            C2139ej c2139ejMerge = merge(rowIndicatorColumn, rowIndicatorColumn2);
            if (c2139ejMerge == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            D8 d8M = c2139ejMerge.m();
            if (!z || d8M == null || (d8M.g() >= d8.g() && d8M.e() <= d8.e())) {
                c2139ejMerge.p(d8);
                int iJ = c2139ejMerge.j() + 1;
                c2139ejMerge.q(0, rowIndicatorColumn);
                c2139ejMerge.q(iJ, rowIndicatorColumn2);
                boolean z2 = rowIndicatorColumn != null;
                int iMin = i;
                int iMax = i2;
                for (int i5 = 1; i5 <= iJ; i5++) {
                    int i6 = z2 ? i5 : iJ - i5;
                    if (c2139ejMerge.n(i6) == null) {
                        C2221fj c2303gj = (i6 == 0 || i6 == iJ) ? new C2303gj(d8, i6 == 0) : new C2221fj(d8);
                        c2139ejMerge.q(i6, c2303gj);
                        int i7 = -1;
                        int iG = d8.g();
                        int i8 = -1;
                        while (iG <= d8.e()) {
                            int startColumn = getStartColumn(c2139ejMerge, i6, iG, z2);
                            if (startColumn < 0 || startColumn > d8.d()) {
                                if (i8 != i7) {
                                    i4 = i8;
                                } else {
                                    i3 = iG;
                                    c2221fj = c2303gj;
                                }
                                i8 = i8;
                                iG = i3 + 1;
                                c2303gj = c2221fj;
                                i7 = -1;
                            } else {
                                i4 = startColumn;
                            }
                            int i9 = iG;
                            c2221fj = c2303gj;
                            C0928Tb c0928TbDetectCodeword = detectCodeword(bitMatrix, d8.f(), d8.d(), z2, i4, i9, iMin, iMax);
                            i3 = i9;
                            if (c0928TbDetectCodeword != null) {
                                c2221fj.f(i3, c0928TbDetectCodeword);
                                iMin = Math.min(iMin, c0928TbDetectCodeword.f());
                                iMax = Math.max(iMax, c0928TbDetectCodeword.f());
                                i8 = i4;
                            } else {
                                i8 = i8;
                            }
                            iG = i3 + 1;
                            c2303gj = c2221fj;
                            i7 = -1;
                        }
                    }
                }
                return createDecoderResult(c2139ejMerge);
            }
            d8 = d8M;
            z = false;
        }
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int iCorrectErrors = correctErrors(iArr, iArr2, i2);
        verifyCodewordCount(iArr, i2);
        DecoderResult decoderResultB = AbstractC3904si.b(iArr, String.valueOf(i));
        decoderResultB.setErrorsCorrected(Integer.valueOf(iCorrectErrors));
        decoderResultB.setErasures(Integer.valueOf(iArr2.length));
        return decoderResultB;
    }

    private static C0928Tb detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iD;
        int codeword;
        int iAdjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, iAdjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int iSum = MathUtils.sum(moduleBitCount);
        if (z) {
            i7 = iAdjustCodewordStartColumn + iSum;
        } else {
            for (int i8 = 0; i8 < moduleBitCount.length / 2; i8++) {
                int i9 = moduleBitCount[i8];
                moduleBitCount[i8] = moduleBitCount[(moduleBitCount.length - 1) - i8];
                moduleBitCount[(moduleBitCount.length - 1) - i8] = i9;
            }
            iAdjustCodewordStartColumn -= iSum;
            i7 = iAdjustCodewordStartColumn;
        }
        if (checkCodewordSkew(iSum, i5, i6) && (codeword = PDF417Common.getCodeword((iD = AbstractC2100eF.d(moduleBitCount)))) != -1) {
            return new C0928Tb(iAdjustCodewordStartColumn, i7, getCodewordBucketNumber(iD), codeword);
        }
        return null;
    }

    private static X6 getBarcodeMetadata(C2303gj c2303gj, C2303gj c2303gj2) {
        X6 x6I;
        X6 x6I2;
        if (c2303gj == null || (x6I = c2303gj.i()) == null) {
            if (c2303gj2 == null) {
                return null;
            }
            return c2303gj2.i();
        }
        if (c2303gj2 == null || (x6I2 = c2303gj2.i()) == null || x6I.a() == x6I2.a() || x6I.b() == x6I2.b() || x6I.c() == x6I2.c()) {
            return x6I;
        }
        return null;
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getMax(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
                if (i6 < 8) {
                    break;
                    break;
                }
                if (bitMatrix.get(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            } else {
                if (i3 >= i2) {
                    break;
                }
                if (i6 < 8) {
                    break;
                }
                if (bitMatrix.get(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private static C2303gj getRowIndicatorColumn(BitMatrix bitMatrix, D8 d8, ResultPoint resultPoint, boolean z, int i, int i2) {
        C2303gj c2303gj = new C2303gj(d8, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            for (int y = (int) resultPoint.getY(); y <= d8.e() && y >= d8.g(); y += i4) {
                C0928Tb c0928TbDetectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (c0928TbDetectCodeword != null) {
                    c2303gj.f(y, c0928TbDetectCodeword);
                    x = z ? c0928TbDetectCodeword.d() : c0928TbDetectCodeword.b();
                }
            }
            i3++;
        }
        return c2303gj;
    }

    private static int getStartColumn(C2139ej c2139ej, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        C0928Tb c0928TbB = isValidBarcodeColumn(c2139ej, i4) ? c2139ej.n(i4).b(i2) : null;
        if (c0928TbB != null) {
            return z ? c0928TbB.b() : c0928TbB.d();
        }
        C0928Tb c0928TbC = c2139ej.n(i).c(i2);
        if (c0928TbC != null) {
            return z ? c0928TbC.d() : c0928TbC.b();
        }
        if (isValidBarcodeColumn(c2139ej, i4)) {
            c0928TbC = c2139ej.n(i4).c(i2);
        }
        if (c0928TbC != null) {
            return z ? c0928TbC.b() : c0928TbC.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!isValidBarcodeColumn(c2139ej, i)) {
                D8 d8M = c2139ej.m();
                return z ? d8M.f() : d8M.d();
            }
            for (C0928Tb c0928Tb : c2139ej.n(i).d()) {
                if (c0928Tb != null) {
                    return (z ? c0928Tb.b() : c0928Tb.d()) + (i3 * i5 * (c0928Tb.b() - c0928Tb.d()));
                }
            }
            i5++;
        }
    }

    private static boolean isValidBarcodeColumn(C2139ej c2139ej, int i) {
        return i >= 0 && i <= c2139ej.j() + 1;
    }

    private static C2139ej merge(C2303gj c2303gj, C2303gj c2303gj2) {
        X6 barcodeMetadata;
        if ((c2303gj == null && c2303gj2 == null) || (barcodeMetadata = getBarcodeMetadata(c2303gj, c2303gj2)) == null) {
            return null;
        }
        return new C2139ej(barcodeMetadata, D8.j(adjustBoundingBox(c2303gj), adjustBoundingBox(c2303gj2)));
    }

    public static String toString(C1203a7[][] c1203a7Arr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < c1203a7Arr.length; i++) {
            try {
                formatter.format("Row %2d: ", Integer.valueOf(i));
                int i2 = 0;
                while (true) {
                    C1203a7[] c1203a7Arr2 = c1203a7Arr[i];
                    if (i2 < c1203a7Arr2.length) {
                        C1203a7 c1203a7 = c1203a7Arr2[i2];
                        if (c1203a7.b().length == 0) {
                            formatter.format("        ", null);
                        } else {
                            formatter.format("%4d(%2d)", Integer.valueOf(c1203a7.b()[0]), c1203a7.a(c1203a7.b()[0]));
                        }
                        i2++;
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i;
        }
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
