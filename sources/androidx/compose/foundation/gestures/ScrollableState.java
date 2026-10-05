package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.PN;

/* JADX INFO: loaded from: classes.dex */
public interface ScrollableState {

    public static final class DefaultImpls {
        @Deprecated
        public static boolean getCanScrollBackward(ScrollableState scrollableState) {
            return PN.a(scrollableState);
        }

        @Deprecated
        public static boolean getCanScrollForward(ScrollableState scrollableState) {
            return PN.b(scrollableState);
        }
    }

    float dispatchRawDelta(float f);

    boolean getCanScrollBackward();

    boolean getCanScrollForward();

    boolean isScrollInProgress();

    Object scroll(MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);
}
