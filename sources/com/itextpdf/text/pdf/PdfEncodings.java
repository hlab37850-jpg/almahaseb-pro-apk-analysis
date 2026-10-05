package com.itextpdf.text.pdf;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import org.apache.poi.hssf.record.formula.MemFuncPtg;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class PdfEncodings {
    static final char[] winansiByteToChar = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', Ascii.MAX, 8364, 65533, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, Barcode128.DEL, Barcode128.FNC3, Barcode128.FNC2, Barcode128.SHIFT, Barcode128.CODE_C, 200, 201, Barcode128.FNC1, Barcode128.STARTA, Barcode128.STARTB, Barcode128.STARTC, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};
    static final char[] pdfEncodingByteToChar = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', Ascii.MAX, 8226, 8224, 8225, 8230, 8212, 8211, 402, 8260, 8249, 8250, 8722, 8240, 8222, 8220, 8221, 8216, 8217, 8218, 8482, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 65533, 8364, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, Barcode128.DEL, Barcode128.FNC3, Barcode128.FNC2, Barcode128.SHIFT, Barcode128.CODE_C, 200, 201, Barcode128.FNC1, Barcode128.STARTA, Barcode128.STARTB, Barcode128.STARTC, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};
    static final IntHashtable winansi = new IntHashtable();
    static final IntHashtable pdfEncoding = new IntHashtable();
    static HashMap<String, ExtraEncoding> extraEncodings = new HashMap<>();

    static {
        for (int i = 128; i < 161; i++) {
            char c = winansiByteToChar[i];
            if (c != 65533) {
                winansi.put(c, i);
            }
        }
        for (int i2 = 128; i2 < 161; i2++) {
            char c2 = pdfEncodingByteToChar[i2];
            if (c2 != 65533) {
                pdfEncoding.put(c2, i2);
            }
        }
        addExtraEncoding("Wingdings", new WingdingsConversion());
        addExtraEncoding("Symbol", new SymbolConversion(true));
        addExtraEncoding("ZapfDingbats", new SymbolConversion(false));
        addExtraEncoding("SymbolTT", new SymbolTTConversion());
        addExtraEncoding("Cp437", new Cp437Conversion());
    }

    public static void addExtraEncoding(String str, ExtraEncoding extraEncoding) {
        synchronized (extraEncodings) {
            HashMap<String, ExtraEncoding> map = (HashMap) extraEncodings.clone();
            map.put(str.toLowerCase(), extraEncoding);
            extraEncodings = map;
        }
    }

    public static final byte[] convertToBytes(String str, String str2) {
        int i;
        byte[] bArrCharToByte;
        int i2 = 0;
        if (str == null) {
            return new byte[0];
        }
        if (str2 == null || str2.length() == 0) {
            int length = str.length();
            byte[] bArr = new byte[length];
            while (i2 < length) {
                bArr[i2] = (byte) str.charAt(i2);
                i2++;
            }
            return bArr;
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str2.toLowerCase());
        if (extraEncoding != null && (bArrCharToByte = extraEncoding.charToByte(str, str2)) != null) {
            return bArrCharToByte;
        }
        IntHashtable intHashtable = str2.equals("Cp1252") ? winansi : str2.equals(PdfObject.TEXT_PDFDOCENCODING) ? pdfEncoding : null;
        if (intHashtable == null) {
            if (!str2.equals(PdfObject.TEXT_UNICODE)) {
                try {
                    CharsetEncoder charsetEncoderNewEncoder = Charset.forName(str2).newEncoder();
                    charsetEncoderNewEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                    java.nio.ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.encode(CharBuffer.wrap(str.toCharArray()));
                    byteBufferEncode.rewind();
                    byte[] bArr2 = new byte[byteBufferEncode.limit()];
                    byteBufferEncode.get(bArr2);
                    return bArr2;
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
            char[] charArray = str.toCharArray();
            int length2 = charArray.length;
            byte[] bArr3 = new byte[(charArray.length * 2) + 2];
            bArr3[0] = -2;
            bArr3[1] = -1;
            int i3 = 2;
            while (i2 < length2) {
                char c = charArray[i2];
                int i4 = i3 + 1;
                bArr3[i3] = (byte) (c >> '\b');
                i3 += 2;
                bArr3[i4] = (byte) (c & 255);
                i2++;
            }
            return bArr3;
        }
        char[] charArray2 = str.toCharArray();
        int length3 = charArray2.length;
        byte[] bArr4 = new byte[length3];
        int i5 = 0;
        for (char c2 : charArray2) {
            if (c2 >= 128 && (c2 <= 160 || c2 > 255)) {
                i = c2;
                i = c2;
                i = intHashtable.get(c2);
            }
            if (i != 0) {
                bArr4[i5] = (byte) i;
                i5++;
            }
        }
        if (i5 == length3) {
            return bArr4;
        }
        byte[] bArr5 = new byte[i5];
        System.arraycopy(bArr4, 0, bArr5, 0, i5);
        return bArr5;
    }

    public static final String convertToString(byte[] bArr, String str) {
        char[] cArr;
        String strByteToChar;
        if (bArr == null) {
            return "";
        }
        int i = 0;
        if (str == null || str.length() == 0) {
            char[] cArr2 = new char[bArr.length];
            while (i < bArr.length) {
                cArr2[i] = (char) (bArr[i] & UnsignedBytes.MAX_VALUE);
                i++;
            }
            return new String(cArr2);
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str.toLowerCase());
        if (extraEncoding != null && (strByteToChar = extraEncoding.byteToChar(bArr, str)) != null) {
            return strByteToChar;
        }
        if (str.equals("Cp1252")) {
            cArr = winansiByteToChar;
        } else {
            cArr = str.equals(PdfObject.TEXT_PDFDOCENCODING) ? pdfEncodingByteToChar : null;
        }
        if (cArr == null) {
            try {
                return new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                throw new ExceptionConverter(e);
            }
        }
        int length = bArr.length;
        char[] cArr3 = new char[length];
        while (i < length) {
            cArr3[i] = cArr[bArr[i] & UnsignedBytes.MAX_VALUE];
            i++;
        }
        return new String(cArr3);
    }

    public static boolean isPdfDocEncoding(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 128 && ((cCharAt <= 160 || cCharAt > 255) && !pdfEncoding.containsKey(cCharAt))) {
                return false;
            }
        }
        return true;
    }

    public static class SymbolTTConversion implements ExtraEncoding {
        private SymbolTTConversion() {
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            int i = 65280 & c;
            return (i == 0 || i == 61440) ? new byte[]{(byte) c} : new byte[0];
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                int i2 = 65280 & c;
                if (i2 == 0 || i2 == 61440) {
                    bArr[i] = (byte) c;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
    }

    public static class WingdingsConversion implements ExtraEncoding {
        private static final byte[] table = {0, 35, 34, 0, 0, 0, MemFuncPtg.sid, DocWriter.GT, 81, RefErrorPtg.sid, 0, 0, 65, 63, 0, 0, 0, 0, 0, -4, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 86, 0, 88, 89, 0, 0, 0, 0, 0, 0, 0, 0, -75, 0, 0, 0, 0, 0, -74, 0, 0, 0, -83, -81, -84, 0, 0, 0, 0, 0, 0, 0, 0, 124, 123, 0, 0, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, -90, 0, 0, 0, 113, 114, 0, 0, 0, 117, 0, 0, 0, 0, 0, 0, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -24, -40, 0, 0, -60, -58, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        private WingdingsConversion() {
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            byte b;
            if (c == ' ') {
                return new byte[]{(byte) c};
            }
            return (c < 9985 || c > 10174 || (b = table[c + 55552]) == 0) ? new byte[0] : new byte[]{b};
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            byte b;
            int i;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i2 = 0;
            for (char c : charArray) {
                if (c == ' ') {
                    i = i2 + 1;
                    bArr[i2] = (byte) c;
                } else {
                    if (c >= 9985 && c <= 10174 && (b = table[c - 9984]) != 0) {
                        i = i2 + 1;
                        bArr[i2] = b;
                    }
                }
                i2 = i;
            }
            if (i2 == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }
    }

    public static class SymbolConversion implements ExtraEncoding {
        private static final IntHashtable t1 = new IntHashtable();
        private static final IntHashtable t2 = new IntHashtable();
        private static final char[] table1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', '!', 8704, '#', 8707, '%', '&', 8715, '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', '<', '=', '>', '?', 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, '[', 8756, ']', 8869, '_', 773, 945, 946, 967, 948, 949, 981, 947, 951, 953, 966, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, '{', '|', '}', '~', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8592, 8593, 8594, 8595, 176, 177, 8243, 8805, 215, 8733, 8706, 8226, 247, 8800, 8801, 8776, 8230, 9474, 9472, 8629, 8501, 8465, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 0, 0, 0, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 0, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 0};
        private static final char[] table2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', 9985, 9986, 9987, 9988, 9742, 9990, 9991, 9992, 9993, 9755, 9758, 9996, 9997, 9998, 9999, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 9733, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 10056, 10057, 10058, 10059, 9679, 10061, 9632, 10063, 10064, 10065, 10066, 9650, 9660, 9670, 10070, 9687, 10072, 10073, 10074, 10075, 10076, 10077, 10078, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 9827, 9830, 9829, 9824, 9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 10102, 10103, 10104, 10105, 10106, 10107, 10108, 10109, 10110, 10111, 10112, 10113, 10114, 10115, 10116, 10117, 10118, 10119, 10120, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129, 10130, 10131, 10132, 8594, 8596, 8597, 10136, 10137, 10138, 10139, 10140, 10141, 10142, 10143, 10144, 10145, 10146, 10147, 10148, 10149, 10150, 10151, 10152, 10153, 10154, 10155, 10156, 10157, 10158, 10159, 0, 10161, 10162, 10163, 10164, 10165, 10166, 10167, 10168, 10169, 10170, 10171, 10172, 10173, 10174, 0};
        private final char[] byteToChar;
        private IntHashtable translation;

        static {
            for (int i = 0; i < 256; i++) {
                char c = table1[i];
                if (c != 0) {
                    t1.put(c, i);
                }
            }
            for (int i2 = 0; i2 < 256; i2++) {
                char c2 = table2[i2];
                if (c2 != 0) {
                    t2.put(c2, i2);
                }
            }
        }

        public SymbolConversion(boolean z) {
            if (z) {
                this.translation = t1;
                this.byteToChar = table1;
            } else {
                this.translation = t2;
                this.byteToChar = table2;
            }
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            int length = bArr.length;
            char[] cArr = new char[length];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                cArr[i2] = this.byteToChar[bArr[i] & UnsignedBytes.MAX_VALUE];
                i++;
                i2++;
            }
            return new String(cArr, 0, i2);
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                byte b = (byte) this.translation.get(c);
                if (b != 0) {
                    bArr[i] = b;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            byte b = (byte) this.translation.get(c);
            if (b != 0) {
                return new byte[]{b};
            }
            return new byte[0];
        }
    }

    public static class Cp437Conversion implements ExtraEncoding {
        private static IntHashtable c2b = new IntHashtable();
        private static final char[] table = {Barcode128.CODE_C, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, Barcode128.FNC3, Barcode128.FNC2, 201, 230, Barcode128.SHIFT, 244, 246, 242, 251, 249, 255, 214, 220, 162, 163, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, 177, 8805, 8804, 8992, 8993, 247, 8776, 176, 8729, 183, 8730, 8319, 178, 9632, 160};

        static {
            int i = 0;
            while (true) {
                char[] cArr = table;
                if (i >= cArr.length) {
                    return;
                }
                c2b.put(cArr[i], i + 128);
                i++;
            }
        }

        private Cp437Conversion() {
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            int i;
            char[] cArr = new char[bArr.length];
            int i2 = 0;
            for (byte b : bArr) {
                int i3 = b & UnsignedBytes.MAX_VALUE;
                if (i3 >= 32) {
                    if (i3 < 128) {
                        i = i2 + 1;
                        cArr[i2] = (char) i3;
                    } else {
                        i = i2 + 1;
                        cArr[i2] = table[i3 - 128];
                    }
                    i2 = i;
                }
            }
            return new String(cArr, 0, i2);
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            int i;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i2 = 0;
            for (char c : charArray) {
                if (c < 128) {
                    i = i2 + 1;
                    bArr[i2] = (byte) c;
                } else {
                    byte b = (byte) c2b.get(c);
                    if (b != 0) {
                        i = i2 + 1;
                        bArr[i2] = b;
                    }
                }
                i2 = i;
            }
            if (i2 == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            if (c < 128) {
                return new byte[]{(byte) c};
            }
            byte b = (byte) c2b.get(c);
            if (b != 0) {
                return new byte[]{b};
            }
            return new byte[0];
        }
    }

    public static final byte[] convertToBytes(char c, String str) {
        IntHashtable intHashtable;
        int i;
        byte[] bArrCharToByte;
        if (str != null && str.length() != 0) {
            ExtraEncoding extraEncoding = extraEncodings.get(str.toLowerCase());
            if (extraEncoding != null && (bArrCharToByte = extraEncoding.charToByte(c, str)) != null) {
                return bArrCharToByte;
            }
            if (str.equals("Cp1252")) {
                intHashtable = winansi;
            } else {
                intHashtable = str.equals(PdfObject.TEXT_PDFDOCENCODING) ? pdfEncoding : null;
            }
            if (intHashtable == null) {
                if (str.equals(PdfObject.TEXT_UNICODE)) {
                    return new byte[]{-2, -1, (byte) (c >> '\b'), (byte) (c & 255)};
                }
                try {
                    CharsetEncoder charsetEncoderNewEncoder = Charset.forName(str).newEncoder();
                    charsetEncoderNewEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                    java.nio.ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.encode(CharBuffer.wrap(new char[]{c}));
                    byteBufferEncode.rewind();
                    byte[] bArr = new byte[byteBufferEncode.limit()];
                    byteBufferEncode.get(bArr);
                    return bArr;
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
            if (c >= 128 && (c <= 160 || c > 255)) {
                i = c;
                i = c;
                i = intHashtable.get(c);
            }
            if (i != 0) {
                return new byte[]{(byte) i};
            }
            return new byte[0];
        }
        return new byte[]{(byte) c};
    }
}
