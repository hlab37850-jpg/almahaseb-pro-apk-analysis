package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2399hx;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;
import defpackage.M8;
import defpackage.O8;
import defpackage.OJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {ShapeTypes.ACTION_BUTTON_BACK_PREVIOUS}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
            final /* synthetic */ InterfaceC0526Fp $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, InterfaceC2052dg interfaceC2052dg, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = interfaceC2052dg;
                this.$block = interfaceC0526Fp;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
            /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
            /* JADX WARN: Code duplicated, block: B:36:0x00cf  */
            /* JADX WARN: Code duplicated, block: B:39:0x00d9  */
            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                OJ oj;
                OJ oj2;
                InterfaceC1830bu interfaceC1830bu;
                LifecycleEventObserver lifecycleEventObserver;
                InterfaceC1830bu interfaceC1830bu2;
                LifecycleEventObserver lifecycleEventObserver2;
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    oj2 = (OJ) this.L$1;
                    oj = (OJ) this.L$0;
                    try {
                        LL.b(obj);
                        interfaceC1830bu2 = (InterfaceC1830bu) oj.a;
                        if (interfaceC1830bu2 != null) {
                            InterfaceC1830bu.a.a(interfaceC1830bu2, null, 1, null);
                        }
                        lifecycleEventObserver2 = (LifecycleEventObserver) oj2.a;
                        if (lifecycleEventObserver2 != null) {
                            this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
                        }
                        return FW.a;
                    } catch (Throwable th) {
                        th = th;
                        interfaceC1830bu = (InterfaceC1830bu) oj.a;
                        if (interfaceC1830bu != null) {
                            InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                        }
                        lifecycleEventObserver = (LifecycleEventObserver) oj2.a;
                        if (lifecycleEventObserver != null) {
                            this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                        }
                        throw th;
                    }
                }
                LL.b(obj);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    return FW.a;
                }
                final OJ oj3 = new OJ();
                OJ oj4 = new OJ();
                try {
                    Lifecycle.State state = this.$state;
                    Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                    final InterfaceC2052dg interfaceC2052dg = this.$$this$coroutineScope;
                    final InterfaceC0526Fp interfaceC0526Fp = this.$block;
                    this.L$0 = oj3;
                    this.L$1 = oj4;
                    this.L$2 = state;
                    this.L$3 = lifecycle;
                    this.L$4 = interfaceC2052dg;
                    this.L$5 = interfaceC0526Fp;
                    this.label = 1;
                    final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(this), 1);
                    c4374ya.A();
                    Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                    final Lifecycle.Event eventUpTo = companion.upTo(state);
                    final Lifecycle.Event eventDownFrom = companion.downFrom(state);
                    final GC gcB = IC.b(false, 1, null);
                    LifecycleEventObserver lifecycleEventObserver3 = new LifecycleEventObserver() { // from class: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1

                        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
                        @InterfaceC3252ki(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {ShapeTypes.ACTION_BUTTON_SOUND, 110}, m = "invokeSuspend")
                        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
                            final /* synthetic */ InterfaceC0526Fp $block;
                            final /* synthetic */ GC $mutex;
                            Object L$0;
                            Object L$1;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(GC gc, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
                                super(2, interfaceC0793Of);
                                this.$mutex = gc;
                                this.$block = interfaceC0526Fp;
                            }

                            @Override // defpackage.AbstractC2171f7
                            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                                return new AnonymousClass1(this.$mutex, this.$block, interfaceC0793Of);
                            }

                            @Override // defpackage.InterfaceC0526Fp
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                                return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                            }

                            @Override // defpackage.AbstractC2171f7
                            public final Object invokeSuspend(Object obj) throws Throwable {
                                GC gc;
                                InterfaceC0526Fp interfaceC0526Fp;
                                GC gc2;
                                Throwable th;
                                Object objD = AbstractC0378Bt.d();
                                int i = this.label;
                                try {
                                    if (i == 0) {
                                        LL.b(obj);
                                        gc = this.$mutex;
                                        interfaceC0526Fp = this.$block;
                                        this.L$0 = gc;
                                        this.L$1 = interfaceC0526Fp;
                                        this.label = 1;
                                        if (gc.c(null, this) == objD) {
                                            return objD;
                                        }
                                    } else {
                                        if (i != 1) {
                                            if (i != 2) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            gc2 = (GC) this.L$0;
                                            try {
                                                LL.b(obj);
                                                FW fw = FW.a;
                                                gc2.b(null);
                                                return FW.a;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                gc2.b(null);
                                                throw th;
                                            }
                                        }
                                        interfaceC0526Fp = (InterfaceC0526Fp) this.L$1;
                                        GC gc3 = (GC) this.L$0;
                                        LL.b(obj);
                                        gc = gc3;
                                    }
                                    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(interfaceC0526Fp, null);
                                    this.L$0 = gc;
                                    this.L$1 = null;
                                    this.label = 2;
                                    if (AbstractC2133eg.d(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == objD) {
                                        return objD;
                                    }
                                    gc2 = gc;
                                    FW fw2 = FW.a;
                                    gc2.b(null);
                                    return FW.a;
                                } catch (Throwable th3) {
                                    gc2 = gc;
                                    th = th3;
                                    gc2.b(null);
                                    throw th;
                                }
                            }
                        }

                        @Override // androidx.lifecycle.LifecycleEventObserver
                        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            AbstractC4492zt.h(lifecycleOwner, "<anonymous parameter 0>");
                            AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
                            if (event == eventUpTo) {
                                oj3.a = O8.d(interfaceC2052dg, null, null, new AnonymousClass1(gcB, interfaceC0526Fp, null), 3, null);
                                return;
                            }
                            if (event == eventDownFrom) {
                                InterfaceC1830bu interfaceC1830bu3 = (InterfaceC1830bu) oj3.a;
                                if (interfaceC1830bu3 != null) {
                                    InterfaceC1830bu.a.a(interfaceC1830bu3, null, 1, null);
                                }
                                oj3.a = null;
                            }
                            if (event == Lifecycle.Event.ON_DESTROY) {
                                InterfaceC4293xa interfaceC4293xa = c4374ya;
                                KL.a aVar = KL.a;
                                interfaceC4293xa.resumeWith(KL.a(FW.a));
                            }
                        }
                    };
                    oj4.a = lifecycleEventObserver3;
                    AbstractC4492zt.f(lifecycleEventObserver3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                    lifecycle.addObserver(lifecycleEventObserver3);
                    Object objX = c4374ya.x();
                    if (objX == AbstractC0378Bt.d()) {
                        AbstractC3416mi.c(this);
                    }
                    if (objX == objD) {
                        return objD;
                    }
                    oj = oj3;
                    oj2 = oj4;
                    interfaceC1830bu2 = (InterfaceC1830bu) oj.a;
                    if (interfaceC1830bu2 != null) {
                        InterfaceC1830bu.a.a(interfaceC1830bu2, null, 1, null);
                    }
                    lifecycleEventObserver2 = (LifecycleEventObserver) oj2.a;
                    if (lifecycleEventObserver2 != null) {
                        this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
                    }
                    return FW.a;
                } catch (Throwable th2) {
                    th = th2;
                    oj = oj3;
                    oj2 = oj4;
                    interfaceC1830bu = (InterfaceC1830bu) oj.a;
                    if (interfaceC1830bu != null) {
                        InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                    }
                    lifecycleEventObserver = (LifecycleEventObserver) oj2.a;
                    if (lifecycleEventObserver != null) {
                        this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                    }
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = interfaceC0526Fp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, interfaceC0793Of);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass3) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, interfaceC2052dg, this.$block, null);
                this.label = 1;
                if (M8.g(abstractC2399hxI, anonymousClass1, this) == objD) {
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

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return FW.a;
        }
        Object objD = AbstractC2133eg.d(new AnonymousClass3(lifecycle, state, interfaceC0526Fp, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, interfaceC0526Fp, interfaceC0793Of);
        return objRepeatOnLifecycle == AbstractC0378Bt.d() ? objRepeatOnLifecycle : FW.a;
    }
}
