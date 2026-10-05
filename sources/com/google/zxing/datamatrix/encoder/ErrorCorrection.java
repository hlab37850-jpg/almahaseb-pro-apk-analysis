package com.google.zxing.datamatrix.encoder;

import androidx.compose.runtime.ComposerKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 240, 92, TIFFConstants.TIFFTAG_SUBFILETYPE}, new int[]{28, 24, ShapeTypes.CHART_X, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS, 223, 248, 116, 255, 110, 61}, new int[]{ShapeTypes.FUNNEL, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 205, 12, 194, ShapeTypes.ACTION_BUTTON_BEGINNING, 39, 245, 60, 97, 120}, new int[]{41, 153, ShapeTypes.FLOW_CHART_DELAY, 91, 61, 42, ShapeTypes.FLOW_CHART_MANUAL_OPERATION, 213, 97, ShapeTypes.MATH_MULTIPLY, 100, 242}, new int[]{ShapeTypes.FLOW_CHART_MAGNETIC_DRUM, 97, 192, 252, 95, 9, ShapeTypes.FLOW_CHART_DISPLAY, 119, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 45, 18, ShapeTypes.CHART_STAR, 83, ShapeTypes.CHART_X}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, TIFFConstants.TIFFTAG_SUBFILETYPE, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, UnknownRecord.BITMAP_00E9, 71, ShapeTypes.ACTION_BUTTON_BEGINNING, 2, 188, 160, 153, ShapeTypes.FLOW_CHART_PUNCHED_TAPE, 253, 79, 108, 82, 27, ShapeTypes.GEAR_9, ShapeTypes.CHART_STAR, ShapeTypes.ACTION_BUTTON_MOVIE}, new int[]{52, 190, 88, 205, 109, 39, ShapeTypes.MATH_PLUS, 21, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 197, 251, 223, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 21, 5, ShapeTypes.ACTION_BUTTON_MOVIE, TIFFConstants.TIFFTAG_SUBFILETYPE, 124, 12, ShapeTypes.MATH_NOT_EQUAL, ShapeTypes.PLAQUE_TABS, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, ShapeTypes.GEAR_9, 37, ShapeTypes.FLOW_CHART_MERGE, ShapeTypes.ACTION_BUTTON_DOCUMENT, 53, 75, 34, 249, 121, 17, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 110, 213, ShapeTypes.FLOW_CHART_MANUAL_INPUT, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 120, ShapeTypes.FLOW_CHART_MERGE, UnknownRecord.BITMAP_00E9, ShapeTypes.ACTION_BUTTON_BEGINNING, 93, 255}, new int[]{245, ShapeTypes.VERTICAL_SCROLL, 242, 218, ShapeTypes.DOUBLE_WAVE, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ShapeTypes.ACTION_BUTTON_HOME, ShapeTypes.MATH_NOT_EQUAL, 102, 120, 84, ShapeTypes.MATH_DIVIDE, 220, 251, 80, ShapeTypes.CORNER_TABS, 229, 18, 2, 4, 68, 33, 101, ShapeTypes.FLOW_CHART_DOCUMENT, 95, 119, 115, 44, ShapeTypes.FUNNEL, ShapeTypes.PLAQUE_TABS, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, ShapeTypes.FLOW_CHART_DOCUMENT, 31, 19, 38, 22, 153, MetaDo.META_CREATEPALETTE, 105, 122, 2, 245, ShapeTypes.FLOW_CHART_DECISION, 242, 8, ShapeTypes.FUNNEL, 95, 100, 9, ShapeTypes.ACTION_BUTTON_END, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, ShapeTypes.MATH_MINUS, Jpeg.M_APP2, 5, 9, 5}, new int[]{245, ShapeTypes.FLOW_CHART_PROCESS, ShapeTypes.ACTION_BUTTON_MOVIE, 223, 96, 32, 117, 22, Jpeg.M_APPE, ShapeTypes.FLOW_CHART_DECISION, Jpeg.M_APPE, 231, 205, 188, Jpeg.M_APPD, 87, 191, 106, 16, ShapeTypes.FLOW_CHART_OR, 118, 23, 37, 90, ShapeTypes.ACTION_BUTTON_DOCUMENT, 205, ShapeTypes.PLUS, 88, 120, 100, 66, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, ShapeTypes.CHART_STAR, 240, 82, 44, ShapeTypes.MATH_PLUS, 87, ShapeTypes.CHART_PLUS, ShapeTypes.FLOW_CHART_OR, 160, ShapeTypes.FUNNEL, 69, 213, 92, 253, 225, 19}, new int[]{ShapeTypes.FUNNEL, 9, 223, Jpeg.M_APPE, 12, 17, 220, 208, 100, 29, ShapeTypes.FUNNEL, ShapeTypes.ACTION_BUTTON_DOCUMENT, 230, 192, 215, 235, 150, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, 36, 223, 38, 200, ShapeTypes.FLOW_CHART_PROCESS, 54, 228, ShapeTypes.FLOW_CHART_SUMMING_JUNCTION, 218, 234, 117, 203, 29, 232, 144, Jpeg.M_APPE, 22, 150, 201, 117, 62, ComposerKt.reuseKey, 164, 13, ShapeTypes.FLOW_CHART_DOCUMENT, 245, ShapeTypes.VERTICAL_SCROLL, 67, MetaDo.META_CREATEPALETTE, 28, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 43, 203, 107, UnknownRecord.BITMAP_00E9, 53, ShapeTypes.FLOW_CHART_CONNECTOR, 46}, new int[]{242, 93, ShapeTypes.ACTION_BUTTON_RETURN, 50, 144, 210, 39, 118, 202, 188, 201, 189, ShapeTypes.FLOW_CHART_CONNECTOR, 108, 196, 37, ShapeTypes.CHART_X, 112, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, ShapeTypes.CHART_X, 221, ShapeTypes.FUNNEL, 64, 114, 71, ShapeTypes.ACTION_BUTTON_BLANK, 44, ShapeTypes.FLOW_CHART_OR, 6, 27, 218, 51, 63, 87, 10, 40, ShapeTypes.DOUBLE_WAVE, 188, 17, ShapeTypes.ACTION_BUTTON_HELP, 31, ShapeTypes.MATH_PLUS, ShapeTypes.ACTION_BUTTON_DOCUMENT, 4, 107, 232, 7, 94, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, ShapeTypes.GEAR_6, 89, 251, ShapeTypes.FLOW_CHART_SORT, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, 56, 89, 33, ShapeTypes.FLOW_CHART_OR, 244, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 36, 73, ShapeTypes.VERTICAL_SCROLL, 213, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 248, ShapeTypes.MATH_EQUAL, 234, 197, ShapeTypes.FLOW_CHART_DELAY, ShapeTypes.MATH_MINUS, 68, 122, 93, 213, 15, 160, 227, 236, 66, ShapeTypes.FLOW_CHART_TERMINATOR, 153, ShapeTypes.CHART_X, 202, ShapeTypes.ACTION_BUTTON_END, ShapeTypes.MATH_DIVIDE, 25, 220, 232, 96, 210, 231, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 223, UnknownRecord.PHONETICPR_00EF, ShapeTypes.MATH_NOT_EQUAL, 241, 59, 52, ShapeTypes.ACTION_BUTTON_MOVIE, 25, 49, 232, 211, 189, 64, 54, 108, 153, ShapeTypes.FLOW_CHART_PROCESS, 63, 96, 103, 82, ShapeTypes.CHART_STAR}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, strCreateECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
        }
        int[] iArr2 = FACTORS[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt == 0 || (i5 = iArr2[i9]) == 0) {
                    cArr[i9] = cArr[i9 - 1];
                } else {
                    char c = cArr[i9 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c);
                }
                i9--;
            }
            if (iCharAt == 0 || (i4 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }
}
