package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class InspectableValueKt {
    private static final InterfaceC3750qp NoInspectorInfo = InspectableValueKt$NoInspectorInfo$1.INSTANCE;
    private static boolean isDebugInspectorInfoEnabled;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.InspectableValueKt$debugInspectorInfo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $definitions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$definitions = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$null");
            this.$definitions.invoke(inspectorInfo);
        }
    }

    public static final InterfaceC3750qp debugInspectorInfo(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "definitions");
        return isDebugInspectorInfoEnabled() ? new AnonymousClass1(interfaceC3750qp) : getNoInspectorInfo();
    }

    public static final InterfaceC3750qp getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    public static final Modifier inspectable(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC3750qp2, "factory");
        return inspectableWrapper(modifier, interfaceC3750qp, (Modifier) interfaceC3750qp2.invoke(Modifier.Companion));
    }

    public static final Modifier inspectableWrapper(Modifier modifier, InterfaceC3750qp interfaceC3750qp, Modifier modifier2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(modifier2, "wrapped");
        InspectableModifier inspectableModifier = new InspectableModifier(interfaceC3750qp);
        return modifier.then(inspectableModifier).then(modifier2).then(inspectableModifier.getEnd());
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean z) {
        isDebugInspectorInfoEnabled = z;
    }
}
