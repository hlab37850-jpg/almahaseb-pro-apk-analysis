package androidx.compose.material.pullrefresh;

import defpackage.C0916Sp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class PullRefreshKt$pullRefresh$2$1 extends C0916Sp implements InterfaceC3750qp {
    public PullRefreshKt$pullRefresh$2$1(Object obj) {
        super(1, obj, PullRefreshState.class, "onPull", "onPull$material_release(F)F", 0);
    }

    public final Float invoke(float f) {
        return Float.valueOf(((PullRefreshState) this.receiver).onPull$material_release(f));
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
