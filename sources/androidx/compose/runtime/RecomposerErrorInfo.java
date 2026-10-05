package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
@InternalComposeApi
public interface RecomposerErrorInfo {
    Exception getCause();

    boolean getRecoverable();
}
