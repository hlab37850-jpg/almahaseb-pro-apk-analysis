package androidx.compose.ui.platform;

import defpackage.IX;

/* JADX INFO: loaded from: classes.dex */
public interface ViewConfiguration {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m4529getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration viewConfiguration) {
            return IX.a(viewConfiguration);
        }
    }

    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo4293getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();
}
