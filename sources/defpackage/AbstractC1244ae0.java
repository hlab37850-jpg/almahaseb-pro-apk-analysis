package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: ae0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1244ae0 {
    public static final Unsafe a;
    public static final Class b;
    public static final boolean c;
    public static final Yd0 d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;

    /* JADX WARN: Code duplicated, block: B:11:0x003f  */
    static {
        boolean z;
        boolean z2;
        Yd0 yd0;
        Unsafe unsafeG = g();
        a = unsafeG;
        b = AbstractC1236aa0.a();
        Class<?> cls = Long.TYPE;
        boolean zS = s(cls);
        c = zS;
        boolean zS2 = s(Integer.TYPE);
        Yd0 vd0 = null;
        if (unsafeG != null) {
            if (zS) {
                vd0 = new Wd0(unsafeG);
            } else if (zS2) {
                vd0 = new Vd0(unsafeG);
            }
        }
        d = vd0;
        if (vd0 == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = vd0.a.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (y() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                h(th);
            }
        }
        e = z;
        Yd0 yd1 = d;
        if (yd1 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls3 = yd1.a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                h(th2);
                z2 = false;
            }
        }
        f = z2;
        w(byte[].class);
        w(boolean[].class);
        x(boolean[].class);
        w(int[].class);
        x(int[].class);
        w(long[].class);
        x(long[].class);
        w(float[].class);
        x(float[].class);
        w(double[].class);
        x(double[].class);
        w(Object[].class);
        x(Object[].class);
        Field fieldY = y();
        if (fieldY != null && (yd0 = d) != null) {
            yd0.k(fieldY);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static double a(Object obj, long j) {
        return d.a(obj, j);
    }

    public static float b(Object obj, long j) {
        return d.b(obj, j);
    }

    public static int c(Object obj, long j) {
        return d.i(obj, j);
    }

    public static long d(Object obj, long j) {
        return d.j(obj, j);
    }

    public static Object e(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object f(Object obj, long j) {
        return d.l(obj, j);
    }

    public static Unsafe g() {
        try {
            return (Unsafe) AccessController.doPrivileged(new Td0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void h(Throwable th) {
        Logger.getLogger(AbstractC1244ae0.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static /* synthetic */ void i(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        Yd0 yd0 = d;
        int i = yd0.i(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        yd0.m(obj, j2, ((z ? 1 : 0) << i2) | ((~(255 << i2)) & i));
    }

    public static /* synthetic */ void j(Object obj, long j, boolean z) {
        long j2 = (-4) & j;
        Yd0 yd0 = d;
        int i = (((int) j) & 3) << 3;
        yd0.m(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & yd0.i(obj, j2)));
    }

    public static void k(Object obj, long j, boolean z) {
        d.c(obj, j, z);
    }

    public static void l(Object obj, long j, double d2) {
        d.d(obj, j, d2);
    }

    public static void m(Object obj, long j, float f2) {
        d.e(obj, j, f2);
    }

    public static void n(Object obj, long j, int i) {
        d.m(obj, j, i);
    }

    public static void o(Object obj, long j, long j2) {
        d.n(obj, j, j2);
    }

    public static void p(Object obj, long j, Object obj2) {
        d.o(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean q(Object obj, long j) {
        return ((byte) ((d.i(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean r(Object obj, long j) {
        return ((byte) ((d.i(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean s(Class cls) {
        int i = AbstractC1236aa0.a;
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

    public static boolean t(Object obj, long j) {
        return d.f(obj, j);
    }

    public static boolean u() {
        return f;
    }

    public static boolean v() {
        return e;
    }

    public static int w(Class cls) {
        if (f) {
            return d.g(cls);
        }
        return -1;
    }

    public static int x(Class cls) {
        if (f) {
            return d.h(cls);
        }
        return -1;
    }

    public static Field y() {
        int i = AbstractC1236aa0.a;
        Field fieldZ = z(Buffer.class, "effectiveDirectAddress");
        if (fieldZ != null) {
            return fieldZ;
        }
        Field fieldZ2 = z(Buffer.class, HTML.Tag.ADDRESS);
        if (fieldZ2 == null || fieldZ2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZ2;
    }

    public static Field z(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
