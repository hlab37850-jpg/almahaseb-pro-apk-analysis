package androidx.core.util;

import android.annotation.SuppressLint;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes2.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(C2020dG c2020dG) {
        return new android.util.Pair<>(c2020dG.c(), c2020dG.e());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(C2020dG c2020dG) {
        return new Pair<>(c2020dG.c(), c2020dG.e());
    }

    public static final <F, S> C2020dG toKotlinPair(Pair<F, S> pair) {
        return new C2020dG(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    public static final <F, S> C2020dG toKotlinPair(android.util.Pair<F, S> pair) {
        return new C2020dG(pair.first, pair.second);
    }
}
