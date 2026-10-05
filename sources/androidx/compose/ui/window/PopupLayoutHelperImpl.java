package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
class PopupLayoutHelperImpl implements PopupLayoutHelper {
    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void getWindowVisibleDisplayFrame(View view, Rect rect) {
        AbstractC4492zt.h(view, "composeView");
        AbstractC4492zt.h(rect, "outRect");
        view.getWindowVisibleDisplayFrame(rect);
    }

    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(View view, int i, int i2) {
        AbstractC4492zt.h(view, "composeView");
    }

    @Override // androidx.compose.ui.window.PopupLayoutHelper
    public void updateViewLayout(WindowManager windowManager, View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC4492zt.h(windowManager, "windowManager");
        AbstractC4492zt.h(view, "popupView");
        AbstractC4492zt.h(layoutParams, "params");
        windowManager.updateViewLayout(view, layoutParams);
    }
}
