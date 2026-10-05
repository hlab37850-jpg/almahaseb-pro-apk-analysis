package defpackage;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ES extends Number {
    public static final ThreadLocal d = new ThreadLocal();
    public static final Random e = new Random();
    public static final int f = Runtime.getRuntime().availableProcessors();
    public static final Unsafe g;
    public static final long h;
    public static final long i;
    public volatile transient b[] a;
    public volatile transient long b;
    public volatile transient int c;

    public class a implements PrivilegedExceptionAction {
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

    public static final class b {
        public static final Unsafe b;
        public static final long c;
        public volatile long a;

        static {
            try {
                Unsafe unsafeI = ES.i();
                b = unsafeI;
                c = unsafeI.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public b(long j) {
            this.a = j;
        }

        public final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }
    }

    static {
        try {
            Unsafe unsafeI = i();
            g = unsafeI;
            h = unsafeI.objectFieldOffset(ES.class.getDeclaredField("b"));
            i = unsafeI.objectFieldOffset(ES.class.getDeclaredField("c"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public static Unsafe i() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    public final boolean e(long j, long j2) {
        return g.compareAndSwapLong(this, h, j, j2);
    }

    public final boolean f() {
        return g.compareAndSwapInt(this, i, 0, 1);
    }

    public abstract long h(long j, long j2);

    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    public final void j(long j, int[] iArr, boolean z) {
        int iNextInt;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            d.set(iArr2);
            iNextInt = e.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr2[0] = iNextInt;
        } else {
            iNextInt = iArr[0];
            iArr2 = iArr;
        }
        int i2 = iNextInt;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            b[] bVarArr = this.a;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i2];
                if (bVar == null) {
                    if (this.c == 0) {
                        b bVar2 = new b(j);
                        if (this.c == 0 && f()) {
                            try {
                                b[] bVarArr2 = this.a;
                                if (bVarArr2 == null || (length2 = bVarArr2.length) <= 0) {
                                    z3 = false;
                                } else {
                                    int i3 = (length2 - 1) & i2;
                                    if (bVarArr2[i3] == null) {
                                        bVarArr2[i3] = bVar2;
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                this.c = 0;
                                if (z3) {
                                    return;
                                }
                            } catch (Throwable th) {
                                this.c = 0;
                                throw th;
                            }
                        }
                    }
                    z4 = false;
                    int i4 = i2 ^ (i2 << 13);
                    int i5 = i4 ^ (i4 >>> 17);
                    i2 = i5 ^ (i5 << 5);
                    iArr2[0] = i2;
                } else {
                    if (z5) {
                        long j2 = bVar.a;
                        if (bVar.a(j2, h(j2, j))) {
                            return;
                        }
                        if (length >= f || this.a != bVarArr) {
                            z4 = false;
                        } else if (!z4) {
                            z4 = true;
                        } else if (this.c == 0 && f()) {
                            try {
                                if (this.a == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i6 = 0; i6 < length; i6++) {
                                        bVarArr3[i6] = bVarArr[i6];
                                    }
                                    this.a = bVarArr3;
                                }
                                this.c = 0;
                                z4 = false;
                            } catch (Throwable th2) {
                                this.c = 0;
                                throw th2;
                            }
                        }
                    } else {
                        z5 = true;
                    }
                    int i7 = i2 ^ (i2 << 13);
                    int i8 = i7 ^ (i7 >>> 17);
                    i2 = i8 ^ (i8 << 5);
                    iArr2[0] = i2;
                }
            } else if (this.c == 0 && this.a == bVarArr && f()) {
                try {
                    if (this.a == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i2 & 1] = new b(j);
                        this.a = bVarArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.c = 0;
                    if (z2) {
                        return;
                    }
                } catch (Throwable th3) {
                    this.c = 0;
                    throw th3;
                }
            } else {
                long j3 = this.b;
                if (e(j3, h(j3, j))) {
                    return;
                }
            }
        }
    }
}
