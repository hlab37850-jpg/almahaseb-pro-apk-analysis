package androidx.compose.material.pullrefresh;

import defpackage.AbstractC3765r2;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class PullRefreshKt$pullRefresh$2$2 extends AbstractC3765r2 implements InterfaceC0526Fp {
    public PullRefreshKt$pullRefresh$2$2(Object obj) {
        super(2, obj, PullRefreshState.class, "onRelease", "onRelease$material_release(F)F", 4);
    }

    public final Object invoke(float f, InterfaceC0793Of interfaceC0793Of) {
        return PullRefreshKt.pullRefresh$lambda$1$onRelease((PullRefreshState) this.receiver, f, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).floatValue(), (InterfaceC0793Of) obj2);
    }
}
