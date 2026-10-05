package defpackage;

import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: cw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1989cw {
    public static final c a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: cw$b */
    public static abstract class b implements c {
        public static final b a = new a("INSTANCE", 0);
        public static final /* synthetic */ b[] b = b();

        /* JADX INFO: renamed from: cw$b$a */
        public final enum a extends b {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // defpackage.AbstractC1989cw.c
            public long a(byte[] bArr, int i) {
                return Longs.fromBytes(bArr[i + 7], bArr[i + 6], bArr[i + 5], bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
            }
        }

        public b(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ b[] b() {
            return new b[]{a};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) b.clone();
        }
    }

    /* JADX INFO: renamed from: cw$c */
    public interface c {
        long a(byte[] bArr, int i);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: cw$d */
    public static abstract class d implements c {
        public static final Unsafe c;
        public static final int d;
        public static final d a = new a("UNSAFE_LITTLE_ENDIAN", 0);
        public static final d b = new b("UNSAFE_BIG_ENDIAN", 1);
        public static final /* synthetic */ d[] e = b();

        /* JADX INFO: renamed from: cw$d$a */
        public final enum a extends d {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // defpackage.AbstractC1989cw.c
            public long a(byte[] bArr, int i) {
                return d.c.getLong(bArr, ((long) i) + ((long) d.d));
            }
        }

        /* JADX INFO: renamed from: cw$d$b */
        public final enum b extends d {
            public b(String str, int i) {
                super(str, i);
            }

            @Override // defpackage.AbstractC1989cw.c
            public long a(byte[] bArr, int i) {
                return Long.reverseBytes(d.c.getLong(bArr, ((long) i) + ((long) d.d)));
            }
        }

        /* JADX INFO: renamed from: cw$d$c */
        public class c implements PrivilegedExceptionAction {
            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws IllegalAccessException {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafeF = f();
            c = unsafeF;
            d = unsafeF.arrayBaseOffset(byte[].class);
            if (unsafeF.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        public d(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ d[] b() {
            return new d[]{a, b};
        }

        public static Unsafe f() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new c());
            }
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) e.clone();
        }
    }

    static {
        c cVar = b.a;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                cVar = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? d.a : d.b;
            }
        } catch (Throwable unused) {
        }
        a = cVar;
    }

    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static long b(byte[] bArr, int i) {
        return a.a(bArr, i);
    }

    public static long c(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, 8);
        long j = 0;
        for (int i3 = 0; i3 < iMin; i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }
}
