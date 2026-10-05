package defpackage;

/* JADX INFO: renamed from: Sr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0918Sr {
    public final Object a;
    public EnumC4078uu b;
    public final boolean c;
    public final J8 d;
    public byte[] e = null;
    public byte[] f = null;
    public byte[] g = null;
    public char[] h = null;
    public char[] i = null;
    public char[] j = null;

    public C0918Sr(J8 j8, Object obj, boolean z) {
        this.d = j8;
        this.a = obj;
        this.c = z;
    }

    public char[] a() {
        if (this.i != null) {
            throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
        }
        char[] cArrB = this.d.b(J8.b.CONCAT_BUFFER);
        this.i = cArrB;
        return cArrB;
    }

    public byte[] b() {
        if (this.e != null) {
            throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
        }
        byte[] bArrA = this.d.a(J8.a.READ_IO_BUFFER);
        this.e = bArrA;
        return bArrA;
    }

    public char[] c() {
        if (this.h != null) {
            throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
        }
        char[] cArrB = this.d.b(J8.b.TOKEN_BUFFER);
        this.h = cArrB;
        return cArrB;
    }

    public byte[] d() {
        if (this.f != null) {
            throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
        }
        byte[] bArrA = this.d.a(J8.a.WRITE_ENCODING_BUFFER);
        this.f = bArrA;
        return bArrA;
    }

    public C1876cU e() {
        return new C1876cU(this.d);
    }

    public EnumC4078uu f() {
        return this.b;
    }

    public Object g() {
        return this.a;
    }

    public boolean h() {
        return this.c;
    }

    public void i(char[] cArr) {
        if (cArr != null) {
            if (cArr != this.i) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.i = null;
            this.d.g(J8.b.CONCAT_BUFFER, cArr);
        }
    }

    public void j(char[] cArr) {
        if (cArr != null) {
            if (cArr != this.j) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.j = null;
            this.d.g(J8.b.NAME_COPY_BUFFER, cArr);
        }
    }

    public void k(byte[] bArr) {
        if (bArr != null) {
            if (bArr != this.e) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.e = null;
            this.d.f(J8.a.READ_IO_BUFFER, bArr);
        }
    }

    public void l(char[] cArr) {
        if (cArr != null) {
            if (cArr != this.h) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.h = null;
            this.d.g(J8.b.TOKEN_BUFFER, cArr);
        }
    }

    public void m(byte[] bArr) {
        if (bArr != null) {
            if (bArr != this.f) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.f = null;
            this.d.f(J8.a.WRITE_ENCODING_BUFFER, bArr);
        }
    }

    public void n(EnumC4078uu enumC4078uu) {
        this.b = enumC4078uu;
    }
}
