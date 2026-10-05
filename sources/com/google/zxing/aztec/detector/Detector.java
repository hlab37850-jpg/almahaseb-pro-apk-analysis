package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import org.apache.poi.ss.usermodel.ShapeTypes;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = {3808, 476, 2107, 1799};
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    public static final class a {
        public final int a;
        public final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public ResultPoint c() {
            return new ResultPoint(a(), b());
        }

        public String toString() {
            return "<" + this.a + ' ' + this.b + '>';
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private static float distance(a aVar, a aVar2) {
        return MathUtils.distance(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float x = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x2 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y2 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float f2 = x * f;
        float f3 = y * f;
        ResultPoint resultPoint = new ResultPoint(x2 + f2, y2 + f3);
        ResultPoint resultPoint2 = new ResultPoint(x2 - f2, y2 - f3);
        float x3 = resultPointArr[1].getX() - resultPointArr[3].getX();
        float y3 = resultPointArr[1].getY() - resultPointArr[3].getY();
        float x4 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
        float y4 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
        float f4 = x3 * f;
        float f5 = f * y3;
        return new ResultPoint[]{resultPoint, new ResultPoint(x4 + f4, y4 + f5), resultPoint2, new ResultPoint(x4 - f4, y4 - f5)};
    }

    private void extractParameters(ResultPoint[] resultPointArr) throws NotFoundException {
        long j;
        long j2;
        if (!isValid(resultPointArr[0]) || !isValid(resultPointArr[1]) || !isValid(resultPointArr[2]) || !isValid(resultPointArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = this.nbCenterLayers * 2;
        int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i), sampleLine(resultPointArr[1], resultPointArr[2], i), sampleLine(resultPointArr[2], resultPointArr[3], i), sampleLine(resultPointArr[3], resultPointArr[0], i)};
        this.shift = getRotation(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.shift + i2) % 4];
            if (this.compact) {
                j = j3 << 7;
                j2 = (i3 >> 1) & ShapeTypes.VERTICAL_SCROLL;
            } else {
                j = j3 << 10;
                j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
            }
            j3 = j + j2;
        }
        int correctedParameterData = getCorrectedParameterData(j3, this.compact);
        if (this.compact) {
            this.nbLayers = (correctedParameterData >> 6) + 1;
            this.nbDataBlocks = (correctedParameterData & 63) + 1;
        } else {
            this.nbLayers = (correctedParameterData >> 11) + 1;
            this.nbDataBlocks = (correctedParameterData & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) + 1;
        }
    }

    private ResultPoint[] getBullsEyeCorners(a aVar) throws NotFoundException {
        this.nbCenterLayers = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z = true;
        while (this.nbCenterLayers < 9) {
            a firstDifferent = getFirstDifferent(aVar2, z, 1, -1);
            a firstDifferent2 = getFirstDifferent(aVar3, z, 1, 1);
            a firstDifferent3 = getFirstDifferent(aVar4, z, -1, 1);
            a firstDifferent4 = getFirstDifferent(aVar5, z, -1, -1);
            if (this.nbCenterLayers > 2) {
                double dDistance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(aVar5, aVar2) * (this.nbCenterLayers + 2));
                if (dDistance < 0.75d || dDistance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z = !z;
            this.nbCenterLayers++;
            aVar5 = firstDifferent4;
            aVar2 = firstDifferent;
            aVar3 = firstDifferent2;
            aVar4 = firstDifferent3;
        }
        int i = this.nbCenterLayers;
        if (i != 5 && i != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.compact = i == 5;
        ResultPoint[] resultPointArr = {new ResultPoint(aVar2.a() + 0.5f, aVar2.b() - 0.5f), new ResultPoint(aVar3.a() + 0.5f, aVar3.b() + 0.5f), new ResultPoint(aVar4.a() - 0.5f, aVar4.b() + 0.5f), new ResultPoint(aVar5.a() - 0.5f, aVar5.b() - 0.5f)};
        int i2 = this.nbCenterLayers;
        return expandSquare(resultPointArr, (i2 * 2) - 3, i2 * 2);
    }

    private int getColor(a aVar, a aVar2) {
        float fDistance = distance(aVar, aVar2);
        float fA = (aVar2.a() - aVar.a()) / fDistance;
        float fB = (aVar2.b() - aVar.b()) / fDistance;
        float fA2 = aVar.a();
        float fB2 = aVar.b();
        boolean z = this.image.get(aVar.a(), aVar.b());
        int iCeil = (int) Math.ceil(fDistance);
        int i = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            fA2 += fA;
            fB2 += fB;
            if (this.image.get(MathUtils.round(fA2), MathUtils.round(fB2)) != z) {
                i++;
            }
        }
        float f = i / fDistance;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == z ? 1 : -1;
        }
        return 0;
    }

    private static int getCorrectedParameterData(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int getDimension() {
        if (this.compact) {
            return (this.nbLayers * 4) + 11;
        }
        int i = this.nbLayers;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    private a getFirstDifferent(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!isValid(iA, iB) || this.image.get(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (isValid(i3, i4) && this.image.get(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (isValid(i5, i4) && this.image.get(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    private a getMatrixCenter() {
        ResultPoint resultPointC;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPointC2;
        ResultPoint resultPointC3;
        ResultPoint resultPointC4;
        ResultPoint resultPointC5;
        try {
            ResultPoint[] resultPointArrDetect = new WhiteRectangleDetector(this.image).detect();
            resultPoint2 = resultPointArrDetect[0];
            resultPoint3 = resultPointArrDetect[1];
            resultPoint = resultPointArrDetect[2];
            resultPointC = resultPointArrDetect[3];
        } catch (NotFoundException unused) {
            int width = this.image.getWidth() / 2;
            int height = this.image.getHeight() / 2;
            int i = width + 7;
            int i2 = height - 7;
            ResultPoint resultPointC6 = getFirstDifferent(new a(i, i2), false, 1, -1).c();
            int i3 = height + 7;
            ResultPoint resultPointC7 = getFirstDifferent(new a(i, i3), false, 1, 1).c();
            int i4 = width - 7;
            ResultPoint resultPointC8 = getFirstDifferent(new a(i4, i3), false, -1, 1).c();
            resultPointC = getFirstDifferent(new a(i4, i2), false, -1, -1).c();
            resultPoint = resultPointC8;
            resultPoint2 = resultPointC6;
            resultPoint3 = resultPointC7;
        }
        int iRound = MathUtils.round((((resultPoint2.getX() + resultPointC.getX()) + resultPoint3.getX()) + resultPoint.getX()) / 4.0f);
        int iRound2 = MathUtils.round((((resultPoint2.getY() + resultPointC.getY()) + resultPoint3.getY()) + resultPoint.getY()) / 4.0f);
        try {
            ResultPoint[] resultPointArrDetect2 = new WhiteRectangleDetector(this.image, 15, iRound, iRound2).detect();
            resultPointC2 = resultPointArrDetect2[0];
            resultPointC3 = resultPointArrDetect2[1];
            resultPointC4 = resultPointArrDetect2[2];
            resultPointC5 = resultPointArrDetect2[3];
        } catch (NotFoundException unused2) {
            int i5 = iRound + 7;
            int i6 = iRound2 - 7;
            resultPointC2 = getFirstDifferent(new a(i5, i6), false, 1, -1).c();
            int i7 = iRound2 + 7;
            resultPointC3 = getFirstDifferent(new a(i5, i7), false, 1, 1).c();
            int i8 = iRound - 7;
            resultPointC4 = getFirstDifferent(new a(i8, i7), false, -1, 1).c();
            resultPointC5 = getFirstDifferent(new a(i8, i6), false, -1, -1).c();
        }
        return new a(MathUtils.round((((resultPointC2.getX() + resultPointC5.getX()) + resultPointC3.getX()) + resultPointC4.getX()) / 4.0f), MathUtils.round((((resultPointC2.getY() + resultPointC5.getY()) + resultPointC3.getY()) + resultPointC4.getY()) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension());
    }

    private static int getRotation(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(EXPECTED_CORNER_BITS[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean isValid(int i, int i2) {
        return i >= 0 && i < this.image.getWidth() && i2 > 0 && i2 < this.image.getHeight();
    }

    private boolean isWhiteOrBlackRectangle(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int color = getColor(aVar8, aVar5);
        return color != 0 && getColor(aVar5, aVar6) == color && getColor(aVar6, aVar7) == color && getColor(aVar7, aVar8) == color;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        GridSampler gridSampler = GridSampler.getInstance();
        int dimension = getDimension();
        float f = dimension / 2.0f;
        int i = this.nbCenterLayers;
        float f2 = f - i;
        float f3 = f + i;
        return gridSampler.sampleGrid(bitMatrix, dimension, dimension, f2, f2, f3, f2, f3, f3, f2, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float fDistance = distance(resultPoint, resultPoint2);
        float f = fDistance / i;
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f) / fDistance;
        float y2 = (f * (resultPoint2.getY() - resultPoint.getY())) / fDistance;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.image.get(MathUtils.round((f2 * x2) + x), MathUtils.round((f2 * y2) + y))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    public AztecDetectorResult detect() {
        return detect(false);
    }

    private static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private boolean isValid(ResultPoint resultPoint) {
        return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    public AztecDetectorResult detect(boolean z) throws NotFoundException {
        ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z) {
            ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        BitMatrix bitMatrix = this.image;
        int i = this.shift;
        return new AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i % 4], bullsEyeCorners[(i + 1) % 4], bullsEyeCorners[(i + 2) % 4], bullsEyeCorners[(i + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }
}
