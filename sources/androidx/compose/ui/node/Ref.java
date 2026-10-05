package androidx.compose.ui.node;

import androidx.compose.runtime.internal.StabilityInferred;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Ref<T> {
    public static final int $stable = 8;
    private T value;

    public final T getValue() {
        return this.value;
    }

    public final void setValue(T t) {
        this.value = t;
    }
}
