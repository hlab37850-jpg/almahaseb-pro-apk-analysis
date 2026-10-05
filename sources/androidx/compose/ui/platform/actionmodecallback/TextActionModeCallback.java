package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Rect;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TextActionModeCallback {
    private final InterfaceC3588op onActionModeDestroy;
    private InterfaceC3588op onCopyRequested;
    private InterfaceC3588op onCutRequested;
    private InterfaceC3588op onPasteRequested;
    private InterfaceC3588op onSelectAllRequested;
    private Rect rect;

    public TextActionModeCallback() {
        this(null, null, null, null, null, null, 63, null);
    }

    private final void addOrRemoveMenuItem(Menu menu, MenuItemOption menuItemOption, InterfaceC3588op interfaceC3588op) {
        if (interfaceC3588op != null && menu.findItem(menuItemOption.getId()) == null) {
            addMenuItem$ui_release(menu, menuItemOption);
        } else {
            if (interfaceC3588op != null || menu.findItem(menuItemOption.getId()) == null) {
                return;
            }
            menu.removeItem(menuItemOption.getId());
        }
    }

    public final void addMenuItem$ui_release(Menu menu, MenuItemOption menuItemOption) {
        AbstractC4492zt.h(menu, HTML.Tag.MENU);
        AbstractC4492zt.h(menuItemOption, "item");
        menu.add(0, menuItemOption.getId(), menuItemOption.getOrder(), menuItemOption.getTitleResource()).setShowAsAction(1);
    }

    public final InterfaceC3588op getOnActionModeDestroy() {
        return this.onActionModeDestroy;
    }

    public final InterfaceC3588op getOnCopyRequested() {
        return this.onCopyRequested;
    }

    public final InterfaceC3588op getOnCutRequested() {
        return this.onCutRequested;
    }

    public final InterfaceC3588op getOnPasteRequested() {
        return this.onPasteRequested;
    }

    public final InterfaceC3588op getOnSelectAllRequested() {
        return this.onSelectAllRequested;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        AbstractC4492zt.e(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            InterfaceC3588op interfaceC3588op = this.onCopyRequested;
            if (interfaceC3588op != null) {
                interfaceC3588op.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            InterfaceC3588op interfaceC3588op2 = this.onPasteRequested;
            if (interfaceC3588op2 != null) {
                interfaceC3588op2.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            InterfaceC3588op interfaceC3588op3 = this.onCutRequested;
            if (interfaceC3588op3 != null) {
                interfaceC3588op3.invoke();
            }
        } else {
            if (itemId != MenuItemOption.SelectAll.getId()) {
                return false;
            }
            InterfaceC3588op interfaceC3588op4 = this.onSelectAllRequested;
            if (interfaceC3588op4 != null) {
                interfaceC3588op4.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (actionMode == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (this.onCopyRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Copy);
        }
        if (this.onPasteRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Paste);
        }
        if (this.onCutRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Cut);
        }
        if (this.onSelectAllRequested == null) {
            return true;
        }
        addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
        return true;
    }

    public final void onDestroyActionMode() {
        InterfaceC3588op interfaceC3588op = this.onActionModeDestroy;
        if (interfaceC3588op != null) {
            interfaceC3588op.invoke();
        }
    }

    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        updateMenuItems$ui_release(menu);
        return true;
    }

    public final void setOnCopyRequested(InterfaceC3588op interfaceC3588op) {
        this.onCopyRequested = interfaceC3588op;
    }

    public final void setOnCutRequested(InterfaceC3588op interfaceC3588op) {
        this.onCutRequested = interfaceC3588op;
    }

    public final void setOnPasteRequested(InterfaceC3588op interfaceC3588op) {
        this.onPasteRequested = interfaceC3588op;
    }

    public final void setOnSelectAllRequested(InterfaceC3588op interfaceC3588op) {
        this.onSelectAllRequested = interfaceC3588op;
    }

    public final void setRect(Rect rect) {
        AbstractC4492zt.h(rect, "<set-?>");
        this.rect = rect;
    }

    @VisibleForTesting
    public final void updateMenuItems$ui_release(Menu menu) {
        AbstractC4492zt.h(menu, HTML.Tag.MENU);
        addOrRemoveMenuItem(menu, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, this.onSelectAllRequested);
    }

    public TextActionModeCallback(InterfaceC3588op interfaceC3588op, Rect rect, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, InterfaceC3588op interfaceC3588op4, InterfaceC3588op interfaceC3588op5) {
        AbstractC4492zt.h(rect, "rect");
        this.onActionModeDestroy = interfaceC3588op;
        this.rect = rect;
        this.onCopyRequested = interfaceC3588op2;
        this.onPasteRequested = interfaceC3588op3;
        this.onCutRequested = interfaceC3588op4;
        this.onSelectAllRequested = interfaceC3588op5;
    }

    public /* synthetic */ TextActionModeCallback(InterfaceC3588op interfaceC3588op, Rect rect, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, InterfaceC3588op interfaceC3588op4, InterfaceC3588op interfaceC3588op5, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : interfaceC3588op, (i & 2) != 0 ? Rect.Companion.getZero() : rect, (i & 4) != 0 ? null : interfaceC3588op2, (i & 8) != 0 ? null : interfaceC3588op3, (i & 16) != 0 ? null : interfaceC3588op4, (i & 32) != 0 ? null : interfaceC3588op5);
    }
}
