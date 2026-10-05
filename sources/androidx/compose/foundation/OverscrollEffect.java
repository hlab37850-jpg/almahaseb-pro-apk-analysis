package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface OverscrollEffect {
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ */
    Object mo161applyToFlingBMRW4eQ(long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);

    /* JADX INFO: renamed from: applyToScroll-Rhakbz0 */
    long mo162applyToScrollRhakbz0(long j, int i, InterfaceC3750qp interfaceC3750qp);

    Modifier getEffectModifier();

    boolean isInProgress();
}
