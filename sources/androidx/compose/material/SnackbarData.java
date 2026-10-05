package androidx.compose.material;

/* JADX INFO: loaded from: classes.dex */
public interface SnackbarData {
    void dismiss();

    String getActionLabel();

    SnackbarDuration getDuration();

    String getMessage();

    void performAction();
}
