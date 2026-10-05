package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0557Gu;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0635Ju;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewModelLazy<VM extends ViewModel> implements InterfaceC3430mv {
    private VM cached;
    private final InterfaceC3588op extrasProducer;
    private final InterfaceC3588op factoryProducer;
    private final InterfaceC3588op storeProducer;
    private final InterfaceC0635Ju viewModelClass;

    /* JADX INFO: renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(InterfaceC0635Ju interfaceC0635Ju, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2) {
        this(interfaceC0635Ju, interfaceC3588op, interfaceC3588op2, null, 8, null);
        AbstractC4492zt.h(interfaceC0635Ju, "viewModelClass");
        AbstractC4492zt.h(interfaceC3588op, "storeProducer");
        AbstractC4492zt.h(interfaceC3588op2, "factoryProducer");
    }

    @Override // defpackage.InterfaceC3430mv
    public boolean isInitialized() {
        return this.cached != null;
    }

    public ViewModelLazy(InterfaceC0635Ju interfaceC0635Ju, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3) {
        AbstractC4492zt.h(interfaceC0635Ju, "viewModelClass");
        AbstractC4492zt.h(interfaceC3588op, "storeProducer");
        AbstractC4492zt.h(interfaceC3588op2, "factoryProducer");
        AbstractC4492zt.h(interfaceC3588op3, "extrasProducer");
        this.viewModelClass = interfaceC0635Ju;
        this.storeProducer = interfaceC3588op;
        this.factoryProducer = interfaceC3588op2;
        this.extrasProducer = interfaceC3588op3;
    }

    @Override // defpackage.InterfaceC3430mv
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(AbstractC0557Gu.a(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(InterfaceC0635Ju interfaceC0635Ju, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC0635Ju, interfaceC3588op, interfaceC3588op2, (i & 8) != 0 ? AnonymousClass1.INSTANCE : interfaceC3588op3);
    }
}
