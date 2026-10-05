package androidx.compose.ui.platform;

import android.os.Build;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.PrimaryTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextToolbar implements TextToolbar {
    private ActionMode actionMode;
    private TextToolbarStatus status;
    private final TextActionModeCallback textActionModeCallback;
    private final View view;

    public AndroidTextToolbar(View view) {
        AbstractC4492zt.h(view, "view");
        this.view = view;
        this.textActionModeCallback = new TextActionModeCallback(new AndroidTextToolbar$textActionModeCallback$1(this), null, null, null, null, null, 62, null);
        this.status = TextToolbarStatus.Hidden;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return this.status;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(Rect rect, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, InterfaceC3588op interfaceC3588op4) {
        AbstractC4492zt.h(rect, "rect");
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(interfaceC3588op);
        this.textActionModeCallback.setOnCutRequested(interfaceC3588op3);
        this.textActionModeCallback.setOnPasteRequested(interfaceC3588op2);
        this.textActionModeCallback.setOnSelectAllRequested(interfaceC3588op4);
        ActionMode actionMode = this.actionMode;
        if (actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = Build.VERSION.SDK_INT >= 23 ? TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1) : this.view.startActionMode(new PrimaryTextActionModeCallback(this.textActionModeCallback));
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }
}
