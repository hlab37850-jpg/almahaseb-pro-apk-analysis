package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.text.ExperimentalTextApi;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public interface PlatformTextInputAdapter {
    InputConnection createInputConnection(EditorInfo editorInfo);

    void onDisposed();
}
