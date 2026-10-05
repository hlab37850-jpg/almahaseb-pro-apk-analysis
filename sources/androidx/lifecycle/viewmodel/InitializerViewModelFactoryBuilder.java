package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import defpackage.AbstractC0557Gu;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0635Ju;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@ViewModelFactoryDsl
public final class InitializerViewModelFactoryBuilder {
    private final List<ViewModelInitializer<?>> initializers = new ArrayList();

    public final <T extends ViewModel> void addInitializer(InterfaceC0635Ju interfaceC0635Ju, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC0635Ju, "clazz");
        AbstractC4492zt.h(interfaceC3750qp, "initializer");
        this.initializers.add(new ViewModelInitializer<>(AbstractC0557Gu.a(interfaceC0635Ju), interfaceC3750qp));
    }

    public final ViewModelProvider.Factory build() {
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.initializers.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
