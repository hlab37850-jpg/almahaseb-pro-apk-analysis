package androidx.compose.ui.platform;

import java.lang.Comparable;

/* JADX INFO: loaded from: classes.dex */
public interface OpenEndRange<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndExclusive();

    T getStart();

    boolean isEmpty();
}
