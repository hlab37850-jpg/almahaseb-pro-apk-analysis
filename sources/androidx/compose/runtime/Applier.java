package androidx.compose.runtime;

import defpackage.O4;

/* JADX INFO: loaded from: classes.dex */
public interface Applier<N> {

    public static final class DefaultImpls {
        @Deprecated
        public static <N> void onBeginChanges(Applier<N> applier) {
            O4.a(applier);
        }

        @Deprecated
        public static <N> void onEndChanges(Applier<N> applier) {
            O4.b(applier);
        }
    }

    void clear();

    void down(N n);

    N getCurrent();

    void insertBottomUp(int i, N n);

    void insertTopDown(int i, N n);

    void move(int i, int i2, int i3);

    void onBeginChanges();

    void onEndChanges();

    void remove(int i, int i2);

    void up();
}
