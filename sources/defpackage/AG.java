package defpackage;

import com.google.common.base.CharMatcher;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AG {
    public static final Logger a = Logger.getLogger(AG.class.getName());
    public static final InterfaceC3949tG b = e();

    public static final class b implements InterfaceC3949tG {
        public b() {
        }

        @Override // defpackage.InterfaceC3949tG
        public AbstractC0714Ld a(String str) {
            return new C1748au(Pattern.compile(str));
        }
    }

    public static AbstractC0714Ld a(String str) {
        Preconditions.checkNotNull(str);
        return b.a(str);
    }

    public static String b(String str) {
        if (h(str)) {
            return null;
        }
        return str;
    }

    public static String c(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    public static Optional d(Class cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.getEnumConstants(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of((Enum) cls.cast(weakReference.get()));
    }

    public static InterfaceC3949tG e() {
        return new b();
    }

    public static String f(String str) {
        return str == null ? "" : str;
    }

    public static CharMatcher g(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    public static boolean h(String str) {
        return str == null || str.isEmpty();
    }

    public static long i() {
        return System.nanoTime();
    }
}
