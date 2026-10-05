package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.RoomTrackingLiveData;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1864cI;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2399hx;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.C1172Zk;
import defpackage.C3343lq;
import defpackage.CR;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC2103eI;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.M8;
import defpackage.O8;
import defpackage.XS;
import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowLiveDataConversions {

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {110, 114}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        public static final class C01441 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01441(LiveData<T> liveData, Observer<T> observer, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C01441(this.$this_asFlow, this.$observer, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01441) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0378Bt.d();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return FW.a;
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;

            /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
            public static final class C01451 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ Observer<T> $observer;
                final /* synthetic */ LiveData<T> $this_asFlow;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01451(LiveData<T> liveData, Observer<T> observer, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$this_asFlow = liveData;
                    this.$observer = observer;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C01451(this.$this_asFlow, this.$observer, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C01451) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$this_asFlow.removeObserver(this.$observer);
                    return FW.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LiveData<T> liveData, Observer<T> observer) {
                super(0);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // defpackage.InterfaceC3588op
            public /* bridge */ /* synthetic */ Object invoke() {
                m5422invoke();
                return FW.a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m5422invoke() {
                O8.d(C3343lq.a, C0368Bj.c().I(), null, new C01451(this.$this_asFlow, this.$observer, null), 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_asFlow = liveData;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2103eI, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Observer observer;
            InterfaceC2103eI interfaceC2103eI;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    observer = (Observer) this.L$1;
                    interfaceC2103eI = (InterfaceC2103eI) this.L$0;
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
            final InterfaceC2103eI interfaceC2103eI2 = (InterfaceC2103eI) this.L$0;
            observer = new Observer() { // from class: androidx.lifecycle.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    interfaceC2103eI2.mo0trySendJP2dKIU(obj2);
                }
            };
            AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
            C01441 c01441 = new C01441(this.$this_asFlow, observer, null);
            this.L$0 = interfaceC2103eI2;
            this.L$1 = observer;
            this.label = 1;
            if (M8.g(abstractC2399hxI, c01441, this) == objD) {
                return objD;
            }
            interfaceC2103eI = interfaceC2103eI2;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, observer);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (AbstractC1864cI.a(interfaceC2103eI, anonymousClass2, this) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {80}, m = "invokeSuspend")
    public static final class C16881 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0939Tm $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16881(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_asLiveData = interfaceC0939Tm;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16881 c16881 = new C16881(this.$this_asLiveData, interfaceC0793Of);
            c16881.L$0 = obj;
            return c16881;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(LiveDataScope<T> liveDataScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C16881) create(liveDataScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                InterfaceC0939Tm interfaceC0939Tm = this.$this_asLiveData;
                InterfaceC0995Vm interfaceC0995Vm = new InterfaceC0995Vm() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // defpackage.InterfaceC0995Vm
                    public final Object emit(T t, InterfaceC0793Of interfaceC0793Of) {
                        Object objEmit = liveDataScope.emit(t, interfaceC0793Of);
                        return objEmit == AbstractC0378Bt.d() ? objEmit : FW.a;
                    }
                };
                this.label = 1;
                if (interfaceC0939Tm.collect(interfaceC0995Vm, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    public static final <T> InterfaceC0939Tm asFlow(LiveData<T> liveData) {
        AbstractC4492zt.h(liveData, "<this>");
        return AbstractC1047Xm.h(AbstractC1047Xm.e(new AnonymousClass1(liveData, null)));
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC0939Tm interfaceC0939Tm) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        return asLiveData$default(interfaceC0939Tm, (InterfaceC0988Vf) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        if ((i & 2) != 0) {
            j = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(interfaceC0939Tm, interfaceC0988Vf, j);
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        return asLiveData$default(interfaceC0939Tm, interfaceC0988Vf, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, long j) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        RoomTrackingLiveData roomTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(interfaceC0988Vf, j, new C16881(interfaceC0939Tm, null));
        if (interfaceC0939Tm instanceof CR) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomTrackingLiveData.setValue(((CR) interfaceC0939Tm).getValue());
            } else {
                roomTrackingLiveData.postValue(((CR) interfaceC0939Tm).getValue());
            }
        }
        return roomTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        return asLiveData(interfaceC0939Tm, interfaceC0988Vf, duration);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, Duration duration) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        AbstractC4492zt.h(duration, "timeout");
        return asLiveData(interfaceC0939Tm, interfaceC0988Vf, Api26Impl.INSTANCE.toMillis(duration));
    }
}
