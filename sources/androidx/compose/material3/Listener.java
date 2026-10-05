package androidx.compose.material3;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {
    private final MutableState accessibilityEnabled$delegate;
    private final MutableState touchExplorationEnabled$delegate;

    public Listener() {
        Boolean bool = Boolean.FALSE;
        this.accessibilityEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.touchExplorationEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }

    private final boolean getAccessibilityEnabled() {
        return ((Boolean) this.accessibilityEnabled$delegate.getValue()).booleanValue();
    }

    private final boolean getTouchExplorationEnabled() {
        return ((Boolean) this.touchExplorationEnabled$delegate.getValue()).booleanValue();
    }

    private final void setAccessibilityEnabled(boolean z) {
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setTouchExplorationEnabled(boolean z) {
        this.touchExplorationEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isEnabled() {
        return getAccessibilityEnabled() && getTouchExplorationEnabled();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z) {
        setAccessibilityEnabled(z);
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z) {
        setTouchExplorationEnabled(z);
    }

    public final void register(AccessibilityManager accessibilityManager) {
        AbstractC4492zt.h(accessibilityManager, "am");
        setAccessibilityEnabled(accessibilityManager.isEnabled());
        setTouchExplorationEnabled(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(this);
        accessibilityManager.addAccessibilityStateChangeListener(this);
    }

    public final void unregister(AccessibilityManager accessibilityManager) {
        AbstractC4492zt.h(accessibilityManager, "am");
        accessibilityManager.removeTouchExplorationStateChangeListener(this);
        accessibilityManager.removeAccessibilityStateChangeListener(this);
    }
}
