package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.GC;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1", f = "PageFetcherSnapshot.kt", l = {232, 99}, m = "invokeSuspend")
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 extends XS implements InterfaceC0552Gp {
    final /* synthetic */ LoadType $loadType$inlined;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(InterfaceC0793Of interfaceC0793Of, PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        super(3, interfaceC0793Of);
        this.this$0 = pageFetcherSnapshot;
        this.$loadType$inlined = loadType;
    }

    public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, Integer num, InterfaceC0793Of interfaceC0793Of) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(interfaceC0793Of, this.this$0, this.$loadType$inlined);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$0 = interfaceC0995Vm;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$1 = num;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC0995Vm interfaceC0995Vm;
        final int iIntValue;
        PageFetcherSnapshotState.Holder holder;
        GC gc;
        InterfaceC0939Tm interfaceC0939TmU;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    iIntValue = this.I$0;
                    gc = (GC) this.L$2;
                    holder = (PageFetcherSnapshotState.Holder) this.L$1;
                    interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
                    LL.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
            LL.b(obj);
            interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
            iIntValue = ((Number) this.L$1).intValue();
            holder = this.this$0.stateHolder;
            gc = holder.lock;
            this.L$0 = interfaceC0995Vm;
            this.L$1 = holder;
            this.L$2 = gc;
            this.I$0 = iIntValue;
            this.label = 1;
            if (gc.c(null, this) == objD) {
                return objD;
            }
            PageFetcherSnapshotState pageFetcherSnapshotState = holder.state;
            LoadState loadState = pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(this.$loadType$inlined);
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
            if (AbstractC4492zt.d(loadState, companion.getComplete$paging_common())) {
                interfaceC0939TmU = AbstractC1047Xm.u(new GenerationalViewportHint[0]);
                gc.b(null);
            } else {
                if (!(pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(this.$loadType$inlined) instanceof LoadState.Error)) {
                    pageFetcherSnapshotState.getSourceLoadStates$paging_common().set(this.$loadType$inlined, companion.getIncomplete$paging_common());
                }
                FW fw = FW.a;
                gc.b(null);
                final InterfaceC0939Tm interfaceC0939TmK = AbstractC1047Xm.k(this.this$0.hintHandler.hintFor(this.$loadType$inlined), iIntValue == 0 ? 0 : 1);
                interfaceC0939TmU = new InterfaceC0939Tm() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1

                    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                        final /* synthetic */ int $generationId$inlined;
                        final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2$1, reason: invalid class name */
                        @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2", f = "PageFetcherSnapshot.kt", l = {223}, m = "emit")
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

                        public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, int i) {
                            this.$this_unsafeFlow = interfaceC0995Vm;
                            this.$generationId$inlined = i;
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
                                GenerationalViewportHint generationalViewportHint = new GenerationalViewportHint(this.$generationId$inlined, (ViewportHint) obj);
                                anonymousClass1.label = 1;
                                if (interfaceC0995Vm.emit(generationalViewportHint, anonymousClass1) == objD) {
                                    return objD;
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
                    public Object collect(InterfaceC0995Vm interfaceC0995Vm2, InterfaceC0793Of interfaceC0793Of) {
                        Object objCollect = interfaceC0939TmK.collect(new AnonymousClass2(interfaceC0995Vm2, iIntValue), interfaceC0793Of);
                        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
                    }
                };
            }
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (AbstractC1047Xm.m(interfaceC0995Vm, interfaceC0939TmU, this) == objD) {
                return objD;
            }
            return FW.a;
        } catch (Throwable th) {
            gc.b(null);
            throw th;
        }
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((InterfaceC0995Vm) obj, (Integer) obj2, (InterfaceC0793Of) obj3);
    }
}
