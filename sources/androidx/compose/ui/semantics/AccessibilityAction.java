package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0348Ap;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
public final class AccessibilityAction<T extends InterfaceC0348Ap> {
    public static final int $stable = 0;
    private final T action;
    private final String label;

    public AccessibilityAction(String str, T t) {
        this.label = str;
        this.action = t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        return AbstractC4492zt.d(this.label, accessibilityAction.label) && AbstractC4492zt.d(this.action, accessibilityAction.action);
    }

    public final T getAction() {
        return this.action;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        String str = this.label;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        T t = this.action;
        return iHashCode + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
