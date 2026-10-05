package defpackage;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: cq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1983cq {
    public static final Ordering a = Ordering.natural().onResultOf(new a()).reverse();

    /* JADX INFO: renamed from: cq$a */
    public class a implements Function {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Constructor constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    /* JADX INFO: renamed from: cq$b */
    public interface b {
        void a(Class cls);
    }

    /* JADX INFO: renamed from: cq$c */
    public static class c {
        public static final b a = a();

        /* JADX INFO: renamed from: cq$c$a */
        public enum a implements b {
            INSTANCE;

            public static final Set b = new CopyOnWriteArraySet();

            @Override // defpackage.AbstractC1983cq.b
            public void a(Class cls) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    if (cls.equals(((WeakReference) it.next()).get())) {
                        return;
                    }
                }
                AbstractC1983cq.b(cls);
                Set set = b;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference(cls));
            }
        }

        public static b a() {
            return AbstractC1983cq.k();
        }
    }

    public static b a() {
        return c.a;
    }

    public static void b(Class cls) {
        Preconditions.checkArgument(g(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        Preconditions.checkArgument(f(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    public static Object c(b bVar, Future future, Class cls) throws Exception {
        bVar.a(cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw i(cls, e);
        } catch (ExecutionException e2) {
            l(e2.getCause(), cls);
            throw new AssertionError();
        }
    }

    public static Object d(Future future, Class cls) {
        return c(a(), future, cls);
    }

    public static Object e(Future future, Class cls, long j, TimeUnit timeUnit) throws Exception {
        a().a(cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw i(cls, e);
        } catch (ExecutionException e2) {
            l(e2.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e3) {
            throw i(cls, e3);
        }
    }

    public static boolean f(Class cls) {
        try {
            i(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(Class cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    public static Object h(Constructor constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Exception i(Class cls, Throwable th) {
        Iterator it = j(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            Exception exc = (Exception) h((Constructor) it.next(), th);
            if (exc != null) {
                if (exc.getCause() == null) {
                    exc.initCause(th);
                }
                return exc;
            }
        }
        String strValueOf = String.valueOf(cls);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 82);
        sb.append("No appropriate constructor for exception of type ");
        sb.append(strValueOf);
        sb.append(" in response to chained exception");
        throw new IllegalArgumentException(sb.toString(), th);
    }

    public static List j(List list) {
        return a.sortedCopy(list);
    }

    public static b k() {
        return c.a.INSTANCE;
    }

    public static void l(Throwable th, Class cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw i(cls, th);
        }
        throw new UncheckedExecutionException(th);
    }
}
