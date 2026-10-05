package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class MS {
    public EventBus a;
    public final Object b;
    public final Method c;
    public final Executor d;

    public static final class b extends MS {
        @Override // defpackage.MS
        public void e(Object obj) {
            synchronized (this) {
                super.e(obj);
            }
        }

        public b(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }
    }

    public static MS c(EventBus eventBus, Object obj, Method method) {
        return f(method) ? new MS(eventBus, obj, method) : new b(eventBus, obj, method);
    }

    public static boolean f(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    public final SubscriberExceptionContext b(Object obj) {
        return new SubscriberExceptionContext(this.a, obj, this.b, this.c);
    }

    public final void d(final Object obj) {
        this.d.execute(new Runnable() { // from class: LS
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(obj);
            }
        });
    }

    public void e(Object obj) throws InvocationTargetException {
        try {
            this.c.invoke(this.b, Preconditions.checkNotNull(obj));
        } catch (IllegalAccessException e) {
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Method became inaccessible: ");
            sb.append(strValueOf);
            throw new Error(sb.toString(), e);
        } catch (IllegalArgumentException e2) {
            String strValueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 33);
            sb2.append("Method rejected target/argument: ");
            sb2.append(strValueOf2);
            throw new Error(sb2.toString(), e2);
        } catch (InvocationTargetException e3) {
            if (!(e3.getCause() instanceof Error)) {
                throw e3;
            }
            throw ((Error) e3.getCause());
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MS)) {
            return false;
        }
        MS ms = (MS) obj;
        return this.b == ms.b && this.c.equals(ms.c);
    }

    public final /* synthetic */ void g(Object obj) {
        try {
            e(obj);
        } catch (InvocationTargetException e) {
            this.a.handleSubscriberException(e.getCause(), b(obj));
        }
    }

    public final int hashCode() {
        return ((this.c.hashCode() + 31) * 31) + System.identityHashCode(this.b);
    }

    public MS(EventBus eventBus, Object obj, Method method) {
        this.a = eventBus;
        this.b = Preconditions.checkNotNull(obj);
        this.c = method;
        method.setAccessible(true);
        this.d = eventBus.executor();
    }
}
