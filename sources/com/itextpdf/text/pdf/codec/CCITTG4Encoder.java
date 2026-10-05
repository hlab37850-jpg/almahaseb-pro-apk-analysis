package com.itextpdf.text.pdf.codec;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.material.internal.ViewUtils;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class CCITTG4Encoder {
    private static final int CODE = 1;
    private static final int EOL = 1;
    private static final int G3CODE_EOF = -3;
    private static final int G3CODE_EOL = -1;
    private static final int G3CODE_INCOMP = -4;
    private static final int G3CODE_INVALID = -2;
    private static final int LENGTH = 0;
    private static final int RUNLEN = 2;
    private int data;
    private byte[] dataBp;
    private int offsetData;
    private byte[] refline;
    private int rowbytes;
    private int rowpixels;
    private int sizeData;
    private static byte[] zeroruns = {8, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static byte[] oneruns = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8};
    private int bit = 8;
    private ByteBuffer outBuf = new ByteBuffer(1024);
    private int[][] TIFFFaxWhiteCodes = {new int[]{8, 53, 0}, new int[]{6, 7, 1}, new int[]{4, 7, 2}, new int[]{4, 8, 3}, new int[]{4, 11, 4}, new int[]{4, 12, 5}, new int[]{4, 14, 6}, new int[]{4, 15, 7}, new int[]{5, 19, 8}, new int[]{5, 20, 9}, new int[]{5, 7, 10}, new int[]{5, 8, 11}, new int[]{6, 8, 12}, new int[]{6, 3, 13}, new int[]{6, 52, 14}, new int[]{6, 53, 15}, new int[]{6, 42, 16}, new int[]{6, 43, 17}, new int[]{7, 39, 18}, new int[]{7, 12, 19}, new int[]{7, 8, 20}, new int[]{7, 23, 21}, new int[]{7, 3, 22}, new int[]{7, 4, 23}, new int[]{7, 40, 24}, new int[]{7, 43, 25}, new int[]{7, 19, 26}, new int[]{7, 36, 27}, new int[]{7, 24, 28}, new int[]{8, 2, 29}, new int[]{8, 3, 30}, new int[]{8, 26, 31}, new int[]{8, 27, 32}, new int[]{8, 18, 33}, new int[]{8, 19, 34}, new int[]{8, 20, 35}, new int[]{8, 21, 36}, new int[]{8, 22, 37}, new int[]{8, 23, 38}, new int[]{8, 40, 39}, new int[]{8, 41, 40}, new int[]{8, 42, 41}, new int[]{8, 43, 42}, new int[]{8, 44, 43}, new int[]{8, 45, 44}, new int[]{8, 4, 45}, new int[]{8, 5, 46}, new int[]{8, 10, 47}, new int[]{8, 11, 48}, new int[]{8, 82, 49}, new int[]{8, 83, 50}, new int[]{8, 84, 51}, new int[]{8, 85, 52}, new int[]{8, 36, 53}, new int[]{8, 37, 54}, new int[]{8, 88, 55}, new int[]{8, 89, 56}, new int[]{8, 90, 57}, new int[]{8, 91, 58}, new int[]{8, 74, 59}, new int[]{8, 75, 60}, new int[]{8, 50, 61}, new int[]{8, 51, 62}, new int[]{8, 52, 63}, new int[]{5, 27, 64}, new int[]{5, 18, 128}, new int[]{6, 23, 192}, new int[]{7, 55, 256}, new int[]{8, 54, TIFFConstants.TIFFTAG_COLORMAP}, new int[]{8, 55, 384}, new int[]{8, 100, 448}, new int[]{8, 101, 512}, new int[]{8, 104, 576}, new int[]{8, 103, 640}, new int[]{9, 204, TypedValues.TransitionType.TYPE_AUTO_TRANSITION}, new int[]{9, 205, ViewUtils.EDGE_TO_EDGE_FLAGS}, new int[]{9, 210, 832}, new int[]{9, 211, 896}, new int[]{9, 212, 960}, new int[]{9, 213, 1024}, new int[]{9, 214, 1088}, new int[]{9, 215, 1152}, new int[]{9, 216, 1216}, new int[]{9, 217, 1280}, new int[]{9, 218, 1344}, new int[]{9, 219, 1408}, new int[]{9, ShapeTypes.FLOW_CHART_OFFLINE_STORAGE, 1472}, new int[]{9, 153, BOFRecord.VERSION}, new int[]{9, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 1600}, new int[]{6, 24, 1664}, new int[]{9, ShapeTypes.FLOW_CHART_MAGNETIC_DISK, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.META_DIBBITBLT}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};
    private int[][] TIFFFaxBlackCodes = {new int[]{10, 55, 0}, new int[]{3, 2, 1}, new int[]{2, 3, 2}, new int[]{2, 2, 3}, new int[]{3, 3, 4}, new int[]{4, 3, 5}, new int[]{4, 2, 6}, new int[]{5, 3, 7}, new int[]{6, 5, 8}, new int[]{6, 4, 9}, new int[]{7, 4, 10}, new int[]{7, 5, 11}, new int[]{7, 7, 12}, new int[]{8, 4, 13}, new int[]{8, 7, 14}, new int[]{9, 24, 15}, new int[]{10, 23, 16}, new int[]{10, 24, 17}, new int[]{10, 8, 18}, new int[]{11, 103, 19}, new int[]{11, 104, 20}, new int[]{11, 108, 21}, new int[]{11, 55, 22}, new int[]{11, 40, 23}, new int[]{11, 23, 24}, new int[]{11, 24, 25}, new int[]{12, 202, 26}, new int[]{12, 203, 27}, new int[]{12, 204, 28}, new int[]{12, 205, 29}, new int[]{12, 104, 30}, new int[]{12, 105, 31}, new int[]{12, 106, 32}, new int[]{12, 107, 33}, new int[]{12, 210, 34}, new int[]{12, 211, 35}, new int[]{12, 212, 36}, new int[]{12, 213, 37}, new int[]{12, 214, 38}, new int[]{12, 215, 39}, new int[]{12, 108, 40}, new int[]{12, 109, 41}, new int[]{12, 218, 42}, new int[]{12, 219, 43}, new int[]{12, 84, 44}, new int[]{12, 85, 45}, new int[]{12, 86, 46}, new int[]{12, 87, 47}, new int[]{12, 100, 48}, new int[]{12, 101, 49}, new int[]{12, 82, 50}, new int[]{12, 83, 51}, new int[]{12, 36, 52}, new int[]{12, 55, 53}, new int[]{12, 56, 54}, new int[]{12, 39, 55}, new int[]{12, 40, 56}, new int[]{12, 88, 57}, new int[]{12, 89, 58}, new int[]{12, 43, 59}, new int[]{12, 44, 60}, new int[]{12, 90, 61}, new int[]{12, 102, 62}, new int[]{12, 103, 63}, new int[]{10, 15, 64}, new int[]{12, 200, 128}, new int[]{12, 201, 192}, new int[]{12, 91, 256}, new int[]{12, 51, TIFFConstants.TIFFTAG_COLORMAP}, new int[]{12, 52, 384}, new int[]{12, 53, 448}, new int[]{13, 108, 512}, new int[]{13, 109, 576}, new int[]{13, 74, 640}, new int[]{13, 75, TypedValues.TransitionType.TYPE_AUTO_TRANSITION}, new int[]{13, 76, ViewUtils.EDGE_TO_EDGE_FLAGS}, new int[]{13, 77, 832}, new int[]{13, 114, 896}, new int[]{13, 115, 960}, new int[]{13, 116, 1024}, new int[]{13, 117, 1088}, new int[]{13, 118, 1152}, new int[]{13, 119, 1216}, new int[]{13, 82, 1280}, new int[]{13, 83, 1344}, new int[]{13, 84, 1408}, new int[]{13, 85, 1472}, new int[]{13, 90, BOFRecord.VERSION}, new int[]{13, 91, 1600}, new int[]{13, 100, 1664}, new int[]{13, 101, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.META_DIBBITBLT}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};
    private int[] horizcode = {3, 1, 0};
    private int[] passcode = {4, 1, 0};
    private int[][] vcodes = {new int[]{7, 3, 0}, new int[]{6, 3, 0}, new int[]{3, 3, 0}, new int[]{1, 1, 0}, new int[]{3, 2, 0}, new int[]{6, 2, 0}, new int[]{7, 2, 0}};
    private int[] msbmask = {0, 1, 3, 7, 15, 31, 63, ShapeTypes.VERTICAL_SCROLL, 255};

    public CCITTG4Encoder(int i) {
        this.rowpixels = i;
        int i2 = (i + 7) / 8;
        this.rowbytes = i2;
        this.refline = new byte[i2];
    }

    private void Fax3Encode2DRow() {
        int iFinddiff = pixel(this.dataBp, this.offsetData, 0) != 0 ? 0 : finddiff(this.dataBp, this.offsetData, 0, this.rowpixels, 0);
        int iFinddiff2 = pixel(this.refline, 0, 0) != 0 ? 0 : finddiff(this.refline, 0, 0, this.rowpixels, 0);
        int i = 0;
        while (true) {
            byte[] bArr = this.refline;
            int iFinddiff3 = finddiff2(bArr, 0, iFinddiff2, this.rowpixels, pixel(bArr, 0, iFinddiff2));
            if (iFinddiff3 >= iFinddiff) {
                int i2 = iFinddiff2 - iFinddiff;
                if (-3 > i2 || i2 > 3) {
                    byte[] bArr2 = this.dataBp;
                    int i3 = this.offsetData;
                    int iFinddiff4 = finddiff2(bArr2, i3, iFinddiff, this.rowpixels, pixel(bArr2, i3, iFinddiff));
                    putcode(this.horizcode);
                    if (i + iFinddiff == 0 || pixel(this.dataBp, this.offsetData, i) == 0) {
                        putspan(iFinddiff - i, this.TIFFFaxWhiteCodes);
                        putspan(iFinddiff4 - iFinddiff, this.TIFFFaxBlackCodes);
                    } else {
                        putspan(iFinddiff - i, this.TIFFFaxBlackCodes);
                        putspan(iFinddiff4 - iFinddiff, this.TIFFFaxWhiteCodes);
                    }
                    iFinddiff = iFinddiff4;
                } else {
                    putcode(this.vcodes[i2 + 3]);
                }
                i = iFinddiff;
            } else {
                putcode(this.passcode);
                i = iFinddiff3;
            }
            int i4 = this.rowpixels;
            if (i >= i4) {
                return;
            }
            byte[] bArr3 = this.dataBp;
            int i5 = this.offsetData;
            iFinddiff = finddiff(bArr3, i5, i, i4, pixel(bArr3, i5, i));
            iFinddiff2 = finddiff(this.refline, 0, finddiff(this.refline, 0, i, this.rowpixels, pixel(this.dataBp, this.offsetData, i) ^ 1), this.rowpixels, pixel(this.dataBp, this.offsetData, i));
        }
    }

    private void Fax4PostEncode() {
        putBits(1, 12);
        putBits(1, 12);
        if (this.bit != 8) {
            this.outBuf.append((byte) this.data);
            this.data = 0;
            this.bit = 8;
        }
    }

    public static byte[] compress(byte[] bArr, int i, int i2) {
        CCITTG4Encoder cCITTG4Encoder = new CCITTG4Encoder(i);
        cCITTG4Encoder.fax4Encode(bArr, 0, cCITTG4Encoder.rowbytes * i2);
        return cCITTG4Encoder.close();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0034 -> B:15:0x0022). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 731. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private static int find0span(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L25
            r5 = r5 & 7
            if (r5 == 0) goto L25
            byte[] r1 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.zeroruns
            r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            if (r1 <= r6) goto L1d
            r1 = r6
        L1d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L21
            return r1
        L21:
            int r6 = r6 - r1
        L22:
            int r4 = r4 + 1
            goto L26
        L25:
            r1 = 0
        L26:
            if (r6 < r0) goto L39
            r5 = r3[r4]
            if (r5 == 0) goto L34
            byte[] r3 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.zeroruns
            r4 = r5 & 255(0xff, float:3.57E-43)
            r3 = r3[r4]
            int r1 = r1 + r3
            return r1
        L34:
            int r1 = r1 + 8
            int r6 = r6 + (-8)
            goto L22
        L39:
            if (r6 <= 0) goto L48
            byte[] r5 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.zeroruns
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r5[r3]
            if (r3 <= r6) goto L46
            goto L47
        L46:
            r6 = r3
        L47:
            int r1 = r1 + r6
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.CCITTG4Encoder.find0span(byte[], int, int, int):int");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0035 -> B:15:0x0022). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 741. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private static int find1span(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L25
            r5 = r5 & 7
            if (r5 == 0) goto L25
            byte[] r1 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.oneruns
            r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            if (r1 <= r6) goto L1d
            r1 = r6
        L1d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L21
            return r1
        L21:
            int r6 = r6 - r1
        L22:
            int r4 = r4 + 1
            goto L26
        L25:
            r1 = 0
        L26:
            if (r6 < r0) goto L3a
            r5 = r3[r4]
            r2 = -1
            if (r5 == r2) goto L35
            byte[] r3 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.oneruns
            r4 = r5 & 255(0xff, float:3.57E-43)
            r3 = r3[r4]
            int r1 = r1 + r3
            return r1
        L35:
            int r1 = r1 + 8
            int r6 = r6 + (-8)
            goto L22
        L3a:
            if (r6 <= 0) goto L49
            byte[] r5 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.oneruns
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r5[r3]
            if (r3 <= r6) goto L47
            goto L48
        L47:
            r6 = r3
        L48:
            int r1 = r1 + r6
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.CCITTG4Encoder.find1span(byte[], int, int, int):int");
    }

    private static int finddiff(byte[] bArr, int i, int i2, int i3, int i4) {
        return i2 + (i4 != 0 ? find1span(bArr, i, i2, i3) : find0span(bArr, i, i2, i3));
    }

    private static int finddiff2(byte[] bArr, int i, int i2, int i3, int i4) {
        return i2 < i3 ? finddiff(bArr, i, i2, i3, i4) : i3;
    }

    private int pixel(byte[] bArr, int i, int i2) {
        if (i2 >= this.rowpixels) {
            return 0;
        }
        return ((bArr[i + (i2 >> 3)] & 255) >> (7 - (i2 & 7))) & 1;
    }

    private void putBits(int i, int i2) {
        int i3;
        while (true) {
            i3 = this.bit;
            if (i2 <= i3) {
                break;
            }
            int i4 = this.data | (i >> (i2 - i3));
            this.data = i4;
            i2 -= i3;
            this.outBuf.append((byte) i4);
            this.data = 0;
            this.bit = 8;
        }
        int i5 = ((i & this.msbmask[i2]) << (i3 - i2)) | this.data;
        this.data = i5;
        int i6 = i3 - i2;
        this.bit = i6;
        if (i6 == 0) {
            this.outBuf.append((byte) i5);
            this.data = 0;
            this.bit = 8;
        }
    }

    private void putcode(int[] iArr) {
        putBits(iArr[1], iArr[0]);
    }

    private void putspan(int i, int[][] iArr) {
        while (i >= 2624) {
            int[] iArr2 = iArr[103];
            putBits(iArr2[1], iArr2[0]);
            i -= iArr2[2];
        }
        if (i >= 64) {
            int[] iArr3 = iArr[(i >> 6) + 63];
            putBits(iArr3[1], iArr3[0]);
            i -= iArr3[2];
        }
        int[] iArr4 = iArr[i];
        putBits(iArr4[1], iArr4[0]);
    }

    public byte[] close() {
        Fax4PostEncode();
        return this.outBuf.toByteArray();
    }

    public void fax4Encode(byte[] bArr, int i, int i2) {
        this.dataBp = bArr;
        this.offsetData = i;
        this.sizeData = i2;
        while (this.sizeData > 0) {
            Fax3Encode2DRow();
            System.arraycopy(this.dataBp, this.offsetData, this.refline, 0, this.rowbytes);
            int i3 = this.offsetData;
            int i4 = this.rowbytes;
            this.offsetData = i3 + i4;
            this.sizeData -= i4;
        }
    }

    public void fax4Encode(byte[] bArr, int i) {
        fax4Encode(bArr, 0, this.rowbytes * i);
    }
}
