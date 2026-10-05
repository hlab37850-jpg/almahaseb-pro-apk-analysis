package androidx.activity;

import android.content.res.Resources;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle$Companion$auto$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    public SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(Resources resources) {
        AbstractC4492zt.h(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
