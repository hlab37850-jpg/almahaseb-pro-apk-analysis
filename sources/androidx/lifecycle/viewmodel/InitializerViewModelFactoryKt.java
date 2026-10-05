package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.QJ;

/* JADX INFO: loaded from: classes2.dex */
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(initializerViewModelFactoryBuilder, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "initializer");
        AbstractC4492zt.m(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(QJ.b(ViewModel.class), interfaceC3750qp);
    }

    public static final ViewModelProvider.Factory viewModelFactory(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        interfaceC3750qp.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
