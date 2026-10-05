package com.fasterxml.jackson.core;

import defpackage.AbstractC2263gE;
import defpackage.C0693Ki;
import defpackage.C0918Sr;
import defpackage.C3560oW;
import defpackage.C3723qW;
import defpackage.C3729qb;
import defpackage.C4114vJ;
import defpackage.EnumC4078uu;
import defpackage.IO;
import defpackage.J8;
import defpackage.V8;
import defpackage.VZ;
import defpackage.X8;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class JsonFactory implements Serializable {
    public static final int g = a.a();
    public static final int h = JsonParser.Feature.a();
    public static final int i = com.fasterxml.jackson.core.a.EnumC0168a.a();
    public static final IO j = C0693Ki.f;
    public static final ThreadLocal k = new ThreadLocal();
    public final transient C3729qb a;
    public final transient X8 b;
    public int c;
    public int d;
    public int e;
    public IO f;

    public enum a {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);

        public final boolean a;

        a(boolean z) {
            this.a = z;
        }

        public static int a() {
            int iC = 0;
            for (a aVar : values()) {
                if (aVar.b()) {
                    iC |= aVar.c();
                }
            }
            return iC;
        }

        public boolean b() {
            return this.a;
        }

        public int c() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public C0918Sr a(Object obj, boolean z) {
        return new C0918Sr(n(), obj, z);
    }

    public com.fasterxml.jackson.core.a b(Writer writer, C0918Sr c0918Sr) {
        return c(writer, c0918Sr);
    }

    public com.fasterxml.jackson.core.a c(Writer writer, C0918Sr c0918Sr) {
        VZ vz = new VZ(c0918Sr, this.e, null, writer);
        IO io = this.f;
        if (io != j) {
            vz.U(io);
        }
        return vz;
    }

    public JsonParser e(InputStream inputStream, C0918Sr c0918Sr) {
        return new V8(c0918Sr, inputStream).c(this.d, null, this.b, this.a, z(a.CANONICALIZE_FIELD_NAMES), z(a.INTERN_FIELD_NAMES));
    }

    public JsonParser f(Reader reader, C0918Sr c0918Sr) {
        return new C4114vJ(c0918Sr, this.d, reader, null, this.a.k(z(a.CANONICALIZE_FIELD_NAMES), z(a.INTERN_FIELD_NAMES)));
    }

    public JsonParser h(byte[] bArr, int i2, int i3, C0918Sr c0918Sr) {
        return new V8(c0918Sr, bArr, i2, i3).c(this.d, null, this.b, this.a, z(a.CANONICALIZE_FIELD_NAMES), z(a.INTERN_FIELD_NAMES));
    }

    public JsonParser i(InputStream inputStream, C0918Sr c0918Sr) {
        return e(inputStream, c0918Sr);
    }

    public JsonParser j(Reader reader, C0918Sr c0918Sr) {
        return f(reader, c0918Sr);
    }

    public JsonParser k(byte[] bArr, int i2, int i3, C0918Sr c0918Sr) {
        return h(bArr, i2, i3, c0918Sr);
    }

    public com.fasterxml.jackson.core.a l(OutputStream outputStream, C0918Sr c0918Sr) {
        C3560oW c3560oW = new C3560oW(c0918Sr, this.e, null, outputStream);
        IO io = this.f;
        if (io != j) {
            c3560oW.U(io);
        }
        return c3560oW;
    }

    public Writer m(OutputStream outputStream, EnumC4078uu enumC4078uu, C0918Sr c0918Sr) {
        return enumC4078uu == EnumC4078uu.UTF8 ? new C3723qW(c0918Sr, outputStream) : new OutputStreamWriter(outputStream, enumC4078uu.a());
    }

    public J8 n() {
        ThreadLocal threadLocal = k;
        SoftReference softReference = (SoftReference) threadLocal.get();
        J8 j8 = softReference == null ? null : (J8) softReference.get();
        if (j8 != null) {
            return j8;
        }
        J8 j9 = new J8();
        threadLocal.set(new SoftReference(j9));
        return j9;
    }

    public final JsonFactory o(com.fasterxml.jackson.core.a.EnumC0168a enumC0168a, boolean z) {
        return z ? y(enumC0168a) : x(enumC0168a);
    }

    public com.fasterxml.jackson.core.a p(OutputStream outputStream, EnumC4078uu enumC4078uu) {
        C0918Sr c0918SrA = a(outputStream, false);
        c0918SrA.n(enumC4078uu);
        return enumC4078uu == EnumC4078uu.UTF8 ? l(outputStream, c0918SrA) : b(m(outputStream, enumC4078uu, c0918SrA), c0918SrA);
    }

    public com.fasterxml.jackson.core.a q(Writer writer) {
        return b(writer, a(writer, false));
    }

    public JsonParser r(InputStream inputStream) {
        return i(inputStream, a(inputStream, false));
    }

    public JsonParser s(Reader reader) {
        return j(reader, a(reader, false));
    }

    public JsonParser t(String str) {
        Reader stringReader = new StringReader(str);
        return j(stringReader, a(stringReader, true));
    }

    public JsonParser u(byte[] bArr) {
        return k(bArr, 0, bArr.length, a(bArr, true));
    }

    public JsonParser v(String str) {
        return t(str);
    }

    public JsonParser w(byte[] bArr) {
        return u(bArr);
    }

    public JsonFactory x(com.fasterxml.jackson.core.a.EnumC0168a enumC0168a) {
        this.e = (~enumC0168a.c()) & this.e;
        return this;
    }

    public JsonFactory y(com.fasterxml.jackson.core.a.EnumC0168a enumC0168a) {
        this.e = enumC0168a.c() | this.e;
        return this;
    }

    public final boolean z(a aVar) {
        return (aVar.c() & this.c) != 0;
    }

    public JsonFactory(AbstractC2263gE abstractC2263gE) {
        this.a = C3729qb.f();
        this.b = X8.g();
        this.c = g;
        this.d = h;
        this.e = i;
        this.f = j;
    }
}
