package defpackage;

import com.google.android.gms.internal.auth.f;
import com.google.android.gms.internal.auth.zzeu;
import com.google.android.gms.internal.auth.zzex;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: dd0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2047dd0 {
    public static final Class a;
    public static final AbstractC4219wd0 b;
    public static final AbstractC4219wd0 c;
    public static final AbstractC4219wd0 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        b = j(false);
        c = j(true);
        d = new f();
    }

    public static AbstractC4219wd0 a() {
        return b;
    }

    public static AbstractC4219wd0 b() {
        return c;
    }

    public static AbstractC4219wd0 c() {
        return d;
    }

    public static Object d(int i, List list, zzex zzexVar, Object obj, AbstractC4219wd0 abstractC4219wd0) {
        if (zzexVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzexVar.zza()) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = e(i, iIntValue, obj, abstractC4219wd0);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzexVar.zza()) {
                    obj = e(i, iIntValue2, obj, abstractC4219wd0);
                    it.remove();
                }
            }
        }
        return obj;
    }

    public static Object e(int i, int i2, Object obj, AbstractC4219wd0 abstractC4219wd0) {
        if (obj == null) {
            obj = abstractC4219wd0.c();
        }
        abstractC4219wd0.d(obj, i, i2);
        return obj;
    }

    public static void f(AbstractC4219wd0 abstractC4219wd0, Object obj, Object obj2) {
        abstractC4219wd0.f(obj, abstractC4219wd0.b(abstractC4219wd0.a(obj), abstractC4219wd0.a(obj2)));
    }

    public static void g(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean h(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void i(C3893sc0 c3893sc0, Object obj, Object obj2, long j) {
        AbstractC1244ae0.p(obj, j, C3893sc0.a(AbstractC1244ae0.f(obj, j), AbstractC1244ae0.f(obj2, j)));
    }

    public static AbstractC4219wd0 j(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (AbstractC4219wd0) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }
}
