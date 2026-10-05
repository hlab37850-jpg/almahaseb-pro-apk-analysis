package androidx.compose.material;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableState$draggableState$1$drag$2", f = "AnchoredDraggable.kt", l = {150}, m = "invokeSuspend")
public final class AnchoredDraggableState$draggableState$1$drag$2 extends XS implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0526Fp $block;
    int label;
    final /* synthetic */ AnchoredDraggableState$draggableState$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$draggableState$1$drag$2(AnchoredDraggableState$draggableState$1 anchoredDraggableState$draggableState$1, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        super(3, interfaceC0793Of);
        this.this$0 = anchoredDraggableState$draggableState$1;
        this.$block = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public final Object invoke(AnchoredDragScope anchoredDragScope, Map<T, Float> map, InterfaceC0793Of interfaceC0793Of) {
        return new AnchoredDraggableState$draggableState$1$drag$2(this.this$0, this.$block, interfaceC0793Of).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            AnchoredDraggableState$draggableState$1$dragScope$1 anchoredDraggableState$draggableState$1$dragScope$1 = this.this$0.dragScope;
            InterfaceC0526Fp interfaceC0526Fp = this.$block;
            this.label = 1;
            if (interfaceC0526Fp.mo13invoke(anchoredDraggableState$draggableState$1$dragScope$1, this) == objD) {
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
