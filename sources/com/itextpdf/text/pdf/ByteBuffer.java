package com.itextpdf.text.pdf;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.apache.poi.hpsf.Constants;
import org.apache.poi.hssf.record.PaletteRecord;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBuffer extends OutputStream {
    private static int byteCacheSize;
    protected byte[] buf;
    protected int count;
    private static byte[][] byteCache = new byte[0][];
    private static final char[] chars = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9'};
    public static final byte ZERO = 48;
    private static final byte[] bytes = {ZERO, 49, 50, 51, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 97, 98, 99, 100, 101, 102};
    public static boolean HIGH_PRECISION = false;
    private static final DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);

    public ByteBuffer() {
        this(128);
    }

    private static byte[] convertToBytes(int i) {
        double d = i;
        int iFloor = (int) Math.floor(Math.log(d) / Math.log(10.0d));
        int i2 = i % 100;
        if (i2 != 0) {
            iFloor += 2;
        }
        int i3 = i % 10;
        if (i3 != 0) {
            iFloor++;
        }
        if (i < 100) {
            iFloor = i < 10 ? iFloor + 2 : iFloor + 1;
        }
        byte[] bArr = new byte[iFloor - 1];
        int i4 = iFloor - 2;
        if (i < 100) {
            bArr[0] = ZERO;
        }
        if (i3 != 0) {
            bArr[i4] = bytes[i3];
            i4 = iFloor - 3;
        }
        if (i2 != 0) {
            bArr[i4] = bytes[(i / 10) % 10];
            bArr[i4 - 1] = 46;
        }
        int iFloor2 = ((int) Math.floor(Math.log(d) / Math.log(10.0d))) - 1;
        for (int i5 = 0; i5 < iFloor2; i5++) {
            bArr[i5] = bytes[(i / ((int) Math.pow(10.0d, (iFloor2 - i5) + 1))) % 10];
        }
        return bArr;
    }

    public static void fillCache(int i) {
        int i2 = i != 0 ? i != 1 ? 1 : 10 : 100;
        for (int i3 = 1; i3 < byteCacheSize; i3 += i2) {
            byte[][] bArr = byteCache;
            if (bArr[i3] == null) {
                bArr[i3] = convertToBytes(i3);
            }
        }
    }

    public static String formatDouble(double d) {
        return formatDouble(d, null);
    }

    public static void setCacheSize(int i) {
        if (i > 3276700) {
            i = 3276700;
        }
        int i2 = byteCacheSize;
        if (i <= i2) {
            return;
        }
        byte[][] bArr = new byte[i][];
        System.arraycopy(byteCache, 0, bArr, 0, i2);
        byteCache = bArr;
        byteCacheSize = i;
    }

    public ByteBuffer append(byte[] bArr, int i, int i2) {
        int i3;
        if (i >= 0 && i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0 && i2 != 0) {
            int i4 = this.count + i2;
            byte[] bArr2 = this.buf;
            if (i4 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i4)];
                System.arraycopy(this.buf, 0, bArr3, 0, this.count);
                this.buf = bArr3;
            }
            System.arraycopy(bArr, i, this.buf, this.count, i2);
            this.count = i4;
        }
        return this;
    }

    public ByteBuffer appendHex(byte b) {
        byte[] bArr = bytes;
        append(bArr[(b >> 4) & 15]);
        return append(bArr[b & 15]);
    }

    public ByteBuffer append_i(int i) {
        int i2 = this.count + 1;
        byte[] bArr = this.buf;
        if (i2 > bArr.length) {
            byte[] bArr2 = new byte[Math.max(bArr.length << 1, i2)];
            System.arraycopy(this.buf, 0, bArr2, 0, this.count);
            this.buf = bArr2;
        }
        this.buf[this.count] = (byte) i;
        this.count = i2;
        return this;
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public void reset() {
        this.count = 0;
    }

    public void setSize(int i) {
        if (i > this.count || i < 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.getComposedMessage("the.new.size.must.be.positive.and.lt.eq.of.the.current.size", new Object[0]));
        }
        this.count = i;
    }

    public int size() {
        return this.count;
    }

    public byte[] toByteArray() {
        int i = this.count;
        byte[] bArr = new byte[i];
        System.arraycopy(this.buf, 0, bArr, 0, i);
        return bArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        append((byte) i);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.count);
    }

    public ByteBuffer(int i) {
        this.buf = new byte[i < 1 ? 128 : i];
    }

    public static String formatDouble(double d, ByteBuffer byteBuffer) {
        boolean z;
        int i;
        byte[] bArr;
        double d2 = d;
        if (HIGH_PRECISION) {
            String str = new DecimalFormat("0.######", dfs).format(d2);
            if (byteBuffer == null) {
                return str;
            }
            byteBuffer.append(str);
            return null;
        }
        if (Math.abs(d) < 1.5E-5d) {
            if (byteBuffer == null) {
                return "0";
            }
            byteBuffer.append(ZERO);
            return null;
        }
        int i2 = 0;
        if (d2 < 0.0d) {
            d2 = -d2;
            z = true;
        } else {
            z = false;
        }
        int i3 = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        if (d2 < 1.0d) {
            double d3 = d2 + 5.0E-6d;
            if (d3 >= 1.0d) {
                if (!z) {
                    if (byteBuffer == null) {
                        return "1";
                    }
                    byteBuffer.append((byte) 49);
                    return null;
                }
                if (byteBuffer == null) {
                    return "-1";
                }
                byteBuffer.append((byte) 45);
                byteBuffer.append((byte) 49);
                return null;
            }
            if (byteBuffer == null) {
                int i4 = (int) (d3 * ((double) AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength));
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append('-');
                }
                sb.append("0.");
                while (true) {
                    i3 /= 10;
                    if (i4 >= i3) {
                        break;
                    }
                    sb.append('0');
                }
                sb.append(i4);
                int length = sb.length() - 1;
                while (sb.charAt(length) == '0') {
                    length--;
                }
                sb.setLength(length + 1);
                return sb.toString();
            }
            int i5 = (int) (d3 * 100000.0d);
            if (z) {
                byteBuffer.append((byte) 45);
            }
            byteBuffer.append(ZERO);
            byteBuffer.append((byte) 46);
            byteBuffer.append((byte) ((i5 / Constants.CP_MAC_ROMAN) + 48));
            if (i5 % Constants.CP_MAC_ROMAN != 0) {
                byteBuffer.append((byte) (((i5 / 1000) % 10) + 48));
                if (i5 % 1000 != 0) {
                    byteBuffer.append((byte) (((i5 / 100) % 10) + 48));
                    if (i5 % 100 != 0) {
                        byteBuffer.append((byte) (((i5 / 10) % 10) + 48));
                        int i6 = i5 % 10;
                        if (i6 != 0) {
                            byteBuffer.append((byte) (i6 + 48));
                        }
                    }
                }
            }
            return null;
        }
        if (d2 > 32767.0d) {
            long j = (long) (d2 + 0.5d);
            if (!z) {
                return Long.toString(j);
            }
            return "-" + Long.toString(j);
        }
        int i7 = (int) ((d2 + 0.005d) * 100.0d);
        int i8 = byteCacheSize;
        if (i7 < i8 && (bArr = byteCache[i7]) != null) {
            if (byteBuffer != null) {
                if (z) {
                    byteBuffer.append((byte) 45);
                }
                byteBuffer.append(byteCache[i7]);
                return null;
            }
            String strConvertToString = PdfEncodings.convertToString(bArr, null);
            if (!z) {
                return strConvertToString;
            }
            return "-" + strConvertToString;
        }
        if (byteBuffer == null) {
            StringBuilder sb2 = new StringBuilder();
            if (z) {
                sb2.append('-');
            }
            if (i7 >= 1000000) {
                sb2.append(chars[i7 / 1000000]);
            }
            if (i7 >= 100000) {
                sb2.append(chars[(i7 / AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength) % 10]);
            }
            if (i7 >= 10000) {
                sb2.append(chars[(i7 / Constants.CP_MAC_ROMAN) % 10]);
            }
            if (i7 >= 1000) {
                sb2.append(chars[(i7 / 1000) % 10]);
            }
            if (i7 >= 100) {
                sb2.append(chars[(i7 / 100) % 10]);
            }
            if (i7 % 100 != 0) {
                sb2.append('.');
                char[] cArr = chars;
                sb2.append(cArr[(i7 / 10) % 10]);
                int i9 = i7 % 10;
                if (i9 != 0) {
                    sb2.append(cArr[i9]);
                }
            }
            return sb2.toString();
        }
        if (i7 < i8) {
            if (i7 >= 1000000) {
                i = 5;
            } else if (i7 >= 100000) {
                i = 4;
            } else if (i7 >= 10000) {
                i = 3;
            } else if (i7 >= 1000) {
                i = 2;
            } else {
                i = i7 >= 100 ? 1 : 0;
            }
            int i10 = i7 % 100;
            if (i10 != 0) {
                i += 2;
            }
            int i11 = i7 % 10;
            if (i11 != 0) {
                i++;
            }
            byte[] bArr2 = new byte[i];
            if (i7 >= 1000000) {
                bArr2[0] = bytes[i7 / 1000000];
                i2 = 1;
            }
            if (i7 >= 100000) {
                bArr2[i2] = bytes[(i7 / AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength) % 10];
                i2++;
            }
            if (i7 >= 10000) {
                bArr2[i2] = bytes[(i7 / Constants.CP_MAC_ROMAN) % 10];
                i2++;
            }
            if (i7 >= 1000) {
                bArr2[i2] = bytes[(i7 / 1000) % 10];
                i2++;
            }
            if (i7 >= 100) {
                bArr2[i2] = bytes[(i7 / 100) % 10];
                i2++;
            }
            if (i10 != 0) {
                int i12 = i2 + 1;
                bArr2[i2] = 46;
                int i13 = i2 + 2;
                byte[] bArr3 = bytes;
                bArr2[i12] = bArr3[(i7 / 10) % 10];
                if (i11 != 0) {
                    bArr2[i13] = bArr3[i11];
                }
            }
            byteCache[i7] = bArr2;
        }
        if (z) {
            byteBuffer.append((byte) 45);
        }
        if (i7 >= 1000000) {
            byteBuffer.append(bytes[i7 / 1000000]);
        }
        if (i7 >= 100000) {
            byteBuffer.append(bytes[(i7 / AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength) % 10]);
        }
        if (i7 >= 10000) {
            byteBuffer.append(bytes[(i7 / Constants.CP_MAC_ROMAN) % 10]);
        }
        if (i7 >= 1000) {
            byteBuffer.append(bytes[(i7 / 1000) % 10]);
        }
        if (i7 >= 100) {
            byteBuffer.append(bytes[(i7 / 100) % 10]);
        }
        if (i7 % 100 == 0) {
            return null;
        }
        byteBuffer.append((byte) 46);
        byte[] bArr4 = bytes;
        byteBuffer.append(bArr4[(i7 / 10) % 10]);
        int i14 = i7 % 10;
        if (i14 == 0) {
            return null;
        }
        byteBuffer.append(bArr4[i14]);
        return null;
    }

    public String toString(String str) {
        return new String(this.buf, 0, this.count, str);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        append(bArr, i, i2);
    }

    public ByteBuffer append(byte[] bArr) {
        return append(bArr, 0, bArr.length);
    }

    public ByteBuffer append(String str) {
        return str != null ? append(DocWriter.getISOBytes(str)) : this;
    }

    public ByteBuffer append(char c) {
        return append_i(c);
    }

    public ByteBuffer append(ByteBuffer byteBuffer) {
        return append(byteBuffer.buf, 0, byteBuffer.count);
    }

    public ByteBuffer append(int i) {
        return append(i);
    }

    public ByteBuffer append(long j) {
        return append(Long.toString(j));
    }

    public ByteBuffer append(byte b) {
        return append_i(b);
    }

    public ByteBuffer append(float f) {
        return append(f);
    }

    public ByteBuffer append(double d) {
        append(formatDouble(d, this));
        return this;
    }
}
