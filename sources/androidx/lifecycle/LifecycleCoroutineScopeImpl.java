package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC3511nu;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final InterfaceC0988Vf coroutineContext;
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = LifecycleCoroutineScopeImpl.this.new AnonymousClass1(interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                AbstractC3511nu.e(interfaceC2052dg.getCoroutineContext(), null, 1, null);
            }
            return FW.a;
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(lifecycle, "lifecycle");
        AbstractC4492zt.h(interfaceC0988Vf, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = interfaceC0988Vf;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            AbstractC3511nu.e(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, defpackage.InterfaceC2052dg
    public InterfaceC0988Vf getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AbstractC4492zt.h(lifecycleOwner, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            AbstractC3511nu.e(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        O8.d(this, C0368Bj.c().I(), null, new AnonymousClass1(null), 2, null);
    }
}
