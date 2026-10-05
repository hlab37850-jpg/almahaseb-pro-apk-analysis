package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface SubcomposeIntermediateMeasureScope extends SubcomposeMeasureScope {
    /* JADX INFO: renamed from: getLookaheadConstraints-msEJaDk */
    long mo4175getLookaheadConstraintsmsEJaDk();

    InterfaceC0526Fp getLookaheadMeasurePolicy();

    /* JADX INFO: renamed from: getLookaheadSize-YbymL2g */
    long mo4176getLookaheadSizeYbymL2g();

    List<Measurable> measurablesForSlot(Object obj);

    @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
    List<Measurable> subcompose(Object obj, InterfaceC0526Fp interfaceC0526Fp);
}
