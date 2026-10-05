package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationBarKt$NavigationBarItem$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<Integer> $itemWidth$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBarItem$2$1(MutableState<Integer> mutableState) {
        super(1);
        this.$itemWidth$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1664invokeozmzZPI(((IntSize) obj).m5324unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m1664invokeozmzZPI(long j) {
        NavigationBarKt.NavigationBarItem$lambda$4(this.$itemWidth$delegate, IntSize.m5320getWidthimpl(j));
    }
}
