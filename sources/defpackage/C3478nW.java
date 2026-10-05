package defpackage;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: renamed from: nW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3478nW extends AbstractC3286l7 {
    public final boolean g;
    public char h;
    public int i;
    public int j;
    public final boolean k;

    public C3478nW(C0918Sr c0918Sr, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        super(c0918Sr, inputStream, bArr, i, i2);
        this.h = (char) 0;
        this.i = 0;
        this.j = 0;
        this.g = z;
        this.k = inputStream != null;
    }

    @Override // defpackage.AbstractC3286l7, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    public final boolean i(int i) throws IOException {
        int i2;
        this.j += this.e - i;
        if (i > 0) {
            if (this.d > 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    byte[] bArr = this.c;
                    bArr[i3] = bArr[this.d + i3];
                }
                this.d = 0;
            }
            this.e = i;
        } else {
            this.d = 0;
            InputStream inputStream = this.b;
            int i4 = inputStream == null ? -1 : inputStream.read(this.c);
            if (i4 < 1) {
                this.e = 0;
                if (i4 < 0) {
                    if (this.k) {
                        c();
                    }
                    return false;
                }
                g();
            }
            this.e = i4;
        }
        while (true) {
            int i5 = this.e;
            if (i5 >= 4) {
                return true;
            }
            InputStream inputStream2 = this.b;
            if (inputStream2 == null) {
                i2 = -1;
            } else {
                byte[] bArr2 = this.c;
                i2 = inputStream2.read(bArr2, i5, bArr2.length - i5);
            }
            if (i2 < 1) {
                if (i2 < 0) {
                    if (this.k) {
                        c();
                    }
                    t(this.e, 4);
                }
                g();
            }
            this.e += i2;
        }
    }

    public final void r(int i, int i2, String str) throws CharConversionException {
        int i3 = (this.j + this.d) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.i + i2) + ", byte #" + i3 + ")");
    }

    @Override // defpackage.AbstractC3286l7, java.io.Reader
    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    public final void t(int i, int i2) throws CharConversionException {
        int i3 = this.j + i;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.i + ", byte #" + i3 + ")");
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cd A[LOOP:0: B:21:0x0031->B:40:0x00cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x00be A[SYNTHETIC] */
    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws CharConversionException {
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.c == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i + i2 > cArr.length) {
            d(cArr, i, i2);
        }
        int i7 = i2 + i;
        char c = this.h;
        if (c != 0) {
            i3 = i + 1;
            cArr[i] = c;
            this.h = (char) 0;
        } else {
            int i8 = this.e - this.d;
            if (i8 < 4 && !i(i8)) {
                return -1;
            }
            i3 = i;
        }
        while (i3 < i7) {
            int i9 = this.d;
            if (this.g) {
                byte[] bArr = this.c;
                i4 = (bArr[i9] << Ascii.CAN) | ((bArr[i9 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i9 + 2] & UnsignedBytes.MAX_VALUE) << 8);
                i5 = bArr[i9 + 3] & UnsignedBytes.MAX_VALUE;
            } else {
                byte[] bArr2 = this.c;
                i4 = (bArr2[i9] & UnsignedBytes.MAX_VALUE) | ((bArr2[i9 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr2[i9 + 2] & UnsignedBytes.MAX_VALUE) << 16);
                i5 = bArr2[i9 + 3] << Ascii.CAN;
            }
            int i10 = i5 | i4;
            this.d = i9 + 4;
            if (i10 <= 65535) {
                i6 = i3 + 1;
                cArr[i3] = (char) i10;
                if (this.d >= this.e) {
                    i3 = i6;
                }
            } else {
                if (i10 > 1114111) {
                    r(i10, i3 - i, "(above " + Integer.toHexString(1114111) + ") ");
                }
                int i11 = i10 - 65536;
                i6 = i3 + 1;
                cArr[i3] = (char) ((i11 >> 10) + 55296);
                i10 = 56320 | (i11 & IEEEDouble.EXPONENT_BIAS);
                if (i6 >= i7) {
                    this.h = (char) i10;
                } else {
                    i3 = i6;
                    i6 = i3 + 1;
                    cArr[i3] = (char) i10;
                    if (this.d >= this.e) {
                        i3 = i6;
                    }
                }
            }
            i3 = i6;
            break;
        }
        int i12 = i3 - i;
        this.i += i12;
        return i12;
    }
}
