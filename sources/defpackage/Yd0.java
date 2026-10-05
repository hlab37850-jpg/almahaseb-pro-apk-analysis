package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Yd0 {
    public final Unsafe a;

    public Yd0(Unsafe unsafe) {
        this.a = unsafe;
    }

    public abstract double a(Object obj, long j);

    public abstract float b(Object obj, long j);

    public abstract void c(Object obj, long j, boolean z);

    public abstract void d(Object obj, long j, double d);

    public abstract void e(Object obj, long j, float f);

    public abstract boolean f(Object obj, long j);

    public final int g(Class cls) {
        return this.a.arrayBaseOffset(cls);
    }

    public final int h(Class cls) {
        return this.a.arrayIndexScale(cls);
    }

    public final int i(Object obj, long j) {
        return this.a.getInt(obj, j);
    }

    public final long j(Object obj, long j) {
        return this.a.getLong(obj, j);
    }

    public final long k(Field field) {
        return this.a.objectFieldOffset(field);
    }

    public final Object l(Object obj, long j) {
        return this.a.getObject(obj, j);
    }

    public final void m(Object obj, long j, int i) {
        this.a.putInt(obj, j, i);
    }

    public final void n(Object obj, long j, long j2) {
        this.a.putLong(obj, j, j2);
    }

    public final void o(Object obj, long j, Object obj2) {
        this.a.putObject(obj, j, obj2);
    }
}
