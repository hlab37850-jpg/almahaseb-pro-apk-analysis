package androidx.compose.ui.platform;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.CR;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.O8;
import defpackage.OJ;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {394}, m = "invokeSuspend")
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt.AnonymousClass2 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ OJ $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(OJ oj, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt.AnonymousClass2 anonymousClass2, View view, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$systemDurationScaleSettingConsumer = oj;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = anonymousClass2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, interfaceC0793Of);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x0088  */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC1830bu interfaceC1830bu;
        InterfaceC1830bu interfaceC1830buD;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC1830bu = (InterfaceC1830bu) this.L$0;
            try {
                LL.b(obj);
                if (interfaceC1830bu != null) {
                    InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                }
                this.$source.getLifecycle().removeObserver(this.$self);
                return FW.a;
            } catch (Throwable th) {
                th = th;
                if (interfaceC1830bu != null) {
                    InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                }
                this.$source.getLifecycle().removeObserver(this.$self);
                throw th;
            }
        }
        LL.b(obj);
        InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
        try {
            MotionDurationScaleImpl motionDurationScaleImpl = (MotionDurationScaleImpl) this.$systemDurationScaleSettingConsumer.a;
            if (motionDurationScaleImpl != null) {
                Context applicationContext = this.$this_createLifecycleAwareWindowRecomposer.getContext().getApplicationContext();
                AbstractC4492zt.g(applicationContext, "context.applicationContext");
                CR animationScaleFlowFor = WindowRecomposer_androidKt.getAnimationScaleFlowFor(applicationContext);
                motionDurationScaleImpl.setScaleFactor(((Number) animationScaleFlowFor.getValue()).floatValue());
                interfaceC1830buD = O8.d(interfaceC2052dg, null, null, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1(animationScaleFlowFor, motionDurationScaleImpl, null), 3, null);
            } else {
                interfaceC1830buD = null;
            }
            try {
                Recomposer recomposer = this.$recomposer;
                this.L$0 = interfaceC1830buD;
                this.label = 1;
                if (recomposer.runRecomposeAndApplyChanges(this) == objD) {
                    return objD;
                }
                interfaceC1830bu = interfaceC1830buD;
                if (interfaceC1830bu != null) {
                    InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                }
                this.$source.getLifecycle().removeObserver(this.$self);
                return FW.a;
            } catch (Throwable th2) {
                interfaceC1830bu = interfaceC1830buD;
                th = th2;
                if (interfaceC1830bu != null) {
                    InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                }
                this.$source.getLifecycle().removeObserver(this.$self);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            interfaceC1830bu = null;
        }
    }
}
