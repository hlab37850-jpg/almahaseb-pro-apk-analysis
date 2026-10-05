package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class TextToolbarHelperMethods {
    public static final TextToolbarHelperMethods INSTANCE = new TextToolbarHelperMethods();

    private TextToolbarHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(23)
    public final void invalidateContentRect(ActionMode actionMode) {
        AbstractC4492zt.h(actionMode, "actionMode");
        actionMode.invalidateContentRect();
    }

    @DoNotInline
    @RequiresApi(23)
    public final ActionMode startActionMode(View view, ActionMode.Callback callback, int i) {
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(callback, "actionModeCallback");
        return view.startActionMode(callback, i);
    }
}
