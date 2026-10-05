package androidx.core.transition;

import android.transition.Transition;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ InterfaceC3750qp $onCancel;
    final /* synthetic */ InterfaceC3750qp $onEnd;
    final /* synthetic */ InterfaceC3750qp $onPause;
    final /* synthetic */ InterfaceC3750qp $onResume;
    final /* synthetic */ InterfaceC3750qp $onStart;

    public TransitionKt$addListener$listener$1(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC3750qp interfaceC3750qp4, InterfaceC3750qp interfaceC3750qp5) {
        this.$onEnd = interfaceC3750qp;
        this.$onResume = interfaceC3750qp2;
        this.$onPause = interfaceC3750qp3;
        this.$onCancel = interfaceC3750qp4;
        this.$onStart = interfaceC3750qp5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        this.$onStart.invoke(transition);
    }
}
