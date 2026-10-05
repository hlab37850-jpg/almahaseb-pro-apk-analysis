package androidx.paging;

import androidx.annotation.CheckResult;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC1173Zl;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingDataTransforms {

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertFooterItem$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$insertFooterItem$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ T $item;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(T t, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$item = t;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(T t, T t2, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$item, interfaceC0793Of);
            anonymousClass1.L$0 = t2;
            return anonymousClass1.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            if (this.L$0 == null) {
                return this.$item;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertHeaderItem$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$insertHeaderItem$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
    public static final class C17171 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ T $item;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17171(T t, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$item = t;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(T t, T t2, InterfaceC0793Of interfaceC0793Of) {
            C17171 c17171 = new C17171(this.$item, interfaceC0793Of);
            c17171.L$0 = t;
            return c17171.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            if (this.L$0 == null) {
                return this.$item;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$insertSeparators$1", f = "PagingDataTransforms.kt", l = {263}, m = "invokeSuspend")
    public static final class C17181 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ Executor $executor;
        final /* synthetic */ InterfaceC0526Fp $generator;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$insertSeparators$1$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
        public static final class C01561 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ T $after;
            final /* synthetic */ T $before;
            final /* synthetic */ InterfaceC0526Fp $generator;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01561(InterfaceC0526Fp interfaceC0526Fp, T t, T t2, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$generator = interfaceC0526Fp;
                this.$before = t;
                this.$after = t2;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C01561(this.$generator, this.$before, this.$after, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01561) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0378Bt.d();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                return this.$generator.mo13invoke(this.$before, this.$after);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17181(Executor executor, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$executor = executor;
            this.$generator = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(T t, T t2, InterfaceC0793Of interfaceC0793Of) {
            C17181 c17181 = new C17181(this.$executor, this.$generator, interfaceC0793Of);
            c17181.L$0 = t;
            c17181.L$1 = t2;
            return c17181.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                Object obj2 = this.L$0;
                Object obj3 = this.L$1;
                AbstractC1040Xf abstractC1040XfA = AbstractC1173Zl.a(this.$executor);
                C01561 c01561 = new C01561(this.$generator, obj2, obj3, null);
                this.L$0 = null;
                this.label = 1;
                obj = M8.g(abstractC1040XfA, c01561, this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return obj;
        }
    }

    @CheckResult
    public static final /* synthetic */ PagingData filter(PagingData pagingData, final InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "predicate");
        final InterfaceC0939Tm flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData(new InterfaceC0939Tm() { // from class: androidx.paging.PagingDataTransforms$filter$$inlined$transform$1

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0526Fp $predicate$inlined;
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$filter$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
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
                    this.$predicate$inlined = interfaceC0526Fp;
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
                    InterfaceC0526Fp interfaceC0526Fp = this.$predicate$inlined;
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object objFilter = ((PageEvent) obj).filter(interfaceC0526Fp, anonymousClass1);
                    if (objFilter == objD) {
                        return objD;
                    }
                    obj2 = objFilter;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(interfaceC0995Vm, interfaceC0526Fp), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    @CheckResult
    public static final /* synthetic */ PagingData flatMap(PagingData pagingData, final InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "transform");
        final InterfaceC0939Tm flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData(new InterfaceC0939Tm() { // from class: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;
                final /* synthetic */ InterfaceC0526Fp $transform$inlined;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
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
                    this.$transform$inlined = interfaceC0526Fp;
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
                    InterfaceC0526Fp interfaceC0526Fp = this.$transform$inlined;
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object objFlatMap = ((PageEvent) obj).flatMap(interfaceC0526Fp, anonymousClass1);
                    if (objFlatMap == objD) {
                        return objD;
                    }
                    obj2 = objFlatMap;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(interfaceC0995Vm, interfaceC0526Fp), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    @CheckResult
    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, T t) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(t, "item");
        return insertFooterItem$default(pagingData, null, t, 1, null);
    }

    public static /* synthetic */ PagingData insertFooterItem$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return insertFooterItem(pagingData, terminalSeparatorType, obj);
    }

    @CheckResult
    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> pagingData, T t) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(t, "item");
        return insertHeaderItem$default(pagingData, null, t, 1, null);
    }

    public static /* synthetic */ PagingData insertHeaderItem$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return insertHeaderItem(pagingData, terminalSeparatorType, obj);
    }

    @CheckResult
    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> pagingData, Executor executor, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(executor, "executor");
        AbstractC4492zt.h(interfaceC0526Fp, "generator");
        return insertSeparators$default(pagingData, null, executor, interfaceC0526Fp, 1, null);
    }

    public static /* synthetic */ PagingData insertSeparators$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return insertSeparators(pagingData, terminalSeparatorType, interfaceC0552Gp);
    }

    @CheckResult
    public static final /* synthetic */ PagingData map(PagingData pagingData, final InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "transform");
        final InterfaceC0939Tm flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData(new InterfaceC0939Tm() { // from class: androidx.paging.PagingDataTransforms$map$$inlined$transform$1

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;
                final /* synthetic */ InterfaceC0526Fp $transform$inlined;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
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
                    this.$transform$inlined = interfaceC0526Fp;
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
                    InterfaceC0526Fp interfaceC0526Fp = this.$transform$inlined;
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object map = ((PageEvent) obj).map(interfaceC0526Fp, anonymousClass1);
                    if (map == objD) {
                        return objD;
                    }
                    obj2 = map;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(interfaceC0995Vm, interfaceC0526Fp), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    private static final <T, R> PagingData<R> transform(PagingData<T> pagingData, InterfaceC0526Fp interfaceC0526Fp) {
        return new PagingData<>(new PagingDataTransforms$transform$$inlined$map$1(pagingData.getFlow$paging_common(), interfaceC0526Fp), pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    @CheckResult
    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T t) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        AbstractC4492zt.h(t, "item");
        return insertSeparators(pagingData, terminalSeparatorType, new AnonymousClass1(t, null));
    }

    @CheckResult
    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T t) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        AbstractC4492zt.h(t, "item");
        return insertSeparators(pagingData, terminalSeparatorType, new C17171(t, null));
    }

    @CheckResult
    public static final /* synthetic */ PagingData insertSeparators(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        AbstractC4492zt.h(interfaceC0552Gp, "generator");
        return new PagingData(SeparatorsKt.insertEventSeparators(pagingData.getFlow$paging_common(), terminalSeparatorType, interfaceC0552Gp), pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    public static /* synthetic */ PagingData insertSeparators$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Executor executor, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return insertSeparators(pagingData, terminalSeparatorType, executor, interfaceC0526Fp);
    }

    @CheckResult
    public static final <T> PagingData<T> filter(PagingData<T> pagingData, final Executor executor, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(executor, "executor");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        final InterfaceC0939Tm flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData<>(new InterfaceC0939Tm() { // from class: androidx.paging.PagingDataTransforms$filter$$inlined$transform$2

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ Executor $executor$inlined;
                final /* synthetic */ InterfaceC3750qp $predicate$inlined;
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$2$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$filter$$inlined$transform$2$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
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

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, Executor executor, InterfaceC3750qp interfaceC3750qp) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                    this.$executor$inlined = executor;
                    this.$predicate$inlined = interfaceC3750qp;
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
                    AbstractC1040Xf abstractC1040XfA = AbstractC1173Zl.a(this.$executor$inlined);
                    PagingDataTransforms$filter$2$1 pagingDataTransforms$filter$2$1 = new PagingDataTransforms$filter$2$1((PageEvent) obj, this.$predicate$inlined, null);
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object objG = M8.g(abstractC1040XfA, pagingDataTransforms$filter$2$1, anonymousClass1);
                    if (objG == objD) {
                        return objD;
                    }
                    obj2 = objG;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(interfaceC0995Vm, executor, interfaceC3750qp), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    @CheckResult
    public static final <T, R> PagingData<R> flatMap(PagingData<T> pagingData, final Executor executor, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(executor, "executor");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        final InterfaceC0939Tm flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData<>(new InterfaceC0939Tm() { // from class: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$2

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ Executor $executor$inlined;
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;
                final /* synthetic */ InterfaceC3750qp $transform$inlined;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$2$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$2$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
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

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, Executor executor, InterfaceC3750qp interfaceC3750qp) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                    this.$executor$inlined = executor;
                    this.$transform$inlined = interfaceC3750qp;
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
                    AbstractC1040Xf abstractC1040XfA = AbstractC1173Zl.a(this.$executor$inlined);
                    PagingDataTransforms$flatMap$2$1 pagingDataTransforms$flatMap$2$1 = new PagingDataTransforms$flatMap$2$1((PageEvent) obj, this.$transform$inlined, null);
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object objG = M8.g(abstractC1040XfA, pagingDataTransforms$flatMap$2$1, anonymousClass1);
                    if (objG == objD) {
                        return objD;
                    }
                    obj2 = objG;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(interfaceC0995Vm, executor, interfaceC3750qp), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    @CheckResult
    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, Executor executor, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        AbstractC4492zt.h(executor, "executor");
        AbstractC4492zt.h(interfaceC0526Fp, "generator");
        return insertSeparators(pagingData, terminalSeparatorType, new C17181(executor, interfaceC0526Fp, null));
    }

    @CheckResult
    public static final <T, R> PagingData<R> map(PagingData<T> pagingData, final Executor executor, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(executor, "executor");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        final InterfaceC0939Tm flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData<>(new InterfaceC0939Tm() { // from class: androidx.paging.PagingDataTransforms$map$$inlined$transform$2

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ Executor $executor$inlined;
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;
                final /* synthetic */ InterfaceC3750qp $transform$inlined;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
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

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, Executor executor, InterfaceC3750qp interfaceC3750qp) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                    this.$executor$inlined = executor;
                    this.$transform$inlined = interfaceC3750qp;
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
                    AbstractC1040Xf abstractC1040XfA = AbstractC1173Zl.a(this.$executor$inlined);
                    PagingDataTransforms$map$2$1 pagingDataTransforms$map$2$1 = new PagingDataTransforms$map$2$1((PageEvent) obj, this.$transform$inlined, null);
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object objG = M8.g(abstractC1040XfA, pagingDataTransforms$map$2$1, anonymousClass1);
                    if (objG == objD) {
                        return objD;
                    }
                    obj2 = objG;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(interfaceC0995Vm, executor, interfaceC3750qp), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }
}
