package androidx.compose.material.ripple;

import defpackage.AbstractC4492zt;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class RippleHostMap {
    private final Map<AndroidRippleIndicationInstance, RippleHostView> indicationToHostMap = new LinkedHashMap();
    private final Map<RippleHostView, AndroidRippleIndicationInstance> hostToIndicationMap = new LinkedHashMap();

    public final RippleHostView get(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        AbstractC4492zt.h(androidRippleIndicationInstance, "indicationInstance");
        return this.indicationToHostMap.get(androidRippleIndicationInstance);
    }

    public final void remove(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        AbstractC4492zt.h(androidRippleIndicationInstance, "indicationInstance");
        RippleHostView rippleHostView = this.indicationToHostMap.get(androidRippleIndicationInstance);
        if (rippleHostView != null) {
            this.hostToIndicationMap.remove(rippleHostView);
        }
        this.indicationToHostMap.remove(androidRippleIndicationInstance);
    }

    public final void set(AndroidRippleIndicationInstance androidRippleIndicationInstance, RippleHostView rippleHostView) {
        AbstractC4492zt.h(androidRippleIndicationInstance, "indicationInstance");
        AbstractC4492zt.h(rippleHostView, "rippleHostView");
        this.indicationToHostMap.put(androidRippleIndicationInstance, rippleHostView);
        this.hostToIndicationMap.put(rippleHostView, androidRippleIndicationInstance);
    }

    public final AndroidRippleIndicationInstance get(RippleHostView rippleHostView) {
        AbstractC4492zt.h(rippleHostView, "rippleHostView");
        return this.hostToIndicationMap.get(rippleHostView);
    }
}
