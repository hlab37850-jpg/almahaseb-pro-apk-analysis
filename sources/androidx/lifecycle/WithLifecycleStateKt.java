package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2399hx;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.C1172Zk;
import defpackage.C4374ya;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
public final class WithLifecycleStateKt {

    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$block = interfaceC3588op;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
        @Override // defpackage.InterfaceC3588op
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z, AbstractC1040Xf abstractC1040Xf, final InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        final ?? r1 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Object objA;
                AbstractC4492zt.h(lifecycleOwner, DublinCoreProperties.SOURCE);
                AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
                if (event != Lifecycle.Event.Companion.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        InterfaceC4293xa interfaceC4293xa = c4374ya;
                        KL.a aVar = KL.a;
                        interfaceC4293xa.resumeWith(KL.a(LL.a(new LifecycleDestroyedException())));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                InterfaceC4293xa interfaceC4293xa2 = c4374ya;
                InterfaceC3588op interfaceC3588op2 = interfaceC3588op;
                try {
                    KL.a aVar2 = KL.a;
                    objA = KL.a(interfaceC3588op2.invoke());
                } catch (Throwable th) {
                    KL.a aVar3 = KL.a;
                    objA = KL.a(LL.a(th));
                }
                interfaceC4293xa2.resumeWith(objA);
            }
        };
        if (z) {
            abstractC1040Xf.dispatch(C1172Zk.a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r1);
                }
            });
        } else {
            lifecycle.addObserver(r1);
        }
        c4374ya.e(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(abstractC1040Xf, lifecycle, r1));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC3588op.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC3588op.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC3588op.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC3588op.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            C0368Bj.c().I();
            AbstractC0703Ks.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC3588op.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C0368Bj.c().I();
        AbstractC0703Ks.c(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            C0368Bj.c().I();
            AbstractC0703Ks.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return interfaceC3588op.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return interfaceC3588op.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
        boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return interfaceC3588op.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            AbstractC2399hx abstractC2399hxI = C0368Bj.c().I();
            boolean zIsDispatchNeeded = abstractC2399hxI.isDispatchNeeded(interfaceC0793Of.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return interfaceC3588op.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC2399hxI, new AnonymousClass2(interfaceC3588op), interfaceC0793Of);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
