package androidx.compose.ui.input.pointer;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1043Xi;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1", f = "SuspendingPointerInputFilter.kt", l = {720, 721}, m = "invokeSuspend")
public final class SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(long j, SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(this.$timeMillis, this.this$0, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC4293xa interfaceC4293xa;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                LL.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            interfaceC4293xa = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.this$0).pointerAwaiter;
            if (interfaceC4293xa != null) {
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(LL.a(new PointerEventTimeoutCancellationException(this.$timeMillis))));
            }
            return FW.a;
        }
        LL.b(obj);
        long j = this.$timeMillis - 1;
        this.label = 1;
        if (AbstractC1043Xi.a(j, this) == objD) {
            return objD;
        }
        this.label = 2;
        if (AbstractC1043Xi.a(1L, this) == objD) {
            return objD;
        }
        interfaceC4293xa = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.this$0).pointerAwaiter;
        if (interfaceC4293xa != null) {
            KL.a aVar2 = KL.a;
            interfaceC4293xa.resumeWith(KL.a(LL.a(new PointerEventTimeoutCancellationException(this.$timeMillis))));
        }
        return FW.a;
    }
}
