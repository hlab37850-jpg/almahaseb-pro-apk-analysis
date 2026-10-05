package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes.dex */
public abstract class RippleIndicationInstance implements IndicationInstance {
    private final StateLayer stateLayer;

    public RippleIndicationInstance(boolean z, State<RippleAlpha> state) {
        AbstractC4492zt.h(state, "rippleAlpha");
        this.stateLayer = new StateLayer(z, state);
    }

    public abstract void addRipple(PressInteraction.Press press, InterfaceC2052dg interfaceC2052dg);

    /* JADX INFO: renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m1317drawStateLayerH2RKhps(DrawScope drawScope, float f, long j) {
        AbstractC4492zt.h(drawScope, "$this$drawStateLayer");
        this.stateLayer.m1321drawStateLayerH2RKhps(drawScope, f, j);
    }

    public abstract void removeRipple(PressInteraction.Press press);

    public final void updateStateLayer$material_ripple_release(Interaction interaction, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(interaction, "interaction");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        this.stateLayer.handleInteraction(interaction, interfaceC2052dg);
    }
}
