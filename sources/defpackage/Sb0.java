package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Sb0 {
    public static final Logger a = Logger.getLogger(Sb0.class.getName());
    public static final Unsafe b;
    public static final Class c;
    public static final boolean d;
    public static final boolean e;
    public static final d f;
    public static final boolean g;
    public static final boolean h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final long q;
    public static final long r;
    public static final long s;
    public static final long t;
    public static final long u;
    public static final long v;
    public static final long w;
    public static final boolean x;

    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // Sb0.d
        public final void b(long j, byte b) {
            Memory.pokeByte((int) j, b);
        }

        @Override // Sb0.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // Sb0.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // Sb0.d
        public final void g(Object obj, long j, boolean z) {
            if (Sb0.x) {
                Sb0.r(obj, j, z);
            } else {
                Sb0.t(obj, j, z);
            }
        }

        @Override // Sb0.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) j2, bArr, (int) j, (int) j3);
        }

        @Override // Sb0.d
        public final void i(Object obj, long j, byte b) {
            if (Sb0.x) {
                Sb0.d(obj, j, b);
            } else {
                Sb0.q(obj, j, b);
            }
        }

        @Override // Sb0.d
        public final boolean l(Object obj, long j) {
            return Sb0.x ? Sb0.P(obj, j) : Sb0.Q(obj, j);
        }

        @Override // Sb0.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // Sb0.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // Sb0.d
        public final byte o(Object obj, long j) {
            return Sb0.x ? Sb0.N(obj, j) : Sb0.O(obj, j);
        }
    }

    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // Sb0.d
        public final void b(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // Sb0.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // Sb0.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // Sb0.d
        public final void g(Object obj, long j, boolean z) {
            if (Sb0.x) {
                Sb0.r(obj, j, z);
            } else {
                Sb0.t(obj, j, z);
            }
        }

        @Override // Sb0.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // Sb0.d
        public final void i(Object obj, long j, byte b) {
            if (Sb0.x) {
                Sb0.d(obj, j, b);
            } else {
                Sb0.q(obj, j, b);
            }
        }

        @Override // Sb0.d
        public final boolean l(Object obj, long j) {
            return Sb0.x ? Sb0.P(obj, j) : Sb0.Q(obj, j);
        }

        @Override // Sb0.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // Sb0.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // Sb0.d
        public final byte o(Object obj, long j) {
            return Sb0.x ? Sb0.N(obj, j) : Sb0.O(obj, j);
        }
    }

    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // Sb0.d
        public final void b(long j, byte b) {
            this.a.putByte(j, b);
        }

        @Override // Sb0.d
        public final void c(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // Sb0.d
        public final void d(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // Sb0.d
        public final void g(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // Sb0.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            this.a.copyMemory(bArr, Sb0.i + j, (Object) null, j2, j3);
        }

        @Override // Sb0.d
        public final void i(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // Sb0.d
        public final boolean l(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // Sb0.d
        public final float m(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // Sb0.d
        public final double n(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // Sb0.d
        public final byte o(Object obj, long j) {
            return this.a.getByte(obj, j);
        }
    }

    public static abstract class d {
        public Unsafe a;

        public d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final long a(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void b(long j, byte b);

        public abstract void c(Object obj, long j, double d);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract void h(byte[] bArr, long j, long j2, long j3);

        public abstract void i(Object obj, long j, byte b);

        public final int j(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long k(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public abstract boolean l(Object obj, long j);

        public abstract float m(Object obj, long j);

        public abstract double n(Object obj, long j);

        public abstract byte o(Object obj, long j);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x002b  */
    static {
        d cVar;
        Unsafe unsafeZ = z();
        b = unsafeZ;
        c = F50.c();
        boolean zG = G(Long.TYPE);
        d = zG;
        boolean zG2 = G(Integer.TYPE);
        e = zG2;
        Field field = null;
        if (unsafeZ == null) {
            cVar = null;
        } else if (!F50.b()) {
            cVar = new c(unsafeZ);
        } else if (zG) {
            cVar = new b(unsafeZ);
        } else if (zG2) {
            cVar = new a(unsafeZ);
        } else {
            cVar = null;
        }
        f = cVar;
        g = B();
        h = A();
        i = E(byte[].class);
        j = E(boolean[].class);
        k = F(boolean[].class);
        l = E(int[].class);
        m = F(int[].class);
        n = E(long[].class);
        o = F(long[].class);
        p = E(float[].class);
        q = F(float[].class);
        r = E(double[].class);
        s = F(double[].class);
        t = E(Object[].class);
        u = F(Object[].class);
        v = n(C());
        Field fieldP = p(String.class, "value");
        if (fieldP != null && fieldP.getType() == char[].class) {
            field = fieldP;
        }
        w = n(field);
        x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static boolean A() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (F50.b()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    public static boolean B() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (C() == null) {
                return false;
            }
            if (F50.b()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    public static Field C() {
        Field fieldP;
        if (F50.b() && (fieldP = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldP;
        }
        Field fieldP2 = p(Buffer.class, HTML.Tag.ADDRESS);
        if (fieldP2 == null || fieldP2.getType() != Long.TYPE) {
            return null;
        }
        return fieldP2;
    }

    public static int E(Class cls) {
        if (h) {
            return f.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int F(Class cls) {
        if (h) {
            return f.a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean G(Class cls) {
        if (!F50.b()) {
            return false;
        }
        try {
            Class cls2 = c;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int H(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static long I(Object obj, long j2) {
        return f.k(obj, j2);
    }

    public static boolean J(Object obj, long j2) {
        return f.l(obj, j2);
    }

    public static float K(Object obj, long j2) {
        return f.m(obj, j2);
    }

    public static double L(Object obj, long j2) {
        return f.n(obj, j2);
    }

    public static Object M(Object obj, long j2) {
        return f.a.getObject(obj, j2);
    }

    public static byte N(Object obj, long j2) {
        return (byte) (H(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte O(Object obj, long j2) {
        return (byte) (H(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    public static boolean P(Object obj, long j2) {
        return N(obj, j2) != 0;
    }

    public static boolean Q(Object obj, long j2) {
        return O(obj, j2) != 0;
    }

    public static byte a(byte[] bArr, long j2) {
        return f.o(bArr, i + j2);
    }

    public static long b(Field field) {
        return f.a(field);
    }

    public static void c(long j2, byte b2) {
        f.b(j2, b2);
    }

    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iH = H(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        g(obj, j3, ((255 & b2) << i2) | (iH & (~(255 << i2))));
    }

    public static void e(Object obj, long j2, double d2) {
        f.c(obj, j2, d2);
    }

    public static void f(Object obj, long j2, float f2) {
        f.d(obj, j2, f2);
    }

    public static void g(Object obj, long j2, int i2) {
        f.e(obj, j2, i2);
    }

    public static void h(Object obj, long j2, long j3) {
        f.f(obj, j2, j3);
    }

    public static void i(Object obj, long j2, Object obj2) {
        f.a.putObject(obj, j2, obj2);
    }

    public static void j(Object obj, long j2, boolean z) {
        f.g(obj, j2, z);
    }

    public static void k(byte[] bArr, long j2, byte b2) {
        f.i(bArr, i + j2, b2);
    }

    public static void l(byte[] bArr, long j2, long j3, long j4) {
        f.h(bArr, j2, j3, j4);
    }

    public static long n(Field field) {
        d dVar;
        if (field == null || (dVar = f) == null) {
            return -1L;
        }
        return dVar.a(field);
    }

    public static long o(ByteBuffer byteBuffer) {
        return f.k(byteBuffer, v);
    }

    public static Field p(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void q(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        g(obj, j3, ((255 & b2) << i2) | (H(obj, j3) & (~(255 << i2))));
    }

    public static void r(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static void t(Object obj, long j2, boolean z) {
        q(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static boolean x() {
        return h;
    }

    public static boolean y() {
        return g;
    }

    public static Unsafe z() {
        try {
            return (Unsafe) AccessController.doPrivileged(new Vb0());
        } catch (Throwable unused) {
            return null;
        }
    }
}
