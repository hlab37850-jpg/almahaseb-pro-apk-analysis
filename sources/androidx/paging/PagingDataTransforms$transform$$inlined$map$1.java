package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC0819Pf;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingDataTransforms$transform$$inlined$map$1 implements InterfaceC0939Tm {
    final /* synthetic */ InterfaceC0939Tm $this_unsafeTransform$inlined;
    final /* synthetic */ InterfaceC0526Fp $transform$inlined;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$transform$$inlined$map$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
        final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;
        final /* synthetic */ InterfaceC0526Fp $transform$inlined$1;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$transform$$inlined$map$1$2$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$transform$$inlined$map$1$2", f = "PagingDataTransforms.kt", l = {224, 223}, m = "emit")
        public static final class AnonymousClass1 extends AbstractC0819Pf {
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0526Fp interfaceC0526Fp) {
            this.$this_unsafeFlow = interfaceC0995Vm;
            this.$transform$inlined$1 = interfaceC0526Fp;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            AnonymousClass1 anonymousClass1;
            InterfaceC0995Vm interfaceC0995Vm;
            if (interfaceC0793Of instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
                int i = anonymousClass1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i - Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                }
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
            Object obj2 = anonymousClass1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = anonymousClass1.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    interfaceC0995Vm = (InterfaceC0995Vm) anonymousClass1.L$0;
                    LL.b(obj2);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj2);
                }
                return FW.a;
            }
            LL.b(obj2);
            InterfaceC0995Vm interfaceC0995Vm2 = this.$this_unsafeFlow;
            InterfaceC0526Fp interfaceC0526Fp = this.$transform$inlined$1;
            anonymousClass1.L$0 = interfaceC0995Vm2;
            anonymousClass1.label = 1;
            Object objMo13invoke = interfaceC0526Fp.mo13invoke((PageEvent) obj, anonymousClass1);
            if (objMo13invoke == objD) {
                return objD;
            }
            obj2 = objMo13invoke;
            interfaceC0995Vm = interfaceC0995Vm2;
            anonymousClass1.L$0 = null;
            anonymousClass1.label = 2;
            if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                return objD;
            }
            return FW.a;
        }

        public final Object emit$$forInline(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AbstractC0703Ks.c(4);
            new AnonymousClass1(interfaceC0793Of);
            AbstractC0703Ks.c(5);
            InterfaceC0995Vm interfaceC0995Vm = this.$this_unsafeFlow;
            Object objMo13invoke = this.$transform$inlined$1.mo13invoke((PageEvent) obj, interfaceC0793Of);
            AbstractC0703Ks.c(0);
            interfaceC0995Vm.emit(objMo13invoke, interfaceC0793Of);
            AbstractC0703Ks.c(1);
            return FW.a;
        }
    }

    public PagingDataTransforms$transform$$inlined$map$1(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        this.$this_unsafeTransform$inlined = interfaceC0939Tm;
        this.$transform$inlined = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(interfaceC0995Vm, this.$transform$inlined), interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public Object collect$$forInline(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        AbstractC0703Ks.c(4);
        new AbstractC0819Pf(interfaceC0793Of) { // from class: androidx.paging.PagingDataTransforms$transform$$inlined$map$1.1
            int label;
            /* synthetic */ Object result;

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return PagingDataTransforms$transform$$inlined$map$1.this.collect(null, this);
            }
        };
        AbstractC0703Ks.c(5);
        InterfaceC0939Tm interfaceC0939Tm = this.$this_unsafeTransform$inlined;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC0995Vm, this.$transform$inlined);
        AbstractC0703Ks.c(0);
        interfaceC0939Tm.collect(anonymousClass2, interfaceC0793Of);
        AbstractC0703Ks.c(1);
        return FW.a;
    }
}
