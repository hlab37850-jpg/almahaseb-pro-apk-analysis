package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public enum QD {
    COMPLETE;

    public static final class a implements Serializable {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Objects.equals(this.a, ((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.a + "]";
        }
    }

    public static final class b implements Serializable {
        public final PS a;

        public b(PS ps) {
            this.a = ps;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.a + "]";
        }
    }

    public static boolean a(Object obj, NS ns) {
        if (obj == COMPLETE) {
            ns.onComplete();
            return true;
        }
        if (obj instanceof a) {
            ns.onError(((a) obj).a);
            return true;
        }
        if (obj instanceof b) {
            ns.a(((b) obj).a);
            return false;
        }
        ns.b(obj);
        return false;
    }

    public static Object b() {
        return COMPLETE;
    }

    public static Object c(Throwable th) {
        return new a(th);
    }

    public static Object f(PS ps) {
        return new b(ps);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object e(Object obj) {
        return obj;
    }
}
