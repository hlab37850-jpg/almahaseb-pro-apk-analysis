package androidx.compose.ui.text.input;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.ExperimentalTextApi;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalTextApi
public interface PlatformTextInputPluginRegistry {
    @Composable
    <T extends PlatformTextInputAdapter> T rememberAdapter(PlatformTextInputPlugin<T> platformTextInputPlugin, Composer composer, int i);
}
