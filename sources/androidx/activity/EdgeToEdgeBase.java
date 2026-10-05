package androidx.activity;

import android.view.View;
import android.view.Window;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
class EdgeToEdgeBase implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void adjustLayoutInDisplayCutoutMode(Window window) {
        AbstractC4492zt.h(window, "window");
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z, boolean z2) {
        AbstractC4492zt.h(systemBarStyle, "statusBarStyle");
        AbstractC4492zt.h(systemBarStyle2, "navigationBarStyle");
        AbstractC4492zt.h(window, "window");
        AbstractC4492zt.h(view, "view");
    }
}
