package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new h("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new h("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final BaseEncoding BASE32 = new j("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new j("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE16 = new g("base16()", "0123456789ABCDEF");

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th) {
            super(th);
        }
    }

    public class a extends ByteSink {
        public final /* synthetic */ CharSink a;

        public a(CharSink charSink) {
            this.a = charSink;
        }

        @Override // com.google.common.io.ByteSink
        public OutputStream openStream() {
            return BaseEncoding.this.encodingStream(this.a.openStream());
        }
    }

    public class b extends ByteSource {
        public final /* synthetic */ CharSource a;

        public b(CharSource charSource) {
            this.a = charSource;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return BaseEncoding.this.decodingStream(this.a.openStream());
        }
    }

    public class e extends Writer {
        public final /* synthetic */ Appendable a;
        public final /* synthetic */ Writer b;

        public e(Appendable appendable, Writer writer) {
            this.a = appendable;
            this.b = writer;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class f {
        public final String a;
        public final char[] b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final byte[] g;
        public final boolean[] h;

        public f(String str, char[] cArr) {
            this.a = (String) Preconditions.checkNotNull(str);
            this.b = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int iLog2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.d = iLog2;
                int iMin = Math.min(8, Integer.lowestOneBit(iLog2));
                try {
                    this.e = 8 / iMin;
                    this.f = iLog2 / iMin;
                    this.c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c = cArr[i];
                        Preconditions.checkArgument(c < 128, "Non-ASCII character: %s", c);
                        Preconditions.checkArgument(bArr[c] == -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i;
                    }
                    this.g = bArr;
                    boolean[] zArr = new boolean[this.e];
                    for (int i2 = 0; i2 < this.f; i2++) {
                        zArr[IntMath.divide(i2 * 8, this.d, RoundingMode.CEILING)] = true;
                    }
                    this.h = zArr;
                } catch (ArithmeticException e) {
                    String str2 = new String(cArr);
                    throw new IllegalArgumentException(str2.length() != 0 ? "Illegal alphabet ".concat(str2) : new String("Illegal alphabet "), e);
                }
            } catch (ArithmeticException e2) {
                int length = cArr.length;
                StringBuilder sb = new StringBuilder(35);
                sb.append("Illegal alphabet length ");
                sb.append(length);
                throw new IllegalArgumentException(sb.toString(), e2);
            }
        }

        public boolean b(char c) {
            return c <= 127 && this.g[c] != -1;
        }

        public int c(char c) throws DecodingException {
            if (c > 127) {
                String strValueOf = String.valueOf(Integer.toHexString(c));
                throw new DecodingException(strValueOf.length() != 0 ? "Unrecognized character: 0x".concat(strValueOf) : new String("Unrecognized character: 0x"));
            }
            byte b = this.g[c];
            if (b != -1) {
                return b;
            }
            if (c <= ' ' || c == 127) {
                String strValueOf2 = String.valueOf(Integer.toHexString(c));
                throw new DecodingException(strValueOf2.length() != 0 ? "Unrecognized character: 0x".concat(strValueOf2) : new String("Unrecognized character: 0x"));
            }
            StringBuilder sb = new StringBuilder(25);
            sb.append("Unrecognized character: ");
            sb.append(c);
            throw new DecodingException(sb.toString());
        }

        public char d(int i) {
            return this.b[i];
        }

        public final boolean e() {
            for (char c : this.b) {
                if (Ascii.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return Arrays.equals(this.b, ((f) obj).b);
            }
            return false;
        }

        public final boolean f() {
            for (char c : this.b) {
                if (Ascii.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean g(int i) {
            return this.h[i % this.e];
        }

        public f h() {
            if (!f()) {
                return this;
            }
            Preconditions.checkState(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.b.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.b;
                if (i >= cArr2.length) {
                    return new f(String.valueOf(this.a).concat(".lowerCase()"), cArr);
                }
                cArr[i] = Ascii.toLowerCase(cArr2[i]);
                i++;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.b);
        }

        public boolean i(char c) {
            byte[] bArr = this.g;
            return c < bArr.length && bArr[c] != -1;
        }

        public f j() {
            if (!e()) {
                return this;
            }
            Preconditions.checkState(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.b.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.b;
                if (i >= cArr2.length) {
                    return new f(String.valueOf(this.a).concat(".upperCase()"), cArr);
                }
                cArr[i] = Ascii.toUpperCase(cArr2[i]);
                i++;
            }
        }

        public String toString() {
            return this.a;
        }
    }

    public static final class g extends j {
        public final char[] e;

        public g(String str, String str2) {
            this(new f(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.j
        public BaseEncoding b(f fVar, Character ch) {
            return new g(fVar);
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                int length = charSequence.length();
                StringBuilder sb = new StringBuilder(32);
                sb.append("Invalid input length ");
                sb.append(length);
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((this.a.c(charSequence.charAt(i)) << 4) | this.a.c(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & UnsignedBytes.MAX_VALUE;
                appendable.append(this.e[i4]);
                appendable.append(this.e[i4 | 256]);
            }
        }

        public g(f fVar) {
            super(fVar, null);
            this.e = new char[512];
            Preconditions.checkArgument(fVar.b.length == 16);
            for (int i = 0; i < 256; i++) {
                this.e[i] = fVar.d(i >>> 4);
                this.e[i | 256] = fVar.d(i & 15);
            }
        }
    }

    public static final class h extends j {
        public h(String str, String str2, Character ch) {
            this(new f(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.j
        public BaseEncoding b(f fVar, Character ch) {
            return new h(fVar, ch);
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.a.g(charSequenceTrimTrailingPadding.length())) {
                int length = charSequenceTrimTrailingPadding.length();
                StringBuilder sb = new StringBuilder(32);
                sb.append("Invalid input length ");
                sb.append(length);
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequenceTrimTrailingPadding.length()) {
                int i3 = i + 2;
                int iC = (this.a.c(charSequenceTrimTrailingPadding.charAt(i)) << 18) | (this.a.c(charSequenceTrimTrailingPadding.charAt(i + 1)) << 12);
                int i4 = i2 + 1;
                bArr[i2] = (byte) (iC >>> 16);
                if (i3 < charSequenceTrimTrailingPadding.length()) {
                    int i5 = i + 3;
                    int iC2 = iC | (this.a.c(charSequenceTrimTrailingPadding.charAt(i3)) << 6);
                    int i6 = i2 + 2;
                    bArr[i4] = (byte) ((iC2 >>> 8) & 255);
                    if (i5 < charSequenceTrimTrailingPadding.length()) {
                        i += 4;
                        i2 += 3;
                        bArr[i6] = (byte) ((iC2 | this.a.c(charSequenceTrimTrailingPadding.charAt(i5))) & 255);
                    } else {
                        i2 = i6;
                        i = i5;
                    }
                } else {
                    i2 = i4;
                    i = i3;
                }
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i3 = i + i2;
            Preconditions.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 2;
                int i5 = ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << 16);
                i += 3;
                int i6 = i5 | (bArr[i4] & UnsignedBytes.MAX_VALUE);
                appendable.append(this.a.d(i6 >>> 18));
                appendable.append(this.a.d((i6 >>> 12) & 63));
                appendable.append(this.a.d((i6 >>> 6) & 63));
                appendable.append(this.a.d(i6 & 63));
                i2 -= 3;
            }
            if (i < i3) {
                a(appendable, bArr, i, i3 - i);
            }
        }

        public h(f fVar, Character ch) {
            super(fVar, ch);
            Preconditions.checkArgument(fVar.b.length == 64);
        }
    }

    public static final class i extends BaseEncoding {
        public final BaseEncoding a;
        public final String b;
        public final int c;

        public i(BaseEncoding baseEncoding, String str, int i) {
            this.a = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.b = (String) Preconditions.checkNotNull(str);
            this.c = i;
            Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", i);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if (this.b.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.a.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if (this.b.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.a.decodeTo(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(Reader reader) {
            return this.a.decodingStream(BaseEncoding.ignoringReader(reader, this.b));
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) {
            this.a.encodeTo(BaseEncoding.separatingAppendable(appendable, this.b, this.c), bArr, i, i2);
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(Writer writer) {
            return this.a.encodingStream(BaseEncoding.separatingWriter(writer, this.b, this.c));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.a.lowerCase().withSeparator(this.b, this.c);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxDecodedSize(int i) {
            return this.a.maxDecodedSize(i);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxEncodedSize(int i) {
            int iMaxEncodedSize = this.a.maxEncodedSize(i);
            return iMaxEncodedSize + (this.b.length() * IntMath.divide(Math.max(0, iMaxEncodedSize - 1), this.c, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.a.omitPadding().withSeparator(this.b, this.c);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String str = this.b;
            int i = this.c;
            StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(str).length());
            sb.append(strValueOf);
            sb.append(".withSeparator(\"");
            sb.append(str);
            sb.append("\", ");
            sb.append(i);
            sb.append(")");
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.a.trimTrailingPadding(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.a.upperCase().withSeparator(this.b, this.c);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            return this.a.withPadChar(c).withSeparator(this.b, this.c);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    public static class j extends BaseEncoding {
        public final f a;
        public final Character b;
        public transient BaseEncoding c;
        public transient BaseEncoding d;

        public class a extends OutputStream {
            public int a = 0;
            public int b = 0;
            public int c = 0;
            public final /* synthetic */ Writer d;

            public a(Writer writer) {
                this.d = writer;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i = this.b;
                if (i > 0) {
                    int i2 = this.a;
                    f fVar = j.this.a;
                    this.d.write(fVar.d((i2 << (fVar.d - i)) & fVar.c));
                    this.c++;
                    if (j.this.b != null) {
                        while (true) {
                            int i3 = this.c;
                            j jVar = j.this;
                            if (i3 % jVar.a.e == 0) {
                                break;
                            }
                            this.d.write(jVar.b.charValue());
                            this.c++;
                        }
                    }
                }
                this.d.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.d.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                this.a = (i & 255) | (this.a << 8);
                this.b += 8;
                while (true) {
                    int i2 = this.b;
                    f fVar = j.this.a;
                    int i3 = fVar.d;
                    if (i2 < i3) {
                        return;
                    }
                    this.d.write(fVar.d((this.a >> (i2 - i3)) & fVar.c));
                    this.c++;
                    this.b -= j.this.a.d;
                }
            }
        }

        public j(String str, String str2, Character ch) {
            this(new f(str, str2.toCharArray()), ch);
        }

        public void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            Preconditions.checkArgument(i2 <= this.a.f);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | ((long) (bArr[i + i4] & UnsignedBytes.MAX_VALUE))) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.a.d;
            while (i3 < i2 * 8) {
                f fVar = this.a;
                appendable.append(fVar.d(((int) (j >>> (i5 - i3))) & fVar.c));
                i3 += this.a.d;
            }
            if (this.b != null) {
                while (i3 < this.a.f * 8) {
                    appendable.append(this.b.charValue());
                    i3 += this.a.d;
                }
            }
        }

        public BaseEncoding b(f fVar, Character ch) {
            return new j(fVar, ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.a.g(charSequenceTrimTrailingPadding.length())) {
                return false;
            }
            for (int i = 0; i < charSequenceTrimTrailingPadding.length(); i++) {
                if (!this.a.b(charSequenceTrimTrailingPadding.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            f fVar;
            Preconditions.checkNotNull(bArr);
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.a.g(charSequenceTrimTrailingPadding.length())) {
                int length = charSequenceTrimTrailingPadding.length();
                StringBuilder sb = new StringBuilder(32);
                sb.append("Invalid input length ");
                sb.append(length);
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequenceTrimTrailingPadding.length()) {
                long jC = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    fVar = this.a;
                    if (i3 >= fVar.e) {
                        break;
                    }
                    jC <<= fVar.d;
                    if (i + i3 < charSequenceTrimTrailingPadding.length()) {
                        jC |= (long) this.a.c(charSequenceTrimTrailingPadding.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = fVar.f;
                int i6 = (i5 * 8) - (i4 * fVar.d);
                int i7 = (i5 - 1) * 8;
                while (i7 >= i6) {
                    bArr[i2] = (byte) ((jC >>> i7) & 255);
                    i7 -= 8;
                    i2++;
                }
                i += this.a.e;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(Reader reader) {
            Preconditions.checkNotNull(reader);
            return new b(reader);
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                a(appendable, bArr, i + i3, Math.min(this.a.f, i2 - i3));
                i3 += this.a.f;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(Writer writer) {
            Preconditions.checkNotNull(writer);
            return new a(writer);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.a.equals(jVar.a) && Objects.equal(this.b, jVar.b);
        }

        public int hashCode() {
            return this.a.hashCode() ^ Objects.hashCode(this.b);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncodingB = this.d;
            if (baseEncodingB == null) {
                f fVarH = this.a.h();
                baseEncodingB = fVarH == this.a ? this : b(fVarH, this.b);
                this.d = baseEncodingB;
            }
            return baseEncodingB;
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxDecodedSize(int i) {
            return (int) (((((long) this.a.d) * ((long) i)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public int maxEncodedSize(int i) {
            f fVar = this.a;
            return fVar.e * IntMath.divide(i, fVar.f, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.b == null ? this : b(this.a, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.a.toString());
            if (8 % this.a.d != 0) {
                if (this.b == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.b);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.b;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncodingB = this.c;
            if (baseEncodingB == null) {
                f fVarJ = this.a.j();
                baseEncodingB = fVarJ == this.a ? this : b(fVarJ, this.b);
                this.c = baseEncodingB;
            }
            return baseEncodingB;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            Character ch;
            return (8 % this.a.d == 0 || ((ch = this.b) != null && ch.charValue() == c)) ? this : b(this.a, Character.valueOf(c));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                Preconditions.checkArgument(!this.a.i(str.charAt(i2)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.b;
            if (ch != null) {
                Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new i(this, str, i);
        }

        public j(f fVar, Character ch) {
            this.a = (f) Preconditions.checkNotNull(fVar);
            Preconditions.checkArgument(ch == null || !fVar.i(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.b = ch;
        }

        public class b extends InputStream {
            public int a = 0;
            public int b = 0;
            public int c = 0;
            public boolean d = false;
            public final /* synthetic */ Reader e;

            public b(Reader reader) {
                this.e = reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.e.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                int i;
                while (true) {
                    int i2 = this.e.read();
                    if (i2 == -1) {
                        if (this.d || j.this.a.g(this.c)) {
                            return -1;
                        }
                        int i3 = this.c;
                        StringBuilder sb = new StringBuilder(32);
                        sb.append("Invalid input length ");
                        sb.append(i3);
                        throw new DecodingException(sb.toString());
                    }
                    this.c++;
                    char c = (char) i2;
                    Character ch = j.this.b;
                    if (ch == null || ch.charValue() != c) {
                        if (this.d) {
                            int i4 = this.c;
                            StringBuilder sb2 = new StringBuilder(61);
                            sb2.append("Expected padding character but found '");
                            sb2.append(c);
                            sb2.append("' at index ");
                            sb2.append(i4);
                            throw new DecodingException(sb2.toString());
                        }
                        int i5 = this.a;
                        f fVar = j.this.a;
                        int i6 = i5 << fVar.d;
                        this.a = i6;
                        int iC = fVar.c(c) | i6;
                        this.a = iC;
                        int i7 = this.b + j.this.a.d;
                        this.b = i7;
                        if (i7 >= 8) {
                            int i8 = i7 - 8;
                            this.b = i8;
                            return (iC >> i8) & 255;
                        }
                    } else {
                        if (!this.d && ((i = this.c) == 1 || !j.this.a.g(i - 1))) {
                            int i9 = this.c;
                            StringBuilder sb3 = new StringBuilder(41);
                            sb3.append("Padding cannot start at index ");
                            sb3.append(i9);
                            throw new DecodingException(sb3.toString());
                        }
                        this.d = true;
                    }
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = i2 + i;
                Preconditions.checkPositionIndexes(i, i3, bArr.length);
                int i4 = i;
                while (i4 < i3) {
                    int i5 = read();
                    if (i5 == -1) {
                        int i6 = i4 - i;
                        if (i6 == 0) {
                            return -1;
                        }
                        return i6;
                    }
                    bArr[i4] = (byte) i5;
                    i4++;
                }
                return i4 - i;
            }
        }
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    private static byte[] extract(byte[] bArr, int i2) {
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    @GwtIncompatible
    public static Reader ignoringReader(Reader reader, String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new c(reader, str);
    }

    public static Appendable separatingAppendable(Appendable appendable, String str, int i2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i2 > 0);
        return new d(i2, appendable, str);
    }

    @GwtIncompatible
    public static Writer separatingWriter(Writer writer, String str, int i2) {
        return new e(separatingAppendable(writer, str, i2), writer);
    }

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final byte[] decodeChecked(CharSequence charSequence) {
        CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(charSequenceTrimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, charSequenceTrimTrailingPadding));
    }

    public abstract int decodeTo(byte[] bArr, CharSequence charSequence);

    @GwtIncompatible
    public final ByteSource decodingSource(CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new b(charSource);
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public abstract void encodeTo(Appendable appendable, byte[] bArr, int i2, int i3);

    @GwtIncompatible
    public final ByteSink encodingSink(CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new a(charSink);
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract int maxDecodedSize(int i2);

    public abstract int maxEncodedSize(int i2);

    public abstract BaseEncoding omitPadding();

    public CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c2);

    public abstract BaseEncoding withSeparator(String str, int i2);

    public class c extends Reader {
        public final /* synthetic */ Reader a;
        public final /* synthetic */ String b;

        public c(Reader reader, String str) {
            this.a = reader;
            this.b = str;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.a.close();
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int i;
            do {
                i = this.a.read();
                if (i == -1) {
                    break;
                }
            } while (this.b.indexOf((char) i) >= 0);
            return i;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new UnsupportedOperationException();
        }
    }

    public final String encode(byte[] bArr, int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
        StringBuilder sb = new StringBuilder(maxEncodedSize(i3));
        try {
            encodeTo(sb, bArr, i2, i3);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public class d implements Appendable {
        public int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Appendable c;
        public final /* synthetic */ String d;

        public d(int i, Appendable appendable, String str) {
            this.b = i;
            this.c = appendable;
            this.d = str;
            this.a = i;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.a == 0) {
                this.c.append(this.d);
                this.a = this.b;
            }
            this.c.append(c);
            this.a--;
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            throw new UnsupportedOperationException();
        }
    }
}
