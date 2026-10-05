package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: wD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4189wD extends T8 {
    public ByteBuffer b;

    public C4189wD(ByteBuffer byteBuffer) {
        this.b = byteBuffer;
    }

    public static C4189wD L(int i) {
        return new C4189wD(ByteBuffer.allocate(i));
    }

    public static C4189wD N(ByteBuffer byteBuffer) {
        return new C4189wD(byteBuffer);
    }

    public static C4189wD P(byte[] bArr) {
        return new C4189wD(ByteBuffer.wrap(bArr));
    }

    @Override // defpackage.T8
    public void A(char c) {
        this.b.putChar(c);
    }

    @Override // defpackage.T8
    public void B(int i) {
        this.b.putInt(i);
    }

    @Override // defpackage.T8
    public void C(int i, int i2) {
        this.b.putInt(i, i2);
    }

    @Override // defpackage.T8
    public void D(long j) {
        this.b.putLong(j);
    }

    @Override // defpackage.T8
    public void E(short s) {
        this.b.putShort(s);
    }

    @Override // defpackage.T8
    public int F() {
        return this.b.remaining();
    }

    @Override // defpackage.T8
    public void G() {
        this.b.reset();
    }

    @Override // defpackage.T8
    public void H() {
        this.b.rewind();
    }

    @Override // defpackage.T8
    public ByteBuffer J() {
        return this.b;
    }

    @Override // defpackage.T8
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C4189wD e() {
        return new C4189wD(this.b.duplicate());
    }

    @Override // defpackage.T8
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public C4189wD I() {
        return new C4189wD(this.b.slice());
    }

    @Override // defpackage.T8
    public byte[] c() {
        return this.b.array();
    }

    @Override // defpackage.T8
    public int d() {
        return this.b.arrayOffset();
    }

    public boolean equals(Object obj) {
        return this.b.equals(obj);
    }

    @Override // defpackage.T8
    public void f() {
        this.b.flip();
    }

    @Override // defpackage.T8
    public byte h() {
        return this.b.get();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.T8
    public byte i(int i) {
        return this.b.get(i);
    }

    @Override // defpackage.T8
    public void j(byte[] bArr) {
        this.b.get(bArr);
    }

    @Override // defpackage.T8
    public void k(byte[] bArr, int i, int i2) {
        this.b.get(bArr, i, i2);
    }

    @Override // defpackage.T8
    public char l() {
        return this.b.getChar();
    }

    @Override // defpackage.T8
    public char m(int i) {
        return this.b.getChar(i);
    }

    @Override // defpackage.T8
    public int n() {
        return this.b.getInt();
    }

    @Override // defpackage.T8
    public long o() {
        return this.b.getLong();
    }

    @Override // defpackage.T8
    public short p() {
        return this.b.getShort();
    }

    @Override // defpackage.T8
    public boolean q() {
        return this.b.hasArray();
    }

    @Override // defpackage.T8
    public boolean r() {
        return this.b.hasRemaining();
    }

    @Override // defpackage.T8
    public int s() {
        return this.b.limit();
    }

    @Override // defpackage.T8
    public void t(int i) {
        this.b.limit(i);
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // defpackage.T8
    public void u() {
        this.b.mark();
    }

    @Override // defpackage.T8
    public int v() {
        return this.b.position();
    }

    @Override // defpackage.T8
    public void w(int i) {
        this.b.position(i);
    }

    @Override // defpackage.T8
    public void x(byte b) {
        this.b.put(b);
    }

    @Override // defpackage.T8
    public void y(T8 t8) {
        this.b.put(t8.J());
    }

    @Override // defpackage.T8
    public void z(byte[] bArr) {
        this.b.put(bArr);
    }
}
