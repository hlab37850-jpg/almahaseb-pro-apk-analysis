package androidx.compose.ui.text.input;

import androidx.compose.ui.text.ExperimentalTextApi;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public interface PlatformTextInput {
    void releaseInputFocus();

    void requestInputFocus();
}
