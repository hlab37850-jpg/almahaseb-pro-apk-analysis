package androidx.compose.ui.focus;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusProperties$exit$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final FocusProperties$exit$1 INSTANCE = new FocusProperties$exit$1();

    public FocusProperties$exit$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m2739invoke3ESFkO8(((FocusDirection) obj).m2717unboximpl());
    }

    /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2739invoke3ESFkO8(int i) {
        return FocusRequester.Companion.getDefault();
    }
}
