package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationDrawerKt$ModalNavigationDrawer$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final NavigationDrawerKt$ModalNavigationDrawer$1 INSTANCE = new NavigationDrawerKt$ModalNavigationDrawer$1();

    public NavigationDrawerKt$ModalNavigationDrawer$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ThresholdConfig mo13invoke(DrawerValue drawerValue, DrawerValue drawerValue2) {
        AbstractC4492zt.h(drawerValue, "<anonymous parameter 0>");
        AbstractC4492zt.h(drawerValue2, "<anonymous parameter 1>");
        return new FractionalThreshold(0.5f);
    }
}
