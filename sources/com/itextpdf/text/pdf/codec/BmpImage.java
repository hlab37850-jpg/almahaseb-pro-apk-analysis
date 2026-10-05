package com.itextpdf.text.pdf.codec;

import androidx.core.view.MotionEventCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BmpImage {
    private static final int BI_BITFIELDS = 3;
    private static final int BI_RGB = 0;
    private static final int BI_RLE4 = 2;
    private static final int BI_RLE8 = 1;
    private static final int LCS_CALIBRATED_RGB = 0;
    private static final int LCS_CMYK = 2;
    private static final int LCS_sRGB = 1;
    private static final int VERSION_2_1_BIT = 0;
    private static final int VERSION_2_24_BIT = 3;
    private static final int VERSION_2_4_BIT = 1;
    private static final int VERSION_2_8_BIT = 2;
    private static final int VERSION_3_1_BIT = 4;
    private static final int VERSION_3_24_BIT = 7;
    private static final int VERSION_3_4_BIT = 5;
    private static final int VERSION_3_8_BIT = 6;
    private static final int VERSION_3_NT_16_BIT = 8;
    private static final int VERSION_3_NT_32_BIT = 9;
    private static final int VERSION_4_16_BIT = 13;
    private static final int VERSION_4_1_BIT = 10;
    private static final int VERSION_4_24_BIT = 14;
    private static final int VERSION_4_32_BIT = 15;
    private static final int VERSION_4_4_BIT = 11;
    private static final int VERSION_4_8_BIT = 12;
    private int alphaMask;
    private long bitmapFileSize;
    private int bitsPerPixel;
    private int blueMask;
    private long compression;
    private int greenMask;
    int height;
    private long imageSize;
    private int imageType;
    private InputStream inputStream;
    private boolean isBottomUp;
    private int numBands;
    private byte[] palette;
    private int redMask;
    int width;
    private long xPelsPerMeter;
    private long yPelsPerMeter;
    public HashMap<String, Object> properties = new HashMap<>();
    private long bitmapOffset = 0;

    public BmpImage(InputStream inputStream, boolean z, int i) throws IOException {
        this.bitmapFileSize = i;
        process(inputStream, z);
    }

    private byte[] decodeRLE(boolean z, byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[this.width * this.height];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < this.height && i3 < bArr.length) {
            try {
                int i6 = i3 + 1;
                int i7 = bArr[i3] & UnsignedBytes.MAX_VALUE;
                if (i7 != 0) {
                    i3 += 2;
                    byte b = bArr[i6];
                    int i8 = b & UnsignedBytes.MAX_VALUE;
                    if (z) {
                        int i9 = i7;
                        while (i9 != 0) {
                            bArr2[i5] = (byte) i8;
                            i9--;
                            i5++;
                        }
                    } else {
                        int i10 = 0;
                        while (i10 < i7) {
                            int i11 = i5 + 1;
                            bArr2[i5] = (byte) ((i10 & 1) == 1 ? b & 15 : (i8 >>> 4) & 15);
                            i10++;
                            i5 = i11;
                        }
                    }
                    i4 += i7;
                } else {
                    int i12 = i3 + 2;
                    byte b2 = bArr[i6];
                    int i13 = b2 & UnsignedBytes.MAX_VALUE;
                    if (i13 == 1) {
                        break;
                    }
                    if (i13 == 0) {
                        i2++;
                        i5 = this.width * i2;
                        i3 = i12;
                        i4 = 0;
                    } else if (i13 != 2) {
                        if (z) {
                            int i14 = i13;
                            while (i14 != 0) {
                                bArr2[i5] = (byte) (bArr[i12] & UnsignedBytes.MAX_VALUE);
                                i14--;
                                i5++;
                                i12++;
                            }
                        } else {
                            int i15 = 0;
                            int i16 = 0;
                            while (i15 < i13) {
                                int i17 = i15 & 1;
                                if (i17 == 0) {
                                    i16 = bArr[i12] & UnsignedBytes.MAX_VALUE;
                                    i12++;
                                }
                                int i18 = i5 + 1;
                                bArr2[i5] = (byte) (i17 == 1 ? i16 & 15 : (i16 >>> 4) & 15);
                                i15++;
                                i5 = i18;
                            }
                        }
                        i4 += i13;
                        if (!z ? (i = b2 & 3) == 1 || i == 2 : (b2 & 1) == 1) {
                            i12++;
                        }
                        i3 = i12;
                    } else {
                        int i19 = i3 + 3;
                        i4 += bArr[i12] & UnsignedBytes.MAX_VALUE;
                        i3 += 4;
                        i2 += bArr[i19] & UnsignedBytes.MAX_VALUE;
                        i5 = (this.width * i2) + i4;
                    }
                }
            } catch (RuntimeException unused) {
            }
        }
        return bArr2;
    }

    private int findMask(int i) {
        for (int i2 = 0; i2 < 32 && (i & 1) != 1; i2++) {
            i >>>= 1;
        }
        return i;
    }

    private int findShift(int i) {
        int i2 = 0;
        while (i2 < 32 && (i & 1) != 1) {
            i >>>= 1;
            i2++;
        }
        return i2;
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

    private byte[] getPalette(int i) {
        byte[] bArr = this.palette;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length / i) * 3];
        int length = bArr.length / i;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int i4 = i2 * 3;
            byte[] bArr3 = this.palette;
            bArr2[i4 + 2] = bArr3[i3];
            bArr2[i4 + 1] = bArr3[i3 + 1];
            bArr2[i4] = bArr3[i3 + 2];
        }
        return bArr2;
    }

    private Image indexedModel(byte[] bArr, int i, int i2) {
        ImgRaw imgRaw = new ImgRaw(this.width, this.height, 1, i, bArr);
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(PdfName.INDEXED);
        pdfArray.add(PdfName.DEVICERGB);
        byte[] palette = getPalette(i2);
        pdfArray.add(new PdfNumber((palette.length / 3) - 1));
        pdfArray.add(new PdfString(palette));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
        imgRaw.setAdditional(pdfDictionary);
        return imgRaw;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x004f  */
    private Image read1632Bit(boolean z) throws IOException {
        int iCeil;
        int iFindMask = findMask(this.redMask);
        int iFindShift = findShift(this.redMask);
        int i = iFindMask + 1;
        int iFindMask2 = findMask(this.greenMask);
        int iFindShift2 = findShift(this.greenMask);
        int i2 = iFindMask2 + 1;
        int iFindMask3 = findMask(this.blueMask);
        int iFindShift3 = findShift(this.blueMask);
        int i3 = iFindMask3 + 1;
        int i4 = this.width;
        byte[] bArr = new byte[this.height * i4 * 3];
        if (z) {
            iCeil = 0;
        } else {
            int i5 = i4 * 16;
            if (i5 % 32 != 0) {
                iCeil = (int) Math.ceil(((double) ((((i5 / 32) + 1) * 32) - i5)) / 8.0d);
            } else {
                iCeil = 0;
            }
        }
        if (this.isBottomUp) {
            int i6 = this.height - 1;
            while (i6 >= 0) {
                int i7 = this.width * 3 * i6;
                int i8 = 0;
                while (i8 < this.width) {
                    int dWord = z ? (int) readDWord(this.inputStream) : readWord(this.inputStream);
                    int i9 = iFindShift;
                    bArr[i7] = (byte) ((((dWord >>> iFindShift) & iFindMask) * 256) / i);
                    int i10 = i7 + 2;
                    bArr[i7 + 1] = (byte) ((((dWord >>> iFindShift2) & iFindMask2) * 256) / i2);
                    i7 += 3;
                    bArr[i10] = (byte) ((((dWord >>> iFindShift3) & iFindMask3) * 256) / i3);
                    i8++;
                    i6 = i6;
                    iFindShift = i9;
                    iFindShift2 = iFindShift2;
                }
                int i11 = iFindShift;
                int i12 = iFindShift2;
                int i13 = i6;
                for (int i14 = 0; i14 < iCeil; i14++) {
                    this.inputStream.read();
                }
                i6 = i13 - 1;
                iFindShift = i11;
                iFindShift2 = i12;
            }
        } else {
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.height) {
                int i17 = 0;
                while (i17 < this.width) {
                    int dWord2 = z ? (int) readDWord(this.inputStream) : readWord(this.inputStream);
                    bArr[i16] = (byte) ((((dWord2 >>> iFindShift) & iFindMask) * 256) / i);
                    int i18 = i16 + 2;
                    bArr[i16 + 1] = (byte) ((((dWord2 >>> iFindShift2) & iFindMask2) * 256) / i2);
                    i16 += 3;
                    bArr[i18] = (byte) ((((dWord2 >>> iFindShift3) & iFindMask3) * 256) / i3);
                    i17++;
                    iFindMask = iFindMask;
                }
                int i19 = iFindMask;
                for (int i20 = 0; i20 < iCeil; i20++) {
                    this.inputStream.read();
                }
                i15++;
                iFindMask = i19;
            }
        }
        return new ImgRaw(this.width, this.height, 3, 8, bArr);
    }

    private Image read1Bit(int i) {
        int i2 = this.width;
        byte[] bArr = new byte[((i2 + 7) / 8) * this.height];
        int iCeil = (int) Math.ceil(((double) i2) / 8.0d);
        int i3 = iCeil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + iCeil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * iCeil, iCeil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * iCeil, iCeil);
                i4++;
            }
        }
        return indexedModel(bArr, 1, i);
    }

    private void read24Bit(byte[] bArr) {
        int i = this.width * 24;
        int iCeil = i % 32 != 0 ? (int) Math.ceil(((double) ((((i / 32) + 1) * 32) - i)) / 8.0d) : 0;
        int i2 = (((this.width * 3) + 3) / 4) * 4 * this.height;
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            try {
                int i4 = this.inputStream.read(bArr2, i3, i2 - i3);
                if (i4 < 0) {
                    break;
                } else {
                    i3 += i4;
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (!this.isBottomUp) {
            int i5 = -iCeil;
            int i6 = 0;
            for (int i7 = 0; i7 < this.height; i7++) {
                i5 += iCeil;
                for (int i8 = 0; i8 < this.width; i8++) {
                    bArr[i6 + 2] = bArr2[i5];
                    int i9 = i5 + 2;
                    bArr[i6 + 1] = bArr2[i5 + 1];
                    i5 += 3;
                    bArr[i6] = bArr2[i9];
                    i6 += 3;
                }
            }
            return;
        }
        int i10 = ((this.width * this.height) * 3) - 1;
        int i11 = -iCeil;
        int i12 = 0;
        while (i12 < this.height) {
            i12++;
            int i13 = (i10 - ((this.width * i12) * 3)) + 1;
            i11 += iCeil;
            for (int i14 = 0; i14 < this.width; i14++) {
                bArr[i13 + 2] = bArr2[i11];
                int i15 = i11 + 2;
                bArr[i13 + 1] = bArr2[i11 + 1];
                i11 += 3;
                bArr[i13] = bArr2[i15];
                i13 += 3;
            }
        }
    }

    private Image read4Bit(int i) {
        int i2 = this.width;
        byte[] bArr = new byte[((i2 + 1) / 2) * this.height];
        int iCeil = (int) Math.ceil(((double) i2) / 2.0d);
        int i3 = iCeil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + iCeil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * iCeil, iCeil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * iCeil, iCeil);
                i4++;
            }
        }
        return indexedModel(bArr, 4, i);
    }

    private Image read8Bit(int i) {
        int i2 = this.width;
        byte[] bArr = new byte[this.height * i2];
        int i3 = i2 * 8;
        int i4 = 0;
        int iCeil = i3 % 32 != 0 ? (int) Math.ceil(((double) ((((i3 / 32) + 1) * 32) - i3)) / 8.0d) : 0;
        int i5 = (this.width + iCeil) * this.height;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            i6 += this.inputStream.read(bArr2, i6, i5 - i6);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i7 = i4 + 1;
                int i8 = this.width;
                System.arraycopy(bArr2, i5 - ((i8 + iCeil) * i7), bArr, i4 * i8, i8);
                i4 = i7;
            }
        } else {
            while (i4 < this.height) {
                int i9 = this.width;
                System.arraycopy(bArr2, (i9 + iCeil) * i4, bArr, i4 * i9, i9);
                i4++;
            }
        }
        return indexedModel(bArr, 8, i);
    }

    private long readDWord(InputStream inputStream) {
        return readUnsignedInt(inputStream);
    }

    private int readInt(InputStream inputStream) {
        int unsignedByte = readUnsignedByte(inputStream);
        int unsignedByte2 = readUnsignedByte(inputStream);
        return (readUnsignedByte(inputStream) << 24) | (readUnsignedByte(inputStream) << 16) | (unsignedByte2 << 8) | unsignedByte;
    }

    private int readLong(InputStream inputStream) {
        return readInt(inputStream);
    }

    private void readPalette(int i) throws IOException {
        if (i == 0) {
            return;
        }
        this.palette = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = this.inputStream.read(this.palette, i2, i - i2);
            if (i3 < 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("incomplete.palette", new Object[0]));
            }
            i2 += i3;
        }
        this.properties.put("palette", this.palette);
    }

    private Image readRLE4() {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            i2 += this.inputStream.read(bArr, i2, i - i2);
        }
        byte[] bArrDecodeRLE = decodeRLE(false, bArr);
        if (this.isBottomUp) {
            int i3 = this.width;
            int i4 = this.height;
            byte[] bArr2 = new byte[i3 * i4];
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                int i7 = this.width;
                int i8 = i6 * i7;
                int i9 = i7 + i5;
                while (i5 != i9) {
                    bArr2[i5] = bArrDecodeRLE[i8];
                    i5++;
                    i8++;
                }
            }
            bArrDecodeRLE = bArr2;
        }
        int i10 = (this.width + 1) / 2;
        byte[] bArr3 = new byte[this.height * i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.height; i13++) {
            for (int i14 = 0; i14 < this.width; i14++) {
                if ((i14 & 1) == 0) {
                    bArr3[(i14 / 2) + i12] = (byte) (bArrDecodeRLE[i11] << 4);
                    i11++;
                } else {
                    int i15 = (i14 / 2) + i12;
                    bArr3[i15] = (byte) (((byte) (bArrDecodeRLE[i11] & 15)) | bArr3[i15]);
                    i11++;
                }
            }
            i12 += i10;
        }
        return indexedModel(bArr3, 4, 4);
    }

    private Image readRLE8() {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            i3 += this.inputStream.read(bArr, i3, i - i3);
        }
        byte[] bArrDecodeRLE = decodeRLE(true, bArr);
        int i4 = this.width;
        int i5 = this.height * i4;
        if (this.isBottomUp) {
            byte[] bArr2 = new byte[bArrDecodeRLE.length];
            while (i2 < this.height) {
                int i6 = i2 + 1;
                System.arraycopy(bArrDecodeRLE, i5 - (i6 * i4), bArr2, i2 * i4, i4);
                i2 = i6;
            }
            bArrDecodeRLE = bArr2;
        }
        return indexedModel(bArrDecodeRLE, 8, 4);
    }

    private int readShort(InputStream inputStream) {
        return (readUnsignedByte(inputStream) << 8) | readUnsignedByte(inputStream);
    }

    private int readUnsignedByte(InputStream inputStream) {
        return inputStream.read() & 255;
    }

    private long readUnsignedInt(InputStream inputStream) {
        return (readUnsignedByte(inputStream) << 24) | (readUnsignedByte(inputStream) << 16) | (readUnsignedByte(inputStream) << 8) | readUnsignedByte(inputStream);
    }

    private int readUnsignedShort(InputStream inputStream) {
        return ((readUnsignedByte(inputStream) << 8) | readUnsignedByte(inputStream)) & 65535;
    }

    private int readWord(InputStream inputStream) {
        return readUnsignedShort(inputStream);
    }

    public void process(InputStream inputStream, boolean z) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (z || (inputStream instanceof BufferedInputStream)) {
            this.inputStream = inputStream;
        } else {
            this.inputStream = new BufferedInputStream(inputStream);
        }
        if (!z) {
            if (readUnsignedByte(this.inputStream) != 66 || readUnsignedByte(this.inputStream) != 77) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.magic.value.for.bmp.file", new Object[0]));
            }
            this.bitmapFileSize = readDWord(this.inputStream);
            readWord(this.inputStream);
            readWord(this.inputStream);
            this.bitmapOffset = readDWord(this.inputStream);
        }
        long dWord = readDWord(this.inputStream);
        if (dWord == 12) {
            this.width = readWord(this.inputStream);
            this.height = readWord(this.inputStream);
        } else {
            this.width = readLong(this.inputStream);
            this.height = readLong(this.inputStream);
        }
        int word = readWord(this.inputStream);
        this.bitsPerPixel = readWord(this.inputStream);
        this.properties.put("color_planes", Integer.valueOf(word));
        this.properties.put("bits_per_pixel", Integer.valueOf(this.bitsPerPixel));
        this.numBands = 3;
        if (this.bitmapOffset == 0) {
            this.bitmapOffset = dWord;
        }
        if (dWord == 12) {
            this.properties.put("bmp_version", "BMP v. 2.x");
            int i6 = this.bitsPerPixel;
            if (i6 == 1) {
                this.imageType = 0;
            } else if (i6 == 4) {
                this.imageType = 1;
            } else if (i6 == 8) {
                this.imageType = 2;
            } else if (i6 == 24) {
                this.imageType = 3;
            }
            long j = this.bitmapOffset;
            int i7 = ((int) (((j - 14) - dWord) / 3)) * 3;
            if (j == dWord) {
                int i8 = this.imageType;
                if (i8 == 0) {
                    i5 = 6;
                } else if (i8 == 1) {
                    i5 = 48;
                } else if (i8 != 2) {
                    i5 = i8 != 3 ? i7 : 0;
                } else {
                    i5 = ViewUtils.EDGE_TO_EDGE_FLAGS;
                }
                this.bitmapOffset = dWord + ((long) i5);
                i7 = i5;
            }
            readPalette(i7);
        } else {
            this.compression = readDWord(this.inputStream);
            this.imageSize = readDWord(this.inputStream);
            this.xPelsPerMeter = readLong(this.inputStream);
            this.yPelsPerMeter = readLong(this.inputStream);
            long dWord2 = readDWord(this.inputStream);
            long dWord3 = readDWord(this.inputStream);
            int i9 = (int) this.compression;
            if (i9 == 0) {
                this.properties.put("compression", "BI_RGB");
            } else if (i9 == 1) {
                this.properties.put("compression", "BI_RLE8");
            } else if (i9 == 2) {
                this.properties.put("compression", "BI_RLE4");
            } else if (i9 == 3) {
                this.properties.put("compression", "BI_BITFIELDS");
            }
            this.properties.put("x_pixels_per_meter", Long.valueOf(this.xPelsPerMeter));
            this.properties.put("y_pixels_per_meter", Long.valueOf(this.yPelsPerMeter));
            this.properties.put("colors_used", Long.valueOf(dWord2));
            this.properties.put("colors_important", Long.valueOf(dWord3));
            if (dWord == 40 || dWord == 52 || dWord == 56) {
                int i10 = (int) this.compression;
                if (i10 == 0 || i10 == 1 || i10 == 2) {
                    int i11 = this.bitsPerPixel;
                    if (i11 == 1) {
                        this.imageType = 4;
                    } else if (i11 == 4) {
                        this.imageType = 5;
                    } else if (i11 == 8) {
                        this.imageType = 6;
                    } else if (i11 == 24) {
                        this.imageType = 7;
                    } else if (i11 == 16) {
                        this.imageType = 8;
                        this.redMask = 31744;
                        this.greenMask = 992;
                        this.blueMask = 31;
                        this.properties.put("red_mask", 31744);
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    } else if (i11 == 32) {
                        this.imageType = 9;
                        this.redMask = 16711680;
                        this.greenMask = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                        this.blueMask = 255;
                        this.properties.put("red_mask", 16711680);
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    }
                    if (dWord >= 52) {
                        this.redMask = (int) readDWord(this.inputStream);
                        this.greenMask = (int) readDWord(this.inputStream);
                        this.blueMask = (int) readDWord(this.inputStream);
                        this.properties.put("red_mask", Integer.valueOf(this.redMask));
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    }
                    if (dWord == 56) {
                        int dWord4 = (int) readDWord(this.inputStream);
                        this.alphaMask = dWord4;
                        this.properties.put("alpha_mask", Integer.valueOf(dWord4));
                    }
                    long j2 = this.bitmapOffset;
                    int i12 = ((int) (((j2 - 14) - dWord) / 4)) * 4;
                    if (j2 == dWord) {
                        int i13 = this.imageType;
                        if (i13 != 4) {
                            if (i13 != 5) {
                                if (i13 != 6) {
                                    i12 = 0;
                                } else if (dWord2 == 0) {
                                    dWord2 = 256;
                                }
                                this.bitmapOffset = dWord + ((long) i12);
                            } else if (dWord2 == 0) {
                                dWord2 = 16;
                            }
                        } else if (dWord2 == 0) {
                            dWord2 = 2;
                        }
                        i12 = ((int) dWord2) * 4;
                        this.bitmapOffset = dWord + ((long) i12);
                    }
                    readPalette(i12);
                    this.properties.put("bmp_version", "BMP v. 3.x");
                } else {
                    if (i10 != 3) {
                        throw new RuntimeException("Invalid compression specified in BMP file.");
                    }
                    int i14 = this.bitsPerPixel;
                    if (i14 == 16) {
                        this.imageType = 8;
                    } else if (i14 == 32) {
                        this.imageType = 9;
                    }
                    this.redMask = (int) readDWord(this.inputStream);
                    this.greenMask = (int) readDWord(this.inputStream);
                    this.blueMask = (int) readDWord(this.inputStream);
                    if (dWord == 56) {
                        int dWord5 = (int) readDWord(this.inputStream);
                        this.alphaMask = dWord5;
                        this.properties.put("alpha_mask", Integer.valueOf(dWord5));
                    }
                    this.properties.put("red_mask", Integer.valueOf(this.redMask));
                    this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                    this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    if (dWord2 != 0) {
                        readPalette(((int) dWord2) * 4);
                    }
                    this.properties.put("bmp_version", "BMP v. 3.x NT");
                }
            } else {
                if (dWord != 108) {
                    this.properties.put("bmp_version", "BMP v. 5.x");
                    throw new RuntimeException("BMP version 5 not implemented yet.");
                }
                this.properties.put("bmp_version", "BMP v. 4.x");
                this.redMask = (int) readDWord(this.inputStream);
                this.greenMask = (int) readDWord(this.inputStream);
                this.blueMask = (int) readDWord(this.inputStream);
                this.alphaMask = (int) readDWord(this.inputStream);
                long dWord6 = readDWord(this.inputStream);
                int i15 = readLong(this.inputStream);
                int i16 = readLong(this.inputStream);
                int i17 = readLong(this.inputStream);
                int i18 = readLong(this.inputStream);
                int i19 = readLong(this.inputStream);
                int i20 = readLong(this.inputStream);
                int i21 = readLong(this.inputStream);
                int i22 = readLong(this.inputStream);
                int i23 = readLong(this.inputStream);
                long dWord7 = readDWord(this.inputStream);
                long dWord8 = readDWord(this.inputStream);
                long dWord9 = readDWord(this.inputStream);
                int i24 = this.bitsPerPixel;
                if (i24 == 1) {
                    this.imageType = 10;
                } else if (i24 == 4) {
                    this.imageType = 11;
                } else if (i24 == 8) {
                    this.imageType = 12;
                } else if (i24 == 16) {
                    this.imageType = 13;
                    if (((int) this.compression) == 0) {
                        this.redMask = 31744;
                        this.greenMask = 992;
                        this.blueMask = 31;
                    }
                } else if (i24 == 24) {
                    this.imageType = 14;
                } else if (i24 == 32) {
                    this.imageType = 15;
                    if (((int) this.compression) == 0) {
                        this.redMask = 16711680;
                        this.greenMask = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                        this.blueMask = 255;
                    }
                }
                this.properties.put("red_mask", Integer.valueOf(this.redMask));
                this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                this.properties.put("alpha_mask", Integer.valueOf(this.alphaMask));
                long j3 = this.bitmapOffset;
                int i25 = ((int) (((j3 - 14) - dWord) / 4)) * 4;
                if (j3 == dWord) {
                    switch (this.imageType) {
                        case 10:
                            if (dWord2 == 0) {
                                dWord2 = 2;
                            }
                            i = (int) dWord2;
                            i25 = i * 4;
                            break;
                        case 11:
                            if (dWord2 == 0) {
                                dWord2 = 16;
                            }
                            i = (int) dWord2;
                            i25 = i * 4;
                            break;
                        case 12:
                            if (dWord2 == 0) {
                                dWord2 = 256;
                            }
                            i = (int) dWord2;
                            i25 = i * 4;
                            break;
                        default:
                            i25 = 0;
                            break;
                    }
                    this.bitmapOffset = dWord + ((long) i25);
                }
                readPalette(i25);
                int i26 = (int) dWord6;
                if (i26 == 0) {
                    this.properties.put("color_space", "LCS_CALIBRATED_RGB");
                    this.properties.put("redX", Integer.valueOf(i15));
                    this.properties.put("redY", Integer.valueOf(i16));
                    this.properties.put("redZ", Integer.valueOf(i17));
                    this.properties.put("greenX", Integer.valueOf(i18));
                    this.properties.put("greenY", Integer.valueOf(i19));
                    this.properties.put("greenZ", Integer.valueOf(i20));
                    this.properties.put("blueX", Integer.valueOf(i21));
                    this.properties.put("blueY", Integer.valueOf(i22));
                    this.properties.put("blueZ", Integer.valueOf(i23));
                    this.properties.put("gamma_red", Long.valueOf(dWord7));
                    this.properties.put("gamma_green", Long.valueOf(dWord8));
                    this.properties.put("gamma_blue", Long.valueOf(dWord9));
                    throw new RuntimeException("Not implemented yet.");
                }
                if (i26 == 1) {
                    this.properties.put("color_space", "LCS_sRGB");
                } else if (i26 == 2) {
                    this.properties.put("color_space", "LCS_CMYK");
                    throw new RuntimeException("Not implemented yet.");
                }
            }
        }
        int i27 = this.height;
        if (i27 > 0) {
            i2 = 1;
            this.isBottomUp = true;
            i3 = 0;
        } else {
            i2 = 1;
            i3 = 0;
            this.isBottomUp = false;
            this.height = Math.abs(i27);
        }
        int i28 = this.bitsPerPixel;
        if (i28 != i2 && i28 != 4 && i28 != 8) {
            if (i28 == 16) {
                this.numBands = 3;
                return;
            } else if (i28 == 32) {
                this.numBands = this.alphaMask == 0 ? 3 : 4;
                return;
            } else {
                this.numBands = 3;
                return;
            }
        }
        this.numBands = 1;
        int i29 = this.imageType;
        if (i29 == 0 || i29 == 1 || i29 == 2) {
            int length = this.palette.length / 3;
            i4 = length <= 256 ? length : 256;
            byte[] bArr = new byte[i4];
            byte[] bArr2 = new byte[i4];
            byte[] bArr3 = new byte[i4];
            while (i3 < i4) {
                int i30 = i3 * 3;
                byte[] bArr4 = this.palette;
                bArr3[i3] = bArr4[i30];
                bArr2[i3] = bArr4[i30 + 1];
                bArr[i3] = bArr4[i30 + 2];
                i3++;
            }
            return;
        }
        int length2 = this.palette.length / 4;
        i4 = length2 <= 256 ? length2 : 256;
        byte[] bArr5 = new byte[i4];
        byte[] bArr6 = new byte[i4];
        byte[] bArr7 = new byte[i4];
        while (i3 < i4) {
            int i31 = i3 * 4;
            byte[] bArr8 = this.palette;
            bArr7[i3] = bArr8[i31];
            bArr6[i3] = bArr8[i31 + 1];
            bArr5[i3] = bArr8[i31 + 2];
            i3++;
        }
    }

    public static Image getImage(InputStream inputStream) {
        return getImage(inputStream, false, 0);
    }

    public static Image getImage(InputStream inputStream, boolean z, int i) {
        BmpImage bmpImage = new BmpImage(inputStream, z, i);
        try {
            Image image = bmpImage.getImage();
            image.setDpi((int) ((bmpImage.xPelsPerMeter * 0.0254d) + 0.5d), (int) ((bmpImage.yPelsPerMeter * 0.0254d) + 0.5d));
            image.setOriginalType(4);
            return image;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static Image getImage(String str) {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) {
        Image image = getImage(new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    private Image getImage() {
        switch (this.imageType) {
            case 0:
                return read1Bit(3);
            case 1:
                return read4Bit(3);
            case 2:
                return read8Bit(3);
            case 3:
                byte[] bArr = new byte[this.width * this.height * 3];
                read24Bit(bArr);
                return new ImgRaw(this.width, this.height, 3, 8, bArr);
            case 4:
                return read1Bit(4);
            case 5:
                int i = (int) this.compression;
                if (i == 0) {
                    return read4Bit(4);
                }
                if (i == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 6:
                int i2 = (int) this.compression;
                if (i2 == 0) {
                    return read8Bit(4);
                }
                if (i2 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 7:
                byte[] bArr2 = new byte[this.width * this.height * 3];
                read24Bit(bArr2);
                return new ImgRaw(this.width, this.height, 3, 8, bArr2);
            case 8:
                return read1632Bit(false);
            case 9:
                return read1632Bit(true);
            case 10:
                return read1Bit(4);
            case 11:
                int i3 = (int) this.compression;
                if (i3 == 0) {
                    return read4Bit(4);
                }
                if (i3 == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 12:
                int i4 = (int) this.compression;
                if (i4 == 0) {
                    return read8Bit(4);
                }
                if (i4 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 13:
                return read1632Bit(false);
            case 14:
                byte[] bArr3 = new byte[this.width * this.height * 3];
                read24Bit(bArr3);
                return new ImgRaw(this.width, this.height, 3, 8, bArr3);
            case 15:
                return read1632Bit(true);
            default:
                return null;
        }
    }
}
