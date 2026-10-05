package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CustomAccessibilityAction {
    public static final int $stable = 0;
    private final InterfaceC3588op action;
    private final String label;

    public CustomAccessibilityAction(String str, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(str, HTML.Tag.LABEL);
        AbstractC4492zt.h(interfaceC3588op, "action");
        this.label = str;
        this.action = interfaceC3588op;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAccessibilityAction)) {
            return false;
        }
        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) obj;
        return AbstractC4492zt.d(this.label, customAccessibilityAction.label) && AbstractC4492zt.d(this.action, customAccessibilityAction.action);
    }

    public final InterfaceC3588op getAction() {
        return this.action;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.action.hashCode();
    }

    public String toString() {
        return "CustomAccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
