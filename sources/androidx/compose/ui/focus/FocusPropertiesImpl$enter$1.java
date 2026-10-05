package androidx.compose.ui.focus;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusPropertiesImpl$enter$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final FocusPropertiesImpl$enter$1 INSTANCE = new FocusPropertiesImpl$enter$1();

    public FocusPropertiesImpl$enter$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m2740invoke3ESFkO8(((FocusDirection) obj).m2717unboximpl());
    }

    /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2740invoke3ESFkO8(int i) {
        return FocusRequester.Companion.getDefault();
    }
}
