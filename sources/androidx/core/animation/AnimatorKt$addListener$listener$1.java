package androidx.core.animation;

import android.animation.Animator;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ InterfaceC3750qp $onCancel;
    final /* synthetic */ InterfaceC3750qp $onEnd;
    final /* synthetic */ InterfaceC3750qp $onRepeat;
    final /* synthetic */ InterfaceC3750qp $onStart;

    public AnimatorKt$addListener$listener$1(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC3750qp interfaceC3750qp4) {
        this.$onRepeat = interfaceC3750qp;
        this.$onEnd = interfaceC3750qp2;
        this.$onCancel = interfaceC3750qp3;
        this.$onStart = interfaceC3750qp4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.$onStart.invoke(animator);
    }
}
