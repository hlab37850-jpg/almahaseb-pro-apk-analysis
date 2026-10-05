package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.O8;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public final class AnchoredDraggableDefaults {
    public static final AnchoredDraggableDefaults INSTANCE = new AnchoredDraggableDefaults();
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec<>(0.0f, 0.0f, null, 7, null);

    private AnchoredDraggableDefaults() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getAnimationSpec$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getPositionalThreshold$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getVelocityThreshold$annotations() {
    }

    @ExperimentalMaterialApi
    public final <T> AnchoredDraggableState.AnchorChangedCallback<T> ReconcileAnimationOnAnchorChangedCallback$material_release(final AnchoredDraggableState<T> anchoredDraggableState, final InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(anchoredDraggableState, "state");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        return new AnchoredDraggableState.AnchorChangedCallback<T>() { // from class: androidx.compose.material.AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1
            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(T t, Map<T, Float> map, Map<T, Float> map2) {
                AbstractC4492zt.h(map, "previousAnchors");
                AbstractC4492zt.h(map2, "newAnchors");
                Float f = map.get(t);
                Float f2 = map2.get(t);
                if (AbstractC4492zt.c(f, f2)) {
                    return;
                }
                if (f2 != null) {
                    O8.d(interfaceC2052dg, null, null, new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$1(anchoredDraggableState, t, null), 3, null);
                } else {
                    O8.d(interfaceC2052dg, null, null, new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$2(anchoredDraggableState, map2, null), 3, null);
                }
            }
        };
    }

    @ExperimentalMaterialApi
    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    @Composable
    @ExperimentalMaterialApi
    public final InterfaceC3750qp getPositionalThreshold(Composer composer, int i) {
        composer.startReplaceableGroup(82866976);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(82866976, i, -1, "androidx.compose.material.AnchoredDraggableDefaults.<get-positionalThreshold> (AnchoredDraggable.kt:663)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new AnchoredDraggableDefaults$positionalThreshold$1$1$1(density);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC3750qp interfaceC3750qp = (InterfaceC3750qp) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC3750qp;
    }

    @Composable
    @ExperimentalMaterialApi
    public final InterfaceC3588op getVelocityThreshold(Composer composer, int i) {
        composer.startReplaceableGroup(2030704141);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030704141, i, -1, "androidx.compose.material.AnchoredDraggableDefaults.<get-velocityThreshold> (AnchoredDraggable.kt:654)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new AnchoredDraggableDefaults$velocityThreshold$1$1$1(density);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC3588op interfaceC3588op = (InterfaceC3588op) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC3588op;
    }
}
