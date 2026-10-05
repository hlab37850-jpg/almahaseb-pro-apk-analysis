package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: nC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3458nC extends FinderPatternFinder {
    public static final FinderPatternInfo[] a = new FinderPatternInfo[0];
    public static final FinderPattern[] b = new FinderPattern[0];
    public static final FinderPattern[][] c = new FinderPattern[0][];

    /* JADX INFO: renamed from: nC$b */
    public static final class b implements Serializable, Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            double estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    public C3458nC(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }

    public FinderPatternInfo[] a(Map map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i = (height * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        for (int i2 = i - 1; i2 < height; i2 += i) {
            clearCounts(iArr);
            int i3 = 0;
            for (int i4 = 0; i4 < width; i4++) {
                if (image.get(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 != 4) {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                } else if (FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i4)) {
                    clearCounts(iArr);
                    i3 = 0;
                } else {
                    shiftCounts2(iArr);
                    i3 = 3;
                }
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i2, width);
            }
        }
        FinderPattern[][] finderPatternArrB = b();
        ArrayList arrayList = new ArrayList();
        for (FinderPattern[] finderPatternArr : finderPatternArrB) {
            ResultPoint.orderBestPatterns(finderPatternArr);
            arrayList.add(new FinderPatternInfo(finderPatternArr));
        }
        return arrayList.isEmpty() ? a : (FinderPatternInfo[]) arrayList.toArray(a);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0140  */
    public final FinderPattern[][] b() throws NotFoundException {
        ArrayList arrayList;
        char c2 = 0;
        List<FinderPattern> possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i = 3;
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size == 3) {
            return new FinderPattern[][]{(FinderPattern[]) possibleCenters.toArray(b)};
        }
        Collections.sort(possibleCenters, new b());
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < size - 2) {
            FinderPattern finderPattern = possibleCenters.get(i2);
            if (finderPattern != null) {
                int i3 = i2 + 1;
                while (i3 < size - 1) {
                    FinderPattern finderPattern2 = possibleCenters.get(i3);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        float f = 0.05f;
                        float f2 = 0.5f;
                        if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > 0.5f && estimatedModuleSize >= 0.05f) {
                            break;
                        }
                        int i4 = i3 + 1;
                        while (i4 < size) {
                            FinderPattern finderPattern3 = possibleCenters.get(i4);
                            if (finderPattern3 != null) {
                                float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > f2 && estimatedModuleSize2 >= f) {
                                    break;
                                }
                                FinderPattern[] finderPatternArr = new FinderPattern[i];
                                finderPatternArr[c2] = finderPattern;
                                finderPatternArr[1] = finderPattern2;
                                finderPatternArr[2] = finderPattern3;
                                ResultPoint.orderBestPatterns(finderPatternArr);
                                FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr);
                                float fDistance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                float fDistance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                float fDistance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                float estimatedModuleSize3 = (fDistance + fDistance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                if (estimatedModuleSize3 > 180.0f || estimatedModuleSize3 < 9.0f || Math.abs((fDistance - fDistance3) / Math.min(fDistance, fDistance3)) >= 0.1f) {
                                    arrayList = arrayList2;
                                } else {
                                    double d = fDistance;
                                    ArrayList arrayList3 = arrayList2;
                                    double d2 = fDistance3;
                                    float fSqrt = (float) Math.sqrt((d * d) + (d2 * d2));
                                    if (Math.abs((fDistance2 - fSqrt) / Math.min(fDistance2, fSqrt)) < 0.1f) {
                                        arrayList = arrayList3;
                                        arrayList.add(finderPatternArr);
                                    } else {
                                        arrayList = arrayList3;
                                    }
                                }
                            } else {
                                arrayList = arrayList2;
                            }
                            i4++;
                            arrayList2 = arrayList;
                            c2 = 0;
                            i = 3;
                            f = 0.05f;
                            f2 = 0.5f;
                        }
                    }
                    i3++;
                    arrayList2 = arrayList2;
                    c2 = 0;
                    i = 3;
                }
            }
            i2++;
            arrayList2 = arrayList2;
            c2 = 0;
            i = 3;
        }
        ArrayList arrayList4 = arrayList2;
        if (arrayList4.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (FinderPattern[][]) arrayList4.toArray(c);
    }
}
