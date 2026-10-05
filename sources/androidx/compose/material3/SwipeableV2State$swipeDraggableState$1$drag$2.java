package androidx.compose.material3;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2State$swipeDraggableState$1$drag$2", f = "SwipeableV2.kt", l = {188}, m = "invokeSuspend")
public final class SwipeableV2State$swipeDraggableState$1$drag$2 extends XS implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC0526Fp $block;
    int label;
    final /* synthetic */ SwipeableV2State$swipeDraggableState$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2State$swipeDraggableState$1$drag$2(InterfaceC0526Fp interfaceC0526Fp, SwipeableV2State$swipeDraggableState$1 swipeableV2State$swipeDraggableState$1, InterfaceC0793Of interfaceC0793Of) {
        super(1, interfaceC0793Of);
        this.$block = interfaceC0526Fp;
        this.this$0 = swipeableV2State$swipeDraggableState$1;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
        return new SwipeableV2State$swipeDraggableState$1$drag$2(this.$block, this.this$0, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
        return ((SwipeableV2State$swipeDraggableState$1$drag$2) create(interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            InterfaceC0526Fp interfaceC0526Fp = this.$block;
            SwipeableV2State$swipeDraggableState$1$dragScope$1 swipeableV2State$swipeDraggableState$1$dragScope$1 = this.this$0.dragScope;
            this.label = 1;
            if (interfaceC0526Fp.mo13invoke(swipeableV2State$swipeDraggableState$1$dragScope$1, this) == objD) {
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
