package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1();

    public SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final SavedStateHandlesVM invoke(CreationExtras creationExtras) {
        AbstractC4492zt.h(creationExtras, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
