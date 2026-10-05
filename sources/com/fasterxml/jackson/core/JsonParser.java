package com.fasterxml.jackson.core;

import defpackage.C4321xu;
import defpackage.C4412yu;
import defpackage.EnumC0431Du;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonParser implements Closeable {
    public int a;

    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false);

        public final boolean a;

        Feature(boolean z) {
            this.a = z;
        }

        public static int a() {
            int iC = 0;
            for (Feature feature : values()) {
                if (feature.b()) {
                    iC |= feature.c();
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

    public abstract long A();

    public short C() throws C4412yu {
        int iZ = z();
        if (iZ >= -32768 && iZ <= 32767) {
            return (short) iZ;
        }
        throw c("Numeric value (" + F() + ") out of range of Java short");
    }

    public abstract String F();

    public boolean G(Feature feature) {
        return (feature.c() & this.a) != 0;
    }

    public abstract EnumC0431Du H();

    public abstract JsonParser I();

    public C4412yu c(String str) {
        return new C4412yu(str, i());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract BigInteger d();

    public byte g() throws C4412yu {
        int iZ = z();
        if (iZ >= -128 && iZ <= 255) {
            return (byte) iZ;
        }
        throw c("Numeric value (" + F() + ") out of range of Java byte");
    }

    public abstract C4321xu i();

    public abstract String r();

    public abstract EnumC0431Du t();

    public abstract BigDecimal u();

    public abstract double v();

    public abstract float x();

    public abstract int z();
}
