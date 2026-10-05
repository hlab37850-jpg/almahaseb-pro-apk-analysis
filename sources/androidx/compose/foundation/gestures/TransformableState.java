package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public interface TransformableState {

    public static final class DefaultImpls {
    }

    boolean isTransformInProgress();

    Object transform(MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);
}
