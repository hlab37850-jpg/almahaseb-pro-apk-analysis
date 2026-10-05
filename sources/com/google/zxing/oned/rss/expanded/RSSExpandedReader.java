package com.google.zxing.oned.rss.expanded;

import androidx.compose.runtime.ComposerKt;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import defpackage.C1822bm;
import defpackage.C1903cm;
import defpackage.Z7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final List<C1822bm> pairs = new ArrayList(11);
    private final List<C1903cm> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, ShapeTypes.MATH_EQUAL, 118, ShapeTypes.FLOW_CHART_CONNECTOR, 7, 21, 63}, new int[]{189, ShapeTypes.FLOW_CHART_PUNCHED_TAPE, 13, 39, 117, ShapeTypes.FLOW_CHART_PREPARATION, 209, 205}, new int[]{193, ShapeTypes.FLOW_CHART_DISPLAY, 49, ShapeTypes.FLOW_CHART_OR, 19, 57, ShapeTypes.ACTION_BUTTON_SOUND, 91}, new int[]{62, ShapeTypes.CHART_STAR, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 197, ShapeTypes.ACTION_BUTTON_RETURN, 85, 44, ShapeTypes.FLOW_CHART_PROCESS}, new int[]{ShapeTypes.CHART_X, ShapeTypes.FLOW_CHART_DECISION, 188, ShapeTypes.FLOW_CHART_MANUAL_OPERATION, 4, 12, 36, 108}, new int[]{113, 128, ShapeTypes.GEAR_6, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, ShapeTypes.FLOW_CHART_DELAY, 52, ShapeTypes.FLOW_CHART_MAGNETIC_DRUM}, new int[]{46, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 203, ShapeTypes.CHART_PLUS, ShapeTypes.FLOW_CHART_TERMINATOR, ComposerKt.referenceKey, 196, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS}, new int[]{76, 17, 51, 153, 37, 111, 122, ShapeTypes.FLOW_CHART_MAGNETIC_DISK}, new int[]{43, 129, ShapeTypes.MATH_PLUS, 106, 107, 110, 119, ShapeTypes.FLOW_CHART_SUMMING_JUNCTION}, new int[]{16, 48, 144, 10, 30, 90, 59, ShapeTypes.MATH_MINUS}, new int[]{109, 116, ShapeTypes.FLOW_CHART_DOCUMENT, 200, ShapeTypes.MATH_MULTIPLY, 112, 125, 164}, new int[]{70, 210, 208, 202, ShapeTypes.PLAQUE_TABS, ShapeTypes.DOUBLE_WAVE, ShapeTypes.MATH_DIVIDE, 115}, new int[]{ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 191, ShapeTypes.FLOW_CHART_MERGE, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, ShapeTypes.ACTION_BUTTON_MOVIE, 94, 71, 2}, new int[]{6, 18, 54, ShapeTypes.ACTION_BUTTON_HOME, 64, 192, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 40}, new int[]{120, ShapeTypes.FLOW_CHART_SORT, 25, 75, 14, 42, 126, ShapeTypes.ACTION_BUTTON_END}, new int[]{79, 26, 78, 23, 69, ComposerKt.reuseKey, 199, ShapeTypes.FUNNEL}, new int[]{103, 98, 83, 38, 114, ShapeTypes.PLUS, ShapeTypes.CORNER_TABS, 124}, new int[]{ShapeTypes.ACTION_BUTTON_BLANK, 61, ShapeTypes.SQUARE_TABS, ShapeTypes.VERTICAL_SCROLL, ShapeTypes.ACTION_BUTTON_DOCUMENT, 88, 53, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS}, new int[]{55, ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, 73, 8, 24, 72, 5, 15}, new int[]{45, ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, 194, 160, 58, ShapeTypes.GEAR_9, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private void adjustOddEvenCounts(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        int iSum = MathUtils.sum(getOddCounts());
        int iSum2 = MathUtils.sum(getEvenCounts());
        boolean z4 = true;
        if (iSum > 13) {
            z4 = false;
            z = true;
        } else {
            z4 = iSum < 4;
            z = false;
        }
        if (iSum2 > 13) {
            z2 = false;
            z3 = true;
        } else {
            z2 = iSum2 < 4;
            z3 = false;
        }
        int i2 = (iSum + iSum2) - i;
        boolean z5 = (iSum & 1) == 1;
        boolean z6 = (iSum2 & 1) == 0;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z5) {
                    if (z6) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z = true;
                } else {
                    if (!z6) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z4 = z4;
                    z3 = true;
                }
            } else if (z5) {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iSum < iSum2) {
                    z3 = true;
                } else {
                    z2 = true;
                    z = true;
                }
            } else {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z4;
            }
        } else if (z5) {
            if (z6) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z6) {
                throw NotFoundException.getNotFoundInstance();
            }
            z4 = z4;
            z2 = true;
        }
        if (z4) {
            if (z) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z2) {
            if (z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z3) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        C1822bm c1822bm = this.pairs.get(0);
        DataCharacter dataCharacterB = c1822bm.b();
        DataCharacter dataCharacterC = c1822bm.c();
        if (dataCharacterC == null) {
            return false;
        }
        int checksumPortion = dataCharacterC.getChecksumPortion();
        int i = 2;
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            C1822bm c1822bm2 = this.pairs.get(i2);
            checksumPortion += c1822bm2.b().getChecksumPortion();
            int i3 = i + 1;
            DataCharacter dataCharacterC2 = c1822bm2.c();
            if (dataCharacterC2 != null) {
                checksumPortion += dataCharacterC2.getChecksumPortion();
                i += 2;
            } else {
                i = i3;
            }
        }
        return ((i + (-4)) * 211) + (checksumPortion % 211) == dataCharacterB.getValue();
    }

    private List<C1822bm> checkRows(boolean z) {
        List<C1822bm> listCheckRows = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z) {
            Collections.reverse(this.rows);
        }
        try {
            listCheckRows = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.rows);
        }
        return listCheckRows;
    }

    public static Result constructResult(List<C1822bm> list) {
        String information = AbstractExpandedDecoder.createDecoder(Z7.a(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).a().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).a().getResultPoints();
        return new Result(information, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<C1822bm> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).a().getStartEnd()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.startFromEven) {
            z = !z;
        }
        boolean z2 = false;
        while (i < size) {
            boolean z3 = bitArray.get(i);
            boolean z4 = !z3;
            if (z3) {
                z2 = z4;
                break;
            } else {
                i++;
                z2 = z4;
            }
        }
        boolean z5 = z2;
        int i2 = 0;
        int i3 = i;
        while (i < size) {
            if (bitArray.get(i) != z5) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                decodeFinderCounters[i2] = 1;
                z5 = !z5;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        return bitArray.get(i) ? bitArray.getNextSet(bitArray.getNextUnset(i)) : bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private static boolean isPartialRow(Iterable<C1822bm> iterable, Iterable<C1903cm> iterable2) {
        for (C1903cm c1903cm : iterable2) {
            for (C1822bm c1822bm : iterable) {
                Iterator it = c1903cm.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (c1822bm.equals((C1822bm) it.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isValidSequence(List<C1822bm> list) {
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).a().getValue() == iArr[i]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.startEnd;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.startEnd;
            int i7 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = nextUnset;
            i3 = i7;
            i4 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i4;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void removePartialRows(Collection<C1822bm> collection, Collection<C1903cm> collection2) {
        Iterator<C1903cm> it = collection2.iterator();
        while (it.hasNext()) {
            C1903cm next = it.next();
            if (next.a().size() != collection.size()) {
                Iterator it2 = next.a().iterator();
                do {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                } while (collection.contains((C1822bm) it2.next()));
            }
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private void storeRow(int i, boolean z) {
        boolean zC = false;
        int i2 = 0;
        boolean zC2 = false;
        while (i2 < this.rows.size()) {
            C1903cm c1903cm = this.rows.get(i2);
            if (c1903cm.b() > i) {
                zC = c1903cm.c(this.pairs);
                break;
            } else {
                zC2 = c1903cm.c(this.pairs);
                i2++;
            }
        }
        if (zC || zC2 || isPartialRow(this.pairs, this.rows)) {
            return;
        }
        this.rows.add(i2, new C1903cm(this.pairs, i, z));
        removePartialRows(this.pairs, this.rows);
    }

    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i = 0; i < dataCharacterCounters.length; i++) {
            dataCharacterCounters[i] = 0;
        }
        if (z2) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        float fSum = MathUtils.sum(dataCharacterCounters) / 17.0f;
        float f = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (Math.abs(fSum - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
            float f2 = (dataCharacterCounters[i4] * 1.0f) / fSum;
            int i5 = (int) (0.5f + f2);
            if (i5 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i5 = 1;
            } else if (i5 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                oddCounts[i6] = i5;
                oddRoundingErrors[i6] = f2 - i5;
            } else {
                evenCounts[i6] = i5;
                evenRoundingErrors[i6] = f2 - i5;
            }
        }
        adjustOddEvenCounts(17);
        int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i7 = 0;
        int i8 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i7 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
            }
            i8 += oddCounts[length2];
        }
        int i9 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i9 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
            }
        }
        int i10 = i7 + i9;
        if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = (13 - i8) / 2;
        int i12 = SYMBOL_WIDEST[i11];
        return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i12, true) * EVEN_TOTAL_SUBSET[i11]) + RSSUtils.getRSSvalue(evenCounts, 9 - i12, false) + GSUM[i11], i10);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    public List<C1822bm> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        boolean z = false;
        while (!z) {
            try {
                List<C1822bm> list = this.pairs;
                list.add(retrieveNextPair(bitArray, list, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (checkChecksum()) {
            return this.pairs;
        }
        boolean zIsEmpty = this.rows.isEmpty();
        storeRow(i, false);
        if (!zIsEmpty) {
            List<C1822bm> listCheckRows = checkRows(false);
            if (listCheckRows != null) {
                return listCheckRows;
            }
            List<C1822bm> listCheckRows2 = checkRows(true);
            if (listCheckRows2 != null) {
                return listCheckRows2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public List<C1903cm> getRows() {
        return this.rows;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    public C1822bm retrieveNextPair(BitArray bitArray, List<C1822bm> list, int i) throws NotFoundException {
        FinderPattern foundFinderPattern;
        DataCharacter dataCharacterDecodeDataCharacter;
        boolean z = list.size() % 2 == 0;
        if (this.startFromEven) {
            z = !z;
        }
        int nextSecondBar = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, nextSecondBar);
            foundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (foundFinderPattern == null) {
                nextSecondBar = getNextSecondBar(bitArray, this.startEnd[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, z, false);
        } catch (NotFoundException unused) {
            dataCharacterDecodeDataCharacter = null;
        }
        return new C1822bm(dataCharacterDecodeDataCharacter2, dataCharacterDecodeDataCharacter, foundFinderPattern);
    }

    private List<C1822bm> checkRows(List<C1903cm> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            C1903cm c1903cm = this.rows.get(i);
            this.pairs.clear();
            Iterator<C1903cm> it = list.iterator();
            while (it.hasNext()) {
                this.pairs.addAll(it.next().a());
            }
            this.pairs.addAll(c1903cm.a());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(c1903cm);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
