package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateHolder {
    @Composable
    void SaveableStateProvider(Object obj, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i);

    void removeState(Object obj);
}
