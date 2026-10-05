package com.zebra.sdk.util.internal;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.formula.Area3DPtg;
import org.apache.poi.hssf.record.formula.AreaErrPtg;
import org.apache.poi.hssf.record.formula.MemFuncPtg;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefErrorPtg;
import org.apache.poi.hssf.record.formula.RefNPtg;
import org.apache.poi.hssf.record.formula.RefPtg;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class Base64 {
    private static final byte[] ALPHABET;
    private static final byte[] DECODABET;
    public static final int DECODE = 0;
    public static final int DONT_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    public static final int GZIP = 2;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    public static final int NO_OPTIONS = 0;
    private static final String PREFERRED_ENCODING = "UTF-8";
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] _NATIVE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, AreaErrPtg.sid, DocWriter.FORWARD};

    public static class InputStream extends FilterInputStream {
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private boolean encode;
        private int lineLength;
        private int numSigBytes;
        private int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++) {
                        try {
                            int i4 = ((FilterInputStream) this).in.read();
                            if (i4 >= 0) {
                                bArr[i3] = (byte) i4;
                                i2++;
                            }
                        } catch (IOException e) {
                            if (i3 == 0) {
                                throw e;
                            }
                        }
                    }
                    if (i2 <= 0) {
                        return -1;
                    }
                    Base64.encode3to4(bArr, 0, i2, this.buffer, 0);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i5 = 0;
                    while (i5 < 4) {
                        do {
                            i = ((FilterInputStream) this).in.read();
                            if (i < 0) {
                                break;
                            }
                        } while (Base64.DECODABET[i & ShapeTypes.VERTICAL_SCROLL] <= -5);
                        if (i < 0) {
                            break;
                        }
                        bArr2[i5] = (byte) i;
                        i5++;
                    }
                    if (i5 != 4) {
                        if (i5 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.numSigBytes = Base64.decode4to3(bArr2, 0, this.buffer, 0);
                    this.position = 0;
                }
            }
            int i6 = this.position;
            if (i6 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i6 >= this.numSigBytes) {
                return -1;
            }
            if (this.encode && this.breakLines && this.lineLength >= 76) {
                this.lineLength = 0;
                return 10;
            }
            this.lineLength++;
            byte[] bArr3 = this.buffer;
            int i7 = i6 + 1;
            this.position = i7;
            byte b = bArr3[i6];
            if (i7 >= this.bufferLength) {
                this.position = -1;
            }
            return b & 255;
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.breakLines = (i & 8) != 8;
            boolean z = (i & 1) == 1;
            this.encode = z;
            int i2 = z ? 4 : 3;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = -1;
            this.lineLength = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                int i4 = read();
                if (i4 >= 0) {
                    bArr[i + i3] = (byte) i4;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class OutputStream extends FilterOutputStream {
        private byte[] b4;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private boolean encode;
        private int lineLength;
        private int position;
        private boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            ((FilterOutputStream) this).out = null;
        }

        public void flushBase64() throws IOException {
            int i = this.position;
            if (i > 0) {
                if (!this.encode) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(Base64.encode3to4(this.b4, this.buffer, i));
                this.position = 0;
            }
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(i);
                return;
            }
            if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = this.bufferLength;
                if (i3 < i4) {
                    return;
                }
                ((FilterOutputStream) this).out.write(Base64.encode3to4(this.b4, bArr, i4));
                int i5 = this.lineLength + 4;
                this.lineLength = i5;
                if (this.breakLines && i5 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.lineLength = 0;
                }
            } else {
                byte[] bArr2 = Base64.DECODABET;
                int i6 = i & ShapeTypes.VERTICAL_SCROLL;
                if (bArr2[i6] <= -5) {
                    if (Base64.DECODABET[i6] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr3 = this.buffer;
                int i7 = this.position;
                int i8 = i7 + 1;
                this.position = i8;
                bArr3[i7] = (byte) i;
                if (i8 < this.bufferLength) {
                    return;
                }
                ((FilterOutputStream) this).out.write(this.b4, 0, Base64.decode4to3(bArr3, 0, this.b4, 0));
            }
            this.position = 0;
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            this.breakLines = (i & 8) != 8;
            boolean z = (i & 1) == 1;
            this.encode = z;
            int i2 = z ? 3 : 4;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    static {
        byte[] bytes;
        try {
            bytes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = _NATIVE_ALPHABET;
        }
        ALPHABET = bytes;
        DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.GT, -9, -9, -9, 63, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, Ref3DPtg.sid, Area3DPtg.sid, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31, 32, 33, 34, 35, RefPtg.sid, 37, 38, 39, 40, MemFuncPtg.sid, RefErrorPtg.sid, AreaErrPtg.sid, RefNPtg.sid, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9};
    }

    private Base64() {
    }

    public static byte[] decode(String str) {
        return decode(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte b = bArr[i + 2];
        if (b == 61) {
            byte[] bArr3 = DECODABET;
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] & 255) << 12) | ((bArr3[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b2 = bArr[i + 3];
        if (b2 == 61) {
            byte[] bArr4 = DECODABET;
            int i3 = ((bArr4[bArr[i + 1]] & 255) << 12) | ((bArr4[bArr[i]] & 255) << 18) | ((bArr4[b] & 255) << 6);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        }
        try {
            byte[] bArr5 = DECODABET;
            int i4 = ((bArr5[bArr[i + 1]] & 255) << 12) | ((bArr5[bArr[i]] & 255) << 18) | ((bArr5[b] & 255) << 6) | (bArr5[b2] & 255);
            bArr2[i2] = (byte) (i4 >> 16);
            bArr2[i2 + 1] = (byte) (i4 >> 8);
            bArr2[i2 + 2] = (byte) i4;
            return 3;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static byte[] decodeFromFile(String str) throws Throwable {
        byte[] bArr;
        InputStream inputStream = null;
        byte[] bArr2 = null;
        InputStream inputStream2 = null;
        try {
            File file = new File(str);
            if (file.length() > 2147483647L) {
                try {
                    throw null;
                } catch (Exception unused) {
                    return null;
                }
            }
            byte[] bArr3 = new byte[(int) file.length()];
            InputStream inputStream3 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
            int i = 0;
            while (true) {
                try {
                    int i2 = inputStream3.read(bArr3, i, 4096);
                    if (i2 < 0) {
                        bArr2 = new byte[i];
                        System.arraycopy(bArr3, 0, bArr2, 0, i);
                        try {
                            inputStream3.close();
                            return bArr2;
                        } catch (Exception unused2) {
                            return bArr2;
                        }
                    }
                    i += i2;
                } catch (IOException unused3) {
                    bArr = bArr2;
                    inputStream2 = inputStream3;
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream3;
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        } catch (IOException unused5) {
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            inputStream2.close();
        } catch (Exception unused6) {
        }
        return bArr;
    }

    public static boolean decodeToFile(String str, String str2) throws Throwable {
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("UTF-8"));
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
                return true;
            } catch (IOException unused2) {
                outputStream = outputStream2;
                try {
                    outputStream.close();
                    return false;
                } catch (Exception unused3) {
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.ObjectInputStream] */
    public static Object decodeToObject(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        ?? Decode = decode(str);
        Object object = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(Decode);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        object = objectInputStream.readObject();
                        Decode = objectInputStream;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        Decode = objectInputStream;
                    } catch (ClassNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        Decode = objectInputStream;
                    }
                } catch (IOException e3) {
                    e = e3;
                    objectInputStream = null;
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    objectInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    Decode = 0;
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        Decode.close();
                        throw th;
                    } catch (Exception unused2) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            objectInputStream = null;
            byteArrayInputStream = null;
        } catch (ClassNotFoundException e6) {
            e = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            Decode = 0;
        }
        try {
            byteArrayInputStream.close();
        } catch (Exception unused3) {
        }
        try {
            Decode.close();
        } catch (Exception unused4) {
        }
        return object;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            byte[] bArr3 = ALPHABET;
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 == 2) {
            byte[] bArr4 = ALPHABET;
            bArr2[i3] = bArr4[i4 >>> 18];
            bArr2[i3 + 1] = bArr4[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr4[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 != 3) {
            return bArr2;
        }
        byte[] bArr5 = ALPHABET;
        bArr2[i3] = bArr5[i4 >>> 18];
        bArr2[i3 + 1] = bArr5[(i4 >>> 12) & 63];
        bArr2[i3 + 2] = bArr5[(i4 >>> 6) & 63];
        bArr2[i3 + 3] = bArr5[i4 & 63];
        return bArr2;
    }

    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, 0, bArr.length, 0);
    }

    public static String encodeFromFile(String str) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[(int) (file.length() * 1.4d)];
            inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            int i = 0;
            while (true) {
                try {
                    int i2 = inputStream.read(bArr, i, 4096);
                    if (i2 < 0) {
                        break;
                    }
                    i += i2;
                } catch (IOException unused) {
                    try {
                        inputStream.close();
                        return null;
                    } catch (Exception unused2) {
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    try {
                        inputStream2.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i, "UTF-8");
            try {
                inputStream.close();
            } catch (Exception unused4) {
            }
            return str2;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, 0);
    }

    public static boolean encodeToFile(byte[] bArr, String str) throws Throwable {
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str), 1);
            try {
                outputStream2.write(bArr);
                try {
                    outputStream2.close();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            } catch (IOException unused2) {
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused3) {
                }
                return false;
            } catch (Throwable th) {
                th = th;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static byte[] decode(String str, boolean z) throws Throwable {
        byte[] bytes;
        ByteArrayInputStream byteArrayInputStream;
        CustomGZIPInputStream customGZIPInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] bArrDecode = decode(bytes, 0, bytes.length);
        if (bArrDecode != null && bArrDecode.length >= 4) {
            ?? r3 = 65280;
            if (35615 == ((bArrDecode[0] & 255) | ((bArrDecode[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) || z) {
                byte[] bArr = new byte[512];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byteArrayInputStream3 = new ByteArrayInputStream(bArrDecode);
                            try {
                                customGZIPInputStream = new CustomGZIPInputStream(byteArrayInputStream3);
                                while (true) {
                                    try {
                                        int i = customGZIPInputStream.read(bArr);
                                        if (i < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    } catch (IOException unused2) {
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayInputStream2 = byteArrayInputStream3;
                                        byteArrayOutputStream.close();
                                        r3 = byteArrayInputStream2;
                                    } catch (Throwable th) {
                                        th = th;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayInputStream = byteArrayInputStream3;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            customGZIPInputStream.close();
                                        } catch (Exception unused4) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (Exception unused5) {
                                            throw th;
                                        }
                                    }
                                }
                                bArrDecode = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                                r3 = byteArrayInputStream3;
                            } catch (IOException unused6) {
                                customGZIPInputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                customGZIPInputStream = null;
                            }
                        } catch (IOException unused7) {
                            byteArrayInputStream3 = null;
                            customGZIPInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayInputStream3 = null;
                            customGZIPInputStream = null;
                        }
                    } catch (Exception unused8) {
                    }
                } catch (IOException unused9) {
                    byteArrayInputStream2 = null;
                    customGZIPInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayInputStream = null;
                    customGZIPInputStream = null;
                }
                try {
                    customGZIPInputStream.close();
                } catch (Exception unused10) {
                }
                try {
                    r3.close();
                } catch (Exception unused11) {
                }
            }
        }
        return bArrDecode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i) {
        encode3to4(bArr2, 0, i, bArr, 0);
        return bArr;
    }

    public static String encodeBytes(byte[] bArr, int i) {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static String encodeObject(Serializable serializable, int i) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ?? objectOutputStream = i & 2;
        ?? gZIPOutputStream = i & 8;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    outputStream = new OutputStream(byteArrayOutputStream, gZIPOutputStream | 1);
                    try {
                        if (objectOutputStream == 2) {
                            gZIPOutputStream = new GZIPOutputStream(outputStream);
                            try {
                                objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                                gZIPOutputStream = gZIPOutputStream;
                            } catch (IOException e) {
                                e = e;
                                objectOutputStream = 0;
                                e.printStackTrace();
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused3) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    r1.close();
                                } catch (Exception unused5) {
                                }
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused6) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused7) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused8) {
                                    throw th;
                                }
                            }
                        } else {
                            gZIPOutputStream = 0;
                            objectOutputStream = new ObjectOutputStream(outputStream);
                        }
                        try {
                            objectOutputStream.writeObject(serializable);
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused9) {
                            }
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused10) {
                            }
                            try {
                                outputStream.close();
                            } catch (Exception unused11) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused12) {
                            }
                            try {
                                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                            } catch (UnsupportedEncodingException unused13) {
                                return new String(byteArrayOutputStream.toByteArray());
                            }
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            objectOutputStream.close();
                            gZIPOutputStream.close();
                            outputStream.close();
                            byteArrayOutputStream.close();
                            return null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        gZIPOutputStream = 0;
                        objectOutputStream = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream = 0;
                    }
                } catch (IOException e4) {
                    e = e4;
                    gZIPOutputStream = 0;
                    objectOutputStream = 0;
                    outputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    gZIPOutputStream = 0;
                    outputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                r1 = objectOutputStream;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPOutputStream = 0;
            objectOutputStream = 0;
            byteArrayOutputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = 0;
            byteArrayOutputStream = null;
            outputStream = null;
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i3 = 0;
        int iDecode4to3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = (byte) (bArr[i4] & Ascii.DEL);
            byte b2 = DECODABET[b];
            if (b2 < -5) {
                return null;
            }
            if (b2 >= -1) {
                int i5 = i3 + 1;
                bArr3[i3] = b;
                if (i5 > 3) {
                    iDecode4to3 += decode4to3(bArr3, 0, bArr2, iDecode4to3);
                    if (b == 61) {
                        break;
                    }
                    i3 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        byte[] bArr4 = new byte[iDecode4to3];
        System.arraycopy(bArr2, 0, bArr4, 0, iDecode4to3);
        return bArr4;
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        return encodeBytes(bArr, i, i2, 0);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        int i4 = i3 & 8;
        if ((i3 & 2) != 2) {
            boolean z = i4 == 0;
            int i5 = (i2 * 4) / 3;
            byte[] bArr2 = new byte[(i2 % 3 > 0 ? 4 : 0) + i5 + (z ? i5 / 76 : 0)];
            int i6 = i2 - 2;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i6) {
                encode3to4(bArr, i7 + i, 3, bArr2, i8);
                i9 += 4;
                if (z && i9 == 76) {
                    bArr2[i8 + 4] = 10;
                    i8++;
                    i9 = 0;
                }
                i7 += 3;
                i8 += 4;
            }
            if (i7 < i2) {
                encode3to4(bArr, i + i7, i2 - i7, bArr2, i8);
                i8 += 4;
            }
            try {
                return new String(bArr2, 0, i8, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr2, 0, i8);
            }
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i4 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        try {
                            gZIPOutputStream.write(bArr, i, i2);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                outputStream.close();
                            } catch (Exception unused3) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                            } catch (UnsupportedEncodingException unused5) {
                                return new String(byteArrayOutputStream.toByteArray());
                            }
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused6) {
                            }
                            try {
                                outputStream.close();
                            } catch (Exception unused7) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused8) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream2 = gZIPOutputStream;
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception unused9) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused10) {
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (Exception unused11) {
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream2.close();
                    outputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                gZIPOutputStream = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            outputStream = null;
        }
    }
}
