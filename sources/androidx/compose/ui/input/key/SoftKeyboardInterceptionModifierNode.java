package androidx.compose.ui.input.key;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.DelegatableNode;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface SoftKeyboardInterceptionModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: onInterceptKeyBeforeSoftKeyboard-ZmokQxo */
    boolean mo3626onInterceptKeyBeforeSoftKeyboardZmokQxo(android.view.KeyEvent keyEvent);

    /* JADX INFO: renamed from: onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo */
    boolean mo3627onPreInterceptKeyBeforeSoftKeyboardZmokQxo(android.view.KeyEvent keyEvent);
}
