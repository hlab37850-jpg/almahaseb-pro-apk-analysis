package androidx.work.impl.constraints;

import androidx.annotation.MainThread;

/* JADX INFO: loaded from: classes2.dex */
public interface ConstraintListener<T> {
    @MainThread
    void onConstraintChanged(T t);
}
