package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final Class<T> clazz;
    private final InterfaceC3750qp initializer;

    public ViewModelInitializer(Class<T> cls, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(cls, "clazz");
        AbstractC4492zt.h(interfaceC3750qp, "initializer");
        this.clazz = cls;
        this.initializer = interfaceC3750qp;
    }

    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final InterfaceC3750qp getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
