package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class W4 extends T8 {
    public final byte[] b;
    public int c;
    public int d;
    public int e;
    public int f;

    public W4(byte[] bArr) {
        this(bArr, 0, 0, bArr == null ? 0 : bArr.length);
    }

    public static T8 K(byte[] bArr) {
        return new W4(bArr);
    }

    public static T8 b(int i) {
        return new W4(new byte[i]);
    }

    @Override // defpackage.T8
    public void A(char c) {
        x((byte) ((c >> '\b') & 255));
        x((byte) (c & 255));
    }

    @Override // defpackage.T8
    public void B(int i) {
        x((byte) ((i >> 24) & 255));
        x((byte) ((i >> 16) & 255));
        x((byte) ((i >> 8) & 255));
        x((byte) (i & 255));
    }

    @Override // defpackage.T8
    public void C(int i, int i2) {
        L(i, (byte) ((i2 >> 24) & 255));
        L(i + 1, (byte) ((i2 >> 16) & 255));
        L(i + 2, (byte) ((i2 >> 8) & 255));
        L(i + 3, (byte) (i2 & 255));
    }

    @Override // defpackage.T8
    public void D(long j) {
        x((byte) ((j >> 56) & 255));
        x((byte) ((j >> 48) & 255));
        x((byte) ((j >> 40) & 255));
        x((byte) ((j >> 32) & 255));
        x((byte) ((j >> 24) & 255));
        x((byte) ((j >> 16) & 255));
        x((byte) ((j >> 8) & 255));
        x((byte) (j & 255));
    }

    @Override // defpackage.T8
    public void E(short s) {
        x((byte) ((s >> 8) & 255));
        x((byte) (s & 255));
    }

    @Override // defpackage.T8
    public int F() {
        return this.e - this.d;
    }

    @Override // defpackage.T8
    public void G() {
        this.d = this.f;
    }

    @Override // defpackage.T8
    public void H() {
        this.d = this.c;
    }

    @Override // defpackage.T8
    public T8 I() {
        byte[] bArr = this.b;
        int i = this.d;
        return new W4(bArr, i, i, this.e);
    }

    @Override // defpackage.T8
    public ByteBuffer J() {
        byte[] bArr = this.b;
        int i = this.d;
        return ByteBuffer.wrap(bArr, i, this.e - i);
    }

    public void L(int i, byte b) {
        this.b[i + this.c] = b;
    }

    @Override // defpackage.T8
    public byte[] c() {
        return this.b;
    }

    @Override // defpackage.T8
    public int d() {
        return this.c;
    }

    @Override // defpackage.T8
    public T8 e() {
        return new W4(this.b, this.c, this.d, this.e);
    }

    @Override // defpackage.T8
    public void f() {
        this.e = this.d;
        this.d = this.c;
    }

    @Override // defpackage.T8
    public byte h() {
        byte[] bArr = this.b;
        int i = this.d;
        this.d = i + 1;
        return bArr[i];
    }

    @Override // defpackage.T8
    public byte i(int i) {
        return this.b[i + this.c];
    }

    @Override // defpackage.T8
    public void j(byte[] bArr) {
        System.arraycopy(this.b, this.d, bArr, 0, bArr.length);
        this.d += bArr.length;
    }

    @Override // defpackage.T8
    public void k(byte[] bArr, int i, int i2) {
        System.arraycopy(this.b, this.d, bArr, i, i2);
        this.d += i2;
    }

    @Override // defpackage.T8
    public char l() {
        return (char) (((h() & UnsignedBytes.MAX_VALUE) << 8) + (h() & UnsignedBytes.MAX_VALUE));
    }

    @Override // defpackage.T8
    public char m(int i) {
        return (char) (((i(i) & UnsignedBytes.MAX_VALUE) << 8) + (i(i + 1) & UnsignedBytes.MAX_VALUE));
    }

    @Override // defpackage.T8
    public int n() {
        int i = this.d;
        byte[] bArr = this.b;
        int i2 = ((bArr[i] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i + 3] & UnsignedBytes.MAX_VALUE);
        this.d = i + 4;
        return i2;
    }

    @Override // defpackage.T8
    public long o() {
        return (((((((((((((((long) (h() & UnsignedBytes.MAX_VALUE)) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE))) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE))) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE))) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE))) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE))) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE))) << 8) + ((long) (h() & UnsignedBytes.MAX_VALUE));
    }

    @Override // defpackage.T8
    public short p() {
        byte[] bArr = this.b;
        int i = this.d;
        int i2 = ((bArr[i] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i + 1] & UnsignedBytes.MAX_VALUE);
        this.d = i + 2;
        return (short) i2;
    }

    @Override // defpackage.T8
    public boolean q() {
        return true;
    }

    @Override // defpackage.T8
    public boolean r() {
        return this.d < this.e;
    }

    @Override // defpackage.T8
    public int s() {
        return this.e - this.c;
    }

    @Override // defpackage.T8
    public void t(int i) {
        this.e = this.c + i;
    }

    @Override // defpackage.T8
    public void u() {
        this.f = this.d;
    }

    @Override // defpackage.T8
    public int v() {
        return this.d - this.c;
    }

    @Override // defpackage.T8
    public void w(int i) {
        this.d = i + this.c;
    }

    @Override // defpackage.T8
    public void x(byte b) {
        byte[] bArr = this.b;
        int i = this.d;
        this.d = i + 1;
        bArr[i] = b;
    }

    @Override // defpackage.T8
    public void y(T8 t8) {
        int iF = t8.F();
        System.arraycopy(t8.c(), t8.v() + t8.d(), this.b, this.d, iF);
        this.d += iF;
    }

    @Override // defpackage.T8
    public void z(byte[] bArr) {
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.b, this.d, length);
        this.d += length;
    }

    public W4(byte[] bArr, int i, int i2, int i3) {
        this.b = bArr;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }
}
