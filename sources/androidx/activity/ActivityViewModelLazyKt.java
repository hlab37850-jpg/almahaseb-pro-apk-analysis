package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3588op;
import defpackage.QJ;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        @Override // defpackage.InterfaceC3588op
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        @Override // defpackage.InterfaceC3588op
        public final CreationExtras invoke() {
            return this.$this_viewModels.getDefaultViewModelCreationExtras();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        @Override // defpackage.InterfaceC3588op
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $extrasProducer;
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3588op interfaceC3588op, ComponentActivity componentActivity) {
            super(0);
            this.$extrasProducer = interfaceC3588op;
            this.$this_viewModels = componentActivity;
        }

        @Override // defpackage.InterfaceC3588op
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            InterfaceC3588op interfaceC3588op = this.$extrasProducer;
            return (interfaceC3588op == null || (creationExtras = (CreationExtras) interfaceC3588op.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : creationExtras;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC3430mv viewModels(ComponentActivity componentActivity, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(componentActivity, "<this>");
        if (interfaceC3588op == null) {
            interfaceC3588op = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        AbstractC4492zt.m(4, "VM");
        return new ViewModelLazy(QJ.b(ViewModel.class), new AnonymousClass1(componentActivity), interfaceC3588op, new AnonymousClass2(componentActivity));
    }

    public static /* synthetic */ InterfaceC3430mv viewModels$default(ComponentActivity componentActivity, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3588op = null;
        }
        AbstractC4492zt.h(componentActivity, "<this>");
        if (interfaceC3588op == null) {
            interfaceC3588op = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        AbstractC4492zt.m(4, "VM");
        return new ViewModelLazy(QJ.b(ViewModel.class), new AnonymousClass1(componentActivity), interfaceC3588op, new AnonymousClass2(componentActivity));
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC3430mv viewModels(ComponentActivity componentActivity, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2) {
        AbstractC4492zt.h(componentActivity, "<this>");
        if (interfaceC3588op2 == null) {
            interfaceC3588op2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        AbstractC4492zt.m(4, "VM");
        return new ViewModelLazy(QJ.b(ViewModel.class), new AnonymousClass3(componentActivity), interfaceC3588op2, new AnonymousClass4(interfaceC3588op, componentActivity));
    }

    public static /* synthetic */ InterfaceC3430mv viewModels$default(ComponentActivity componentActivity, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3588op = null;
        }
        if ((i & 2) != 0) {
            interfaceC3588op2 = null;
        }
        AbstractC4492zt.h(componentActivity, "<this>");
        if (interfaceC3588op2 == null) {
            interfaceC3588op2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        AbstractC4492zt.m(4, "VM");
        return new ViewModelLazy(QJ.b(ViewModel.class), new AnonymousClass3(componentActivity), interfaceC3588op2, new AnonymousClass4(interfaceC3588op, componentActivity));
    }
}
