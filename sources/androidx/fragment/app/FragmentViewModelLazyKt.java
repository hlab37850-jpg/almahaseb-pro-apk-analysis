package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0635Ju;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3588op;
import defpackage.QJ;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // defpackage.InterfaceC3588op
        public final ViewModelStore invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            AbstractC4492zt.g(fragmentActivityRequireActivity, "requireActivity()");
            ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
            AbstractC4492zt.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        @Override // defpackage.InterfaceC3588op
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            AbstractC4492zt.g(fragmentActivityRequireActivity, "requireActivity()");
            return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16851 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16851(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        @Override // defpackage.InterfaceC3588op
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16862 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16862(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$ownerProducer = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3588op
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            AbstractC4492zt.g(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC3430mv activityViewModels(Fragment fragment, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(fragment, "$this$activityViewModels");
        AbstractC4492zt.m(4, "VM");
        InterfaceC0635Ju interfaceC0635JuB = QJ.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        if (interfaceC3588op == null) {
            interfaceC3588op = new AnonymousClass2(fragment);
        }
        return createViewModelLazy(fragment, interfaceC0635JuB, anonymousClass1, interfaceC3588op);
    }

    public static /* synthetic */ InterfaceC3430mv activityViewModels$default(Fragment fragment, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3588op = null;
        }
        AbstractC4492zt.h(fragment, "$this$activityViewModels");
        AbstractC4492zt.m(4, "VM");
        InterfaceC0635Ju interfaceC0635JuB = QJ.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        if (interfaceC3588op == null) {
            interfaceC3588op = new AnonymousClass2(fragment);
        }
        return createViewModelLazy(fragment, interfaceC0635JuB, anonymousClass1, interfaceC3588op);
    }

    @MainThread
    public static final <VM extends ViewModel> InterfaceC3430mv createViewModelLazy(Fragment fragment, InterfaceC0635Ju interfaceC0635Ju, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(fragment, "$this$createViewModelLazy");
        AbstractC4492zt.h(interfaceC0635Ju, "viewModelClass");
        AbstractC4492zt.h(interfaceC3588op, "storeProducer");
        if (interfaceC3588op2 == null) {
            interfaceC3588op2 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(interfaceC0635Ju, interfaceC3588op, interfaceC3588op2);
    }

    public static /* synthetic */ InterfaceC3430mv createViewModelLazy$default(Fragment fragment, InterfaceC0635Ju interfaceC0635Ju, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, int i, Object obj) {
        if ((i & 4) != 0) {
            interfaceC3588op2 = null;
        }
        return createViewModelLazy(fragment, interfaceC0635Ju, interfaceC3588op, interfaceC3588op2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC3430mv viewModels(Fragment fragment, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(fragment, "$this$viewModels");
        AbstractC4492zt.h(interfaceC3588op, "ownerProducer");
        AbstractC4492zt.m(4, "VM");
        return createViewModelLazy(fragment, QJ.b(ViewModel.class), new C16862(interfaceC3588op), interfaceC3588op2);
    }

    public static /* synthetic */ InterfaceC3430mv viewModels$default(Fragment fragment, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3588op = new C16851(fragment);
        }
        if ((i & 2) != 0) {
            interfaceC3588op2 = null;
        }
        AbstractC4492zt.h(fragment, "$this$viewModels");
        AbstractC4492zt.h(interfaceC3588op, "ownerProducer");
        AbstractC4492zt.m(4, "VM");
        return createViewModelLazy(fragment, QJ.b(ViewModel.class), new C16862(interfaceC3588op), interfaceC3588op2);
    }
}
