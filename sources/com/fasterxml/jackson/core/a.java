package com.fasterxml.jackson.core;

import defpackage.IO;
import defpackage.KH;
import java.io.Closeable;
import java.io.Flushable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Closeable, Flushable {
    public KH a;

    /* JADX INFO: renamed from: com.fasterxml.jackson.core.a$a, reason: collision with other inner class name */
    public enum EnumC0168a {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false);

        public final boolean a;
        public final int b = 1 << ordinal();

        EnumC0168a(boolean z) {
            this.a = z;
        }

        public static int a() {
            int iC = 0;
            for (EnumC0168a enumC0168a : values()) {
                if (enumC0168a.b()) {
                    iC |= enumC0168a.c();
                }
            }
            return iC;
        }

        public boolean b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }
    }

    public abstract void A(int i);

    public abstract void C(long j);

    public abstract void F(String str);

    public abstract void G(BigDecimal bigDecimal);

    public abstract void H(BigInteger bigInteger);

    public abstract void I(char c);

    public abstract void J(IO io);

    public abstract void K(String str);

    public abstract void L(char[] cArr, int i, int i2);

    public abstract void M();

    public abstract void N();

    public abstract void O(String str);

    public KH c() {
        return this.a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public a d(KH kh) {
        this.a = kh;
        return this;
    }

    public abstract void flush();

    public abstract a g();

    public abstract void i(boolean z);

    public abstract void r();

    public abstract void t();

    public abstract void u(String str);

    public abstract void v();

    public abstract void x(double d);

    public abstract void z(float f);
}
