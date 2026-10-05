package androidx.compose.ui.hapticfeedback;

import android.view.View;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    private final View view;

    public PlatformHapticFeedback(View view) {
        AbstractC4492zt.h(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo3602performHapticFeedbackCdsT49E(int i) {
        HapticFeedbackType.Companion companion = HapticFeedbackType.Companion;
        if (HapticFeedbackType.m3606equalsimpl0(i, companion.m3610getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m3606equalsimpl0(i, companion.m3611getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
