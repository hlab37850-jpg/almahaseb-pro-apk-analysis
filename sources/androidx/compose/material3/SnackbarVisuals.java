package androidx.compose.material3;

import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface SnackbarVisuals {
    String getActionLabel();

    SnackbarDuration getDuration();

    String getMessage();

    boolean getWithDismissAction();
}
