package androidx.compose.ui.platform;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ExperimentalComposeUiApi;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface WindowInfo {
    @ExperimentalComposeUiApi
    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    int mo4530getKeyboardModifiersk7X9c1A();

    boolean isWindowFocused();
}
