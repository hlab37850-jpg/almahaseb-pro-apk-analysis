package androidx.window.layout;

import androidx.annotation.RestrictTo;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowLayoutInfo {
    private final List<DisplayFeature> displayFeatures;

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowLayoutInfo(List<? extends DisplayFeature> list) {
        AbstractC4492zt.h(list, "displayFeatures");
        this.displayFeatures = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AbstractC4492zt.d(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return AbstractC4492zt.d(this.displayFeatures, ((WindowLayoutInfo) obj).displayFeatures);
    }

    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    public String toString() {
        return AbstractC3240kc.j0(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
