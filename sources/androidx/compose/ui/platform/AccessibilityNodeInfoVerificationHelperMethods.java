package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class AccessibilityNodeInfoVerificationHelperMethods {
    public static final AccessibilityNodeInfoVerificationHelperMethods INSTANCE = new AccessibilityNodeInfoVerificationHelperMethods();

    private AccessibilityNodeInfoVerificationHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAvailableExtraData(AccessibilityNodeInfo accessibilityNodeInfo, List<String> list) {
        AbstractC4492zt.h(accessibilityNodeInfo, "node");
        AbstractC4492zt.h(list, "data");
        accessibilityNodeInfo.setAvailableExtraData(list);
    }
}
