package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SubcomposeLayoutState {
    public static final int $stable = 8;
    private LayoutNodeSubcompositionsState _state;
    private final InterfaceC0526Fp setCompositionContext;
    private final InterfaceC0526Fp setIntermediateMeasurePolicy;
    private final InterfaceC0526Fp setMeasurePolicy;
    private final InterfaceC0526Fp setRoot;
    private final SubcomposeSlotReusePolicy slotReusePolicy;

    public interface PrecomposedSlotHandle {
        void dispose();

        int getPlaceablesCount();

        /* JADX INFO: renamed from: premeasure-0kLqBqw */
        void mo4180premeasure0kLqBqw(int i, long j);
    }

    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        AbstractC4492zt.h(subcomposeSlotReusePolicy, "slotReusePolicy");
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        this.setRoot = new SubcomposeLayoutState$setRoot$1(this);
        this.setCompositionContext = new SubcomposeLayoutState$setCompositionContext$1(this);
        this.setMeasurePolicy = new SubcomposeLayoutState$setMeasurePolicy$1(this);
        this.setIntermediateMeasurePolicy = new SubcomposeLayoutState$setIntermediateMeasurePolicy$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout");
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void isInLookaheadScope$annotations() {
    }

    public final void disposeCurrentNodes$ui_release() {
        getState().disposeCurrentNodes();
    }

    public final void forceRecomposeChildren$ui_release() {
        getState().forceRecomposeChildren();
    }

    public final InterfaceC0526Fp getSetCompositionContext$ui_release() {
        return this.setCompositionContext;
    }

    public final InterfaceC0526Fp getSetIntermediateMeasurePolicy$ui_release() {
        return this.setIntermediateMeasurePolicy;
    }

    public final InterfaceC0526Fp getSetMeasurePolicy$ui_release() {
        return this.setMeasurePolicy;
    }

    public final InterfaceC0526Fp getSetRoot$ui_release() {
        return this.setRoot;
    }

    @ExperimentalComposeUiApi
    public final boolean isInLookaheadScope() {
        return getState().isInLookaheadScope();
    }

    public final PrecomposedSlotHandle precompose(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        return getState().precompose(obj, interfaceC0526Fp);
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    public SubcomposeLayoutState(int i) {
        this(SubcomposeLayoutKt.SubcomposeSlotReusePolicy(i));
    }
}
