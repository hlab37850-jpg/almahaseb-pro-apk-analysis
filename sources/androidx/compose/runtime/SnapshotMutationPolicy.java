package androidx.compose.runtime;

import defpackage.TQ;

/* JADX INFO: loaded from: classes.dex */
public interface SnapshotMutationPolicy<T> {

    public static final class DefaultImpls {
        @Deprecated
        public static <T> T merge(SnapshotMutationPolicy<T> snapshotMutationPolicy, T t, T t2, T t3) {
            return (T) TQ.a(snapshotMutationPolicy, t, t2, t3);
        }
    }

    boolean equivalent(T t, T t2);

    T merge(T t, T t2, T t3);
}
