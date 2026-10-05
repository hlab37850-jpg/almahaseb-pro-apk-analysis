package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class SidecarAdapter$translate$checkedFeature$4 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SidecarAdapter$translate$checkedFeature$4 INSTANCE = new SidecarAdapter$translate$checkedFeature$4();

    public SidecarAdapter$translate$checkedFeature$4() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        AbstractC4492zt.h(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
    }
}
