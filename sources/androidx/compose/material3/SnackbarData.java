package androidx.compose.material3;

import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface SnackbarData {
    void dismiss();

    SnackbarVisuals getVisuals();

    void performAction();
}
