package defpackage;

import com.google.api.client.repackaged.com.google.common.base.CharMatcher;
import com.google.api.client.repackaged.com.google.common.base.Enums;
import com.google.api.client.repackaged.com.google.common.base.Optional;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FG {
    public static Optional a(Class cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.getEnumConstants(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    public static CharMatcher b(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }
}
