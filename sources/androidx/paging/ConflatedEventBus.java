package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.DC;
import defpackage.ER;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
public final class ConflatedEventBus<T> {
    private final InterfaceC0939Tm flow;
    private final DC state;

    /* JADX WARN: Illegal instructions before constructor call */
    public ConflatedEventBus() {
        AbstractC0419Di abstractC0419Di = null;
        this(abstractC0419Di, 1, abstractC0419Di);
    }

    public final InterfaceC0939Tm getFlow() {
        return this.flow;
    }

    public final void send(T t) {
        AbstractC4492zt.h(t, "data");
        DC dc = this.state;
        dc.setValue(new C2020dG(Integer.valueOf(((Number) ((C2020dG) dc.getValue()).c()).intValue() + 1), t));
    }

    public ConflatedEventBus(T t) {
        final DC dcA = ER.a(new C2020dG(Integer.MIN_VALUE, t));
        this.state = dcA;
        this.flow = new InterfaceC0939Tm() { // from class: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2", f = "ConflatedEventBus.kt", l = {225}, m = "emit")
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

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // defpackage.InterfaceC0995Vm
                public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                    AnonymousClass1 anonymousClass1;
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
                    if (i2 == 0) {
                        LL.b(obj2);
                        InterfaceC0995Vm interfaceC0995Vm = this.$this_unsafeFlow;
                        Object objE = ((C2020dG) obj).e();
                        if (objE != null) {
                            anonymousClass1.label = 1;
                            if (interfaceC0995Vm.emit(objE, anonymousClass1) == objD) {
                                return objD;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj2);
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = dcA.collect(new AnonymousClass2(interfaceC0995Vm), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        };
    }

    public /* synthetic */ ConflatedEventBus(Object obj, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : obj);
    }
}
