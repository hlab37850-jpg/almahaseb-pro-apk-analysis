package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.languages.ArabicLigaturizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class BidiLine {
    protected static final IntHashtable mirrorChars;
    protected int arabicOptions;
    protected ArrayList<PdfChunk> chunks;
    protected int currentChar;
    protected PdfChunk[] detailChunks;
    protected int[] indexChars;
    protected int indexChunk;
    protected int indexChunkChar;
    protected boolean isWordSplit;
    protected byte[] orderLevels;
    protected int pieceSize;
    protected int runDirection;
    protected boolean shortStore;
    protected int storedCurrentChar;
    protected PdfChunk[] storedDetailChunks;
    protected int[] storedIndexChars;
    protected int storedIndexChunk;
    protected int storedIndexChunkChar;
    protected byte[] storedOrderLevels;
    protected int storedRunDirection;
    protected char[] storedText;
    protected int storedTotalTextLength;
    protected char[] text;
    protected int totalTextLength;

    static {
        IntHashtable intHashtable = new IntHashtable();
        mirrorChars = intHashtable;
        intHashtable.put(40, 41);
        intHashtable.put(41, 40);
        intHashtable.put(60, 62);
        intHashtable.put(62, 60);
        intHashtable.put(91, 93);
        intHashtable.put(93, 91);
        intHashtable.put(123, 125);
        intHashtable.put(125, 123);
        intHashtable.put(ShapeTypes.ACTION_BUTTON_SOUND, ShapeTypes.CHART_PLUS);
        intHashtable.put(ShapeTypes.CHART_PLUS, ShapeTypes.ACTION_BUTTON_SOUND);
        intHashtable.put(8249, 8250);
        intHashtable.put(8250, 8249);
        intHashtable.put(8261, 8262);
        intHashtable.put(8262, 8261);
        intHashtable.put(8317, 8318);
        intHashtable.put(8318, 8317);
        intHashtable.put(8333, 8334);
        intHashtable.put(8334, 8333);
        intHashtable.put(8712, 8715);
        intHashtable.put(8713, 8716);
        intHashtable.put(8714, 8717);
        intHashtable.put(8715, 8712);
        intHashtable.put(8716, 8713);
        intHashtable.put(8717, 8714);
        intHashtable.put(8725, 10741);
        intHashtable.put(8764, 8765);
        intHashtable.put(8765, 8764);
        intHashtable.put(8771, 8909);
        intHashtable.put(8786, 8787);
        intHashtable.put(8787, 8786);
        intHashtable.put(8788, 8789);
        intHashtable.put(8789, 8788);
        intHashtable.put(8804, 8805);
        intHashtable.put(8805, 8804);
        intHashtable.put(8806, 8807);
        intHashtable.put(8807, 8806);
        intHashtable.put(8808, 8809);
        intHashtable.put(8809, 8808);
        intHashtable.put(8810, 8811);
        intHashtable.put(8811, 8810);
        intHashtable.put(8814, 8815);
        intHashtable.put(8815, 8814);
        intHashtable.put(8816, 8817);
        intHashtable.put(8817, 8816);
        intHashtable.put(8818, 8819);
        intHashtable.put(8819, 8818);
        intHashtable.put(8820, 8821);
        intHashtable.put(8821, 8820);
        intHashtable.put(8822, 8823);
        intHashtable.put(8823, 8822);
        intHashtable.put(8824, 8825);
        intHashtable.put(8825, 8824);
        intHashtable.put(8826, 8827);
        intHashtable.put(8827, 8826);
        intHashtable.put(8828, 8829);
        intHashtable.put(8829, 8828);
        intHashtable.put(8830, 8831);
        intHashtable.put(8831, 8830);
        intHashtable.put(8832, 8833);
        intHashtable.put(8833, 8832);
        intHashtable.put(8834, 8835);
        intHashtable.put(8835, 8834);
        intHashtable.put(8836, 8837);
        intHashtable.put(8837, 8836);
        intHashtable.put(8838, 8839);
        intHashtable.put(8839, 8838);
        intHashtable.put(8840, 8841);
        intHashtable.put(8841, 8840);
        intHashtable.put(8842, 8843);
        intHashtable.put(8843, 8842);
        intHashtable.put(8847, 8848);
        intHashtable.put(8848, 8847);
        intHashtable.put(8849, 8850);
        intHashtable.put(8850, 8849);
        intHashtable.put(8856, 10680);
        intHashtable.put(8866, 8867);
        intHashtable.put(8867, 8866);
        intHashtable.put(8870, 10974);
        intHashtable.put(8872, 10980);
        intHashtable.put(8873, 10979);
        intHashtable.put(8875, 10981);
        intHashtable.put(8880, 8881);
        intHashtable.put(8881, 8880);
        intHashtable.put(8882, 8883);
        intHashtable.put(8883, 8882);
        intHashtable.put(8884, 8885);
        intHashtable.put(8885, 8884);
        intHashtable.put(8886, 8887);
        intHashtable.put(8887, 8886);
        intHashtable.put(8905, 8906);
        intHashtable.put(8906, 8905);
        intHashtable.put(8907, 8908);
        intHashtable.put(8908, 8907);
        intHashtable.put(8909, 8771);
        intHashtable.put(8912, 8913);
        intHashtable.put(8913, 8912);
        intHashtable.put(8918, 8919);
        intHashtable.put(8919, 8918);
        intHashtable.put(8920, 8921);
        intHashtable.put(8921, 8920);
        intHashtable.put(8922, 8923);
        intHashtable.put(8923, 8922);
        intHashtable.put(8924, 8925);
        intHashtable.put(8925, 8924);
        intHashtable.put(8926, 8927);
        intHashtable.put(8927, 8926);
        intHashtable.put(8928, 8929);
        intHashtable.put(8929, 8928);
        intHashtable.put(8930, 8931);
        intHashtable.put(8931, 8930);
        intHashtable.put(8932, 8933);
        intHashtable.put(8933, 8932);
        intHashtable.put(8934, 8935);
        intHashtable.put(8935, 8934);
        intHashtable.put(8936, 8937);
        intHashtable.put(8937, 8936);
        intHashtable.put(8938, 8939);
        intHashtable.put(8939, 8938);
        intHashtable.put(8940, 8941);
        intHashtable.put(8941, 8940);
        intHashtable.put(8944, 8945);
        intHashtable.put(8945, 8944);
        intHashtable.put(8946, 8954);
        intHashtable.put(8947, 8955);
        intHashtable.put(8948, 8956);
        intHashtable.put(8950, 8957);
        intHashtable.put(8951, 8958);
        intHashtable.put(8954, 8946);
        intHashtable.put(8955, 8947);
        intHashtable.put(8956, 8948);
        intHashtable.put(8957, 8950);
        intHashtable.put(8958, 8951);
        intHashtable.put(8968, 8969);
        intHashtable.put(8969, 8968);
        intHashtable.put(8970, 8971);
        intHashtable.put(8971, 8970);
        intHashtable.put(9001, 9002);
        intHashtable.put(9002, 9001);
        intHashtable.put(10088, 10089);
        intHashtable.put(10089, 10088);
        intHashtable.put(10090, 10091);
        intHashtable.put(10091, 10090);
        intHashtable.put(10092, 10093);
        intHashtable.put(10093, 10092);
        intHashtable.put(10094, 10095);
        intHashtable.put(10095, 10094);
        intHashtable.put(10096, 10097);
        intHashtable.put(10097, 10096);
        intHashtable.put(10098, 10099);
        intHashtable.put(10099, 10098);
        intHashtable.put(10100, 10101);
        intHashtable.put(10101, 10100);
        intHashtable.put(10197, 10198);
        intHashtable.put(10198, 10197);
        intHashtable.put(10205, 10206);
        intHashtable.put(10206, 10205);
        intHashtable.put(10210, 10211);
        intHashtable.put(10211, 10210);
        intHashtable.put(10212, 10213);
        intHashtable.put(10213, 10212);
        intHashtable.put(10214, 10215);
        intHashtable.put(10215, 10214);
        intHashtable.put(10216, 10217);
        intHashtable.put(10217, 10216);
        intHashtable.put(10218, 10219);
        intHashtable.put(10219, 10218);
        intHashtable.put(10627, 10628);
        intHashtable.put(10628, 10627);
        intHashtable.put(10629, 10630);
        intHashtable.put(10630, 10629);
        intHashtable.put(10631, 10632);
        intHashtable.put(10632, 10631);
        intHashtable.put(10633, 10634);
        intHashtable.put(10634, 10633);
        intHashtable.put(10635, 10636);
        intHashtable.put(10636, 10635);
        intHashtable.put(10637, 10640);
        intHashtable.put(10638, 10639);
        intHashtable.put(10639, 10638);
        intHashtable.put(10640, 10637);
        intHashtable.put(10641, 10642);
        intHashtable.put(10642, 10641);
        intHashtable.put(10643, 10644);
        intHashtable.put(10644, 10643);
        intHashtable.put(10645, 10646);
        intHashtable.put(10646, 10645);
        intHashtable.put(10647, 10648);
        intHashtable.put(10648, 10647);
        intHashtable.put(10680, 8856);
        intHashtable.put(10688, 10689);
        intHashtable.put(10689, 10688);
        intHashtable.put(10692, 10693);
        intHashtable.put(10693, 10692);
        intHashtable.put(10703, 10704);
        intHashtable.put(10704, 10703);
        intHashtable.put(10705, 10706);
        intHashtable.put(10706, 10705);
        intHashtable.put(10708, 10709);
        intHashtable.put(10709, 10708);
        intHashtable.put(10712, 10713);
        intHashtable.put(10713, 10712);
        intHashtable.put(10714, 10715);
        intHashtable.put(10715, 10714);
        intHashtable.put(10741, 8725);
        intHashtable.put(10744, 10745);
        intHashtable.put(10745, 10744);
        intHashtable.put(10748, 10749);
        intHashtable.put(10749, 10748);
        intHashtable.put(10795, 10796);
        intHashtable.put(10796, 10795);
        intHashtable.put(10797, 10796);
        intHashtable.put(10798, 10797);
        intHashtable.put(10804, 10805);
        intHashtable.put(10805, 10804);
        intHashtable.put(10812, 10813);
        intHashtable.put(10813, 10812);
        intHashtable.put(10852, 10853);
        intHashtable.put(10853, 10852);
        intHashtable.put(10873, 10874);
        intHashtable.put(10874, 10873);
        intHashtable.put(10877, 10878);
        intHashtable.put(10878, 10877);
        intHashtable.put(10879, 10880);
        intHashtable.put(10880, 10879);
        intHashtable.put(10881, 10882);
        intHashtable.put(10882, 10881);
        intHashtable.put(10883, 10884);
        intHashtable.put(10884, 10883);
        intHashtable.put(10891, 10892);
        intHashtable.put(10892, 10891);
        intHashtable.put(10897, 10898);
        intHashtable.put(10898, 10897);
        intHashtable.put(10899, 10900);
        intHashtable.put(10900, 10899);
        intHashtable.put(10901, 10902);
        intHashtable.put(10902, 10901);
        intHashtable.put(10903, 10904);
        intHashtable.put(10904, 10903);
        intHashtable.put(10905, 10906);
        intHashtable.put(10906, 10905);
        intHashtable.put(10907, 10908);
        intHashtable.put(10908, 10907);
        intHashtable.put(10913, 10914);
        intHashtable.put(10914, 10913);
        intHashtable.put(10918, 10919);
        intHashtable.put(10919, 10918);
        intHashtable.put(10920, 10921);
        intHashtable.put(10921, 10920);
        intHashtable.put(10922, 10923);
        intHashtable.put(10923, 10922);
        intHashtable.put(10924, 10925);
        intHashtable.put(10925, 10924);
        intHashtable.put(10927, 10928);
        intHashtable.put(10928, 10927);
        intHashtable.put(10931, 10932);
        intHashtable.put(10932, 10931);
        intHashtable.put(10939, 10940);
        intHashtable.put(10940, 10939);
        intHashtable.put(10941, 10942);
        intHashtable.put(10942, 10941);
        intHashtable.put(10943, 10944);
        intHashtable.put(10944, 10943);
        intHashtable.put(10945, 10946);
        intHashtable.put(10946, 10945);
        intHashtable.put(10947, 10948);
        intHashtable.put(10948, 10947);
        intHashtable.put(10949, 10950);
        intHashtable.put(10950, 10949);
        intHashtable.put(10957, 10958);
        intHashtable.put(10958, 10957);
        intHashtable.put(10959, 10960);
        intHashtable.put(10960, 10959);
        intHashtable.put(10961, 10962);
        intHashtable.put(10962, 10961);
        intHashtable.put(10963, 10964);
        intHashtable.put(10964, 10963);
        intHashtable.put(10965, 10966);
        intHashtable.put(10966, 10965);
        intHashtable.put(10974, 8870);
        intHashtable.put(10979, 8873);
        intHashtable.put(10980, 8872);
        intHashtable.put(10981, 8875);
        intHashtable.put(10988, 10989);
        intHashtable.put(10989, 10988);
        intHashtable.put(10999, 11000);
        intHashtable.put(11000, 10999);
        intHashtable.put(11001, 11002);
        intHashtable.put(11002, 11001);
        intHashtable.put(12296, 12297);
        intHashtable.put(12297, 12296);
        intHashtable.put(12298, 12299);
        intHashtable.put(12299, 12298);
        intHashtable.put(12300, 12301);
        intHashtable.put(12301, 12300);
        intHashtable.put(12302, 12303);
        intHashtable.put(12303, 12302);
        intHashtable.put(12304, 12305);
        intHashtable.put(12305, 12304);
        intHashtable.put(12308, 12309);
        intHashtable.put(12309, 12308);
        intHashtable.put(12310, 12311);
        intHashtable.put(12311, 12310);
        intHashtable.put(12312, 12313);
        intHashtable.put(12313, 12312);
        intHashtable.put(12314, 12315);
        intHashtable.put(12315, 12314);
        intHashtable.put(65288, 65289);
        intHashtable.put(65289, 65288);
        intHashtable.put(65308, 65310);
        intHashtable.put(65310, 65308);
        intHashtable.put(65339, 65341);
        intHashtable.put(65341, 65339);
        intHashtable.put(65371, 65373);
        intHashtable.put(65373, 65371);
        intHashtable.put(65375, 65376);
        intHashtable.put(65376, 65375);
        intHashtable.put(65378, 65379);
        intHashtable.put(65379, 65378);
    }

    public BidiLine() {
        this.pieceSize = 256;
        this.text = new char[256];
        this.detailChunks = new PdfChunk[256];
        this.totalTextLength = 0;
        this.orderLevels = new byte[256];
        this.indexChars = new int[256];
        this.chunks = new ArrayList<>();
        this.indexChunk = 0;
        this.indexChunkChar = 0;
        this.currentChar = 0;
        this.storedText = new char[0];
        this.storedDetailChunks = new PdfChunk[0];
        this.storedTotalTextLength = 0;
        this.storedOrderLevels = new byte[0];
        this.storedIndexChars = new int[0];
        this.storedIndexChunk = 0;
        this.storedIndexChunkChar = 0;
        this.storedCurrentChar = 0;
        this.isWordSplit = false;
    }

    public static boolean isWS(char c) {
        return c <= ' ';
    }

    public static String processLTR(String str, int i, int i2) {
        BidiLine bidiLine = new BidiLine();
        bidiLine.addChunk(new PdfChunk(new Chunk(str), (PdfAction) null));
        bidiLine.arabicOptions = i2;
        bidiLine.getParagraph(i);
        ArrayList<PdfChunk> arrayListCreateArrayOfPdfChunks = bidiLine.createArrayOfPdfChunks(0, bidiLine.totalTextLength - 1);
        StringBuilder sb = new StringBuilder();
        Iterator<PdfChunk> it = arrayListCreateArrayOfPdfChunks.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    private float processTabStop(TabStop tabStop, float f, float f2, float f3, float f4, boolean z, List<TabStop> list) {
        float position = tabStop.getPosition(f, f2 - f3, f4);
        float f5 = f3 - (position - f);
        if (f5 < 0.0f) {
            position += f5;
            f5 = 0.0f;
        }
        if (z) {
            tabStop.setPosition(f);
            list.add(tabStop);
        } else {
            tabStop.setPosition(position);
        }
        return f5;
    }

    public void addChunk(PdfChunk pdfChunk) {
        this.chunks.add(pdfChunk);
    }

    public void addChunks(ArrayList<PdfChunk> arrayList) {
        this.chunks.addAll(arrayList);
    }

    public void addPiece(char c, PdfChunk pdfChunk) {
        int i = this.totalTextLength;
        int i2 = this.pieceSize;
        if (i >= i2) {
            char[] cArr = this.text;
            PdfChunk[] pdfChunkArr = this.detailChunks;
            int i3 = i2 * 2;
            this.pieceSize = i3;
            char[] cArr2 = new char[i3];
            this.text = cArr2;
            this.detailChunks = new PdfChunk[i3];
            System.arraycopy(cArr, 0, cArr2, 0, i);
            System.arraycopy(pdfChunkArr, 0, this.detailChunks, 0, this.totalTextLength);
        }
        char[] cArr3 = this.text;
        int i4 = this.totalTextLength;
        cArr3[i4] = c;
        PdfChunk[] pdfChunkArr2 = this.detailChunks;
        this.totalTextLength = i4 + 1;
        pdfChunkArr2[i4] = pdfChunk;
    }

    public void clearChunks() {
        this.chunks.clear();
        this.totalTextLength = 0;
        this.currentChar = 0;
    }

    public ArrayList<PdfChunk> createArrayOfPdfChunks(int i, int i2) {
        return createArrayOfPdfChunks(i, i2, null);
    }

    public void doArabicShapping() {
        char c;
        char[] cArr;
        char c2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.totalTextLength;
            if (i < i3 && ((c2 = (cArr = this.text)[i]) < 1536 || c2 > 1791)) {
                if (i != i2) {
                    cArr[i2] = c2;
                    PdfChunk[] pdfChunkArr = this.detailChunks;
                    pdfChunkArr[i2] = pdfChunkArr[i];
                    byte[] bArr = this.orderLevels;
                    bArr[i2] = bArr[i];
                }
                i++;
                i2++;
            } else {
                if (i >= i3) {
                    this.totalTextLength = i2;
                    return;
                }
                int i4 = i + 1;
                while (i4 < this.totalTextLength && (c = this.text[i4]) >= 1536 && c <= 1791) {
                    i4++;
                }
                int i5 = i4 - i;
                char[] cArr2 = this.text;
                int iArabic_shape = ArabicLigaturizer.arabic_shape(cArr2, i, i5, cArr2, i2, i5, this.arabicOptions);
                if (i != i2) {
                    int i6 = 0;
                    while (i6 < iArabic_shape) {
                        PdfChunk[] pdfChunkArr2 = this.detailChunks;
                        pdfChunkArr2[i2] = pdfChunkArr2[i];
                        byte[] bArr2 = this.orderLevels;
                        bArr2[i2] = bArr2[i];
                        i6++;
                        i2++;
                        i++;
                    }
                } else {
                    i2 += iArabic_shape;
                }
                i = i4;
            }
        }
    }

    public void flip(int i, int i2) {
        int i3 = (i + i2) / 2;
        while (true) {
            i2--;
            if (i >= i3) {
                return;
            }
            int[] iArr = this.indexChars;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            i++;
        }
    }

    public boolean getParagraph(int i) {
        this.runDirection = i;
        this.currentChar = 0;
        this.totalTextLength = 0;
        boolean z = false;
        while (this.indexChunk < this.chunks.size()) {
            PdfChunk pdfChunk = this.chunks.get(this.indexChunk);
            BaseFont font = pdfChunk.font().getFont();
            String string = pdfChunk.toString();
            int length = string.length();
            while (true) {
                int i2 = this.indexChunkChar;
                if (i2 >= length) {
                    break;
                }
                char cCharAt = string.charAt(i2);
                char unicodeEquivalent = (char) font.getUnicodeEquivalent(cCharAt);
                if (unicodeEquivalent == '\r' || unicodeEquivalent == '\n') {
                    if (unicodeEquivalent == '\r') {
                        int i3 = this.indexChunkChar;
                        if (i3 + 1 < length && string.charAt(i3 + 1) == '\n') {
                            this.indexChunkChar++;
                        }
                    }
                    int i4 = this.indexChunkChar + 1;
                    this.indexChunkChar = i4;
                    if (i4 >= length) {
                        this.indexChunkChar = 0;
                        this.indexChunk++;
                    }
                    if (this.totalTextLength == 0) {
                        this.detailChunks[0] = pdfChunk;
                    }
                    z = true;
                    break;
                }
                addPiece(cCharAt, pdfChunk);
                this.indexChunkChar++;
            }
            if (z) {
                break;
            }
            this.indexChunkChar = 0;
            this.indexChunk++;
        }
        int i5 = this.totalTextLength;
        if (i5 == 0) {
            return z;
        }
        int iTrimRight = trimRight(0, i5 - 1) + 1;
        this.totalTextLength = iTrimRight;
        if (iTrimRight == 0) {
            return true;
        }
        if (i != 1) {
            if (this.orderLevels.length < iTrimRight) {
                int i6 = this.pieceSize;
                this.orderLevels = new byte[i6];
                this.indexChars = new int[i6];
            }
            ArabicLigaturizer.processNumbers(this.text, 0, iTrimRight, this.arabicOptions);
            byte[] levels = new BidiOrder(this.text, 0, this.totalTextLength, i != 2 ? i != 3 ? (byte) -1 : (byte) 1 : (byte) 0).getLevels();
            for (int i7 = 0; i7 < this.totalTextLength; i7++) {
                this.orderLevels[i7] = levels[i7];
                this.indexChars[i7] = i7;
            }
            doArabicShapping();
            mirrorGlyphs();
        }
        this.totalTextLength = trimRightEx(0, this.totalTextLength - 1) + 1;
        return true;
    }

    public float getWidth(int i, int i2) {
        return getWidth(i, i2, 0.0f);
    }

    public int[] getWord(int i, int i2) {
        int i3 = i2;
        while (i3 < this.totalTextLength && (Character.isLetter(this.text[i3]) || Character.isDigit(this.text[i3]) || this.text[i3] == 173)) {
            i3++;
        }
        if (i3 == i2) {
            return null;
        }
        while (i2 >= i && (Character.isLetter(this.text[i2]) || Character.isDigit(this.text[i2]) || this.text[i2] == 173)) {
            i2--;
        }
        return new int[]{i2 + 1, i3};
    }

    public boolean isEmpty() {
        return this.currentChar >= this.totalTextLength && this.indexChunk >= this.chunks.size();
    }

    public boolean isWordSplit() {
        return this.isWordSplit;
    }

    public void mirrorGlyphs() {
        int i;
        for (int i2 = 0; i2 < this.totalTextLength; i2++) {
            if ((this.orderLevels[i2] & 1) == 1 && (i = mirrorChars.get(this.text[i2])) != 0) {
                this.text[i2] = (char) i;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0270  */
    /* JADX WARN: Code duplicated, block: B:52:0x012a  */
    public PdfLine processLine(float f, float f2, int i, int i2, int i3, float f3, float f4, float f5) {
        int i4;
        boolean zIsSurrogatePair;
        PdfChunk pdfChunk;
        TabStop tabStop;
        float f6;
        HyphenationEvent hyphenationEvent;
        int[] word;
        float f7;
        char c = 0;
        this.isWordSplit = false;
        this.arabicOptions = i3;
        save();
        boolean z = i2 == 3;
        if (this.currentChar >= this.totalTextLength) {
            if (!getParagraph(i2)) {
                return null;
            }
            if (this.totalTextLength == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new PdfChunk("", this.detailChunks[0]));
                return new PdfLine(0.0f, 0.0f, f2, i, true, arrayList, z);
            }
        }
        int i5 = this.currentChar;
        if (i5 != 0) {
            this.currentChar = trimLeftEx(i5, this.totalTextLength - 1);
        }
        int i6 = this.currentChar;
        ArrayList arrayList2 = new ArrayList();
        float percentage = f2;
        PdfChunk pdfChunk2 = null;
        TabStop tabStop2 = null;
        int i7 = -1;
        boolean z2 = false;
        float f8 = Float.NaN;
        float f9 = Float.NaN;
        while (true) {
            int i8 = this.currentChar;
            if (i8 >= this.totalTextLength) {
                i4 = i7;
                zIsSurrogatePair = z2;
                pdfChunk = pdfChunk2;
                tabStop = tabStop2;
                f6 = percentage;
                break;
            }
            PdfChunk pdfChunk3 = this.detailChunks[i8];
            if (pdfChunk3.isImage() && f3 < f4) {
                Image image = pdfChunk3.getImage();
                if (image.isScaleToFitHeight()) {
                    float f10 = f4 + (2.0f * f5);
                    if (((f10 - image.getScaledHeight()) - pdfChunk3.getImageOffsetY()) - image.getSpacingBefore() < f3) {
                        pdfChunk3.setImageScalePercentage((((f10 - pdfChunk3.getImageOffsetY()) - image.getSpacingBefore()) - f3) / image.getScaledHeight());
                    }
                }
            }
            zIsSurrogatePair = Utilities.isSurrogatePair(this.text, this.currentChar);
            int unicodeEquivalent = zIsSurrogatePair ? pdfChunk3.getUnicodeEquivalent(Utilities.convertToUtf32(this.text, this.currentChar)) : pdfChunk3.getUnicodeEquivalent(this.text[this.currentChar]);
            if (!PdfChunk.noPrint(unicodeEquivalent)) {
                float charWidth = zIsSurrogatePair ? pdfChunk3.getCharWidth(unicodeEquivalent) : pdfChunk3.isImage() ? pdfChunk3.getImageWidth() : pdfChunk3.getCharWidth(this.text[this.currentChar]);
                if (percentage - charWidth < 0.0f && pdfChunk2 == null && pdfChunk3.isImage()) {
                    Image image2 = pdfChunk3.getImage();
                    if (image2.isScaleToFitLineWhenOverflow()) {
                        pdfChunk3.setImageScalePercentage(percentage / image2.getWidth());
                        f7 = percentage;
                    } else {
                        f7 = charWidth;
                    }
                } else {
                    f7 = charWidth;
                }
                if (pdfChunk3.isTab()) {
                    if (pdfChunk3.isAttribute(Chunk.TABSETTINGS)) {
                        int i9 = this.currentChar;
                        if (tabStop2 != null) {
                            percentage = processTabStop(tabStop2, f8, f2, percentage, f9, z, arrayList2);
                        }
                        float f11 = f2 - percentage;
                        TabStop tabStop3 = PdfChunk.getTabStop(pdfChunk3, f11);
                        if (tabStop3.getPosition() > f2) {
                            i4 = i9;
                            f6 = percentage;
                            pdfChunk = pdfChunk2;
                            tabStop = null;
                            break;
                        }
                        pdfChunk3.setTabStop(tabStop3);
                        if (z || tabStop3.getAlignment() != TabStop.Alignment.LEFT) {
                            f8 = f11;
                            i7 = i9;
                            f9 = Float.NaN;
                            tabStop2 = tabStop3;
                        } else {
                            percentage = f2 - tabStop3.getPosition();
                            i7 = i9;
                            tabStop2 = null;
                            f8 = Float.NaN;
                            f9 = Float.NaN;
                        }
                    } else {
                        pdfChunk3 = pdfChunk3;
                        Object[] objArr = (Object[]) pdfChunk3.getAttribute(Chunk.TAB);
                        float fFloatValue = ((Float) objArr[1]).floatValue();
                        if (((Boolean) objArr[2]).booleanValue() && fFloatValue < f2 - percentage) {
                            return new PdfLine(0.0f, f2, percentage, i, true, createArrayOfPdfChunks(i6, this.currentChar - 1), z);
                        }
                        this.detailChunks[this.currentChar].adjustLeft(f);
                        percentage = f2 - fFloatValue;
                    }
                    if (zIsSurrogatePair) {
                        this.currentChar++;
                    }
                    pdfChunk2 = pdfChunk3;
                } else {
                    pdfChunk3 = pdfChunk3;
                    PdfChunk pdfChunk4 = pdfChunk2;
                    if (pdfChunk3.isSeparator()) {
                        Object[] objArr2 = (Object[]) pdfChunk3.getAttribute(Chunk.SEPARATOR);
                        DrawInterface drawInterface = (DrawInterface) objArr2[c];
                        if (((Boolean) objArr2[1]).booleanValue() && (drawInterface instanceof LineSeparator)) {
                            percentage -= (((LineSeparator) drawInterface).getPercentage() * f2) / 100.0f;
                            if (percentage < 0.0f) {
                                percentage = 0.0f;
                            }
                        }
                    } else {
                        boolean zIsExtSplitCharacter = pdfChunk3.isExtSplitCharacter(i6, this.currentChar, this.totalTextLength, this.text, this.detailChunks);
                        if (zIsExtSplitCharacter && Character.isWhitespace((char) unicodeEquivalent)) {
                            i7 = this.currentChar;
                        }
                        float f12 = percentage - f7;
                        if (f12 < 0.0f) {
                            i4 = i7;
                            tabStop = tabStop2;
                            f6 = percentage;
                            pdfChunk = pdfChunk4;
                            break;
                        }
                        if (tabStop2 != null && tabStop2.getAlignment() == TabStop.Alignment.ANCHOR && Float.isNaN(f9) && tabStop2.getAnchorChar() == ((char) unicodeEquivalent)) {
                            f9 = f2 - percentage;
                        }
                        if (zIsExtSplitCharacter) {
                            i7 = this.currentChar;
                        }
                        percentage = f12;
                    }
                    if (zIsSurrogatePair) {
                        this.currentChar++;
                    }
                    pdfChunk2 = pdfChunk3;
                }
            }
            this.currentChar++;
            z2 = zIsSurrogatePair;
            c = 0;
        }
        if (pdfChunk == null) {
            int i10 = this.currentChar;
            this.currentChar = i10 + 1;
            if (zIsSurrogatePair) {
                this.currentChar = i10 + 2;
            }
            int i11 = this.currentChar;
            return new PdfLine(0.0f, f2, 0.0f, i, false, createArrayOfPdfChunks(i11 - 1, i11 - 1), z);
        }
        float fProcessTabStop = tabStop != null ? processTabStop(tabStop, f8, f2, f6, f9, z, arrayList2) : f6;
        for (TabStop tabStop4 : arrayList2) {
            tabStop4.setPosition((f2 - fProcessTabStop) - tabStop4.getPosition());
        }
        int i12 = this.currentChar;
        int i13 = this.totalTextLength;
        if (i12 >= i13) {
            return new PdfLine(0.0f, f2, fProcessTabStop, i, true, createArrayOfPdfChunks(i6, i13 - 1), z);
        }
        int iTrimRightEx = trimRightEx(i6, i12 - 1);
        if (iTrimRightEx < i6) {
            return new PdfLine(0.0f, f2, fProcessTabStop, i, false, createArrayOfPdfChunks(i6, this.currentChar - 1), z);
        }
        if (iTrimRightEx == this.currentChar - 1 && (hyphenationEvent = (HyphenationEvent) pdfChunk.getAttribute(Chunk.HYPHENATION)) != null && (word = getWord(i6, iTrimRightEx)) != null) {
            float width = getWidth(word[0], this.currentChar - 1) + fProcessTabStop;
            char[] cArr = this.text;
            int i14 = word[0];
            String hyphenatedWordPre = hyphenationEvent.getHyphenatedWordPre(new String(cArr, i14, word[1] - i14), pdfChunk.font().getFont(), pdfChunk.font().size(), width);
            String hyphenatedWordPost = hyphenationEvent.getHyphenatedWordPost();
            if (hyphenatedWordPre.length() > 0) {
                PdfChunk pdfChunk5 = new PdfChunk(hyphenatedWordPre, pdfChunk);
                this.currentChar = word[1] - hyphenatedWordPost.length();
                return new PdfLine(0.0f, f2, width - pdfChunk.width(hyphenatedWordPre), i, false, createArrayOfPdfChunks(i6, word[0] - 1, pdfChunk5), z);
            }
        }
        if (i4 == -1) {
            this.isWordSplit = true;
        }
        if (i4 == -1 || i4 >= iTrimRightEx) {
            return new PdfLine(0.0f, f2, fProcessTabStop + getWidth(iTrimRightEx + 1, this.currentChar - 1, f2), i, false, createArrayOfPdfChunks(i6, iTrimRightEx), z);
        }
        this.currentChar = i4 + 1;
        int iTrimRightEx2 = trimRightEx(i6, i4);
        if (iTrimRightEx2 < i6) {
            iTrimRightEx2 = this.currentChar - 1;
        }
        return new PdfLine(0.0f, f2, f2 - getWidth(i6, iTrimRightEx2, f2), i, false, createArrayOfPdfChunks(i6, iTrimRightEx2), z);
    }

    public void reorder(int i, int i2) {
        byte b = this.orderLevels[i];
        byte b2 = b;
        byte b3 = b2;
        byte b4 = b3;
        for (int i3 = i + 1; i3 <= i2; i3++) {
            byte b5 = this.orderLevels[i3];
            if (b5 > b4) {
                b4 = b5;
            } else if (b5 < b3) {
                b3 = b5;
            }
            b2 = (byte) (b2 & b5);
            b = (byte) (b | b5);
        }
        if ((b & 1) == 0) {
            return;
        }
        if ((b2 & 1) == 1) {
            flip(i, i2 + 1);
            return;
        }
        byte b6 = (byte) (b3 | 1);
        while (b4 >= b6) {
            int i4 = i;
            while (true) {
                if (i4 <= i2 && this.orderLevels[i4] < b4) {
                    i4++;
                } else {
                    if (i4 > i2) {
                        break;
                    }
                    int i5 = i4 + 1;
                    while (i5 <= i2 && this.orderLevels[i5] >= b4) {
                        i5++;
                    }
                    flip(i4, i5);
                    i4 = i5 + 1;
                }
            }
            b4 = (byte) (b4 - 1);
        }
    }

    public void restore() {
        this.runDirection = this.storedRunDirection;
        int i = this.storedTotalTextLength;
        this.totalTextLength = i;
        this.indexChunk = this.storedIndexChunk;
        this.indexChunkChar = this.storedIndexChunkChar;
        this.currentChar = this.storedCurrentChar;
        if (!this.shortStore) {
            System.arraycopy(this.storedText, 0, this.text, 0, i);
            System.arraycopy(this.storedDetailChunks, 0, this.detailChunks, 0, this.totalTextLength);
        }
        if (this.runDirection != 1) {
            byte[] bArr = this.storedOrderLevels;
            int i2 = this.currentChar;
            System.arraycopy(bArr, i2, this.orderLevels, i2, this.totalTextLength - i2);
            int[] iArr = this.storedIndexChars;
            int i3 = this.currentChar;
            System.arraycopy(iArr, i3, this.indexChars, i3, this.totalTextLength - i3);
        }
    }

    public void save() {
        int i = this.indexChunk;
        if (i > 0) {
            if (i < this.chunks.size()) {
                while (true) {
                    this.indexChunk--;
                    int i2 = this.indexChunk;
                    if (i2 < 0) {
                        break;
                    } else {
                        this.chunks.remove(i2);
                    }
                }
            } else {
                this.chunks.clear();
            }
            this.indexChunk = 0;
        }
        this.storedRunDirection = this.runDirection;
        int i3 = this.totalTextLength;
        this.storedTotalTextLength = i3;
        this.storedIndexChunk = this.indexChunk;
        this.storedIndexChunkChar = this.indexChunkChar;
        int i4 = this.currentChar;
        this.storedCurrentChar = i4;
        boolean z = i4 < i3;
        this.shortStore = z;
        if (!z) {
            if (this.storedText.length < i3) {
                this.storedText = new char[i3];
                this.storedDetailChunks = new PdfChunk[i3];
            }
            System.arraycopy(this.text, 0, this.storedText, 0, i3);
            System.arraycopy(this.detailChunks, 0, this.storedDetailChunks, 0, this.totalTextLength);
        }
        if (this.runDirection != 1) {
            int length = this.storedOrderLevels.length;
            int i5 = this.totalTextLength;
            if (length < i5) {
                this.storedOrderLevels = new byte[i5];
                this.storedIndexChars = new int[i5];
            }
            byte[] bArr = this.orderLevels;
            int i6 = this.currentChar;
            System.arraycopy(bArr, i6, this.storedOrderLevels, i6, i5 - i6);
            int[] iArr = this.indexChars;
            int i7 = this.currentChar;
            System.arraycopy(iArr, i7, this.storedIndexChars, i7, this.totalTextLength - i7);
        }
    }

    public int trimLeft(int i, int i2) {
        while (i <= i2 && isWS((char) this.detailChunks[i].getUnicodeEquivalent(this.text[i]))) {
            i++;
        }
        return i;
    }

    public int trimLeftEx(int i, int i2) {
        while (i <= i2) {
            char unicodeEquivalent = (char) this.detailChunks[i].getUnicodeEquivalent(this.text[i]);
            if (!isWS(unicodeEquivalent) && !PdfChunk.noPrint(unicodeEquivalent) && (!this.detailChunks[i].isTab() || !this.detailChunks[i].isAttribute(Chunk.TABSETTINGS) || !((Boolean) ((Object[]) this.detailChunks[i].getAttribute(Chunk.TAB))[1]).booleanValue())) {
                break;
            }
            i++;
        }
        return i;
    }

    public int trimRight(int i, int i2) {
        while (i2 >= i && isWS((char) this.detailChunks[i2].getUnicodeEquivalent(this.text[i2]))) {
            i2--;
        }
        return i2;
    }

    public int trimRightEx(int i, int i2) {
        while (i2 >= i) {
            char unicodeEquivalent = (char) this.detailChunks[i2].getUnicodeEquivalent(this.text[i2]);
            if (!isWS(unicodeEquivalent) && !PdfChunk.noPrint(unicodeEquivalent) && (!this.detailChunks[i2].isTab() || !this.detailChunks[i2].isAttribute(Chunk.TABSETTINGS) || !((Boolean) ((Object[]) this.detailChunks[i2].getAttribute(Chunk.TAB))[1]).booleanValue())) {
                break;
            }
            i2--;
        }
        return i2;
    }

    public ArrayList<PdfChunk> createArrayOfPdfChunks(int i, int i2, PdfChunk pdfChunk) {
        boolean z = this.runDirection != 1;
        if (z) {
            reorder(i, i2);
        }
        ArrayList<PdfChunk> arrayList = new ArrayList<>();
        PdfChunk pdfChunk2 = this.detailChunks[i];
        StringBuffer stringBuffer = new StringBuffer();
        while (i <= i2) {
            int i3 = z ? this.indexChars[i] : i;
            char c = this.text[i3];
            PdfChunk pdfChunk3 = this.detailChunks[i3];
            if (!PdfChunk.noPrint(pdfChunk3.getUnicodeEquivalent(c))) {
                if (pdfChunk3.isImage() || pdfChunk3.isSeparator() || pdfChunk3.isTab()) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    arrayList.add(pdfChunk3);
                } else if (pdfChunk3 == pdfChunk2) {
                    stringBuffer.append(c);
                } else {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    if (!pdfChunk3.isImage() && !pdfChunk3.isSeparator() && !pdfChunk3.isTab()) {
                        stringBuffer.append(c);
                    }
                    pdfChunk2 = pdfChunk3;
                }
            }
            i++;
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
        }
        if (pdfChunk != null) {
            arrayList.add(pdfChunk);
        }
        return arrayList;
    }

    public float getWidth(int i, int i2, float f) {
        float charWidth = 0.0f;
        TabStop tabStop = null;
        float f2 = Float.NaN;
        float f3 = Float.NaN;
        while (i <= i2) {
            boolean zIsSurrogatePair = Utilities.isSurrogatePair(this.text, i);
            if (this.detailChunks[i].isTab() && this.detailChunks[i].isAttribute(Chunk.TABSETTINGS)) {
                if (tabStop != null) {
                    float position = tabStop.getPosition(f2, charWidth, f3);
                    charWidth = (charWidth - f2) + position;
                    tabStop.setPosition(position);
                }
                TabStop tabStop2 = this.detailChunks[i].getTabStop();
                if (tabStop2 == null) {
                    tabStop = PdfChunk.getTabStop(this.detailChunks[i], charWidth);
                    f2 = charWidth;
                } else {
                    charWidth = this.runDirection == 3 ? f - tabStop2.getPosition() : tabStop2.getPosition();
                    tabStop = null;
                    f2 = Float.NaN;
                }
                f3 = Float.NaN;
            } else if (zIsSurrogatePair) {
                charWidth += this.detailChunks[i].getCharWidth(Utilities.convertToUtf32(this.text, i));
                i++;
            } else {
                char c = this.text[i];
                PdfChunk pdfChunk = this.detailChunks[i];
                if (!PdfChunk.noPrint(pdfChunk.getUnicodeEquivalent(c))) {
                    if (tabStop != null && tabStop.getAlignment() != TabStop.Alignment.ANCHOR && Float.isNaN(f3) && tabStop.getAnchorChar() == ((char) pdfChunk.getUnicodeEquivalent(c))) {
                        f3 = charWidth;
                    }
                    charWidth += this.detailChunks[i].getCharWidth(c);
                }
            }
            i++;
        }
        if (tabStop == null) {
            return charWidth;
        }
        float position2 = tabStop.getPosition(f2, charWidth, f3);
        float f4 = (charWidth - f2) + position2;
        tabStop.setPosition(position2);
        return f4;
    }

    public BidiLine(BidiLine bidiLine) {
        this.pieceSize = 256;
        this.text = new char[256];
        this.detailChunks = new PdfChunk[256];
        this.totalTextLength = 0;
        this.orderLevels = new byte[256];
        this.indexChars = new int[256];
        this.chunks = new ArrayList<>();
        this.indexChunk = 0;
        this.indexChunkChar = 0;
        this.currentChar = 0;
        this.storedText = new char[0];
        this.storedDetailChunks = new PdfChunk[0];
        this.storedTotalTextLength = 0;
        this.storedOrderLevels = new byte[0];
        this.storedIndexChars = new int[0];
        this.storedIndexChunk = 0;
        this.storedIndexChunkChar = 0;
        this.storedCurrentChar = 0;
        this.isWordSplit = false;
        this.runDirection = bidiLine.runDirection;
        this.pieceSize = bidiLine.pieceSize;
        this.text = (char[]) bidiLine.text.clone();
        this.detailChunks = (PdfChunk[]) bidiLine.detailChunks.clone();
        this.totalTextLength = bidiLine.totalTextLength;
        this.orderLevels = (byte[]) bidiLine.orderLevels.clone();
        this.indexChars = (int[]) bidiLine.indexChars.clone();
        this.chunks = new ArrayList<>(bidiLine.chunks);
        this.indexChunk = bidiLine.indexChunk;
        this.indexChunkChar = bidiLine.indexChunkChar;
        this.currentChar = bidiLine.currentChar;
        this.storedRunDirection = bidiLine.storedRunDirection;
        this.storedText = (char[]) bidiLine.storedText.clone();
        this.storedDetailChunks = (PdfChunk[]) bidiLine.storedDetailChunks.clone();
        this.storedTotalTextLength = bidiLine.storedTotalTextLength;
        this.storedOrderLevels = (byte[]) bidiLine.storedOrderLevels.clone();
        this.storedIndexChars = (int[]) bidiLine.storedIndexChars.clone();
        this.storedIndexChunk = bidiLine.storedIndexChunk;
        this.storedIndexChunkChar = bidiLine.storedIndexChunkChar;
        this.storedCurrentChar = bidiLine.storedCurrentChar;
        this.shortStore = bidiLine.shortStore;
        this.arabicOptions = bidiLine.arabicOptions;
    }
}
