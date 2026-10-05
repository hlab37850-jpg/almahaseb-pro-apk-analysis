package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ig0 {
    public static final Unsafe a;
    public static final Class b;
    public static final boolean c;
    public static final boolean d;
    public static final d e;
    public static final boolean f;
    public static final boolean g;
    public static final long h;
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
    public static final int v;
    public static final boolean w;

    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // Ig0.d
        public final byte a(Object obj, long j) {
            return Ig0.w ? Ig0.L(obj, j) : Ig0.M(obj, j);
        }

        @Override // Ig0.d
        public final void b(Object obj, long j, byte b) {
            if (Ig0.w) {
                Ig0.u(obj, j, b);
            } else {
                Ig0.y(obj, j, b);
            }
        }

        @Override // Ig0.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // Ig0.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // Ig0.d
        public final void g(Object obj, long j, boolean z) {
            if (Ig0.w) {
                Ig0.z(obj, j, z);
            } else {
                Ig0.D(obj, j, z);
            }
        }

        @Override // Ig0.d
        public final boolean h(Object obj, long j) {
            return Ig0.w ? Ig0.N(obj, j) : Ig0.O(obj, j);
        }

        @Override // Ig0.d
        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        @Override // Ig0.d
        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // Ig0.d
        public final byte a(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // Ig0.d
        public final void b(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // Ig0.d
        public final void c(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // Ig0.d
        public final void d(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // Ig0.d
        public final void g(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // Ig0.d
        public final boolean h(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // Ig0.d
        public final float i(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // Ig0.d
        public final double j(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }
    }

    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // Ig0.d
        public final byte a(Object obj, long j) {
            return Ig0.w ? Ig0.L(obj, j) : Ig0.M(obj, j);
        }

        @Override // Ig0.d
        public final void b(Object obj, long j, byte b) {
            if (Ig0.w) {
                Ig0.u(obj, j, b);
            } else {
                Ig0.y(obj, j, b);
            }
        }

        @Override // Ig0.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // Ig0.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // Ig0.d
        public final void g(Object obj, long j, boolean z) {
            if (Ig0.w) {
                Ig0.z(obj, j, z);
            } else {
                Ig0.D(obj, j, z);
            }
        }

        @Override // Ig0.d
        public final boolean h(Object obj, long j) {
            return Ig0.w ? Ig0.N(obj, j) : Ig0.O(obj, j);
        }

        @Override // Ig0.d
        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        @Override // Ig0.d
        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    public static abstract class d {
        public Unsafe a;

        public d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void b(Object obj, long j, byte b);

        public abstract void c(Object obj, long j, double d);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract boolean h(Object obj, long j);

        public abstract float i(Object obj, long j);

        public abstract double j(Object obj, long j);

        public final int k(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long l(Object obj, long j) {
            return this.a.getLong(obj, j);
        }
    }

    static {
        Unsafe unsafeT = t();
        a = unsafeT;
        b = Zd0.c();
        boolean zB = B(Long.TYPE);
        c = zB;
        boolean zB2 = B(Integer.TYPE);
        d = zB2;
        d bVar = null;
        if (unsafeT != null) {
            if (!Zd0.b()) {
                bVar = new b(unsafeT);
            } else if (zB) {
                bVar = new c(unsafeT);
            } else if (zB2) {
                bVar = new a(unsafeT);
            }
        }
        e = bVar;
        f = E();
        g = A();
        long jN = n(byte[].class);
        h = jN;
        i = n(boolean[].class);
        j = s(boolean[].class);
        k = n(int[].class);
        l = s(int[].class);
        m = n(long[].class);
        n = s(long[].class);
        o = n(float[].class);
        p = s(float[].class);
        q = n(double[].class);
        r = s(double[].class);
        s = n(Object[].class);
        t = s(Object[].class);
        Field fieldG = G();
        u = (fieldG == null || bVar == null) ? -1L : bVar.a.objectFieldOffset(fieldG);
        v = (int) (jN & 7);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static boolean A() {
        Unsafe unsafe = a;
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
            if (Zd0.b()) {
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
            Logger logger = Logger.getLogger(Ig0.class.getName());
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean B(Class cls) {
        if (!Zd0.b()) {
            return false;
        }
        try {
            Class cls2 = b;
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

    public static double C(Object obj, long j2) {
        return e.j(obj, j2);
    }

    public static void D(Object obj, long j2, boolean z) {
        y(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static boolean E() {
        Unsafe unsafe = a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (G() == null) {
                return false;
            }
            if (Zd0.b()) {
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
            Logger logger = Logger.getLogger(Ig0.class.getName());
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    public static Object F(Object obj, long j2) {
        return e.a.getObject(obj, j2);
    }

    public static Field G() {
        Field fieldD;
        if (Zd0.b() && (fieldD = d(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldD;
        }
        Field fieldD2 = d(Buffer.class, HTML.Tag.ADDRESS);
        if (fieldD2 == null || fieldD2.getType() != Long.TYPE) {
            return null;
        }
        return fieldD2;
    }

    public static byte L(Object obj, long j2) {
        return (byte) (b(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte M(Object obj, long j2) {
        return (byte) (b(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    public static boolean N(Object obj, long j2) {
        return L(obj, j2) != 0;
    }

    public static boolean O(Object obj, long j2) {
        return M(obj, j2) != 0;
    }

    public static byte a(byte[] bArr, long j2) {
        return e.a(bArr, h + j2);
    }

    public static int b(Object obj, long j2) {
        return e.k(obj, j2);
    }

    public static Object c(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Field d(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(Object obj, long j2, double d2) {
        e.c(obj, j2, d2);
    }

    public static void g(Object obj, long j2, float f2) {
        e.d(obj, j2, f2);
    }

    public static void h(Object obj, long j2, int i2) {
        e.e(obj, j2, i2);
    }

    public static void i(Object obj, long j2, long j3) {
        e.f(obj, j2, j3);
    }

    public static void j(Object obj, long j2, Object obj2) {
        e.a.putObject(obj, j2, obj2);
    }

    public static void k(Object obj, long j2, boolean z) {
        e.g(obj, j2, z);
    }

    public static void l(byte[] bArr, long j2, byte b2) {
        e.b(bArr, h + j2, b2);
    }

    public static boolean m() {
        return g;
    }

    public static int n(Class cls) {
        if (g) {
            return e.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static long o(Object obj, long j2) {
        return e.l(obj, j2);
    }

    public static boolean r() {
        return f;
    }

    public static int s(Class cls) {
        if (g) {
            return e.a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new Kg0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void u(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iB = b(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        h(obj, j3, ((255 & b2) << i2) | (iB & (~(255 << i2))));
    }

    public static boolean w(Object obj, long j2) {
        return e.h(obj, j2);
    }

    public static float x(Object obj, long j2) {
        return e.i(obj, j2);
    }

    public static void y(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        h(obj, j3, ((255 & b2) << i2) | (b(obj, j3) & (~(255 << i2))));
    }

    public static void z(Object obj, long j2, boolean z) {
        u(obj, j2, z ? (byte) 1 : (byte) 0);
    }
}
