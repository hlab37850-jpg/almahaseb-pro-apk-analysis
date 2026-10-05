package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public final class V8 {
    public final C0918Sr a;
    public final InputStream b;
    public final byte[] c;
    public int d;
    public int e;
    public final boolean f;
    public int g;
    public boolean h;
    public int i;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4078uu.values().length];
            a = iArr;
            try {
                iArr[EnumC4078uu.UTF32_BE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC4078uu.UTF32_LE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC4078uu.UTF16_BE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC4078uu.UTF16_LE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC4078uu.UTF8.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public V8(C0918Sr c0918Sr, InputStream inputStream) {
        this.h = true;
        this.i = 0;
        this.a = c0918Sr;
        this.b = inputStream;
        this.c = c0918Sr.b();
        this.d = 0;
        this.e = 0;
        this.g = 0;
        this.f = true;
    }

    public final boolean a(int i) {
        if ((65280 & i) == 0) {
            this.h = true;
        } else {
            if ((i & 255) != 0) {
                return false;
            }
            this.h = false;
        }
        this.i = 2;
        return true;
    }

    public final boolean b(int i) throws CharConversionException {
        if ((i >> 8) == 0) {
            this.h = true;
        } else if ((16777215 & i) == 0) {
            this.h = false;
        } else if (((-16711681) & i) == 0) {
            h("3412");
        } else {
            if ((i & (-65281)) != 0) {
                return false;
            }
            h("2143");
        }
        this.i = 4;
        return true;
    }

    public JsonParser c(int i, AbstractC2263gE abstractC2263gE, X8 x8, C3729qb c3729qb, boolean z, boolean z2) {
        if (e() != EnumC4078uu.UTF8 || !z) {
            return new C4114vJ(this.a, i, d(), abstractC2263gE, c3729qb.k(z, z2));
        }
        return new C3642pW(this.a, i, this.b, abstractC2263gE, x8.p(z, z2), this.c, this.d, this.e, this.f);
    }

    public Reader d() {
        EnumC4078uu enumC4078uuF = this.a.f();
        int i = a.a[enumC4078uuF.ordinal()];
        if (i == 1 || i == 2) {
            C0918Sr c0918Sr = this.a;
            return new C3478nW(c0918Sr, this.b, this.c, this.d, this.e, c0918Sr.f().b());
        }
        if (i != 3 && i != 4 && i != 5) {
            throw new RuntimeException("Internal error");
        }
        InputStream ob = this.b;
        if (ob == null) {
            ob = new ByteArrayInputStream(this.c, this.d, this.e);
        } else if (this.d < this.e) {
            ob = new OB(this.a, ob, this.c, this.d, this.e);
        }
        return new InputStreamReader(ob, enumC4078uuF.a());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0081  */
    public EnumC4078uu e() {
        int i;
        EnumC4078uu enumC4078uu;
        if (f(4)) {
            byte[] bArr = this.c;
            int i2 = this.d;
            int i3 = (bArr[i2 + 3] & UnsignedBytes.MAX_VALUE) | (bArr[i2] << Ascii.CAN) | ((bArr[i2 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i2 + 2] & UnsignedBytes.MAX_VALUE) << 8);
            if (g(i3) || b(i3) || a(i3 >>> 16)) {
                i = this.i;
                if (i != 1) {
                    enumC4078uu = EnumC4078uu.UTF8;
                } else if (i != 2) {
                    if (i == 4) {
                        throw new RuntimeException("Internal error");
                    }
                    if (this.h) {
                        enumC4078uu = EnumC4078uu.UTF32_BE;
                    } else {
                        enumC4078uu = EnumC4078uu.UTF32_LE;
                    }
                } else if (this.h) {
                    enumC4078uu = EnumC4078uu.UTF16_BE;
                } else {
                    enumC4078uu = EnumC4078uu.UTF16_LE;
                }
            } else {
                enumC4078uu = EnumC4078uu.UTF8;
            }
        } else {
            if (f(2)) {
                byte[] bArr2 = this.c;
                int i4 = this.d;
                if (a((bArr2[i4 + 1] & UnsignedBytes.MAX_VALUE) | ((bArr2[i4] & UnsignedBytes.MAX_VALUE) << 8))) {
                    i = this.i;
                    if (i != 1) {
                        enumC4078uu = EnumC4078uu.UTF8;
                    } else if (i != 2) {
                        if (i == 4) {
                            throw new RuntimeException("Internal error");
                        }
                        if (this.h) {
                            enumC4078uu = EnumC4078uu.UTF32_BE;
                        } else {
                            enumC4078uu = EnumC4078uu.UTF32_LE;
                        }
                    } else if (this.h) {
                        enumC4078uu = EnumC4078uu.UTF16_BE;
                    } else {
                        enumC4078uu = EnumC4078uu.UTF16_LE;
                    }
                }
            }
            enumC4078uu = EnumC4078uu.UTF8;
        }
        this.a.n(enumC4078uu);
        return enumC4078uu;
    }

    public boolean f(int i) throws IOException {
        int i2;
        int i3 = this.e - this.d;
        while (i3 < i) {
            InputStream inputStream = this.b;
            if (inputStream == null) {
                i2 = -1;
            } else {
                byte[] bArr = this.c;
                int i4 = this.e;
                i2 = inputStream.read(bArr, i4, bArr.length - i4);
            }
            if (i2 < 1) {
                return false;
            }
            this.e += i2;
            i3 += i2;
        }
        return true;
    }

    public final boolean g(int i) throws CharConversionException {
        if (i == -16842752) {
            h("3412");
        } else {
            if (i == -131072) {
                this.d += 4;
                this.i = 4;
                this.h = false;
                return true;
            }
            if (i == 65279) {
                this.h = true;
                this.d += 4;
                this.i = 4;
                return true;
            }
            if (i == 65534) {
                h("2143");
                h("3412");
            }
        }
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this.d += 2;
            this.i = 2;
            this.h = true;
            return true;
        }
        if (i2 == 65534) {
            this.d += 2;
            this.i = 2;
            this.h = false;
            return true;
        }
        if ((i >>> 8) != 15711167) {
            return false;
        }
        this.d += 3;
        this.i = 1;
        this.h = true;
        return true;
    }

    public final void h(String str) throws CharConversionException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    public V8(C0918Sr c0918Sr, byte[] bArr, int i, int i2) {
        this.h = true;
        this.i = 0;
        this.a = c0918Sr;
        this.b = null;
        this.c = bArr;
        this.d = i;
        this.e = i2 + i;
        this.g = -i;
        this.f = false;
    }
}
