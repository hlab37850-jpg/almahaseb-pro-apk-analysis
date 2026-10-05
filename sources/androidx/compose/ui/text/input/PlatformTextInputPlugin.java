package androidx.compose.ui.text.input;

import android.view.View;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalTextApi
public interface PlatformTextInputPlugin<T extends PlatformTextInputAdapter> {
    T createAdapter(PlatformTextInput platformTextInput, View view);
}
