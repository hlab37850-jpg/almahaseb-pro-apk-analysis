package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    @Override // defpackage.InterfaceC3588op
    public final ViewModelProvider.Factory invoke() {
        return this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
    }
}
