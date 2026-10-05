package androidx.paging;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DifferCallback {
    void onChanged(int i, int i2);

    void onInserted(int i, int i2);

    void onRemoved(int i, int i2);
}
