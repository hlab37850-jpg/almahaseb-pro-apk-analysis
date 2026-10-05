package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidImageException;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public class TiffImage {
    public static Image ProcessExtraSamples(DeflaterOutputStream deflaterOutputStream, DeflaterOutputStream deflaterOutputStream2, byte[] bArr, int i, int i2, int i3, int i4) throws IOException {
        if (i2 != 8) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("extra.samples.are.not.supported", new Object[0]));
        }
        int i5 = i3 * i4;
        byte[] bArr2 = new byte[i5];
        int i6 = i5 * i;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i6) {
            int i10 = 0;
            while (i10 < i - 1) {
                bArr[i8] = bArr[i7 + i10];
                i10++;
                i8++;
            }
            i7 += i;
            bArr2[i9] = bArr[i7 - 1];
            i9++;
        }
        deflaterOutputStream.write(bArr, 0, i8);
        deflaterOutputStream2.write(bArr2, 0, i9);
        return null;
    }

    public static void applyPredictor(byte[] bArr, int i, int i2, int i3, int i4) {
        if (i != 2) {
            return;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = ((i5 * i2) + 1) * i4;
            for (int i7 = i4; i7 < i2 * i4; i7++) {
                bArr[i6] = (byte) (bArr[i6] + bArr[i6 - i4]);
                i6++;
            }
        }
    }

    public static void decodePackbits(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i < bArr2.length) {
            try {
                int i3 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0 && b <= 127) {
                    i2 = i3;
                    int i4 = 0;
                    while (i4 < b + 1) {
                        bArr2[i] = bArr[i2];
                        i4++;
                        i++;
                        i2++;
                    }
                } else if (b > -1 || b < -127) {
                    i2 += 2;
                } else {
                    i2 += 2;
                    byte b2 = bArr[i3];
                    int i5 = 0;
                    while (i5 < (-b) + 1) {
                        int i6 = i + 1;
                        bArr2[i] = b2;
                        i5++;
                        i = i6;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static long[] getArrayLongShort(TIFFDirectory tIFFDirectory, int i) {
        TIFFField field = tIFFDirectory.getField(i);
        if (field == null) {
            return null;
        }
        if (field.getType() == 4) {
            return field.getAsLongs();
        }
        char[] asChars = field.getAsChars();
        long[] jArr = new long[asChars.length];
        for (int i2 = 0; i2 < asChars.length; i2++) {
            jArr[i2] = asChars[i2];
        }
        return jArr;
    }

    public static int getDpi(TIFFField tIFFField, int i) {
        double d;
        if (tIFFField == null) {
            return 0;
        }
        long[] asRational = tIFFField.getAsRational(0);
        float f = asRational[0] / asRational[1];
        if (i == 1 || i == 2) {
            d = f;
        } else {
            if (i != 3) {
                return 0;
            }
            d = ((double) f) * 2.54d;
        }
        return (int) (d + 0.5d);
    }

    public static int getNumberOfPages(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            return TIFFDirectory.getNumDirectories(randomAccessFileOrArray);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0185 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01bb A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01cc A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0203  */
    /* JADX WARN: Code duplicated, block: B:113:0x0206  */
    /* JADX WARN: Code duplicated, block: B:115:0x0209  */
    /* JADX WARN: Code duplicated, block: B:117:0x020e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0212  */
    /* JADX WARN: Code duplicated, block: B:120:0x0222  */
    /* JADX WARN: Code duplicated, block: B:129:0x0244  */
    /* JADX WARN: Code duplicated, block: B:147:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:155:0x032f A[Catch: Exception -> 0x0033, RuntimeException -> 0x0332, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x0332, blocks: (B:153:0x031c, B:155:0x032f), top: B:170:0x031c }] */
    /* JADX WARN: Code duplicated, block: B:159:0x033b A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x031c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0083 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0089  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b6 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00d8 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f0 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x010b A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0112  */
    /* JADX WARN: Code duplicated, block: B:73:0x0126  */
    /* JADX WARN: Code duplicated, block: B:76:0x012e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0131  */
    /* JADX WARN: Code duplicated, block: B:80:0x0134  */
    /* JADX WARN: Code duplicated, block: B:82:0x0139  */
    /* JADX WARN: Code duplicated, block: B:83:0x013e A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0146 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x014e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0152 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x015c A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0166  */
    /* JADX WARN: Code duplicated, block: B:93:0x016b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0173 A[Catch: Exception -> 0x0033, TryCatch #4 {Exception -> 0x0033, blocks: (B:4:0x000b, B:6:0x0019, B:11:0x002e, B:15:0x0036, B:17:0x0041, B:32:0x006d, B:34:0x0083, B:36:0x008a, B:39:0x00a2, B:43:0x00ae, B:45:0x00b6, B:52:0x00c5, B:54:0x00d5, B:56:0x00d8, B:58:0x00de, B:64:0x0100, B:66:0x010b, B:68:0x0114, B:70:0x011c, B:104:0x018d, B:151:0x030b, B:153:0x031c, B:155:0x032f, B:157:0x0333, B:159:0x033b, B:105:0x01bb, B:106:0x01c9, B:108:0x01cc, B:149:0x02d2, B:148:0x02cc, B:121:0x0231, B:127:0x023c, B:128:0x0243, B:130:0x0252, B:135:0x026a, B:134:0x0267, B:141:0x027e, B:143:0x02b5, B:145:0x02bb, B:146:0x02bc, B:150:0x02ec, B:83:0x013e, B:85:0x0146, B:88:0x0152, B:90:0x015c, B:94:0x016d, B:96:0x0173, B:101:0x0185, B:63:0x00f0, B:161:0x033f, B:162:0x034d), top: B:176:0x000b, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x017d  */
    /* JADX WARN: Code duplicated, block: B:99:0x017f  */
    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, boolean z, int i, boolean z2) {
        int i2;
        float f;
        int fieldAsLong;
        int fieldAsLong2;
        int fieldAsLong3;
        int dpi;
        int dpi2;
        int i3;
        int i4;
        float f2;
        int fieldAsLong4;
        int i5;
        long[] arrayLongShort;
        long[] arrayLongShort2;
        long j;
        long[] jArr;
        TIFFField field;
        long asLong;
        int i6;
        int i7;
        long asLong2;
        int i8;
        float f3;
        CCITTG4Encoder cCITTG4Encoder;
        float f4;
        int i9;
        int i10;
        float f5;
        float f6;
        int i11;
        Image image;
        int i12;
        byte[] bArr;
        CCITTG4Encoder cCITTG4Encoder2;
        int i13;
        int iMin;
        TIFFFaxDecoder tIFFFaxDecoder;
        byte[] bArr2;
        ICC_Profile iCC_Profile;
        int i14;
        TIFFField field2;
        long asLong3;
        int i15;
        TIFFField field3;
        long j2;
        float f7;
        int i16 = 0;
        if (i < 1) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.page.number.must.be.gt.eq.1", new Object[0]));
        }
        try {
            TIFFDirectory tIFFDirectory = new TIFFDirectory(randomAccessFileOrArray, i - 1);
            if (tIFFDirectory.isTagPresent(322)) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("tiles.are.not.supported", new Object[0]));
            }
            int fieldAsLong5 = (int) tIFFDirectory.getFieldAsLong(259);
            if (fieldAsLong5 != 2 && fieldAsLong5 != 3 && fieldAsLong5 != 4 && fieldAsLong5 != 32771) {
                return getTiffImageColor(tIFFDirectory, randomAccessFileOrArray);
            }
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ORIENTATION)) {
                i2 = fieldAsLong5;
                int fieldAsLong6 = (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_ORIENTATION);
                if (fieldAsLong6 == 3 || fieldAsLong6 == 4) {
                    f = 3.1415927f;
                } else if (fieldAsLong6 == 5 || fieldAsLong6 == 8) {
                    f = 1.5707964f;
                } else if (fieldAsLong6 == 6 || fieldAsLong6 == 7) {
                    f = -1.5707964f;
                }
                fieldAsLong = (int) tIFFDirectory.getFieldAsLong(257);
                fieldAsLong2 = (int) tIFFDirectory.getFieldAsLong(256);
                if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_RESOLUTIONUNIT)) {
                    fieldAsLong3 = (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_RESOLUTIONUNIT);
                } else {
                    fieldAsLong3 = 2;
                }
                dpi = getDpi(tIFFDirectory.getField(TIFFConstants.TIFFTAG_XRESOLUTION), fieldAsLong3);
                dpi2 = getDpi(tIFFDirectory.getField(TIFFConstants.TIFFTAG_YRESOLUTION), fieldAsLong3);
                if (fieldAsLong3 == 1) {
                    if (dpi2 != 0) {
                        f7 = dpi / dpi2;
                    } else {
                        f7 = 0.0f;
                    }
                    f2 = f7;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i3 = dpi2;
                    i4 = dpi;
                    f2 = 0.0f;
                }
                if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ROWSPERSTRIP)) {
                    fieldAsLong4 = (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_ROWSPERSTRIP);
                } else {
                    fieldAsLong4 = fieldAsLong;
                }
                if (fieldAsLong4 > 0 || fieldAsLong4 > fieldAsLong) {
                    i5 = fieldAsLong;
                } else {
                    i5 = fieldAsLong4;
                }
                arrayLongShort = getArrayLongShort(tIFFDirectory, TIFFConstants.TIFFTAG_STRIPOFFSETS);
                arrayLongShort2 = getArrayLongShort(tIFFDirectory, TIFFConstants.TIFFTAG_STRIPBYTECOUNTS);
                j = 0;
                if (arrayLongShort2 == null) {
                    if (fieldAsLong == i5) {
                        arrayLongShort2 = new long[]{randomAccessFileOrArray.length() - ((long) ((int) arrayLongShort[0]))};
                    }
                } else if (arrayLongShort2.length == 1) {
                    j2 = arrayLongShort2[0];
                    if (j2 != 0 || j2 + arrayLongShort[0] > randomAccessFileOrArray.length()) {
                        if (fieldAsLong == i5) {
                            arrayLongShort2 = new long[]{randomAccessFileOrArray.length() - ((long) ((int) arrayLongShort[0]))};
                        }
                    }
                }
                jArr = arrayLongShort2;
                field = tIFFDirectory.getField(TIFFConstants.TIFFTAG_FILLORDER);
                if (field != null) {
                    asLong = field.getAsLong(0);
                } else {
                    asLong = 1;
                }
                if (tIFFDirectory.isTagPresent(262) || tIFFDirectory.getFieldAsLong(262) != 1) {
                    i6 = 0;
                } else {
                    i6 = 1;
                }
                i7 = i2;
                if (i7 == 2) {
                    i6 |= 10;
                    asLong2 = 0;
                    i8 = 257;
                } else if (i7 != 3) {
                    i14 = i6 | 12;
                    field2 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_GROUP3OPTIONS);
                    if (field2 != null) {
                        asLong3 = field2.getAsLong(0);
                        if ((asLong3 & 1) != 0) {
                            i15 = 258;
                        } else {
                            i15 = 257;
                        }
                        if ((asLong3 & 4) != 0) {
                            i6 |= 14;
                        } else {
                            i6 = i14;
                        }
                        i8 = i15;
                        asLong2 = 0;
                        j = asLong3;
                    } else {
                        i6 = i14;
                        asLong2 = 0;
                        i8 = 257;
                    }
                } else if (i7 != 4) {
                    field3 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_GROUP4OPTIONS);
                    if (field3 != null) {
                        asLong2 = field3.getAsLong(0);
                    } else {
                        asLong2 = 0;
                    }
                    i8 = 256;
                } else if (i7 != 32771) {
                    i6 = i6;
                    asLong2 = 0;
                    i8 = 0;
                } else {
                    i6 |= 10;
                    asLong2 = 0;
                    i8 = 257;
                }
                if (z2 || i5 != fieldAsLong) {
                    f3 = f;
                    cCITTG4Encoder = new CCITTG4Encoder(fieldAsLong2);
                    f4 = f2;
                    i9 = fieldAsLong;
                    while (i16 < arrayLongShort.length) {
                        i12 = i4;
                        int i17 = fieldAsLong;
                        bArr = new byte[(int) jArr[i16]];
                        cCITTG4Encoder2 = cCITTG4Encoder;
                        i13 = i3;
                        randomAccessFileOrArray.seek(arrayLongShort[i16]);
                        randomAccessFileOrArray.readFully(bArr);
                        iMin = Math.min(i5, i9);
                        int i18 = i16;
                        int i19 = i6;
                        long j3 = asLong;
                        tIFFFaxDecoder = new TIFFFaxDecoder(j3, fieldAsLong2, iMin);
                        tIFFFaxDecoder.setRecoverFromImageError(z);
                        asLong = j3;
                        bArr2 = new byte[((fieldAsLong2 + 7) / 8) * iMin];
                        if (i7 != 2) {
                            if (i7 != 3) {
                                if (i7 == 4) {
                                    try {
                                        tIFFFaxDecoder.decodeT6(bArr2, bArr, 0, iMin, asLong2);
                                    } catch (InvalidImageException e) {
                                        if (!z) {
                                            throw e;
                                        }
                                    }
                                    cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                                    cCITTG4Encoder2 = cCITTG4Encoder2;
                                } else if (i7 != 32771) {
                                    cCITTG4Encoder2 = cCITTG4Encoder2;
                                }
                                arrayLongShort = arrayLongShort;
                                i13 = i13;
                                f3 = f3;
                                f4 = f4;
                                i12 = i12;
                                i9 -= i5;
                                i16 = i18 + 1;
                                f3 = f3;
                                i3 = i13;
                                cCITTG4Encoder = cCITTG4Encoder2;
                                f4 = f4;
                                i4 = i12;
                                fieldAsLong = i17;
                                i8 = i8;
                                arrayLongShort = arrayLongShort;
                                i6 = i19;
                            } else {
                                cCITTG4Encoder2 = cCITTG4Encoder2;
                                try {
                                    tIFFFaxDecoder.decode2D(bArr2, bArr, 0, iMin, j);
                                } catch (RuntimeException e2) {
                                    j ^= 4;
                                    try {
                                        tIFFFaxDecoder.decode2D(bArr2, bArr, 0, iMin, j);
                                    } catch (RuntimeException unused) {
                                        if (z == 0 || i5 == 1) {
                                            throw e2;
                                        }
                                        byte[] bArr3 = new byte[(int) jArr[0]];
                                        randomAccessFileOrArray.seek(arrayLongShort[0]);
                                        randomAccessFileOrArray.readFully(bArr3);
                                        Image image2 = Image.getInstance(fieldAsLong2, i17, false, i8, i19, bArr3);
                                        image2.setInverted(true);
                                        image2.setDpi(i12, i13);
                                        image2.setXYRatio(f4);
                                        image2.setOriginalType(5);
                                        if (f3 != 0.0f) {
                                            image2.setInitialRotation(f3);
                                        }
                                        return image2;
                                    }
                                }
                                cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                            }
                            arrayLongShort = arrayLongShort;
                            i13 = i13;
                            f3 = f3;
                            f4 = f4;
                            i12 = i12;
                            i9 -= i5;
                            i16 = i18 + 1;
                            f3 = f3;
                            i3 = i13;
                            cCITTG4Encoder = cCITTG4Encoder2;
                            f4 = f4;
                            i4 = i12;
                            fieldAsLong = i17;
                            i8 = i8;
                            arrayLongShort = arrayLongShort;
                            i6 = i19;
                        }
                        tIFFFaxDecoder.decode1D(bArr2, bArr, 0, iMin);
                        cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                        i9 -= i5;
                        i16 = i18 + 1;
                        f3 = f3;
                        i3 = i13;
                        cCITTG4Encoder = cCITTG4Encoder2;
                        f4 = f4;
                        i4 = i12;
                        fieldAsLong = i17;
                        i8 = i8;
                        arrayLongShort = arrayLongShort;
                        i6 = i19;
                    }
                    i10 = i3;
                    int i20 = fieldAsLong;
                    f5 = f3;
                    f6 = f4;
                    i11 = i4;
                    image = Image.getInstance(fieldAsLong2, i20, false, 256, i6 & 1, cCITTG4Encoder.close());
                } else {
                    byte[] bArr4 = new byte[(int) jArr[0]];
                    randomAccessFileOrArray.seek(arrayLongShort[0]);
                    randomAccessFileOrArray.readFully(bArr4);
                    image = Image.getInstance(fieldAsLong2, fieldAsLong, false, i8, i6, bArr4);
                    image.setInverted(true);
                    i10 = i3;
                    f6 = f2;
                    i11 = i4;
                    f5 = f;
                }
                image.setDpi(i11, i10);
                image.setXYRatio(f6);
                if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                    try {
                        iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                        if (iCC_Profile.getNumComponents() == 1) {
                            image.tagICC(iCC_Profile);
                        }
                    } catch (RuntimeException unused2) {
                    }
                }
                image.setOriginalType(5);
                if (f5 != 0.0f) {
                    image.setInitialRotation(f5);
                }
                return image;
            }
            i2 = fieldAsLong5;
            f = 0.0f;
            fieldAsLong = (int) tIFFDirectory.getFieldAsLong(257);
            fieldAsLong2 = (int) tIFFDirectory.getFieldAsLong(256);
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_RESOLUTIONUNIT)) {
                fieldAsLong3 = (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_RESOLUTIONUNIT);
            } else {
                fieldAsLong3 = 2;
            }
            dpi = getDpi(tIFFDirectory.getField(TIFFConstants.TIFFTAG_XRESOLUTION), fieldAsLong3);
            dpi2 = getDpi(tIFFDirectory.getField(TIFFConstants.TIFFTAG_YRESOLUTION), fieldAsLong3);
            if (fieldAsLong3 == 1) {
                if (dpi2 != 0) {
                    f7 = dpi / dpi2;
                } else {
                    f7 = 0.0f;
                }
                f2 = f7;
                i3 = 0;
                i4 = 0;
            } else {
                i3 = dpi2;
                i4 = dpi;
                f2 = 0.0f;
            }
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ROWSPERSTRIP)) {
                fieldAsLong4 = (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_ROWSPERSTRIP);
            } else {
                fieldAsLong4 = fieldAsLong;
            }
            if (fieldAsLong4 > 0) {
                i5 = fieldAsLong;
            } else {
                i5 = fieldAsLong;
            }
            arrayLongShort = getArrayLongShort(tIFFDirectory, TIFFConstants.TIFFTAG_STRIPOFFSETS);
            arrayLongShort2 = getArrayLongShort(tIFFDirectory, TIFFConstants.TIFFTAG_STRIPBYTECOUNTS);
            j = 0;
            if (arrayLongShort2 == null) {
                if (fieldAsLong == i5) {
                    arrayLongShort2 = new long[]{randomAccessFileOrArray.length() - ((long) ((int) arrayLongShort[0]))};
                }
            } else if (arrayLongShort2.length == 1) {
                j2 = arrayLongShort2[0];
                if (j2 != 0) {
                    if (fieldAsLong == i5) {
                        arrayLongShort2 = new long[]{randomAccessFileOrArray.length() - ((long) ((int) arrayLongShort[0]))};
                    }
                } else if (fieldAsLong == i5) {
                    arrayLongShort2 = new long[]{randomAccessFileOrArray.length() - ((long) ((int) arrayLongShort[0]))};
                }
            }
            jArr = arrayLongShort2;
            field = tIFFDirectory.getField(TIFFConstants.TIFFTAG_FILLORDER);
            if (field != null) {
                asLong = field.getAsLong(0);
            } else {
                asLong = 1;
            }
            if (tIFFDirectory.isTagPresent(262)) {
                i6 = 0;
            } else {
                i6 = 0;
            }
            i7 = i2;
            if (i7 == 2) {
                i6 |= 10;
                asLong2 = 0;
                i8 = 257;
            } else if (i7 != 3) {
                i14 = i6 | 12;
                field2 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_GROUP3OPTIONS);
                if (field2 != null) {
                    asLong3 = field2.getAsLong(0);
                    if ((asLong3 & 1) != 0) {
                        i15 = 258;
                    } else {
                        i15 = 257;
                    }
                    if ((asLong3 & 4) != 0) {
                        i6 |= 14;
                    } else {
                        i6 = i14;
                    }
                    i8 = i15;
                    asLong2 = 0;
                    j = asLong3;
                } else {
                    i6 = i14;
                    asLong2 = 0;
                    i8 = 257;
                }
            } else if (i7 != 4) {
                field3 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_GROUP4OPTIONS);
                if (field3 != null) {
                    asLong2 = field3.getAsLong(0);
                } else {
                    asLong2 = 0;
                }
                i8 = 256;
            } else if (i7 != 32771) {
                i6 = i6;
                asLong2 = 0;
                i8 = 0;
            } else {
                i6 |= 10;
                asLong2 = 0;
                i8 = 257;
            }
            if (z2) {
                f3 = f;
                cCITTG4Encoder = new CCITTG4Encoder(fieldAsLong2);
                f4 = f2;
                i9 = fieldAsLong;
                while (i16 < arrayLongShort.length) {
                    i12 = i4;
                    int i110 = fieldAsLong;
                    bArr = new byte[(int) jArr[i16]];
                    cCITTG4Encoder2 = cCITTG4Encoder;
                    i13 = i3;
                    randomAccessFileOrArray.seek(arrayLongShort[i16]);
                    randomAccessFileOrArray.readFully(bArr);
                    iMin = Math.min(i5, i9);
                    int i111 = i16;
                    int i112 = i6;
                    long j4 = asLong;
                    tIFFFaxDecoder = new TIFFFaxDecoder(j4, fieldAsLong2, iMin);
                    tIFFFaxDecoder.setRecoverFromImageError(z);
                    asLong = j4;
                    bArr2 = new byte[((fieldAsLong2 + 7) / 8) * iMin];
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 4) {
                                tIFFFaxDecoder.decodeT6(bArr2, bArr, 0, iMin, asLong2);
                                cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                                cCITTG4Encoder2 = cCITTG4Encoder2;
                            } else if (i7 != 32771) {
                                cCITTG4Encoder2 = cCITTG4Encoder2;
                            }
                            arrayLongShort = arrayLongShort;
                            i13 = i13;
                            f3 = f3;
                            f4 = f4;
                            i12 = i12;
                            i9 -= i5;
                            i16 = i111 + 1;
                            f3 = f3;
                            i3 = i13;
                            cCITTG4Encoder = cCITTG4Encoder2;
                            f4 = f4;
                            i4 = i12;
                            fieldAsLong = i110;
                            i8 = i8;
                            arrayLongShort = arrayLongShort;
                            i6 = i112;
                        } else {
                            cCITTG4Encoder2 = cCITTG4Encoder2;
                            tIFFFaxDecoder.decode2D(bArr2, bArr, 0, iMin, j);
                            cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                        }
                        arrayLongShort = arrayLongShort;
                        i13 = i13;
                        f3 = f3;
                        f4 = f4;
                        i12 = i12;
                        i9 -= i5;
                        i16 = i111 + 1;
                        f3 = f3;
                        i3 = i13;
                        cCITTG4Encoder = cCITTG4Encoder2;
                        f4 = f4;
                        i4 = i12;
                        fieldAsLong = i110;
                        i8 = i8;
                        arrayLongShort = arrayLongShort;
                        i6 = i112;
                    }
                    tIFFFaxDecoder.decode1D(bArr2, bArr, 0, iMin);
                    cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                    i9 -= i5;
                    i16 = i111 + 1;
                    f3 = f3;
                    i3 = i13;
                    cCITTG4Encoder = cCITTG4Encoder2;
                    f4 = f4;
                    i4 = i12;
                    fieldAsLong = i110;
                    i8 = i8;
                    arrayLongShort = arrayLongShort;
                    i6 = i112;
                }
                i10 = i3;
                int i21 = fieldAsLong;
                f5 = f3;
                f6 = f4;
                i11 = i4;
                image = Image.getInstance(fieldAsLong2, i21, false, 256, i6 & 1, cCITTG4Encoder.close());
            } else {
                f3 = f;
                cCITTG4Encoder = new CCITTG4Encoder(fieldAsLong2);
                f4 = f2;
                i9 = fieldAsLong;
                while (i16 < arrayLongShort.length) {
                    i12 = i4;
                    int i113 = fieldAsLong;
                    bArr = new byte[(int) jArr[i16]];
                    cCITTG4Encoder2 = cCITTG4Encoder;
                    i13 = i3;
                    randomAccessFileOrArray.seek(arrayLongShort[i16]);
                    randomAccessFileOrArray.readFully(bArr);
                    iMin = Math.min(i5, i9);
                    int i114 = i16;
                    int i115 = i6;
                    long j5 = asLong;
                    tIFFFaxDecoder = new TIFFFaxDecoder(j5, fieldAsLong2, iMin);
                    tIFFFaxDecoder.setRecoverFromImageError(z);
                    asLong = j5;
                    bArr2 = new byte[((fieldAsLong2 + 7) / 8) * iMin];
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 4) {
                                tIFFFaxDecoder.decodeT6(bArr2, bArr, 0, iMin, asLong2);
                                cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                                cCITTG4Encoder2 = cCITTG4Encoder2;
                            } else if (i7 != 32771) {
                                cCITTG4Encoder2 = cCITTG4Encoder2;
                            }
                            arrayLongShort = arrayLongShort;
                            i13 = i13;
                            f3 = f3;
                            f4 = f4;
                            i12 = i12;
                            i9 -= i5;
                            i16 = i114 + 1;
                            f3 = f3;
                            i3 = i13;
                            cCITTG4Encoder = cCITTG4Encoder2;
                            f4 = f4;
                            i4 = i12;
                            fieldAsLong = i113;
                            i8 = i8;
                            arrayLongShort = arrayLongShort;
                            i6 = i115;
                        } else {
                            cCITTG4Encoder2 = cCITTG4Encoder2;
                            tIFFFaxDecoder.decode2D(bArr2, bArr, 0, iMin, j);
                            cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                        }
                        arrayLongShort = arrayLongShort;
                        i13 = i13;
                        f3 = f3;
                        f4 = f4;
                        i12 = i12;
                        i9 -= i5;
                        i16 = i114 + 1;
                        f3 = f3;
                        i3 = i13;
                        cCITTG4Encoder = cCITTG4Encoder2;
                        f4 = f4;
                        i4 = i12;
                        fieldAsLong = i113;
                        i8 = i8;
                        arrayLongShort = arrayLongShort;
                        i6 = i115;
                    }
                    tIFFFaxDecoder.decode1D(bArr2, bArr, 0, iMin);
                    cCITTG4Encoder2.fax4Encode(bArr2, iMin);
                    i9 -= i5;
                    i16 = i114 + 1;
                    f3 = f3;
                    i3 = i13;
                    cCITTG4Encoder = cCITTG4Encoder2;
                    f4 = f4;
                    i4 = i12;
                    fieldAsLong = i113;
                    i8 = i8;
                    arrayLongShort = arrayLongShort;
                    i6 = i115;
                }
                i10 = i3;
                int i22 = fieldAsLong;
                f5 = f3;
                f6 = f4;
                i11 = i4;
                image = Image.getInstance(fieldAsLong2, i22, false, 256, i6 & 1, cCITTG4Encoder.close());
            }
            image.setDpi(i11, i10);
            image.setXYRatio(f6);
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                if (iCC_Profile.getNumComponents() == 1) {
                    image.tagICC(iCC_Profile);
                }
            }
            image.setOriginalType(5);
            if (f5 != 0.0f) {
                image.setInitialRotation(f5);
            }
            return image;
        } catch (Exception e3) {
            throw new ExceptionConverter(e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0189  */
    /* JADX WARN: Code duplicated, block: B:104:0x0192 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:122:0x01cd A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d7 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:127:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x020d A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:136:0x021f  */
    /* JADX WARN: Code duplicated, block: B:139:0x022e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0238 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0240 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0253 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:149:0x027f A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:151:0x028e  */
    /* JADX WARN: Code duplicated, block: B:153:0x0291 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0295 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:157:0x02ab A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:159:0x02b6 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:162:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:165:0x02c9 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:171:0x02f3 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:172:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:173:0x02fc A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0309  */
    /* JADX WARN: Code duplicated, block: B:178:0x0313 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:180:0x032c A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:181:0x033d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0341 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:186:0x0347  */
    /* JADX WARN: Code duplicated, block: B:188:0x034a  */
    /* JADX WARN: Code duplicated, block: B:190:0x034e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0353  */
    /* JADX WARN: Code duplicated, block: B:194:0x0358  */
    /* JADX WARN: Code duplicated, block: B:195:0x0359 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:196:0x0360  */
    /* JADX WARN: Code duplicated, block: B:198:0x036a A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0373  */
    /* JADX WARN: Code duplicated, block: B:203:0x0379 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:208:0x0386  */
    /* JADX WARN: Code duplicated, block: B:210:0x038a A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:211:0x039c A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:215:0x03b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:222:0x03d3 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:225:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:231:0x0417 A[Catch: Exception -> 0x0035, RuntimeException -> 0x041a, TRY_LEAVE, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:235:0x0422 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0436 A[Catch: Exception -> 0x0035, LOOP:0: B:236:0x0434->B:237:0x0436, LOOP_END, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:240:0x045c A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0462 A[Catch: Exception -> 0x0035, LOOP:1: B:239:0x045a->B:243:0x0462, LOOP_END, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:246:0x0468  */
    /* JADX WARN: Code duplicated, block: B:248:0x046b A[Catch: Exception -> 0x0035, LOOP:2: B:247:0x0469->B:248:0x046b, LOOP_END, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:252:0x04bd A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:255:0x04c5 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:257:0x04cc A[Catch: Exception -> 0x0035, TRY_LEAVE, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:12:0x0029, B:13:0x0034, B:16:0x0038, B:25:0x004e, B:26:0x0059, B:27:0x005a, B:29:0x0065, B:42:0x0085, B:44:0x008d, B:47:0x0098, B:48:0x00a5, B:49:0x00a6, B:51:0x00b4, B:53:0x00bb, B:55:0x00c3, B:63:0x00d6, B:64:0x00e1, B:65:0x00e2, B:67:0x00fb, B:69:0x0102, B:71:0x011e, B:76:0x012b, B:78:0x0133, B:85:0x0146, B:87:0x0154, B:89:0x015a, B:91:0x0162, B:97:0x0175, B:122:0x01cd, B:125:0x01d7, B:132:0x01f5, B:141:0x0238, B:143:0x0240, B:145:0x0253, B:146:0x025d, B:223:0x03ef, B:227:0x03f8, B:229:0x0403, B:231:0x0417, B:233:0x041c, B:235:0x0422, B:237:0x0436, B:240:0x045c, B:248:0x046b, B:249:0x0489, B:243:0x0462, B:250:0x04b7, B:252:0x04bd, B:255:0x04c5, B:257:0x04cc, B:149:0x027f, B:150:0x028d, B:153:0x0291, B:155:0x0295, B:157:0x02ab, B:159:0x02b6, B:161:0x02bd, B:163:0x02c2, B:165:0x02c9, B:167:0x02d2, B:168:0x02d4, B:169:0x02eb, B:171:0x02f3, B:173:0x02fc, B:174:0x0308, B:176:0x0310, B:178:0x0313, B:180:0x032c, B:183:0x0341, B:206:0x0380, B:212:0x03a1, B:210:0x038a, B:211:0x039c, B:197:0x0363, B:195:0x0359, B:198:0x036a, B:221:0x03c1, B:222:0x03d3, B:134:0x020d, B:138:0x0222, B:104:0x0192, B:106:0x019a, B:111:0x01a6, B:112:0x01b3, B:117:0x01bb, B:118:0x01c6), top: B:262:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:263:0x0403 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:266:0x0460 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x0465 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    public static Image getTiffImageColor(TIFFDirectory tIFFDirectory, RandomAccessFileOrArray randomAccessFileOrArray) {
        float f;
        int i;
        int fieldAsLong;
        int i2;
        int asInt;
        float f2;
        long[] jArr;
        TIFFField field;
        int asInt2;
        TIFFLZWDecoder tIFFLZWDecoder;
        ByteArrayOutputStream byteArrayOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        TIFFLZWDecoder tIFFLZWDecoder2;
        long[] jArr2;
        ByteArrayOutputStream byteArrayOutputStream3;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream4;
        int i4;
        DeflaterOutputStream deflaterOutputStream2;
        CCITTG4Encoder cCITTG4Encoder;
        TIFFLZWDecoder tIFFLZWDecoder3;
        DeflaterOutputStream deflaterOutputStream3;
        int i5;
        int i6;
        int i7;
        DeflaterOutputStream deflaterOutputStream4;
        int i8;
        byte[] bArr;
        int iMin;
        byte[] bArr2;
        int i9;
        DeflaterOutputStream deflaterOutputStream5;
        int i10;
        byte[] bArr3;
        TIFFField field2;
        Jpeg jpeg;
        byte[] asBytes;
        int length;
        int i11;
        Image image;
        ICC_Profile iCC_Profile;
        char[] asChars;
        int length2;
        byte[] bArr4;
        int length3;
        int i12;
        int i13;
        int i14;
        boolean z;
        int i15;
        int length4;
        RandomAccessFileOrArray randomAccessFileOrArray2 = randomAccessFileOrArray;
        try {
            int fieldAsLong2 = (int) tIFFDirectory.getFieldAsLong(259);
            if (fieldAsLong2 != 1 && fieldAsLong2 != 32773 && fieldAsLong2 != 32946 && fieldAsLong2 != 5 && fieldAsLong2 != 6 && fieldAsLong2 != 7 && fieldAsLong2 != 8) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.compression.1.is.not.supported", fieldAsLong2));
            }
            int fieldAsLong3 = (int) tIFFDirectory.getFieldAsLong(262);
            if (fieldAsLong3 != 0 && fieldAsLong3 != 1 && fieldAsLong3 != 2 && fieldAsLong3 != 3 && fieldAsLong3 != 5 && fieldAsLong2 != 6 && fieldAsLong2 != 7) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.photometric.1.is.not.supported", fieldAsLong3));
            }
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ORIENTATION)) {
                int fieldAsLong4 = (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_ORIENTATION);
                if (fieldAsLong4 == 3 || fieldAsLong4 == 4) {
                    f = 3.1415927f;
                } else if (fieldAsLong4 == 5 || fieldAsLong4 == 8) {
                    f = 1.5707964f;
                } else if (fieldAsLong4 == 6 || fieldAsLong4 == 7) {
                    f = -1.5707964f;
                } else {
                    f = 0.0f;
                }
            } else {
                f = 0.0f;
            }
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_PLANARCONFIG) && tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_PLANARCONFIG) == 2) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("planar.images.are.not.supported", new Object[0]));
            }
            ?? IsTagPresent = tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_EXTRASAMPLES);
            int fieldAsLong5 = tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_SAMPLESPERPIXEL) ? (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_SAMPLESPERPIXEL) : 1;
            if (tIFFDirectory.isTagPresent(258)) {
                fieldAsLong = (int) tIFFDirectory.getFieldAsLong(258);
                i = 1;
            } else {
                i = 1;
                fieldAsLong = 1;
            }
            if (fieldAsLong != i && fieldAsLong != 2 && fieldAsLong != 4 && fieldAsLong != 8) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bits.per.sample.1.is.not.supported", fieldAsLong));
            }
            int fieldAsLong6 = (int) tIFFDirectory.getFieldAsLong(257);
            int i16 = fieldAsLong;
            int fieldAsLong7 = (int) tIFFDirectory.getFieldAsLong(256);
            int fieldAsLong8 = tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_RESOLUTIONUNIT) ? (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_RESOLUTIONUNIT) : 2;
            int dpi = getDpi(tIFFDirectory.getField(TIFFConstants.TIFFTAG_XRESOLUTION), fieldAsLong8);
            int dpi2 = getDpi(tIFFDirectory.getField(TIFFConstants.TIFFTAG_YRESOLUTION), fieldAsLong8);
            TIFFField field3 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_FILLORDER);
            if (field3 != null) {
                asInt = field3.getAsInt(0);
                i2 = 2;
            } else {
                i2 = 2;
                asInt = 1;
            }
            boolean z2 = asInt == i2;
            int fieldAsLong9 = tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ROWSPERSTRIP) ? (int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_ROWSPERSTRIP) : fieldAsLong6;
            int i17 = (fieldAsLong9 <= 0 || fieldAsLong9 > fieldAsLong6) ? fieldAsLong6 : fieldAsLong9;
            long[] arrayLongShort = getArrayLongShort(tIFFDirectory, TIFFConstants.TIFFTAG_STRIPOFFSETS);
            long[] arrayLongShort2 = getArrayLongShort(tIFFDirectory, TIFFConstants.TIFFTAG_STRIPBYTECOUNTS);
            if (arrayLongShort2 != null) {
                f2 = f;
                if (arrayLongShort2.length == 1) {
                    long j = arrayLongShort2[0];
                    if (j == 0 || j + arrayLongShort[0] > randomAccessFileOrArray.length()) {
                    }
                    jArr = arrayLongShort2;
                    if ((fieldAsLong2 != 5 || fieldAsLong2 == 32946 || fieldAsLong2 == 8) && (field = tIFFDirectory.getField(317)) != null) {
                        asInt2 = field.getAsInt(0);
                        if (asInt2 == 1 && asInt2 != 2) {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("illegal.value.for.predictor.in.tiff.file", new Object[0]));
                        }
                        if (asInt2 == 2 && i16 != 8) {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("1.bit.samples.are.not.supported.for.horizontal.differencing.predictor", i16));
                        }
                    } else {
                        asInt2 = 1;
                    }
                    if (fieldAsLong2 == 5) {
                        tIFFLZWDecoder = new TIFFLZWDecoder(fieldAsLong7, asInt2, fieldAsLong5);
                    } else {
                        tIFFLZWDecoder = null;
                    }
                    if (IsTagPresent > 0) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                    } else {
                        byteArrayOutputStream = null;
                        deflaterOutputStream = null;
                    }
                    if (i16 == 1 || fieldAsLong5 != 1 || fieldAsLong3 == 3) {
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        tIFFLZWDecoder2 = tIFFLZWDecoder;
                        jArr2 = arrayLongShort;
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        i3 = dpi2;
                        if (fieldAsLong2 != 6 || fieldAsLong2 == 7) {
                            byteArrayOutputStream4 = byteArrayOutputStream3;
                            i4 = dpi;
                            deflaterOutputStream2 = null;
                            cCITTG4Encoder = null;
                        } else {
                            deflaterOutputStream2 = new DeflaterOutputStream(byteArrayOutputStream3);
                            byteArrayOutputStream4 = byteArrayOutputStream3;
                            i4 = dpi;
                            cCITTG4Encoder = null;
                        }
                    } else {
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        tIFFLZWDecoder2 = tIFFLZWDecoder;
                        jArr2 = arrayLongShort;
                        i3 = dpi2;
                        i4 = dpi;
                        deflaterOutputStream2 = null;
                        byteArrayOutputStream4 = null;
                        cCITTG4Encoder = new CCITTG4Encoder(fieldAsLong7);
                    }
                    if (fieldAsLong2 != 6) {
                        if (fieldAsLong2 != 7) {
                            tIFFLZWDecoder3 = tIFFLZWDecoder2;
                            deflaterOutputStream3 = deflaterOutputStream2;
                            i5 = fieldAsLong6;
                            i6 = 0;
                            while (i6 < jArr2.length) {
                                i8 = fieldAsLong3;
                                bArr = new byte[(int) jArr[i6]];
                                CCITTG4Encoder cCITTG4Encoder2 = cCITTG4Encoder;
                                long[] jArr3 = jArr;
                                randomAccessFileOrArray2.seek(jArr2[i6]);
                                randomAccessFileOrArray2.readFully(bArr);
                                iMin = Math.min(i17, fieldAsLong6);
                                if (fieldAsLong2 != 1) {
                                    bArr2 = new byte[((((fieldAsLong7 * i16) * fieldAsLong5) + 7) / 8) * iMin];
                                } else {
                                    bArr2 = null;
                                }
                                if (z2) {
                                    TIFFFaxDecoder.reverseBits(bArr);
                                }
                                if (fieldAsLong2 != 1) {
                                    if (fieldAsLong2 != 5) {
                                        if (fieldAsLong2 != 8) {
                                            if (fieldAsLong2 == 32773) {
                                                decodePackbits(bArr, bArr2);
                                            } else if (fieldAsLong2 != 32946) {
                                            }
                                        }
                                        inflate(bArr, bArr2);
                                        applyPredictor(bArr2, asInt2, fieldAsLong7, iMin, fieldAsLong5);
                                    } else {
                                        tIFFLZWDecoder3.decode(bArr, bArr2, iMin);
                                    }
                                    bArr = bArr2;
                                }
                                if (i16 == 1 || fieldAsLong5 != 1) {
                                    i9 = i8;
                                } else {
                                    i9 = i8;
                                    if (i9 != 3) {
                                        cCITTG4Encoder2.fax4Encode(bArr, iMin);
                                    }
                                    deflaterOutputStream5 = deflaterOutputStream3;
                                    fieldAsLong6 -= i17;
                                    i6++;
                                    randomAccessFileOrArray2 = randomAccessFileOrArray;
                                    deflaterOutputStream3 = deflaterOutputStream5;
                                    cCITTG4Encoder = cCITTG4Encoder2;
                                    fieldAsLong3 = i9;
                                    jArr = jArr3;
                                }
                                if (IsTagPresent > 0) {
                                    ProcessExtraSamples(deflaterOutputStream3, deflaterOutputStream, bArr, fieldAsLong5, i16, fieldAsLong7, iMin);
                                    deflaterOutputStream5 = deflaterOutputStream3;
                                } else {
                                    deflaterOutputStream5 = deflaterOutputStream3;
                                    deflaterOutputStream5.write(bArr);
                                }
                                fieldAsLong6 -= i17;
                                i6++;
                                randomAccessFileOrArray2 = randomAccessFileOrArray;
                                deflaterOutputStream3 = deflaterOutputStream5;
                                cCITTG4Encoder = cCITTG4Encoder2;
                                fieldAsLong3 = i9;
                                jArr = jArr3;
                            }
                            i7 = fieldAsLong3;
                            CCITTG4Encoder cCITTG4Encoder3 = cCITTG4Encoder;
                            deflaterOutputStream4 = deflaterOutputStream3;
                            if (i16 == 1 || fieldAsLong5 != 1 || i7 == 3) {
                                deflaterOutputStream4.close();
                                ImgRaw imgRaw = new ImgRaw(fieldAsLong7, i5, fieldAsLong5 - (IsTagPresent == true ? 1 : 0), i16, byteArrayOutputStream4.toByteArray());
                                imgRaw.setDeflated(true);
                                image = imgRaw;
                            } else {
                                image = Image.getInstance(fieldAsLong7, i5, false, 256, i7 == 1 ? 1 : 0, cCITTG4Encoder3.close());
                            }
                        } else {
                            if (jArr.length > 1) {
                                throw new IOException(MessageLocalization.getComposedMessage("compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips", jArr.length));
                            }
                            i10 = (int) jArr[0];
                            bArr3 = new byte[i10];
                            randomAccessFileOrArray2.seek(jArr2[0]);
                            randomAccessFileOrArray2.readFully(bArr3);
                            field2 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_JPEGTABLES);
                            if (field2 != null) {
                                asBytes = field2.getAsBytes();
                                length = asBytes.length;
                                if (asBytes[0] == -1 || asBytes[1] != -40) {
                                    i11 = 0;
                                } else {
                                    length -= 2;
                                    i11 = 2;
                                }
                                if (asBytes[asBytes.length - 2] == -1 && asBytes[asBytes.length - 1] == -39) {
                                    length -= 2;
                                }
                                byte[] bArr5 = new byte[length];
                                System.arraycopy(asBytes, i11, bArr5, 0, length);
                                byte[] bArr6 = new byte[i10 + length];
                                System.arraycopy(bArr3, 0, bArr6, 0, 2);
                                System.arraycopy(bArr5, 0, bArr6, 2, length);
                                System.arraycopy(bArr3, 2, bArr6, length + 2, i10 - 2);
                                bArr3 = bArr6;
                            }
                            jpeg = new Jpeg(bArr3);
                            if (fieldAsLong3 == 2) {
                                jpeg.setColorTransform(0);
                            }
                        }
                        image.setDpi(i4, i3);
                        if (fieldAsLong2 != 6 && fieldAsLong2 != 7) {
                            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                                try {
                                    iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                                    if (fieldAsLong5 - (IsTagPresent == true ? 1 : 0) == iCC_Profile.getNumComponents()) {
                                        image.tagICC(iCC_Profile);
                                    }
                                } catch (RuntimeException unused) {
                                }
                            }
                            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_COLORMAP)) {
                                asChars = tIFFDirectory.getField(TIFFConstants.TIFFTAG_COLORMAP).getAsChars();
                                length2 = asChars.length;
                                bArr4 = new byte[length2];
                                length3 = asChars.length / 3;
                                i12 = length3 * 2;
                                for (i13 = 0; i13 < length3; i13++) {
                                    int i18 = i13 * 3;
                                    bArr4[i18] = (byte) (asChars[i13] >>> '\b');
                                    bArr4[i18 + 1] = (byte) (asChars[i13 + length3] >>> '\b');
                                    bArr4[i18 + 2] = (byte) (asChars[i13 + i12] >>> '\b');
                                }
                                i14 = 0;
                                while (true) {
                                    if (i14 < length2) {
                                        z = true;
                                        break;
                                    }
                                    if (bArr4[i14] != 0) {
                                        z = false;
                                        break;
                                    }
                                    i14++;
                                }
                                if (z) {
                                    for (i15 = 0; i15 < length3; i15++) {
                                        int i19 = i15 * 3;
                                        bArr4[i19] = (byte) asChars[i15];
                                        bArr4[i19 + 1] = (byte) asChars[i15 + length3];
                                        bArr4[i19 + 2] = (byte) asChars[i15 + i12];
                                    }
                                }
                                PdfArray pdfArray = new PdfArray();
                                pdfArray.add(PdfName.INDEXED);
                                pdfArray.add(PdfName.DEVICERGB);
                                pdfArray.add(new PdfNumber(length3 - 1));
                                pdfArray.add(new PdfString(bArr4));
                                PdfDictionary pdfDictionary = new PdfDictionary();
                                pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
                                image.setAdditional(pdfDictionary);
                            }
                            image.setOriginalType(5);
                        }
                        if (i7 == 0) {
                            image.setInverted(true);
                        }
                        if (f2 != 0.0f) {
                            image.setInitialRotation(f2);
                        }
                        if (IsTagPresent > 0) {
                            deflaterOutputStream.close();
                            Image image2 = Image.getInstance(fieldAsLong7, i5, 1, i16, byteArrayOutputStream2.toByteArray());
                            image2.makeMask();
                            image2.setDeflated(true);
                            image.setImageMask(image2);
                        }
                        return image;
                    }
                    if (!tIFFDirectory.isTagPresent(513)) {
                        throw new IOException(MessageLocalization.getComposedMessage("missing.tag.s.for.ojpeg.compression", new Object[0]));
                    }
                    int fieldAsLong10 = (int) tIFFDirectory.getFieldAsLong(513);
                    length4 = ((int) randomAccessFileOrArray.length()) - fieldAsLong10;
                    if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_JPEGIFBYTECOUNT)) {
                        length4 = ((int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_JPEGIFBYTECOUNT)) + ((int) jArr[0]);
                    }
                    byte[] bArr7 = new byte[Math.min(length4, ((int) randomAccessFileOrArray.length()) - fieldAsLong10)];
                    randomAccessFileOrArray2.seek(fieldAsLong10);
                    randomAccessFileOrArray2.readFully(bArr7);
                    jpeg = new Jpeg(bArr7);
                    image = jpeg;
                    i7 = fieldAsLong3;
                    i5 = fieldAsLong6;
                    image.setDpi(i4, i3);
                    if (fieldAsLong2 != 6) {
                        if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                            iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                            if (fieldAsLong5 - (IsTagPresent == true ? 1 : 0) == iCC_Profile.getNumComponents()) {
                                image.tagICC(iCC_Profile);
                            }
                        }
                        if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_COLORMAP)) {
                            asChars = tIFFDirectory.getField(TIFFConstants.TIFFTAG_COLORMAP).getAsChars();
                            length2 = asChars.length;
                            bArr4 = new byte[length2];
                            length3 = asChars.length / 3;
                            i12 = length3 * 2;
                            while (i13 < length3) {
                                int i110 = i13 * 3;
                                bArr4[i110] = (byte) (asChars[i13] >>> '\b');
                                bArr4[i110 + 1] = (byte) (asChars[i13 + length3] >>> '\b');
                                bArr4[i110 + 2] = (byte) (asChars[i13 + i12] >>> '\b');
                            }
                            i14 = 0;
                            while (true) {
                                if (i14 < length2) {
                                    z = true;
                                    break;
                                }
                                if (bArr4[i14] != 0) {
                                    z = false;
                                    break;
                                }
                                i14++;
                            }
                            if (z) {
                                while (i15 < length3) {
                                    int i111 = i15 * 3;
                                    bArr4[i111] = (byte) asChars[i15];
                                    bArr4[i111 + 1] = (byte) asChars[i15 + length3];
                                    bArr4[i111 + 2] = (byte) asChars[i15 + i12];
                                }
                            }
                            PdfArray pdfArray2 = new PdfArray();
                            pdfArray2.add(PdfName.INDEXED);
                            pdfArray2.add(PdfName.DEVICERGB);
                            pdfArray2.add(new PdfNumber(length3 - 1));
                            pdfArray2.add(new PdfString(bArr4));
                            PdfDictionary pdfDictionary2 = new PdfDictionary();
                            pdfDictionary2.put(PdfName.COLORSPACE, pdfArray2);
                            image.setAdditional(pdfDictionary2);
                        }
                        image.setOriginalType(5);
                    }
                    if (i7 == 0) {
                        image.setInverted(true);
                    }
                    if (f2 != 0.0f) {
                        image.setInitialRotation(f2);
                    }
                    if (IsTagPresent > 0) {
                        deflaterOutputStream.close();
                        Image image3 = Image.getInstance(fieldAsLong7, i5, 1, i16, byteArrayOutputStream2.toByteArray());
                        image3.makeMask();
                        image3.setDeflated(true);
                        image.setImageMask(image3);
                    }
                    return image;
                }
                jArr = arrayLongShort2;
                if (fieldAsLong2 != 5) {
                    asInt2 = field.getAsInt(0);
                    if (asInt2 == 1) {
                    }
                    if (asInt2 == 2) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("1.bit.samples.are.not.supported.for.horizontal.differencing.predictor", i16));
                    }
                } else {
                    asInt2 = field.getAsInt(0);
                    if (asInt2 == 1) {
                    }
                    if (asInt2 == 2) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("1.bit.samples.are.not.supported.for.horizontal.differencing.predictor", i16));
                    }
                }
                if (fieldAsLong2 == 5) {
                    tIFFLZWDecoder = new TIFFLZWDecoder(fieldAsLong7, asInt2, fieldAsLong5);
                } else {
                    tIFFLZWDecoder = null;
                }
                if (IsTagPresent > 0) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                } else {
                    byteArrayOutputStream = null;
                    deflaterOutputStream = null;
                }
                if (i16 == 1) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    tIFFLZWDecoder2 = tIFFLZWDecoder;
                    jArr2 = arrayLongShort;
                    byteArrayOutputStream3 = new ByteArrayOutputStream();
                    i3 = dpi2;
                    if (fieldAsLong2 != 6) {
                        byteArrayOutputStream4 = byteArrayOutputStream3;
                        i4 = dpi;
                        deflaterOutputStream2 = null;
                        cCITTG4Encoder = null;
                    } else {
                        byteArrayOutputStream4 = byteArrayOutputStream3;
                        i4 = dpi;
                        deflaterOutputStream2 = null;
                        cCITTG4Encoder = null;
                    }
                } else {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    tIFFLZWDecoder2 = tIFFLZWDecoder;
                    jArr2 = arrayLongShort;
                    byteArrayOutputStream3 = new ByteArrayOutputStream();
                    i3 = dpi2;
                    if (fieldAsLong2 != 6) {
                        byteArrayOutputStream4 = byteArrayOutputStream3;
                        i4 = dpi;
                        deflaterOutputStream2 = null;
                        cCITTG4Encoder = null;
                    } else {
                        byteArrayOutputStream4 = byteArrayOutputStream3;
                        i4 = dpi;
                        deflaterOutputStream2 = null;
                        cCITTG4Encoder = null;
                    }
                }
                if (fieldAsLong2 != 6) {
                    if (fieldAsLong2 != 7) {
                        tIFFLZWDecoder3 = tIFFLZWDecoder2;
                        deflaterOutputStream3 = deflaterOutputStream2;
                        i5 = fieldAsLong6;
                        i6 = 0;
                        while (i6 < jArr2.length) {
                            i8 = fieldAsLong3;
                            bArr = new byte[(int) jArr[i6]];
                            CCITTG4Encoder cCITTG4Encoder4 = cCITTG4Encoder;
                            long[] jArr4 = jArr;
                            randomAccessFileOrArray2.seek(jArr2[i6]);
                            randomAccessFileOrArray2.readFully(bArr);
                            iMin = Math.min(i17, fieldAsLong6);
                            if (fieldAsLong2 != 1) {
                                bArr2 = new byte[((((fieldAsLong7 * i16) * fieldAsLong5) + 7) / 8) * iMin];
                            } else {
                                bArr2 = null;
                            }
                            if (z2) {
                                TIFFFaxDecoder.reverseBits(bArr);
                            }
                            if (fieldAsLong2 != 1) {
                                if (fieldAsLong2 != 5) {
                                    if (fieldAsLong2 != 8) {
                                        if (fieldAsLong2 == 32773) {
                                            decodePackbits(bArr, bArr2);
                                        } else if (fieldAsLong2 != 32946) {
                                        }
                                    }
                                    inflate(bArr, bArr2);
                                    applyPredictor(bArr2, asInt2, fieldAsLong7, iMin, fieldAsLong5);
                                } else {
                                    tIFFLZWDecoder3.decode(bArr, bArr2, iMin);
                                }
                                bArr = bArr2;
                            }
                            if (i16 == 1) {
                                i9 = i8;
                                if (IsTagPresent > 0) {
                                    ProcessExtraSamples(deflaterOutputStream3, deflaterOutputStream, bArr, fieldAsLong5, i16, fieldAsLong7, iMin);
                                } else {
                                    deflaterOutputStream5 = deflaterOutputStream3;
                                    deflaterOutputStream5.write(bArr);
                                }
                                fieldAsLong6 -= i17;
                                i6++;
                                randomAccessFileOrArray2 = randomAccessFileOrArray;
                                deflaterOutputStream3 = deflaterOutputStream5;
                                cCITTG4Encoder = cCITTG4Encoder4;
                                fieldAsLong3 = i9;
                                jArr = jArr4;
                            } else {
                                i9 = i8;
                                if (IsTagPresent > 0) {
                                    ProcessExtraSamples(deflaterOutputStream3, deflaterOutputStream, bArr, fieldAsLong5, i16, fieldAsLong7, iMin);
                                } else {
                                    deflaterOutputStream5 = deflaterOutputStream3;
                                    deflaterOutputStream5.write(bArr);
                                }
                                fieldAsLong6 -= i17;
                                i6++;
                                randomAccessFileOrArray2 = randomAccessFileOrArray;
                                deflaterOutputStream3 = deflaterOutputStream5;
                                cCITTG4Encoder = cCITTG4Encoder4;
                                fieldAsLong3 = i9;
                                jArr = jArr4;
                            }
                            deflaterOutputStream5 = deflaterOutputStream3;
                            fieldAsLong6 -= i17;
                            i6++;
                            randomAccessFileOrArray2 = randomAccessFileOrArray;
                            deflaterOutputStream3 = deflaterOutputStream5;
                            cCITTG4Encoder = cCITTG4Encoder4;
                            fieldAsLong3 = i9;
                            jArr = jArr4;
                        }
                        i7 = fieldAsLong3;
                        CCITTG4Encoder cCITTG4Encoder5 = cCITTG4Encoder;
                        deflaterOutputStream4 = deflaterOutputStream3;
                        if (i16 == 1) {
                            deflaterOutputStream4.close();
                            ImgRaw imgRaw2 = new ImgRaw(fieldAsLong7, i5, fieldAsLong5 - (IsTagPresent == true ? 1 : 0), i16, byteArrayOutputStream4.toByteArray());
                            imgRaw2.setDeflated(true);
                            image = imgRaw2;
                        } else {
                            deflaterOutputStream4.close();
                            ImgRaw imgRaw3 = new ImgRaw(fieldAsLong7, i5, fieldAsLong5 - (IsTagPresent == true ? 1 : 0), i16, byteArrayOutputStream4.toByteArray());
                            imgRaw3.setDeflated(true);
                            image = imgRaw3;
                        }
                    } else {
                        if (jArr.length > 1) {
                            throw new IOException(MessageLocalization.getComposedMessage("compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips", jArr.length));
                        }
                        i10 = (int) jArr[0];
                        bArr3 = new byte[i10];
                        randomAccessFileOrArray2.seek(jArr2[0]);
                        randomAccessFileOrArray2.readFully(bArr3);
                        field2 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_JPEGTABLES);
                        if (field2 != null) {
                            asBytes = field2.getAsBytes();
                            length = asBytes.length;
                            if (asBytes[0] == -1) {
                                i11 = 0;
                            } else {
                                i11 = 0;
                            }
                            if (asBytes[asBytes.length - 2] == -1) {
                                length -= 2;
                            }
                            byte[] bArr8 = new byte[length];
                            System.arraycopy(asBytes, i11, bArr8, 0, length);
                            byte[] bArr9 = new byte[i10 + length];
                            System.arraycopy(bArr3, 0, bArr9, 0, 2);
                            System.arraycopy(bArr8, 0, bArr9, 2, length);
                            System.arraycopy(bArr3, 2, bArr9, length + 2, i10 - 2);
                            bArr3 = bArr9;
                        }
                        jpeg = new Jpeg(bArr3);
                        if (fieldAsLong3 == 2) {
                            jpeg.setColorTransform(0);
                        }
                    }
                    image.setDpi(i4, i3);
                    if (fieldAsLong2 != 6) {
                        if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                            iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                            if (fieldAsLong5 - (IsTagPresent == true ? 1 : 0) == iCC_Profile.getNumComponents()) {
                                image.tagICC(iCC_Profile);
                            }
                        }
                        if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_COLORMAP)) {
                            asChars = tIFFDirectory.getField(TIFFConstants.TIFFTAG_COLORMAP).getAsChars();
                            length2 = asChars.length;
                            bArr4 = new byte[length2];
                            length3 = asChars.length / 3;
                            i12 = length3 * 2;
                            while (i13 < length3) {
                                int i112 = i13 * 3;
                                bArr4[i112] = (byte) (asChars[i13] >>> '\b');
                                bArr4[i112 + 1] = (byte) (asChars[i13 + length3] >>> '\b');
                                bArr4[i112 + 2] = (byte) (asChars[i13 + i12] >>> '\b');
                            }
                            i14 = 0;
                            while (true) {
                                if (i14 < length2) {
                                    z = true;
                                    break;
                                }
                                if (bArr4[i14] != 0) {
                                    z = false;
                                    break;
                                }
                                i14++;
                            }
                            if (z) {
                                while (i15 < length3) {
                                    int i113 = i15 * 3;
                                    bArr4[i113] = (byte) asChars[i15];
                                    bArr4[i113 + 1] = (byte) asChars[i15 + length3];
                                    bArr4[i113 + 2] = (byte) asChars[i15 + i12];
                                }
                            }
                            PdfArray pdfArray3 = new PdfArray();
                            pdfArray3.add(PdfName.INDEXED);
                            pdfArray3.add(PdfName.DEVICERGB);
                            pdfArray3.add(new PdfNumber(length3 - 1));
                            pdfArray3.add(new PdfString(bArr4));
                            PdfDictionary pdfDictionary3 = new PdfDictionary();
                            pdfDictionary3.put(PdfName.COLORSPACE, pdfArray3);
                            image.setAdditional(pdfDictionary3);
                        }
                        image.setOriginalType(5);
                    }
                    if (i7 == 0) {
                        image.setInverted(true);
                    }
                    if (f2 != 0.0f) {
                        image.setInitialRotation(f2);
                    }
                    if (IsTagPresent > 0) {
                        deflaterOutputStream.close();
                        Image image4 = Image.getInstance(fieldAsLong7, i5, 1, i16, byteArrayOutputStream2.toByteArray());
                        image4.makeMask();
                        image4.setDeflated(true);
                        image.setImageMask(image4);
                    }
                    return image;
                }
                if (!tIFFDirectory.isTagPresent(513)) {
                    throw new IOException(MessageLocalization.getComposedMessage("missing.tag.s.for.ojpeg.compression", new Object[0]));
                }
                int fieldAsLong11 = (int) tIFFDirectory.getFieldAsLong(513);
                length4 = ((int) randomAccessFileOrArray.length()) - fieldAsLong11;
                if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_JPEGIFBYTECOUNT)) {
                    length4 = ((int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_JPEGIFBYTECOUNT)) + ((int) jArr[0]);
                }
                byte[] bArr10 = new byte[Math.min(length4, ((int) randomAccessFileOrArray.length()) - fieldAsLong11)];
                randomAccessFileOrArray2.seek(fieldAsLong11);
                randomAccessFileOrArray2.readFully(bArr10);
                jpeg = new Jpeg(bArr10);
                image = jpeg;
                i7 = fieldAsLong3;
                i5 = fieldAsLong6;
                image.setDpi(i4, i3);
                if (fieldAsLong2 != 6) {
                    if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                        iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                        if (fieldAsLong5 - (IsTagPresent == true ? 1 : 0) == iCC_Profile.getNumComponents()) {
                            image.tagICC(iCC_Profile);
                        }
                    }
                    if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_COLORMAP)) {
                        asChars = tIFFDirectory.getField(TIFFConstants.TIFFTAG_COLORMAP).getAsChars();
                        length2 = asChars.length;
                        bArr4 = new byte[length2];
                        length3 = asChars.length / 3;
                        i12 = length3 * 2;
                        while (i13 < length3) {
                            int i114 = i13 * 3;
                            bArr4[i114] = (byte) (asChars[i13] >>> '\b');
                            bArr4[i114 + 1] = (byte) (asChars[i13 + length3] >>> '\b');
                            bArr4[i114 + 2] = (byte) (asChars[i13 + i12] >>> '\b');
                        }
                        i14 = 0;
                        while (true) {
                            if (i14 < length2) {
                                z = true;
                                break;
                            }
                            if (bArr4[i14] != 0) {
                                z = false;
                                break;
                            }
                            i14++;
                        }
                        if (z) {
                            while (i15 < length3) {
                                int i115 = i15 * 3;
                                bArr4[i115] = (byte) asChars[i15];
                                bArr4[i115 + 1] = (byte) asChars[i15 + length3];
                                bArr4[i115 + 2] = (byte) asChars[i15 + i12];
                            }
                        }
                        PdfArray pdfArray4 = new PdfArray();
                        pdfArray4.add(PdfName.INDEXED);
                        pdfArray4.add(PdfName.DEVICERGB);
                        pdfArray4.add(new PdfNumber(length3 - 1));
                        pdfArray4.add(new PdfString(bArr4));
                        PdfDictionary pdfDictionary4 = new PdfDictionary();
                        pdfDictionary4.put(PdfName.COLORSPACE, pdfArray4);
                        image.setAdditional(pdfDictionary4);
                    }
                    image.setOriginalType(5);
                }
                if (i7 == 0) {
                    image.setInverted(true);
                }
                if (f2 != 0.0f) {
                    image.setInitialRotation(f2);
                }
                if (IsTagPresent > 0) {
                    deflaterOutputStream.close();
                    Image image5 = Image.getInstance(fieldAsLong7, i5, 1, i16, byteArrayOutputStream2.toByteArray());
                    image5.makeMask();
                    image5.setDeflated(true);
                    image.setImageMask(image5);
                }
                return image;
            }
            f2 = f;
            if (fieldAsLong6 == i17) {
                arrayLongShort2 = new long[]{randomAccessFileOrArray.length() - ((long) ((int) arrayLongShort[0]))};
            }
            jArr = arrayLongShort2;
            if (fieldAsLong2 != 5) {
                asInt2 = field.getAsInt(0);
                if (asInt2 == 1) {
                }
                if (asInt2 == 2) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("1.bit.samples.are.not.supported.for.horizontal.differencing.predictor", i16));
                }
            } else {
                asInt2 = field.getAsInt(0);
                if (asInt2 == 1) {
                }
                if (asInt2 == 2) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("1.bit.samples.are.not.supported.for.horizontal.differencing.predictor", i16));
                }
            }
            if (fieldAsLong2 == 5) {
                tIFFLZWDecoder = new TIFFLZWDecoder(fieldAsLong7, asInt2, fieldAsLong5);
            } else {
                tIFFLZWDecoder = null;
            }
            if (IsTagPresent > 0) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            } else {
                byteArrayOutputStream = null;
                deflaterOutputStream = null;
            }
            if (i16 == 1) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                tIFFLZWDecoder2 = tIFFLZWDecoder;
                jArr2 = arrayLongShort;
                byteArrayOutputStream3 = new ByteArrayOutputStream();
                i3 = dpi2;
                if (fieldAsLong2 != 6) {
                    byteArrayOutputStream4 = byteArrayOutputStream3;
                    i4 = dpi;
                    deflaterOutputStream2 = null;
                    cCITTG4Encoder = null;
                } else {
                    byteArrayOutputStream4 = byteArrayOutputStream3;
                    i4 = dpi;
                    deflaterOutputStream2 = null;
                    cCITTG4Encoder = null;
                }
            } else {
                byteArrayOutputStream2 = byteArrayOutputStream;
                tIFFLZWDecoder2 = tIFFLZWDecoder;
                jArr2 = arrayLongShort;
                byteArrayOutputStream3 = new ByteArrayOutputStream();
                i3 = dpi2;
                if (fieldAsLong2 != 6) {
                    byteArrayOutputStream4 = byteArrayOutputStream3;
                    i4 = dpi;
                    deflaterOutputStream2 = null;
                    cCITTG4Encoder = null;
                } else {
                    byteArrayOutputStream4 = byteArrayOutputStream3;
                    i4 = dpi;
                    deflaterOutputStream2 = null;
                    cCITTG4Encoder = null;
                }
            }
            if (fieldAsLong2 != 6) {
                if (fieldAsLong2 != 7) {
                    tIFFLZWDecoder3 = tIFFLZWDecoder2;
                    deflaterOutputStream3 = deflaterOutputStream2;
                    i5 = fieldAsLong6;
                    i6 = 0;
                    while (i6 < jArr2.length) {
                        i8 = fieldAsLong3;
                        bArr = new byte[(int) jArr[i6]];
                        CCITTG4Encoder cCITTG4Encoder6 = cCITTG4Encoder;
                        long[] jArr5 = jArr;
                        randomAccessFileOrArray2.seek(jArr2[i6]);
                        randomAccessFileOrArray2.readFully(bArr);
                        iMin = Math.min(i17, fieldAsLong6);
                        if (fieldAsLong2 != 1) {
                            bArr2 = new byte[((((fieldAsLong7 * i16) * fieldAsLong5) + 7) / 8) * iMin];
                        } else {
                            bArr2 = null;
                        }
                        if (z2) {
                            TIFFFaxDecoder.reverseBits(bArr);
                        }
                        if (fieldAsLong2 != 1) {
                            if (fieldAsLong2 != 5) {
                                if (fieldAsLong2 != 8) {
                                    if (fieldAsLong2 == 32773) {
                                        decodePackbits(bArr, bArr2);
                                    } else if (fieldAsLong2 != 32946) {
                                    }
                                }
                                inflate(bArr, bArr2);
                                applyPredictor(bArr2, asInt2, fieldAsLong7, iMin, fieldAsLong5);
                            } else {
                                tIFFLZWDecoder3.decode(bArr, bArr2, iMin);
                            }
                            bArr = bArr2;
                        }
                        if (i16 == 1) {
                            i9 = i8;
                            if (IsTagPresent > 0) {
                                ProcessExtraSamples(deflaterOutputStream3, deflaterOutputStream, bArr, fieldAsLong5, i16, fieldAsLong7, iMin);
                            } else {
                                deflaterOutputStream5 = deflaterOutputStream3;
                                deflaterOutputStream5.write(bArr);
                            }
                            fieldAsLong6 -= i17;
                            i6++;
                            randomAccessFileOrArray2 = randomAccessFileOrArray;
                            deflaterOutputStream3 = deflaterOutputStream5;
                            cCITTG4Encoder = cCITTG4Encoder6;
                            fieldAsLong3 = i9;
                            jArr = jArr5;
                        } else {
                            i9 = i8;
                            if (IsTagPresent > 0) {
                                ProcessExtraSamples(deflaterOutputStream3, deflaterOutputStream, bArr, fieldAsLong5, i16, fieldAsLong7, iMin);
                            } else {
                                deflaterOutputStream5 = deflaterOutputStream3;
                                deflaterOutputStream5.write(bArr);
                            }
                            fieldAsLong6 -= i17;
                            i6++;
                            randomAccessFileOrArray2 = randomAccessFileOrArray;
                            deflaterOutputStream3 = deflaterOutputStream5;
                            cCITTG4Encoder = cCITTG4Encoder6;
                            fieldAsLong3 = i9;
                            jArr = jArr5;
                        }
                        deflaterOutputStream5 = deflaterOutputStream3;
                        fieldAsLong6 -= i17;
                        i6++;
                        randomAccessFileOrArray2 = randomAccessFileOrArray;
                        deflaterOutputStream3 = deflaterOutputStream5;
                        cCITTG4Encoder = cCITTG4Encoder6;
                        fieldAsLong3 = i9;
                        jArr = jArr5;
                    }
                    i7 = fieldAsLong3;
                    CCITTG4Encoder cCITTG4Encoder7 = cCITTG4Encoder;
                    deflaterOutputStream4 = deflaterOutputStream3;
                    if (i16 == 1) {
                        deflaterOutputStream4.close();
                        ImgRaw imgRaw4 = new ImgRaw(fieldAsLong7, i5, fieldAsLong5 - (IsTagPresent == true ? 1 : 0), i16, byteArrayOutputStream4.toByteArray());
                        imgRaw4.setDeflated(true);
                        image = imgRaw4;
                    } else {
                        deflaterOutputStream4.close();
                        ImgRaw imgRaw5 = new ImgRaw(fieldAsLong7, i5, fieldAsLong5 - (IsTagPresent == true ? 1 : 0), i16, byteArrayOutputStream4.toByteArray());
                        imgRaw5.setDeflated(true);
                        image = imgRaw5;
                    }
                } else {
                    if (jArr.length > 1) {
                        throw new IOException(MessageLocalization.getComposedMessage("compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips", jArr.length));
                    }
                    i10 = (int) jArr[0];
                    bArr3 = new byte[i10];
                    randomAccessFileOrArray2.seek(jArr2[0]);
                    randomAccessFileOrArray2.readFully(bArr3);
                    field2 = tIFFDirectory.getField(TIFFConstants.TIFFTAG_JPEGTABLES);
                    if (field2 != null) {
                        asBytes = field2.getAsBytes();
                        length = asBytes.length;
                        if (asBytes[0] == -1) {
                            i11 = 0;
                        } else {
                            i11 = 0;
                        }
                        if (asBytes[asBytes.length - 2] == -1) {
                            length -= 2;
                        }
                        byte[] bArr11 = new byte[length];
                        System.arraycopy(asBytes, i11, bArr11, 0, length);
                        byte[] bArr12 = new byte[i10 + length];
                        System.arraycopy(bArr3, 0, bArr12, 0, 2);
                        System.arraycopy(bArr11, 0, bArr12, 2, length);
                        System.arraycopy(bArr3, 2, bArr12, length + 2, i10 - 2);
                        bArr3 = bArr12;
                    }
                    jpeg = new Jpeg(bArr3);
                    if (fieldAsLong3 == 2) {
                        jpeg.setColorTransform(0);
                    }
                }
                image.setDpi(i4, i3);
                if (fieldAsLong2 != 6) {
                    if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                        iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                        if (fieldAsLong5 - (IsTagPresent == true ? 1 : 0) == iCC_Profile.getNumComponents()) {
                            image.tagICC(iCC_Profile);
                        }
                    }
                    if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_COLORMAP)) {
                        asChars = tIFFDirectory.getField(TIFFConstants.TIFFTAG_COLORMAP).getAsChars();
                        length2 = asChars.length;
                        bArr4 = new byte[length2];
                        length3 = asChars.length / 3;
                        i12 = length3 * 2;
                        while (i13 < length3) {
                            int i116 = i13 * 3;
                            bArr4[i116] = (byte) (asChars[i13] >>> '\b');
                            bArr4[i116 + 1] = (byte) (asChars[i13 + length3] >>> '\b');
                            bArr4[i116 + 2] = (byte) (asChars[i13 + i12] >>> '\b');
                        }
                        i14 = 0;
                        while (true) {
                            if (i14 < length2) {
                                z = true;
                                break;
                            }
                            if (bArr4[i14] != 0) {
                                z = false;
                                break;
                            }
                            i14++;
                        }
                        if (z) {
                            while (i15 < length3) {
                                int i117 = i15 * 3;
                                bArr4[i117] = (byte) asChars[i15];
                                bArr4[i117 + 1] = (byte) asChars[i15 + length3];
                                bArr4[i117 + 2] = (byte) asChars[i15 + i12];
                            }
                        }
                        PdfArray pdfArray5 = new PdfArray();
                        pdfArray5.add(PdfName.INDEXED);
                        pdfArray5.add(PdfName.DEVICERGB);
                        pdfArray5.add(new PdfNumber(length3 - 1));
                        pdfArray5.add(new PdfString(bArr4));
                        PdfDictionary pdfDictionary5 = new PdfDictionary();
                        pdfDictionary5.put(PdfName.COLORSPACE, pdfArray5);
                        image.setAdditional(pdfDictionary5);
                    }
                    image.setOriginalType(5);
                }
                if (i7 == 0) {
                    image.setInverted(true);
                }
                if (f2 != 0.0f) {
                    image.setInitialRotation(f2);
                }
                if (IsTagPresent > 0) {
                    deflaterOutputStream.close();
                    Image image6 = Image.getInstance(fieldAsLong7, i5, 1, i16, byteArrayOutputStream2.toByteArray());
                    image6.makeMask();
                    image6.setDeflated(true);
                    image.setImageMask(image6);
                }
                return image;
            }
            if (!tIFFDirectory.isTagPresent(513)) {
                throw new IOException(MessageLocalization.getComposedMessage("missing.tag.s.for.ojpeg.compression", new Object[0]));
            }
            int fieldAsLong12 = (int) tIFFDirectory.getFieldAsLong(513);
            length4 = ((int) randomAccessFileOrArray.length()) - fieldAsLong12;
            if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_JPEGIFBYTECOUNT)) {
                length4 = ((int) tIFFDirectory.getFieldAsLong(TIFFConstants.TIFFTAG_JPEGIFBYTECOUNT)) + ((int) jArr[0]);
            }
            byte[] bArr13 = new byte[Math.min(length4, ((int) randomAccessFileOrArray.length()) - fieldAsLong12)];
            randomAccessFileOrArray2.seek(fieldAsLong12);
            randomAccessFileOrArray2.readFully(bArr13);
            jpeg = new Jpeg(bArr13);
            image = jpeg;
            i7 = fieldAsLong3;
            i5 = fieldAsLong6;
            image.setDpi(i4, i3);
            if (fieldAsLong2 != 6) {
                if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_ICCPROFILE)) {
                    iCC_Profile = ICC_Profile.getInstance(tIFFDirectory.getField(TIFFConstants.TIFFTAG_ICCPROFILE).getAsBytes());
                    if (fieldAsLong5 - (IsTagPresent == true ? 1 : 0) == iCC_Profile.getNumComponents()) {
                        image.tagICC(iCC_Profile);
                    }
                }
                if (tIFFDirectory.isTagPresent(TIFFConstants.TIFFTAG_COLORMAP)) {
                    asChars = tIFFDirectory.getField(TIFFConstants.TIFFTAG_COLORMAP).getAsChars();
                    length2 = asChars.length;
                    bArr4 = new byte[length2];
                    length3 = asChars.length / 3;
                    i12 = length3 * 2;
                    while (i13 < length3) {
                        int i118 = i13 * 3;
                        bArr4[i118] = (byte) (asChars[i13] >>> '\b');
                        bArr4[i118 + 1] = (byte) (asChars[i13 + length3] >>> '\b');
                        bArr4[i118 + 2] = (byte) (asChars[i13 + i12] >>> '\b');
                    }
                    i14 = 0;
                    while (true) {
                        if (i14 < length2) {
                            z = true;
                            break;
                        }
                        if (bArr4[i14] != 0) {
                            z = false;
                            break;
                        }
                        i14++;
                    }
                    if (z) {
                        while (i15 < length3) {
                            int i119 = i15 * 3;
                            bArr4[i119] = (byte) asChars[i15];
                            bArr4[i119 + 1] = (byte) asChars[i15 + length3];
                            bArr4[i119 + 2] = (byte) asChars[i15 + i12];
                        }
                    }
                    PdfArray pdfArray6 = new PdfArray();
                    pdfArray6.add(PdfName.INDEXED);
                    pdfArray6.add(PdfName.DEVICERGB);
                    pdfArray6.add(new PdfNumber(length3 - 1));
                    pdfArray6.add(new PdfString(bArr4));
                    PdfDictionary pdfDictionary6 = new PdfDictionary();
                    pdfDictionary6.put(PdfName.COLORSPACE, pdfArray6);
                    image.setAdditional(pdfDictionary6);
                }
                image.setOriginalType(5);
            }
            if (i7 == 0) {
                image.setInverted(true);
            }
            if (f2 != 0.0f) {
                image.setInitialRotation(f2);
            }
            if (IsTagPresent > 0) {
                deflaterOutputStream.close();
                Image image7 = Image.getInstance(fieldAsLong7, i5, 1, i16, byteArrayOutputStream2.toByteArray());
                image7.makeMask();
                image7.setDeflated(true);
                image.setImageMask(image7);
            }
            return image;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static void inflate(byte[] bArr, byte[] bArr2) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        try {
            inflater.inflate(bArr2);
        } catch (DataFormatException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, boolean z, int i) {
        return getTiffImage(randomAccessFileOrArray, z, i, false);
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        return getTiffImage(randomAccessFileOrArray, i, false);
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, int i, boolean z) {
        return getTiffImage(randomAccessFileOrArray, false, i, z);
    }
}
