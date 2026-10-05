package defpackage;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: sl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3907sl {
    public static final ThreadLocal f = new ThreadLocal();
    public boolean a = true;
    public boolean b = false;
    public boolean c = false;
    public Class d = null;
    public String[] e = null;

    public static void B(Object obj, Object obj2) {
        Set setU = u();
        if (setU != null) {
            setU.remove(t(obj, obj2));
            if (setU.isEmpty()) {
                f.remove();
            }
        }
    }

    public static AbstractC2101eG t(Object obj, Object obj2) {
        return AbstractC2101eG.e(new C0866Qr(obj), new C0866Qr(obj2));
    }

    public static Set u() {
        return (Set) f.get();
    }

    public static boolean w(Object obj, Object obj2) {
        Set setU = u();
        AbstractC2101eG abstractC2101eGT = t(obj, obj2);
        return setU != null && (setU.contains(abstractC2101eGT) || setU.contains(AbstractC2101eG.e(abstractC2101eGT.b(), abstractC2101eGT.c())));
    }

    public static void z(Object obj, Object obj2) {
        Set setU = u();
        if (setU == null) {
            setU = new HashSet();
            f.set(setU);
        }
        setU.add(t(obj, obj2));
    }

    public void A(boolean z) {
        this.a = z;
    }

    public C3907sl a(byte b, byte b2) {
        if (!this.a) {
            return this;
        }
        this.a = b == b2;
        return this;
    }

    public C3907sl b(char c, char c2) {
        if (!this.a) {
            return this;
        }
        this.a = c == c2;
        return this;
    }

    public C3907sl c(double d, double d2) {
        return !this.a ? this : f(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public C3907sl d(float f2, float f3) {
        return !this.a ? this : e(Float.floatToIntBits(f2), Float.floatToIntBits(f3));
    }

    public C3907sl e(int i, int i2) {
        if (!this.a) {
            return this;
        }
        this.a = i == i2;
        return this;
    }

    public C3907sl f(long j, long j2) {
        if (!this.a) {
            return this;
        }
        this.a = j == j2;
        return this;
    }

    public C3907sl g(Object obj, Object obj2) {
        if (!this.a || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            A(false);
            return this;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            s(obj, obj2);
        } else if (!this.c || AbstractC0538Gb.a(cls)) {
            this.a = obj.equals(obj2);
        } else {
            x(obj, obj2);
        }
        return this;
    }

    public C3907sl h(short s, short s2) {
        if (!this.a) {
            return this;
        }
        this.a = s == s2;
        return this;
    }

    public C3907sl i(boolean z, boolean z2) {
        if (!this.a) {
            return this;
        }
        this.a = z == z2;
        return this;
    }

    public C3907sl j(byte[] bArr, byte[] bArr2) {
        if (!this.a || bArr == bArr2) {
            return this;
        }
        if (bArr == null || bArr2 == null) {
            A(false);
            return this;
        }
        if (bArr.length != bArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < bArr.length && this.a; i++) {
            a(bArr[i], bArr2[i]);
        }
        return this;
    }

    public C3907sl k(char[] cArr, char[] cArr2) {
        if (!this.a || cArr == cArr2) {
            return this;
        }
        if (cArr == null || cArr2 == null) {
            A(false);
            return this;
        }
        if (cArr.length != cArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < cArr.length && this.a; i++) {
            b(cArr[i], cArr2[i]);
        }
        return this;
    }

    public C3907sl l(double[] dArr, double[] dArr2) {
        if (!this.a || dArr == dArr2) {
            return this;
        }
        if (dArr == null || dArr2 == null) {
            A(false);
            return this;
        }
        if (dArr.length != dArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < dArr.length && this.a; i++) {
            c(dArr[i], dArr2[i]);
        }
        return this;
    }

    public C3907sl m(float[] fArr, float[] fArr2) {
        if (!this.a || fArr == fArr2) {
            return this;
        }
        if (fArr == null || fArr2 == null) {
            A(false);
            return this;
        }
        if (fArr.length != fArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < fArr.length && this.a; i++) {
            d(fArr[i], fArr2[i]);
        }
        return this;
    }

    public C3907sl n(int[] iArr, int[] iArr2) {
        if (!this.a || iArr == iArr2) {
            return this;
        }
        if (iArr == null || iArr2 == null) {
            A(false);
            return this;
        }
        if (iArr.length != iArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < iArr.length && this.a; i++) {
            e(iArr[i], iArr2[i]);
        }
        return this;
    }

    public C3907sl o(long[] jArr, long[] jArr2) {
        if (!this.a || jArr == jArr2) {
            return this;
        }
        if (jArr == null || jArr2 == null) {
            A(false);
            return this;
        }
        if (jArr.length != jArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < jArr.length && this.a; i++) {
            f(jArr[i], jArr2[i]);
        }
        return this;
    }

    public C3907sl p(Object[] objArr, Object[] objArr2) {
        if (!this.a || objArr == objArr2) {
            return this;
        }
        if (objArr == null || objArr2 == null) {
            A(false);
            return this;
        }
        if (objArr.length != objArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < objArr.length && this.a; i++) {
            g(objArr[i], objArr2[i]);
        }
        return this;
    }

    public C3907sl q(short[] sArr, short[] sArr2) {
        if (!this.a || sArr == sArr2) {
            return this;
        }
        if (sArr == null || sArr2 == null) {
            A(false);
            return this;
        }
        if (sArr.length != sArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < sArr.length && this.a; i++) {
            h(sArr[i], sArr2[i]);
        }
        return this;
    }

    public C3907sl r(boolean[] zArr, boolean[] zArr2) {
        if (!this.a || zArr == zArr2) {
            return this;
        }
        if (zArr == null || zArr2 == null) {
            A(false);
            return this;
        }
        if (zArr.length != zArr2.length) {
            A(false);
            return this;
        }
        for (int i = 0; i < zArr.length && this.a; i++) {
            i(zArr[i], zArr2[i]);
        }
        return this;
    }

    public final void s(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            A(false);
            return;
        }
        if (obj instanceof long[]) {
            o((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            n((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            q((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            k((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            j((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            l((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            m((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            r((boolean[]) obj, (boolean[]) obj2);
        } else {
            p((Object[]) obj, (Object[]) obj2);
        }
    }

    public boolean v() {
        return this.a;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0030  */
    public C3907sl x(Object obj, Object obj2) {
        if (!this.a || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            this.a = false;
            return this;
        }
        Class<?> superclass = obj.getClass();
        Class<?> cls = obj2.getClass();
        if (superclass.isInstance(obj2)) {
            if (!cls.isInstance(obj)) {
                superclass = cls;
            }
        } else {
            if (!cls.isInstance(obj)) {
                this.a = false;
                return this;
            }
            if (superclass.isInstance(obj2)) {
                superclass = cls;
            }
        }
        try {
            if (superclass.isArray()) {
                g(obj, obj2);
            } else {
                y(obj, obj2, superclass);
                while (superclass.getSuperclass() != null && superclass != this.d) {
                    superclass = superclass.getSuperclass();
                    y(obj, obj2, superclass);
                }
            }
            return this;
        } catch (IllegalArgumentException unused) {
            this.a = false;
            return this;
        }
    }

    public final void y(Object obj, Object obj2, Class cls) {
        if (w(obj, obj2)) {
            return;
        }
        try {
            z(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i = 0; i < declaredFields.length && this.a; i++) {
                Field field = declaredFields[i];
                if (!N5.a(this.e, field.getName()) && !field.getName().contains("$") && (this.b || !Modifier.isTransient(field.getModifiers()))) {
                    if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(InterfaceC3988tl.class)) {
                        try {
                            g(field.get(obj), field.get(obj2));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            }
            B(obj, obj2);
        } catch (Throwable th) {
            B(obj, obj2);
            throw th;
        }
    }
}
