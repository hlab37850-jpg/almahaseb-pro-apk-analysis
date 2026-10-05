package androidx.compose.runtime;

import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public interface RememberManager {
    void deactivating(ComposeNodeLifecycleCallback composeNodeLifecycleCallback);

    void forgetting(RememberObserver rememberObserver);

    void releasing(ComposeNodeLifecycleCallback composeNodeLifecycleCallback);

    void remembering(RememberObserver rememberObserver);

    void sideEffect(InterfaceC3588op interfaceC3588op);
}
