package com.itextpdf.text.pdf;

import androidx.compose.runtime.ComposerKt;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Hashtable;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeDatamatrix {
    public static final int DM_ASCII = 1;
    public static final int DM_AUTO = 0;
    public static final int DM_B256 = 4;
    public static final int DM_C40 = 2;
    public static final int DM_EDIFACT = 6;
    public static final int DM_ERROR_EXTENSION = 5;
    public static final int DM_ERROR_INVALID_SQUARE = 3;
    public static final int DM_ERROR_TEXT_TOO_BIG = 1;
    public static final int DM_EXTENSION = 32;
    public static final int DM_NO_ERROR = 0;
    public static final int DM_RAW = 7;
    public static final int DM_TEST = 64;
    public static final int DM_TEXT = 3;
    public static final int DM_X21 = 5;
    private static final DmParams[] dmSizes = {new DmParams(10, 10, 10, 10, 3, 3, 5), new DmParams(12, 12, 12, 12, 5, 5, 7), new DmParams(8, 18, 8, 18, 5, 5, 7), new DmParams(14, 14, 14, 14, 8, 8, 10), new DmParams(8, 32, 8, 16, 10, 10, 11), new DmParams(16, 16, 16, 16, 12, 12, 12), new DmParams(12, 26, 12, 26, 16, 16, 14), new DmParams(18, 18, 18, 18, 18, 18, 14), new DmParams(20, 20, 20, 20, 22, 22, 18), new DmParams(12, 36, 12, 18, 22, 22, 18), new DmParams(22, 22, 22, 22, 30, 30, 20), new DmParams(16, 36, 16, 18, 32, 32, 24), new DmParams(24, 24, 24, 24, 36, 36, 24), new DmParams(26, 26, 26, 26, 44, 44, 28), new DmParams(16, 48, 16, 24, 49, 49, 28), new DmParams(32, 32, 16, 16, 62, 62, 36), new DmParams(36, 36, 18, 18, 86, 86, 42), new DmParams(40, 40, 20, 20, 114, 114, 48), new DmParams(44, 44, 22, 22, 144, 144, 56), new DmParams(48, 48, 24, 24, ShapeTypes.GEAR_9, ShapeTypes.GEAR_9, 68), new DmParams(52, 52, 26, 26, 204, 102, 42), new DmParams(64, 64, 16, 16, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, ShapeTypes.FLOW_CHART_PREPARATION, 56), new DmParams(72, 72, 18, 18, 368, 92, 36), new DmParams(80, 80, 20, 20, 456, 114, 48), new DmParams(88, 88, 22, 22, 576, 144, 56), new DmParams(96, 96, 24, 24, 696, ShapeTypes.GEAR_9, 68), new DmParams(104, 104, 26, 26, 816, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 56), new DmParams(120, 120, 20, 20, 1050, ShapeTypes.FUNNEL, 68), new DmParams(ShapeTypes.FLOW_CHART_PROCESS, ShapeTypes.FLOW_CHART_PROCESS, 22, 22, 1304, ShapeTypes.ACTION_BUTTON_HELP, 62), new DmParams(144, 144, 24, 24, 1558, ShapeTypes.FLOW_CHART_MAGNETIC_DRUM, 62)};
    private static final String x12 = "\r*> 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int extOut;
    private boolean forceSquareSize = false;
    private int height;
    private byte[] image;
    private int options;
    private short[] place;
    private int width;
    private int ws;

    public static class DmParams {
        int dataBlock;
        int dataSize;
        int errorBlock;
        int height;
        int heightSection;
        int width;
        int widthSection;

        public DmParams(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.height = i;
            this.width = i2;
            this.heightSection = i3;
            this.widthSection = i4;
            this.dataSize = i5;
            this.dataBlock = i6;
            this.errorBlock = i7;
        }
    }

    public static class Placement {
        private static final Hashtable<Integer, short[]> cache = new Hashtable<>();
        private short[] array;
        private int ncol;
        private int nrow;

        private Placement() {
        }

        private void corner1(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, 1, i, 1);
            module(this.nrow - 1, 2, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner2(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 4, i, 3);
            module(0, this.ncol - 3, i, 4);
            module(0, this.ncol - 2, i, 5);
            module(0, this.ncol - 1, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void corner3(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner4(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, this.ncol - 1, i, 1);
            module(0, this.ncol - 3, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 3, i, 5);
            module(1, this.ncol - 2, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        public static short[] doPlacement(int i, int i2) {
            Integer numValueOf = Integer.valueOf((i * 1000) + i2);
            Hashtable<Integer, short[]> hashtable = cache;
            short[] sArr = hashtable.get(numValueOf);
            if (sArr != null) {
                return sArr;
            }
            Placement placement = new Placement();
            placement.nrow = i;
            placement.ncol = i2;
            placement.array = new short[i * i2];
            placement.ecc200();
            hashtable.put(numValueOf, placement.array);
            return placement.array;
        }

        private void ecc200() {
            int i;
            int i2;
            int i3 = 0;
            Arrays.fill(this.array, (short) 0);
            int i4 = 4;
            int i5 = 1;
            while (true) {
                if (i4 == this.nrow && i3 == 0) {
                    corner1(i5);
                    i5++;
                }
                if (i4 == this.nrow - 2 && i3 == 0 && this.ncol % 4 != 0) {
                    corner2(i5);
                    i5++;
                }
                if (i4 == this.nrow - 2 && i3 == 0 && this.ncol % 8 == 4) {
                    corner3(i5);
                    i5++;
                }
                if (i4 == this.nrow + 4 && i3 == 2 && this.ncol % 8 == 0) {
                    corner4(i5);
                    i5++;
                }
                while (true) {
                    if (i4 < this.nrow && i3 >= 0 && this.array[(this.ncol * i4) + i3] == 0) {
                        utah(i4, i3, i5);
                        i5++;
                    }
                    int i6 = i4 - 2;
                    int i7 = i3 + 2;
                    if (i6 < 0 || i7 >= this.ncol) {
                        break;
                    }
                    i4 = i6;
                    i3 = i7;
                }
                int i8 = i4 - 1;
                int i9 = i3 + 5;
                while (true) {
                    if (i8 >= 0) {
                        int i10 = this.ncol;
                        if (i9 < i10 && this.array[(i10 * i8) + i9] == 0) {
                            utah(i8, i9, i5);
                            i5++;
                        }
                    }
                    int i11 = i8 + 2;
                    int i12 = i9 - 2;
                    i = this.nrow;
                    if (i11 >= i || i12 < 0) {
                        break;
                    }
                    i8 = i11;
                    i9 = i12;
                }
                i4 = i8 + 5;
                i3 = i9 - 1;
                if (i4 >= i && i3 >= (i2 = this.ncol)) {
                    break;
                }
            }
            short[] sArr = this.array;
            if (sArr[(i * i2) - 1] == 0) {
                sArr[((i * i2) - i2) - 2] = 1;
                sArr[(i * i2) - 1] = 1;
            }
        }

        private void module(int i, int i2, int i3, int i4) {
            if (i < 0) {
                int i5 = this.nrow;
                i += i5;
                i2 += 4 - ((i5 + 4) % 8);
            }
            if (i2 < 0) {
                int i6 = this.ncol;
                i2 += i6;
                i += 4 - ((i6 + 4) % 8);
            }
            this.array[(i * this.ncol) + i2] = (short) ((i3 * 8) + i4);
        }

        private void utah(int i, int i2, int i3) {
            int i4 = i - 2;
            int i5 = i2 - 2;
            module(i4, i5, i3, 0);
            int i6 = i2 - 1;
            module(i4, i6, i3, 1);
            int i7 = i - 1;
            module(i7, i5, i3, 2);
            module(i7, i6, i3, 3);
            module(i7, i2, i3, 4);
            module(i, i5, i3, 5);
            module(i, i6, i3, 6);
            module(i, i2, i3, 7);
        }
    }

    public static class ReedSolomon {
        private static final int[] log = {0, 255, 1, 240, 2, 225, 241, 53, 3, 38, Jpeg.M_APP2, ShapeTypes.FLOW_CHART_DECISION, 242, 43, 54, 210, 4, 195, 39, 114, 227, 106, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 28, 243, ShapeTypes.FLOW_CHART_PREPARATION, 44, 23, 55, 118, 211, 234, 5, 219, 196, 96, 40, 222, 115, 103, 228, 78, 107, 125, ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, 8, 29, ShapeTypes.ACTION_BUTTON_HOME, 244, ShapeTypes.CHART_STAR, ShapeTypes.FLOW_CHART_MANUAL_INPUT, ShapeTypes.MATH_EQUAL, 45, 99, 24, 49, 56, 13, 119, 153, 212, 199, 235, 91, 6, 76, 220, 217, 197, 11, 97, ShapeTypes.PLAQUE_TABS, 41, 36, 223, 253, 116, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 104, 193, 229, 86, 79, ShapeTypes.ACTION_BUTTON_SOUND, 108, ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, 126, ShapeTypes.FLOW_CHART_PUNCHED_TAPE, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 34, 9, 74, 30, 32, ShapeTypes.ACTION_BUTTON_HELP, 84, 245, ShapeTypes.GEAR_6, ShapeTypes.CHART_PLUS, 204, ShapeTypes.FLOW_CHART_MANUAL_OPERATION, 81, ShapeTypes.MATH_NOT_EQUAL, 190, 46, 88, 100, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, 25, 231, 50, ComposerKt.reuseKey, 57, ShapeTypes.FLOW_CHART_OR, 14, 67, 120, 128, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 248, 213, ShapeTypes.ACTION_BUTTON_END, 200, 63, 236, 110, 92, ShapeTypes.MATH_PLUS, 7, ShapeTypes.ACTION_BUTTON_BLANK, 77, 124, 221, 102, 218, 95, 198, 90, 12, ShapeTypes.FLOW_CHART_OFFLINE_STORAGE, 98, 48, ShapeTypes.CHART_X, ShapeTypes.MATH_DIVIDE, 42, 209, 37, ShapeTypes.FLOW_CHART_PROCESS, 224, 52, TIFFConstants.TIFFTAG_SUBFILETYPE, UnknownRecord.PHONETICPR_00EF, 117, UnknownRecord.BITMAP_00E9, ShapeTypes.FLOW_CHART_TERMINATOR, 22, 105, 27, 194, 113, 230, ComposerKt.referenceKey, 87, ShapeTypes.FLOW_CHART_DELAY, 80, 189, ShapeTypes.ACTION_BUTTON_MOVIE, 203, 109, ShapeTypes.FUNNEL, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS, 62, ShapeTypes.VERTICAL_SCROLL, MetaDo.META_CREATEPALETTE, ShapeTypes.FLOW_CHART_SUMMING_JUNCTION, 66, ShapeTypes.FLOW_CHART_DOCUMENT, 192, 35, 252, 10, ShapeTypes.SQUARE_TABS, 75, 216, 31, 83, 33, 73, 164, 144, 85, ShapeTypes.ACTION_BUTTON_DOCUMENT, 246, 65, ShapeTypes.GEAR_9, 61, 188, 202, 205, ShapeTypes.FLOW_CHART_DISPLAY, ShapeTypes.FLOW_CHART_CONNECTOR, ShapeTypes.ACTION_BUTTON_RETURN, 82, 72, ShapeTypes.CORNER_TABS, 215, 191, 251, 47, ShapeTypes.MATH_MULTIPLY, 89, ShapeTypes.FLOW_CHART_MERGE, 101, 94, 160, 123, 26, 112, 232, 21, 51, Jpeg.M_APPE, 208, ShapeTypes.PLUS, 58, 69, 148, 18, 15, 16, 68, 17, 121, ShapeTypes.FLOW_CHART_SORT, 129, 19, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 59, 249, 70, 214, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ShapeTypes.ACTION_BUTTON_BEGINNING, 71, 201, ShapeTypes.FLOW_CHART_MAGNETIC_DRUM, 64, 60, Jpeg.M_APPD, ShapeTypes.DOUBLE_WAVE, 111, 20, 93, 122, ShapeTypes.MATH_MINUS, 150};
        private static final int[] alog = {1, 2, 4, 8, 16, 32, 64, 128, 45, 90, ShapeTypes.MATH_EQUAL, 69, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 57, 114, 228, 229, 231, 227, 235, 251, 219, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 27, 54, 108, 216, ShapeTypes.FLOW_CHART_DISPLAY, 23, 46, 92, ShapeTypes.PLAQUE_TABS, 93, ShapeTypes.CHART_STAR, 89, ShapeTypes.MATH_MULTIPLY, 73, ShapeTypes.FLOW_CHART_SUMMING_JUNCTION, 9, 18, 36, 72, 144, 13, 26, 52, 104, 208, ShapeTypes.FLOW_CHART_MANUAL_INPUT, 55, 110, 220, ShapeTypes.FLOW_CHART_SORT, 7, 14, 28, 56, 112, 224, Jpeg.M_APPD, MetaDo.META_CREATEPALETTE, 195, ShapeTypes.ACTION_BUTTON_SOUND, 123, 246, 193, ShapeTypes.FUNNEL, 115, 230, 225, UnknownRecord.PHONETICPR_00EF, 243, 203, ShapeTypes.CHART_PLUS, 91, ShapeTypes.CORNER_TABS, 65, ShapeTypes.DOUBLE_WAVE, 41, 82, 164, 101, 202, ShapeTypes.CHART_X, 95, 190, 81, ShapeTypes.ACTION_BUTTON_HOME, 105, 210, ShapeTypes.FLOW_CHART_DOCUMENT, 63, 126, 252, 213, ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, 35, 70, ShapeTypes.FLOW_CHART_PREPARATION, 53, 106, 212, ShapeTypes.FLOW_CHART_DECISION, 39, 78, ShapeTypes.FLOW_CHART_MAGNETIC_DRUM, 21, 42, 84, ShapeTypes.ACTION_BUTTON_BEGINNING, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 217, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, 19, 38, 76, ShapeTypes.FLOW_CHART_OFFLINE_STORAGE, 29, 58, 116, 232, 253, 215, ShapeTypes.PLUS, 43, 86, ShapeTypes.ACTION_BUTTON_MOVIE, 117, 234, 249, 223, ShapeTypes.FLOW_CHART_OR, 11, 22, 44, 88, ShapeTypes.MATH_PLUS, 77, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 25, 50, 100, 200, 189, 87, ShapeTypes.GEAR_9, 113, Jpeg.M_APP2, UnknownRecord.BITMAP_00E9, 255, 211, ShapeTypes.FLOW_CHART_TERMINATOR, 59, 118, 236, 245, 199, ShapeTypes.ACTION_BUTTON_HELP, 107, 214, 129, 47, 94, 188, 85, ShapeTypes.ACTION_BUTTON_DOCUMENT, 121, 242, 201, 191, 83, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS, 97, 194, ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.VERTICAL_SCROLL, TIFFConstants.TIFFTAG_SUBFILETYPE, 209, ShapeTypes.FLOW_CHART_CONNECTOR, 51, 102, 204, ShapeTypes.MATH_NOT_EQUAL, 71, ShapeTypes.FLOW_CHART_MANUAL_OPERATION, 49, 98, 196, ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, 103, ComposerKt.referenceKey, ShapeTypes.MATH_MINUS, 79, ShapeTypes.FLOW_CHART_DELAY, 17, 34, 68, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 61, 122, 244, 197, ShapeTypes.ACTION_BUTTON_END, 99, 198, ShapeTypes.ACTION_BUTTON_BLANK, 111, 222, ShapeTypes.FLOW_CHART_PUNCHED_TAPE, 15, 30, 60, 120, 240, 205, ShapeTypes.SQUARE_TABS, 67, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 33, 66, ShapeTypes.FLOW_CHART_PROCESS, 37, 74, 148, 5, 10, 20, 40, 80, 160, 109, 218, 153, 31, 62, 124, 248, 221, ShapeTypes.FLOW_CHART_MERGE, 3, 6, 12, 24, 48, 96, 192, ShapeTypes.GEAR_6, 119, Jpeg.M_APPE, 241, ComposerKt.reuseKey, ShapeTypes.MATH_DIVIDE, 75, 150, 1};
        private static final int[] poly5 = {228, 48, 15, 111, 62};
        private static final int[] poly7 = {23, 68, 144, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 240, 92, TIFFConstants.TIFFTAG_SUBFILETYPE};
        private static final int[] poly10 = {28, 24, ShapeTypes.CHART_X, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS, 223, 248, 116, 255, 110, 61};
        private static final int[] poly11 = {ShapeTypes.FUNNEL, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 205, 12, 194, ShapeTypes.ACTION_BUTTON_BEGINNING, 39, 245, 60, 97, 120};
        private static final int[] poly12 = {41, 153, ShapeTypes.FLOW_CHART_DELAY, 91, 61, 42, ShapeTypes.FLOW_CHART_MANUAL_OPERATION, 213, 97, ShapeTypes.MATH_MULTIPLY, 100, 242};
        private static final int[] poly14 = {ShapeTypes.FLOW_CHART_MAGNETIC_DRUM, 97, 192, 252, 95, 9, ShapeTypes.FLOW_CHART_DISPLAY, 119, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 45, 18, ShapeTypes.CHART_STAR, 83, ShapeTypes.CHART_X};
        private static final int[] poly18 = {83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, TIFFConstants.TIFFTAG_SUBFILETYPE, 225, 48, 90, 188};
        private static final int[] poly20 = {15, 195, 244, 9, UnknownRecord.BITMAP_00E9, 71, ShapeTypes.ACTION_BUTTON_BEGINNING, 2, 188, 160, 153, ShapeTypes.FLOW_CHART_PUNCHED_TAPE, 253, 79, 108, 82, 27, ShapeTypes.GEAR_9, ShapeTypes.CHART_STAR, ShapeTypes.ACTION_BUTTON_MOVIE};
        private static final int[] poly24 = {52, 190, 88, 205, 109, 39, ShapeTypes.MATH_PLUS, 21, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 197, 251, 223, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 21, 5, ShapeTypes.ACTION_BUTTON_MOVIE, TIFFConstants.TIFFTAG_SUBFILETYPE, 124, 12, ShapeTypes.MATH_NOT_EQUAL, ShapeTypes.PLAQUE_TABS, 96, 50, 193};
        private static final int[] poly28 = {211, 231, 43, 97, 71, 96, 103, ShapeTypes.GEAR_9, 37, ShapeTypes.FLOW_CHART_MERGE, ShapeTypes.ACTION_BUTTON_DOCUMENT, 53, 75, 34, 249, 121, 17, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 110, 213, ShapeTypes.FLOW_CHART_MANUAL_INPUT, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 120, ShapeTypes.FLOW_CHART_MERGE, UnknownRecord.BITMAP_00E9, ShapeTypes.ACTION_BUTTON_BEGINNING, 93, 255};
        private static final int[] poly36 = {245, ShapeTypes.VERTICAL_SCROLL, 242, 218, ShapeTypes.DOUBLE_WAVE, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ShapeTypes.ACTION_BUTTON_HOME, ShapeTypes.MATH_NOT_EQUAL, 102, 120, 84, ShapeTypes.MATH_DIVIDE, 220, 251, 80, ShapeTypes.CORNER_TABS, 229, 18, 2, 4, 68, 33, 101, ShapeTypes.FLOW_CHART_DOCUMENT, 95, 119, 115, 44, ShapeTypes.FUNNEL, ShapeTypes.PLAQUE_TABS, 59, 25, 225, 98, 81, 112};
        private static final int[] poly42 = {77, 193, ShapeTypes.FLOW_CHART_DOCUMENT, 31, 19, 38, 22, 153, MetaDo.META_CREATEPALETTE, 105, 122, 2, 245, ShapeTypes.FLOW_CHART_DECISION, 242, 8, ShapeTypes.FUNNEL, 95, 100, 9, ShapeTypes.ACTION_BUTTON_END, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, ShapeTypes.MATH_MINUS, Jpeg.M_APP2, 5, 9, 5};
        private static final int[] poly48 = {245, ShapeTypes.FLOW_CHART_PROCESS, ShapeTypes.ACTION_BUTTON_MOVIE, 223, 96, 32, 117, 22, Jpeg.M_APPE, ShapeTypes.FLOW_CHART_DECISION, Jpeg.M_APPE, 231, 205, 188, Jpeg.M_APPD, 87, 191, 106, 16, ShapeTypes.FLOW_CHART_OR, 118, 23, 37, 90, ShapeTypes.ACTION_BUTTON_DOCUMENT, 205, ShapeTypes.PLUS, 88, 120, 100, 66, ShapeTypes.FLOW_CHART_MULTIDOCUMENT, ShapeTypes.CHART_STAR, 240, 82, 44, ShapeTypes.MATH_PLUS, 87, ShapeTypes.CHART_PLUS, ShapeTypes.FLOW_CHART_OR, 160, ShapeTypes.FUNNEL, 69, 213, 92, 253, 225, 19};
        private static final int[] poly56 = {ShapeTypes.FUNNEL, 9, 223, Jpeg.M_APPE, 12, 17, 220, 208, 100, 29, ShapeTypes.FUNNEL, ShapeTypes.ACTION_BUTTON_DOCUMENT, 230, 192, 215, 235, 150, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, 36, 223, 38, 200, ShapeTypes.FLOW_CHART_PROCESS, 54, 228, ShapeTypes.FLOW_CHART_SUMMING_JUNCTION, 218, 234, 117, 203, 29, 232, 144, Jpeg.M_APPE, 22, 150, 201, 117, 62, ComposerKt.reuseKey, 164, 13, ShapeTypes.FLOW_CHART_DOCUMENT, 245, ShapeTypes.VERTICAL_SCROLL, 67, MetaDo.META_CREATEPALETTE, 28, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 43, 203, 107, UnknownRecord.BITMAP_00E9, 53, ShapeTypes.FLOW_CHART_CONNECTOR, 46};
        private static final int[] poly62 = {242, 93, ShapeTypes.ACTION_BUTTON_RETURN, 50, 144, 210, 39, 118, 202, 188, 201, 189, ShapeTypes.FLOW_CHART_CONNECTOR, 108, 196, 37, ShapeTypes.CHART_X, 112, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, ShapeTypes.CHART_X, 221, ShapeTypes.FUNNEL, 64, 114, 71, ShapeTypes.ACTION_BUTTON_BLANK, 44, ShapeTypes.FLOW_CHART_OR, 6, 27, 218, 51, 63, 87, 10, 40, ShapeTypes.DOUBLE_WAVE, 188, 17, ShapeTypes.ACTION_BUTTON_HELP, 31, ShapeTypes.MATH_PLUS, ShapeTypes.ACTION_BUTTON_DOCUMENT, 4, 107, 232, 7, 94, ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS, 224, 124, 86, 47, 11, 204};
        private static final int[] poly68 = {220, 228, ShapeTypes.GEAR_6, 89, 251, ShapeTypes.FLOW_CHART_SORT, ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, 56, 89, 33, ShapeTypes.FLOW_CHART_OR, 244, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 36, 73, ShapeTypes.VERTICAL_SCROLL, 213, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 248, ShapeTypes.MATH_EQUAL, 234, 197, ShapeTypes.FLOW_CHART_DELAY, ShapeTypes.MATH_MINUS, 68, 122, 93, 213, 15, 160, 227, 236, 66, ShapeTypes.FLOW_CHART_TERMINATOR, 153, ShapeTypes.CHART_X, 202, ShapeTypes.ACTION_BUTTON_END, ShapeTypes.MATH_DIVIDE, 25, 220, 232, 96, 210, 231, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 223, UnknownRecord.PHONETICPR_00EF, ShapeTypes.MATH_NOT_EQUAL, 241, 59, 52, ShapeTypes.ACTION_BUTTON_MOVIE, 25, 49, 232, 211, 189, 64, 54, 108, 153, ShapeTypes.FLOW_CHART_PROCESS, 63, 96, 103, 82, ShapeTypes.CHART_STAR};

        public static void generateECC(byte[] bArr, int i, int i2, int i3) {
            int i4 = (i + 2) / i2;
            byte[] bArr2 = new byte[256];
            byte[] bArr3 = new byte[256];
            int[] poly = getPoly(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5;
                int i7 = 0;
                while (i6 < i) {
                    bArr2[i7] = bArr[i6];
                    i6 += i4;
                    i7++;
                }
                reedSolomonBlock(bArr2, i7, bArr3, i3, poly);
                int i8 = i5;
                int i9 = 0;
                while (i8 < i3 * i4) {
                    bArr[i + i8] = bArr3[i9];
                    i8 += i4;
                    i9++;
                }
            }
        }

        private static int[] getPoly(int i) {
            switch (i) {
                case 5:
                    return poly5;
                case 7:
                    return poly7;
                case 10:
                    return poly10;
                case 11:
                    return poly11;
                case 12:
                    return poly12;
                case 14:
                    return poly14;
                case 18:
                    return poly18;
                case 20:
                    return poly20;
                case 24:
                    return poly24;
                case 28:
                    return poly28;
                case 36:
                    return poly36;
                case 42:
                    return poly42;
                case 48:
                    return poly48;
                case 56:
                    return poly56;
                case 62:
                    return poly62;
                case 68:
                    return poly68;
                default:
                    return null;
            }
        }

        private static void reedSolomonBlock(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr) {
            byte b;
            for (int i3 = 0; i3 <= i2; i3++) {
                bArr2[i3] = 0;
            }
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = (bArr2[0] ^ bArr[i4]) & 255;
                int i6 = 0;
                while (i6 < i2) {
                    int i7 = i6 + 1;
                    byte b2 = bArr2[i7];
                    if (i5 == 0) {
                        b = 0;
                    } else {
                        int[] iArr2 = alog;
                        int[] iArr3 = log;
                        b = (byte) iArr2[(iArr3[i5] + iArr3[iArr[(i2 - i6) - 1]]) % 255];
                    }
                    bArr2[i6] = (byte) (b2 ^ b);
                    i6 = i7;
                }
            }
        }
    }

    private static int C40OrTextEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        String str;
        String str2;
        int i5;
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            bArr2[i3] = -26;
        } else {
            bArr2[i3] = -17;
        }
        if (z) {
            str = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            str2 = "`abcdefghijklmnopqrstuvwxyz{|}~\u007f";
        } else {
            str = " 0123456789abcdefghijklmnopqrstuvwxyz";
            str2 = "`ABCDEFGHIJKLMNOPQRSTUVWXYZ{|}~\u007f";
        }
        int[] iArr = new int[(i2 * 4) + 10];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i2) {
            if (i7 % 3 == 0) {
                i8 = i6;
                i9 = i7;
            }
            int i10 = i6 + 1;
            int i11 = bArr[i + i6] & UnsignedBytes.MAX_VALUE;
            if (i11 > 127) {
                i11 -= 128;
                int i12 = i7 + 1;
                iArr[i7] = 1;
                i7 += 2;
                iArr[i12] = 30;
            }
            char c = (char) i11;
            int iIndexOf = str.indexOf(c);
            if (iIndexOf >= 0) {
                iArr[i7] = iIndexOf + 3;
                i7++;
            } else if (i11 < 32) {
                int i13 = i7 + 1;
                iArr[i7] = 0;
                i7 += 2;
                iArr[i13] = i11;
            } else {
                int iIndexOf2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_".indexOf(c);
                if (iIndexOf2 >= 0) {
                    int i14 = i7 + 1;
                    iArr[i7] = 1;
                    i7 += 2;
                    iArr[i14] = iIndexOf2;
                } else {
                    int iIndexOf3 = str2.indexOf(c);
                    if (iIndexOf3 >= 0) {
                        int i15 = i7 + 1;
                        iArr[i7] = 2;
                        i7 += 2;
                        iArr[i15] = iIndexOf3;
                    }
                }
            }
            i6 = i10;
        }
        if (i7 % 3 != 0) {
            i5 = i8;
            i7 = i9;
        } else {
            i5 = i6;
        }
        if ((i7 / 3) * 2 > i4 - 2) {
            return -1;
        }
        int i16 = 1;
        for (int i17 = 0; i17 < i7; i17 += 3) {
            int i18 = (iArr[i17] * 1600) + (iArr[i17 + 1] * 40) + iArr[i17 + 2] + 1;
            int i19 = i16 + 1;
            bArr2[i3 + i16] = (byte) (i18 / 256);
            i16 += 2;
            bArr2[i3 + i19] = (byte) i18;
        }
        int i20 = i16 + 1;
        bArr2[i16] = -2;
        int iAsciiEncodation = asciiEncodation(bArr, i5, i2 - i5, bArr2, i20, i4 - i20);
        return iAsciiEncodation < 0 ? iAsciiEncodation : i20 + iAsciiEncodation;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[DONT_INVERT, PHI: r9 r14
      0x00ac: PHI (r9v16 int) = (r9v15 int), (r9v20 int) binds: [B:38:0x009c, B:41:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x00ac: PHI (r14v1 int) = (r14v0 int), (r14v3 int) binds: [B:38:0x009c, B:41:0x00a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00af  */
    /* JADX WARN: Code duplicated, block: B:86:0x00bd A[EDGE_INSN: B:86:0x00bd->B:46:0x00bd BREAK  A[LOOP:0: B:6:0x0011->B:45:0x00b8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00bd A[EDGE_INSN: B:87:0x00bd->B:46:0x00bd BREAK  A[LOOP:0: B:6:0x0011->B:45:0x00b8], SYNTHETIC] */
    private static int EdifactEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (i2 == 0) {
            return 0;
        }
        int i8 = 0;
        boolean z = true;
        int i9 = 0;
        int i10 = 18;
        int i11 = 0;
        while (i8 < i2) {
            int i12 = bArr[i8 + i];
            int i13 = i12 & 255;
            int i14 = i12 & 224;
            if ((i14 == 64 || i14 == 32) && i13 != 95) {
                if (z) {
                    int i15 = i11 + 1;
                    if (i15 > i4) {
                        break;
                    }
                    bArr2[i3 + i11] = -16;
                    i11 = i15;
                    z = false;
                }
                i9 |= (i12 & 63) << i10;
                if (i10 != 0) {
                    i10 -= 6;
                } else {
                    if (i11 + 3 > i4) {
                        break;
                    }
                    bArr2[i3 + i11] = (byte) (i9 >> 16);
                    int i16 = i11 + 2;
                    bArr2[i3 + i11 + 1] = (byte) (i9 >> 8);
                    i11 += 3;
                    bArr2[i3 + i16] = (byte) i9;
                    i9 = 0;
                    i10 = 18;
                }
                i8++;
            } else if (!z) {
                i9 |= 31 << i10;
                if ((i11 + 3) - (i10 / 8) > i4) {
                    break;
                }
                int i17 = i11 + 1;
                bArr2[i3 + i11] = (byte) (i9 >> 16);
                if (i10 <= 12) {
                    bArr2[i3 + i17] = (byte) (i9 >> 8);
                    i17 = i11 + 2;
                }
                if (i10 <= 6) {
                    bArr2[i3 + i17] = (byte) i9;
                    i11 = i17 + 1;
                } else {
                    i11 = i17;
                }
                z = true;
                i9 = 0;
                i10 = 18;
                if (i13 <= 127) {
                    if (i11 >= i4) {
                        break;
                    }
                    bArr2[i3 + i11] = (byte) (i13 + 1);
                    i11++;
                    i8++;
                } else {
                    if (i11 >= i4) {
                        break;
                    }
                    bArr2[i3 + i11] = -21;
                    i13 -= 128;
                    i11++;
                    if (i11 >= i4) {
                        break;
                        break;
                    }
                    bArr2[i3 + i11] = (byte) (i13 + 1);
                    i11++;
                    i8++;
                }
            } else if (i13 <= 127) {
                if (i11 >= i4) {
                    break;
                    break;
                }
                bArr2[i3 + i11] = (byte) (i13 + 1);
                i11++;
                i8++;
            } else {
                if (i11 >= i4) {
                    break;
                    break;
                }
                bArr2[i3 + i11] = -21;
                i13 -= 128;
                i11++;
                if (i11 >= i4) {
                    break;
                    break;
                }
                bArr2[i3 + i11] = (byte) (i13 + 1);
                i11++;
                i8++;
            }
        }
        if (i8 != i2) {
            return -1;
        }
        int i18 = 0;
        while (true) {
            DmParams[] dmParamsArr = dmSizes;
            if (i18 >= dmParamsArr.length) {
                i5 = Integer.MAX_VALUE;
                break;
            }
            i5 = dmParamsArr[i18].dataSize;
            if (i5 >= i3 + i11 + (3 - (i10 / 6))) {
                break;
            }
            i18++;
        }
        if ((i5 - i3) - i11 <= 2 && i10 >= 6) {
            if (i10 <= 12) {
                byte b = (byte) ((i9 >> 18) & 63);
                if ((b & 32) == 0) {
                    b = (byte) (b | 64);
                }
                bArr2[i3 + i11] = (byte) (b + 1);
                i11++;
            }
            if (i10 > 6) {
                return i11;
            }
            byte b2 = (byte) ((i9 >> 12) & 63);
            if ((b2 & 32) == 0) {
                b2 = (byte) (b2 | 64);
            }
            i7 = i11 + 1;
            bArr2[i3 + i11] = (byte) (b2 + 1);
        } else {
            if (z) {
                return i11;
            }
            int i19 = (31 << i10) | i9;
            if ((i11 + 3) - (i10 / 8) > i4) {
                return -1;
            }
            int i20 = i11 + 1;
            bArr2[i3 + i11] = (byte) (i19 >> 16);
            if (i10 <= 12) {
                i6 = i11 + 2;
                bArr2[i3 + i20] = (byte) (i19 >> 8);
            } else {
                i6 = i20;
            }
            if (i10 > 6) {
                return i6;
            }
            i7 = i6 + 1;
            bArr2[i3 + i6] = (byte) i19;
        }
        return i7;
    }

    private static int X12Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = 0;
        if (i2 == 0) {
            return 0;
        }
        byte[] bArr3 = new byte[i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i2) {
                break;
            }
            int iIndexOf = x12.indexOf((char) bArr[i6 + i]);
            if (iIndexOf >= 0) {
                bArr3[i6] = (byte) iIndexOf;
                i7++;
            } else {
                bArr3[i6] = 100;
                if (i7 >= 6) {
                    i7 -= (i7 / 3) * 3;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    bArr3[(i6 - i8) - 1] = 100;
                }
                i7 = 0;
            }
            i6++;
        }
        if (i7 >= 6) {
            i7 -= (i7 / 3) * 3;
        }
        for (int i9 = 0; i9 < i7; i9++) {
            bArr3[(i6 - i9) - 1] = 100;
        }
        int i10 = 0;
        while (i5 < i2) {
            byte b = bArr3[i5];
            if (i10 >= i4) {
                break;
            }
            if (b < 40) {
                if (i5 == 0 || (i5 > 0 && bArr3[i5 - 1] > 40)) {
                    bArr2[i10 + i3] = -18;
                    i10++;
                }
                if (i10 + 2 > i4) {
                    break;
                }
                int i11 = (bArr3[i5] * 1600) + (bArr3[i5 + 1] * 40);
                i5 += 2;
                int i12 = i11 + bArr3[i5] + 1;
                int i13 = i10 + 1;
                bArr2[i3 + i10] = (byte) (i12 / 256);
                i10 += 2;
                bArr2[i13 + i3] = (byte) i12;
                i5++;
            } else {
                if (i5 > 0 && bArr3[i5 - 1] < 40) {
                    bArr2[i10 + i3] = -2;
                    i10++;
                }
                int i14 = bArr[i5 + i] & UnsignedBytes.MAX_VALUE;
                if (i14 > 127) {
                    bArr2[i10 + i3] = -21;
                    i14 -= 128;
                    i10++;
                }
                if (i10 >= i4) {
                    break;
                }
                bArr2[i10 + i3] = (byte) (i14 + 1);
                i10++;
                i5++;
            }
        }
        byte b2 = i2 > 0 ? bArr3[i2 - 1] : (byte) 100;
        if (i5 != i2) {
            return -1;
        }
        if (b2 < 40 && i10 >= i4) {
            return -1;
        }
        if (b2 >= 40) {
            return i10;
        }
        int i15 = i10 + 1;
        bArr2[i3 + i10] = -2;
        return i15;
    }

    private static int asciiEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i2 + i;
        int i6 = i4 + i3;
        int i7 = i3;
        while (i < i5) {
            if (i7 >= i6) {
                return -1;
            }
            int i8 = i + 1;
            int i9 = bArr[i] & UnsignedBytes.MAX_VALUE;
            if (isDigit(i9) && i8 < i5 && isDigit(bArr[i8] & UnsignedBytes.MAX_VALUE)) {
                i += 2;
                bArr2[i7] = (byte) (((i9 - 48) * 10) + (bArr[i8] & UnsignedBytes.MAX_VALUE) + 82);
                i7++;
            } else {
                if (i9 > 127) {
                    int i10 = i7 + 1;
                    if (i10 >= i6) {
                        return -1;
                    }
                    bArr2[i7] = -21;
                    i7 += 2;
                    bArr2[i10] = (byte) (i9 - 127);
                } else {
                    bArr2[i7] = (byte) (i9 + 1);
                    i7++;
                }
                i = i8;
            }
        }
        return i7 - i3;
    }

    private static int b256Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 250 && i2 + 2 > i4) {
            return -1;
        }
        if (i2 >= 250 && i2 + 3 > i4) {
            return -1;
        }
        bArr2[i3] = -25;
        if (i2 < 250) {
            bArr2[i3 + 1] = (byte) i2;
            i5 = 2;
        } else {
            bArr2[i3 + 1] = (byte) ((i2 / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249);
            bArr2[i3 + 2] = (byte) (i2 % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            i5 = 3;
        }
        System.arraycopy(bArr, i, bArr2, i5 + i3, i2);
        int i6 = i5 + i2 + i3;
        int i7 = i3 + 1;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = (bArr2[i7] & 255) + ((i8 * ShapeTypes.FLOW_CHART_SORT) % 255) + 1;
            if (i9 > 255) {
                i9 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr2[i7] = (byte) i9;
            i7 = i8;
        }
        return i6 - i3;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    private void draw(byte[] bArr, int i, DmParams dmParams) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ((dmParams.width + (this.ws * 2)) + 7) / 8;
        Arrays.fill(this.image, (byte) 0);
        int i8 = this.ws;
        while (true) {
            int i9 = dmParams.height;
            i2 = this.ws;
            if (i8 >= i9 + i2) {
                break;
            }
            while (i2 < dmParams.width + this.ws) {
                setBit(i2, i8, i7);
                i2 += 2;
            }
            i8 += dmParams.heightSection;
        }
        int i10 = dmParams.heightSection - 1;
        while (true) {
            i10 += i2;
            int i11 = dmParams.height;
            i3 = this.ws;
            if (i10 >= i11 + i3) {
                break;
            }
            while (i3 < dmParams.width + this.ws) {
                setBit(i3, i10, i7);
                i3++;
            }
            i2 = dmParams.heightSection;
        }
        while (true) {
            int i12 = dmParams.width;
            i4 = this.ws;
            if (i3 >= i12 + i4) {
                break;
            }
            while (i4 < dmParams.height + this.ws) {
                setBit(i3, i4, i7);
                i4++;
            }
            i3 += dmParams.widthSection;
        }
        int i13 = dmParams.widthSection - 1;
        while (true) {
            i13 += i4;
            int i14 = dmParams.width;
            int i15 = this.ws;
            if (i13 >= i14 + i15) {
                break;
            }
            for (int i16 = i15 + 1; i16 < dmParams.height + this.ws; i16 += 2) {
                setBit(i13, i16, i7);
            }
            i4 = dmParams.widthSection;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < dmParams.height) {
            int i19 = 1;
            while (true) {
                i5 = dmParams.heightSection;
                if (i19 < i5 - 1) {
                    int i20 = 0;
                    while (i20 < dmParams.width) {
                        int i21 = 1;
                        while (true) {
                            i6 = dmParams.widthSection;
                            if (i21 < i6 - 1) {
                                int i22 = i18 + 1;
                                short s = this.place[i18];
                                if (s == 1) {
                                    int i23 = this.ws;
                                    setBit(i21 + i20 + i23, i19 + i17 + i23, i7);
                                } else if (s > 1) {
                                    if (((128 >> (s % 8)) & bArr[(s / 8) - 1] & UnsignedBytes.MAX_VALUE) != 0) {
                                        int i24 = this.ws;
                                        setBit(i21 + i20 + i24, i19 + i17 + i24, i7);
                                    }
                                }
                                i21++;
                                i18 = i22;
                            }
                        }
                        i20 += i6;
                    }
                    i19++;
                }
            }
            i17 += i5;
        }
    }

    private static int getEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, boolean z) {
        int[] iArr = new int[6];
        if (i4 < 0) {
            return -1;
        }
        int i6 = i5 & 7;
        if (i6 != 0) {
            switch (i6) {
                case 1:
                    return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
                case 2:
                    return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
                case 3:
                    return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
                case 4:
                    return b256Encodation(bArr, i, i2, bArr2, i3, i4);
                case 5:
                    return X12Encodation(bArr, i, i2, bArr2, i3, i4);
                case 6:
                    return EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
                case 7:
                    if (i2 > i4) {
                        return -1;
                    }
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    return i2;
                default:
                    return -1;
            }
        }
        int iAsciiEncodation = asciiEncodation(bArr, i, i2, bArr2, i3, i4);
        iArr[0] = iAsciiEncodation;
        if (z && iAsciiEncodation >= 0) {
            return iAsciiEncodation;
        }
        int iC40OrTextEncodation = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
        iArr[1] = iC40OrTextEncodation;
        if (z && iC40OrTextEncodation >= 0) {
            return iC40OrTextEncodation;
        }
        int iC40OrTextEncodation2 = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
        iArr[2] = iC40OrTextEncodation2;
        if (z && iC40OrTextEncodation2 >= 0) {
            return iC40OrTextEncodation2;
        }
        int iB256Encodation = b256Encodation(bArr, i, i2, bArr2, i3, i4);
        iArr[3] = iB256Encodation;
        if (z && iB256Encodation >= 0) {
            return iB256Encodation;
        }
        int iX12Encodation = X12Encodation(bArr, i, i2, bArr2, i3, i4);
        iArr[4] = iX12Encodation;
        if (z && iX12Encodation >= 0) {
            return iX12Encodation;
        }
        int iEdifactEncodation = EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
        iArr[5] = iEdifactEncodation;
        if (z && iEdifactEncodation >= 0) {
            return iEdifactEncodation;
        }
        if (iArr[0] < 0 && iArr[1] < 0 && iArr[2] < 0 && iArr[3] < 0 && iArr[4] < 0 && iEdifactEncodation < 0) {
            return -1;
        }
        int i7 = 99999;
        int i8 = 0;
        for (int i9 = 0; i9 < 6; i9++) {
            int i10 = iArr[i9];
            if (i10 >= 0 && i10 < i7) {
                i7 = i10;
                i8 = i9;
            }
        }
        if (i8 == 0) {
            return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
        }
        if (i8 == 1) {
            return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
        }
        if (i8 == 2) {
            return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
        }
        if (i8 == 3) {
            return b256Encodation(bArr, i, i2, bArr2, i3, i4);
        }
        return i8 == 4 ? X12Encodation(bArr, i, i2, bArr2, i3, i4) : i7;
    }

    private static int getNumber(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + 1;
            int i6 = bArr[i] & UnsignedBytes.MAX_VALUE;
            if (i6 < 48 || i6 > 57) {
                return -1;
            }
            i4 = ((i4 * 10) + i6) - 48;
            i3++;
            i = i5;
        }
        return i4;
    }

    private static boolean isDigit(int i) {
        return i >= 48 && i <= 57;
    }

    private static void makePadding(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        int i3 = i + 1;
        bArr[i] = -127;
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            int i4 = i3 + 1;
            int i5 = (i4 * ShapeTypes.FLOW_CHART_SORT) % 253;
            int i6 = i5 + ShapeTypes.DOUBLE_WAVE;
            if (i6 > 254) {
                i6 = i5 - 124;
            }
            bArr[i3] = (byte) i6;
            i3 = i4;
        }
    }

    private int processExtensions(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        byte b;
        int number;
        int number2;
        int number3;
        int number4;
        int i4 = 0;
        if ((this.options & 32) == 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (i4 < i2 && i5 <= 20) {
            int i7 = i4 + 1;
            int i8 = bArr[i + i4] & UnsignedBytes.MAX_VALUE;
            i5++;
            if (i8 == 46) {
                this.extOut = i7;
                return i6;
            }
            if (i8 != 109) {
                if (i8 != 112) {
                    if (i8 != 115) {
                        if (i8 != 101) {
                            if (i8 == 102) {
                                if (i5 != 1 && (i5 != 2 || ((b = bArr[i]) != 115 && b != 109))) {
                                    return -1;
                                }
                                i3 = i6 + 1;
                                bArr2[i6] = -24;
                            }
                            i4 = i7;
                        } else {
                            i4 += 7;
                            if (i4 > i2 || (number = getNumber(bArr, i + i7, 6)) < 0) {
                                return -1;
                            }
                            int i9 = i6 + 1;
                            bArr2[i6] = -15;
                            if (number < 127) {
                                i6 += 2;
                                bArr2[i9] = (byte) (number + 1);
                            } else if (number < 16383) {
                                int i10 = i6 + 2;
                                int i11 = number - 127;
                                bArr2[i9] = (byte) ((i11 / TIFFConstants.TIFFTAG_SUBFILETYPE) + 128);
                                i6 += 3;
                                bArr2[i10] = (byte) ((i11 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                            } else {
                                int i12 = number - 16383;
                                bArr2[i9] = (byte) ((i12 / 64516) + 192);
                                int i13 = i6 + 3;
                                bArr2[i6 + 2] = (byte) (((i12 / TIFFConstants.TIFFTAG_SUBFILETYPE) % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                                i6 += 4;
                                bArr2[i13] = (byte) ((i12 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                            }
                        }
                    } else {
                        if (i5 != 1 || i4 + 10 > i2 || (number2 = getNumber(bArr, i + i7, 2)) <= 0 || number2 > 16 || (number3 = getNumber(bArr, i + i4 + 3, 2)) <= 1 || number3 > 16 || (number4 = getNumber(bArr, i + i4 + 5, 5)) < 0 || number2 >= 64516) {
                            return -1;
                        }
                        i4 += 10;
                        bArr2[i6] = -23;
                        bArr2[i6 + 1] = (byte) (((number2 - 1) << 4) | (17 - number3));
                        int i14 = i6 + 3;
                        bArr2[i6 + 2] = (byte) ((number4 / TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                        i6 += 4;
                        bArr2[i14] = (byte) ((number4 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                    }
                } else {
                    if (i5 != 1) {
                        return -1;
                    }
                    i3 = i6 + 1;
                    bArr2[i6] = -22;
                }
                i6 = i3;
                i4 = i7;
            } else {
                if (i5 != 1 || (i4 = i4 + 2) > i2) {
                    return -1;
                }
                int i15 = bArr[i + i7] & UnsignedBytes.MAX_VALUE;
                if (i15 != 53 && i15 != 53) {
                    return -1;
                }
                int i16 = i6 + 1;
                bArr2[i6] = -22;
                i6 += 2;
                bArr2[i16] = (byte) (i15 == 53 ? 236 : Jpeg.M_APPD);
            }
        }
        return -1;
    }

    private void setBit(int i, int i2, int i3) {
        byte[] bArr = this.image;
        int i4 = (i2 * i3) + (i / 8);
        bArr[i4] = (byte) (((byte) (128 >> (i & 7))) | bArr[i4]);
    }

    public Image createImage() {
        byte[] bArr = this.image;
        if (bArr == null) {
            return null;
        }
        int i = this.width;
        int i2 = this.ws;
        byte[] bArrCompress = CCITTG4Encoder.compress(bArr, i + (i2 * 2), this.height + (i2 * 2));
        int i3 = this.width;
        int i4 = this.ws;
        return Image.getInstance(i3 + (i4 * 2), this.height + (i4 * 2), false, 256, 0, bArrCompress, null);
    }

    public int generate(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("iso-8859-1");
        return generate(bytes, 0, bytes.length);
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getImage() {
        return this.image;
    }

    public int getOptions() {
        return this.options;
    }

    public int getWidth() {
        return this.width;
    }

    public int getWs() {
        return this.ws;
    }

    public void placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, float f, float f2) {
        int i = this.width;
        int i2 = this.ws;
        int i3 = i + (i2 * 2);
        int i4 = this.height + (i2 * 2);
        int i5 = (i3 + 7) / 8;
        pdfContentByte.setColorFill(baseColor);
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i6 * i5;
            for (int i8 = 0; i8 < i3; i8++) {
                if ((((this.image[(i8 / 8) + i7] & UnsignedBytes.MAX_VALUE) << (i8 % 8)) & 128) != 0) {
                    pdfContentByte.rectangle(i8 * f2, ((i4 - i6) - 1) * f, f2, f);
                }
            }
        }
        pdfContentByte.fill();
    }

    public void setForceSquareSize(boolean z) {
        this.forceSquareSize = z;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setWs(int i) {
        this.ws = i;
    }

    public int generate(byte[] bArr, int i, int i2) {
        int i3;
        DmParams[] dmParamsArr;
        DmParams dmParams;
        DmParams[] dmParamsArr2;
        byte[] bArr2 = new byte[2500];
        this.extOut = 0;
        int iProcessExtensions = processExtensions(bArr, i, i2, bArr2);
        if (iProcessExtensions < 0) {
            return 5;
        }
        if (this.height != 0 && this.width != 0) {
            int i4 = 0;
            while (true) {
                dmParamsArr2 = dmSizes;
                if (i4 >= dmParamsArr2.length) {
                    break;
                }
                int i5 = this.height;
                DmParams dmParams2 = dmParamsArr2[i4];
                if (i5 == dmParams2.height && this.width == dmParams2.width) {
                    break;
                }
                i4++;
            }
            if (i4 == dmParamsArr2.length) {
                return 3;
            }
            dmParams = dmParamsArr2[i4];
            int i6 = this.extOut;
            int encodation = getEncodation(bArr, i + i6, i2 - i6, bArr2, iProcessExtensions, dmParams.dataSize - iProcessExtensions, this.options, true);
            if (encodation < 0) {
                return 1;
            }
            i3 = encodation + iProcessExtensions;
        } else {
            DmParams[] dmParamsArr3 = dmSizes;
            DmParams dmParams3 = dmParamsArr3[dmParamsArr3.length - 1];
            int i7 = this.extOut;
            int encodation2 = getEncodation(bArr, i + i7, i2 - i7, bArr2, iProcessExtensions, dmParams3.dataSize - iProcessExtensions, this.options, false);
            if (encodation2 < 0) {
                return 1;
            }
            i3 = encodation2 + iProcessExtensions;
            int i8 = 0;
            while (true) {
                dmParamsArr = dmSizes;
                if (i8 >= dmParamsArr.length) {
                    break;
                }
                DmParams dmParams4 = dmParamsArr[i8];
                if (dmParams4.dataSize >= i3 && (!this.forceSquareSize || dmParams4.width == dmParams4.height)) {
                    break;
                }
                i8++;
            }
            dmParams = dmParamsArr[i8];
            this.height = dmParams.height;
            this.width = dmParams.width;
        }
        if ((this.options & 64) != 0) {
            return 0;
        }
        int i9 = dmParams.width;
        int i10 = this.ws;
        this.image = new byte[(((i9 + (i10 * 2)) + 7) / 8) * (dmParams.height + (i10 * 2))];
        makePadding(bArr2, i3, dmParams.dataSize - i3);
        int i11 = dmParams.height;
        int i12 = i11 - ((i11 / dmParams.heightSection) * 2);
        int i13 = dmParams.width;
        this.place = Placement.doPlacement(i12, i13 - ((i13 / dmParams.widthSection) * 2));
        int i14 = dmParams.dataSize;
        int i15 = dmParams.dataBlock;
        int i16 = dmParams.errorBlock;
        ReedSolomon.generateECC(bArr2, i14, i15, i16);
        draw(bArr2, (((i14 + 2) / i15) * i16) + i14, dmParams);
        return 0;
    }
}
