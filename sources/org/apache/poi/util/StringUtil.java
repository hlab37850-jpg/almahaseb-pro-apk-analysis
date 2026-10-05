package org.apache.poi.util;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class StringUtil {
    private static final String ENCODING_ISO_8859_1 = "ISO-8859-1";

    public static class StringsIterator implements Iterator<String> {
        private int position = 0;
        private String[] strings;

        public StringsIterator(String[] strArr) {
            if (strArr != null) {
                this.strings = strArr;
            } else {
                this.strings = new String[0];
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.strings.length;
        }

        @Override // java.util.Iterator
        public void remove() {
        }

        @Override // java.util.Iterator
        public String next() {
            int i = this.position;
            this.position = i + 1;
            String[] strArr = this.strings;
            if (i < strArr.length) {
                return strArr[i];
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    private StringUtil() {
    }

    public static String format(String str, Object[] objArr) {
        int i;
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int iMatchOptionalFormatting = 0;
        int i3 = 0;
        while (iMatchOptionalFormatting < str.length()) {
            if (str.charAt(iMatchOptionalFormatting) == '%') {
                if (i3 >= objArr.length) {
                    stringBuffer.append("?missing data?");
                } else if (!(objArr[i3] instanceof Number) || (i2 = iMatchOptionalFormatting + 1) >= str.length()) {
                    stringBuffer.append(objArr[i3].toString());
                    i3++;
                } else {
                    iMatchOptionalFormatting += matchOptionalFormatting((Number) objArr[i3], str.substring(i2), stringBuffer);
                    i3++;
                }
            } else if (str.charAt(iMatchOptionalFormatting) == '\\' && (i = iMatchOptionalFormatting + 1) < str.length() && str.charAt(i) == '%') {
                stringBuffer.append('%');
                iMatchOptionalFormatting = i;
            } else {
                stringBuffer.append(str.charAt(iMatchOptionalFormatting));
            }
            iMatchOptionalFormatting++;
        }
        return stringBuffer.toString();
    }

    public static int getEncodedSize(String str) {
        return (str.length() * (hasMultibyte(str) ? 2 : 1)) + 3;
    }

    public static String getFromCompressedUnicode(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, Math.min(i2, bArr.length - i), ENCODING_ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFromUnicodeLE(byte[] bArr, int i, int i2) {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("Illegal offset " + i + " (String data is of length " + bArr.length + ")");
        }
        if (i2 >= 0 && (bArr.length - i) / 2 >= i2) {
            try {
                return new String(bArr, i, i2 * 2, XmpWriter.UTF16LE);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("Illegal length " + i2);
    }

    public static String getPreferredEncoding() {
        return ENCODING_ISO_8859_1;
    }

    public static boolean hasMultibyte(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 255) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnicodeString(String str) {
        try {
            return !str.equals(new String(str.getBytes(ENCODING_ISO_8859_1), ENCODING_ISO_8859_1));
        } catch (UnsupportedEncodingException unused) {
            return true;
        }
    }

    private static int matchOptionalFormatting(Number number, String str, StringBuffer stringBuffer) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        if (str.length() <= 0 || !Character.isDigit(str.charAt(0))) {
            if (str.length() <= 0 || str.charAt(0) != '.' || 1 >= str.length() || !Character.isDigit(str.charAt(1))) {
                numberFormat.format(number, stringBuffer, new FieldPosition(0));
                return 1;
            }
            numberFormat.setMaximumFractionDigits(Integer.parseInt(str.charAt(1) + ""));
            numberFormat.format(number, stringBuffer, new FieldPosition(0));
            return 2;
        }
        numberFormat.setMinimumIntegerDigits(Integer.parseInt(str.charAt(0) + ""));
        if (2 >= str.length() || str.charAt(1) != '.' || !Character.isDigit(str.charAt(2))) {
            numberFormat.format(number, stringBuffer, new FieldPosition(0));
            return 1;
        }
        numberFormat.setMaximumFractionDigits(Integer.parseInt(str.charAt(2) + ""));
        numberFormat.format(number, stringBuffer, new FieldPosition(0));
        return 3;
    }

    public static void putCompressedUnicode(String str, byte[] bArr, int i) {
        try {
            byte[] bytes = str.getBytes(ENCODING_ISO_8859_1);
            System.arraycopy(bytes, 0, bArr, i, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void putUnicodeLE(String str, byte[] bArr, int i) {
        try {
            byte[] bytes = str.getBytes(XmpWriter.UTF16LE);
            System.arraycopy(bytes, 0, bArr, i, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readCompressedUnicode(LittleEndianInput littleEndianInput, int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) littleEndianInput.readUByte();
        }
        return new String(cArr);
    }

    public static String readUnicodeLE(LittleEndianInput littleEndianInput, int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) littleEndianInput.readUShort();
        }
        return new String(cArr);
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput) {
        int uShort = littleEndianInput.readUShort();
        return (littleEndianInput.readByte() & 1) == 0 ? readCompressedUnicode(littleEndianInput, uShort) : readUnicodeLE(littleEndianInput, uShort);
    }

    public static void writeUnicodeString(LittleEndianOutput littleEndianOutput, String str) {
        littleEndianOutput.writeShort(str.length());
        boolean zHasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static void writeUnicodeStringFlagAndData(LittleEndianOutput littleEndianOutput, String str) {
        boolean zHasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static void putCompressedUnicode(String str, LittleEndianOutput littleEndianOutput) {
        try {
            littleEndianOutput.write(str.getBytes(ENCODING_ISO_8859_1));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void putUnicodeLE(String str, LittleEndianOutput littleEndianOutput) {
        try {
            littleEndianOutput.write(str.getBytes(XmpWriter.UTF16LE));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput, int i) {
        if ((littleEndianInput.readByte() & 1) == 0) {
            return readCompressedUnicode(littleEndianInput, i);
        }
        return readUnicodeLE(littleEndianInput, i);
    }

    public static String getFromUnicodeLE(byte[] bArr) {
        return bArr.length == 0 ? "" : getFromUnicodeLE(bArr, 0, bArr.length / 2);
    }
}
