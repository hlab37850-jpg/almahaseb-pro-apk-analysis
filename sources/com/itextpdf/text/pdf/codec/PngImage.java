package com.itextpdf.text.pdf.codec;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class PngImage {
    public static final String IDAT = "IDAT";
    public static final String IEND = "IEND";
    public static final String IHDR = "IHDR";
    public static final String PLTE = "PLTE";
    private static final int PNG_FILTER_AVERAGE = 3;
    private static final int PNG_FILTER_NONE = 0;
    private static final int PNG_FILTER_PAETH = 4;
    private static final int PNG_FILTER_SUB = 1;
    private static final int PNG_FILTER_UP = 2;
    private static final int TRANSFERSIZE = 4096;
    public static final String cHRM = "cHRM";
    public static final String gAMA = "gAMA";
    public static final String iCCP = "iCCP";
    public static final String pHYs = "pHYs";
    public static final String sRGB = "sRGB";
    public static final String tRNS = "tRNS";
    float XYRatio;
    int bitDepth;
    int bytesPerPixel;
    byte[] colorTable;
    int colorType;
    int compressionMethod;
    DataInputStream dataStream;
    int dpiX;
    int dpiY;
    int filterMethod;
    boolean genBWMask;
    int height;
    ICC_Profile icc_profile;
    byte[] image;
    int inputBands;
    PdfName intent;
    int interlaceMethod;
    InputStream is;
    boolean palShades;
    byte[] smask;
    byte[] trans;
    int width;
    float xB;
    float xG;
    float xR;
    float xW;
    float yB;
    float yG;
    float yR;
    float yW;
    public static final int[] PNGID = {ShapeTypes.FLOW_CHART_DOCUMENT, 80, 78, 71, 13, 10, 26, 10};
    private static final PdfName[] intents = {PdfName.PERCEPTUAL, PdfName.RELATIVECOLORIMETRIC, PdfName.SATURATION, PdfName.ABSOLUTECOLORIMETRIC};
    PdfDictionary additional = new PdfDictionary();
    NewByteArrayOutputStream idat = new NewByteArrayOutputStream();
    int transRedGray = -1;
    int transGreen = -1;
    int transBlue = -1;
    float gamma = 1.0f;
    boolean hasCHRM = false;

    public static class NewByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getBuf() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public PngImage(InputStream inputStream) {
        this.is = inputStream;
    }

    private static void decodeAverageFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & UnsignedBytes.MAX_VALUE) + ((bArr2[i3] & UnsignedBytes.MAX_VALUE) / 2));
        }
        for (int i4 = i2; i4 < i; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & UnsignedBytes.MAX_VALUE) + (((bArr[i4 - i2] & UnsignedBytes.MAX_VALUE) + (bArr2[i4] & UnsignedBytes.MAX_VALUE)) / 2));
        }
    }

    private static void decodePaethFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & UnsignedBytes.MAX_VALUE) + (bArr2[i3] & UnsignedBytes.MAX_VALUE));
        }
        for (int i4 = i2; i4 < i; i4++) {
            int i5 = i4 - i2;
            bArr[i4] = (byte) ((bArr[i4] & UnsignedBytes.MAX_VALUE) + paethPredictor(bArr[i5] & UnsignedBytes.MAX_VALUE, bArr2[i4] & UnsignedBytes.MAX_VALUE, bArr2[i5] & UnsignedBytes.MAX_VALUE));
        }
    }

    private static void decodeSubFilter(byte[] bArr, int i, int i2) {
        for (int i3 = i2; i3 < i; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & UnsignedBytes.MAX_VALUE) + (bArr[i3 - i2] & UnsignedBytes.MAX_VALUE));
        }
    }

    private static void decodeUpFilter(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((bArr[i2] & UnsignedBytes.MAX_VALUE) + (bArr2[i2] & UnsignedBytes.MAX_VALUE));
        }
    }

    public static Image getImage(URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        try {
            inputStreamOpenStream = url.openStream();
            try {
                Image image = getImage(inputStreamOpenStream);
                image.setUrl(url);
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                return image;
            } catch (Throwable th) {
                th = th;
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenStream = null;
        }
    }

    public static final int getInt(InputStream inputStream) {
        return (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    public static int getPixel(byte[] bArr, int i, int i2, int i3, int i4) {
        if (i3 == 8) {
            return bArr[(i4 * i2) + i] & UnsignedBytes.MAX_VALUE;
        }
        int i5 = i4 * i2;
        int i6 = 8 / i3;
        return (bArr[i5 + (i / i6)] >> ((8 - ((i % i6) * i3)) - i3)) & ((1 << i3) - 1);
    }

    public static final String getString(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            stringBuffer.append((char) inputStream.read());
        }
        return stringBuffer.toString();
    }

    public static final int getWord(InputStream inputStream) {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static int paethPredictor(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int iAbs = Math.abs(i4 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int iAbs3 = Math.abs(i4 - i3);
        if (iAbs > iAbs2 || iAbs > iAbs3) {
            return iAbs2 <= iAbs3 ? i2 : i3;
        }
        return i;
    }

    public static void setPixel(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        if (i5 == 8) {
            int i8 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i8 + i7] = (byte) iArr[i7 + i];
                i7++;
            }
            return;
        }
        if (i5 != 16) {
            int i9 = 8 / i5;
            int i10 = (i6 * i4) + (i3 / i9);
            bArr[i10] = (byte) ((iArr[i] << ((8 - ((i3 % i9) * i5)) - i5)) | bArr[i10]);
        } else {
            int i11 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i11 + i7] = (byte) (iArr[i7 + i] >>> 8);
                i7++;
            }
        }
    }

    public boolean checkMarker(String str) {
        if (str.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public void decodeIdat() {
        int i;
        int i2 = this.bitDepth;
        int i3 = i2 == 16 ? 8 : i2;
        int i4 = i2 == 16 ? 2 : 1;
        this.bytesPerPixel = i4;
        int i5 = this.colorType;
        if (i5 == 0) {
            i = (((i3 * this.width) + 7) / 8) * this.height;
        } else if (i5 == 6) {
            i = this.width * 3 * this.height;
            this.bytesPerPixel = i4 * 4;
        } else if (i5 != 2) {
            i = -1;
            if (i5 == 3) {
                i = this.interlaceMethod == 1 ? (((i3 * this.width) + 7) / 8) * this.height : -1;
                this.bytesPerPixel = 1;
            } else if (i5 == 4) {
                i = this.width * this.height;
                this.bytesPerPixel = i4 * 2;
            }
        } else {
            i = this.width * 3 * this.height;
            this.bytesPerPixel = i4 * 3;
        }
        if (i >= 0) {
            this.image = new byte[i];
        }
        if (this.palShades) {
            this.smask = new byte[this.width * this.height];
        } else if (this.genBWMask) {
            this.smask = new byte[((this.width + 7) / 8) * this.height];
        }
        this.dataStream = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.idat.getBuf(), 0, this.idat.size()), new Inflater()));
        if (this.interlaceMethod != 1) {
            decodePass(0, 0, 1, 1, this.width, this.height);
            return;
        }
        decodePass(0, 0, 8, 8, (this.width + 7) / 8, (this.height + 7) / 8);
        decodePass(4, 0, 8, 8, (this.width + 3) / 8, (this.height + 7) / 8);
        decodePass(0, 4, 4, 8, (this.width + 3) / 4, (this.height + 3) / 8);
        decodePass(2, 0, 4, 4, (this.width + 1) / 4, (this.height + 3) / 4);
        decodePass(0, 2, 2, 4, (this.width + 1) / 2, (this.height + 1) / 4);
        decodePass(1, 0, 2, 2, this.width / 2, (this.height + 1) / 2);
        decodePass(0, 1, 1, 2, this.width, this.height / 2);
    }

    public void decodePass(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        if (i5 == 0 || i6 == 0) {
            return;
        }
        int i8 = (((this.inputBands * i5) * this.bitDepth) + 7) / 8;
        int i9 = i2;
        byte[] bArr = new byte[i8];
        byte[] bArr2 = new byte[i8];
        int i10 = 0;
        while (i10 < i6) {
            try {
                i7 = this.dataStream.read();
                try {
                    this.dataStream.readFully(bArr, 0, i8);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i7 = 0;
            }
            if (i7 != 0) {
                if (i7 == 1) {
                    decodeSubFilter(bArr, i8, this.bytesPerPixel);
                } else if (i7 == 2) {
                    decodeUpFilter(bArr, bArr2, i8);
                } else if (i7 == 3) {
                    decodeAverageFilter(bArr, bArr2, i8, this.bytesPerPixel);
                } else {
                    if (i7 != 4) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("png.filter.unknown", new Object[0]));
                    }
                    decodePaethFilter(bArr, bArr2, i8, this.bytesPerPixel);
                }
            }
            processPixels(bArr, i, i3, i9, i5);
            i10++;
            i9 += i4;
            byte[] bArr3 = bArr2;
            bArr2 = bArr;
            bArr = bArr3;
        }
    }

    public PdfObject getColorspace() {
        if (this.icc_profile != null) {
            return (this.colorType & 2) == 0 ? PdfName.DEVICEGRAY : PdfName.DEVICERGB;
        }
        if (this.gamma == 1.0f && !this.hasCHRM) {
            return (this.colorType & 2) == 0 ? PdfName.DEVICEGRAY : PdfName.DEVICERGB;
        }
        PdfArray pdfArray = new PdfArray();
        PdfDictionary pdfDictionary = new PdfDictionary();
        if ((this.colorType & 2) != 0) {
            PdfObject pdfLiteral = new PdfLiteral("[1 1 1]");
            pdfArray.add(PdfName.CALRGB);
            if (this.gamma != 1.0f) {
                PdfArray pdfArray2 = new PdfArray();
                PdfNumber pdfNumber = new PdfNumber(this.gamma);
                pdfArray2.add(pdfNumber);
                pdfArray2.add(pdfNumber);
                pdfArray2.add(pdfNumber);
                pdfDictionary.put(PdfName.GAMMA, pdfArray2);
            }
            if (this.hasCHRM) {
                float f = this.yW;
                float f2 = this.xG;
                float f3 = this.xB;
                float f4 = this.yR;
                float f5 = this.xR;
                float f6 = this.yG;
                float f7 = this.yB;
                float f8 = ((((f2 - f3) * f4) - ((f5 - f3) * f6)) + ((f5 - f2) * f7)) * f;
                float f9 = this.xW;
                float f10 = (((((f2 - f3) * f) - ((f9 - f3) * f6)) + ((f9 - f2) * f7)) * f4) / f8;
                float f11 = (f10 * f5) / f4;
                float f12 = (((1.0f - f5) / f4) - 1.0f) * f10;
                float f13 = ((-f6) * ((((f5 - f3) * f) - ((f9 - f3) * f4)) + ((f9 - f5) * f7))) / f8;
                float f14 = (f13 * f2) / f6;
                float f15 = f13 * (((1.0f - f2) / f6) - 1.0f);
                float f16 = (((((f5 - f2) * f) - ((f9 - f2) * f)) + ((f9 - f5) * f6)) * f7) / f8;
                float f17 = (f16 * f3) / f7;
                float f18 = (((1.0f - f3) / f7) - 1.0f) * f16;
                PdfArray pdfArray3 = new PdfArray();
                pdfArray3.add(new PdfNumber(f11 + f14 + f17));
                pdfArray3.add(new PdfNumber(1.0f));
                pdfArray3.add(new PdfNumber(f12 + f15 + f18));
                PdfArray pdfArray4 = new PdfArray();
                pdfArray4.add(new PdfNumber(f11));
                pdfArray4.add(new PdfNumber(f10));
                pdfArray4.add(new PdfNumber(f12));
                pdfArray4.add(new PdfNumber(f14));
                pdfArray4.add(new PdfNumber(f13));
                pdfArray4.add(new PdfNumber(f15));
                pdfArray4.add(new PdfNumber(f17));
                pdfArray4.add(new PdfNumber(f16));
                pdfArray4.add(new PdfNumber(f18));
                pdfDictionary.put(PdfName.MATRIX, pdfArray4);
                pdfLiteral = pdfArray3;
            }
            pdfDictionary.put(PdfName.WHITEPOINT, pdfLiteral);
            pdfArray.add(pdfDictionary);
        } else {
            if (this.gamma == 1.0f) {
                return PdfName.DEVICEGRAY;
            }
            pdfArray.add(PdfName.CALGRAY);
            pdfDictionary.put(PdfName.GAMMA, new PdfNumber(this.gamma));
            pdfDictionary.put(PdfName.WHITEPOINT, new PdfLiteral("[1 1 1]"));
            pdfArray.add(pdfDictionary);
        }
        return pdfArray;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    public void processPixels(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int[] pixel = getPixel(bArr);
        int i6 = this.colorType;
        if (i6 == 0) {
            i5 = 1;
        } else if (i6 == 6 || i6 == 2) {
            i5 = 3;
        } else if (i6 == 3 || i6 == 4) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (this.image != null) {
            int i7 = this.width * i5;
            int i8 = this.bitDepth;
            if (i8 == 16) {
                i8 = 8;
            }
            int i9 = ((i7 * i8) + 7) / 8;
            int i10 = i;
            for (int i11 = 0; i11 < i4; i11++) {
                setPixel(this.image, pixel, this.inputBands * i11, i5, i10, i3, this.bitDepth, i9);
                i10 += i2;
            }
        }
        if (this.palShades) {
            if ((this.colorType & 4) != 0) {
                if (this.bitDepth == 16) {
                    for (int i12 = 0; i12 < i4; i12++) {
                        int i13 = (this.inputBands * i12) + i5;
                        pixel[i13] = pixel[i13] >>> 8;
                    }
                }
                int i14 = this.width;
                int i15 = i;
                for (int i16 = 0; i16 < i4; i16++) {
                    setPixel(this.smask, pixel, (this.inputBands * i16) + i5, 1, i15, i3, 8, i14);
                    i15 += i2;
                }
                return;
            }
            int i17 = this.width;
            int[] iArr = new int[1];
            int i18 = i;
            for (int i19 = 0; i19 < i4; i19++) {
                int i20 = pixel[i19];
                byte[] bArr2 = this.trans;
                if (i20 < bArr2.length) {
                    iArr[0] = bArr2[i20];
                } else {
                    iArr[0] = 255;
                }
                setPixel(this.smask, iArr, 0, 1, i18, i3, 8, i17);
                i18 += i2;
            }
            return;
        }
        if (this.genBWMask) {
            int i21 = this.colorType;
            if (i21 == 0) {
                int i22 = (this.width + 7) / 8;
                int i23 = i;
                for (int i24 = 0; i24 < i4; i24++) {
                    setPixel(this.smask, new int[]{pixel[i24] == this.transRedGray ? 1 : 0}, 0, 1, i23, i3, 1, i22);
                    i23 += i2;
                }
                return;
            }
            if (i21 == 2) {
                int i25 = (this.width + 7) / 8;
                int i26 = i;
                for (int i27 = 0; i27 < i4; i27++) {
                    int i28 = this.inputBands * i27;
                    setPixel(this.smask, new int[]{(pixel[i28] == this.transRedGray && pixel[i28 + 1] == this.transGreen && pixel[i28 + 2] == this.transBlue) ? 1 : 0}, 0, 1, i26, i3, 1, i25);
                    i26 += i2;
                }
                return;
            }
            if (i21 != 3) {
                return;
            }
            int i29 = (this.width + 7) / 8;
            int i30 = i;
            for (int i31 = 0; i31 < i4; i31++) {
                int i32 = pixel[i31];
                byte[] bArr3 = this.trans;
                setPixel(this.smask, new int[]{(i32 >= bArr3.length || bArr3[i32] != 0) ? 0 : 1}, 0, 1, i30, i3, 1, i29);
                i30 += i2;
            }
        }
    }

    public void readPng() throws IOException {
        int i = 0;
        while (true) {
            int[] iArr = PNGID;
            if (i >= iArr.length) {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = getInt(this.is);
                    String string = getString(this.is);
                    if (i2 < 0 || !checkMarker(string)) {
                        break;
                    }
                    if (IDAT.equals(string)) {
                        while (i2 != 0) {
                            int i3 = this.is.read(bArr, 0, Math.min(i2, 4096));
                            if (i3 < 0) {
                                return;
                            }
                            this.idat.write(bArr, 0, i3);
                            i2 -= i3;
                        }
                    } else if (tRNS.equals(string)) {
                        int i4 = this.colorType;
                        if (i4 != 0) {
                            if (i4 != 2) {
                                if (i4 == 3 && i2 > 0) {
                                    this.trans = new byte[i2];
                                    for (int i5 = 0; i5 < i2; i5++) {
                                        this.trans[i5] = (byte) this.is.read();
                                    }
                                    i2 = 0;
                                }
                            } else if (i2 >= 6) {
                                i2 -= 6;
                                int word = getWord(this.is);
                                int word2 = getWord(this.is);
                                int word3 = getWord(this.is);
                                if (this.bitDepth == 16) {
                                    this.transRedGray = word;
                                    this.transGreen = word2;
                                    this.transBlue = word3;
                                } else {
                                    this.additional.put(PdfName.MASK, new PdfLiteral("[" + word + " " + word + " " + word2 + " " + word2 + " " + word3 + " " + word3 + "]"));
                                }
                            }
                        } else if (i2 >= 2) {
                            i2 -= 2;
                            int word4 = getWord(this.is);
                            if (this.bitDepth == 16) {
                                this.transRedGray = word4;
                            } else {
                                this.additional.put(PdfName.MASK, new PdfLiteral("[" + word4 + " " + word4 + "]"));
                            }
                        }
                        Utilities.skip(this.is, i2);
                    } else if (IHDR.equals(string)) {
                        this.width = getInt(this.is);
                        this.height = getInt(this.is);
                        this.bitDepth = this.is.read();
                        this.colorType = this.is.read();
                        this.compressionMethod = this.is.read();
                        this.filterMethod = this.is.read();
                        this.interlaceMethod = this.is.read();
                    } else if (PLTE.equals(string)) {
                        if (this.colorType == 3) {
                            PdfArray pdfArray = new PdfArray();
                            pdfArray.add(PdfName.INDEXED);
                            pdfArray.add(getColorspace());
                            pdfArray.add(new PdfNumber((i2 / 3) - 1));
                            ByteBuffer byteBuffer = new ByteBuffer();
                            while (true) {
                                int i6 = i2 - 1;
                                if (i2 <= 0) {
                                    break;
                                }
                                byteBuffer.append_i(this.is.read());
                                i2 = i6;
                            }
                            byte[] byteArray = byteBuffer.toByteArray();
                            this.colorTable = byteArray;
                            pdfArray.add(new PdfString(byteArray));
                            this.additional.put(PdfName.COLORSPACE, pdfArray);
                        } else {
                            Utilities.skip(this.is, i2);
                        }
                    } else if (pHYs.equals(string)) {
                        int i7 = getInt(this.is);
                        int i8 = getInt(this.is);
                        if (this.is.read() == 1) {
                            this.dpiX = (int) ((i7 * 0.0254f) + 0.5f);
                            this.dpiY = (int) ((i8 * 0.0254f) + 0.5f);
                        } else if (i8 != 0) {
                            this.XYRatio = i7 / i8;
                        }
                    } else if (cHRM.equals(string)) {
                        this.xW = getInt(this.is) / 100000.0f;
                        this.yW = getInt(this.is) / 100000.0f;
                        this.xR = getInt(this.is) / 100000.0f;
                        this.yR = getInt(this.is) / 100000.0f;
                        this.xG = getInt(this.is) / 100000.0f;
                        this.yG = getInt(this.is) / 100000.0f;
                        this.xB = getInt(this.is) / 100000.0f;
                        this.yB = getInt(this.is) / 100000.0f;
                        this.hasCHRM = Math.abs(this.xW) >= 1.0E-4f && Math.abs(this.yW) >= 1.0E-4f && Math.abs(this.xR) >= 1.0E-4f && Math.abs(this.yR) >= 1.0E-4f && Math.abs(this.xG) >= 1.0E-4f && Math.abs(this.yG) >= 1.0E-4f && Math.abs(this.xB) >= 1.0E-4f && Math.abs(this.yB) >= 1.0E-4f;
                    } else if (sRGB.equals(string)) {
                        this.intent = intents[this.is.read()];
                        this.gamma = 2.2f;
                        this.xW = 0.3127f;
                        this.yW = 0.329f;
                        this.xR = 0.64f;
                        this.yR = 0.33f;
                        this.xG = 0.3f;
                        this.yG = 0.6f;
                        this.xB = 0.15f;
                        this.yB = 0.06f;
                        this.hasCHRM = true;
                    } else if (gAMA.equals(string)) {
                        int i9 = getInt(this.is);
                        if (i9 != 0) {
                            this.gamma = 100000.0f / i9;
                            if (!this.hasCHRM) {
                                this.xW = 0.3127f;
                                this.yW = 0.329f;
                                this.xR = 0.64f;
                                this.yR = 0.33f;
                                this.xG = 0.3f;
                                this.yG = 0.6f;
                                this.xB = 0.15f;
                                this.yB = 0.06f;
                                this.hasCHRM = true;
                            }
                        }
                    } else if (iCCP.equals(string)) {
                        while (true) {
                            int i10 = i2 - 1;
                            if (this.is.read() == 0) {
                                break;
                            } else {
                                i2 = i10;
                            }
                        }
                        this.is.read();
                        int i11 = i2 - 2;
                        byte[] bArr2 = new byte[i11];
                        int i12 = 0;
                        while (i11 > 0) {
                            int i13 = this.is.read(bArr2, i12, i11);
                            if (i13 < 0) {
                                throw new IOException(MessageLocalization.getComposedMessage("premature.end.of.file", new Object[0]));
                            }
                            i12 += i13;
                            i11 -= i13;
                        }
                        try {
                            this.icc_profile = ICC_Profile.getInstance(PdfReader.FlateDecode(bArr2, true));
                        } catch (RuntimeException unused) {
                            this.icc_profile = null;
                        }
                    } else if (IEND.equals(string)) {
                        return;
                    } else {
                        Utilities.skip(this.is, i2);
                    }
                    Utilities.skip(this.is, 4);
                }
                throw new IOException(MessageLocalization.getComposedMessage("corrupted.png.file", new Object[0]));
            }
            if (iArr[i] != this.is.read()) {
                throw new IOException(MessageLocalization.getComposedMessage("file.is.not.a.valid.png", new Object[0]));
            }
            i++;
        }
    }

    public int[] getPixel(byte[] bArr) {
        int i = this.bitDepth;
        int i2 = 0;
        if (i == 8) {
            int length = bArr.length;
            int[] iArr = new int[length];
            while (i2 < length) {
                iArr[i2] = bArr[i2] & UnsignedBytes.MAX_VALUE;
                i2++;
            }
            return iArr;
        }
        if (i != 16) {
            int[] iArr2 = new int[(bArr.length * 8) / i];
            int i3 = 8 / i;
            int i4 = (1 << i) - 1;
            int i5 = 0;
            while (i2 < bArr.length) {
                int i6 = i3 - 1;
                while (i6 >= 0) {
                    iArr2[i5] = (bArr[i2] >>> (this.bitDepth * i6)) & i4;
                    i6--;
                    i5++;
                }
                i2++;
            }
            return iArr2;
        }
        int length2 = bArr.length / 2;
        int[] iArr3 = new int[length2];
        while (i2 < length2) {
            int i7 = i2 * 2;
            iArr3[i2] = ((bArr[i7] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i7 + 1] & UnsignedBytes.MAX_VALUE);
            i2++;
        }
        return iArr3;
    }

    public static Image getImage(InputStream inputStream) {
        return new PngImage(inputStream).getImage();
    }

    public static Image getImage(String str) {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) {
        Image image = getImage(new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    public Image getImage() throws IOException {
        int i;
        int i2;
        Image imgRaw;
        readPng();
        try {
            this.palShades = false;
            if (this.trans != null) {
                int i3 = 0;
                i = 0;
                i2 = 0;
                while (true) {
                    byte[] bArr = this.trans;
                    if (i3 < bArr.length) {
                        int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
                        if (i4 == 0) {
                            i++;
                            i2 = i3;
                        }
                        if (i4 != 0 && i4 != 255) {
                            this.palShades = true;
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
            }
            if ((this.colorType & 4) != 0) {
                this.palShades = true;
            }
            boolean z = this.palShades;
            boolean z2 = !z && (i > 1 || this.transRedGray >= 0);
            this.genBWMask = z2;
            if (!z && !z2 && i == 1) {
                this.additional.put(PdfName.MASK, new PdfLiteral("[" + i2 + " " + i2 + "]"));
            }
            boolean z3 = this.interlaceMethod == 1 || this.bitDepth == 16 || (this.colorType & 4) != 0 || this.palShades || this.genBWMask;
            int i5 = this.colorType;
            if (i5 == 0) {
                this.inputBands = 1;
            } else if (i5 == 6) {
                this.inputBands = 4;
            } else if (i5 == 2) {
                this.inputBands = 3;
            } else if (i5 == 3) {
                this.inputBands = 1;
            } else if (i5 == 4) {
                this.inputBands = 2;
            }
            if (z3) {
                decodeIdat();
            }
            int i6 = this.inputBands;
            int i7 = this.colorType;
            if ((i7 & 4) != 0) {
                i6--;
            }
            int i8 = i6;
            int i9 = this.bitDepth;
            int i10 = i9 == 16 ? 8 : i9;
            byte[] bArr2 = this.image;
            if (bArr2 == null) {
                imgRaw = new ImgRaw(this.width, this.height, i8, i10, this.idat.toByteArray());
                imgRaw.setDeflated(true);
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.BITSPERCOMPONENT, new PdfNumber(this.bitDepth));
                pdfDictionary.put(PdfName.PREDICTOR, new PdfNumber(15));
                pdfDictionary.put(PdfName.COLUMNS, new PdfNumber(this.width));
                PdfName pdfName = PdfName.COLORS;
                int i11 = this.colorType;
                pdfDictionary.put(pdfName, new PdfNumber((i11 == 3 || (i11 & 2) == 0) ? 1 : 3));
                this.additional.put(PdfName.DECODEPARMS, pdfDictionary);
            } else if (i7 == 3) {
                imgRaw = new ImgRaw(this.width, this.height, i8, i10, this.image);
            } else {
                imgRaw = Image.getInstance(this.width, this.height, i8, i10, bArr2);
            }
            PdfDictionary pdfDictionary2 = this.additional;
            PdfName pdfName2 = PdfName.COLORSPACE;
            if (pdfDictionary2.get(pdfName2) == null) {
                this.additional.put(pdfName2, getColorspace());
            }
            PdfName pdfName3 = this.intent;
            if (pdfName3 != null) {
                this.additional.put(PdfName.INTENT, pdfName3);
            }
            if (this.additional.size() > 0) {
                imgRaw.setAdditional(this.additional);
            }
            ICC_Profile iCC_Profile = this.icc_profile;
            if (iCC_Profile != null) {
                imgRaw.tagICC(iCC_Profile);
            }
            if (this.palShades) {
                Image image = Image.getInstance(this.width, this.height, 1, 8, this.smask);
                image.makeMask();
                imgRaw.setImageMask(image);
            }
            if (this.genBWMask) {
                Image image2 = Image.getInstance(this.width, this.height, 1, 1, this.smask);
                image2.makeMask();
                imgRaw.setImageMask(image2);
            }
            imgRaw.setDpi(this.dpiX, this.dpiY);
            imgRaw.setXYRatio(this.XYRatio);
            imgRaw.setOriginalType(2);
            return imgRaw;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
