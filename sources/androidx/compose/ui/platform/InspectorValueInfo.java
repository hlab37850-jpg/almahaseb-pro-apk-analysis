package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4362yO;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class InspectorValueInfo implements InspectableValue {
    public static final int $stable = 8;
    private InspectorInfo _values;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private final InterfaceC3750qp f57info;

    public InspectorValueInfo(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "info");
        this.f57info = interfaceC3750qp;
    }

    private final InspectorInfo getValues() {
        InspectorInfo inspectorInfo = this._values;
        if (inspectorInfo == null) {
            inspectorInfo = new InspectorInfo();
            this.f57info.invoke(inspectorInfo);
        }
        this._values = inspectorInfo;
        return inspectorInfo;
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public InterfaceC4362yO getInspectableElements() {
        return getValues().getProperties();
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public String getNameFallback() {
        return getValues().getName();
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public Object getValueOverride() {
        return getValues().getValue();
    }
}
